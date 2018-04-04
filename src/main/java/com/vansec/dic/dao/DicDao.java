package com.vansec.dic.dao;

import com.vansec.comm.orm.Page;
import com.vansec.dic.domain.Dic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 字典管理数据管理类.
 * @author zhousd
 */
public interface DicDao {

    /**
     * 根据主键获取Dic.
     */
    Dic getById(String id);

    /**
     * 保存.
     */
    void save(Dic dic);

    /**
     * 更新.
     */
    void update(Dic dic);

    /**
     * 根据ID删除字典.
     */
    void delete(String id);

    /**
     * 根据父节点id查找所有子节点
     * @param parentId 父节点ID
     * @return
     */
    List<Dic> getByParentId(String parentId);

    /**
     * 根据字典名称查找字典
     * @param item 字典名
     * @return
     */
    List<Dic> getByItem(String item);
}
