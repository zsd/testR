package com.vansec.attachment.dao.mapper;

import com.vansec.attachment.domain.AttachRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xierh
 *附件关联映射接口.
 */
@Repository
public interface AttachRelationMapper {

    /**
     * 插入附件与业务关联
     * @param attachRelation
     */
    void insert(AttachRelation attachRelation);

    /**
     * 根据附件ID获取附件与业务关联
     * @param attachId 附件ID
     * @return
     */
    AttachRelation getByAttachId(@Param("attachId") String attachId);

    /**
     * 根据附件ID删除附件与业务关联
     * @param attachId
     */
    void deleteByAttachId(@Param("attachId") String attachId);
}
