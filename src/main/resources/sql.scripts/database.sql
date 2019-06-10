-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema school_admin
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema school_admin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `school_admin` DEFAULT CHARACTER SET utf8 ;
USE `school_admin` ;

-- -----------------------------------------------------
-- Table `school_admin`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`school` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(145) NOT NULL,
  `address` VARCHAR(145) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school_admin`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`student` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(145) NOT NULL,
  `birth` DATE NOT NULL,
  `school_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumnos_colegios1_idx` (`school_id` ASC),
  CONSTRAINT `fk_alumnos_colegios1`
    FOREIGN KEY (`school_id`)
    REFERENCES `school_admin`.`school` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school_admin`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`course` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school_admin`.`grade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`grade` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school_admin`.`inscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`inscription` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `student_id` BIGINT NOT NULL,
  `course_id` BIGINT NOT NULL,
  `grade_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumno_has_asignatura_asignatura1_idx` (`course_id` ASC),
  INDEX `fk_alumno_has_asignatura_alumno1_idx` (`student_id` ASC),
  INDEX `fk_alumno_has_asignatura_notas1_idx` (`grade_id` ASC),
  CONSTRAINT `fk_alumno_has_asignatura_alumno1`
    FOREIGN KEY (`student_id`)
    REFERENCES `school_admin`.`student` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_asignatura_asignatura1`
    FOREIGN KEY (`course_id`)
    REFERENCES `school_admin`.`course` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_alumno_has_asignatura_notas1`
    FOREIGN KEY (`grade_id`)
    REFERENCES `school_admin`.`grade` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `school_admin`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `school_admin`.`teacher` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(145) NOT NULL,
  `birth` DATE NOT NULL,
  `active` TINYINT(1) NOT NULL,
  `school_id` BIGINT NOT NULL,
  `course_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_profesor_asignatura1_idx` (`course_id` ASC),
  INDEX `fk_profesor_colegio1_idx` (`school_id` ASC),
  CONSTRAINT `fk_profesor_asignatura1`
    FOREIGN KEY (`course_id`)
    REFERENCES `school_admin`.`course` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_profesor_colegio1`
    FOREIGN KEY (`school_id`)
    REFERENCES `school_admin`.`school` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `school_admin`.`school`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`school` (`id`, `name`, `address`) VALUES (1, 'Chilean Eagles College', 'La Florida');
INSERT INTO `school_admin`.`school` (`id`, `name`, `address`) VALUES (2, 'Santa Cruz', 'Santiago Centro');
INSERT INTO `school_admin`.`school` (`id`, `name`, `address`) VALUES (3, 'Ciudadela Montessori', 'Las Condes');

COMMIT;


-- -----------------------------------------------------
-- Data for table `school_admin`.`student`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (1, 'Aleix', '05/8/18', 1);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (2, 'Unai ', '07/7/25', 1);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (3, 'Yenny', '08/7/26', 2);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (4, 'Elizabeth', '06/9/24', 3);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (5, 'Duglimar', '06/11/16', 2);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (6, 'Guillem', '07/12/17', 3);
INSERT INTO `school_admin`.`student` (`id`, `name`, `birth`, `school_id`) VALUES (7, 'Adria', '08/10/14', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `school_admin`.`course`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`course` (`id`, `name`) VALUES (1, 'Matematica');
INSERT INTO `school_admin`.`course` (`id`, `name`) VALUES (2, 'Programacion');
INSERT INTO `school_admin`.`course` (`id`, `name`) VALUES (3, 'Ingles');

COMMIT;


-- -----------------------------------------------------
-- Data for table `school_admin`.`grade`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`grade` (`id`, `name`) VALUES (1, 'Verde');
INSERT INTO `school_admin`.`grade` (`id`, `name`) VALUES (2, 'Amarillo');
INSERT INTO `school_admin`.`grade` (`id`, `name`) VALUES (3, 'Anaranjado');
INSERT INTO `school_admin`.`grade` (`id`, `name`) VALUES (4, 'Rojo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `school_admin`.`inscription`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (1, 1, 1, 2);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (2, 1, 2, 3);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (3, 1, 3, 4);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (4, 2, 1, 1);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (5, 2, 2, 3);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (6, 2, 3, 2);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (7, 3, 1, 4);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (8, 3, 2, 3);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (9, 3, 3, 4);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (10, 4, 1, 1);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (11, 4, 2, 1);
INSERT INTO `school_admin`.`inscription` (`id`, `student_id`, `course_id`, `grade_id`) VALUES (12, 4, 3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `school_admin`.`teacher`
-- -----------------------------------------------------
START TRANSACTION;
USE `school_admin`;
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (1, 'Aaron ', '80/8/25', 1, 1, 1);
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (2, 'Francisco', '86/4/30', 1, 1, 2);
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (3, 'Raul', '89/5/17', 0, 2, 1);
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (4, 'Arturo ', '76/6/12', 1, 3, 2);
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (5, 'Alberto ', '92/9/15', 0, 3, 3);
INSERT INTO `school_admin`.`teacher` (`id`, `name`, `birth`, `active`, `school_id`, `course_id`) VALUES (6, 'Miguel ', '95/8/26', 1, 3, 1);

COMMIT;

