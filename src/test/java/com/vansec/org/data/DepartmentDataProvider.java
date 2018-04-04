package com.vansec.org.data;

import com.vansec.comm.DataUtils;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;

/**
 * 单位测试数据提供类.
 */
public class DepartmentDataProvider {

    public static Department getDepartment1() {
        Department department = new Department();
        department.setId(DataUtils.ID_1);
        department.setName("测试部门_001");
        department.setParent(OrgDataProvider.getOrg1());
        return department;
    }

    private DepartmentDataProvider() {}

}
