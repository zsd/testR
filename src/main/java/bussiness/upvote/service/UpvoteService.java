package bussiness.upvote.service;

import bussiness.upvote.domain.Upvote;
import com.vansec.comm.orm.Page;

import java.util.Map;

/**
 * 点赞服务接口.
 * @author zhousd
 */
public interface UpvoteService {

    /**
     * 根据id获取.
     */
    Upvote getById(String id);

    /**
     * 保存.
     */
    void save(Upvote upvote);

    /**
     * 更新.
     */
    void update(Upvote upvote);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 批量删除.
     */
    void deleteIdStr(String idStr);

    /**
     * 分页列表.
     */
    Page<Upvote> search(Page<Upvote> page, Map<String, Object> param);
}
