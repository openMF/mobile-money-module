-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mobile-money
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mobile-money
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mobile-money` DEFAULT CHARACTER SET utf8 ;
USE `mobile-money` ;

-- -----------------------------------------------------
-- Table `mobile-money`.`mobile_money_operator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile-money`.`mobile_money_operator` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `country_code` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `created_on` TIMESTAMP NOT NULL,
  `last_modified_on` TIMESTAMP NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobile-money`.`tenant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile-money`.`tenant` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `mobile_money_number` INT(20) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobile-money`.`operator_configuration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile-money`.`operator_configuration` (
  `id` BIGINT NOT NULL,
  `config_name` VARCHAR(45) NOT NULL,
  `config_value` VARCHAR(200) NOT NULL,
  `mobile_money_operator_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `mobile_money_operator_id`),
  INDEX `fk_operator_configuration_mobile_money_operator1_idx` (`mobile_money_operator_id` ASC),
  CONSTRAINT `fk_operator_configuration_mobile_money_operator1`
    FOREIGN KEY (`mobile_money_operator_id`)
    REFERENCES `mobile-money`.`mobile_money_operator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobile-money`.`tenant_transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile-money`.`tenant_transaction` (
  `id` BIGINT NOT NULL,
  `account_type` VARCHAR(45) NOT NULL,
  `transaction_type` VARCHAR(45) NOT NULL,
  `amount` DECIMAL NOT NULL,
  `fineract_transaction_id` VARCHAR(45) NOT NULL,
  `fineract_account_id` VARCHAR(45) NULL,
  `fineract_client_id` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `tenant_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `tenant_id`),
  INDEX `fk_tenant_transaction_tenant1_idx` (`tenant_id` ASC),
  CONSTRAINT `fk_tenant_transaction_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `mobile-money`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobile-money`.`tenant_mobile_money_operator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobile-money`.`tenant_mobile_money_operator` (
  `tenant_id` BIGINT UNSIGNED NOT NULL,
  `mobile_money_operator_id` BIGINT NOT NULL,
  PRIMARY KEY (`tenant_id`, `mobile_money_operator_id`),
  INDEX `fk_tenant_has_mobile_money_operator_mobile_money_operator1_idx` (`mobile_money_operator_id` ASC),
  INDEX `fk_tenant_has_mobile_money_operator_tenant_idx` (`tenant_id` ASC),
  CONSTRAINT `fk_tenant_has_mobile_money_operator_tenant`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `mobile-money`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tenant_has_mobile_money_operator_mobile_money_operator1`
    FOREIGN KEY (`mobile_money_operator_id`)
    REFERENCES `mobile-money`.`mobile_money_operator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
