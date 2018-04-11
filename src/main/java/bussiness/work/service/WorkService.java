package bussiness.work.service;

import bussiness.work.domain.Work;
import com.vansec.comm.orm.Page;

import java.util.Map;

/**
 * 作品服务接口.
 * @author zhousd
 */
public interface WorkService {

    /**
     * 根据id获取.
     */
    Work getById(String id);

    /**
     * 保存.
     */
    void save(Work work);

    /**
     * 更新.
     */
    void update(Work work);

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
    Page<Work> search(Page<Work> page, Map<String, Object> param);
}
