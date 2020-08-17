# MySQL Schema

``` mysql
-유저 생성 및 권한주기와 관련 DB생성-
create user 'shareHouse'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'shareHouse'@'%';
create database shareHouse;
use shareHouse;


-FAQ 테이블 생성-
CREATE TABLE FAQ(
   	id int auto_increment primary key,
    type varchar(100) not null,
    title varchar(1000) unique not null,
    content BLOB not null,
    create_date timestamp
) engine=InnoDB default charset=utf8;

-house_detail 테이블 생성-
CREATE TABLE house_detail(
   	id int auto_increment primary key,
    img1 varchar(100),
    img2 varchar(100),
    img3 varchar(100),
    title varchar(200) not null,
    content BLOB not null,
    hash_tag varchar(100),
    tourPoint BLOB not null,
    address varchar(100) not null,
    gender char not null,
   	contractEndDate varchar(100) not null,
    maxResidencePersonnel int not null,
    house_form varchar(50) not null,
    construction varchar(100) not null,
    drawing varchar(100) not null,
    roomName varchar(100) not null,
    type varchar(100) not null,
    area varchar(100) not null,
    deposit varchar(100) not null,
    monthly varchar(100) not null,
    moveInDate varchar(100) not null,
    tourApply BLOB not null,
    subway varchar(100) not null,
    bus varchar(100) not null,
    university varchar(100),
    mart varchar(100) not null,
    facilities varchar(100) not null,
    heal varchar(100) not null,
    create_date timeStamp 
) engine=InnoDB default charset=utf8;
```



