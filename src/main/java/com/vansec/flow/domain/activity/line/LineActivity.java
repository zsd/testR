package com.vansec.flow.domain.activity.line;

import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.Flow;
import com.vansec.flow.domain.Task;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.common.Handleable;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * 线性活动.
 * @author zhousd
 */
public abstract class LineActivity extends Activity {
	
	public LineActivity() {
		super();
	}

	public LineActivity(Post handler, Task task, List<Handleable> receivers) {
		super(handler, task, receivers);
	}

	@Override
	public void execute() {

        // 前一个任务设置为已办
        Task task = this.getTask();
        task.done(this);

        Handleable handler = this.getNextHandler();
        Task newTask = new Task(this.getTask().getTaskObject(), handler);
        newTask.create(this);

        Flow flow = this.getFlowFromData();
        flow.move(this, newTask);

        this.create();
    }

    @Override
    public Handleable getNextHandler() {
        Handleable handler = null;
        if (CollectionUtils.isNotEmpty(this.getReceivers())) {
            handler = this.getReceivers().get(0);
        }
        return handler;
    }

}
