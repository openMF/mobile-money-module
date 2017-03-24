--Add Tenant App key for security
USE `mobile-money` ;

ALTER TABLE `tenant` ADD `app_key` VARCHAR( 100 ) NOT NULL AFTER `mobile_money_number` ;