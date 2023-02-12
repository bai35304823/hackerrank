CREATE SCHEMA `micro_passenger` ;
Hibernate: 
    
    create table passengers (
       id bigint not null auto_increment,
        contact_no varchar(255),
        passengerid varchar(255),
        passenger_name varchar(255),
        primary key (id)
    ) engine=InnoDB