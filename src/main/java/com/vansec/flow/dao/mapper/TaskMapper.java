package com.vansec.flow.dao.mapper;

import com.vansec.flow.domain.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 任务映射接口
 * @author xierh
 */
@Repository
public interface TaskMapper {

    /**
     * 插入任务.
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
    void read(@Param("isReaded") int isReaded, @Param("id") String id);

    /**
     * 删除任务.
     * @param id 任务主键
     */
    void delete(@Param("id") String id);

    /**
     * 根据任务Id获取任务.
     * @param id 任务Id
     * @return  返回任务实体
     */
    Task getById(@Param("id") String id);

    /**
     * 分页查询任务
     * @param skip 页数
     * @param limit 每页显示数量
     * @return
     */
    List<Task> search(@Param("objectType") int objectType, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 查询记录数
     * @param skip 页数
     * @param limit 每页显示数量
     * @return
     */
    long count(@Param("objectType") int objectType, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 根据对象ID获取该对象关联的最新任务
     * @param objectId 对象ID
     * @return 该对象关联的任务列表
     */
    List<Task> getByObjectId(@Param("objectId") String objectId);

//    /**
//     * 根据对象ID获取该对象关联的最新任务
//     * @param objectId 对象ID
//     * @return 该对象关联的最新任务
//     */
//    Task getLastTaskByObjectId(@Param("objectId") String objectId);

    /**
     * 根据活动ID获取任务.
     * @param activityId  活动ID
     * @return 任务
     */
    Task getByActivityId(@Param("activityId") String activityId);
}
