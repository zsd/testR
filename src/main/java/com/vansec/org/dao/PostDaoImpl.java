package com.vansec.org.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.orm.Page;
import com.vansec.org.OrgModule;
import com.vansec.org.dao.mapper.PostMapper;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 岗位数据访问类.
 * @author zhousd
 */
@Repository
public class PostDaoImpl implements PostDao {

    private Logger logger = LoggerFactory.getLogger(PostDaoImpl.class);

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private OrgDao orgDao;

    @Override
    public Post getById(String id) {
        try {
            Post post = postMapper.getById(id);
            this.convert(post);
            return post;
        } catch (Exception e) {
            throw new DataAccessException(OrgModule.ERR_DAO_POST_GETBYID, e);
        }
    }

    @Override
    public List<Post> getByUserId(String id) {
        try {
            List<Post> posts  = postMapper.getByUserId(id);
            for (Post post: posts) {
                this.convert(post);
            }
            return posts;
        } catch (Exception e) {
            throw new DataAccessException(OrgModule.ERR_DAO_POST_GETBYID, e);
        }
    }

    private void convert(Post post) {
        if (post == null) {
            return;
        }
        post.setUser(userDao.getByPostId(post.getId()));
        if (post.getParent() != null) {
            Department department = departmentDao.getById(post.getParent().getId());
            if (department.getParent() != null) {
                Org org = orgDao.getById(department.getParent().getId());
                department.setParent(org);
            }
            post.setParent(department);
        }
    }

    @Override
    public void save(Post post) {
        postMapper.save(post);
    }

    @Override
    public void update(Post post) {
        postMapper.update(post);
    }

    @Override
    public void delete(String id) {
        postMapper.delete(id);
    }

    @Override
    public List<Post> search(Map<String, Object> param) {
        return postMapper.search(param);
    }

    @Override
    public long count(Map<String, Object> param) {
        return postMapper.count(param);
    }

}