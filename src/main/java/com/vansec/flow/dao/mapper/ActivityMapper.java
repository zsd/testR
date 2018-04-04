package com.vansec.flow.dao.mapper;

import com.vansec.flow.domain.Activity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 活动映射接口
 * @author xierh
 */
@Repository
public interface ActivityMapper {

    /**
     * 保存活动.
     * @param activity 活动
     */
    void insert(Activity activity);

    /**
     * 根据活动Id获取活动.
     * @param id 活动Id
     * @return  返回活动
     */
    Activity getById(@Param("id") String id);

    /**
     * 根据流程Id获取活动列表.
     * @param flowId 流程Id
     * @return 活动列表
     */
    List<Activity> getByFlowId(@Param("flowId") String flowId);

//    /**
//     * 根据流程ID获取起始活动
//     * @param flowId 流程Id
//     * @return 起始活动
//     */
//    Activity getStartActivityByFlowId(@Param("flowId") String flowId);
//
//    /**
//     * 根据活动ID获取起始活动
//     * @param id 活动Id
//     * @return 起始活动
//     */
//    Activity getStartActivityById(@Param("id") String id);
}
