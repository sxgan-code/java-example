-- 创建数据库
create database if not exists zoey_mock_db default charset utf8mb4;
create database if not exists zoey_mock_db_backup default charset utf8mb4;
-- 切换到数据库
use zoey_mock_db;



-- ----------------------------
-- 1、系统配置表
-- ----------------------------
drop table if exists sys_code;
create table sys_code
(
    config_id    bigint(6)     not null auto_increment comment '主键配置ID，主键约束',
    config_key   varchar(128)  not null comment '配置Key值，唯一约束',
    config_value varchar(2000) not null comment '配置的Value值，如果有多个，用逗号隔开',
    config_type  varchar(50)   not null default '' comment '配置类型',
    description  varchar(100)  not null default '' comment '作用描述',
    create_time  datetime      not null default current_timestamp comment '创建时间',
    update_time  datetime      not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag     tinyint       not null default '0' comment '是否删除：0-否；1-是',
    primary key (config_id),
    unique key uk_config_key (config_key)
) engine = innodb
  auto_increment = 1000
  default charset = utf8mb4 comment ='系统代码配置表';
desc sys_code;

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id         bigint(10)   not null auto_increment comment '用户ID',
    user_name       varchar(30)  not null default '' comment '用户昵称',
    email           varchar(50)  not null default '' comment '用户邮箱',
    password        varchar(80)  not null default '' comment '密码',
    sex             tinyint(1)   not null default 2 comment '用户性别（0男 1女 2未知）',
    phone_number    varchar(11)  not null default '' comment '手机号码',
    avatar          varchar(100) not null default '' comment '头像路径',
    personal_sign   varchar(500) not null default '这个人很懒，什么也没留下' comment '个性签名',
    salt            varchar(20)  not null default '' comment '盐加密',
    dept_id         bigint(4)    not null default -1 comment '部门ID',
    user_type       tinyint(1)   not null default 1 comment '用户类型（0系统用户 1普通用户）',
    status          tinyint(1)   not null default 1 comment '帐号状态（1正常 0停用）',
    login_ip        varchar(128) not null default '' comment '最后登录IP',
    login_date      datetime     not null default current_timestamp comment '最后登录时间',
    pwd_update_date datetime     not null default current_timestamp comment '密码最后更新时间',
    remark          varchar(500) not null default '' comment '备注',
    create_by       varchar(64)  not null default '' comment '创建者',
    update_by       varchar(64)  not null default '' comment '更新者',
    create_time     datetime     not null default current_timestamp comment '创建时间',
    update_time     datetime     not null default current_timestamp on update current_timestamp comment '更新时间',
    del_flag        tinyint(1)   not null default 0 comment '删除标志（0代表存在 1代表删除）',
    primary key (user_id),
    unique key uk_email (email)
) engine = innodb
  default charset = utf8mb4
  auto_increment = 10000 comment = '用户信息表';

-- ###########   其他表              教育系统
drop table if exists school_course;
create table if not exists school_course
(
    id         int          default 0000              not null primary key comment '课程编号',
    name       varchar(255) default ''                not null comment '课程名',
    teacher    varchar(255) default ''                not null comment '任课老师',
    start_date datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '开始时间',
    end_date   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '结束时间'
)
    comment '课程表';

drop table if exists school_cs;
create table if not exists school_cs
(
    stu_no int not null comment '学号',
    cou_no int not null comment '课程号',
    primary key (stu_no, cou_no)
)
    comment '学生课程关联表';

drop table if exists school_dept;
create table if not exists school_dept
(
    dept_no   int auto_increment comment '部门号'
        primary key,
    dept_name varchar(50) not null
)
    comment '部门表';

drop table if exists school_student;
create table if not exists school_student
(
    id              int          default 0000                  not null primary key comment '学号',
    name            varchar(255) default ''                    not null comment '姓名',
    sex             int          default 0                     not null comment '性别:1-男，0-女',
    email           varchar(255) default ''                    not null comment '邮箱',
    class_id        int          default -1                    not null comment '课程id',
    enrollment_date datetime     default '1970-01-01 08:00:00' not null comment '入学时间'
)
    comment '学生表';


