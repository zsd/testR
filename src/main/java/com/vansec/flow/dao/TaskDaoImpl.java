package com.vansec.flow.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.orm.Page;
import com.vansec.flow.FlowModule;
import com.vansec.flow.dao.mapper.TaskMapper;
import com.vansec.flow.domain.Task;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 任务数据访问实现类.
 * @author xierh
 */
@Repository
public class TaskDaoImpl implements TaskDao {

    private static Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private TaskMapper mapper;

    @Override
    public void insert(Task task) {
        try {
           mapper.insert(task);
        } catch (Exception e) {
            logger.error("insert task error!", e);
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_INSERT, e);
        }
    }

    @Override
    public void update(Task task) {
        try {
            mapper.update(task);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_UPDATE, e);
        }
    }

    @Override
    public void read(int isReaded, String id) {
        try {
            mapper.read(isReaded, id);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_READ, e);
        }
    }

    @Override
    public Task getById(String id) {
        try {
            Task task = mapper.getById(id);
            if (task != null && task.getActivity() != null) {
                task.setActivity(activityDao.getById(task.getActivity().getId()));
            }
            return task;
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_GETBYID, e);
        }
    }

    @Override
    public Page<Task> search(Page<Task> page, Map<String, Object> param) {
        try {
            int skip = (page.getPageNo() - 1) * page.getPageSize();
            int limit = page.getPageSize();
            int objectType = 1;
            List<Task> taskList = mapper.search(objectType, skip, limit);
            long count = mapper.count(objectType, skip, limit);
            page.setResult(taskList);
            page.setTotalCount(count);
            return page;
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_SEARCH, e);
        }
    }

    @Override
    public List<Task> getByObjectId(String objectId) {
        try {
            List<Task> taskList = new ArrayList<>();
            if (StringUtils.isNotBlank(objectId)) {
                taskList = mapper.getByObjectId(objectId);
            }
            return taskList;
        } catch (Exception e) {
            logger.error("Get task by object id!", e);
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_GETBYOBJECTID, e);
        }
    }

    @Override
    public Task getLastTaskByObjectId(String objectId) {
        try {
            logger.debug("the objectId is {}", objectId);
//            Task task = mapper.getLastTaskByObjectId(objectId);
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(FlowModule.ERR_DAO_TASK_GETLASTTASKBYOBJECTID, e);
        }
    }

    @Override
    public Task getByActivityId(String activityId) {
        Task task = mapper.getByActivityId(activityId);
        return task;
    }
}
