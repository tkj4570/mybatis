/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 5.7.35 : Database - mybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatis`;

/*Table structure for table `tbl_dept` */

DROP TABLE IF EXISTS `tbl_dept`;

CREATE TABLE `tbl_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_dept` */

insert  into `tbl_dept`(`id`,`dept_name`) values 
(1,'开发部'),
(2,'测试部');

/*Table structure for table `tbl_employee` */

DROP TABLE IF EXISTS `tbl_employee`;

CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_employee` */

insert  into `tbl_employee`(`id`,`last_name`,`gender`,`email`,`dept_id`) values 
(2,'xiana','1','1314',1),
(3,'tom','0','12',2),
(4,'mary','1','1',1),
(5,'ketx','1','1111',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
