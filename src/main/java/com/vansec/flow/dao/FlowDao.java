package com.vansec.flow.dao;

import com.vansec.flow.domain.Flow;

/**
 * 流程数据访问接口.
 * @author xierh
 */
public interface FlowDao {

    /**
     * 保存流程.
     * @param flow 流程实体
     */
    void save(Flow flow);

    /**
     * 更新流程.
     * @param flow 流程实体
     */
    void update(Flow flow);

    /**
     * 根据ID获取流程.
     * @return 流程
     */
    Flow getById(String id);
}
