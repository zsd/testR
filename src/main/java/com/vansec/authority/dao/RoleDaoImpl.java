package com.vansec.authority.dao;

import com.vansec.authority.AuthorityModule;
import com.vansec.authority.dao.mapper.RoleMapper;
import com.vansec.authority.domain.Role;
import com.vansec.comm.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 角色管理数据访问类.
 * @author zhousd
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    private static Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据岗位ID获取角色.
     * @param postId 岗位Id
     * @return 角色
     */
    public List<Role> getByPostId(String postId) throws DataAccessException {
        try {
            return roleMapper.getByPostId(postId);
        } catch (Exception e) {
            logger.error("Get list by post id error!", e);
            throw new DataAccessException(AuthorityModule.ERR_DAO_ROLE_GETBYPOSTID, e);
        }
    }

    @Override
    public void save(Role role) throws DataAccessException {
        try {
            roleMapper.save(role);
        } catch (Exception e) {
            logger.error("Save role error!", e);
            throw new DataAccessException(AuthorityModule.ERR_DAO_ROLE_SAVE, e);
        }
    }

    /**
     * 更新角色
     * @param role 角色
     */
    @Override
    public void update(Role role){roleMapper.update(role);}

    /**
     * 删除角色
     * @param id 角色主键id
     */
    @Override
    public void delete(String id){roleMapper.delete(id);}

    /**
     * 根据条件分页查询角色
     * @param param 参数
     * @return
     */
    @Override
    public List<Role> search(Map<String, Object> param){
        return roleMapper.search(param);
    }

    /**
     * 根据条件查询扶贫对象总数
     * @param param 参数
     * @return
     */
    @Override
    public long count(Map<String, Object> param){ return roleMapper.count(param);}

    @Override
    public void saveOrgRole(String orgId, int type, String roleId) {
        roleMapper.saveOrgRole(orgId, type, roleId);
    }

    @Override
    public void deleteByOrg(String orgId) {
        roleMapper.deleteByOrg(orgId);
    }

    @Override
    public void deleteByRole(String roleId) {
        roleMapper.deleteByRole(roleId);
    }
}
