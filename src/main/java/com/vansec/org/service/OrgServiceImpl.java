package com.vansec.org.service;

import com.vansec.comm.exception.DataAccessException;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.org.OrgModule;
import com.vansec.org.dao.OrgDao;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组织机构服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class OrgServiceImpl implements OrgService {

    private Logger logger = LoggerFactory.getLogger(OrgServiceImpl.class);

    @Autowired
    private OrgDao orgDao;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;

    @Override
    public Org getById(String id) {
        try {
            Org org = orgDao.getById(id);
            return org;
        } catch (Exception e) {
            logger.error("get org by id error!", e);
            throw new DataAccessException(OrgModule.ERR_SEV_ORG_GETBYID, e);
        }

    }

    @Override
    public void save(Org org) {
        if (org != null && StringUtils.isEmpty(org.getId())) {
            org.setId(Identities.uuid());
        }
        orgDao.save(org);
    }

    @Override
    public void update(Org org) {
        orgDao.update(org);
    }

    @Override
    public void delete(String id) {
        orgDao.delete(id);
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
    public Page<Org> search(Page<Org> page, Map<String, Object> param) {
        return orgDao.search(page, param);
    }

    @Override
    public List<Org> getAll() {
        List<Org> orgs = orgDao.getAll();
        for (Org org : orgs) {
            List<Department> departments = departmentService.getByParentId(org.getId());
            org.setDepartments(departments);
            for (Department department : departments) {
                List<User> users = userService.getByDepartmentId(department.getId());
                department.setUsers(users);
            }
        }
        return orgs;
    }

}
