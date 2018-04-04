package com.vansec.org.domain.common;

import com.vansec.comm.domain.EntityImpl;

/**
 * 组织机构父级实体.
 * 包括单位,部门等
 * @author zhousd
 */
public class OrgImpl extends EntityImpl implements Handleable {

    private OrgImpl parent; // 归属

    private int type; // 组织结构类型

    public static final int TYPE_ORG = 1; // 单位类型
    public static final int TYPE_DEPARTMENT = 2; // 部门类型
    public static final int TYPE_POST = 3; // 岗位类型
    public static final int TYPE_USER = 4; // 用户类型

    public OrgImpl getParent() {
        return parent;
    }

    public void setParent(OrgImpl parent) {
        this.parent = parent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
