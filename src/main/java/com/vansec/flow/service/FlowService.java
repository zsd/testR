package com.vansec.flow.service;

import com.vansec.flow.domain.Activity;

/**
 * 流程服务接口.
 * @author zhousd
 */
public interface FlowService {

    /**
     * 流程执行.
     * @param activity 活动
     */
    void execute(Activity activity);
}
