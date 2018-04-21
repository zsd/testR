package bussiness.upvote.domain;

import bussiness.remark.domain.Remark;
import bussiness.work.domain.Work;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.user.domain.User;

/**
 * 点赞实体.
 * @author zhousd
 */
public class Upvote extends EntityImpl {

    private Remark remark; // 作品

    private User user; // 点赞用户

    public Remark getRemark() {
        return remark;
    }

    public void setRemark(Remark remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
