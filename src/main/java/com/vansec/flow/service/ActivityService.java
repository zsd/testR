package com.vansec.flow.service;

import com.vansec.flow.domain.Activity;

import java.util.List;

/**
 * 活动服务接口.
 * @author zhousd
 */
public interface ActivityService {

    /**
     * 根据流程Id获取活动列表
     * @param flowId 流程id
     * @return 活动列表
     */
    List<Activity> getByFlowId(String flowId);
}
