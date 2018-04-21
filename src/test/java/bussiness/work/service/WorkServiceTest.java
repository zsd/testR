package bussiness.work.service;

import bussiness.work.data.WorkDataProvider;
import bussiness.work.domain.Work;
import com.vansec.AbstractTest;
import com.vansec.comm.DataUtilsTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 作品服务测试类.
 */
public class WorkServiceTest extends AbstractTest {

    @Autowired
    private WorkService workService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest() {
        Work work = WorkDataProvider.getWork();
        workService.save(work);
    }

    /**
     * 根据ID获取测试.
     */
    @Test
    public void getByIdTest() {
        Work work = workService.getById(DataUtilsTest.ID_1);
        Assert.assertNotNull(work);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest() {
        Work work = workService.getById(DataUtilsTest.ID_1);
        work.setName("测试修改标题");
        workService.update(work);
    }

    /**
     * 根据ID删除测试.
     */
    @Test
    public void deleteTest() {
        workService.delete(DataUtilsTest.ID_1);
        Work work = workService.getById(DataUtilsTest.ID_1);
        Assert.assertNull(work);
    }
}
