CREATE TABLE `product` (
    `code` BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `description` VARCHAR(500),
    `category` VARCHAR(100),
    `unity` VARCHAR(50),
    `unitaryPrice` DOUBLE(10 , 2 ),
    `totalPrice` DOUBLE(10 , 2 )
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO `product` (`code`, `name`, `description`, `category`, `unity`, `unitaryPrice`,`totalPrice` )
VALUES (NULL, 'Carretilha Marine Sports Caster', 'Carretilha Marine Sports Caster 400 3 Rol. Direita', 'Carretilhas', 'unity', 20.0, NULL);