package com.vansec.org.service;

import com.vansec.authority.service.RoleService;
import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.org.OrgModule;
import com.vansec.org.dao.PostDao;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 岗位服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public Post getById(String id) {
        try {
            Post post = postDao.getById(id);
//            List<Role> roleList = roleService.getByPostId(post.getId());
//            post.setRoleList(roleList);
            return post;
        } catch (Exception e) {
            logger.error("get post by id error!", e);
            throw new DataAccessException(OrgModule.ERR_SEV_POST_GETBYID, e);
        }

    }

    @Override
    public List<Post> getByUserId(String id) {
        try {
            List<Post> posts = postDao.getByUserId(id);
            return posts;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(Post post) {
        if (post != null && StringUtils.isEmpty(post.getId())) {
            post.setId(Identities.uuid());
        }
        postDao.save(post);
    }

    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    @Override
    public void delete(String id) {
        postDao.delete(id);
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
    public Page<Post> search(Page<Post> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        param.put("skip", skip);
        param.put("limit", limit);
        List<Post> lists = postDao.search(param);
        long count = postDao.count(param);
        for (Post post : lists) {
            User user = userService.getById(post.getUser().getId());
            if(user != null){
                post.getUser().setName(user.getName());
                post.setRoleList(roleService.getByPostId(post.getId()));
            }else{
                post.setUser(new User());
                post.getUser().setName("");
            }

        }
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }
}
