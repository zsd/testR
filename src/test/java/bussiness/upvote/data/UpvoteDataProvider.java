package bussiness.upvote.data;

import bussiness.remark.data.RemarkDataProvider;
import bussiness.upvote.domain.Upvote;
import com.vansec.comm.DataUtilsTest;
import com.vansec.user.data.UserDataProvider;

/**
 * 点赞测试数据提供类
 */
public class UpvoteDataProvider {

    private UpvoteDataProvider() {}

    /**
     * 生成数据.
     */
    public static Upvote getUpvote() {
        Upvote upvote = new Upvote();
        upvote.setId(DataUtilsTest.ID_1);
        upvote.setRemark(RemarkDataProvider.getRemark());
        upvote.setUser(UserDataProvider.getUser());
        return upvote;
    }
}
