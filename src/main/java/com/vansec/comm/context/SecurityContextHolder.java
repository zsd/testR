package com.vansec.comm.context;

import com.vansec.org.domain.Post;
import com.vansec.org.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * 以静态变量持有安全上下文, 例如:HttpSession
 */
public class SecurityContextHolder {

    /** 岗位上下文 */
    public static String POST_CONTEXT = "POST_CONTEXT";

    /** 权限上下文 */
    public static String AUTHORITY_CONTEXT = "AUTHORITY_CONTEXT";

    /**
     * 私有的构造函数
     */
    private SecurityContextHolder() {}

    /**
     * 从会话中获取岗位.
     */
    public static Post getPost() {
        HttpServletRequest request = ServletContextHolder.getRequest();
        return (Post) request.getSession().getAttribute(POST_CONTEXT);
    }

    /**
     * 在会话中设置岗位.
     * @param post 岗位
     */
    public static void setPost(Post post) {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(POST_CONTEXT, post);
    }

    /**
     * 从会话中获取权限.
     * 此方法暂时不需要，后续需要的时候再打开 by zhousd
     */
//    public static Set<String> getAuthoritySet() {
//        HttpServletRequest request = ServletContextHolder.getRequest();
//        return (Set<String>) request.getSession().getAttribute(AUTHORITY_CONTEXT);
//    }

    /**
     * 在会话中设置权限.
     * @param authoritySet 权限
     */
    public static void setAuthoritySet(Set<String> authoritySet) {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(AUTHORITY_CONTEXT, authoritySet);
    }

    /**
     * 销毁会话
     */
    public static void destroy() {
        HttpServletRequest request = ServletContextHolder.getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(POST_CONTEXT);
        session.removeAttribute(AUTHORITY_CONTEXT);
        session.invalidate();
    }

}
