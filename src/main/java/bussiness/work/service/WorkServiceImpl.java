package bussiness.work.service;

import bussiness.work.dao.WorkDao;
import bussiness.work.domain.Work;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.Identities;
import com.vansec.user.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 作品服务实现类.
 * @author zhousd
 */
@Service
@Transactional
public class WorkServiceImpl implements WorkService {

    private static Logger logger = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Autowired
    private WorkDao workDao;

    @Override
    public Work getById(String id) {
        try {
            return workDao.getById(id);
        } catch (Exception e) {
            logger.error("get work by id error!", e);
        }
        return null;
    }

    @Override
    public void save(Work work) {
        try {
            if (work != null && StringUtils.isEmpty(work.getId())) {
                work.setId(Identities.uuid());
            }
            workDao.save(work);
        } catch (Exception e){
            logger.error("save work error!", e);
        }
    }

    @Override
    public void update(Work work) {
        try {
            workDao.update(work);
        } catch (Exception e){
            logger.error("update work error!", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            workDao.delete(id);
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
    public Page<Work> search(Page<Work> page, Map<String, Object> param) {
        try {
            return workDao.search(page, param);
        } catch (Exception e) {
            logger.error("search work error!", e);
        }
        return null;
    }
}
