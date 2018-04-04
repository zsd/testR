package com.vansec.flow.service;

import com.vansec.flow.domain.TaskObject;

/**
 * 流转对象服务接口.
 * @author zhousd
 */
public interface TaskObjectService {

    /**
     * 保存流转对象.
     */
    void save(TaskObject taskObject);

    /**
     * 更新流转对象.
     */
    void update(TaskObject taskObject);

    /**
     * 根据ID获取流转对象.
     */
    TaskObject getById(String id);
}
