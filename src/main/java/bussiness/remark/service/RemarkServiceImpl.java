package bussiness.remark.service;

import bussiness.remark.dao.RemarkDao;
import bussiness.remark.domain.Remark;
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
 * 评论服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class RemarkServiceImpl implements RemarkService {

    private static Logger logger = LoggerFactory.getLogger(RemarkServiceImpl.class);

    @Autowired
    private RemarkDao remarkDao;

    @Override
    public Remark getById(String id) {
        try {
            return remarkDao.getById(id);
        } catch (Exception e) {
            logger.error("get remark by id error!", e);
        }
        return null;
    }

    @Override
    public void save(Remark remark) {
        try {
            if (remark != null && StringUtils.isEmpty(remark.getId())) {
                remark.setId(Identities.uuid());
            }
            remarkDao.save(remark);
        } catch (Exception e){
            logger.error("save remark error!", e);
        }
    }

    @Override
    public void update(Remark work) {
        try {
            remarkDao.update(work);
        } catch (Exception e){
            logger.error("update remark error!", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            remarkDao.delete(id);
        } catch (Exception e) {
            logger.error("delete remark by id error!", e);
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
    public Page<Remark> search(Page<Remark> page, Map<String, Object> param) {
        try {
            return remarkDao.search(page, param);
        } catch (Exception e) {
            logger.error("search remark error!", e);
        }
        return null;
    }
}
