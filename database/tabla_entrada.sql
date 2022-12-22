USE sistema_bd;
#AÑADIMOS LOS NUEVOS CAMPOS A LA TABLA empleado
ALTER TABLE `sistema_bd`.`empleado` 
ADD COLUMN `nid` VARCHAR(45) NULL AFTER `idEmpleado`,
ADD COLUMN `contratado` TINYINT(4) NULL AFTER `email`;
#AÑADIMOS EL NUEVO CAMPO A LA TABLA USUARIO
ALTER TABLE `sistema_bd`.`usuario` 
ADD COLUMN `administrador` TINYINT(4) NULL AFTER `password`;
#ACTUALIZAMOS EL CAMPO contratado
UPDATE `sistema_bd`.`empleado` SET contratado = 1 WHERE idEmpleado;
#EL NID LO ACTUALIZAS TÚ
#ACTUALIZAS EL CAMPO administrador (1 es true, 0 es false)
#AHORA CREAMOS LA NUEVA TABLA
CREATE TABLE `sistema_bd`.`entrada` (
  `idEntrada` INT NOT NULL,
  `cantidadEntrada` INT NULL,
  `fechaEntrada` VARCHAR(50) NULL,
  `idMaterial` INT NULL,
  `idEmpleado` INT NULL,
  PRIMARY KEY (`idEntrada`),
  INDEX `idMaterialEntrada_idx` (`idEmpleado` ASC) VISIBLE,
  CONSTRAINT `idMaterialEntrada`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `sistema_bd`.`material` (`idMaterial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idEmpleadoEntrada`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `sistema_bd`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

