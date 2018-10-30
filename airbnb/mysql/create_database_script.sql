SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `airbnbdb` DEFAULT CHARACTER SET utf8 ;
USE `airbnbdb` ;


CREATE TABLE IF NOT EXISTS `airbnbdb`.`User` (
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL,
  `surname` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnbdb`.`Localization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnbdb`.`Localization` (
  `country` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `building_number` VARCHAR(255) NOT NULL,
  `flat_number` VARCHAR(255) NULL,
  `id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `airbnbdb`.`Apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnbdb`.`Apartment` (
  `host` VARCHAR(255) NOT NULL,
  `price` FLOAT NOT NULL,
  `beds_adult` INT NOT NULL,
  `type` VARCHAR(255) NULL,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(4096) NOT NULL,
  `beds_child` INT NOT NULL,
  `localization_id` VARCHAR(255) NOT NULL,
  INDEX `host_email_idx` (`host` ASC),
  PRIMARY KEY (`host`, `price`, `localization_id`, `name`),
  INDEX `localization_id_idx` (`localization_id` ASC),
  CONSTRAINT `host_email`
    FOREIGN KEY (`host`)
    REFERENCES `airbnbdb`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `localization_id`
    FOREIGN KEY (`localization_id`)
    REFERENCES `airbnbdb`.`Localization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnbdb`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnbdb`.`Reservation` (
  `property_id` VARCHAR(255) NOT NULL,
  `account_email` VARCHAR(255) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`property_id`, `account_email`),
  INDEX `account_email_idx` (`account_email` ASC),
  CONSTRAINT `account_email`
    FOREIGN KEY (`account_email`)
    REFERENCES `airbnbdb`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `property_localization_id`
    FOREIGN KEY (`property_id`)
    REFERENCES `airbnbdb`.`Localization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnbdb`.`Message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnbdb`.`Message` (
  `sender` VARCHAR(255) NOT NULL,
  `receiver` VARCHAR(255) NOT NULL,
  `message` VARCHAR(2048) NOT NULL,
  `date` DATETIME NOT NULL,
  `isUnread` TINYINT NULL,
  PRIMARY KEY (`date`, `sender`, `receiver`),
  INDEX `receiver_email_idx` (`receiver` ASC),
  CONSTRAINT `sender_email`
    FOREIGN KEY (`sender`)
    REFERENCES `airbnbdb`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `receiver_email`
    FOREIGN KEY (`receiver`)
    REFERENCES `airbnbdb`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER 'userLQE'@'%' IDENTIFIED BY '2dAlhk2RqPhVlFOK';

GRANT ALL ON `airbnbdb`.* TO 'userLQE';
GRANT ALL ON `new_schema1`.* TO 'userLQE';
GRANT SELECT ON TABLE `airbnbdb`.* TO 'userLQE';
GRANT SELECT ON TABLE `new_schema1`.* TO 'userLQE';
GRANT SELECT, INSERT, TRIGGER ON TABLE `airbnbdb`.* TO 'userLQE';
GRANT SELECT, INSERT, TRIGGER ON TABLE `new_schema1`.* TO 'userLQE';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `airbnbdb`.* TO 'userLQE';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `new_schema1`.* TO 'userLQE';
GRANT EXECUTE ON `airbnbdb`.* TO 'userLQE';
GRANT EXECUTE ON `new_schema1`.* TO 'userLQE';