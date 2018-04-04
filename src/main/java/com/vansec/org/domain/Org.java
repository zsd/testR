package com.vansec.org.domain;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.org.domain.common.Handleable;
import com.vansec.org.domain.common.OrgImpl;

import java.util.List;

/**
 * 组织机构实体.
 * 包括单位,部门等
 * @author zhousd
 */
public class Org extends OrgImpl {

    private List<Department> departments; //部门集合

    public Org() {
        super();
        this.setType(OrgImpl.TYPE_ORG);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
