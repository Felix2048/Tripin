package com.tripin.application.service;

import com.tripin.application.entity.Plan;
import com.tripin.application.entity.UserInfo;
import com.tripin.application.enums.PlanType;
import com.tripin.application.mapper.PlanMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PlanMapperTest {
    @Autowired
    private PlanMapper planMapper;

    @Test
    public void getOne() {
        Plan plan = planMapper.getPlanByID( 2 );
        System.out.println( plan );
        Assert.assertEquals( "shanghai", plan.getPlanName() );
        Assert.assertEquals( PlanType.PUBLIC, plan.getPlanType() );
    }

    @Test
    public void insertAPlan() {
        Plan plan = new Plan();
        plan.setMapID( 1 );
        plan.setPlanName( "chongqing" );
        plan.setPlanType( PlanType.PUBLIC );
        plan.setPlanCreatedDate( new Date( 2010, 5, 16 ) );
        plan.setPlanModifiedDate( new Date( 2010, 5, 16 ) );

        int i = planMapper.insert( plan );
        System.out.println( "i :" + i );
        System.out.println(plan);

        plan = planMapper.getPlanByID( 7 );
        System.out.println(plan);

    }
}
