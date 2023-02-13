CREATE SCHEMA `micro_booking` ;
Hibernate: 
    
    create table booking (
       id bigint not null auto_increment,
        booking_id varchar(255),
        date_of_flight date,
        departure varchar(255),
        destination varchar(255),
        passenger_id varchar(255),
        schedule_id varchar(255),
        seat_no varchar(255),
        ticket_cost decimal(19,2),
        total_amt decimal(19,2),
        flight_id bigint,
        passengers_id bigint,
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
    
    create table passengers (
       id bigint not null auto_increment,
        contact_no varchar(255),
        passengerid varchar(255),
        passenger_name varchar(255),
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