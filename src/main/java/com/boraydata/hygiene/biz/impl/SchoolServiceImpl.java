package com.boraydata.hygiene.biz.impl;

import com.boraydata.hygiene.biz.SchoolService;
import com.boraydata.hygiene.dal.entity.SchoolEntity;
import com.boraydata.hygiene.dal.entity.SchoolInfoEntity;
import com.boraydata.hygiene.dal.mapper.SchoolMapper;
import com.boraydata.hygiene.dal.query.SchoolQuery;
import com.boraydata.hygiene.web.request.SchoolRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public SchoolEntity school(SchoolRequest schoolRequest) {
        SchoolQuery schoolQuery = new SchoolQuery();
        schoolQuery.setSchoolName(schoolRequest.getSchoolName());
        return schoolMapper.findSchoolBySchoolName(schoolQuery);
    }

    @Override
    public SchoolInfoEntity schoolInfo(SchoolRequest schoolRequest) {
        SchoolInfoEntity schoolInfoEntity = new SchoolInfoEntity();
        schoolInfoEntity.setSchoolPosition(schoolRequest.getSchoolPosition());
        schoolInfoEntity.setSchoolName(schoolRequest.getSchoolName());
        Date date = null;
        if (schoolRequest.getDataTime() != null && schoolRequest.getDataTime() != 0) {
            schoolInfoEntity.setDataTime(schoolRequest.getDataTime());
            date = new Date(schoolRequest.getDataTime());
        } else {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        if (hour < 7 || week == 1 || week == 7) {
            schoolInfoEntity.setStudentNumber(0);
            schoolInfoEntity.setTeacherNumber(0);
            schoolInfoEntity.setSecurityNumber(0);
        } else if (hour == 7){
            schoolInfoEntity.setStudentNumber(8000 * minute / 60);
            schoolInfoEntity.setTeacherNumber(500 *  minute / 60);
            schoolInfoEntity.setSecurityNumber(30 * minute / 60);
        } else {
            Random random = new Random();
            schoolInfoEntity.setStudentNumber(8000 + random.nextInt(500));
            schoolInfoEntity.setTeacherNumber(500 + random.nextInt(20));
            schoolInfoEntity.setSecurityNumber(30 + random.nextInt(5));
        }
        schoolInfoEntity.setDataTime(date.getTime());
        return schoolInfoEntity;
    }
}
