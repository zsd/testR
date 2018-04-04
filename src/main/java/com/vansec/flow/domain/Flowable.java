package com.vansec.flow.domain;

import com.vansec.flow.domain.support.Status;

/**
 * 任务流转对象接口.
 * @author zhousd
 */
public interface Flowable {

    /**
     * 获取流转对象Id
     * @return 流转对象Id
     */
    String getId();

    /**
     * 获取状态.
     */
    Status getStatus();

}
