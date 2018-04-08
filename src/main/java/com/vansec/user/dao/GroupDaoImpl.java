package com.vansec.user.dao;

import com.vansec.comm.orm.Page;
import com.vansec.user.dao.mapper.GroupMapper;
import com.vansec.user.domain.Group;
import com.vansec.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户组数据访问类.
 * @author zhousd
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    private Logger logger = LoggerFactory.getLogger(GroupDaoImpl.class);

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group getById(String id) {
        try {
            return groupMapper.getById(id);
        } catch (Exception e) {
            logger.error("get group by id error!", e);
        }
        return null;
    }

    @Override
    public void save(Group group) {
        groupMapper.save(group);
    }

    @Override
    public void update(Group group) {
        groupMapper.update(group);
    }

    @Override
    public void delete(String id) {
        groupMapper.delete(id);
    }

    @Override
    public Page<Group> search(Page<Group> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<Group> lists = groupMapper.search(name, skip, limit);
        long count = groupMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }
}