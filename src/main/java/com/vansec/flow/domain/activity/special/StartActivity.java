package com.vansec.flow.domain.activity.special;

import com.vansec.flow.domain.Flow;
import com.vansec.flow.domain.Task;
import com.vansec.flow.domain.activity.line.ApprovalActivity;
import com.vansec.flow.domain.support.ActivityType;
import com.vansec.flow.domain.support.ActivityTypeFactory;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.common.Handleable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 起始活动.<p/>
 * @author zhousd
 */
public class StartActivity extends ApprovalActivity {

    private static Logger logger = LoggerFactory.getLogger(StartActivity.class);

    public StartActivity() {
        super();
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_START));
    }

    public StartActivity(Post handler, Task task, List<Handleable> receivers) {
        super(handler, task, receivers);
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_START));
    }

    @Override
    public void execute() {
        //任务创建
        Task task = this.getTask();
        task.setHandler(this.getNextHandler());
        task.create(this);
        this.setTask(null);
        //流程创建
        Flow flow = new Flow();
        flow.create(this, task);
        //活动创建
        this.create();
    }

}
