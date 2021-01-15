package com.boraydata.hygiene.biz;

import com.boraydata.hygiene.dal.entity.PublicEntity;
import com.boraydata.hygiene.web.request.PublicRequest;

import java.util.List;

public interface PublicService {

    List<PublicEntity> listPublicInfo(PublicRequest publicRequest);

}
