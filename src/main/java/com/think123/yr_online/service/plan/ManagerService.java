package com.think123.yr_online.service.plan;

import com.think123.yr_online.dto.PlanDto;

import java.util.Map;

/**
 * @author plzthink123
 * 2019-08-14 20:49
 */
public interface ManagerService {
    Map<String, Object> getPlanPage(PlanDto dto);

    void deleteManager(Integer[] ids);

    void deleteManagerNotReal(Integer[] ids);

    void addPlan(PlanDto dto);

    void modifyPlan(PlanDto dto);

   /* void addColor(ColorDto dto);

    void modifyColor(ColorDto dto);

    void deleteColor(Integer[] ids);*/
}
