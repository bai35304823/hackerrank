CREATE SCHEMA `micro_schedule` ;
Hibernate: 
    
    create table flight (
       id bigint not null auto_increment,
        arrival_time datetime(6),
        capacity varchar(255),
        depart_airport_code varchar(255),
        depart_country_id varchar(255),
        departure_time datetime(6),
        dest_airport_code varchar(255),
        dest_country_id varchar(255),
        plane_reg_no varchar(255),
        schedule_id varchar(255),
        depart_airport_id bigint,
        depart_country bigint,
        dest_airport_id bigint,
        dest_country bigint,
        plane_id bigint,
        primary key (id)
    ) engine=InnoDB
    
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

Hibernate: 
    
    create table plane (
       id bigint not null auto_increment,
        plane_capacity varchar(255),
        plane_maker varchar(255),
        plane_model varchar(255),
        plane_reg_no varchar(255),
        primary key (id)
    ) engine=InnoDB