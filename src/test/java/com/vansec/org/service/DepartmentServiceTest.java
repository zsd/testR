package com.vansec.org.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.comm.orm.Page;
import com.vansec.dic.service.DicService;
import com.vansec.org.data.DepartmentDataProvider;
import com.vansec.org.data.OrgDataProvider;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 岗位服务测试用例.
 * @author zhousd
 */
public class DepartmentServiceTest extends AbstractTest {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest(){
        Department department = DepartmentDataProvider.getDepartment1();
        departmentService.save(department);
    }

    /**
     * 查询测试.
     */
    @Test
    public void getByIdTest(){
        Department department = departmentService.getById(DataUtils.ID_1);
        Assert.notNull(department);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest(){
        Department department = departmentService.getById(DataUtils.ID_1);
        department.setName("修改部门名称");
        departmentService.update(department);
    }
    /**
     * 更新测试.
     */
    @Test
    public void deleteTest(){
        departmentService.delete(DataUtils.ID_1);
        Department department = departmentService.getById(DataUtils.ID_1);
        Assert.isNull(department);
    }

    /**
     * 分页查询.
     */
    @Test
    public void searchTest() {
        Page<Department> departments = new Page<>();
        Map<String, Object> param = new HashMap<>();
        departmentService.search(departments, param);
        Assert.notNull(departments);
    }

}
