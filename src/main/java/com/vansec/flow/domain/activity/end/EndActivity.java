package com.vansec.flow.domain.activity.end;

import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.Flow;
import com.vansec.flow.domain.Task;
import com.vansec.flow.domain.support.ActivityType;
import com.vansec.flow.domain.support.ActivityTypeFactory;
import com.vansec.flow.domain.support.Status;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.common.Handleable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 办结活动.
 * @author zhousd
 */
public class EndActivity extends Activity {

	private static Logger logger = LoggerFactory.getLogger(EndActivity.class);

	public EndActivity() {
		super();
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_END));
	}

	public EndActivity(Post handler, Task task, List<Handleable> receivers) {
		super(handler, task, receivers);
        this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_END));
	}

	@Override
	public void execute() {
        Task task = this.getTask();
        task.done(this);
        Flow flow = this.getFlowFromData();
        flow.move(this, task);
        this.create();
	}
}
