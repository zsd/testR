package com.vansec.flow.domain.support;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.comm.domain.ObjectType;

import java.util.List;

/**
 * 流转对象状态.
 * @author zhousd
 */
public class Status extends EntityImpl {

    private ObjectType objectType; // 关联流转对象类型

    private Status pre; // 上一状态

    public Status() {
        super();
    }

    public Status(String name) {
        this();
        this.setName(name);
    }

    public Status(ObjectType objectType, String name) {
        this();
        this.objectType = objectType;
        this.setName(name);
    }

    public Status(String id, ObjectType objectType, String name, Status pre) {
        this(objectType, name);
        this.setId(id);
        this.pre = pre;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public Status getPre() {
        return pre;
    }

    public void setPre(Status pre) {
        this.pre = pre;
    }
}
