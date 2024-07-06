CREATE TABLE Journal(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL ,
    topic VARCHAR(200) NOT NULL ,
    notes TEXT 
);

DESCRIBE journal ;

DROP TABLE journal;
