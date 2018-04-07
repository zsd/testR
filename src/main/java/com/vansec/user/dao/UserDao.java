package com.vansec.user.dao;

import com.vansec.comm.orm.Page;
import com.vansec.user.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户数据访问类.
 * @author zhousd
 */
public interface UserDao {

    /**
     * 根据用户ID获取用户.
     * @param id 用户ID
     * @return 用户实体
     */
    User getById(String id);

    /**
     * 根据用户登录名称获取用户.
     * @param loginName 用户登录名称
     * @return 用户实体
     */
    User getByLoginName(String loginName);

    /**
     * 保存用户.
     */
    void save(User user);

    /**
     * 更新用户.
     */
    void update(User user);

    /**
     * 删除用户.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<User> search(Page<User> page, Map<String, Object> param);

    /**
     * 添加用户登录名判断.
     */
    long checkLoginName(String id, String loginName);
}