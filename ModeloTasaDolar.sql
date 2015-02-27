/*
SQLyog Ultimate v9.02 
MySQL - 5.6.12-log : Database - tasaremota
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tasaremota` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tasaremota`;

/*Table structure for table `tasadolar` */

DROP TABLE IF EXISTS `tasadolar`;

CREATE TABLE `tasadolar` (
  `idTasa` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tasa` decimal(10,2) NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`idTasa`,`tasa`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tasadolar` */

insert  into `tasadolar`(`idTasa`,`tasa`,`fecha`) values (1,'9.15','2015-02-01'),(2,'10.15','2015-03-01'),(3,'9.15','2025-02-15'),(4,'9.20','2015-02-25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
