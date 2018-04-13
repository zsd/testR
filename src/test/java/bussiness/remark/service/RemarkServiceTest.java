package bussiness.remark.service;

import bussiness.remark.data.RemarkDataProvider;
import bussiness.remark.domain.Remark;
import com.vansec.AbstractTest;
import com.vansec.comm.DataUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 评论服务测试类.
 */
public class RemarkServiceTest extends AbstractTest {

    @Autowired
    private RemarkService remarkService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest() {
        Remark remark = RemarkDataProvider.getRemark();
        remarkService.save(remark);
    }

    /**
     * 根据ID获取测试.
     */
    @Test
    public void getByIdTest() {
        Remark remark = remarkService.getById(DataUtils.ID_1);
        Assert.assertNotNull(remark);
    }

    /**
     * 更新测试.
     */
    @Test
    public void updateTest() {
        Remark remark = remarkService.getById(DataUtils.ID_1);
        remark.setContent("测试修改标题");
        remarkService.update(remark);
    }

    /**
     * 根据ID删除测试.
     */
    @Test
    public void deleteTest() {
        remarkService.delete(DataUtils.ID_1);
        Remark work = remarkService.getById(DataUtils.ID_1);
        Assert.assertNull(work);
    }
}
