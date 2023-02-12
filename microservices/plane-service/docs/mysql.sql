CREATE SCHEMA `micro_plane` ;
Hibernate: 
    
    create table plane (
       id bigint not null auto_increment,
        plane_capacity varchar(255),
        plane_maker varchar(255),
        plane_model varchar(255),
        plane_reg_no varchar(255),
        primary key (id)
    ) engine=InnoDB