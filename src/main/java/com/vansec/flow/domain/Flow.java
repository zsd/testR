package com.vansec.flow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.comm.utils.Identities;
import com.vansec.flow.dao.FlowDao;

/**
 * 流程实体.
 * @author xierh
 */
public class Flow extends EntityImpl {

    private Activity startActivity;//初始活动

    private Task currentTask;//当前任务

    private FlowDao flowDao; //活动持久化Dao工具

    public Flow() {
        super();
    }

    public void move(Activity activity, Task currentTask) {
        Activity tempActivity = this.update(activity);
        this.currentTask = currentTask;
        flowDao.update(this);
        tempActivity.setFlow(this);
    }

    public void create(Activity activity, Task task) {
        Activity tempActivity = this.update(activity);
        this.setId(Identities.uuid());
        this.startActivity = tempActivity;
        this.currentTask = task;
        flowDao.save(this);
        tempActivity.setFlow(this);
    }

    /**
     * 设置Dao工具.
     * @param activity 活动
     */
    private Activity update(Activity activity) {
        this.setFlowDao(activity.getFlowDao());
        return activity;
    }


    public Activity getStartActivity() {
        return startActivity;
    }

    public void setStartActivity(Activity startActivity) {
        this.startActivity = startActivity;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    @JsonIgnore
    public FlowDao getFlowDao() {
        return flowDao;
    }

    public void setFlowDao(FlowDao flowDao) {
        this.flowDao = flowDao;
    }
}
