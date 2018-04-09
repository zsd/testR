package com.vansec.authority.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vansec.comm.domain.EntityImpl;

import java.util.List;

/**
 * 角色.
 * @author zhousd
 */
public class Role extends EntityImpl {

    private String name; // 角色名称

    private String description; // 描述

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

}
