package bussiness.upvote.dao;

import bussiness.upvote.domain.Upvote;
import com.vansec.comm.orm.Page;

import java.util.Map;

/**
 * 点赞数据访问类.
 * @author zhousd
 */
public interface UpvoteDao {

    /**
     * 根据ID获取.
     */
    Upvote getById(String id);

    /**
     * 保存.
     */
    void save(Upvote upvote);

    /**
     * 删除用户.
     */
    void delete(String id);
}