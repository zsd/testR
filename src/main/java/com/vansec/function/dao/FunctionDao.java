package com.vansec.function.dao;

import com.vansec.function.domain.Function;
import com.vansec.function.domain.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 黄辅湘 on 2016/6/22.
 */
public interface FunctionDao {

    /**
     * 根据项目名获取字典值列表.
     */
    List<Function> getByParentId(String parentId);

    /**
     * 保存.
     */
    void save(Function function);

    /**
     * 更新.
     */
    void update(Function function);

    /**
     * 根据ID删除
     */
    void delete(String id);

    void deleteByParent(List<String> list);

    /**
     * 获取所有节点信息
     * @return
     */
    List<TreeNode> getAllNode();

    /**
     * 根据岗位获取列表.
     */
    List<Function> getByPostId(String postId, String parentId);

    /**
     * 编号判断.
     */
    long checkedCode(String id,String code);

    /**
     * 根据用户获取按钮权限.
     */
    List<Function> getButtonByPostId(String postId);
}
