CREATE TABLE user_tbl(uid serial PRIMARY KEY, name VARCHAR(100) NOT NULL, email VARCHAR(100), password VARCHAR(255), area VARCHAR(255), birthday date, qq VARCHAR(20),wechat VARCHAR(100));
comment on table user_tbl is '用户表';
comment on column user_tbl.uid is '主键';
comment on column user_tbl.name is '名称';
comment on column user_tbl.email is '电子邮件';
comment on column user_tbl.password is '密码';
comment on column user_tbl.area is '国家和地区';
comment on column user_tbl.birthday is '生日';
comment on column user_tbl.qq is 'QQ';
comment on column user_tbl.wechat is '微信号';

CREATE TABLE product_tbl
(
  pid serial NOT NULL,
  pname character varying(256) NOT NULL DEFAULT ''::character varying,
  image_name character varying(256) NOT NULL DEFAULT ''::character varying,
  image_file bytea,
  CONSTRAINT pk_notice_image PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE notice_image OWNER TO postgres;


CREATE TABLE sysuser_tbl(
uid VARCHAR(20) PRIMARY KEY,
name VARCHAR(100) NOT NULL,
role VARCHAR(30),
tel VARCHAR(20) NOT NULL,
department VARCHAR(20) NOT NULL,
email VARCHAR(100),
password VARCHAR(255),
area VARCHAR(255),
birthday VARCHAR(20),
qq VARCHAR(20),
wechat VARCHAR(100));
comment on table sysuser_tbl is '系统用户表';
comment on column sysuser_tbl.uid is '主键';
comment on column sysuser_tbl.name is '名称';
comment on column sysuser_tbl.role is '角色';
comment on column sysuser_tbl.tel is '电话';
comment on column sysuser_tbl.department is '部门';
comment on column sysuser_tbl.email is '电子邮件';
comment on column sysuser_tbl.password is '密码';
comment on column sysuser_tbl.area is '国家和地区';
comment on column sysuser_tbl.birthday is '生日';
comment on column sysuser_tbl.qq is 'QQ';
comment on column sysuser_tbl.wechat is '微信号';