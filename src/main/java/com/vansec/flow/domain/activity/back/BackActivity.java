package com.vansec.flow.domain.activity.back;

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
 * 退回活动.
 * @author zhousd
 */
public class BackActivity extends Activity {

	private static Logger logger = LoggerFactory.getLogger(BackActivity.class);

	public BackActivity() {
		super();
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_BACK));
	}

	public BackActivity(Post handler, Task task, List<Handleable> receivers) {
		super(handler, task, receivers);
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_BACK));
	}

	@Override
	public void execute() {

        Task task = this.getTask();
        task.done(this);
        Handleable handler = null;
        Task newTask = new Task(this.getTask().getTaskObject(), handler);
        newTask.create(this);

        Flow flow = this.getFlowFromData();
        flow.move(this, newTask);

        this.create();
	}

    @Override
    public Handleable getNextHandler() {
        return null;
    }
}
