package com.vansec.org.controller;

import bussiness.comm.LogFactory;
import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.ControllerUtils;
import com.vansec.comm.utils.JsonMapper;
import com.vansec.log.domain.Log;
import com.vansec.log.service.LogService;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import com.vansec.org.service.DepartmentService;
import com.vansec.org.service.OrgService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 部门控制器.
 * @author zhousd
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private OrgService orgService;
    @Autowired
    private LogService logService ;

    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 查询列表.
     */
    @RequestMapping(value = "gotoPage", method = RequestMethod.GET)
    public ModelAndView gotoPage() {
        ModelAndView mv = new ModelAndView();
        //添加系统日记
        logService.add(LogFactory.insert(Log.TYPE_GETBYID,"访问部门管理页面","机构管理", SecurityContextHolder.getPost().getUser()));
        mv.setViewName("org/department/list");
        return mv;
    }
    /**
     * 分页.
     */
    @RequestMapping(value = "search", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam(required = false) String name,
                         @RequestParam(required = false) String orgId,
                         @RequestParam(required = false) Integer pageNo,
                         @RequestParam(required = false) Integer pageSize) {

        Page<Department> page = new Page<>();
        if (pageNo != null && pageSize != null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("orgId", orgId);
        page = departmentService.search(page, param);
        return jsonMapper.toJson(page);
    }

    /**
     * 保存数据.
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(String json) {
        logger.debug("OrgController save json : {}", json);
        Map<String, Object> response;
        try {
            Department department = jsonMapper.fromJson(json, Department.class);
            if (StringUtils.isNotBlank(department.getId())) {
                departmentService.update(department);
                //添加系统日记
                logService.add(LogFactory.insert(Log.TYPE_MOD,"添加部门","机构管理", SecurityContextHolder.getPost().getUser()));
            } else {
                departmentService.save(department);
                //添加系统日记
                logService.add(LogFactory.insert(Log.TYPE_ADD,"添加部门","机构管理", SecurityContextHolder.getPost().getUser()));
            }
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "保存成功！");
            return response;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "保存失败！");
            return response;
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String idStr) {
        logger.debug("DepartmentController delete id : {}", idStr);
        Map<String, Object> response;
        try {
            departmentService.deleteIdStr(idStr);
            //添加系统日记
            logService.add(LogFactory.insert(Log.TYPE_DEL,"删除部门","机构管理", SecurityContextHolder.getPost().getUser()));
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "删除成功！");
        } catch (Exception e) {
            logger.debug("delete idStr failed!", e);
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "删除失败！");
        }
        return response;
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrgName(@RequestParam(required = false) String id){
        Map<String,Object> mapName = new HashMap<>();
        Org org = orgService.getById(id);
        mapName.put("orgName",org.getName());
        return mapName;
    }

}
