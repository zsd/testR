package com.vansec.flow.dao;

import com.vansec.flow.domain.Activity;

import java.util.List;

/**
 * 活动数据访问接口.
 * @author xierh
 */
public interface ActivityDao {

    /**
     * 保存活动.
     * @param activity 活动
     */
    void save(Activity activity);

    /**
     * 根据活动Id获取活动.
     * @param id 活动Id
     * @return  返回活动
     */
    Activity getById(String id);

    /**
     * 根据流程Id获取活动列表.
     * @param flowId 流程Id
     * @return 活动列表
     */
    List<Activity> getByFlowId(String flowId);

    /**
     * 根据流程ID获取起始活动
     * @param flowId 流程Id
     * @return 起始活动
     */
    Activity getStartActivityByFlowId(String flowId);

    /**
     * 根据活动ID获取起始活动
     * @param id 活动Id
     * @return 起始活动
     */
    Activity getStartActivityById(String id);
}
