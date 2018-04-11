package bussiness.remark.dao;

import bussiness.work.domain.Work;
import com.vansec.comm.orm.Page;

import java.util.Map;

/**
 * 评论数据访问类.
 * @author zhousd
 */
public interface RemarkDao {

    /**
     * 根据ID获取.
     */
    Work getById(String id);

    /**
     * 保存.
     */
    void save(Work work);

    /**
     * 更新用户.
     */
    void update(Work work);

    /**
     * 删除用户.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Work> search(Page<Work> page, Map<String, Object> param);
}