package com.vansec.org.service;

import bussiness.comm.MD5Encryption;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.org.dao.UserDao;
import com.vansec.org.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByLoginName(String loginName) {
        User user = userDao.getByLoginName(loginName);
        return user;
    }

    @Override
    public User getById(String id) {
        User user = userDao.getById(id);
        return user;
    }

    @Override
    public void save(User user) {
        try{
            if (user != null && StringUtils.isEmpty(user.getId())) {
                user.setId(Identities.uuid());
            }
            //对密码进行加密
            user.setPassword(MD5Encryption.EncoderByMd5(user.getPassword()));
            userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try{
            //对密码进行加密
            user.setPassword(MD5Encryption.EncoderByMd5(user.getPassword()));
            userDao.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
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
    public Page<User> search(Page<User> page, Map<String, Object> param) {
        return userDao.search(page, param);
    }

    @Override
    public long checkLoginName(String id,String loginName){
        return userDao.checkLoginName(id,loginName);
    }

    @Override
    public List<User> getByDepartmentId(String departmentId) {
        return userDao.getByDepartmentId(departmentId);
    }

    @Override
    public List<Map<String, Object>> getAllUser(String name, String departmentId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name",name);
        param.put("departmentId",departmentId);
        return userDao.getAllUser(param);
    }
}
