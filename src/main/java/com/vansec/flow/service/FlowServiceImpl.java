package com.vansec.flow.service;

import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.utils.Identities;
import com.vansec.flow.dao.ActivityDao;
import com.vansec.flow.dao.FlowDao;
import com.vansec.flow.dao.TaskDao;
import com.vansec.flow.domain.Activity;
import com.vansec.flow.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class FlowServiceImpl implements FlowService {

    private static Logger logger = LoggerFactory.getLogger(FlowServiceImpl.class);

    @Autowired
    private FlowDao flowDao;

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskService taskService;

    @Override
    public void execute(Activity activity) {
        logger.debug("Flow start!");
        this.beforeExecute(activity);
        activity.execute();
    }

    /**
     * 活动执行前执行.
     * @param activity 当前执行的活动
     */
    private void beforeExecute(Activity activity) {
//        checkError(activity);
        setDataService(activity);
        activity.setId(Identities.uuid());
    }

    /**
     * 检查任务数据是否错误.
     */
    private void checkError(Activity activity) {
        Task task = activity.getTask();
        taskService.checkError(task, SecurityContextHolder.getPost());
    }

    /**
     * 设入活动涉及的数据操作工具类.
     * @param activity 当前活动
     */
    private void setDataService(Activity activity) {
        activity.setTaskDao(taskDao);
        activity.setActivityDao(activityDao);
        activity.setFlowDao(flowDao);
    }

}
