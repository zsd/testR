package com.vansec.dic.dao;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.orm.Page;
import com.vansec.dic.DicModule;
import com.vansec.dic.dao.mapper.DicMapper;
import com.vansec.dic.domain.Dic;
import com.vansec.dic.service.DicServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 字典管理数据访问实现类.
 * @author zhousd
 */
@Repository
public class DicDaoImpl implements DicDao {

    private static Logger logger = LoggerFactory.getLogger(DicDaoImpl.class);

    @Autowired
    private DicMapper dicMapper;

    @Override
    public Dic getById(String id) {
        try {
            return dicMapper.getById(id);
        } catch (Exception e) {
            logger.debug("Get dic by id error!", e);
            throw new DataAccessException(DicModule.ERR_DAO_GETBYID, e);
        }
    }

    @Override
    public void save(Dic dic) {
        try {
            dicMapper.save(dic);
        } catch (Exception e) {
            logger.debug("Save dic error!", e);
            throw new DataAccessException(DicModule.ERR_DAO_GETBYITEM, e);
        }

    }

    @Override
    public void update(Dic dic) {
        try {
            dicMapper.update(dic);
        } catch (Exception e) {
            logger.debug("Update dic error!", e);
            throw new DataAccessException(DicModule.ERR_DAO_UPDATE, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            dicMapper.delete(id);
        } catch (Exception e) {
            logger.debug("Delete dic error!", e);
            throw new DataAccessException(DicModule.ERR_DAO_DEL, e);
        }
    }

    @Override
    public List<Dic> getByParentId(String parentId){
        return dicMapper.getByParentId(parentId);
    }

    @Override
    public List<Dic> getByItem(String item){
        return dicMapper.getByItem(item);
    }
}