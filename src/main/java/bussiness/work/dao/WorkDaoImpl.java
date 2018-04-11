package bussiness.work.dao;

import bussiness.work.dao.mapper.WorkMapper;
import bussiness.work.domain.Work;
import com.vansec.comm.orm.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 作品数据访问类.
 * @author zhousd
 */
@Repository
public class WorkDaoImpl implements WorkDao {

    private Logger logger = LoggerFactory.getLogger(WorkDaoImpl.class);

    @Autowired
    private WorkMapper workMapper;

    @Override
    public Work getById(String id) {
        return workMapper.getById(id);
    }

    @Override
    public void save(Work work) {
        workMapper.save(work);
    }

    @Override
    public void update(Work work) {
        workMapper.update(work);
    }

    @Override
    public void delete(String id) {
        workMapper.delete(id);
    }

    @Override
    public Page<Work> search(Page<Work> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<Work> lists = workMapper.search(name, skip, limit);
        long count = workMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }
}