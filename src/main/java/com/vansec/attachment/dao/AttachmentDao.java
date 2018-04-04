package com.vansec.attachment.dao;

import com.vansec.attachment.AttachmentModule;
import com.vansec.attachment.dao.mapper.AttachmentMapper;
import com.vansec.attachment.domain.Attachment;
import com.vansec.comm.domain.Entity;
import com.vansec.comm.exception.DataAccessException;
import com.vansec.org.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xierh
 * 附件数据访问对象.
 */
@Repository
public class AttachmentDao {

    private static Logger logger = LoggerFactory.getLogger(AttachmentDao.class);

    @Autowired
    private AttachmentMapper mapper;

    /**
     * 插入附件
     *
     * @param attachment 附件实体对象
     * @param post       岗位对象
     */
    public void insert(Attachment attachment, Post post) {
        try {
            Date time = new Date();
            attachment.setCreateTime(time);
            attachment.setUpdateTime(time);
            mapper.insert(attachment, post);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_INSERT, e);
        }
    }

    /**
     * 更新附件
     *
     * @param attachment 附件实体对象
     * @param post       岗位对象
     */
    public void update(Attachment attachment, Post post) {
        try {
            attachment.setUpdateTime(new Date());
            mapper.update(attachment, post);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_UPDATE, e);
        }
    }

    /**
     * 更新附件新名称
     *
     * @param id      附件流水号
     * @param newName 附件新名称
     * @param post    岗位对象
     */
    public void updateNewName(String id, String newName, Post post) {
        try {
            mapper.updateNewName(id, newName, post, new Date());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_UPDATE_NEW_NAME, e);
        }
    }

    /**
     * 删除附件
     *
     * @param attachment 附件实体对象
     */
    public void delete(Attachment attachment) {
        this.delete(String.valueOf(attachment.getId()));
    }

    /**
     * 删除附件
     *
     * @param id 附件流水号
     */
    public void delete(String id) {
        try {
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_DELETE, e);
        }
    }

    /**
     * 获取附件
     *
     * @param id 附件流水号
     */
    public Attachment find(String id) {
        try {
            return mapper.find(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_FIND, e);
        }
    }

    /**
     * 获取附件集合
     *
     * @param entity 与附件关联的实体对
     */
    public List<Attachment> finds(Entity entity) {
        return this.finds(String.valueOf(entity.getId()));
    }

    /**
     * 获取附件集合
     *
     * @param entityId 与附件关联的实体对象流水号
     */
    public List<Attachment> finds(String entityId) {
        try {
            return mapper.finds(entityId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_FINDS, e);
        }
    }

    /**
     * 根据业务对象ID和业务类型获取附件
     * @param objectId
     * @param type
     * @return
     */
    public List<Attachment> getList(String objectId, int type) {
        try {
            return mapper.getList(objectId, type);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_GETLIST, e);
        }
    }

    public List<Attachment> search(Map<String, Object> param) {
        try {
            return mapper.search(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_SEARCH, e);
        }
    }

    public long count(Map<String, Object> param) {
        try {
            return mapper.count(param);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DataAccessException(AttachmentModule.ERR_DAO_ATTACHMENT_COUNT, e);
        }
    }
}
