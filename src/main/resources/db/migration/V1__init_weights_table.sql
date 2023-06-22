drop table if exists WEIGHTS;
create table WEIGHTS(
    id int primary key auto_increment,
    date_weight date not null,
    body_weight float not null,
    description varchar(100)
)