package com.vansec.example.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.vansec.AbstractTest;
import com.vansec.comm.orm.Page;
import com.vansec.example.domain.Example;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 示例程序测试类.
 */
public class ExampleServiceTest extends AbstractTest {

    @Autowired
    private ExampleService exampleService;
    
    private Page<Example> resultPage = null;
    private Example example = null;
    
    /**
     * 查询测试.
     */
    @Test
    public void searchTest(){
        Page<Example> page = new Page<>();
        Map<String, Object> param = new HashMap<>();
        resultPage = exampleService.search(page, param);
        Assert.assertNotNull(resultPage);
    }
    
    /**
     * 获取单个对象测试.
     */
    @Test
    public void getTest(){
        searchTest();
        example = exampleService.get(resultPage.getResult().get(0).getId());
        Assert.assertNotNull(example);
    }
    
    /**
     * 删除测试.
     */
    @Test
    public void deleteTest(){
        getTest();
        exampleService.delete(example.getId());
        Example e = exampleService.get(example.getId());
        Assert.assertNull(e);
    }
    
    /**
     * 插入/更新测试.
     */
    @Test
    public void saveTest(){
        Example newExample = new Example();
        newExample.setName("mars");
        newExample.setGender("");
        Boolean result = exampleService.save(newExample);
        Assert.assertTrue(result);
    }

}
