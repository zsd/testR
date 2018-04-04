package com.vansec.authority.dao.mapper;

import com.vansec.authority.domain.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限Mapper类.
 * @author zhousd
 */
@Repository
public interface AuthorityMapper {

    /**
     * 根据角色ID获取权限列表.<p/>
     * @param roleId 角色ID
     * @return 权限列表
     */
    List<Authority> getByRoleId(String roleId);

    /**
     * 保存角色.
     * @param authority 角色
     */
    void save(Authority authority);

    /**
     * 根据岗位ID获取权限列表.<p/>
     * @param postId 岗位ID
     * @return 权限列表
     */
    List<Authority> getByPostId(String postId);
}
