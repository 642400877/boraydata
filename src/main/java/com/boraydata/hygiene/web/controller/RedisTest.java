package com.boraydata.hygiene.web.controller;

import com.boraydata.hygiene.sal.client.Isaaclin;
import com.boraydata.hygiene.sal.client.Ncov;
import com.boraydata.hygiene.web.request.OtherRequest;
import com.boraydata.hygiene.web.result.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Isaaclin isaaclin;

    @Autowired
    private Ncov ncov;

    @RequestMapping("redis")
    public void redis(@RequestBody OtherRequest otherRequest) {
        log.info(redisTemplate.opsForValue().get("1"));
    }

    @RequestMapping("http")
    public MyResult http() {
        return MyResult.success(isaaclin.overallApi());
    }

    @RequestMapping("ncov")
    public MyResult ncov() {
        return MyResult.success(ncov.ncov());
    }
}
