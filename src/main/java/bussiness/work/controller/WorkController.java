package bussiness.work.controller;

import bussiness.comm.LogFactory;
import bussiness.work.domain.Work;
import bussiness.work.service.WorkService;
import com.vansec.comm.context.SecurityContextHolder;
import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.ControllerUtils;
import com.vansec.comm.utils.JsonMapper;
import com.vansec.log.domain.Log;
import com.vansec.log.service.LogService;
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
 * 作品控制器.
 * @author zhousd
 */
@Controller
@RequestMapping("work")
public class WorkController {

    private static Logger logger = LoggerFactory.getLogger(WorkController.class);

    @Autowired
    private WorkService workService;

    @Autowired
    private LogService logService ;

    private JsonMapper jsonMapper = new JsonMapper();

    private static final String MODULENAME_WORK = "作品管理";

    /**
     * 查询列表.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView gotoPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("work/list");
        return mv;
    }
    /**
     * 分页.
     */
    @RequestMapping(value = "search", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer pageNo,
                         @RequestParam(required = false) Integer pageSize) {

        Page<Work> page = new Page<>();
        if (pageNo != null && pageSize != null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("name", name);

        page = workService.search(page, param);

        return jsonMapper.toJson(page);
    }

    /**
     * 保存数据.
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(String json) {
        logger.debug("Work Controller save json : {}", json);
        Map<String, Object> response;
        try {
            Work work = jsonMapper.fromJson(json, Work.class);
            if (StringUtils.isNotBlank(work.getId())) {
                workService.update(work);
                logService.add(LogFactory.insert(Log.TYPE_MOD, "修改作品", MODULENAME_WORK,
                        SecurityContextHolder.getUser())); //添加系统日记
            } else {
                work.setUser(SecurityContextHolder.getUser());
                workService.save(work);
                logService.add(LogFactory.insert(Log.TYPE_ADD, "添加作品", MODULENAME_WORK,
                        SecurityContextHolder.getUser())); //添加系统日记
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
        logger.debug("Work Controller delete id : {}", idStr);
        Map<String, Object> response;
        try {
            workService.deleteIdStr(idStr);
            logService.add(LogFactory.insert(Log.TYPE_DEL,"删除作品", MODULENAME_WORK,
                    SecurityContextHolder.getUser())); //添加系统日记
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "删除成功！");
        } catch (Exception e) {
            logger.debug("delete idStr failed!", e);
            response = ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "删除失败！");
        }
        return response;
    }
}
