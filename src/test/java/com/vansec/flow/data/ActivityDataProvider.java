package com.vansec.flow.data;

import com.vansec.comm.DataUtils;
import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.activity.end.EndActivity;
import com.vansec.flow.domain.activity.line.ApprovalActivity;
import com.vansec.flow.domain.activity.line.LineActivity;
import com.vansec.flow.domain.activity.self.AcceptActivity;
import com.vansec.flow.domain.activity.special.StartActivity;
import com.vansec.org.data.PostDataProvider;
import com.vansec.org.domain.common.Handleable;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity测试数据提供类.
 * @author zhousd
 */
public final class ActivityDataProvider {

    /**
     * 生成起始活动.
     */
    public static Activity getStartActivity() {
        List<Handleable> receivers = new ArrayList<>();
        receivers.add(PostDataProvider.post1());
        Activity activity = new StartActivity(PostDataProvider.post1(), TaskDataProvider.getTask(), receivers);
        activity.setId(DataUtils.ID_1);
        return activity;
    }

    /**
     * 生成审批活动.
     */
    public static Activity getApprovalActivity() {
        List<Handleable> receivers = new ArrayList<>();
        receivers.add(PostDataProvider.post1());
        Activity activity = new ApprovalActivity(PostDataProvider.post1(), TaskDataProvider.getTask(), receivers);
        activity.setId(DataUtils.ID_2);
        return activity;
    }

    /**
     * 生成受理活动.
     */
    public static Activity getAcceptActivity() {
        Activity activity = new AcceptActivity(PostDataProvider.post1(), TaskDataProvider.getTask(), null);
        activity.setId(DataUtils.ID_3);
        return activity;
    }

    /**
     * 生成办结活动.
     */
    public static Activity getEndActivity() {
        Activity activity = new EndActivity(PostDataProvider.post1(), TaskDataProvider.getTask(), null);
        activity.setId(DataUtils.ID_4);
        return activity;
    }

    private ActivityDataProvider() {}
}
