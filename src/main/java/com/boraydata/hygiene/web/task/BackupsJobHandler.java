package com.boraydata.hygiene.web.task;

import com.boraydata.hygiene.dal.mapper.CommonMapper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BackupsJobHandler {

    @Autowired
    CommonMapper commonMapper;

    @XxlJob("populationBackupsJobHandler")
    public void populationBackupsJobHandler() {
        log.info("populationBackupsJobHandler start");
        commonMapper.dropPopulationTable();
        commonMapper.createPopulationTable();
        log.info("populationBackupsJobHandler end");
    }

    @XxlJob("economicsBackupsJobHandler")
    public void economicsBackupsJobHandler() {
        log.info("economicsBackupsJobHandler start");
        commonMapper.dropEconomicsTable();
        commonMapper.createEconomicsTable();
        log.info("economicsBackupsJobHandler end");
    }
}
