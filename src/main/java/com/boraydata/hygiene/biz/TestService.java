package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.biz.dto.TestDto;
import com.boraydata.hygiene.dal.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TestService {

    List<TestEntity> listTestInfo();

}
