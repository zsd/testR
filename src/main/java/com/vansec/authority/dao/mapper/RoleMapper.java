package com.vansec.authority.dao.mapper;

import com.vansec.authority.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 行政区域角色Mapper类.
 * @author zhousd
 */
@Repository
public interface RoleMapper {

    /**
     * 根据岗位ID获取角色.<p/>
     * @param postId 岗位ID
     * @return 角色
     */
    List<Role> getByPostId(String postId);

    /**
     * 保存角色.
     * @param role 角色
     */
    void save(Role role);

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
    void saveOrgRole(@Param("orgId") String orgId, @Param("type") int type, @Param("roleId") String roleId);

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
