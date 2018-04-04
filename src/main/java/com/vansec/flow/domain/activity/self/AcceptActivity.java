package com.vansec.flow.domain.activity.self;

import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.Flow;
import com.vansec.flow.domain.Task;
import com.vansec.flow.domain.support.ActivityType;
import com.vansec.flow.domain.support.ActivityTypeFactory;
import com.vansec.flow.domain.support.Status;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.common.Handleable;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 受理活动.
 * @author xierh
 */
public class AcceptActivity extends Activity {

    private static Logger logger = LoggerFactory.getLogger(AcceptActivity.class);

    public AcceptActivity() {
        super();
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_ACCEPT));
    }

    public AcceptActivity(Post handler, Task task, List<Handleable> receivers) {
        super(handler, task, receivers);
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_ACCEPT));
    }

    @Override
    public void execute() {

        // 前一个任务设置为已办
        Task task = this.getTask();
        task.done(this);

        //任务创建
        Task newTask = new Task(this.getTask().getTaskObject(), this.getHandler());
        newTask.setIsReaded(Task.ISREADED_YES);
        newTask.create(this);

        //流程移动
        Flow flow = this.getFlowFromData();
        flow.move(this, newTask);

        //活动创建
        this.create();
    }
}
