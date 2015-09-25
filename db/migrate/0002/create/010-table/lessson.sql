create table LESSSON (
    ID int not null auto_increment,
    USER_ID varchar(64),
    LESSON_NAME varchar(64),
    INSTRUCTOR varchar(64),
    LESSON_DATE varchar(64),
    LESSON_TIME_FROM varchar(64),
    LESSON_TIME_TO varchar(64),
    LESSON_TENPO varchar(64),
    constraint LESSSON_PK primary key(ID)
);
