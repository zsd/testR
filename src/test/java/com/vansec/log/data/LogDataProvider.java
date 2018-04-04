package com.vansec.log.data;

import bussiness.comm.ClientFactory;
import bussiness.comm.ModuleFactory;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.example.domain.Example;
import com.vansec.location.domain.Gps;
import com.vansec.comm.domain.Client;
import com.vansec.log.domain.Log;
import com.vansec.comm.domain.Module;
import com.vansec.org.data.PostDataProvider;
import com.vansec.org.domain.Post;

/**
 * 业务日志测试数据提供类.
 * @author zhousd
 */
public final class LogDataProvider {

    /**
     * 生成业务日志实体.
     */
    public static Log getLog() {
        Module module = ModuleFactory.getModule(ModuleFactory.ID_EXAMPLE);
        Example obj = new Example();
        obj.setId("1");
        obj.setName("测试示例");
        Gps gps = new Gps();
        gps.setLongitude("110");
        gps.setLatitude("20");
        Post post = PostDataProvider.post1();
        Client client = ClientFactory.getClient(ClientFactory.TYPE_PC_WEB);
        return new Log(Log.TYPE_ADD, "新增一条地名地址信息", "1.1.1.1", module, obj, post, gps, client);
    }

    private LogDataProvider() {}

}
