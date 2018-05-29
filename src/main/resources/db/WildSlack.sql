-- MySQL Script generated by MySQL Workbench
-- Fri May 11 11:34:37 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wildslack
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wildslack` DEFAULT CHARACTER SET utf8 ;
USE `wildslack` ;

-- -----------------------------------------------------
-- Table `wildslack`.`workspace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`workspace` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `wildslack`.`app_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(50)NOT NULL,
  PRIMARY KEY (`id`));

  INSERT INTO app_role values(1, 'USER');
  INSERT INTO app_role values(2, 'ADMIN');

-- -----------------------------------------------------
-- Table `wildslack`.`chanel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`chanel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  `id_workspace` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (`id_workspace` ASC),
  CONSTRAINT `chanel`
    FOREIGN KEY (`id_workspace`)
    REFERENCES `wildslack`.`workspace` (`id`));


-------------------------------------------------------
-- Table `wildslack`.`AppUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),

  UNIQUE INDEX `mail_UNIQUE` (`email` ASC));


-- -----------------------------------------------------
-- Table `wildslack`.`workspace_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`workspace_member` (
  `id_user` INT NOT NULL,
  `id_workspace` INT NOT NULL,
  INDEX (`id_user` ASC),
  INDEX (`id_workspace` ASC),
  CONSTRAINT `workspace_member`
    FOREIGN KEY (`id_user`)
    REFERENCES `wildslack`.`user` (`id`),
  CONSTRAINT ``
    FOREIGN KEY (`id_workspace`)
    REFERENCES `wildslack`.`workspace` (`id`));


-- -----------------------------------------------------
-- Table `wildslack`.`chanel_manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`chanel_manager` (
  `id_user` INT NOT NULL,
  `id_chanel` INT NOT NULL,
  INDEX (`id_user` ASC),
  INDEX (`id_chanel` ASC),
  CONSTRAINT `chanel_manager_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `wildslack`.`user` (`id`),
  CONSTRAINT `chanel_manager`
    FOREIGN KEY (`id_chanel`)
    REFERENCES `wildslack`.`chanel` (`id`));


-- -----------------------------------------------------
-- Table `wildslack`.`chanel_member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`chanel_member` (
  `id_chanel` INT NOT NULL,
  `id_user` INT NOT NULL,
  INDEX (`id_chanel` ASC),
  INDEX (`id_user` ASC),
  CONSTRAINT `chanel_member`
    FOREIGN KEY (`id_chanel`)
    REFERENCES `wildslack`.`chanel` (`id`),
  CONSTRAINT `chanel_member_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `wildslack`.`user` (`id`));


-- -----------------------------------------------------
-- Table `wildslack`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `wildslack`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`post` (
  `id_user` INT NOT NULL,
  `id_message` INT NOT NULL,
  `id_chanel` INT NOT NULL,
  INDEX (`id_user` ASC),
  INDEX (`id_message` ASC),
  INDEX (`id_chanel` ASC),
  CONSTRAINT `post_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `wildslack`.`user` (`id`),
  CONSTRAINT `post_message`
    FOREIGN KEY (`id_message`)
    REFERENCES `wildslack`.`message` (`id`),
  CONSTRAINT `post_chanel`
    FOREIGN KEY (`id_chanel`)
    REFERENCES `wildslack`.`chanel` (`id`));


-- -----------------------------------------------------
-- Table `wildslack`.`workspace_manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wildslack`.`workspace_manager` (
  `id_user` INT NOT NULL,
  `id_workspace` INT NOT NULL,
  INDEX (`id_user` ASC),
  INDEX (`id_workspace` ASC),
  CONSTRAINT `workspace_manager_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `wildslack`.`user` (`id`),
  CONSTRAINT `workspace_manager`
    FOREIGN KEY (`id_workspace`)
    REFERENCES `wildslack`.`workspace` (`id`));


INSERT INTO app_role values(1, 'USER');
INSERT INTO app_role values(2, 'ADMIN');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
