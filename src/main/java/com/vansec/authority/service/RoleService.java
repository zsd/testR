package com.vansec.authority.service;

import com.vansec.authority.domain.Role;
import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.orm.Page;
import com.vansec.user.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 角色服务接口.
 * @author zhousd
 */
public interface RoleService {

    /**
     * 根据角色ID获取角色.
     * @param postId 角色ID
     * @return 角色实体
     * @throws ServiceException 服务异常
     */
    List<Role> getByPostId(String postId) throws ServiceException;

    /**
     * 保存角色.
     * @param role 角色
     * @throws ServiceException 服务异常
     */
    void save(Role role) throws ServiceException;

    /**
     * 删除角色.
     * @param id 角色主键id
     */
    void delete(String id);

    /**
     * 根据ID字符串删除相应记录.
     * @param idStr ID字符串
     */
    void deleteIdStr(String idStr);

    /**
     * 根据条件分页查询角色.
     * @param param 参数
     */
    Page<Role> search(Page<Role> page, Map<String, Object> param);

    /**
     * 保存用户角色关联.
     * @param user 用户
     */
    void saveOrgRole(User user);
}
