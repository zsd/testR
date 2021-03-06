package bussiness.remark.dao;

import bussiness.remark.domain.Remark;
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
    Remark getById(String id);

    /**
     * 保存.
     */
    void save(Remark remark);

    /**
     * 更新用户.
     */
    void update(Remark remark);

    /**
     * 删除用户.
     */
    void delete(String id);

    /**
     * 分页查询.
     */
    Page<Remark> search(Page<Remark> page, Map<String, Object> param);
}