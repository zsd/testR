package bussiness.upvote.service;

import bussiness.upvote.data.UpvoteDataProvider;
import bussiness.upvote.domain.Upvote;
import com.vansec.AbstractTest;
import com.vansec.comm.DataUtilsTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 点赞服务测试类.
 */
public class UpvoteServiceTest extends AbstractTest {

    @Autowired
    private UpvoteService upvoteService;

    /**
     * 保存测试.
     */
    @Test
    public void saveTest() {
        Upvote upvote = UpvoteDataProvider.getUpvote();
        upvoteService.save(upvote);
    }

    /**
     * 根据ID获取测试.
     */
    @Test
    public void getByIdTest() {
        Upvote upvote = upvoteService.getById(DataUtilsTest.ID_1);
        Assert.assertNotNull(upvote);
    }

    /**
     * 根据ID删除测试.
     */
    @Test
    public void deleteTest() {
        upvoteService.delete(DataUtilsTest.ID_1);
        Upvote upvote = upvoteService.getById(DataUtilsTest.ID_1);
        Assert.assertNull(upvote);
    }
}
