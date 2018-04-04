package com.vansec.flow.domain.support;

import com.vansec.comm.domain.ObjectType;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动类型工厂.
 * @author zhousd
 */
public class ActivityTypeFactory {

    public static final String ID_START = "1001"; // 起始活动编号
    public static final String ID_ACCEPT = "1002"; // 接收活动编号
    public static final String ID_APPROVAL = "1003"; // 审批活动编号
    public static final String ID_END = "1004"; // 办结活动编号
    public static final String ID_BACK = "1005"; // 退回活动编号

    private static Map<String, ActivityType> activityTypeMap = new HashMap(); // 实体容器

    static {
        ActivityType at1 = new ActivityType(ID_START, "发起");
        activityTypeMap.put(ID_START, at1);
        ActivityType at2 = new ActivityType(ID_ACCEPT, "接收");
        activityTypeMap.put(ID_ACCEPT, at2);
        ActivityType at3 = new ActivityType(ID_APPROVAL, "审批");
        activityTypeMap.put(ID_APPROVAL, at3);
        ActivityType at4 = new ActivityType(ID_END, "办结");
        activityTypeMap.put(ID_END, at4);
        ActivityType at5 = new ActivityType(ID_BACK, "退回");
        activityTypeMap.put(ID_BACK, at5);
    }

    /**
     * 根据实体ID获取活动类型.
     */
    public static ActivityType get(String activityTypeId) {
        return activityTypeMap.get(activityTypeId);
    }

    private ActivityTypeFactory() {}
}
