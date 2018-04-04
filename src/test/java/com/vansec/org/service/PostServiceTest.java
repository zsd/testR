package com.vansec.org.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.org.data.PostDataProvider;
import com.vansec.org.data.UserDataProvider;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 岗位服务测试用例.
 * @author zhousd
 */
public class PostServiceTest extends AbstractTest {

    @Autowired
    PostService postService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest(){
        Post post = PostDataProvider.post1();
        postService.save(post);
    }

    /**
     * 查询测试.
     */
    @Test
    public void getByIdTest(){
        Post post = postService.getById(DataUtils.ID_1);
        Assert.notNull(post);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest(){
        Post post = postService.getById(DataUtils.ID_1);
        post.setName("修改岗位");
        postService.update(post);
    }
    /**
     * 更新测试.
     */
    @Test
    public void deleteTest(){
        postService.delete(DataUtils.ID_1);
    }

}
