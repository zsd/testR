package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;

import java.util.List;
import java.util.Map;

/**
 * 单位数据访问接口.
 * @author zhousd
 */
public interface DepartmentDao {

    /**
     * 根据ID获取部门.
     */
    Department getById(String id);

    /**
     * 保存组织机构.
     */
    void save(Department department);

    /**
     * 更新.
     */
    void update(Department department);

    /**
     * 根据ID删除.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Department> search(Page<Department> page, Map<String, Object> param);

    List<Department> getByParentId(String parentId);
}