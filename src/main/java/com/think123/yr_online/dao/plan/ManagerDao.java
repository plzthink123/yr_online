package com.think123.yr_online.dao.plan;

import com.think123.yr_online.dataobject.Plan;
import com.think123.yr_online.dto.ColorDto;
import com.think123.yr_online.dto.PlanDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//@Mapper
public interface ManagerDao {
    //@Select("select * from info_color")
    List<Plan> findPlanList(PlanDto dto);

    List<PlanDto> findPlan_CustomerList(PlanDto dto);

    @Select("select max(plan_id) from bus_plan")
    Integer findMaxId();

    @Insert("insert into bus_plan values(#{co_id},#{co_name},#{co_remark},'00')")
    void insert(ColorDto dto);

    @Update("update bus_plan set co_name=#{co_name} , co_remark=#{co_remark} ,co_status=#{co_status} where co_id=#{co_id}")
    void update(ColorDto dto);

    void deleteManager(Integer[] ids);

    void deleteManagerNotReal(Integer[] ids);

    void addPlan(PlanDto dto);

    void modifyPlan(PlanDto dto);

    void cancelPlan(PlanDto dto);
}
