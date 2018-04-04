package com.vansec.flow.service;

import com.vansec.flow.dao.ActivityDao;
import com.vansec.flow.domain.Activity;
import com.vansec.org.domain.common.Handleable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 活动服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> getByFlowId(String flowId) {
        List<Activity> activityList = activityDao.getByFlowId(flowId);
        return activityList;
    }
}
