package com.vansec.flow.service;

import com.vansec.comm.orm.Page;
import com.vansec.flow.domain.Task;
import com.vansec.org.domain.common.Handleable;

import java.util.Map;

/**
 * 任务服务接口.
 * @author zhousd
 */
public interface TaskService {

    /**
     * 判断是否有权限操作任务.
     * @param task 任务
     * @param handler 登录用户
     */
    void checkError(Task task, Handleable handler);

    /**
     * 查询分页列表
     * @param page 分页实体
     * @param param 查询条件
     * @return 实例分页列表
     */
    Page<Task> search(Page<Task> page, Map<String, Object> param);

    /**
     * 根据对象ID获取该对象关联的起始任务
     * @param objectId 对象ID
     * @return 该对象关联的起始任务
     */
    Task getByObjectId(String objectId);

    /**
     * 根据对象ID获取该对象关联的最新任务
     * @param objectId 对象ID
     * @return 该对象关联的最新任务
     */
    Task getLastTaskByObjectId(String objectId);

    /**
     * 根据任务Id获取任务.
     * @param id 任务ID
     * @return 任务
     */
    Task getById(String id);

    /**
     * 根据任务Id获取任务,关联对象.
     * @param id 任务ID
     * @param taskObjectService 任务对象服务
     * @return 任务
     */
    Task getById(String id, TaskObjectService taskObjectService);
}
