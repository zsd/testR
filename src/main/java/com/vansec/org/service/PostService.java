package com.vansec.org.service;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;

import java.util.List;
import java.util.Map;

/**
 * 岗位服务接口.
 * @author zhousd
 */
public interface PostService {

    /**
     * 根据岗位ID获取岗位.
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
     * 批量删除岗位.
     */
    void deleteIdStr(String idStr);

    /**
     * 分页查询.
     */
    Page<Post> search(Page<Post> page, Map<String, Object> param);
}
