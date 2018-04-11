package bussiness.work.domain;

import com.vansec.comm.domain.EntityImpl;

/**
 * 作品实体.
 * @author zhousd
 */
public class Work extends EntityImpl {

    /**
     *
     * id                   varchar(32) not null comment '主键',
     title                varchar(500) comment '标题',
     content              blob comment '内容简介',
     url                  varchar(500) comment '链接',
     type                 varchar(20) comment '作品类型',
     reward_money         int comment '悬赏金额',
     reward_points        int comment '悬赏积分',
     actor_count          int comment '参与人数',
     set_count            int comment '设定总人数',
     score                float(1,1) comment '作品得分，5分制',
     user_id              varchar(32) comment '发布人ID',
     user_name            varchar(200) comment '发布人姓名',
     create_time          datetime comment '发布时间',
     update_time          datetime comment '更新时间',
     */

    private String name; // 名称

    private String content; // 内容

    private String url; // 链接

    private String type; // 作品类型
}
