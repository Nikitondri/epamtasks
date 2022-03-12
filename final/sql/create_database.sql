CREATE DATABASE `cafe_db` DEFAULT CHARACTER SET utf8;

CREATE USER 'cafe_application'@'localhost' IDENTIFIED BY 'admin';
CREATE USER 'cafe_application'@'%' IDENTIFIED BY 'admin';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `cafe_db`.*
    TO 'cafe_application'@localhost;

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `cafe_db`.*
    TO 'cafe_application'@'%';