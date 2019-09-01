package com.think123.yr_online.dao.process;

import com.think123.yr_online.dto.ProductDto;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-15 19:12
 */
public interface PkgDao {



     List<ProductDto> findProductListOnsStatusOn35(ProductDto dto);

    void modifyProductStatus(ProductDto dto);

    void modifyProcessStatus(ProductDto dto);
}
