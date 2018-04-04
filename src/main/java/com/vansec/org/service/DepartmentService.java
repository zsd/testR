package com.vansec.org.service;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;

import java.util.List;
import java.util.Map;

/**
 * 部门服务接口.
 * @author zhousd
 */
public interface DepartmentService {

    /**
     * 根据机构ID获取部门.
     */
    Department getById(String id);

    /**
     * 保存.
     */
    void save(Department department);

    /**
     * 更新.
     */
    void update(Department department);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 批量删除部门.
     */
    void deleteIdStr(String idStr);

    /**
     * 分页查询.
     */
    Page<Department> search(Page<Department> page, Map<String, Object> param);

    List<Department> getByParentId(String parentId);
}
