/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.17 : Database - mydemo_01
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydemo_01` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mydemo_01`;

/*Table structure for table `r_role_menu` */

DROP TABLE IF EXISTS `r_role_menu`;

CREATE TABLE `r_role_menu` (
  `role_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `menu_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `r_role_menu` */

insert  into `r_role_menu`(`role_id`,`menu_id`,`create_time`) values ('r001','m001',NULL),('r001','m002',NULL),('r001','m003',NULL),('r002','m001','2024-08-03 06:29:14'),('r002','m002',NULL),('r002','m004',NULL),('r003','m002',NULL),('r003','m005',NULL);

/*Table structure for table `r_user_role` */

DROP TABLE IF EXISTS `r_user_role`;

CREATE TABLE `r_user_role` (
  `user_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `r_user_role` */

insert  into `r_user_role`(`user_id`,`role_id`,`create_time`) values ('20240719001','r002',NULL),('20240719001','r003',NULL),('20240719002','r001',NULL),('20240719003','002',NULL);

/*Table structure for table `t_liu_menu` */

DROP TABLE IF EXISTS `t_liu_menu`;

CREATE TABLE `t_liu_menu` (
  `menu_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `menu_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `menu_type` tinyint(4) DEFAULT '1' COMMENT 'default:1,1:menu,2:button',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creator` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_delete` tinyint(1) DEFAULT '0' COMMENT 'default:0,0:no,1:yes',
  `menu_key` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_liu_menu` */

insert  into `t_liu_menu`(`menu_id`,`menu_name`,`menu_type`,`url`,`creator`,`create_time`,`update_time`,`is_delete`,`menu_key`) values ('m001','open',1,NULL,NULL,NULL,NULL,0,'menu001'),('m002','save',1,NULL,NULL,NULL,NULL,0,'menu002'),('m003','edit',1,NULL,NULL,NULL,NULL,0,'menu003'),('m004','copy',1,NULL,NULL,NULL,NULL,0,'menu004'),('m005','close',1,NULL,NULL,NULL,NULL,0,'menu005'),('m006','rename',1,NULL,NULL,NULL,NULL,0,'menu006'),('m007','new',1,NULL,NULL,NULL,NULL,0,'menu007'),('m008','insert',1,NULL,NULL,NULL,NULL,0,'menu008'),('m009','update',1,NULL,NULL,NULL,NULL,0,'menu009'),('m010','view',1,NULL,NULL,NULL,NULL,0,'menu010');

/*Table structure for table `t_liu_role` */

DROP TABLE IF EXISTS `t_liu_role`;

CREATE TABLE `t_liu_role` (
  `role_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `is_valid` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_liu_role` */

insert  into `t_liu_role`(`role_id`,`role_name`,`creator`,`create_time`,`update_time`,`is_valid`) values ('r001','level1',NULL,NULL,NULL,0),('r002','level2',NULL,NULL,NULL,0),('r003','level3',NULL,NULL,NULL,0);

/*Table structure for table `t_liu_user` */

DROP TABLE IF EXISTS `t_liu_user`;

CREATE TABLE `t_liu_user` (
  `user_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_liu_user` */

insert  into `t_liu_user`(`user_id`,`user_name`,`password`,`address`) values ('20240719001','my','123456',NULL),('20240719002','liu','654321',NULL),('20240719003','ddd','789456',NULL),('20240719004','xi','456789','dddd');

/*Table structure for table `t_liu_user_token` */

DROP TABLE IF EXISTS `t_liu_user_token`;

CREATE TABLE `t_liu_user_token` (
  `user_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_token` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `valid_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_liu_user_token` */

insert  into `t_liu_user_token`(`user_id`,`user_token`,`valid_time`,`create_time`) values ('20240719001','13eb0328-a1b5-4cb0-b8ca-ff4c751adb95','2024-08-06 17:46:24','2024-08-06 17:43:24'),('20240719002','68c2b7b5-d9c4-4d67-a18a-b958ed8a9b6c','2024-07-25 10:10:35','2024-07-25 10:07:35'),('20240719004','f214c054-d886-4b79-95d7-e830047b1661','2024-07-25 15:07:33','2024-07-25 15:04:33'),('200900512552','dfdfdaffe5555','2024-07-25 17:43:20','2024-07-25 17:40:20'),('200900512552','dfdfdaffe5555','2024-07-25 17:46:42','2024-07-25 17:43:42'),('200900512552','dfdfdaffe5555','2024-07-25 17:47:34','2024-07-25 17:44:34');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
