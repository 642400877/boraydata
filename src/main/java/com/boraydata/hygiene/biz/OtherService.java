package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.ReasonEntity;
import com.boraydata.hygiene.web.request.OtherRequest;

import java.util.List;

public interface OtherService {

    ReasonEntity findReason(OtherRequest otherRequest);

    List<String> findVideo();

}
