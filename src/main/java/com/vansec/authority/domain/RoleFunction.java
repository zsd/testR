package com.vansec.authority.domain;

import java.util.Date;

/**
 * Created by msx on 2016/6/24.
 * 角色关联权限实体
 */
public class RoleFunction {
    private String roleId;
    private String functionId;

    public RoleFunction() {
        super();
    }

    public RoleFunction(String roleId,String functionId){
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }
}
