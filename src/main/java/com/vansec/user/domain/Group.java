package com.vansec.user.domain;

import com.vansec.authority.domain.Role;
import com.vansec.comm.domain.EntityImpl;

import java.util.List;

/**
 * 用户组实体.
 * @author zhousd
 */
public class Group extends EntityImpl {

    private List<Role> roleList; // 当前岗位使用角色集合

    public Group() {
        super();
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}