package com.vansec.org.dao.mapper;

import com.vansec.org.domain.Org;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgMapper {

    /**
     * 根据单位ID获取单位.
     */
    Org getById(String id);

    /**
     * 保存组织机构.
     */
    void save(Org org);

    /**
     * 更新组织机构.
     */
    void update(Org org);

    /**
     * 根据ID删除组织机构.
     */
    void delete(String id);

    /**
     * 分页查询-获取列表.
     */
    List<Org> search(@Param("name") String name, @Param("skip")  int skip, @Param("limit")  int limit);

    /**
     * 分页查询-获取数据.
     */
    long count(@Param("name") String name);

    List<Org> getAll();
}
