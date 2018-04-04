package com.vansec.flow.service;

import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.support.Status;

import java.util.List;

/**
 * 流转对象状态服务接口.
 * @author zhousd
 */
public interface StatusService {

    /**
     * 保存状态.
     */
    void save(Status status);

    /**
     * 根据对象类型ID获取状态.
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
