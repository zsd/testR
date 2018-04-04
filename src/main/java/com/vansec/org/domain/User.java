package com.vansec.org.domain;

import com.vansec.comm.domain.EntityImpl;
import com.vansec.org.domain.common.OrgImpl;

import java.util.Date;

/**
 * 用户实体.
 * @author zhousd
 */
public class User extends OrgImpl {

    private String loginName = ""; // 登录名

    private String password = ""; // 密码

    private String phone = ""; // 手机号码

    private String birthday ;//出生日期

    private String email;//邮箱

    public User() {
        super();
        this.setType(OrgImpl.TYPE_USER);
    }

    public User(String loginName, String password) {
        this();
        this.loginName = loginName;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}