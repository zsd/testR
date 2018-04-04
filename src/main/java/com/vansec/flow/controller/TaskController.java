package com.vansec.flow.controller;

import com.vansec.comm.orm.Page;
import com.vansec.comm.utils.JsonMapper;
import com.vansec.flow.domain.Task;
import com.vansec.flow.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 任务控制器.
 * @author xierh
 */
@Controller
@RequestMapping("task")
public class TaskController {

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 根据ID获取任务、矛盾对象、按钮
     * @param id 任务id
     */
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getById(@PathVariable String id, HttpSession session, HttpServletRequest request) {
        return "";
    }

    /**
     * 查询分页列表
     * @param pageNo 页数
     * @param pageSize 分页显示数量
     * @return 实例分页列表
     */
    @RequestMapping(value = "/getPage", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String getPageByParam(@RequestParam(required = false) String pageNo,
                            @RequestParam(required = false) String pageSize){

        Page<Task> page = new Page<>();
        if (StringUtils.isNotBlank(pageNo)) {
            page.setPageNo(Integer.parseInt(pageNo));
        } else {
            page.setPageNo(1);
        }
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.parseInt(pageSize));
        }
        Map<String, Object> param = new HashMap<>();

        page = taskService.search(page, param);

        String ret = jsonMapper.toJson(page);
        return ret;
    }

}
