-- MySQL Script generated by MySQL Workbench
-- Wed May 26 18:54:39 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Sistema_de_Biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Sistema_de_Biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Sistema_de_Biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `Sistema_de_Biblioteca` ;

-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Editorial` (
  `idEditorial` INT NOT NULL AUTO_INCREMENT,
  `nombreEditorial` VARCHAR(45) NULL,
  `estadoEditorial` INT NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Biblioteca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Biblioteca` (
  `idBiblioteca` INT NOT NULL AUTO_INCREMENT,
  `nombreBiblioteca` VARCHAR(45) NULL,
  `direccionBiblioteca` VARCHAR(45) NOT NULL,
  `rutBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idBiblioteca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Libro` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `numeroSerieLibro` VARCHAR(45) NULL,
  `isbnLibro` VARCHAR(45) NULL,
  `tituloLibro` VARCHAR(45) NULL,
  `numpaginaLibro` INT NULL,
  `precioLibro` INT NULL,
  `anhopublicacionLibro` DATE NULL,
  `estadoLibro` INT NULL,
  `editorial_idEditorial` INT NOT NULL,
  `Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `editorial_idEditorial`, `Biblioteca_idBiblioteca`),
  INDEX `fk_libro_editorial1_idx` (`editorial_idEditorial` ASC) VISIBLE,
  INDEX `fk_Libro_Biblioteca1_idx` (`Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_libro_editorial1`
    FOREIGN KEY (`editorial_idEditorial`)
    REFERENCES `Sistema_de_Biblioteca`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_Biblioteca1`
    FOREIGN KEY (`Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombreAutor` VARCHAR(45) NULL,
  `apPaternoAutor` VARCHAR(45) NULL,
  `apMaternoAutor` VARCHAR(45) NULL,
  `estadoAutor` INT NULL,
  `table1col` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`libro_has_Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`libro_has_Autor` (
  `libro_idLibro` INT NOT NULL,
  `Autor_idAutor` INT NOT NULL,
  PRIMARY KEY (`libro_idLibro`, `Autor_idAutor`),
  INDEX `fk_libro_has_Autor_Autor1_idx` (`Autor_idAutor` ASC) VISIBLE,
  INDEX `fk_libro_has_Autor_libro_idx` (`libro_idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_has_Autor_libro`
    FOREIGN KEY (`libro_idLibro`)
    REFERENCES `Sistema_de_Biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_has_Autor_Autor1`
    FOREIGN KEY (`Autor_idAutor`)
    REFERENCES `Sistema_de_Biblioteca`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombreCategoria` VARCHAR(45) NULL,
  `estadoCategoria` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`libro_has_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`libro_has_categoria` (
  `libro_idLibro` INT NOT NULL,
  `categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`libro_idLibro`, `categoria_idCategoria`),
  INDEX `fk_libro_has_categoria_categoria1_idx` (`categoria_idCategoria` ASC) VISIBLE,
  INDEX `fk_libro_has_categoria_libro1_idx` (`libro_idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_libro_has_categoria_libro1`
    FOREIGN KEY (`libro_idLibro`)
    REFERENCES `Sistema_de_Biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_has_categoria_categoria1`
    FOREIGN KEY (`categoria_idCategoria`)
    REFERENCES `Sistema_de_Biblioteca`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Idioma` (
  `ididioma` INT NOT NULL AUTO_INCREMENT,
  `nombreIdioma` VARCHAR(45) NULL,
  `estadoIdioma` INT NULL,
  PRIMARY KEY (`ididioma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`idioma_has_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`idioma_has_libro` (
  `idioma_ididioma` INT NOT NULL,
  `libro_idLibro` INT NOT NULL,
  PRIMARY KEY (`idioma_ididioma`, `libro_idLibro`),
  INDEX `fk_idioma_has_libro_libro1_idx` (`libro_idLibro` ASC) VISIBLE,
  INDEX `fk_idioma_has_libro_idioma1_idx` (`idioma_ididioma` ASC) VISIBLE,
  CONSTRAINT `fk_idioma_has_libro_idioma1`
    FOREIGN KEY (`idioma_ididioma`)
    REFERENCES `Sistema_de_Biblioteca`.`Idioma` (`ididioma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idioma_has_libro_libro1`
    FOREIGN KEY (`libro_idLibro`)
    REFERENCES `Sistema_de_Biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Distribuidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Distribuidor` (
  `iddistribuidor` INT NOT NULL AUTO_INCREMENT,
  `rutDistribuidor` INT NULL,
  `nombreEmpresaDistribuidor` VARCHAR(45) NULL,
  `tiempodistribucionDitribuidor` VARCHAR(45) NULL,
  `direccionDistribuidor` VARCHAR(45) NOT NULL,
  `telefonoDistribuidor` INT NOT NULL,
  PRIMARY KEY (`iddistribuidor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `rutCliente` INT NULL,
  `nombreCliente` VARCHAR(45) NULL,
  `apellidoPCliente` VARCHAR(45) NULL,
  `apellidoMCliente` VARCHAR(45) NULL,
  `fechaNacCliente` DATE NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`direccionCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`direccionCliente` (
  `idDireccionCliente` INT NOT NULL AUTO_INCREMENT,
  `nombreCalleCliente` VARCHAR(45) NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idDireccionCliente`, `cliente_idcliente`),
  INDEX `fk_direccionCliente_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_direccionCliente_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `Sistema_de_Biblioteca`.`Cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`telefonoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`telefonoCliente` (
  `idtelefonoCliente` INT NOT NULL AUTO_INCREMENT,
  `numeroTelefonoCliente` INT NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idtelefonoCliente`, `cliente_idcliente`),
  INDEX `fk_telefono_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_telefono_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `Sistema_de_Biblioteca`.`Cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`correo_electronicoCliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`correo_electronicoCliente` (
  `idcorreoCliente` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idcorreoCliente`, `cliente_idcliente`),
  INDEX `fk_correo_electronicoCliente_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_correo_electronicoCliente_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `Sistema_de_Biblioteca`.`Cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Trabajador` (
  `idTrabajador` INT NOT NULL AUTO_INCREMENT,
  `nombreTrabajador` VARCHAR(45) NULL,
  `apellidoPTrabajador` VARCHAR(45) NULL,
  `apellidoMTrabajador` VARCHAR(45) NULL,
  `fechaContratoTrabajador` DATE NULL,
  `Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idTrabajador`, `Biblioteca_idBiblioteca`),
  INDEX `fk_Trabajador_Biblioteca1_idx` (`Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_Trabajador_Biblioteca1`
    FOREIGN KEY (`Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`direccionTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`direccionTrabajador` (
  `iddireccionTrabajador` INT NOT NULL AUTO_INCREMENT,
  `nombrecalleTrabajador` VARCHAR(45) NULL,
  `Trabajador_idTrabajador` INT NOT NULL,
  PRIMARY KEY (`iddireccionTrabajador`, `Trabajador_idTrabajador`),
  INDEX `fk_direccionTrabajador_Trabajador1_idx` (`Trabajador_idTrabajador` ASC) VISIBLE,
  CONSTRAINT `fk_direccionTrabajador_Trabajador1`
    FOREIGN KEY (`Trabajador_idTrabajador`)
    REFERENCES `Sistema_de_Biblioteca`.`Trabajador` (`idTrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`telefonoTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`telefonoTrabajador` (
  `idtelefonoTrabajador` INT NOT NULL AUTO_INCREMENT,
  `numeroTelefonoTrabajador` INT NULL,
  `Trabajador_idTrabajador` INT NOT NULL,
  PRIMARY KEY (`idtelefonoTrabajador`, `Trabajador_idTrabajador`),
  INDEX `fk_telefonoTrabajador_Trabajador1_idx` (`Trabajador_idTrabajador` ASC) VISIBLE,
  CONSTRAINT `fk_telefonoTrabajador_Trabajador1`
    FOREIGN KEY (`Trabajador_idTrabajador`)
    REFERENCES `Sistema_de_Biblioteca`.`Trabajador` (`idTrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`correo_electronicoTrabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`correo_electronicoTrabajador` (
  `idcorreoTrabajador` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `Trabajador_idTrabajador` INT NOT NULL,
  PRIMARY KEY (`idcorreoTrabajador`, `Trabajador_idTrabajador`),
  INDEX `fk_correo_electronicoTrabajador_Trabajador1_idx` (`Trabajador_idTrabajador` ASC) VISIBLE,
  CONSTRAINT `fk_correo_electronicoTrabajador_Trabajador1`
    FOREIGN KEY (`Trabajador_idTrabajador`)
    REFERENCES `Sistema_de_Biblioteca`.`Trabajador` (`idTrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Compra_Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Compra_Libro` (
  `idCompra_Libro` INT NOT NULL AUTO_INCREMENT,
  `libroComprado` VARCHAR(45) NULL,
  `Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idCompra_Libro`, `Biblioteca_idBiblioteca`),
  INDEX `fk_Compra_Libro_Biblioteca1_idx` (`Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_Compra_Libro_Biblioteca1`
    FOREIGN KEY (`Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `folioFactura` INT NOT NULL,
  `precioNetoFactura` INT NOT NULL,
  `precioIVA_Factura` INT NOT NULL,
  `costoIVA_Factura` INT NOT NULL,
  `fechaCompraFactura` DATE NOT NULL,
  `horaCompraFactura` DATE NOT NULL,
  `metodopagoFactura` VARCHAR(45) NOT NULL,
  `Distribuidor_iddistribuidor` INT NOT NULL,
  `Distribuidor_direccion_idDireccion` INT NOT NULL,
  `Distribuidor_telefono_idtelefono` INT NOT NULL,
  `Compra_Libro_idCompra_Libro` INT NOT NULL,
  `Compra_Libro_Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idFactura`, `Distribuidor_iddistribuidor`, `Distribuidor_direccion_idDireccion`, `Distribuidor_telefono_idtelefono`, `Compra_Libro_idCompra_Libro`, `Compra_Libro_Biblioteca_idBiblioteca`),
  INDEX `fk_Factura_Distribuidor1_idx` (`Distribuidor_iddistribuidor` ASC, `Distribuidor_direccion_idDireccion` ASC, `Distribuidor_telefono_idtelefono` ASC) VISIBLE,
  INDEX `fk_Factura_Compra_Libro1_idx` (`Compra_Libro_idCompra_Libro` ASC, `Compra_Libro_Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Distribuidor1`
    FOREIGN KEY (`Distribuidor_iddistribuidor`)
    REFERENCES `Sistema_de_Biblioteca`.`Distribuidor` (`iddistribuidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Compra_Libro1`
    FOREIGN KEY (`Compra_Libro_idCompra_Libro` , `Compra_Libro_Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Compra_Libro` (`idCompra_Libro` , `Biblioteca_idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Boleta` (
  `idBoleta` INT NOT NULL AUTO_INCREMENT,
  `folioBoleta` INT NOT NULL,
  `precioNetoBoleta` INT NOT NULL,
  `precioIVA_Boleta` INT NOT NULL,
  `costoIVA_Boleta` INT NOT NULL,
  `fechaVentaBoleta` DATE NOT NULL,
  `horaVentaBoleta` INT NOT NULL,
  `metodopagoBoleta` VARCHAR(45) NOT NULL,
  `Cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idBoleta`, `Cliente_idcliente`),
  INDEX `fk_Boleta_Cliente1_idx` (`Cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_Boleta_Cliente1`
    FOREIGN KEY (`Cliente_idcliente`)
    REFERENCES `Sistema_de_Biblioteca`.`Cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Venta_Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Venta_Libro` (
  `idVenta_Libro` INT NOT NULL AUTO_INCREMENT,
  `libroVendido` VARCHAR(45) NULL,
  `Boleta_idBoleta` INT NOT NULL,
  `Trabajador_idTrabajador` INT NOT NULL,
  `Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`idVenta_Libro`, `Boleta_idBoleta`, `Trabajador_idTrabajador`, `Biblioteca_idBiblioteca`),
  INDEX `fk_Venta_Libro_Boleta1_idx` (`Boleta_idBoleta` ASC) VISIBLE,
  INDEX `fk_Venta_Libro_Trabajador1_idx` (`Trabajador_idTrabajador` ASC) VISIBLE,
  INDEX `fk_Venta_Libro_Biblioteca1_idx` (`Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Libro_Boleta1`
    FOREIGN KEY (`Boleta_idBoleta`)
    REFERENCES `Sistema_de_Biblioteca`.`Boleta` (`idBoleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Libro_Trabajador1`
    FOREIGN KEY (`Trabajador_idTrabajador`)
    REFERENCES `Sistema_de_Biblioteca`.`Trabajador` (`idTrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Libro_Biblioteca1`
    FOREIGN KEY (`Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sistema_de_Biblioteca`.`Arriendo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sistema_de_Biblioteca`.`Arriendo` (
  `id_Arriendo` INT NOT NULL AUTO_INCREMENT,
  `costoTotalArriendo` INT NOT NULL,
  `fechaArriendo` DATE NOT NULL,
  `fechaEstimadaDevolucionArr` DATE NOT NULL,
  `fechaEntregaArriendo` DATE NOT NULL,
  `diasRetrasoArriendo` DATE NOT NULL,
  `multaArriendo` INT NULL,
  `costoArriendo` INT NULL,
  `Cliente_idcliente` INT NOT NULL,
  `Trabajador_idTrabajador` INT NOT NULL,
  `cantidadLibros` INT NOT NULL,
  `Biblioteca_idBiblioteca` INT NOT NULL,
  PRIMARY KEY (`id_Arriendo`, `costoTotalArriendo`, `Cliente_idcliente`, `Trabajador_idTrabajador`, `Biblioteca_idBiblioteca`),
  INDEX `fk_Arriendo_Libro_Cliente1_idx` (`Cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_Arriendo_Libro_Trabajador1_idx` (`Trabajador_idTrabajador` ASC) VISIBLE,
  INDEX `fk_Arriendo_Biblioteca1_idx` (`Biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_Arriendo_Libro_Cliente1`
    FOREIGN KEY (`Cliente_idcliente`)
    REFERENCES `Sistema_de_Biblioteca`.`Cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Arriendo_Libro_Trabajador1`
    FOREIGN KEY (`Trabajador_idTrabajador`)
    REFERENCES `Sistema_de_Biblioteca`.`Trabajador` (`idTrabajador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Arriendo_Biblioteca1`
    FOREIGN KEY (`Biblioteca_idBiblioteca`)
    REFERENCES `Sistema_de_Biblioteca`.`Biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;