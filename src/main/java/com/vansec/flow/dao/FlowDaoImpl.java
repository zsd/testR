package com.vansec.flow.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.flow.FlowModule;
import com.vansec.flow.dao.mapper.FlowMapper;
import com.vansec.flow.domain.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 流程数据访问实现类.
 * @author xierh
 */
@Repository
public class FlowDaoImpl implements FlowDao {

    @Autowired
    private FlowMapper mapper;

    @Override
    public void update(Flow flow) {
        try{
            mapper.update(flow);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_FLOW_UPDATE, e);
        }
    }

    @Override
    public void save(Flow flow) {
        try {
            mapper.save(flow);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_FLOW_SAVE, e);
        }
    }

    @Override
    public Flow getById(String id) {
        try {
            return mapper.getById(id);
        } catch (Exception e) {
            throw new DataAccessException(FlowModule.ERR_DAO_FLOW_GETBYID, e);
        }
    }
}
