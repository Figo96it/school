
CREATE TABLE if not exists School (
    id int not null,
    name varchar(255) not null,
    address varchar(255) not null,
    class_id int,
    PRIMARY KEY (id)
);