package com.vansec.log.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vansec.comm.orm.Page;
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

import javax.servlet.http.HttpServletResponse;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 * 日志控制器.
 * @author wupb
 */
@Controller
@RequestMapping("log")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @Autowired
    private LogService service;
    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 查询列表.
     */
    @RequestMapping(value = "gotoPage", method = RequestMethod.GET)
    public ModelAndView gotoPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("log/list");
        return mv;
    }
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView gotoPageOne() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("log/list");
        return mv;
    }
    /**
     * 分页。
     */
    @RequestMapping(value = "search", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam(required = false) String type,
                         @RequestParam(required = false) String description,
                         @RequestParam(required = false) Integer pageNo,
                         @RequestParam(required = false) Integer pageSize) {

        Page<Log> page = new Page<>();
        if (pageNo != null && pageSize != null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("type", type);
        param.put("description", description);

        page =service.search(page, param);
        String ret = jsonMapper.toJson(page);
        return ret;
    }
}
