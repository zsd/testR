package com.vansec.flow.dao.mapper;

import com.vansec.flow.domain.Flow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 流程映射接口
 * @author xierh
 */
@Repository
public interface FlowMapper {

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
    Flow getById(@Param("id") String id);
}
