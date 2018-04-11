package bussiness.work.dao.mapper;

import bussiness.work.domain.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkMapper {

    /**
     * 根据ID获取.
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
     * 分页查询-列表.
     */
    List<Work> search(@Param("name") String name, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 分页查询-总数.
     */
    long count(@Param("name") String name);
}
