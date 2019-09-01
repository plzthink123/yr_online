package com.think123.yr_online.service.process.pkg.impl;

import com.github.pagehelper.PageInfo;
import com.think123.yr_online.dao.process.PkgDao;
import com.think123.yr_online.dto.ProductDto;
import com.think123.yr_online.service.process.pkg.PkgService;
import com.think123.yr_online.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-25 10:16
 */
@Service
public class PkgServiceImpl implements PkgService {
    @Autowired
    private PkgDao pkgDao;
    @Override
    public Map<String, Object> getPkgPage(ProductDto dto) {
        PageInfo<ProductDto> page = Utils.createPageInfo(dto, () -> {

            return pkgDao.findProductListOnsStatusOn35(dto);
        });
        return Utils.convert2PageData(page);
    }

    @Override
    public void modifyProductStatus(ProductDto dto) {
        pkgDao.modifyProductStatus(dto);
    }

    @Override
    public void modifyProcessStatus(ProductDto dto) {
        pkgDao.modifyProcessStatus(dto);
    }
}