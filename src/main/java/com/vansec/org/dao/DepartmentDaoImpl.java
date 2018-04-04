package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.dao.mapper.DepartmentMapper;
import com.vansec.org.dao.mapper.OrgMapper;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 单位数据访问类.
 * @author zhousd
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    private Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private OrgMapper orgMapper;

    @Override
    public Department getById(String id) {
        return departmentMapper.getById(id);
    }

    public void save(Department department) {
        departmentMapper.save(department);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void delete(String id) {
        departmentMapper.delete(id);
    }

    @Override
    public Page<Department> search(Page<Department> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        String orgId = param.get("orgId") == null ? null: param.get("orgId").toString();
        List<Department> lists = departmentMapper.search(name, orgId,skip, limit);
        //赋值单位名称
        for(Department department:lists){
            String id = department.getParent().getId();
            department.getParent().setName(orgMapper.getById(id).getName());
        }
        long count = departmentMapper.count(name,orgId);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public List<Department> getByParentId(String parentId) {
        return departmentMapper.getByParentId(parentId);
    }
}