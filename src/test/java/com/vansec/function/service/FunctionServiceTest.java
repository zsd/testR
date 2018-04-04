package com.vansec.function.service;

import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import com.vansec.frontset.service.LoginService;
import com.vansec.function.domain.Function;
import com.vansec.function.domain.TreeNode;
import com.vansec.org.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 黄辅湘 on 2016/6/22.
 */
public class FunctionServiceTest   extends AbstractTest {
    @Autowired
    private FunctionService functionService;

    private String id ;

    /**
     * 登录测试.
     */
    @Test
    public void saveTest(){
        Function Function = new Function("111111", "2222","2","2","2",2,"85be7590ed544b41b1bf8d35342fc3c9","1");
        functionService.save(Function);
    }

    @Test
    public void getByParentIdTest(){
        List<Function> list = functionService.getByParentId("root");
    }

    @Test
    public void updateTest(){
        Function function = new Function("扶贫对象", "123","2","2","2",21,"","2");
        function.setId("85be7590ed544b41b1bf8d35342fc3c9");
        functionService.update(function);
    }

    @Test
    public void deleteTest(){
        Function Function = new Function("扶贫对象", "123","1","1","1",1,"root","1");
        functionService.delete("8b2965306cb5440c835d47efc1bf67ee");
    }

    @Test
    public void selectNode(){
        List<TreeNode> treeNodes = functionService.getAllNode();
    }

    @Test
    public void getByPostId() {
        List<Function> functionList = functionService.getByPostId(DataUtils.ID_1, "root");
        Assert.assertNotNull(functionList);
    }
}
