SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema argcoin_base
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema argcoin_base
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `argcoin_base` DEFAULT CHARACTER SET utf8 ;
USE `argcoin_base` ;

-- -----------------------------------------------------
-- Table `argcoin_base`.`formadepago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`formadepago` (
  `idformadepago` INT NOT NULL,
  `numerodebito` VARCHAR(45) NULL,
  `numerocredito` VARCHAR(45) NULL,
  `titular` VARCHAR(45) NULL,
  `tipoformadepago` VARCHAR(45) NULL,
  PRIMARY KEY (`idformadepago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `cantidadPesos` DOUBLE NULL,
  `formadepago_idformadepago` INT NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_formadepago1_idx` (`formadepago_idformadepago` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_formadepago1`
    FOREIGN KEY (`formadepago_idformadepago`)
    REFERENCES `argcoin_base`.`formadepago` (`idformadepago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`billeteravirtual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`billeteravirtual` (
  `idbilleteravirtual` INT NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idbilleteravirtual`),
  INDEX `fk_billeteravirtual_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_billeteravirtual_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `argcoin_base`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`criptomoneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`criptomoneda` (
  `idcriptomoneda` INT NOT NULL,
  `cantidad` DOUBLE NULL,
  `billeteravirtual_idbilleteravirtual` INT NOT NULL,
  PRIMARY KEY (`idcriptomoneda`),
  INDEX `fk_criptomoneda_billeteravirtual1_idx` (`billeteravirtual_idbilleteravirtual` ASC) VISIBLE,
  CONSTRAINT `fk_criptomoneda_billeteravirtual1`
    FOREIGN KEY (`billeteravirtual_idbilleteravirtual`)
    REFERENCES `argcoin_base`.`billeteravirtual` (`idbilleteravirtual`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`clientepremium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`clientepremium` (
  `idclientepremium` INT NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` INT NOT NULL,
  `clientepremium_idclientepremium` INT NOT NULL,
  PRIMARY KEY (`idclientepremium`),
  INDEX `fk_clientepremium_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_clientepremium_clientepremium1_idx` (`clientepremium_idclientepremium` ASC) VISIBLE,
  CONSTRAINT `fk_clientepremium_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `argcoin_base`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientepremium_clientepremium1`
    FOREIGN KEY (`clientepremium_idclientepremium`)
    REFERENCES `argcoin_base`.`clientepremium` (`idclientepremium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`clientebasico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`clientebasico` (
  `idclientebasico` INT NOT NULL AUTO_INCREMENT,
  `puntosbienvenida` DOUBLE NULL,
  `cliente_idcliente` INT NOT NULL,
  `clientepremium_idclientepremium` INT NOT NULL,
  PRIMARY KEY (`idclientebasico`),
  INDEX `fk_clientebasico_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_clientebasico_clientepremium1_idx` (`clientepremium_idclientepremium` ASC) VISIBLE,
  CONSTRAINT `fk_clientebasico_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `argcoin_base`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientebasico_clientepremium1`
    FOREIGN KEY (`clientepremium_idclientepremium`)
    REFERENCES `argcoin_base`.`clientepremium` (`idclientepremium`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`transaccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`transaccion` (
  `idtransaccion` INT NOT NULL AUTO_INCREMENT,
  `estadotransaccion` INT NULL,
  `fecha` DATE NULL,
  `cantidad` DOUBLE NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idtransaccion`),
  INDEX `fk_transaccion_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_transaccion_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `argcoin_base`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`casadecambio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`casadecambio` (
  `idcadadecambio` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`idcadadecambio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `argcoin_base`.`casadecambio_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `argcoin_base`.`casadecambio_cliente` (
  `idcasadecambio_cliente` INT NOT NULL,
  `casadecambio_idcadadecambio` INT NULL,
  `cliente_idcliente` INT NULL,
  PRIMARY KEY (`idcasadecambio_cliente`),
  INDEX `fk_casadecambio_cliente_casadecambio1_idx` (`casadecambio_idcadadecambio` ASC) VISIBLE,
  INDEX `fk_casadecambio_cliente_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  UNIQUE INDEX `casadecambio_idcadadecambio_UNIQUE` (`casadecambio_idcadadecambio` ASC) VISIBLE,
  UNIQUE INDEX `cliente_idcliente_UNIQUE` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_casadecambio_cliente_casadecambio1`
    FOREIGN KEY (`casadecambio_idcadadecambio`)
    REFERENCES `argcoin_base`.`casadecambio` (`idcadadecambio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_casadecambio_cliente_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `argcoin_base`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
