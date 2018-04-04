package com.vansec.attachment.dao.mapper;

import com.vansec.attachment.domain.Attachment;
import com.vansec.org.domain.Post;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xierh
 * 附件映射接口.
 */
@Repository
public interface AttachmentMapper {

    /**
     * 插入附件
     *
     * @param attachment 附件实体对象
     * @param post       岗位对象
     */
    void insert(@Param("attachment") Attachment attachment, @Param("post") Post post);

    /**
     * 更新附件
     *
     * @param attachment 附件实体对象
     * @param post       岗位对象
     */
    void update(@Param("attachment") Attachment attachment, @Param("post") Post post);

    /**
     * 更新附件新名称
     *
     * @param id         附件流水号
     * @param newName    新名称
     * @param updateTime 更新时间
     */
    void updateNewName(@Param("id") String id, @Param("newName") String newName, @Param("post") Post post, @Param("updateTime") Date updateTime);

    /**
     * 删除附件
     *
     * @param id 附件流水号
     */
    void delete(@Param("id") String id);

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    Attachment find(@Param("id") String id);

    /**
     * 获取附件集合
     *
     * @param entityId 与附件关联的实体对象流水号
     */
    List<Attachment> finds(@Param("id") String entityId);

    /**
     * 根据业务对象ID和业务类型获取附件列表
     * @param objectId
     * @param type
     * @return
     */
    List<Attachment> getList(@Param("objectId") String objectId, @Param("type") int type);

    /**
     * 根据条件获取附件分页列表
     * @param param
     * @return
     */
    List<Attachment> search(Map<String, Object> param);

    long count(Map<String, Object> param);
}
