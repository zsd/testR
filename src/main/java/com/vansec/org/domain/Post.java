package com.vansec.org.domain;

import com.vansec.authority.domain.Role;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.org.domain.common.Handleable;
import com.vansec.org.domain.common.OrgImpl;

import java.util.List;

/**
 * 岗位.
 * @author zhousd
 */
public class Post extends OrgImpl {

    private User user; // 关联用户

    private Department parent;

    private List<Role> roleList; // 当前岗位使用角色集合

    public Post() {
        super();
        this.setType(OrgImpl.TYPE_POST);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }
}