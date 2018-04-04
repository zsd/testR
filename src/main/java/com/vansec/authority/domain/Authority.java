package com.vansec.authority.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vansec.comm.domain.EntityImpl;

/**
 * 权限实体.
 * @author zhousd
 */
public class Authority extends EntityImpl {

    private String label;

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
