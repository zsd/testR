package bussiness.remark.service;

import bussiness.remark.domain.Remark;
import com.vansec.comm.orm.Page;

import java.util.Map;

/**
 * 评论服务接口.
 * @author zhousd
 */
public interface RemarkService {

    /**
     * 根据id获取.
     */
    Remark getById(String id);

    /**
     * 保存.
     */
    void save(Remark remark);

    /**
     * 更新.
     */
    void update(Remark remark);

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
    Page<Remark> search(Page<Remark> page, Map<String, Object> param);
}
