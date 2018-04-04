package com.vansec.flow.data;

import bussiness.comm.ObjectTypeFactory;
import com.vansec.comm.DataUtils;
import com.vansec.flow.domain.support.Status;

/**
 * Status测试数据提供类.
 * @author zhousd
 */
public final class StatusDataProvider {

    /**
     * 生成状态1.
     */
    public static Status getStatus1() {
        Status status = new Status(DataUtils.ID_1, ObjectTypeFactory.getObjectType(ObjectTypeFactory.ID_EXAMPLE), "测试状态1", null);
        return status;
    }

    /**
     * 生成状态1.
     */
    public static Status getStatus2() {
        Status status = new Status(DataUtils.ID_2, ObjectTypeFactory.getObjectType(ObjectTypeFactory.ID_EXAMPLE), "测试状态2", getStatus1());
        return status;
    }

    private StatusDataProvider() {}
}
