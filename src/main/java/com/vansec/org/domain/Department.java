package com.vansec.org.domain;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.dic.domain.Dic;
import com.vansec.org.domain.common.Handleable;
import com.vansec.org.domain.common.OrgImpl;

import java.util.List;

/**
 * 组织机构实体.
 * 包括单位,部门等
 * @author zhousd
 */
public class Department extends OrgImpl {

    private Org parent;

    private List<User> users; //用户集合

    public Department() {
        super();
        this.setType(OrgImpl.TYPE_DEPARTMENT);
    }

    @Override
    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
