package com.vansec.user.dao.mapper;

import com.vansec.user.domain.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {

    /**
     * 根据用户ID获取.
     */
    Group getById(String id);

    /**
     * 保存.
     */
    void save(Group group);

    /**
     * 更新.
     */
    void update(Group group);

    /**
     * 删除.
     */
    void delete(String id);

    /**
     * 分页查询-列表.
     */
    List<Group> search(@Param("name") String name, @Param("skip") int skip, @Param("limit") int limit);

    /**
     * 分页查询-总数.
     */
    long count(@Param("name") String name);
}
