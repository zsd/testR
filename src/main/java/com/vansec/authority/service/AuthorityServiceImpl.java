package com.vansec.authority.service;

import com.vansec.authority.dao.AuthorityDao;
import com.vansec.authority.domain.Authority;
import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.utils.Identities;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

    private static Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public List<Authority> getByRoleId(String roleId) throws ServiceException {
        try {
            return authorityDao.getByRoleId(roleId);
        } catch (Exception e) {
            logger.error("Get list by role id error!", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Set<String> getSetByPostId(String postId) throws ServiceException {
        try {
            Set<String> set = new HashSet<>();
            List<Authority> authorityList = this.getByPostId(postId);
            for (Authority authority : authorityList) {
                set.add(authority.getLabel());
            }
            return set;
        } catch (Exception e) {
            logger.error("Get list by role id error!", e);
            throw new ServiceException(e);
        }
    }

    private List<Authority> getByPostId(String postId) {
        return authorityDao.getByPostId(postId);
    }

    @Override
    public void save(Authority authority) throws ServiceException {
        try {
            if (authority != null && StringUtils.isEmpty(authority.getId())) {
                authority.setId(Identities.uuid());
            }
            authorityDao.save(authority);
        } catch (Exception e) {
            logger.error("save authority error!", e);
            throw new ServiceException(e);
        }
    }
}
