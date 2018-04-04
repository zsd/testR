package com.vansec.flow.domain.support;

import com.vansec.comm.domain.EntityImpl;

/**
 * 流转对象类型.
 * @author zhousd
 */
public class ActivityType extends EntityImpl {

    public ActivityType() {
        super();
    }

    public ActivityType(String name) {
        this();
        this.setName(name);
    }

    public ActivityType(String id, String name) {
        this();
        this.setId(id);
        this.setName(name);
    }
}
