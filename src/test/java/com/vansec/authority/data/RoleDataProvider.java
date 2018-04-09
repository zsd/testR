package com.vansec.authority.data;

import com.vansec.authority.domain.Role;
import com.vansec.comm.DataUtils;

/**
 * 角色测试数据提供类.
 * @author zhousd
 */
public final class RoleDataProvider {

    /**
     * 生成角色.
     */
    public static Role getRole() {
        Role role = new Role();
        role.setId(DataUtils.ID_1);
        role.setName("测试角色");
        role.setDescription("测试角色");
        return role;
    }

    private RoleDataProvider() {}
}
