package com.vansec.user.service;

import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.user.dao.GroupDao;
import com.vansec.user.domain.Group;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 用户组服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private static Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupDao groupDao;

    @Override
    public Group getById(String id) {
        try {
            return groupDao.getById(id);
        } catch (Exception e) {
            logger.error("get group by id error!", e);
        }
        return null;
    }

    @Override
    public void save(Group group) {
        try {
            if (group != null && StringUtils.isEmpty(group.getId())) {
                group.setId(Identities.uuid());
            }
            groupDao.save(group);
        } catch (Exception e) {
            logger.error("save group error!", e);
        }
    }

    @Override
    public void update(Group group) {
        try {
            groupDao.update(group);
        } catch (Exception e) {
            logger.error("update group error!", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            groupDao.delete(id);
        } catch (Exception e) {
            logger.error("delete group by id error!", e);
        }
    }

    @Override
    public void deleteIdStr(String idStr) {
        if (StringUtils.isBlank(idStr)) {
            return;
        }
        String[] ids = idStr.split(",");
        for (String id : ids) {
            this.delete(id);
        }
    }

    @Override
    public Page<Group> search(Page<Group> page, Map<String, Object> param) {
        try {
            return groupDao.search(page, param);
        } catch (Exception e) {
            logger.error("search group error!", e);
        }
        return null;
    }
}
