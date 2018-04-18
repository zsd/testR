package bussiness.upvote.dao;

import bussiness.upvote.dao.mapper.UpvoteMapper;
import bussiness.upvote.domain.Upvote;
import bussiness.work.domain.Work;
import com.vansec.comm.orm.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 点赞数据访问类.
 * @author zhousd
 */
@Repository
public class UpvoteDaoImpl implements UpvoteDao {

    private Logger logger = LoggerFactory.getLogger(UpvoteDaoImpl.class);

    @Autowired
    private UpvoteMapper upvoteMapper;

    @Override
    public Upvote getById(String id) {
        return upvoteMapper.getById(id);
    }

    @Override
    public void save(Upvote upvote) {
        upvoteMapper.save(upvote);
    }
    @Override
    public void delete(String id) {
        upvoteMapper.delete(id);
    }
}