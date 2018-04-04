package com.vansec.function.dao;

import com.vansec.dic.dao.mapper.DicMapper;
import com.vansec.function.dao.mapper.FunctionMapper;
import com.vansec.function.domain.Function;
import com.vansec.function.domain.TreeNode;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能数据访问实现类.
 * @author huangfx
 */
@Repository
public class FunctionDaoImpl  implements FunctionDao{

    private static Logger logger = LoggerFactory.getLogger(FunctionDaoImpl.class);

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public List<Function> getByParentId(String parentId) {
        return functionMapper.getByParentId(parentId);
    }

    @Override
    public void save(Function function) {
        functionMapper.save(function);
    }

    @Override
    public void update(Function function) {
        functionMapper.update(function);
    }

    @Override
    public void delete(String id) {
        functionMapper.delete(id);
    }

    @Override
    public void deleteByParent(List<String> list) {
        functionMapper.deleteByParent(list);
    }

    @Override
    public List<TreeNode> getAllNode(){ return functionMapper.getAllNode();}

    @Override
    public List<Function> getByPostId(String postId, String parentId) {
        return functionMapper.getByPostId(postId,parentId);
    }

    @Override
    public long checkedCode(String id, String code) {
        return functionMapper.checkedCode(id,code);
    }

    @Override
    public List<Function> getButtonByPostId( String userId) {
        return functionMapper.getButtonByPostId(userId);
    }
}
