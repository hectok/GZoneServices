-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema gzone
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gzone
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gzone` DEFAULT CHARACTER SET utf8 ;
USE `gzone` ;

-- -----------------------------------------------------
-- Table `gzone`.`Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Pais` (
  `id_Pais` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id_Pais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Localizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Localizacion` (
  `idLocalizacion` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `provincia` VARCHAR(45) NOT NULL,
  `calle` VARCHAR(50) NULL,
  `codigo_postal` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `id_Pais` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idLocalizacion`),
  INDEX `fk_Localizacion_Pais1_idx` (`id_Pais` ASC),
  CONSTRAINT `fk_Localizacion_Pais1`
    FOREIGN KEY (`id_Pais`)
    REFERENCES `gzone`.`Pais` (`id_Pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Usuario` (
  `id_usuario` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Clave primaria que se usara para definir a un usuario.',
  `usuario` VARCHAR(255) NOT NULL COMMENT 'Nombre de usuario, que sera unico para cada nuevo miembro.No se pueden emplear simbolos.',
  `correo` VARCHAR(255) NOT NULL COMMENT 'Correo electronico del usuario. Solo se puede tener un usuario por correo electronico por lo que lo marcaremos como UNIQUE',
  `contrasena` VARCHAR(255) NOT NULL COMMENT 'Contraseña propia del usuario. ',
  `nombre` VARCHAR(255) NULL COMMENT 'Nombre real del usuario. Puede ser opcional en caso de que no quiera dar sus datos. No puede contener simbolos ni numeros',
  `apellido` VARCHAR(100) NULL,
  `descripcion` TEXT NULL COMMENT 'Breve descripcion de uno mismo. Gustos y aficiones.',
  `localizacion` INT UNSIGNED NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `usuario` (`usuario` ASC),
  UNIQUE INDEX `correo` (`correo` ASC),
  INDEX `fk_Usuario_Localizacion1_idx` (`localizacion` ASC),
  CONSTRAINT `fk_Usuario_Localizacion1`
    FOREIGN KEY (`localizacion`)
    REFERENCES `gzone`.`Localizacion` (`idLocalizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Ticket` (
  `cod_compra` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Numero de compra de un producto (producto) por un cliente (usuario). El codigo de compra se implementa para tener un registro de todas las compra-ventas hechas.',
  `cantidad` INT NOT NULL,
  `fecha_compra` DATE NOT NULL COMMENT 'Fecha de compra del producto. Para un mayor detalle se guardara hasta el minuto de la compra.',
  `dir_facturacion` VARCHAR(255) NOT NULL COMMENT 'Dirección obligatoria en la que se realiza el cobro',
  `id_usuario` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`cod_compra`),
  INDEX `fk_Compra_Usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_Compra_Usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gzone`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Oferta` (
  `id_oferta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_creacion` DATE NOT NULL,
  `precio` DECIMAL(5,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_oferta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Producto` (
  `id_producto` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Clave primaria de un producto cualquiera. Se autoincrementa cada vez que se añade un producto a la base de datos.',
  `nombre` VARCHAR(255) NOT NULL COMMENT 'Nombre del producto. Suponemos que no hay dos productos con el mismo nombre.',
  `precio` DECIMAL(5,2) NOT NULL COMMENT 'Precio en euros del producto. En caso de ser un producto free to play su precio sera de 0',
  `anio` INT UNSIGNED NOT NULL,
  `requisitos` TEXT NULL DEFAULT NULL COMMENT 'Tabla con los requisitos del juego',
  `id_oferta` INT UNSIGNED NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  INDEX `fk_Producto_Oferta1_idx` (`id_oferta` ASC),
  CONSTRAINT `fk_Producto_Oferta1`
    FOREIGN KEY (`id_oferta`)
    REFERENCES `gzone`.`Oferta` (`id_oferta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Linea_Ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Linea_Ticket` (
  `cod_compra` INT UNSIGNED NOT NULL,
  `producto_id` INT(11) UNSIGNED NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`cod_compra`, `producto_id`),
  INDEX `fk_Compra_has_Producto_Producto1_idx` (`producto_id` ASC),
  INDEX `fk_Compra_has_Producto_Compra1_idx` (`cod_compra` ASC),
  CONSTRAINT `fk_Compra_has_Producto_Compra1`
    FOREIGN KEY (`cod_compra`)
    REFERENCES `gzone`.`Ticket` (`cod_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_has_Producto_Producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `gzone`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`NJugadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`NJugadores` (
  `id_nJugadores` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `njugadores` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_nJugadores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Producto_NJugadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Producto_NJugadores` (
  `id_producto` INT(11) UNSIGNED NOT NULL,
  `id_njugador` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_producto`, `id_njugador`),
  INDEX `fk_Producto_has_NJugadores_NJugadores1_idx` (`id_njugador` ASC),
  INDEX `fk_Producto_has_NJugadores_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Producto_has_NJugadores_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `gzone`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_NJugadores_NJugadores1`
    FOREIGN KEY (`id_njugador`)
    REFERENCES `gzone`.`NJugadores` (`id_nJugadores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Idioma` (
  `id_idioma` CHAR(3) NOT NULL,
  `idioma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_idioma`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Producto_Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Producto_Idioma` (
  `id_producto` INT(11) UNSIGNED NOT NULL,
  `id_idioma` CHAR(3) NOT NULL,
  `detalles_largo` TEXT NULL,
  `detalles_corto` TEXT NULL,
  PRIMARY KEY (`id_producto`, `id_idioma`),
  INDEX `fk_Producto_has_Idioma_Idioma1_idx` (`id_idioma` ASC),
  INDEX `fk_Producto_has_Idioma_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Producto_has_Idioma_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `gzone`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Idioma_Idioma1`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `gzone`.`Idioma` (`id_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Categoria_Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Categoria_Idioma` (
  `id_categoria` INT NOT NULL,
  `id_idioma` CHAR(3) NOT NULL,
  `categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`id_categoria`, `id_idioma`),
  INDEX `fk_Categoria_has_Idioma_Idioma1_idx` (`id_idioma` ASC),
  INDEX `fk_Categoria_has_Idioma_Categoria1_idx` (`id_categoria` ASC),
  CONSTRAINT `fk_Categoria_has_Idioma_Categoria1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `gzone`.`Categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Categoria_has_Idioma_Idioma1`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `gzone`.`Idioma` (`id_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gzone`.`Producto_Idioma_Disponible`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Producto_Idioma_Disponible` (
  `id_producto` INT(11) UNSIGNED NOT NULL,
  `id_idioma` CHAR(3) NOT NULL,
  PRIMARY KEY (`id_producto`, `id_idioma`),
  INDEX `fk_Producto_has_Idioma1_Idioma1_idx` (`id_idioma` ASC),
  INDEX `fk_Producto_has_Idioma1_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Producto_has_Idioma1_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `gzone`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Idioma1_Idioma1`
    FOREIGN KEY (`id_idioma`)
    REFERENCES `gzone`.`Idioma` (`id_idioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gzone`.`Producto_Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gzone`.`Producto_Categoria` (
  `id_producto` INT(11) UNSIGNED NOT NULL,
  `id_categoria` INT NOT NULL,
  PRIMARY KEY (`id_producto`, `id_categoria`),
  INDEX `fk_Producto_has_Categoria_Categoria1_idx` (`id_categoria` ASC),
  INDEX `fk_Producto_has_Categoria_Producto1_idx` (`id_producto` ASC),
  CONSTRAINT `fk_Producto_has_Categoria_Producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `gzone`.`Producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Categoria_Categoria1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `gzone`.`Categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;