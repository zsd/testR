package bussiness.upvote.data;

import bussiness.upvote.domain.Upvote;
import bussiness.work.data.WorkDataProvider;
import com.vansec.comm.DataUtils;
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
        upvote.setId(DataUtils.ID_1);
        upvote.setWork(WorkDataProvider.getWork());
        upvote.setUser(UserDataProvider.getUser());
        return upvote;
    }
}
