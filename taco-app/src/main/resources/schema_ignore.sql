create table if not exists Ingredient(
        id varchar(4) not null,
        name varchar(25) not null,
        type smallint not null,
        createdAt timestamp not null,
        PRIMARY KEY(id));


create table if not exists Taco(
        id bigint NOT NULL AUTO_INCREMENT,
        name varchar(50) not null,
        createdAt timestamp not null,
        PRIMARY KEY(id));


create table if not exists Taco_Ingredients(
        taco bigint not null,
        ingredient varchar(4) not null);

alter table Taco_Ingredients
    add foreign key (taco) references Taco(id);

alter table Taco_Ingredients
    add foreign key (ingredient) references Ingredient(id);

create table if not exists Taco_order(
        id bigint NOT NULL AUTO_INCREMENT,
        deliveryName varchar(50) not null,
        deliveryStreet varchar(50) not null,
        deliveryCity varchar(50) not null,
        deliveryState varchar(2) not null,
        deliveryZip varchar(10) not null,
        ccNumber varchar(16) not null,
        ccCVV varchar(3) not null,
        placedAt timestamp not null,
        PRIMARY KEY(id));

create table if not exists Taco_Order_Tacos(
        tacoOrder bigint not null,
        taco bigint not null);

alter table Taco_Order_Tacos
    add foreign key (tacoOrder) references Taco_order(id);

alter table Taco_Order_Tacos
    add foreign key (taco) references Taco(id);


create table if not exists User(
        id bigint NOT NULL AUTO_INCREMENT,
        username varchar(50),
        password varchar(300),
        fullname varchar(50),
        street varchar(30),
        city varchar(20),
        state varchar(10),
        zip varchar(20),
        phoneNumber varchar(20),
        PRIMARY KEY(id));

--create table authorities (
--      username varchar(50) not null,
--      authority varchar(50) not null,
--      constraint fk_authorities_users foreign key(username) references User(username));
--
--create unique index ix_auth_username on authorities (username,authority);