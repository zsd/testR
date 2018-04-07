package com.vansec.user.dao.mapper;

import com.vansec.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    /**
     * 根据用户ID获取岗位.
     * @param id 用户ID
     * @return 用户实体
     */
    User getById(String id);

    /**
     * 根据用户登录名称获取用户.
     * @param loginName 登录名称
     * @return 用户
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
     * 分页查询-列表.
     */
    List<User> search(@Param("name") String name, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 分页查询-总数.
     */
    long count(@Param("name") String name);

    /**
     * 添加用户登录名判断.
     */
    long checkLoginName(@Param("id") String id, @Param("loginName") String loginName);
}