create table if not exists mock_test
(
    TASK_ID              int         not null
        primary key,
    TASK_NAME            varchar(50) null,
    STATUS               int         null,
    TASK_LEVEL           varchar(50) null,
    TASK_CREATE_TIME     date        null,
    TASK_START_TIME      date        null,
    TASK_RUN_TIME        date        null,
    TASK_REMARK          varchar(50) null,
    TASK_RESERVED_FIELD1 varchar(50) null,
    TASK_RESERVED_FIELD2 varchar(50) null,
    TASK_RESERVED_FIELD3 varchar(50) null,
    TASK_RESERVED_FIELD4 varchar(50) null,
    TASK_RESERVED_FIELD5 varchar(50) null
)
    comment '测试任务表';

create table if not exists school_enrollments
(
    student_id      int   null,
    class_id        int   null,
    enrollment_date date  null,
    grade           float null
);


#####################################                测试数据

create table if not exists mock_role
(
    role_id     bigint auto_increment comment '角色id'
        primary key,
    user_id     bigint       default -1                    not null comment '角色id',
    role_name   varchar(50)  default ''                    not null comment '角色名称',
    role_code   int          default -1                    not null comment '角色代码',
    description varchar(255) default ''                    not null comment '说明',
    create_date datetime     default '1970-01-01 08:00:00' not null comment '创建时间',
    update_date datetime     default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint user_id
        unique (user_id)
)
    collate = utf8_unicode_ci;

create table if not exists mock_tb_task
(
    id               bigint auto_increment comment '自增主键'
        primary key,
    task_rule_id     bigint      default -1                    not null comment '任务规则id',
    task_batch_id    varchar(20) default ''                    not null comment '批次id',
    second_entity_id bigint      default -1                    not null comment '二级主体id：如账户id',
    create_time      datetime    default '1970-01-01 08:00:00' not null comment '创建时间',
    update_time      datetime    default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment 'tb_task临时表';

create table if not exists mock_user
(
    user_id     bigint      default -1                    not null comment '用户id'
        primary key,
    user_name   varchar(50) default ''                    not null comment '用户名',
    age         int         default 0                     not null comment '年龄',
    email       varchar(50) default ''                    not null comment '邮箱',
    password    varchar(50) default '123456'              not null comment '邮箱',
    gender      varchar(50) default 'Male'                not null comment '性别',
    ethnicity   varchar(3)  default ''                    not null comment '种族',
    job_title   varchar(50) default ''                    not null comment '工作',
    address     varchar(50) default ''                    not null comment '地址',
    city        varchar(3)  default ''                    not null comment '城市',
    create_date datetime    default '1970-01-01 08:00:00' not null comment '创建时间',
    update_date datetime    default CURRENT_TIMESTAMP     not null on update CURRENT_TIMESTAMP comment '更新时间',
    constraint email
        unique (email)
)
    collate = utf8_unicode_ci;

CREATE TABLE `tb_hotel`
(
    `id`        bigint(20)   NOT NULL COMMENT '酒店id',
    `name`      varchar(255) NOT NULL COMMENT '酒店名称；例：7天酒店',
    `address`   varchar(255) NOT NULL COMMENT '酒店地址；例：航头路',
    `price`     int(10)      NOT NULL COMMENT '酒店价格；例：329',
    `score`     int(2)       NOT NULL COMMENT '酒店评分；例：45，就是4.5分',
    `brand`     varchar(32)  NOT NULL COMMENT '酒店品牌；例：如家',
    `city`      varchar(32)  NOT NULL COMMENT '所在城市；例：上海',
    `star_name` varchar(16)  DEFAULT NULL COMMENT '酒店星级，从低到高分别是：1星到5星，1钻到5钻',
    `business`  varchar(255) DEFAULT NULL COMMENT '商圈；例：虹桥',
    `latitude`  varchar(32)  NOT NULL COMMENT '纬度；例：31.2497',
    `longitude` varchar(32)  NOT NULL COMMENT '经度；例：120.3925',
    `pic`       varchar(255) DEFAULT NULL COMMENT '酒店图片；例:/img/1.jpg',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;