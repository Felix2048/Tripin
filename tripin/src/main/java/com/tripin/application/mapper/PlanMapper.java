package com.tripin.application.mapper;

import com.tripin.application.entity.Plan;
import com.tripin.application.entity.Route;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlanMapper {


    /**
     * 根据 planID 查找对应的 plan
     * @param planID id
     * @return Plan
     */
    @Select("SELECT * FROM \"plan\" WHERE \"planID\" = #{id} and \"isDelete\"=false")
    Plan getPlanByID(@Param("id") Integer planID);

    /**
     * 根据 planID 查找所有的 routes
     * @param planID
     * @return
     */
    @Select("SELECT * FROM route WHERE \"planID\" = #{planID} and \"isDelete\"=false ORDER BY origin ")
    List<Route> getAllRouteByPlanID(@Param("planID") int planID);

    /**
     * 插入Plan
     * @param plan
     * @return
     */
    @Insert("INSERT INTO \"plan\"(\"planName\",\"planType\",\"defaultTransportation\",\"isDelete\") VALUES (#{planName},CAST(#{planType} as \"enum_planType\"), CAST(#{defaultTransportation} as \"enum_transportation\"),#{isDelete})")
    int insert(Plan plan);

    /**
     * 修改Plan
     * @param plan
     * @return
     */
    @Update("update \"plan\" set \"planName\"=#{planName},\"planType\"=CAST(#{planType} as \"enum_planType\"),\"defaultTransportation\"=CAST(#{defaultTransportation} AS \"enum_transportation\") where \"planID\"=#{planID}")
    int update(Plan plan);

    /**
     * 获取Plan的list
     * @param planId
     * @return
     */
    @Select("select * from plan where \"planID\"=#{planID} and \"isDelete\"=false")
    Plan getByPlanId(@Param("planID") Integer planId);

}
