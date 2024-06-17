# 初始化数据库
insert into sys_code(config_key, config_value, config_type, description)
values ('email.password', 'your password', 'sys_config', '授权码');

INSERT INTO school_course(id, name, teacher, start_date, end_date)
VALUES (1, 'Math', 'Ms. Johnson', '2022-09-01', '2022-12-22'),
       (2, 'English', 'Mr. Smith', '2022-09-01', '2022-12-22'),
       (3, 'Science', 'Ms. Lee', '2022-09-01', '2022-12-22');
INSERT INTO school_course(id, name, teacher, start_date, end_date)
VALUES (4, '体育', '张三', '2022-09-01', '2022-12-22'),
       (5, '历史', '李四', '2022-09-01', '2022-12-22'),
       (6, '化学', '王五', '2022-09-01', '2022-12-22');