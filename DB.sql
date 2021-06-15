-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET cp1251 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Address` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Address` (
  `idAddress` BIGINT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `street` VARCHAR(45) NULL DEFAULT NULL,
  `numHouse` VARCHAR(45) NULL DEFAULT NULL,
  `User_idUser` BIGINT NOT NULL,
  PRIMARY KEY (`idAddress`, `User_idUser`),
  UNIQUE INDEX `idAddress_UNIQUE` (`idAddress` ASC) VISIBLE,
  UNIQUE INDEX `city_UNIQUE` (`city` ASC) VISIBLE,
  UNIQUE INDEX `street_UNIQUE` (`street` ASC) VISIBLE,
  UNIQUE INDEX `numHouse_UNIQUE` (`numHouse` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`Basket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Basket` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Basket` (
  `amount` INT NULL DEFAULT '1',
  `User_idUser` BIGINT NOT NULL,
  `Book_idBook` BIGINT NOT NULL,
  `Bought` TINYINT NULL DEFAULT '0',
  PRIMARY KEY (`User_idUser`, `Book_idBook`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Book` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Book` (
  `idBook` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `author` VARCHAR(45) NULL DEFAULT NULL,
  `cost` DOUBLE NOT NULL,
  `url` VARCHAR(100) NOT NULL DEFAULT 'https://mrb.imgix.net/assets/default-book.png',
  `briefInfo` VARCHAR(1000) NOT NULL,
  `amount` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idBook`),
  UNIQUE INDEX `idBook_UNIQUE` (`idBook` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Order` (
  `idOrder` BIGINT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `Basket_idBasket` BIGINT NOT NULL,
  `Basket_User_idUser` BIGINT NOT NULL,
  `Basket_Book_idBook` BIGINT NOT NULL,
  PRIMARY KEY (`idOrder`, `Basket_idBasket`, `Basket_User_idUser`, `Basket_Book_idBook`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `idUser` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `lastName` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(100) CHARACTER SET 'utf8' NOT NULL,
  `roleID` INT NOT NULL DEFAULT '1',
  `phoneNumber` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `idUser_UNIQUE` (`idUser` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('1', 'To Kill a Mockingbird', '12.99', 'https://images-na.ssl-images-amazon.com/images/I/51IXWZzlgSL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad atque iste laborum nemo unde!\n                        Blanditiis optio perspiciatis quidem vero voluptates', '10');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('2', 'Shakespeare Bats Cleanup',  '10.59', 'https://images-na.ssl-images-amazon.com/images/I/51k1H84qiCL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda at dolores eaque fuga laboriosam nisi praesentium quas sapiente tenetur vero.', '5');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('3', 'The Kite Runner', '15.39', 'https://images-na.ssl-images-amazon.com/images/I/51vRNqL61aL._SX318_BO1,204,203,200_.jpg', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum minima provident quisquam reiciendis. Consectetur eum incidunt molestias necessitatibus. Dolore, tempore!', '20');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('4', 'Malibu Rising',  '23.99', 'https://m.media-amazon.com/images/I/518bm5DN-VS.jpg', 'Read with Jenna Book Club Pick as Featured on Today From the New York Times bestselling author of Daisy Jones & The Six and The Seven Husbands of Evelyn Hugo . . . ', '30');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('5', 'The Music of Bees: A Novel',  '20', 'https://mrb.imgix.net/assets/default-book.png', 'Three lonely strangers in a rural Oregon town, each working through grief and life\'s curveballs, are brought together by happenstance on a local honeybee farm where they find surprising friendship.', '20');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('8', 'American Dirt',  '15.49', 'https://mrb.imgix.net/assets/default-book.png', '\"This book is not simply the great American novel; itâs the great novel of las Americas. Itâs the great world novel! This is the international story of our times. Masterful.\" âSandra Cisneros', '30');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('10', 'The Moonlight Child',  '18.99', 'https://m.media-amazon.com/images/I/416mBhHXQ1L.jpg', 'âI cannot recommend this book highly enough! It\'s a definite must read. - Reader Review   A gripping and emotional novel that will leave you wondering about the neighbors next door... ', '100');
INSERT INTO `mydb`.`Book` (`idBook`, `name`, `cost`, `url`, `briefInfo`, `amount`) VALUES ('11', 'The Pale-Faced Lie','19.89', 'https://m.media-amazon.com/images/I/51gQxIh+1PL.jpg', 'Spur Award Winner for Best Western First Nonfiction Book â¢ Spur Award Finalist for Best Western Contemporary Nonfiction â¢ IPPY Silver Award.', '20');


INSERT INTO `mydb`.`User` (`idUser`, `firstName`, `lastName`, `email`, `password`, `roleID`, `phoneNumber`) VALUES (
'12','Admin','Admin','admin@gmail.com','cnOJiNcAyPcUix+17lZej+dFFi3CwxETyG9mqvMDwTI=','2','87771231212');
INSERT INTO `mydb`.`User` (`idUser`, `firstName`, `lastName`, `email`, `password`, `roleID`, `phoneNumber`) VALUES ('19','User','User','user@gmail.com','e41EogRisZS4g29lYu/xAn30jLR0YnFoHuLN6AX4M5Q=','1','user123');


