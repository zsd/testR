package com.vansec.org.dao.mapper;

import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {

    /**
     * 根据单位ID获取部门.
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
     * 根据ID删除.
     */
    void delete(String id);

    /**
     * 分页列表-列表.
     */
    List<Department> search(@Param("name") String name, @Param("orgId") String orgId, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 分页列表-数量.
     */
    long count(@Param("name") String name, @Param("orgId") String orgId);

    List<Department> getByParentId(String parentId);
}
