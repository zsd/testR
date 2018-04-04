package com.vansec.authority.data;

import com.vansec.authority.domain.Authority;
import com.vansec.authority.domain.Role;
import com.vansec.comm.DataUtils;

/**
 * 业务日志测试数据提供类.
 * @author zhousd
 */
public final class AuthorityDataProvider {

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

    /**
     * 生成权限.
     */
    public static Authority getAuthority() {
        Authority authority = new Authority();
        authority.setId(DataUtils.ID_1);
        authority.setLabel("test");
        authority.setName("测试权限");
        authority.setDescription("测试权限");
        return authority;
    }

    private AuthorityDataProvider() {}
}
