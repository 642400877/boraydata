package com.boraydata.hygiene.sal.client;

import com.alibaba.fastjson.JSONObject;
import com.boraydata.hygiene.common.http.HttpUtil;
import com.boraydata.hygiene.sal.entity.AreaEntity;
import com.boraydata.hygiene.sal.entity.OverallEntity;
import com.boraydata.hygiene.web.request.AreaRequest;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Isaaclin {

    private final static String mainUrl = "https://lab.isaaclin.cn";

    private final static String overallUrl = "/nCoV/api/overall";

    private final static String areaUrl = "/nCoV/api/area";

    public OverallEntity overallApi() {
        OverallEntity overallEntity = JSONObject.parseObject(HttpUtil.httpGetConnection(mainUrl + overallUrl), OverallEntity.class);
        return overallEntity;
    }

    public AreaEntity areaApi(AreaRequest areaRequest) throws UnsupportedEncodingException, URISyntaxException {
        Map<String, String> map = new HashMap<>();
        map.put("province", areaRequest.getProvince());
        AreaEntity areaEntity = JSONObject.parseObject(HttpUtil.httpGetConnection(mainUrl + areaUrl, map), AreaEntity.class);
        return areaEntity;
    }

    public List<AreaEntity> areaApiList(AreaRequest areaRequest){
        List<AreaEntity> areaEntityList = new ArrayList<>();
        areaRequest.getProvinceList().forEach(item -> {
            Map<String, String> map = new HashMap<>();
            map.put("province", item);
            AreaEntity areaEntity = null;
            try {
                areaEntity = JSONObject.parseObject(HttpUtil.httpGetConnection(mainUrl + areaUrl, map), AreaEntity.class);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            areaEntityList.add(areaEntity);
        });
        return areaEntityList;
    }
}
