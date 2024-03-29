## 追加commit命令
- git commit --amend --no-edit


## 资料
[github OAuth](https://docs.github.com/cn/developers/apps/building-oauth-apps/creating-an-oauth-app)
[Spring_文档](https://spring.io/guides)
[Spring web](https:/lspring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[Github deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[Bootstrap](https://v3.bootcss.com/getting-started/)
[thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)

## 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven)

## 脚本
```sql
create table USER_NAME
(
    ID           INTEGER auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        VARCHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    AC_TOKEN     VARCHAR(100),
    BIO          VARCHAR(256),
    constraint USER_NAME_PK
        primary key (ID)
);
```

```sql
create table comment
(
    id           bigint auto_increment,
    parent_id    bigint not null,
    type         int    not null,
    commentator  int    not null,
    gmt_create   bigint not null,
    gmt_modified bigint,
    like_count   bigint default 0,
    constraint COMMENT_PK
        primary key (id)
);
```
```bash
mvn flyway:migrate
mvn -D mybatis.generator.overwrite=true mybatis-generator:generate
```
