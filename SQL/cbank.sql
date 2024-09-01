DROP TABLE IF EXISTS `certification`;
DROP TABLE IF EXISTS `achievement`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE user
(
    id          BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    nickname    VARCHAR(100) COMMENT '用户昵称，可以个性化设置',
    username    VARCHAR(100) NOT NULL UNIQUE COMMENT '用户账号，用于系统登录',
    password    VARCHAR(255) NOT NULL,
    real_name   VARCHAR(255) COMMENT '用户的真实姓名',
    email       VARCHAR(255),
    age         INT(3),
    gender      CHAR(1) COMMENT 'M表示男性，F表示女性',
    phone       VARCHAR(15),
    role        VARCHAR(50) COMMENT '用户身份，0超级管理员，1管理员，2用户',
    date_joined DATETIME     NOT NULL,
    status      VARCHAR(50)
);

CREATE TABLE achievement
(
    id           BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    user_id      BIGINT(20)   NOT NULL COMMENT '用户表的外键，表示创建此成就的管理员',
    name         VARCHAR(255) NOT NULL COMMENT '成果的名称',
    description  TEXT COMMENT '成就描述和认证介绍',
    type         VARCHAR(100) COMMENT '成就类型：在线课程、学位、项目、论文、职业、技能证书',
    credits      DECIMAL(5, 2) COMMENT '成就对应的学分',
    created_date DATETIME     NOT NULL COMMENT '成就创建时间',
    status       VARCHAR(50) COMMENT '成就状态',
    level        VARCHAR(50) COMMENT '成就等级：初级、中级、高级',
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE certification
(
    id               BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    achievement_id   BIGINT(20)   NOT NULL COMMENT '关联的成果id',
    achievement_name VARCHAR(255) NOT NULL COMMENT '申请认证的成果的名称',
    applicant_id     BIGINT(20)   NOT NULL COMMENT '申请认证的用户的id',
    reviewer_id      BIGINT(20)   NOT NULL COMMENT '审核认证申请的用户id',
    application_date DATETIME     NOT NULL COMMENT '申请提交的日期和时间',
    review_date      DATETIME COMMENT '认证审核的日期和时间',
    status           VARCHAR(50) COMMENT '认证状态：待审核、已通过、已拒绝',
    remark           TEXT COMMENT '' COMMENT '审核员对该认证的评语或备注',
    FOREIGN KEY (achievement_id) REFERENCES achievement (id),
    FOREIGN KEY (applicant_id) REFERENCES user (id)
);

-- 插入用户数据
INSERT INTO `user` (nickname, username, password, real_name, email, age, gender, phone, role, date_joined, status)
VALUES ('admin', 'admin', 'admin', 'WuKong', 'wukong@sun.com', 28, 'M', '1234567890', '0', '2024-09-01 10:00:00', 'active'),
       ('折浪1', 'zhelang1', 'zhelang1', '折浪', 'zhelang02@qq.com', 21, 'M', '9876543210', '1', '2024-09-01 11:00:00', 'active'),
       ('折浪2', 'zhelang2', 'zhelang2', '折浪', 'zhelang02@qq.com', 22, 'F', '9876543210', '2', '2024-09-01 11:00:00', 'active'),
       ('折浪3', 'zhelang3', 'zhelang3', '折浪', 'zhelang02@qq.com', 23, 'M', '9876543210', '2', '2024-09-01 11:00:00', 'active');

-- 插入成就数据
INSERT INTO `achievement` (user_id, name, description, type, credits, created_date, level)
VALUES (1, '算法分析与设计', '讲算法的分析和设计的', '在线课程', 4.0, '2024-09-02 09:00:00', 'medium'),
       (1, '港珠澳大桥建设', '参与港珠澳大桥建设项目', '项目', 15.0, '2024-09-02 09:00:00', 'high');

-- 插入认证数据
INSERT INTO `certification` (achievement_id, achievement_name, applicant_id, reviewer_id, application_date, review_date,
                             status, remark)
VALUES (1, '算法分析与设计', 1, 2, '2024-09-02 09:00:00', '2024-09-03 15:00:00', '已通过', '申请人符合所有要求，认证通过。'),
       (2, '港珠澳大桥建设', 2, 1, '2024-09-04 12:00:00', NULL, '待审核', '等待审核。');
