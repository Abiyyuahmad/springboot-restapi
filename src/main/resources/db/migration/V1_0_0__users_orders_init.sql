CREATE TABLE `user` (
    `id` BigInt( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR ( 50 ) NOT NULL UNIQUE ,
    `first_name` VARCHAR ( 50 ) NOT NULL,
    `last_name` VARCHAR ( 50 ) NOT NULL,
    `email_address` VARCHAR ( 50 ) NOT NULL,
    `role` VARCHAR ( 50 ) NOT NULL,
    `ssn` VARCHAR ( 50 ) NOT NULL UNIQUE,
    `password` VARCHAR ( 100 ) NOT NULL,
    `address` VARCHAR ( 100 ),
    PRIMARY KEY ( `id` )
);

CREATE TABLE `orders` (
    `orderid` BigInt( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT,
    `orderdescription` VARCHAR ( 100 ) ,
    `user_id` BigInt( 20 ) NOT NULL,
    PRIMARY KEY ( `orderid` )
);
