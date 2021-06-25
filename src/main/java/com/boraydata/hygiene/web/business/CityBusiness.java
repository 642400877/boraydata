package com.boraydata.hygiene.web.business;

import com.alibaba.fastjson.JSONObject;
import com.boraydata.hygiene.biz.CityService;
import com.boraydata.hygiene.common.type.OrganizationType;
import com.boraydata.hygiene.dal.entity.FireControlEntity;
import com.boraydata.hygiene.web.request.AreaMapRequest;
import com.boraydata.hygiene.web.request.AreaRequest;
import com.boraydata.hygiene.web.request.FireControlRequest;
import com.boraydata.hygiene.web.response.FireControlAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

@Service
public class CityBusiness {

    private static final String area = "中关村街道,万寿路街道,永定路街道,羊坊店街道,甘家口街道,八里庄街道,紫竹院街道,北下关街道,北太平庄街道,学院路街道,海淀街道,青龙桥街道,清华园街道,燕园街道,香山街道,清河街道,花园路街道,西三旗街道,马连洼街道,田村路街道,上地街道,万柳街道,东升街道,曙光街道,温泉街道,四季青街道,西北旺街道,苏家坨街道,上庄街道";

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

    public Object areaMapData(AreaRequest areaRequest) throws IOException {
        List<AreaMapRequest> areaMapRequestList = new ArrayList<>();
        Random random = new Random();
        List<String> areaList = Arrays.asList(area.split(","));
        ClassPathResource resource = new ClassPathResource("map.json");
        InputStream file = resource.getInputStream();
        BufferedReader reader = null;
        StringBuilder sbf = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            ArrayList arrayList = JSONObject.parseObject(String.valueOf(JSONObject.parseObject(sbf.toString(), HashMap.class).get("features")), ArrayList.class);
            arrayList.forEach(item -> {
                HashMap oneAreaMap = JSONObject.parseObject(String.valueOf(item), HashMap.class);
                String placeName = String.valueOf(JSONObject.parseObject(String.valueOf(oneAreaMap.get("properties")), HashMap.class).get("name"));
                if (areaList.contains(placeName)) {
                    AreaMapRequest areaMapRequest = new AreaMapRequest();
                    areaMapRequest.setStreetName(placeName);
                    areaMapRequest.setPopulation(random.nextInt(50000) + 50000);
                    List<List<Double>> path = JSONObject.parseObject(String.valueOf(JSONObject.parseObject(String.valueOf(oneAreaMap.get("geometry")), HashMap.class).get("coordinates")), ArrayList.class);
                    areaMapRequest.setPath(new ArrayList<>());
                    if (!CollectionUtils.isEmpty(path)) {
                        for (int i = 0; i< path.size(); i++) {
                            areaMapRequest.getPath().add(path.get(i));
                        }
                    }
                    areaMapRequestList.add(areaMapRequest);
                }
            });
            return areaMapRequestList;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }
}
