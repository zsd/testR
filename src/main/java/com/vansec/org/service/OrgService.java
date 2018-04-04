package com.vansec.org.service;

import com.vansec.comm.orm.Page;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;

import java.util.List;
import java.util.Map;

/**
 * 组织机构服务接口.
 * @author zhousd
 */
public interface OrgService {

    /**
     * 根据机构ID获取机构.
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
     * 删除组织机构.
     */
    void delete(String id);

    /**
     * 批量删除组织机构.
     */
    void deleteIdStr(String idStr);

    /**
     * 分页查询.
     */
    Page<Org> search(Page<Org> page, Map<String, Object> param);

    List<Org> getAll();

}
