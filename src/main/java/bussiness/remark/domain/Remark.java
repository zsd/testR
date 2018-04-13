package bussiness.remark.domain;

import bussiness.work.domain.Work;
import com.vansec.comm.domain.EntityImpl;
import com.vansec.user.domain.User;

/**
 * 评论实体.
 * @author zhousd
 */
public class Remark extends EntityImpl {

    private String content; // 内容

    private int likeCount; // 点赞数

    private Work work; // 作品

    private User user; // 发布人

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

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
