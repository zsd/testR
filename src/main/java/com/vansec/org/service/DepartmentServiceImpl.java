package com.vansec.org.service;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.org.OrgModule;
import com.vansec.org.dao.DepartmentDao;
import com.vansec.org.domain.Department;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 部门服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department getById(String id) {
        try {
            Department department = departmentDao.getById(id);
            return department;
        } catch (Exception e) {
            logger.error("get department by id error!", e);
            throw new DataAccessException(OrgModule.ERR_SEV_ORG_GETBYID, e);
        }

    }

    @Override
    public void save(Department department) {
        if (department != null && StringUtils.isEmpty(department.getId())) {
            department.setId(Identities.uuid());
        }
        departmentDao.save(department);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(String id) {
        departmentDao.delete(id);
    }

    @Override
    public void deleteIdStr(String idStr) {
        if (StringUtils.isBlank(idStr)) {
            return;
        }
        String[] ids = idStr.split(",");
        for (String id : ids) {
            this.delete(id);
        }
    }

    @Override
    public Page<Department> search(Page<Department> page, Map<String, Object> param) {
        return departmentDao.search(page, param);
    }

    @Override
    public List<Department> getByParentId(String parentId) {
        return departmentDao.getByParentId(parentId);
    }

}
