package com.vansec.org.data;

import com.vansec.comm.DataUtils;
import com.vansec.org.domain.Post;

/**
 * 岗位测试数据提供类
 */
public class PostDataProvider {

    private PostDataProvider() {}

    public static Post post1() {
        Post post = new Post();
        post.setId(DataUtils.ID_1);
        post.setName("测试岗位_001");
        post.setUser(UserDataProvider.getUser1());
        post.setParent(DepartmentDataProvider.getDepartment1());
        return post;
    }

}
