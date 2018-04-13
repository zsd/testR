package bussiness.remark.dao.mapper;

import bussiness.remark.domain.Remark;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemarkMapper {

    /**
     * 根据ID获取.
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
     * 分页查询-列表.
     */
    List<Remark> search(@Param("name") String name, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 分页查询-总数.
     */
    long count(@Param("name") String name);
}
