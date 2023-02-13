CREATE SCHEMA `micro_registration` ;
Hibernate: 
    
    create table registrations (
       email varchar(25) not null,
        access_count bigint not null,
        access_time datetime(6),
        admin_name varchar(25) not null,
        password varchar(255),
        phone varchar(255),
        salt tinyblob,
        primary key (email)
    ) engine=InnoDB