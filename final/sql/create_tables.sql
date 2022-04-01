USE `cafe_db`;

CREATE TABLE `user_account`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) NOT NULL UNIQUE,
    `password` CHAR(128) NOT NULL, /*SHA3-512*/
    `role` ENUM('CLIENT','ADMIN','WORKER') NOT NULL,
    `status` TINYINT NOT NULL CHECK (`status` IN (0, 1)),
    CONSTRAINT PK_user_account PRIMARY KEY(`id`),
    UNIQUE (`login`)
);

CREATE TABLE `user_info`(
    `id` INT UNSIGNED NOT NULL,
    `surname` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `phone` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `balance` DECIMAL(8, 2) UNSIGNED NOT NULL DEFAULT 0.00,
    `bonus` DECIMAL(8, 2) UNSIGNED NOT NULL DEFAULT 0.00,
    CONSTRAINT PK_user_info PRIMARY KEY (`id`),
    UNIQUE (`phone`),
    UNIQUE (`email`),
    CONSTRAINT FK_account FOREIGN KEY (`id`)
        REFERENCES `user_account` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE `order`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` INT UNSIGNED NOT NULL,
    `status` ENUM('ACTIVE','READY','CANCELED','FINISHED') NOT NULL DEFAULT 'ACTIVE',
    `cost` DECIMAL(8, 2) UNSIGNED NOT NULL,
    `payment_type` ENUM('CASH','CREDIT_CARD','BALANCE') NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `desired_time` DATETIME,
    `finished_time` DATETIME,
    `bonuses_used` DECIMAL(8, 2) UNSIGNED NOT NULL DEFAULT 0.00,
    `rating` TINYINT CHECK (`rating` IN (0, 1, 2, 3, 4, 5)),
    `worker_id` INT UNSIGNED NOT NULL,
    CONSTRAINT PK_order PRIMARY KEY (`id`),
    CONSTRAINT FK_user_id FOREIGN KEY (`user_id`)
        REFERENCES `user_account` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_worker_id FOREIGN KEY (`worker_id`)
        REFERENCES `user_account` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE `dish_type`(
    `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    CONSTRAINT PK_dish_type PRIMARY KEY (`id`),
    UNIQUE (`name`)
);

CREATE TABLE `dish`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `cost` DECIMAL(8, 2) UNSIGNED NOT NULL,
    `is_enable` TINYINT NOT NULL CHECK (`is_enable` IN (0, 1)),
    `type_id` TINYINT UNSIGNED NOT NULL,
    `dish_weight` INT NOT NULL,
    `description` TEXT NOT NULL,
    `picture_path` VARCHAR(255) NOT NULL,
    CONSTRAINT PK_dish PRIMARY KEY (`id`),
    UNIQUE (`name`),
    CONSTRAINT FK_dish_type FOREIGN KEY (`type_id`)
        REFERENCES `dish_type` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE `review`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `dish_id` INT UNSIGNED NOT NULL,
    `user_id` INT UNSIGNED NOT NULL,
    `parent_id` INT UNSIGNED,
    `text` TEXT NOT NULL,
    `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_review PRIMARY KEY (`id`),
    CONSTRAINT FK_review_dish_id FOREIGN KEY (`dish_id`)
        REFERENCES `dish` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_review_user_id FOREIGN KEY (`user_id`)
        REFERENCES `user_account` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_review_parent_id FOREIGN KEY (`parent_id`)
        REFERENCES `review` (`id`)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE INDEX cost ON dish(cost);
CREATE INDEX type_id ON dish(type_id);

CREATE TABLE `order_dish`(
     `dish_id` INT UNSIGNED NOT NULL,
     `count` INT UNSIGNED NOT NULL,
     `order_id` INT UNSIGNED NOT NULL,
     CONSTRAINT PK_order_point PRIMARY KEY (`dish_id`,`order_id`),
     CONSTRAINT FK_order_dish FOREIGN KEY (`dish_id`)
         REFERENCES `dish` (`id`)
         ON UPDATE CASCADE
         ON DELETE RESTRICT,
     CONSTRAINT FK_order FOREIGN KEY (`order_id`)
         REFERENCES `order` (`id`)
         ON UPDATE CASCADE
         ON DELETE RESTRICT
);

