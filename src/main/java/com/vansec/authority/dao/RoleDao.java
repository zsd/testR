package com.vansec.authority.dao;

import com.vansec.authority.domain.Role;
import com.vansec.comm.exception.DataAccessException;

import java.util.List;
import java.util.Map;

/**
 * 角色管理数据访问接口.
 * @author zhousd
 */
public interface RoleDao {

    /**
     * 根据岗位ID获取角色.
     * @param postId 岗位Id
     * @return 角色
     * @throws DataAccessException 数据访问异常
     */
    List<Role> getByPostId(String postId) throws DataAccessException;

    /**
     * 保存角色.
     * @param role 角色
     * @throws DataAccessException 服务异常
     */
    void save(Role role) throws DataAccessException;

    /**
     * 更新角色
     * @param role 角色
     */
    void update(Role role);

    /**
     * 删除角色
     * @param id 角色主键id
     */
    void delete(String id);

    /**
     * 根据条件分页查询角色
     * @param param 参数
     * @return
     */
    List<Role> search(Map<String, Object> param);

    /**
     * 根据条件查询角色总数
     * @param param 参数
     * @return
     */
    long count(Map<String, Object> param);

    /**
     * 保存组织角色关联
     * @param orgId 组织机构ID
     * @param type 组织机构类型
     * @param roleId 角色ID
     */
    void saveOrgRole(String orgId, int type, String roleId);

    /**
     * 根据组织机构ID删除组织角色关联
     * @param orgId 组织机构ID
     */
    void deleteByOrg(String orgId);
    /**
     * 根据角色ID删除组织角色关联
     * @param roleId 组织机构ID
     */
    void deleteByRole(String roleId);

}
