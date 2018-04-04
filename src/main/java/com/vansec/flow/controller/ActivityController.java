package com.vansec.flow.controller;

import com.vansec.comm.utils.JsonMapper;
import com.vansec.flow.domain.Activity;
import com.vansec.flow.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 活动控制器
 * @author zhousd
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

    private static Logger logger = LoggerFactory.getLogger(ActivityController.class);

    private JsonMapper jsonMapper = new JsonMapper();

    @Autowired
    private ActivityService activityService;

    /**
     * 根据流程Id获取活动列表
     * @param flowId 流程Id
     * @return 活动列表
     */
    @RequestMapping(value = "/getByFlowId", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getByFlowId(String flowId) {
        logger.debug("this flowId is {}", flowId);
        List<Activity> activityList = activityService.getByFlowId(flowId);
        return jsonMapper.toJson(activityList);
    }

}
