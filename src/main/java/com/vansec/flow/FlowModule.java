package com.vansec.flow;

import com.vansec.comm.exception.MessageProvider;

/**
 * 流程异常信息.
 * @author zhousd
 */
public enum FlowModule {

    //任务模块
    ERR_DAO_TASK_INSERT,
    ERR_DAO_TASK_UPDATE,
    ERR_DAO_TASK_READ,
    ERR_DAO_TASK_GETBYID,
    ERR_DAO_TASK_SEARCH,
    ERR_DAO_TASK_GETBYOBJECTID,
    ERR_TASKSERVICE_CHECKERROR_ISDO,
    ERR_DAO_TASK_GETLASTTASKBYOBJECTID,
    ERR_SERVICE_TASK_GETLASTTASKBYOBJECTID,


    //流程模块
    ERR_DAO_FLOW_UPDATE,
    ERR_DAO_FLOW_SAVE,
    ERR_DAO_FLOW_GETBYID,


    //活动模块
    ERR_DAO_ACTIVITY_SAVE,
    ERR_DAO_ACTIVITY_GETBYID,
    ERR_DAO_ACTIVITY_GETBYFLOWID,
    ERR_DAO_ACTIVITY_GETSTARTACTIVITYBYFLOWID,
    ERR_DAO_ACTIVITY_GETSTARTACTIVITYBYID

    ;

    @Override
    public String toString() {
        return MessageProvider.getResource(FlowModule.class).getMessage(this.name());
    }
}
