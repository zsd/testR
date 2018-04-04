package com.vansec.flow.domain;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.comm.domain.ObjectType;
import com.vansec.flow.domain.support.Status;

/**
 * 流转对象实体.
 * @author zhousd
 */
public class TaskObject extends EntityImpl implements Flowable {

    private Status status; //状态

    @Override
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
