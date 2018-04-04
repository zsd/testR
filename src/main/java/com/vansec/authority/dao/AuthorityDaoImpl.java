package com.vansec.authority.dao;

import com.vansec.authority.AuthorityModule;
import com.vansec.authority.dao.mapper.AuthorityMapper;
import com.vansec.authority.domain.Authority;
import com.vansec.comm.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限管理数据访问类.
 * @author zhousd
 */
@Repository
public class AuthorityDaoImpl implements AuthorityDao {

    private static Logger logger = LoggerFactory.getLogger(AuthorityDaoImpl.class);

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public List<Authority> getByRoleId(String roleId) {
        try {
            return authorityMapper.getByRoleId(roleId);
        } catch (Exception e) {
            logger.error("Get list by role id error!", e);
            throw new DataAccessException(AuthorityModule.ERR_DAO_AUTHORITY_GETBYROLEID, e);
        }
    }

    @Override
    public void save(Authority authority) throws DataAccessException {
        try {
            authorityMapper.save(authority);
        } catch (Exception e) {
            logger.error("Save authority error!", e);
            throw new DataAccessException(AuthorityModule.ERR_DAO_AUTHORITY_SAVE, e);
        }
    }

    @Override
    public List<Authority> getByPostId(String postId) throws DataAccessException {
        try {
            return authorityMapper.getByPostId(postId);
        } catch (Exception e) {
            logger.error("Save authority error!", e);
            throw new DataAccessException(AuthorityModule.ERR_DAO_AUTHORITY_GETBYPOSTID, e);
        }
    }
}
