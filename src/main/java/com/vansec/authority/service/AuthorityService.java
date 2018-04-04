package com.vansec.authority.service;

import com.vansec.authority.domain.Authority;
import com.vansec.comm.exception.ServiceException;

import java.util.List;
import java.util.Set;

/**
 * 权限服务接口.
 * @author zhousd
 */
public interface AuthorityService {

    /**
     * 根据角色获取关联的权限接口.
     * @param roleId 角色
     * @return 关联权限集合
     * @throws ServiceException 服务异常
     */
    List<Authority> getByRoleId(String roleId) throws ServiceException;

    /**
     * 根据岗位ID获取权限集合.
     * @param postId 岗位
     * @return 权限集合
     * @throws ServiceException 服务异常
     */
    Set<String> getSetByPostId(String postId) throws ServiceException;

    /**
     * 保存权限.
     * @param authority 权限
     * @throws ServiceException 服务异常
     */
    void save(Authority authority) throws ServiceException;
}
