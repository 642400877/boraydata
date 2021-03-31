package com.boraydata.hygiene.sal.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boraydata.hygiene.common.http.HttpUtil;
import com.boraydata.hygiene.sal.entity.NcovAreaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class Ncov {

    private final static String url = "https://ncov.deepeye.tech/data/data/pie/%E6%B5%B7%E6%B7%80%E5%8C%BA.json";

    public NcovAreaEntity ncov() {
//        NcovAreaEntity ncovAreaEntity = JSONObject.parseObject(HttpUtil.httpGetConnection(url), NcovAreaEntity.class);
//        return ncovAreaEntity;
        String jsonStr = HttpUtil.httpGetConnection(url);
        JSONObject obj = JSON.parseObject(jsonStr);
        NcovAreaEntity ncovAreaEntity = new NcovAreaEntity();
        Arrays.asList(obj.getString("areas"));
//        ncovAreaEntity.setArea();
        return ncovAreaEntity;

    }
}
