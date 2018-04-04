package com.vansec.org.dao.mapper;

import com.vansec.org.domain.Post;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 岗位数据映射类.
 * @author zhousd
 */
@Repository
public interface PostMapper {

    /**
     * 根据岗位ID获取岗位实体.
     * @param id 岗位ID
     * @return 岗位实体
     */
    Post getById(String id);

    /**
     * 根据用户ID集合获取岗位列表
     * @return 岗位集合
     */
    List<Post> getByUserId(String id);

    /**
     * 保存岗位.
     */
    void save(Post post);

    /**
     * 更新岗位.
     */
    void update(Post post);

    /**
     * 删除岗位.
     */
    void delete(String id);

    /**
     * 分页查询-列表.
     */
    List<Post> search(Map<String, Object> param);

    /**
     * 分页查询-总数.
     */
    long count(Map<String, Object> param);
}