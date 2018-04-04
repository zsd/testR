package com.vansec.org.dao;

import com.vansec.comm.orm.Page;
import com.vansec.org.dao.mapper.OrgMapper;
import com.vansec.org.domain.Org;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 单位数据访问类.
 * @author zhousd
 */
@Repository
public class OrgDaoImpl implements OrgDao {

    private Logger logger = LoggerFactory.getLogger(OrgDaoImpl.class);

    @Autowired
    private OrgMapper orgMapper;

    @Override
    public Org getById(String id) {
        return orgMapper.getById(id);
    }

    public void save(Org org) {
        orgMapper.save(org);
    }

    @Override
    public void update(Org org) {
        orgMapper.update(org);
    }

    @Override
    public void delete(String id) {
        orgMapper.delete(id);
    }

    @Override
    public Page<Org> search(Page<Org> page, Map<String, Object> param) {
        int skip = (page.getPageNo() - 1) * page.getPageSize();
        int limit = page.getPageSize();
        String name = param.get("name") == null ? null: param.get("name").toString();
        List<Org> lists = orgMapper.search(name, skip, limit);
        long count = orgMapper.count(name);
        page.setResult(lists);
        page.setTotalCount(count);
        return page;
    }

    @Override
    public List<Org> getAll() {
        return orgMapper.getAll();
    }
}