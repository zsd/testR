package bussiness.upvote.service;

import bussiness.upvote.dao.UpvoteDao;
import bussiness.upvote.domain.Upvote;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 点赞服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class UpvoteServiceImpl implements UpvoteService {

    private static Logger logger = LoggerFactory.getLogger(UpvoteServiceImpl.class);

    @Autowired
    private UpvoteDao upvoteDao;

    @Override
    public Upvote getById(String id) {
        try {
            return upvoteDao.getById(id);
        } catch (Exception e) {
            logger.error("get upvote by id error!", e);
        }
        return null;
    }

    @Override
    public void save(Upvote upvote) {
        try {
            if (upvote != null && StringUtils.isEmpty(upvote.getId())) {
                upvote.setId(Identities.uuid());
            }
            upvoteDao.save(upvote);
        } catch (Exception e){
            logger.error("save upvote error!", e);
        }
    }

    @Override
    public void update(Upvote work) {
//        try {
//            upvoteDao.update(work);
//        } catch (Exception e){
//            logger.error("update work error!", e);
//        }
    }

    @Override
    public void delete(String id) {
        try {
            upvoteDao.delete(id);
        } catch (Exception e) {
            logger.error("delete work by id error!", e);
        }
    }

    @Override
    public void deleteIdStr(String idStr) {
        if (StringUtils.isBlank(idStr)) {
            return;
        }
        String[] ids = idStr.split(",");
        for (String id : ids) {
            this.delete(id);
        }
    }

    @Override
    public Page<Upvote> search(Page<Upvote> page, Map<String, Object> param) {
//        try {
//            return upvoteDao.search(page, param);
//        } catch (Exception e) {
//            logger.error("search work error!", e);
//        }
        return null;
    }
}
