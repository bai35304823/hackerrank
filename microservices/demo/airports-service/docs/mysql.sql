CREATE SCHEMA `micro_airports` ;
Hibernate: 
    
    create table airport (
       id bigint not null auto_increment,
        airport_code varchar(255),
        airport_name varchar(255),
        country_id varchar(255),
        country bigint,
        primary key (id)
    ) engine=InnoDB
Hibernate: 
    
    create table country (
       id bigint not null auto_increment,
        country_city varchar(255),
        country_id varchar(255),
        country_name varchar(255),
        country_state varchar(255),
        primary key (id)
    ) engine=InnoDB