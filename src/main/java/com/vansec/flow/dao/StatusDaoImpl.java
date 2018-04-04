package com.vansec.flow.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.flow.FlowModule;
import com.vansec.flow.dao.mapper.FlowMapper;
import com.vansec.flow.dao.mapper.StatusMapper;
import com.vansec.flow.domain.Flow;
import com.vansec.flow.domain.support.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 流转对象状态访问实现类.
 * @author zhousd
 */
@Repository
public class StatusDaoImpl implements StatusDao {

    @Autowired
    private StatusMapper statusMapper;

    @Override
    public void save(Status status) {
        statusMapper.insert(status);
    }

    @Override
    public Status getById(String id) {
        return statusMapper.getById(id);
    }

    @Override
    public List<Status> getByObjectTypeId(String objectTypeId) {
        return statusMapper.getByObjectTypeId(objectTypeId);
    }

    @Override
    public Status getNext(String currentId) {
        return statusMapper.getNext(currentId);
    }

    @Override
    public Status getPre(String currentId) {
        return statusMapper.getPre(currentId);
    }
}
