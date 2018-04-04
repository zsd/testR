package com.vansec.example.data;

import com.vansec.example.domain.Example;

/**
 * 业务日志测试数据提供类.
 * @author zhousd
 */
public final class ExampleDataProvider {

    /**
     * 生成示例数据.
     * @return 示例数据
     */
    public static Example getExample() {
        return new Example();
    }

    private ExampleDataProvider() {}
}
