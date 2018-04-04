package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Org;

import java.util.List;
import java.util.Map;

/**
 * 单位数据访问接口.
 * @author zhousd
 */
public interface OrgDao {

    /**
     * 根据单位ID获取单位.
     * @param id 单位ID
     * @return 单位
     */
    Org getById(String id);

    /**
     * 保存组织机构.
     */
    void save(Org org);

    /**
     * 更新组织机构.
     */
    void update(Org org);

    /**
     * 根据ID删除组织机构.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Org> search(Page<Org> page, Map<String, Object> param);

    List<Org> getAll();
}