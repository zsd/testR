package com.vansec.frontset.service;

import bussiness.comm.MD5Encryption;
import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.utils.Constants;
import com.vansec.function.service.FunctionService;
import com.vansec.org.OrgModule;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;
import com.vansec.org.service.PostService;
import com.vansec.org.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * 用户服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private FunctionService functionService;

    @Override
    public String login(User user) {
        try {
            User realUser = userService.getByLoginName(user.getLoginName());
            if (ObjectUtils.equals(realUser, null)) {
                return Constants.NOT_EXIST_LOGINNAME;
            }
            if (!realUser.getLoginName().equals(user.getLoginName())
                    || !MD5Encryption.checkpassword(user.getPassword(),realUser.getPassword())) {
                return Constants.LOGINNAME_OR_PASSWORD_ERROR;
            }
            List<Post> postList = postService.getByUserId(realUser.getId());
            if (CollectionUtils.isEmpty(postList)) {
                return Constants.SYSTEM_ERROR;
            }
            Post post = postList.get(0); // 这个地方可以按照主岗位选择
            post.setUser(realUser);

            Set<String> buttonSet =  functionService.getButtonByPostId(post.getId());
            SecurityContextHolder.setPost(post);
            SecurityContextHolder.setAuthoritySet(buttonSet);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.SYSTEM_ERROR;
        }
        return null;
    }

    @Override
    public void logout() {
        SecurityContextHolder.destroy();
    }

}
