package com.vansec.flow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.comm.utils.Identities;
import com.vansec.flow.dao.ActivityDao;
import com.vansec.flow.dao.FlowDao;
import com.vansec.flow.dao.TaskDao;
import com.vansec.flow.domain.support.ActivityType;
import com.vansec.flow.domain.support.Status;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.common.Handleable;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动实体.
 * @author xierh
 */
public class Activity extends EntityImpl {

    private Task task; //当前任务

    private Post handler; //活动处理人

    private Flow flow; //所属流程

    private ActivityType type; //操作类型

    private List<Handleable> receivers = new ArrayList<>(); //接收人列表

    private ActivityDao activityDao;//活动持久层工具类

    private TaskDao taskDao; //任务持久层工具类

    private FlowDao flowDao; //流程持久层工具类

    public Activity() {
        super();
    }

    public Activity(Post handler, Task task, List<Handleable> receivers) {
        this();
        this.handler = handler;
        this.task = task;
        this.receivers = receivers;
    }

    /**
     * 活动执行.
     * 需要重写
     */
    public void execute() {
    }

    /**
     * 保存活动.
     * 需要重写
     */
    public void create() {
        this.initInfo();
        this.setReceivers(this.getReceivers());
        this.getActivityDao().save(this);
    }

    /**
     * 获取下一个处理人.
     * 需要重写
     */
    public Handleable getNextHandler() {
        return null;
    }

    /**
     * 初始化活动信息.
     */
    public void initInfo() {
//        this.handlerIp = ServletContextHolder.getRequest().getRemoteAddr();
    }

    public ActivityType getType() {
        return type;
    }

    /**
     * 从数据库中获取最新的关联流程.
     * @return flow 当前活动关联的流程
     */
    @JsonIgnore
    public Flow getFlowFromData() {
        Activity activity = this.getActivityDao().getById(this.getTask().getActivity().getId());
        return activity.getFlow();
    }

    /**
     * 判断任务是否已经持久化.
     * @return 是否已经持久化
     */
    @JsonIgnore
    public boolean getTaskIsNew() {
        this.task.setTaskDao(this.getTaskDao());
        return this.task.isNew();
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public List<Handleable> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Handleable> receivers) {
        this.receivers = receivers;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Post getHandler() {
        return handler;
    }

    public void setHandler(Post handler) {
        this.handler = handler;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    @JsonIgnore
    public ActivityDao getActivityDao() {
        return activityDao;
    }

    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @JsonIgnore
    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @JsonIgnore
    public FlowDao getFlowDao() {
        return flowDao;
    }

    public void setFlowDao(FlowDao flowDao) {
        this.flowDao = flowDao;
    }
}
