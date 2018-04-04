package com.vansec.org.controller;

import bussiness.comm.LogFactory;
import com.vansec.authority.service.RoleService;
import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.ControllerUtils;
import com.vansec.comm.utils.JsonMapper;
import com.vansec.log.domain.Log;
import com.vansec.log.service.LogService;
import com.vansec.org.domain.Department;
import com.vansec.org.domain.Org;
import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;
import com.vansec.org.domain.common.OrgImpl;
import com.vansec.org.service.DepartmentService;
import com.vansec.org.service.OrgService;
import com.vansec.org.service.PostService;
import com.vansec.org.service.UserService;
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
 * 岗位控制器.
 * @author zhousd
 */
@Controller
@RequestMapping("post")
public class PostController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private DepartmentService  departmentService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

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
        logService.add(LogFactory.insert(Log.TYPE_GETBYID,"访问岗位管理页面","机构管理", SecurityContextHolder.getPost().getUser()));
        mv.setViewName("org/post/list");
        return mv;
    }
    /**
     * 分页.
     */
    @RequestMapping(value = "search", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam(required = false) String name,
                         @RequestParam(required = false) String departmentId,
                         @RequestParam(required = false) Integer pageNo,
                         @RequestParam(required = false) Integer pageSize) {

        Page<Post> page = new Page<>();
        if (pageNo != null && pageSize != null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("departmentId", departmentId);
        page = postService.search(page, param);
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
            Post post = jsonMapper.fromJson(json, Post.class);
            if (StringUtils.isNotBlank(post.getId())) {
                postService.update(post);
                //添加系统日记
                logService.add(LogFactory.insert(Log.TYPE_MOD,"修改岗位","机构管理", SecurityContextHolder.getPost().getUser()));
            } else {
                postService.save(post);
                //添加系统日记
                logService.add(LogFactory.insert(Log.TYPE_ADD,"添加岗位","机构管理", SecurityContextHolder.getPost().getUser()));
            }
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "保存成功！");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "保存失败！");
        }
        return response;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String idStr) {
        logger.debug("PostController delete id : {}", idStr);
        Map<String, Object> response;
        try {
            postService.deleteIdStr(idStr);
            //添加系统日记
            logService.add(LogFactory.insert(Log.TYPE_DEL,"删除岗位","机构管理", SecurityContextHolder.getPost().getUser()));
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "删除成功！");
        } catch (Exception e) {
            logger.debug("delete idStr failed!", e);
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "保存失败！");
        }
        return response;
    }

    /**
     * 获取单位名字和部门名字
     * @param id
     * @return
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrgDepartmentName(@RequestParam(required = false) String id,
                                                    @RequestParam(required = false) String userId){
        Map<String,Object> mapName = new HashMap<>();
        Department department = departmentService.getById(id);
        Org org = orgService.getById(department.getParent().getId());
        User user = userService.getById(userId);
        mapName.put("departmentName",department.getName());
        mapName.put("orgName",org.getName());
        mapName.put("userName",user.getName());
        return mapName;
    }

    /**
     * 保存组织机构与角色关联
     * @return
     */
    @RequestMapping(value = "saveRoleRel", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveRoleRel(String json){
        logger.debug("PostController saveRoleRel json : {}", json);
        Map<String, Object> response;
        try {
            Post post = jsonMapper.fromJson(json, Post.class);
            roleService.saveOrgRole(post);
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "保存成功！");
        } catch (Exception e) {
            logger.debug("saveRoleRel json failed!", e);
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "保存失败！");
        }
        return response;
    }

}
