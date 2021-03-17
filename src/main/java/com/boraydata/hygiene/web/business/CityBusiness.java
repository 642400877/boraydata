package com.boraydata.hygiene.web.business;

import com.boraydata.hygiene.biz.CityService;
import com.boraydata.hygiene.common.type.OrganizationType;
import com.boraydata.hygiene.dal.entity.FireControlEntity;
import com.boraydata.hygiene.web.request.FireControlRequest;
import com.boraydata.hygiene.web.response.FireControlAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CityBusiness {

    @Autowired
    CityService cityService;

    public FireControlEntity fireControlInfo(FireControlRequest fireControlRequest) {
        return cityService.fireControlInfo(fireControlRequest);
    }

    public List<FireControlAllResponse> fireControlInfoAll() {
        List<FireControlEntity> fireControlEntityList = cityService.fireControlInfoAll();
        List<FireControlAllResponse> fireControlAllResponseList = new ArrayList<>();
        Random random = new Random();
        fireControlEntityList.stream().forEach(item -> {
            FireControlAllResponse fireControlAllResponse = new FireControlAllResponse();
            fireControlAllResponse.setFireControlName(item.getFireControlName());
            fireControlAllResponse.setFireControlPosition(item.getFireControlPosition());
            fireControlAllResponse.setResponseTime(random.nextInt(6) + 10);
            fireControlAllResponse.setStatus(OrganizationType.getValueByCode(random.nextInt(2)));
            fireControlAllResponseList.add(fireControlAllResponse);
        });
        return fireControlAllResponseList;
    }
}
