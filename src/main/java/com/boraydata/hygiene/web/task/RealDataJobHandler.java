package com.boraydata.hygiene.web.task;

import com.boraydata.hygiene.biz.RealDataService;
import com.boraydata.hygiene.sal.client.Isaaclin;
import com.boraydata.hygiene.sal.entity.AreaEntity;
import com.boraydata.hygiene.web.request.AreaRequest;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class RealDataJobHandler {

    @Autowired
    Isaaclin isaaclin;

    @Autowired
    RealDataService realDataService;

    @XxlJob("realDataJobHandler")
    public void realDataJobHandler() throws Exception {
        AreaRequest areaRequest = new AreaRequest();
        areaRequest.setProvince("北京市");
        AreaEntity areaEntity = isaaclin.areaApi(areaRequest);
        areaEntity.getResults().get(0).getCities().forEach(item -> {
            if ("海淀区".equals(item.getCityName())) {
                item.setUpdateTime(new Date(areaEntity.getResults().get(0).getUpdateTime()));
                realDataService.addRealData(item);
            }
        });
    }

}
