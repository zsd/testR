package com.vansec.flow.service;

import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.JsonMapper;
import com.vansec.flow.FlowModule;
import com.vansec.flow.dao.TaskDao;
import com.vansec.flow.domain.Task;
import com.vansec.org.domain.common.Handleable;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 任务服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private static Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskDao taskDao;

    @Override
    public void checkError(Task task, Handleable handler){
        Handleable taskHandler = task.getHandler();
        if (ObjectUtils.equals(task.getIsDo(), Task.ISDO_YES)) {
            throw new ServiceException(FlowModule.ERR_TASKSERVICE_CHECKERROR_ISDO);
        }
        return ;
    }

    @Override
    public Page<Task> search(Page<Task> page, Map<String, Object> param) throws ServiceException {
        return taskDao.search(page, param);
    }

    @Override
    public Task getByObjectId(String objectId) {
        List<Task> taskList = taskDao.getByObjectId(objectId);
        Task task = null;
        if (CollectionUtils.isNotEmpty(taskList)) {
            task = taskList.get(taskList.size()-1);
        }
        return task;
    }

    @Override
    public Task getLastTaskByObjectId(String objectId) {
        /*List<Task> taskList = taskDao.getByObjectId(objectId);
        Task task = null;
        if (CollectionUtils.isNotEmpty(taskList)) {
            task = taskList.get(0);
        }*/
        return taskDao.getLastTaskByObjectId(objectId);
    }

    @Override
    public Task getById(String id) {
        Task task = taskDao.getById(id);
        return task;
    }

    @Override
    public Task getById(String id, TaskObjectService taskObjectService) {
        Task task = taskDao.getById(id);
        if (task != null && task.getTaskObject() != null) {
            task.setTaskObject(taskObjectService.getById(id));
        }
        return task;
    }
}
