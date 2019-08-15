package com.think123.yr_online.service.info;

import com.think123.yr_online.dataobject.Color;
import com.think123.yr_online.dto.ColorDto;

import java.util.List;
import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-09 13:44
 */
public interface ColorService {
    Map<String, Object> getColorPage(ColorDto dto);

    void addColor(ColorDto dto);

    void modifyColor(ColorDto dto);

    void deleteColor(Integer[] ids);

    List<Color> getAllColor();
}
