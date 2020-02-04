create table Car (
    id int unsigned primary key auto_increment,
    name varchar(100) not null,
    lpgPowered bit,
    onOn100km double(10.2) not null,
    lpgOn100Km double(10.2) not null,
    pbOn100Km double(10.2) not null
);