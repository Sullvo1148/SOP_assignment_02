DROP TABLE cart IF EXISTS;

CREATE TABLE cart (
    id int AUTO_INCREMENT,
    name varchar(255),
    type varchar(255),
    detail varchar(1000),
    calories double,
    price int
);

INSERT INTO cart (name, type, detail, calories, price) values ('test', 'test', 'test', 0.0, 10);