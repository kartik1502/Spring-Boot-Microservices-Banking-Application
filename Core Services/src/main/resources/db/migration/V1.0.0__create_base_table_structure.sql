-- core_service.user definition

CREATE TABLE `user`
(
    `user_id`                    bigint(20) NOT NULL AUTO_INCREMENT,
    `email_id`                 varchar(255) DEFAULT NULL,
    `first_name`            varchar(255) DEFAULT NULL,
    `identification_number` varchar(255) DEFAULT NULL,
    `last_name`             varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`)
);

-- core_service.bank_account definition

CREATE TABLE `bank_account`
(
    `bank_account_id`                bigint(20) NOT NULL AUTO_INCREMENT,
    `actual_balance`    decimal(19, 2) DEFAULT NULL,
    `available_balance` decimal(19, 2) DEFAULT NULL,
    `account_number`            varchar(255)   DEFAULT NULL,
    `account_status`            varchar(255)   DEFAULT NULL,
    `account_type`              varchar(255)   DEFAULT NULL,
    `user_id`           bigint(20) DEFAULT NULL,
    PRIMARY KEY (`bank_account_id`),
    KEY                 `FKt5uqy9p0v3rp3yhlgvm7ep0ij` (`user_id`),
    CONSTRAINT `FKt5uqy9p0v3rp3yhlgvm7ep0ij` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
);

-- core_service.utility_account definition

CREATE TABLE `utility_account`
(
    `utility_account_id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `account_number`        varchar(255) DEFAULT NULL,
    `provider_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`utility_account_id`)
);