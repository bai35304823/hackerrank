CREATE SCHEMA `micro_country` ;
Hibernate: 
    
    create table country (
       id bigint not null auto_increment,
        country_city varchar(255),
        country_id varchar(255),
        country_name varchar(255),
        country_state varchar(255),
        primary key (id)
    ) engine=InnoDB