package com.vansec.user.data;

import com.vansec.authority.data.AuthorityDataProvider;
import com.vansec.authority.domain.Role;
import com.vansec.comm.DataUtils;
import com.vansec.user.domain.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户组测试数据提供类
 */
public class GroupDataProvider {

    private GroupDataProvider() {}

    public static Group getGroup() {
        Group group = new Group();
        group.setId(DataUtils.ID_1);
        group.setName("管理测试组");
        List<Role> roleList = new ArrayList<>();
        roleList.add(AuthorityDataProvider.getRole());
        return group;
    }
}
