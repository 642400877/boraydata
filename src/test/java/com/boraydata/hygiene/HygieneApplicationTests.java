package com.boraydata.hygiene;

import com.boraydata.hygiene.biz.RealDataService;
import com.boraydata.hygiene.biz.impl.RealDataServiceImpl;
import com.boraydata.hygiene.sal.client.Isaaclin;
import com.boraydata.hygiene.sal.entity.AreaEntity;
import com.boraydata.hygiene.web.request.AreaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@SpringBootTest
class HygieneApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test2() throws UnsupportedEncodingException, URISyntaxException {
        Isaaclin isaaclin = new Isaaclin();
        RealDataService realDataService = new RealDataServiceImpl();

        AreaRequest areaRequest = new AreaRequest();
        areaRequest.setProvince("北京市");
        AreaEntity areaEntity = isaaclin.areaApi(areaRequest);
        areaEntity.getResults().get(0).getCities().stream().forEach(item -> {
            if ("海淀区".equals(item.getCityName())) {
                realDataService.addRealData(item);
            }
        });
    }

}
