package bussiness.upvote.domain;

import bussiness.work.domain.Work;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.user.domain.User;

/**
 * 点赞实体.
 * @author zhousd
 */
public class Upvote extends EntityImpl {

    private Work work; // 作品

    private User user; // 点赞用户

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
