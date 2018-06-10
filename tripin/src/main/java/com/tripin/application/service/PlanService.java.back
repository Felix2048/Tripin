package com.tripin.application.service;

import com.tripin.application.annotation.Logged;
import com.tripin.application.entity.Plan;
import com.tripin.application.entity.Route;
import com.tripin.application.enums.ErrorCode;
import com.tripin.application.exception.TripinException;
import com.tripin.application.mapper.PlanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanService {
    private static final Logger LOGGER = LoggerFactory.getLogger( PlanService.class );

    private final PlanMapper planMapper;

    public PlanService(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    @Logged({"planID"})
    @Transactional
    public Plan getPlanById(Integer planID) {
        Plan plan = planMapper.getPlanByID( planID );
        if (null == plan) {
            throw new TripinException( ErrorCode.QUERY_ERROR );
        }
        return plan;
    }

    @Logged({"id"})
    @Transactional
    public List<Route> getRouterByID(int id) {
        List routeList = planMapper.getAllRouteByPlanID( id );
        if (0 == routeList.size()) {
            throw new TripinException( ErrorCode.QUERY_ERROR );
        }
        return routeList;
    }


//    ==============
//    仅作为参考
//    ==============
    /**
     * @param token
     * @throws TripinException
     * @Description: 注销拥有当前token中的userID用户的登陆
     */
//    @Logged({"token"})
//    @Transactional
//    public void userLogout(Token token) throws TripinException {
//        if (onlineUserHashMap.containsKey( token.getUserID() )) {
//            Token onlineUser = onlineUserHashMap.get( token.getUserID() );
//            // 删除现有token
//            onlineUserHashMap.remove( onlineUser.getUserID() );
//            tokenHashMap.remove( onlineUser.getToken() );
//        } else {
//            throw new TripinException( ErrorCode.LOGOUT_ERROR );
//        }
//    }

}
