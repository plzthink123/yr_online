package com.think123.yr_online.service.process.pkg;

import com.think123.yr_online.dto.ProductDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-25 10:16
 */
public interface PkgService {
    Map<String, Object> getPkgPage(ProductDto dto);

    void modifyProductStatus(ProductDto dto);

    void modifyProcessStatus(ProductDto dto);
}
