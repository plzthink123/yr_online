package com.think123.yr_online.service.plan;

import com.think123.yr_online.dao.plan.ManagerDao;
import com.think123.yr_online.dataobject.Plan;
import com.think123.yr_online.dto.PlanDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author plzthink123
 * 2019-08-14 21:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerServiceImplTest {
    @Autowired
    private ManagerDao managerDao;

    @Test
    public void getPlanPage() {
        PlanDto planDto=new PlanDto();
        List<Plan> plans=managerDao.findPlanList(planDto);
        for (Plan plan:plans
             ) {
            System.out.println(plan);
        }
    }

    @Test
    public void Test2OrderQuery(){
        PlanDto planDto=new PlanDto();
        List<PlanDto> plan_customerList = managerDao.findPlan_CustomerList(planDto);
        for (PlanDto plan:plan_customerList
        ) {
            System.out.println(plan);
        }
    }
}