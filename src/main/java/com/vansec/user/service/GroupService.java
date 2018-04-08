package com.vansec.user.service;

import com.vansec.comm.orm.Page;
import com.vansec.user.domain.Group;

import java.util.Map;

/**
 * 用户组服务接口.
 * @author zhousd
 */
public interface GroupService {

    /**
     * 根据id获取.
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
     * 删除用户组.
     */
    void delete(String id);

    /**
     * 批量删除.
     */
    void deleteIdStr(String idStr);

    /**
     * 分页列表.
     */
    Page<Group> search(Page<Group> page, Map<String, Object> param);
}
