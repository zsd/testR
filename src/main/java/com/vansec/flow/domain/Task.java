package com.vansec.flow.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.comm.utils.Identities;
import com.vansec.flow.dao.TaskDao;
import com.vansec.flow.domain.support.Status;
import com.vansec.org.domain.common.Handleable;

/**
 * 任务实体.
 * @author xierh
 */
public class Task extends EntityImpl {

    private Handleable handler; //处理人

    private Activity activity; //活动对象

    private TaskObject taskObject; //流转对象

    private int isDo = ISDO_NO; //是否已办

    private int isReaded = ISREADED_NO ; //是否已读

    private TaskDao taskDao; //任务持久层工具类

    public static final int ISDO_NO = 0; // 是否已办，未办
    public static final int ISDO_YES = 1; // 是否已办，已办

    public static final int ISREADED_NO = 0; // 是否已读，未读
    public static final int ISREADED_YES = 1; // 是否已读，已读

    public Task() {
        super();
    }

    public Task(TaskObject taskObject, Handleable handler) {
        this();
        this.taskObject = taskObject;
        this.handler = handler;
    }

    public void create(Activity activity) {
        Activity tempActivity = this.update(activity);
        this.setId(Identities.uuid());
        this.activity = tempActivity;
        taskDao.insert(this);
    }

    public void done(Activity activity) {
        this.update(activity);
        this.isDo = ISDO_YES;
        taskDao.update(this);
    }

    /**
     * 任务是否已经被持久化.
     * @return 是否被持久化
     */
    @JsonIgnore
    public boolean isNew() {
        boolean isNew = false;
        if (this.taskDao.getById(this.getId()) == null) {
            isNew = true;
        }
        return isNew;
    }

    /**
     * 设置Dao工具.
     * @param activity 活动
     */
    private Activity update(Activity activity) {
        this.taskDao = activity.getTaskDao();
        return activity;
    }

    public int getIsDo() {
        return isDo;
    }

    public void setIsDo(int isDo) {
        this.isDo = isDo;
    }

    public Handleable getHandler() {
        return handler;
    }

    public void setHandler(Handleable handler) {
        this.handler = handler;
    }

    public int getIsReaded() {
        return isReaded;
    }

    public void setIsReaded(int isReaded) {
        this.isReaded = isReaded;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TaskObject getTaskObject() {
        return taskObject;
    }

    public void setTaskObject(TaskObject taskObject) {
        this.taskObject = taskObject;
    }

    @JsonIgnore
    public TaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
