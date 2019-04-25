USE mysql;

-- -----------------------------------------------------
-- Database example
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS example DEFAULT CHARACTER SET utf8;

-- -----------------------------------------------------
-- Schema example
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS example DEFAULT CHARACTER SET utf8;
USE example;

-- -----------------------------------------------------
-- Users
-- -----------------------------------------------------
DROP USER IF EXISTS 'example'@'localhost';
DROP USER IF EXISTS 'example'@'%';

CREATE USER IF NOT EXISTS 'example'@'localhost'
    IDENTIFIED BY 'P@ssw0rd';

CREATE USER IF NOT EXISTS 'example'@'%'
    IDENTIFIED BY 'P@ssw0rd';

GRANT ALL PRIVILEGES ON example.* TO 'example'@'localhost'
    IDENTIFIED BY 'P@ssw0rd';

GRANT ALL PRIVILEGES ON example.* TO 'example'@'%'
    IDENTIFIED BY 'P@ssw0rd';

FLUSH PRIVILEGES;
