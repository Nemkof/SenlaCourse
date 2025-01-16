CREATE DATABASE homework; 
USE homework;

CREATE TABLE product (
    maker VARCHAR(10) NOT NULL,
    model VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    PRIMARY KEY (model)
);

CREATE TABLE laptop (
    code INT NOT NULL,
    model VARCHAR(50) NOT NULL,
    speed SMALLINT NOT NULL,
    ram SMALLINT NOT NULL,
    hd REAL NOT NULL,
    price DECIMAL(10,2),
    screen TINYINT NOT NULL,
    FOREIGN KEY (model) REFERENCES product(model)
);

CREATE TABLE pc (
    code INT NOT NULL,
    model VARCHAR(50) NOT NULL,
    speed SMALLINT NOT NULL,
    ram SMALLINT NOT NULL,
    hd REAL NOT NULL,
    cd VARCHAR(10) NOT NULL,
    price DECIMAL(10,2),
	FOREIGN KEY (model) REFERENCES product(model)
);

CREATE TABLE printer (
    code INT NOT NULL,
    model VARCHAR(50) NOT NULL,
    color CHAR(1) NOT NULL,
    type VARCHAR(10) NOT NULL,
    price DECIMAL(10,2),
	FOREIGN KEY (model) REFERENCES product(model)
);


