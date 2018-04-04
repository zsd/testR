package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.dao.mapper.UserMapper;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户数据访问类.
 * @author zhousd
 */
@Repository
public class UserDaoImpl implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    public User getByPostId(String postId) {
        return userMapper.getByPostId(postId);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public Page<User> search(Page<User> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<User> lists = userMapper.search(name, skip, limit);
        long count = userMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public long checkLoginName(String id,String loginName){
        return userMapper.checkLoginName(id,loginName);
    }

    @Override
    public List<User> getByDepartmentId(String departmentId) {
        return userMapper.getByDepartmentId(departmentId);
    }

    @Override
    public List<Map<String, Object>> getAllUser(Map<String, Object> param) {
        return userMapper.getAllUser(param);
    }
}