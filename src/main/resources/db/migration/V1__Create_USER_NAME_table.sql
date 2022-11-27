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