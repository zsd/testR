package com.vansec.flow.dao;

import com.vansec.comm.orm.Page;
import com.vansec.flow.domain.Task;

import java.util.List;
import java.util.Map;

/**
 * 任务数据访问接口.
 * @author zhousd
 */
public interface TaskDao {

    /**
     * 插入任务.
     * @param task  任务实体
     */
    void insert(Task task);

    /**
     * 更新任务.
     * @param task 任务实体
     */
    void update(Task task);

    /**
     * 标记为已读未读.
     * @param isReaded 是否已读
     * @param id 任务ID
     */
    void read(int isReaded, String id);

    /**
     * 根据任务Id获取任务.
     * @param id 任务Id
     * @return  返回任务实体
     */
    Task getById(String id);

    /**
     * 查询分页列表
     * @param page 分页实体
     * @param param 查询条件
     * @return 实例分页列表
     */
    Page<Task> search(Page<Task> page, Map<String, Object> param);

    /**
     * 根据对象ID获取该对象关联的最新任务
     * @param objectId 对象ID
     * @return 该对象关联的任务列表
     */
    List<Task> getByObjectId(String objectId);

    /**
     * 根据活动ID获取任务
     * @param activityId 活动ID
     * @return 任务
     */
    Task getByActivityId(String activityId);

    /**
     * 根据对象ID获取该对象关联的最新任务
     * @param objectId 对象ID
     * @return 该对象关联的最新任务
     */
    Task getLastTaskByObjectId(String objectId);
}
