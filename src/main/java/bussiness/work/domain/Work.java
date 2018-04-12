package bussiness.work.domain;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.user.domain.User;

/**
 * 作品实体.
 * @author zhousd
 */
public class Work extends EntityImpl {

    private String content; // 内容

    private String url; // 链接

    private String type; // 作品类型

    private int rewardMoney; // 悬赏金额

    private int rewardPoints; // 悬赏积分

    private int setCount; // 设定总人数

    private float score; // 作品得分

    private User user; // 发布人

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public void setRewardMoney(int rewardMoney) {
        this.rewardMoney = rewardMoney;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public int getSetCount() {
        return setCount;
    }

    public void setSetCount(int setCount) {
        this.setCount = setCount;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
