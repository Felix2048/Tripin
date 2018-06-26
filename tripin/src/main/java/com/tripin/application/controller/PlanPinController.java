package com.tripin.application.controller;

import com.tripin.application.entity.Pin;
import com.tripin.application.entity.Plan;
import com.tripin.application.entity.Plat;
import com.tripin.application.service.PlanPinService;
import com.tripin.application.utils.BaseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanPinController {
    @Autowired
    private PlanPinService planPinService;


    //todo 如何直接根据 plan 实体进行操作

    //根据 user id 获取所有计划
    @GetMapping("query")
    public BaseJson getPlansByID(@RequestParam("userId") Integer userID) {
        BaseJson baseJson = planPinService.getPlansByUserId( userID );
        return baseJson;
    }


//    根据用户添加计划与地图(只添加计划，不打点)
    @PostMapping("/add")
    public BaseJson add(@RequestParam("userId")Integer userId, Plan plan, Plat plat) {
        return planPinService.addPlanByUserId( userId, plan, plat );
    }

    @PostMapping("add/pins")
    public BaseJson addPinsByPlanId(@RequestParam Integer planId, List<Pin> pinList) {
        return planPinService.addPinsByPlanId( planId, pinList );
    }

//    @PostMapping("/delete")
//    public BaseJson delete(@RequestParam Integer id) {
//        return planPinService.deleteById( id );
//
//    }

    @PostMapping("/update")
    public BaseJson updatePlanByUserId(@RequestParam("userId")Integer userId, Plan plan, Plat plat) {
        return planPinService.updatePlanByUserId( userId, plan, plat );
    }

    //todo 查找路径 这个是在服务端做还是客户端？
//    @GetMapping("query/routes")
//    public BaseJson getRoutesByID(@RequestParam("planID") Integer planID) {
//        return new BaseJson();
//    }

    @GetMapping("/pins")
    public BaseJson getPinsByPlanID(@RequestParam("planid") Integer planID) {
        return planPinService.getPinsByPlanId( planID );
    }

    @PostMapping("/update/pin")
    public BaseJson updatePinByUserId(@RequestParam("pinId")Integer pinId, Pin pin) {
        return planPinService.updatePinByPlanId( pinId, pin );
    }

    @GetMapping("/planedOrderedPin")
    public BaseJson getPlanedPinOrder(@RequestParam("planID")Integer planID) {
        return planPinService.getPlanedPinOrder(planID);
    }
}
