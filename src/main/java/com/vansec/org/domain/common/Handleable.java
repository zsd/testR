package com.vansec.org.domain.common;

import com.vansec.comm.domain.Entity;

/**
 * 处理人接口.
 * @author zhousd
 */
public interface Handleable extends Entity {

    String getId(); // 获取主键

    String getName(); // 获取名称
}