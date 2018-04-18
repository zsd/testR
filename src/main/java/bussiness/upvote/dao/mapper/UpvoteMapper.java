package bussiness.upvote.dao.mapper;

import bussiness.upvote.domain.Upvote;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpvoteMapper {

    /**
     * 根据ID获取.
     */
    Upvote getById(String id);
    
    /**
     * 保存.
     */
    void save(Upvote upvote);

    /**
     * 删除.
     */
    void delete(String id);
}
