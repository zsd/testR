package com.vansec.flow.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.flow.FlowModule;
import com.vansec.flow.dao.mapper.ActivityMapper;
import com.vansec.flow.domain.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 活动数据访问实现类.
 * @author xierh
 */
@Repository
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private FlowDao flowDao;

    @Autowired
    private ActivityMapper mapper;

    @Override
    public void save(Activity activity) {
        try{
            mapper.insert(activity);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_ACTIVITY_SAVE, e);
        }
    }

    @Override
    public Activity getById(String id) {
        try{
            Activity activity = mapper.getById(id);
            if(activity !=null && activity.getFlow()!= null) {
                activity.setFlow(flowDao.getById(activity.getFlow().getId()));
            }
            return activity;
        } catch (Exception e){
            throw new DataAccessException(FlowModule.ERR_DAO_ACTIVITY_GETBYID, e);
        }

    }

    @Override
    public List<Activity> getByFlowId(String flowId) {
        try{
            return mapper.getByFlowId(flowId);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_ACTIVITY_GETBYFLOWID, e);
        }
    }

    @Override
    public Activity getStartActivityByFlowId(String flowId) {
        try {
//            return mapper.getStartActivityByFlowId(flowId);
            return null;
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_ACTIVITY_GETSTARTACTIVITYBYFLOWID, e);
        }
    }

    @Override
    public Activity getStartActivityById(String id) {
        try {
//            return mapper.getStartActivityById(id);
            return null;
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_ACTIVITY_GETSTARTACTIVITYBYID, e);
        }
    }
}
