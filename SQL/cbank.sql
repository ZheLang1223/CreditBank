DROP TABLE IF EXISTS `users`;
CREATE TABLE users
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

DROP TABLE IF EXISTS `achievements`;
CREATE TABLE achievements
(
    id             BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    user_id        BIGINT(20)   NOT NULL,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    type           VARCHAR(100),
    credits        DECIMAL(5, 2),
    date_created   DATETIME     NOT NULL,
    status         VARCHAR(50),
    attachment_url VARCHAR(255),
    level          VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

DROP TABLE IF EXISTS 'certifications';
CREATE TABLE certifications
(
    id             BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    achievement_id BIGINT(20) NOT NULL COMMENT '成果表的外键',
    evaluator_id   BIGINT(20) NOT NULL COMMENT '用户表的外键，表示审核',
    date_submitted DATETIME   NOT NULL,
    date_approved  DATETIME,
    status         VARCHAR(50),
    remarks        TEXT,
    FOREIGN KEY (achievement_id) REFERENCES achievements (id),
    FOREIGN KEY (evaluator_id) REFERENCES users (id)
);
