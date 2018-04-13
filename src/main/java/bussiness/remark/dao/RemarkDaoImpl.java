package bussiness.remark.dao;

import bussiness.remark.dao.mapper.RemarkMapper;
import bussiness.remark.domain.Remark;
import com.vansec.comm.orm.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 评论数据访问类.
 * @author zhousd
 */
@Repository
public class RemarkDaoImpl implements RemarkDao {

    private Logger logger = LoggerFactory.getLogger(RemarkDaoImpl.class);

    @Autowired
    private RemarkMapper remarkMapper;

    @Override
    public Remark getById(String id) {
        return remarkMapper.getById(id);
    }

    @Override
    public void save(Remark remark) {
        remarkMapper.save(remark);
    }

    @Override
    public void update(Remark remark) {
        remarkMapper.update(remark);
    }

    @Override
    public void delete(String id) {
        remarkMapper.delete(id);
    }

    @Override
    public Page<Remark> search(Page<Remark> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<Remark> lists = remarkMapper.search(name, skip, limit);
        long count = remarkMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }
}