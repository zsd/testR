package com.vansec.flow.service;

import com.vansec.comm.exception.ServiceException;
import com.vansec.comm.utils.Identities;
import com.vansec.flow.dao.StatusDao;
import com.vansec.flow.domain.support.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 流转对象状态实现类.
 * @author zhousd
 */
@Service
@Transactional
public class StatusServiceImpl implements StatusService {

    private static Logger logger = LoggerFactory.getLogger(StatusServiceImpl.class);

    @Autowired
    private StatusDao statusDao;

    @Override
    public void save(Status status) {
        try {
            if (StringUtils.isEmpty(status.getId())) {
                status.setId(Identities.uuid());
            }
            statusDao.save(status);
        } catch (Exception e) {
            logger.error("save status error!", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Status getById(String id) {
        try {
            return statusDao.getById(id);
        } catch (Exception e) {
            logger.error("Get status by id error!", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Status> getByObjectTypeId(String objectTypeId) {
        try {
            return statusDao.getByObjectTypeId(objectTypeId);
        } catch (Exception e) {
            logger.error("get status by id error!", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Status getNext(String currentId) {
        try {
            return statusDao.getNext(currentId);
        } catch (Exception e) {
            logger.error("Get next status by current id error!", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Status getPre(String currentId) {
        try {
            return statusDao.getPre(currentId);
        } catch (Exception e) {
            logger.error("Get pre status by current id error!", e);
            throw new ServiceException(e);
        }
    }
}
