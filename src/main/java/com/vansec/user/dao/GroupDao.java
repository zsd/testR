package com.vansec.user.dao;

import com.vansec.comm.orm.Page;
import com.vansec.user.domain.Group;
import com.vansec.user.domain.User;

import java.util.Map;

/**
 * 用户组数据访问类.
 * @author zhousd
 */
public interface GroupDao {

    /**
     * 根据用户ID获取.
     */
    Group getById(String id);

    /**
     * 保存.
     */
    void save(Group group);

    /**
     * 更新.
     */
    void update(Group group);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Group> search(Page<Group> page, Map<String, Object> param);
}