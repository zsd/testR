package com.vansec.org.data;

import com.vansec.comm.DataUtils;
import com.vansec.org.domain.Org;

/**
 * 单位测试数据提供类.
 */
public class OrgDataProvider {

    private OrgDataProvider() {}

    public static Org getOrg1() {
        Org org = new Org();
        org.setId(DataUtils.ID_1);
        org.setName("测试单位_001");
        return org;
    }

    public static Org getOrg2() {
        Org org = new Org();
        org.setId("UTU_002");
        org.setName("测试单位_002");
        return org;
    }

    public static Org getOrg3() {
        Org org = new Org();
        org.setId("UTU_003");
        org.setName("测试单位_003");
        return org;
    }
}
