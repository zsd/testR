package com.vansec.flow.domain.activity.line;

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
 * 上报活动.
 * @author zhousd
 */
public class ApprovalActivity extends LineActivity {
	
	private static Logger logger = LoggerFactory.getLogger(ApprovalActivity.class);
	
	public ApprovalActivity() {
		super();
		this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_APPROVAL));
	}

	public ApprovalActivity(Post handler, Task task, List<Handleable> receivers) {
		super(handler, task, receivers);
		this.setType(ActivityTypeFactory.get(ActivityTypeFactory.ID_APPROVAL));
	}

	@Override
	public void execute() {
        super.execute();
	}
}
