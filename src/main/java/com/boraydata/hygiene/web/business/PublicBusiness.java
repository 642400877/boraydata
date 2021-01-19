package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.PublicService;
import com.boraydata.hygiene.biz.impl.PublicServiceImpl;
import com.boraydata.hygiene.dal.entity.PublicEntity;
import com.boraydata.hygiene.web.request.PublicRequest;
import com.boraydata.hygiene.web.response.ConsultationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicBusiness {

    @Autowired
    PublicService publicService;

    public List<PublicEntity> listPublicInfo(PublicRequest publicRequest) {
        return publicService.listPublicInfo(publicRequest);
    }

    public List<PublicEntity> listConsultationInfo(PublicRequest publicRequest) {
        ConsultationResponse consultationResponse = new ConsultationResponse();

        return publicService.listPublicInfo(publicRequest);
    }

}
