package bussiness.remark.data;

import bussiness.remark.domain.Remark;
import bussiness.work.data.WorkDataProvider;
import com.vansec.comm.DataUtilsTest;
import com.vansec.user.data.UserDataProvider;

/**
 * 评论测试数据提供类
 */
public class RemarkDataProvider {

    private RemarkDataProvider() {}

    /**
     * 生成数据.
     */
    public static Remark getRemark() {
        Remark remark = new Remark();
        remark.setId(DataUtilsTest.ID_1);
        remark.setContent("作品内容");
        remark.setWork(WorkDataProvider.getWork());
        remark.setLikeCount(10);
        remark.setUser(UserDataProvider.getUser());
        return remark;
    }
}
