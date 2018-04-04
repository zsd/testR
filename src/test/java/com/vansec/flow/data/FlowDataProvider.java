package com.vansec.flow.data;

import com.vansec.comm.DataUtils;
import com.vansec.flow.domain.Flow;

/**
 * Flow测试数据提供类.
 * @author zhousd
 */
public final class FlowDataProvider {

    /**
     * 生成流程.
     */
    public static Flow getFlow() {
        Flow flow = new Flow();
        flow.setStartActivity(ActivityDataProvider.getStartActivity());
        flow.setCurrentTask(TaskDataProvider.getTask());
        flow.setId(DataUtils.ID_1);
        return flow;
    }

    private FlowDataProvider() {}
}
