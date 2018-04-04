package com.vansec.authority.dao;

import com.vansec.authority.domain.Authority;
import com.vansec.comm.exception.DataAccessException;

import java.util.List;

/**
 * 权限管理数据访问接口.
 * @author zhousd
 */
public interface AuthorityDao {

    /**
     * 根据岗位ID获取角色.
     * @param postId 岗位Id
     * @return 角色
     * @throws DataAccessException 数据访问异常
     */
    List<Authority> getByRoleId(String postId) throws DataAccessException;

    /**
     * 保存权限.
     * @param authority 权限
     * @throws DataAccessException 数据访问异常
     */
    void save(Authority authority) throws DataAccessException;

    /**
     * 根据岗位ID获取权限列表.
     * @param postId 岗位ID
     * @return 权限列表
     * @throws DataAccessException 数据访问异常
     */
    List<Authority> getByPostId(String postId) throws DataAccessException;
}
