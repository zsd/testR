package com.vansec.flow.dao.mapper;

import com.vansec.flow.domain.Task;
import com.vansec.flow.domain.support.Status;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 流转对象状态接口.
 * @author zhousd
 */
@Repository
public interface StatusMapper {

    /**
     * 保存状态.
     */
    void insert(Status status);

    /**
     * 根据ID获取状态.
     */
    Status getById(String id);

    /**
     * 根据对象类型ID获取状态列表.
     */
    List<Status> getByObjectTypeId(String objectTypeId);

    /**
     * 根据当前状态获取下一状态.
     * @param currentId 当前状态id
     */
    Status getNext(String currentId);

    /**
     * 根据当前状态获取上一状态.
     * @param currentId 当前状态id
     */
    Status getPre(String currentId);
}