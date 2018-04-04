package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;

import java.util.List;
import java.util.Map;

/**
 * 岗位数据访问类.
 * @author zhousd
 */
public interface PostDao {

    /**
     * 根据岗位ID获取岗位实体.
     * @param id 岗位ID
     * @return 岗位实体
     */
    Post getById(String id);

    /**
     * 根据用户ID集合获取岗位列表.
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
     * 分页查询．
     */
    List<Post> search(Map<String, Object> param);

    long count(Map<String, Object> param);
}