package com.vansec.authority;

import com.vansec.comm.exception.MessageProvider;

/**
 * 权限模块消息枚举类.
 * @author zhousd
 */
public enum AuthorityModule {

    //角色
    ERR_DAO_ROLE_GETBYPOSTID,
    ERR_DAO_ROLE_SAVE,

    //权限
    ERR_DAO_AUTHORITY_GETBYROLEID,
    ERR_DAO_AUTHORITY_SAVE,
    ERR_DAO_AUTHORITY_GETBYPOSTID,
    ;

    @Override
    public String toString() {
        return MessageProvider.getResource(AuthorityModule.class).getMessage(this.name());
    }
}
