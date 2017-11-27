/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.28 : Database - home_jiajia
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`home_jiajia` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `home_jiajia`;

/*Table structure for table `data_dictionary_master` */

DROP TABLE IF EXISTS `data_dictionary_master`;

CREATE TABLE `data_dictionary_master` (
  `master_id` varchar(36) NOT NULL COMMENT '类型id',
  `master_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `status` varchar(50) DEFAULT NULL COMMENT '状态；0/启用，1/禁用',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `create_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`master_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表--主表';

/*Data for the table `data_dictionary_master` */

insert  into `data_dictionary_master`(`master_id`,`master_name`,`status`,`description`,`create_id`,`create_time`,`update_id`,`update_time`) values ('0562b947-106e-44e7-8453-cceab584f233','persontype','0','  客户关系类型','undefined','2015-12-01 17:20:32','admin','2016-02-18 17:29:34'),('0b442b50-c272-49e4-8afd-06324606c2e7','priority','0','优先级','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:15',NULL,NULL),('0b442b50-c272-49e4-8afd-06324606c2f7','startType','0','启用状态','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:15',NULL,NULL),('12d17544-eac1-43b4-a2c4-937487c69ac3','uselevel','0','用量',NULL,'2015-12-04 16:18:58',NULL,NULL),('165ee5-1e2a-411a-966f-df74041fa55e1','conditionusetype','0','计费模板公式条件','admin','2016-04-12 11:39:00',NULL,NULL),('165ee5-1e2a-411a-966f-df74041fa55e2','symbol','0','条件项','admin','2016-04-12 11:39:00',NULL,NULL),('217316d7-43f1-4c39-ac7c-0c57568df96f','cardType','0','证件类型',NULL,'2015-12-08 14:24:55',NULL,NULL),('21a3bf28-a9b9-433a-a094-039a594283fc','price','0','单价','undefined','2015-12-04 16:12:43','admin','2015-12-04 16:13:54'),('2df47126-299c-4d95-8d0d-991fc07a5700','car','0','车型','undefined','2015-12-01 19:47:01','admin','2016-02-18 17:29:34'),('4294df89-2deb-4a48-8149-d286c4d6e82f','pet_sex','0','宠物性别',NULL,'2015-12-02 16:57:20',NULL,NULL),('61237e60-93d0-40fb-9f59-38280c5d83ef','eduLever','0','学历',NULL,'2015-12-08 14:19:12',NULL,NULL),('89b61124-656a-40a6-abde-170eac147db5','accountType','0','账户类型','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:56:24',NULL,NULL),('996d846c-9e61-4cbc-af7e-dc7ba4d4234d','waterRate','1','水费',NULL,'2015-12-03 18:41:03','admin','2015-12-04 16:08:02'),('9cee256b-4f2a-42fe-93df-1415f8d9ede6','门禁卡','1','门禁卡','undefined','2015-12-01 17:10:52','admin','2016-02-18 17:29:41'),('a7ac2886-94c2-4d82-babf-05dc9bfe5add','cartype','0','车位类型',NULL,'2015-12-01 17:13:19',NULL,NULL),('ccaf63c0-ba8d-4876-ba66-f7d5ef4745b9','sex','0','性别',NULL,'2015-12-08 14:23:03',NULL,NULL),('ed47d533-d070-493c-82e6-a6a003086f13','married','0','婚姻状况',NULL,'2015-12-08 14:27:22',NULL,NULL),('f8c15049-9d7e-4d01-9ae8-7b54ccc8230f','停车卡','1','2',NULL,'2015-12-01 17:12:29',NULL,'2015-12-01 17:13:09'),('fbec651a-f74a-4456-88c8-45d8ef731551','fullName','0','全名','undefined','2015-12-01 11:38:16','admin','2016-02-18 17:29:34'),('www65ee5-1e2a-411a-966f-df74041fa55e','unit','0','单位',NULL,'2016-02-24 16:16:48',NULL,NULL);

/*Table structure for table `data_dictionary_master_project` */

DROP TABLE IF EXISTS `data_dictionary_master_project`;

CREATE TABLE `data_dictionary_master_project` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `master_id` varchar(36) DEFAULT NULL COMMENT '数据字典主表id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典从表和项目关联表';

/*Data for the table `data_dictionary_master_project` */

insert  into `data_dictionary_master_project`(`id`,`master_id`,`project_id`) values ('032581b6-1d5b-4177-8f6b-c1733f0cf428','89b61124-656a-40a6-abde-170eac147db5','960045b9-2f34-4cd0-a5d1-2860e177781d'),('032581b6-1d5b-4177-8f6b-c1733f0cfc27','0b442b50-c272-49e4-8afd-06324606c2f7','960045b9-2f34-4cd0-a5d1-2860e177781d'),('032581b6-1d5b-4177-8f6b-c1733f0cfc28','0b442b50-c272-49e4-8afd-06324606c2e7','960045b9-2f34-4cd0-a5d1-2860e177781d'),('032581b6-1d5b-4177-8f6b-c1733f0cfcc3','0562b947-106e-44e7-8453-cceab584f233','960045b9-2f34-4cd0-a5d1-2860e177781d'),('032581b6-1d5b-4177-8f6b-c1733f0cfcc7','165ee5-1e2a-411a-966f-df74041fa55e1','3c435785-745b-1127-f1ae-2a5e8cc64a3b'),('032581b6-1d5b-4177-8f6b-c1733f0cfcc8','165ee5-1e2a-411a-966f-df74041fa55e2','3c435785-745b-1127-f1ae-2a5e8cc64a3b'),('035823cd-c79a-422a-94a7-090d1d359bca','f8c15049-9d7e-4d01-9ae8-7b54ccc8230f','960045b9-2f34-4cd0-a5d1-2860e177781d'),('0fee0728-f71c-400d-997c-56eb18c9e564','fbec651a-f74a-4456-88c8-45d8ef731551','960045b9-2f34-4cd0-a5d1-2860e177781d'),('13f473b3-ce6c-465b-96cf-ec457e3ca5ae','21a3bf28-a9b9-433a-a094-039a594283fc','960045b9-2f34-4cd0-a5d1-2860e177781d'),('2a43bf87-6666-4f28-a51b-fee5ea3ad6ea','www65ee5-1e2a-411a-966f-df74041fa55e','960045b9-2f34-4cd0-a5d1-2860e177781d'),('44b054d0-99c1-4ac1-b3a1-55996c1d6ab6','ed47d533-d070-493c-82e6-a6a003086f13','960045b9-2f34-4cd0-a5d1-2860e177781d'),('47791f17-c8ec-4ed9-9cd1-454dca2620b6','61237e60-93d0-40fb-9f59-38280c5d83ef','960045b9-2f34-4cd0-a5d1-2860e177781d'),('57c5bff3-0e8a-463d-851d-2561feebea6b','4294df89-2deb-4a48-8149-d286c4d6e82f','960045b9-2f34-4cd0-a5d1-2860e177781d'),('59db03b7-24b5-456c-a59e-6dd814d0fdd5','ccaf63c0-ba8d-4876-ba66-f7d5ef4745b9','960045b9-2f34-4cd0-a5d1-2860e177781d'),('76cd28fb-230d-468c-99a7-3760bac1409e','996d846c-9e61-4cbc-af7e-dc7ba4d4234d','960045b9-2f34-4cd0-a5d1-2860e177781d'),('8372b443-2fb0-4446-aed5-19f7a5010f3d','12d17544-eac1-43b4-a2c4-937487c69ac3','960045b9-2f34-4cd0-a5d1-2860e177781d'),('83b46ca6-c24d-45a1-895f-add577caf161','217316d7-43f1-4c39-ac7c-0c57568df96f','960045b9-2f34-4cd0-a5d1-2860e177781d'),('ac687ad9-6a2f-4f69-9d2b-3d2c0d27572e','a7ac2886-94c2-4d82-babf-05dc9bfe5add','960045b9-2f34-4cd0-a5d1-2860e177781d'),('ba62e742-65e5-4d72-9693-4dc08e1b2383','2df47126-299c-4d95-8d0d-991fc07a5700','960045b9-2f34-4cd0-a5d1-2860e177781d'),('c8cbb79f-fd45-424e-b4a0-b9694aa4c5cf','9cee256b-4f2a-42fe-93df-1415f8d9ede6','960045b9-2f34-4cd0-a5d1-2860e177781d');

/*Table structure for table `data_dictionary_slave` */

DROP TABLE IF EXISTS `data_dictionary_slave`;

CREATE TABLE `data_dictionary_slave` (
  `slave_id` varchar(36) NOT NULL COMMENT '类型属性id',
  `slave_name` varchar(50) DEFAULT NULL COMMENT '类型属性名称',
  `master_id` varchar(36) DEFAULT NULL COMMENT '关联类型id',
  `status` varchar(50) DEFAULT NULL COMMENT '状态；0/启用，1/禁用',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `create_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`slave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表--从表';

/*Data for the table `data_dictionary_slave` */

insert  into `data_dictionary_slave`(`slave_id`,`slave_name`,`master_id`,`status`,`description`,`create_id`,`create_time`,`update_id`,`update_time`) values ('092b352b-8642-41ce-85e1-bbd3852e0927','  fixed parking space','a7ac2886-94c2-4d82-babf-05dc9bfe5add','0','固定车位','','2015-12-01 17:20:19',NULL,NULL),('0b26cc8e-d832-4649-aa9b-1544d1f33c40','lm','www65ee5-1e2a-411a-966f-df74041fa55e','0','立方米',NULL,NULL,NULL,NULL),('0ca138b2-8088-412c-aefd-b26b1224bf0a','electricPrice','21a3bf28-a9b9-433a-a094-039a594283fc','0','电费单价','admin','2015-12-04 16:17:10',NULL,NULL),('21f0a08f-ccad-4c1b-bb84-45dd964998ee','VIP person','0562b947-106e-44e7-8453-cceab584f233','0',' VIP客户','','2015-12-01 17:21:39','admin','2016-02-18 17:29:34'),('275ee5-1e2a-411a-966f-df74041fa5510','exclusive','165ee5-1e2a-411a-966f-df74041fa55e2','0','不包含','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa5511','yes','165ee5-1e2a-411a-966f-df74041fa55e2','0','是','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa5512','no','165ee5-1e2a-411a-966f-df74041fa55e2','0','不是','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e1','all','165ee5-1e2a-411a-966f-df74041fa55e1','0','全部','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e2','everyone','165ee5-1e2a-411a-966f-df74041fa55e1','0','任何','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e3','=','165ee5-1e2a-411a-966f-df74041fa55e2','0','等于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e4','!=','165ee5-1e2a-411a-966f-df74041fa55e2','0','不等于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e5','>','165ee5-1e2a-411a-966f-df74041fa55e2','0','大于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e6','<','165ee5-1e2a-411a-966f-df74041fa55e2','0','小于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e7','>=','165ee5-1e2a-411a-966f-df74041fa55e2','0','大于等于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e8','<=','165ee5-1e2a-411a-966f-df74041fa55e2','0','小于等于','admin','2016-04-12 11:39:00',NULL,NULL),('275ee5-1e2a-411a-966f-df74041fa55e9','contain','165ee5-1e2a-411a-966f-df74041fa55e2','0','包含','admin','2016-04-12 11:39:00',NULL,NULL),('313f20f8-1bee-4898-a856-9f16a445c5a5','1','61237e60-93d0-40fb-9f59-38280c5d83ef','0','小学','admin','2015-12-08 14:19:57',NULL,NULL),('3c11b2cc-5dd3-451d-a2b7-072aa36a70c9','7','61237e60-93d0-40fb-9f59-38280c5d83ef','0','硕士研究生','admin','2015-12-08 14:21:15',NULL,NULL),('451a92e7-e20b-432d-a51e-0f73fb410429','0','217316d7-43f1-4c39-ac7c-0c57568df96f','0','身份证','admin','2015-12-08 14:26:49',NULL,NULL),('48baf400-9334-492d-a26b-9192c9f80a6f','1','89b61124-656a-40a6-abde-170eac147db5','0','押金账户','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:56:34',NULL,NULL),('52034760-0726-4efb-a6b0-0fabc65d5078','1','ed47d533-d070-493c-82e6-a6a003086f13','0','未婚','admin','2015-12-08 14:27:43',NULL,NULL),('5439ca17-0dec-4a28-aac9-be8293d677ce','1','217316d7-43f1-4c39-ac7c-0c57568df96f','0','护照','admin','2015-12-08 14:26:57',NULL,NULL),('545968d7-451d-45b0-b814-41687218336c','control','9cee256b-4f2a-42fe-93df-1415f8d9ede6','0','门控机','472ec15f-b600-4818-a047-4488121dcc34','2016-02-18 17:30:23',NULL,NULL),('5a9afe88-a732-491c-955e-079d927df9ee','0','ccaf63c0-ba8d-4876-ba66-f7d5ef4745b9','0','男','admin','2015-12-08 14:23:27',NULL,NULL),('5bf4aa99-d0df-4ab1-a51f-994ca7e498cb','wall','9cee256b-4f2a-42fe-93df-1415f8d9ede6','0','围墙机','472ec15f-b600-4818-a047-4488121dcc34','2016-02-18 17:30:47',NULL,NULL),('68766b9c-eaa8-4ba2-bec5-dfa91e27b3a8','waterlevel','12d17544-eac1-43b4-a2c4-937487c69ac3','0','用水量','admin','2015-12-04 16:19:41',NULL,NULL),('6d949e93-0a9d-4ffb-b652-b31fea52ff5e','5','61237e60-93d0-40fb-9f59-38280c5d83ef','0','大专','admin','2015-12-08 14:20:52',NULL,NULL),('6fa68fa4-a3fa-4e49-868b-3c942ac2418f','m','www65ee5-1e2a-411a-966f-df74041fa55e','0','平方米','472ec15f-b600-4818-a047-4488121dcc34','2016-02-24 16:17:57',NULL,NULL),('7359a1e1-7864-4ab4-a616-0a1a234b106b','ordinary person','0562b947-106e-44e7-8453-cceab584f233','0','普通客户','','2015-12-01 17:22:24','admin','2016-02-18 17:29:34'),('80111ffa-cee0-4f79-a69e-13c58cf43511','0','4294df89-2deb-4a48-8149-d286c4d6e82f','0','公','admin','2015-12-02 16:57:41',NULL,NULL),('81239231-6ae9-4688-9c5c-d7f3dbaa9807','0','ed47d533-d070-493c-82e6-a6a003086f13','0','已婚','admin','2015-12-08 14:27:36',NULL,NULL),('82bc1b07-5db6-4ae2-915a-df8bbf854f92','2','61237e60-93d0-40fb-9f59-38280c5d83ef','0','初中','admin','2015-12-08 14:20:11',NULL,NULL),('86ddbac0-ec45-4172-a230-e295d383c84d','6','61237e60-93d0-40fb-9f59-38280c5d83ef','0','本科','admin','2015-12-08 14:21:03',NULL,NULL),('9f472b02-a77c-46b7-8082-e8cc5f5740aa','8','61237e60-93d0-40fb-9f59-38280c5d83ef','0','博士研究生','admin','2015-12-08 14:21:25',NULL,NULL),('a4d93f16-f20d-4307-86d2-63c87b99820c','1','ccaf63c0-ba8d-4876-ba66-f7d5ef4745b9','0','女','admin','2015-12-08 14:23:36',NULL,NULL),('ad3d1600-bd25-4dd8-a9b1-bce572e85ae2','ForbidPerson','0562b947-106e-44e7-8453-cceab584f233','0','重点客户','472ec15f-b600-4818-a047-4488121dcc34','2016-02-18 15:03:00','admin','2016-02-18 17:29:34'),('b29c7acd-eaf8-48f0-a9e0-d29e57e39793','private parking','a7ac2886-94c2-4d82-babf-05dc9bfe5add','0','私人车位','','2015-12-01 17:20:06',NULL,NULL),('b3792d1e-7677-40e7-8d10-a7de9791a7c6','3','61237e60-93d0-40fb-9f59-38280c5d83ef','0','中专','admin','2015-12-08 14:20:22',NULL,NULL),('b67a4156-574c-4b89-bd36-40eb80038698','waterprice','21a3bf28-a9b9-433a-a094-039a594283fc','0','水费单价','admin','2015-12-04 16:15:47',NULL,NULL),('c5d1b34c-9695-492b-96bc-8fc92a27c011','level1','0b442b50-c272-49e4-8afd-06324606c2e7','0','1','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:32',NULL,NULL),('c5d1b34c-9695-492b-96bc-8fc92a27c913','1','0b442b50-c272-49e4-8afd-06324606c2f7','0','未启用','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:32',NULL,NULL),('c9ea161e-f935-43d4-a987-b81fa3360dfc','ForbidPerson','0562b947-106e-44e7-8453-cceab584f233','0','黑名单','472ec15f-b600-4818-a047-4488121dcc34','2016-02-18 15:03:49','admin','2016-02-18 17:29:34'),('d87b7d6b-3ade-4566-ac2d-e8bb447e62f1','4','61237e60-93d0-40fb-9f59-38280c5d83ef','0','高中','admin','2015-12-08 14:20:31',NULL,NULL),('e7c7d8a3-3215-4ac1-a80f-0c10321f2b46','1','4294df89-2deb-4a48-8149-d286c4d6e82f','0','母','admin','2015-12-02 16:57:50',NULL,NULL),('fbd5bfab-1182-4fe2-9c9c-a3ecf9cf5b6f','0','89b61124-656a-40a6-abde-170eac147db5','0','资产账户','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:56:24',NULL,NULL),('ff5896ac-2567-48f1-9e9c-978af1fb4012','level2','0b442b50-c272-49e4-8afd-06324606c2e7','0','2','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:15',NULL,NULL),('ff5896ac-2567-48f1-9e9c-978af1fb4013','level3','0b442b50-c272-49e4-8afd-06324606c2e7','0','3','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:15',NULL,NULL),('ff5896ac-2567-48f1-9e9c-978af1fb405d','0','0b442b50-c272-49e4-8afd-06324606c2f7','0','已启用','70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca','2016-04-05 15:47:15',NULL,NULL),('wwwdb44c-e6cc-4fe0-9d7c-a990e864a392','meter','www65ee5-1e2a-411a-966f-df74041fa55e','0','米','472ec15f-b600-4818-a047-4488121dcc34','2016-02-24 16:17:57',NULL,NULL),('wwwdb44c-e6cc-4fe0-9d7c-a990e864a393','kg','www65ee5-1e2a-411a-966f-df74041fa55e','0','千克','472ec15f-b600-4818-a047-4488121dcc34','2016-02-24 16:17:57',NULL,NULL),('wwwdb44c-e6cc-4fe0-9d7c-a990e864a39b','a','www65ee5-1e2a-411a-966f-df74041fa55e','0','个','472ec15f-b600-4818-a047-4488121dcc34','2016-02-24 16:17:57',NULL,NULL);

/*Table structure for table `hr_authority` */

DROP TABLE IF EXISTS `hr_authority`;

CREATE TABLE `hr_authority` (
  `authority_id` varchar(36) NOT NULL COMMENT '操作权限id',
  `t_user_id` varchar(36) DEFAULT NULL COMMENT 'hr管理员id',
  `core_position_id` varchar(36) DEFAULT NULL COMMENT '核心团队id',
  `type` int(10) DEFAULT NULL COMMENT '0表示团队id，1表示项目id',
  `permissions_id` varchar(36) DEFAULT NULL COMMENT '权限id',
  `teamwork_id` varchar(36) DEFAULT NULL COMMENT '团队id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员团队关联表';

/*Data for the table `hr_authority` */

/*Table structure for table `hr_permissions` */

DROP TABLE IF EXISTS `hr_permissions`;

CREATE TABLE `hr_permissions` (
  `permissions_id` varchar(36) NOT NULL COMMENT 'id',
  `permissions_name` varchar(36) DEFAULT NULL COMMENT '功能权限名称',
  `permissions_address` varchar(50) DEFAULT NULL COMMENT '功能权限地址',
  `permissions_description` varchar(50) DEFAULT NULL COMMENT '描述',
  `permissions_type` varchar(30) DEFAULT NULL COMMENT '类型',
  `status` tinyint(10) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`permissions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能权限表';

/*Data for the table `hr_permissions` */

insert  into `hr_permissions`(`permissions_id`,`permissions_name`,`permissions_address`,`permissions_description`,`permissions_type`,`status`) values ('03819bc1-7fa7-4dec-9041-fdb4c2df9195','项目团队管理',NULL,'project',NULL,0),('325de4b8-2e73-4f49-996b-692786db9621','物业项目管理',NULL,'property',NULL,0),('44dd4b29-3f81-4469-9cbd-8d09d911b201','客户管理',NULL,'customer',NULL,0),('4959844d-bced-4c78-9977-032c724dcd2d','组件绑定',NULL,'bindcomponent',NULL,0),('4dd94496-e80b-45f2-9e7c-c13b3d039e6e','房屋初验',NULL,NULL,'业务管理',1),('53181ed6-64c3-4a86-8199-de7619c610c0','组织结构管理',NULL,'affiliate',NULL,0),('63bf6120-1967-4a4a-883f-4254a57d0101','合同初始化',NULL,'contract',NULL,0),('8a41aa72-c211-4872-a5d2-7a434d27d737','资产库管理',NULL,'assetlib',NULL,0),('99d6889e-8417-4051-9774-923fc6e67d7d','我的团队',NULL,'myteam',NULL,0),('9e716108-c01f-4bc7-acb8-4d8085393713','人员管理',NULL,'person',NULL,0),('afe363ae-b1d9-41a2-b0be-1f7a9456ac5d','核心岗位任命',NULL,'coreposition',NULL,0),('b5237215-2acd-4d9b-8902-37c81a3eba7b','人员管理设置',NULL,'admins',NULL,0),('c0033e9f-7707-48cb-93e5-8dd29dbb5052','岗位员工设置',NULL,'staff',NULL,1),('cec4cf54-5c5f-4617-866c-0e95a602491d','资产初始化',NULL,'asset',NULL,0),('f1a944fa-e054-4813-918b-0fa2dd949476','组件初始化',NULL,'component',NULL,0),('f888b1bf-c9ec-47f9-8a26-9a967bd3e40d','可视对讲',NULL,'viewspeak',NULL,0);

/*Table structure for table `t_after_sale` */

DROP TABLE IF EXISTS `t_after_sale`;

CREATE TABLE `t_after_sale` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `responsible_department_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '负责单位id',
  `responsible_department` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责单位',
  `responsible_department_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责单位类型',
  `responsible_department_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责单位电话',
  `responsible_project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '负责项目id',
  `responsible_project` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责项目',
  `responsible_items` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责事项',
  `After_start_time` date DEFAULT NULL COMMENT '售后开始时间',
  `After_end_time` date DEFAULT NULL COMMENT '售后结束时间',
  `home_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋id',
  `service_home_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '服务房屋编号',
  `home_Address` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋地址',
  `client_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id',
  `client_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户类型',
  `client_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `client_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户电话',
  `client_evaluate` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户评价',
  `Processing_state` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '处理状态',
  `source` varchar(8) COLLATE utf8_bin DEFAULT NULL COMMENT '来源',
  `Problem_description` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '问题描述',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '员工id',
  `property_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联资产表id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单ID',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单负责人Id',
  `guarantee` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '保修单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_after_sale` */

/*Table structure for table `t_article_get` */

DROP TABLE IF EXISTS `t_article_get`;

CREATE TABLE `t_article_get` (
  `article_get_id` varchar(36) NOT NULL COMMENT '物品领取id',
  `article_state_id` varchar(36) DEFAULT NULL COMMENT '遗失物品关系id',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '领取人id',
  `time` datetime DEFAULT NULL COMMENT '领取时间',
  PRIMARY KEY (`article_get_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_article_get` */

/*Table structure for table `t_article_release` */

DROP TABLE IF EXISTS `t_article_release`;

CREATE TABLE `t_article_release` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '放行条id',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋id',
  `house_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋地址',
  `name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '受理人姓名(预留)',
  `phone_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话(预留)',
  `Id_card` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号(预留)',
  `apply_time` date DEFAULT NULL COMMENT '申请时间',
  `release_time` date DEFAULT NULL COMMENT '放行时间',
  `accept_time` date DEFAULT NULL COMMENT '受理时间',
  `items_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '物品id(预留字段)',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '业主id',
  `person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '受理人id',
  `enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '小区公司id',
  `customer_type` tinyint(4) DEFAULT NULL COMMENT '客户类型',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  `release_time_end` datetime DEFAULT NULL,
  `release_code` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '放行条编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_article_release` */

insert  into `t_article_release`(`id`,`house_id`,`house_name`,`name`,`phone_number`,`Id_card`,`apply_time`,`release_time`,`accept_time`,`items_id`,`cust_id`,`person_id`,`enterprise_id`,`customer_type`,`operate_date`,`release_time_end`,`release_code`) values ('cf6469b1-c9d0-4af0-a026-624eea87ef79',NULL,'02区002栋1单元0202房',NULL,NULL,NULL,'2016-04-21','2016-04-01',NULL,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,NULL,'2016-04-21','2016-04-30 00:00:00','FXT20160421141235'),('d409d5e0-109e-488d-b9f8-ca770d45444b',NULL,'02区002栋1单元0201房',NULL,NULL,NULL,'2016-05-03','2016-05-01',NULL,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,1,'2016-05-03','2016-05-31 00:00:00','FXT20160503151505');

/*Table structure for table `t_authorization` */

DROP TABLE IF EXISTS `t_authorization`;

CREATE TABLE `t_authorization` (
  `authorization_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '授权管理id',
  `authorized_personId` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '被授权人id',
  `authorizer_personId` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '授权人id',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `access_card` tinyint(4) DEFAULT '0' COMMENT '门禁卡(0)否 1 是',
  `vehicle` tinyint(4) DEFAULT '0' COMMENT '车辆登记',
  `parking_card` tinyint(4) DEFAULT '0' COMMENT '停车卡',
  `carport_manage` tinyint(4) DEFAULT '0' COMMENT '车位管理',
  `roperty_changes` tinyint(4) DEFAULT '0' COMMENT '产权变更',
  `lease` tinyint(4) DEFAULT '0' COMMENT '租赁',
  `article_release` tinyint(4) DEFAULT '0' COMMENT '放行条',
  `decorate` tinyint(4) DEFAULT '0' COMMENT '装修',
  `partnership` tinyint(4) DEFAULT '0' COMMENT '入伙',
  `authorization_type` int(11) DEFAULT NULL COMMENT '授权类型(1委托书 2电话 ，3电子授权)',
  `sta_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `accessoryAddress` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '附件路径',
  `remark` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `entrance` tinyint(4) DEFAULT '0' COMMENT '新增  门禁卡(预留)',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  `status` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '授权状态',
  PRIMARY KEY (`authorization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_authorization` */

insert  into `t_authorization`(`authorization_id`,`authorized_personId`,`authorizer_personId`,`house_id`,`access_card`,`vehicle`,`parking_card`,`carport_manage`,`roperty_changes`,`lease`,`article_release`,`decorate`,`partnership`,`authorization_type`,`sta_date`,`end_date`,`accessoryAddress`,`remark`,`entrance`,`operate_date`,`status`) values ('14a85cc5-8012-47f0-94e8-53a17e52c0f9','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,1,'2016-05-16','2016-06-11',NULL,NULL,0,'2016-05-16','1'),('155d25bc-92bd-4672-898c-e8aef08073ee','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,3,'2016-04-07','2016-04-23',NULL,NULL,0,'2016-04-28','1'),('1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,1,'2016-04-01','2016-04-30','',NULL,0,'2016-04-28','1'),('22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,3,NULL,NULL,NULL,NULL,0,'2016-04-28','1'),('2392e3a0-96f7-4e61-b435-763dde1524d1','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,2,NULL,NULL,NULL,NULL,0,'2016-04-28','1'),('503ab2c9-ae23-4dd0-8508-d6e267833097','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,1,'2016-05-16','2016-06-11',NULL,NULL,0,'2016-05-16','1'),('64b409e5-1333-46b4-bea5-55e3f5d29cd2','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,3,'2016-04-01','2016-04-30',NULL,NULL,0,'2016-04-28','1'),('9d11bffe-2c87-4b26-b047-6933469fb3d0','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,2,'2016-04-01','2016-04-30',NULL,NULL,0,'2016-04-28','1'),('b4382661-b795-4125-a076-e88a3369853c','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','775ac943-8709-438b-a5ad-7049fc92b38b',0,0,0,0,0,0,0,0,0,3,'2016-04-01','2016-04-30','',NULL,0,'2016-04-28','1'),('dda4892a-f706-43dd-839b-976b0ddef493','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','16030350-17e5-481b-9d39-7973353d20b9',0,0,0,0,0,0,0,0,0,2,'2016-04-01','2016-04-30',NULL,NULL,0,'2016-04-28','1'),('f68229d7-d965-4551-a822-e1b9b47f1a49','f22cd363-2809-4af4-9199-872c68ffc9be','f22cd363-2809-4af4-9199-872c68ffc9be','775ac943-8709-438b-a5ad-7049fc92b38b',0,0,0,0,0,0,0,0,0,3,'2016-04-01','2016-04-30',NULL,NULL,0,'2016-04-28','1');

/*Table structure for table `t_authorization_project` */

DROP TABLE IF EXISTS `t_authorization_project`;

CREATE TABLE `t_authorization_project` (
  `authorization_project_id` varchar(36) NOT NULL COMMENT '授权项目id',
  `authorization_project_type_id` varchar(36) DEFAULT NULL COMMENT '授权项目类型id',
  `authorization_id` varchar(36) DEFAULT NULL COMMENT '授权管理id',
  PRIMARY KEY (`authorization_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authorization_project` */

insert  into `t_authorization_project`(`authorization_project_id`,`authorization_project_type_id`,`authorization_id`) values ('019ec6e9-957f-4d3d-8366-2d8a84c0f22e','9266b03e-195a-4f6b-ac9f-f3a1992f6a00','dda4892a-f706-43dd-839b-976b0ddef493'),('029f7032-d676-437e-a436-244cee29b8d5','07a3ec0e-0d22-48b4-9659-68867aab43e6','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('05013a40-bd98-45a9-b548-59be9b620b6d','20cdcd6e-69b6-4178-9e2f-44078c899507','64b409e5-1333-46b4-bea5-55e3f5d29cd2'),('076237e5-048f-4945-973c-9ae2800b771e','d9a9a4ae-3b67-46a0-a24a-1d39734af744','dda4892a-f706-43dd-839b-976b0ddef493'),('175c23cc-e084-4bbd-b943-4d15a267c93b','969aeb34-eaab-4e7a-9d53-226921ae8d2b','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('17b7c449-44bb-42c2-bf63-2e8f34e2bf01','969aeb34-eaab-4e7a-9d53-226921ae8d2b','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('1b6be23c-3f49-4db1-b66f-7d2fa85603f7','56ede32b-7fe0-434c-95c1-0051bc5cf44e','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('1ba0f234-3f02-46ef-9fbb-847d873e3cea','82cc1954-38fb-4fb8-bd93-e417faee42d3','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('1f359969-6df7-4b26-862b-a01758540f54','56ede32b-7fe0-434c-95c1-0051bc5cf44e','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('206050e6-e7d5-429f-b341-65382a2dfc57','58b0f99a-6845-4c6e-8761-42ae671aa858','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('2595df5c-b4f1-4e3f-9ae0-cf2975e553ce','969aeb34-eaab-4e7a-9d53-226921ae8d2b','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('25c0243a-651b-44e2-84d5-dec96e0c8a85','d9a9a4ae-3b67-46a0-a24a-1d39734af744','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('27e8e8bb-dbe0-486d-a796-e659cb5a0104','cd81b4df-7eda-47c8-a84c-c9d47578c78b','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('30573ca5-5fcd-47e0-8d0d-9c19eabf249b','d9a9a4ae-3b67-46a0-a24a-1d39734af744','2392e3a0-96f7-4e61-b435-763dde1524d1'),('31d581a0-b0c9-4d21-963f-ee863a800a35','969aeb34-eaab-4e7a-9d53-226921ae8d2b','f68229d7-d965-4551-a822-e1b9b47f1a49'),('3864ef6f-51b9-4099-a7f1-dac8a24e7e52','56ede32b-7fe0-434c-95c1-0051bc5cf44e','2392e3a0-96f7-4e61-b435-763dde1524d1'),('3aef0bab-9c9e-4923-bfa5-b0e2134d6041','20cdcd6e-69b6-4178-9e2f-44078c899507','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('410cd2dc-7f42-4b19-817f-f38b2d1bb2d6','58b0f99a-6845-4c6e-8761-42ae671aa858','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('41a39839-d47c-4e5d-a798-5435bdac69a7','693697f3-147b-4e67-9c4f-d98e032efecb','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('43a2e016-23b2-42e4-b826-037f23ee47df','82cc1954-38fb-4fb8-bd93-e417faee42d3','2392e3a0-96f7-4e61-b435-763dde1524d1'),('44d50ba7-e3e0-4642-95af-869ce44f66ef','cd81b4df-7eda-47c8-a84c-c9d47578c78b','2392e3a0-96f7-4e61-b435-763dde1524d1'),('47d77e07-d8ef-4c87-8ad0-c086f3721ec1','693697f3-147b-4e67-9c4f-d98e032efecb','2392e3a0-96f7-4e61-b435-763dde1524d1'),('4885910f-87a8-4531-bb8e-d79cc59914ad','07a3ec0e-0d22-48b4-9659-68867aab43e6','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('4a15e7c3-1614-420e-99ab-19b5ba0bd927','cd81b4df-7eda-47c8-a84c-c9d47578c78b','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('4ba50f0b-0ea2-4796-ac9c-b196bec48d58','cd81b4df-7eda-47c8-a84c-c9d47578c78b','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('4ea491b4-d05c-4f37-93d8-d509b43777d9','58b0f99a-6845-4c6e-8761-42ae671aa858','2392e3a0-96f7-4e61-b435-763dde1524d1'),('63003c18-9a1a-4ca8-80b3-3b2a10a7372a','20cdcd6e-69b6-4178-9e2f-44078c899507','dda4892a-f706-43dd-839b-976b0ddef493'),('6918c203-9e64-4a8a-8f38-c1c6786e4003','58b0f99a-6845-4c6e-8761-42ae671aa858','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('6e207f7f-0c13-40fb-9789-3288a95032cd','693697f3-147b-4e67-9c4f-d98e032efecb','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('82c91304-6ba1-4010-a8b3-0b12dc089a4f','20cdcd6e-69b6-4178-9e2f-44078c899507','503ab2c9-ae23-4dd0-8508-d6e267833097'),('85b950f1-f370-41b9-aacb-cd04abf87b55','07a3ec0e-0d22-48b4-9659-68867aab43e6','2392e3a0-96f7-4e61-b435-763dde1524d1'),('86132f19-c42d-49d4-a282-e513f8dfc2c5','9266b03e-195a-4f6b-ac9f-f3a1992f6a00','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('8848fc3b-5017-4927-811e-7dc5a6e633ca','20cdcd6e-69b6-4178-9e2f-44078c899507','14a85cc5-8012-47f0-94e8-53a17e52c0f9'),('8afe5357-7c1e-4b17-bcb2-08cdfd5078d7','20cdcd6e-69b6-4178-9e2f-44078c899507','2392e3a0-96f7-4e61-b435-763dde1524d1'),('922dc1c4-e6f7-4d2a-8267-0da36369dc08','82cc1954-38fb-4fb8-bd93-e417faee42d3','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('93bdb0e0-366d-49ca-b91c-e4831b1e019b','d9a9a4ae-3b67-46a0-a24a-1d39734af744','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('98f73f19-5564-4186-98d4-bb5fe187d16f','56ede32b-7fe0-434c-95c1-0051bc5cf44e','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('98fac829-fdc5-4471-839f-0c1a0c4a0010','9266b03e-195a-4f6b-ac9f-f3a1992f6a00','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('9c7cf229-5b6f-410a-b647-8c7b161cf33f','20cdcd6e-69b6-4178-9e2f-44078c899507','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('a5262db8-a23b-42ab-9db8-6b3b8b11fd52','07a3ec0e-0d22-48b4-9659-68867aab43e6','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('a7255810-e2ee-4dd2-b05b-f352de36d6b4','9266b03e-195a-4f6b-ac9f-f3a1992f6a00','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('a961ef48-91c4-4e46-a033-28abe56d061b','07a3ec0e-0d22-48b4-9659-68867aab43e6','dda4892a-f706-43dd-839b-976b0ddef493'),('b34e6508-a272-4d13-908b-607a25026e8e','969aeb34-eaab-4e7a-9d53-226921ae8d2b','dda4892a-f706-43dd-839b-976b0ddef493'),('b44d2201-2632-4efe-973f-e4c364ce39a9','82cc1954-38fb-4fb8-bd93-e417faee42d3','b4382661-b795-4125-a076-e88a3369853c'),('b669e6bb-3ad7-4ea9-b02f-7d3991ba4a81','9266b03e-195a-4f6b-ac9f-f3a1992f6a00','2392e3a0-96f7-4e61-b435-763dde1524d1'),('b93595d4-baee-4d69-8047-54d089789d38','56ede32b-7fe0-434c-95c1-0051bc5cf44e','dda4892a-f706-43dd-839b-976b0ddef493'),('bb68612d-6abb-4bbb-bbbe-d380908bd7f4','82cc1954-38fb-4fb8-bd93-e417faee42d3','dda4892a-f706-43dd-839b-976b0ddef493'),('bf2097e7-9dc9-4dec-af83-7764b04fcb16','693697f3-147b-4e67-9c4f-d98e032efecb','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c'),('c316ab3e-ca19-447d-8460-45ac57c1f61a','56ede32b-7fe0-434c-95c1-0051bc5cf44e','b4382661-b795-4125-a076-e88a3369853c'),('d0828f56-1037-4544-af8c-55d8fe39ef94','20cdcd6e-69b6-4178-9e2f-44078c899507','9d11bffe-2c87-4b26-b047-6933469fb3d0'),('daae9ac5-20d7-4bfc-ae21-1eb76e76b993','969aeb34-eaab-4e7a-9d53-226921ae8d2b','2392e3a0-96f7-4e61-b435-763dde1524d1'),('dbc3fcd0-a3f3-4a2d-8bf5-8c253b2092ea','82cc1954-38fb-4fb8-bd93-e417faee42d3','1ae5ea6e-ff1a-4e7e-b468-f8487ed83b6e'),('dd81be9b-9e38-4c0c-ba6b-5c9e07a030b3','693697f3-147b-4e67-9c4f-d98e032efecb','b4382661-b795-4125-a076-e88a3369853c'),('e09d41af-6d56-4712-872f-e52fa8e22959','cd81b4df-7eda-47c8-a84c-c9d47578c78b','dda4892a-f706-43dd-839b-976b0ddef493'),('e788457c-a66c-404a-b88b-09b95a2affb7','693697f3-147b-4e67-9c4f-d98e032efecb','dda4892a-f706-43dd-839b-976b0ddef493'),('e7a22ebf-da85-4811-aa43-b8cee9011cce','58b0f99a-6845-4c6e-8761-42ae671aa858','dda4892a-f706-43dd-839b-976b0ddef493'),('e94cd29d-4c66-4ab8-b3d2-b63d56b4ab27','82cc1954-38fb-4fb8-bd93-e417faee42d3','155d25bc-92bd-4672-898c-e8aef08073ee'),('fe04c764-5e9d-43e7-b10d-66a5149140ed','d9a9a4ae-3b67-46a0-a24a-1d39734af744','22e71c98-68bb-40d7-aa9d-66a9a0e1ab8c');

/*Table structure for table `t_authorization_project_type` */

DROP TABLE IF EXISTS `t_authorization_project_type`;

CREATE TABLE `t_authorization_project_type` (
  `authorization_project_id` varchar(36) NOT NULL COMMENT '授权项目类型id',
  `authorization_project_name` varchar(100) DEFAULT NULL COMMENT '授权项目名',
  PRIMARY KEY (`authorization_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_authorization_project_type` */

insert  into `t_authorization_project_type`(`authorization_project_id`,`authorization_project_name`) values ('07a3ec0e-0d22-48b4-9659-68867aab43e6','装修'),('20cdcd6e-69b6-4178-9e2f-44078c899507','租赁'),('56ede32b-7fe0-434c-95c1-0051bc5cf44e','门禁卡'),('58b0f99a-6845-4c6e-8761-42ae671aa858','宠物登记'),('693697f3-147b-4e67-9c4f-d98e032efecb','放行条'),('82cc1954-38fb-4fb8-bd93-e417faee42d3','车位管理'),('9266b03e-195a-4f6b-ac9f-f3a1992f6a00','车辆登记'),('969aeb34-eaab-4e7a-9d53-226921ae8d2b','停车卡'),('cd81b4df-7eda-47c8-a84c-c9d47578c78b','入伙'),('d9a9a4ae-3b67-46a0-a24a-1d39734af744','产权变更');

/*Table structure for table `t_car_access_card` */

DROP TABLE IF EXISTS `t_car_access_card`;

CREATE TABLE `t_car_access_card` (
  `card_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '车辆卡id(编号)',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋id',
  `idcard_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'ID卡号',
  `do_card_date` date DEFAULT NULL COMMENT '办卡日期',
  `card_state` tinyint(4) DEFAULT NULL COMMENT '卡状态(1正常，2挂失,3禁用，4.欠费)',
  `start_date` date DEFAULT NULL COMMENT '启用日期',
  `end_date` date DEFAULT NULL COMMENT '截止日期',
  `cust_code` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id(户主)',
  `user_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '使用人姓名（预留字段）',
  `kinsfolk` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '亲属关系',
  `nominal_fee` double DEFAULT NULL COMMENT '工本费',
  `photograph` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '照片',
  `park_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '车位id（建筑结构id）',
  `refund_date` date DEFAULT NULL COMMENT '退费日期',
  `payment_amount` double DEFAULT NULL COMMENT '缴费金额',
  `creater` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '登记人id',
  `registration_status` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '行驶证状态',
  `parking_location` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '停车位置',
  `note` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `car_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '办卡类型',
  `carcard_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆卡类型',
  `user_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型',
  `car_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆id',
  `customer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编号（预留字段）',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_car_access_card` */

insert  into `t_car_access_card`(`card_id`,`house_id`,`idcard_num`,`do_card_date`,`card_state`,`start_date`,`end_date`,`cust_code`,`user_name`,`kinsfolk`,`nominal_fee`,`photograph`,`park_id`,`refund_date`,`payment_amount`,`creater`,`registration_status`,`parking_location`,`note`,`car_type`,`carcard_type`,`user_type`,`car_id`,`customer_id`,`operate_date`) values ('b00c8f5a-0afb-11e6-8899-507b9d2ee731',NULL,'1','2016-04-25',1,'2016-04-01','2016-04-30','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'057f7e9e-fe2b-4aea-b688-c9d02efd09d1',NULL,'2016-04-25');

/*Table structure for table `t_car_info` */

DROP TABLE IF EXISTS `t_car_info`;

CREATE TABLE `t_car_info` (
  `car_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '车辆id',
  `person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '个人客户id（预留字段）',
  `car_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车牌号码',
  `car_brand` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆品牌',
  `car_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆类型',
  `car_style` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆型号',
  `engine_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '发动机号码',
  `discriminate_code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆识别代号',
  `passengers` int(11) DEFAULT NULL COMMENT '核定载客',
  `car_color` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆颜色',
  `regedit_date` date DEFAULT NULL COMMENT '注册登记日期',
  `certification_date` date DEFAULT NULL COMMENT '发证日期',
  `business_style` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '交易类型',
  `claims` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '理赔信息',
  `record_date` date DEFAULT NULL COMMENT '登记日期',
  `driving_license` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '行驶证号',
  `registrant` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id（前台人员）',
  `owner` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '车辆所有人id',
  `address` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '住址',
  `commissionagent` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '代办人 （预留字段）',
  `transactor` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '办理人 新增字段(业主或者办理人)',
  `delete_car` tinyint(4) DEFAULT '1' COMMENT '删除状态  新增字段',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_car_info` */

insert  into `t_car_info`(`car_id`,`person_id`,`car_num`,`car_brand`,`car_type`,`car_style`,`engine_num`,`discriminate_code`,`passengers`,`car_color`,`regedit_date`,`certification_date`,`business_style`,`claims`,`record_date`,`driving_license`,`registrant`,`owner`,`address`,`commissionagent`,`transactor`,`delete_car`,`operate_date`) values ('057f7e9e-fe2b-4aea-b688-c9d02efd09d1','f22cd363-2809-4af4-9199-872c68ffc9be','1','别克','两厢车','1',NULL,NULL,NULL,'1','2016-04-01','2016-04-01',NULL,NULL,'2016-04-25','1',NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',1,'2016-04-25');

/*Table structure for table `t_centralized_treatment_relation_records` */

DROP TABLE IF EXISTS `t_centralized_treatment_relation_records`;

CREATE TABLE `t_centralized_treatment_relation_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '集中处理记录id',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '任务id',
  `centralized_treatment_project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '集中处理项目id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_centralized_treatment_relation_records` */

/*Table structure for table `t_changetitle` */

DROP TABLE IF EXISTS `t_changetitle`;

CREATE TABLE `t_changetitle` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '产权变更主键',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋id',
  `pact_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同编号',
  `buy_date` date DEFAULT NULL COMMENT '认购时间',
  `sign_contract_date` date DEFAULT NULL COMMENT '签约时间',
  `cust_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '原产权归属人',
  `new_cust_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新产权归属人',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '原产权归属人id',
  `new_cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新产权归属人id',
  `registration_price` float DEFAULT NULL COMMENT '登记价',
  `house_after_folding_price` float DEFAULT NULL COMMENT '房屋折后实价',
  `building_area_price` float DEFAULT NULL COMMENT '建筑面积价格',
  `setIn_building_price` float DEFAULT NULL COMMENT '套内面积单价',
  `deal_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '交易类型',
  `payment_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '付款方式',
  `down_payment_price` float DEFAULT NULL COMMENT '首付金额',
  `property_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '产权类型',
  `pact_scan` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上传合同扫描',
  `property_scan` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '上传房产扫描',
  `stall_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新增车位id',
  `arrearage_pay` tinyint(4) DEFAULT NULL COMMENT '新增  费用承担人0表示原业主，1表示新业主',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  `store_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  商铺id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_changetitle` */

/*Table structure for table `t_classes` */

DROP TABLE IF EXISTS `t_classes`;

CREATE TABLE `t_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班次id',
  `post_id` int(10) DEFAULT NULL COMMENT '岗位id',
  `classes_type_id` int(11) DEFAULT NULL COMMENT '班次类型id',
  `classes_type_name` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '班次类型名称',
  `classes_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次名称',
  `start_time` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '结束时间',
  `headcount` int(11) DEFAULT '0' COMMENT '需要总人数',
  `state` int(11) DEFAULT NULL COMMENT '班次状态',
  `usable` int(11) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='班次表';

/*Data for the table `t_classes` */

/*Table structure for table `t_classes_type` */

DROP TABLE IF EXISTS `t_classes_type`;

CREATE TABLE `t_classes_type` (
  `classes_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班次类型id',
  `classes_type_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次类型名称',
  PRIMARY KEY (`classes_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_classes_type` */

/*Table structure for table `t_communtit_notice` */

DROP TABLE IF EXISTS `t_communtit_notice`;

CREATE TABLE `t_communtit_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `brief_content` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `founder` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `creation_time` date DEFAULT NULL,
  `final_modifier` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `last_modification_time` date DEFAULT NULL,
  `detailed_information` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_communtit_notice` */

/*Table structure for table `t_contract` */

DROP TABLE IF EXISTS `t_contract`;

CREATE TABLE `t_contract` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `contract_odd_num` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '合同单号',
  `contract_num` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '合同编号',
  `contract_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '合同类型',
  `contract_project` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同项目',
  `first_party` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同甲方',
  `second_party` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同乙方',
  `third_party` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同丙方',
  `four_party` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同丁方',
  `start_using_date` date DEFAULT NULL COMMENT '合同启动日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_contract` */

/*Table structure for table `t_contract_property_structure` */

DROP TABLE IF EXISTS `t_contract_property_structure`;

CREATE TABLE `t_contract_property_structure` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `contract_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同id',
  `property_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `functional_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '功能区域ID',
  `start_time` date DEFAULT NULL COMMENT '启动时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_contract_property_structure` */

/*Table structure for table `t_core_position` */

DROP TABLE IF EXISTS `t_core_position`;

CREATE TABLE `t_core_position` (
  `core_position_id` varchar(36) NOT NULL COMMENT '核心岗位id',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '人员id',
  `post_id` varchar(36) DEFAULT NULL COMMENT '岗位id',
  `state` tinyint(4) DEFAULT NULL COMMENT '1专业线经理 0项目经理',
  `create_time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`core_position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_core_position` */

insert  into `t_core_position`(`core_position_id`,`staff_id`,`post_id`,`state`,`create_time`) values ('c708ec56-3cc4-4b0d-9f82-751a4c4301af','7f9bd177-0702-43b6-8207-3622687054cb','ffe2fdff-dd11-487c-9711-800edd83c43d',1,'2016-04-13 09:53:35');

/*Table structure for table `t_corporate_news` */

DROP TABLE IF EXISTS `t_corporate_news`;

CREATE TABLE `t_corporate_news` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '企业新闻id',
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `brief_content` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '简要内容',
  `detailed_information` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '详细信息',
  `founder` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `creation_time` date DEFAULT NULL COMMENT '创建时间',
  `final_modifier` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `last_modification_time` date DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_corporate_news` */

/*Table structure for table `t_corrected_reading` */

DROP TABLE IF EXISTS `t_corrected_reading`;

CREATE TABLE `t_corrected_reading` (
  `corrected_reading_id` varchar(36) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '读数修正Id',
  `water_meter_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表Id',
  `corrected_time` date DEFAULT NULL COMMENT '修正时间',
  `operator` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  `correction` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '修正量',
  `reason` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '原因',
  `annex_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '附件ID',
  `correction_value` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '修正值',
  PRIMARY KEY (`corrected_reading_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_corrected_reading` */

/*Table structure for table `t_division` */

DROP TABLE IF EXISTS `t_division`;

CREATE TABLE `t_division` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `division_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '部门',
  `isinitialize` int(11) DEFAULT '0' COMMENT '是否初始化',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_division` */

/*Table structure for table `t_entrance` */

DROP TABLE IF EXISTS `t_entrance`;

CREATE TABLE `t_entrance` (
  `card_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '门禁卡id',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '绑定住宅id',
  `card_date` date DEFAULT NULL COMMENT '办卡日期',
  `start_date` date DEFAULT NULL COMMENT '启用日期',
  `end_date` date DEFAULT NULL COMMENT '截止日期',
  `user_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户类型',
  `user_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '使用人id(修改)',
  `relation` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关系链',
  `nominal_fee` double DEFAULT NULL COMMENT '工本费',
  `note` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `car_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '办卡类型',
  `cust_code` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '办卡人id',
  `card_state` tinyint(4) DEFAULT '1' COMMENT '卡状态(1正常，2挂失,3禁用,4.退卡)',
  `idcard_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'ID卡号（预留字段）',
  `related` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关系人',
  `card_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  门禁卡号',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  操作人',
  `operate_date` date DEFAULT NULL COMMENT '新增  操作时间',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_entrance` */

insert  into `t_entrance`(`card_id`,`house_id`,`card_date`,`start_date`,`end_date`,`user_type`,`user_id`,`relation`,`nominal_fee`,`note`,`car_type`,`cust_code`,`card_state`,`idcard_num`,`related`,`card_num`,`staff_id`,`operate_date`) values ('27bea6ba-0afb-11e6-8899-507b9d2ee731','37ddd3d7-ca8d-45c3-aa67-2b4c05fe1fc9','2016-04-25','2016-04-01',NULL,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,NULL,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',1,NULL,NULL,'1',NULL,'2016-04-25');

/*Table structure for table `t_faq` */

DROP TABLE IF EXISTS `t_faq`;

CREATE TABLE `t_faq` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `headline` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `content` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `date` date DEFAULT NULL COMMENT '日期',
  `faq_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'faq编号',
  `faq_state` tinyint(4) DEFAULT NULL COMMENT 'faq启用状态（0表示未启用，1表示启用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_faq` */

/*Table structure for table `t_gift` */

DROP TABLE IF EXISTS `t_gift`;

CREATE TABLE `t_gift` (
  `gift_id` varchar(36) NOT NULL COMMENT '礼品包id',
  `gift_name` varchar(36) DEFAULT NULL COMMENT '礼品包名称',
  `gift_amount` int(11) DEFAULT NULL COMMENT '礼包数量',
  PRIMARY KEY (`gift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_gift` */

/*Table structure for table `t_gift_article` */

DROP TABLE IF EXISTS `t_gift_article`;

CREATE TABLE `t_gift_article` (
  `gift_article_id` varchar(108) NOT NULL,
  `gift_id` varchar(108) DEFAULT NULL,
  `article_id` varchar(108) DEFAULT NULL,
  `quantity` int(30) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`gift_article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_gift_article` */

/*Table structure for table `t_inform` */

DROP TABLE IF EXISTS `t_inform`;

CREATE TABLE `t_inform` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `inform` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '通知',
  `time` date DEFAULT NULL COMMENT '日期',
  `content` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_inform` */

insert  into `t_inform`(`id`,`inform`,`time`,`content`) values (1,'公司内部公开招聘','2015-05-23','本物业公司需要招聘一名有能力的人担任社区公职人员'),(2,'放假通知','2015-05-31','明天，儿童节公司全体员工放假一天'),(3,'公司组织结构的调整','2015-04-08','公司业务不断加大，将会改变公司内部的组织结构'),(4,'杨明同志入党','2015-06-01','杨明同志由于表现优秀成功加入中国共产党'),(5,'欢迎新同事入职事业部','2015-05-31','欢迎新同事入职事业部，现安排部门经理进行入职指引');

/*Table structure for table `t_intake` */

DROP TABLE IF EXISTS `t_intake`;

CREATE TABLE `t_intake` (
  `intake_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '入伙id',
  `house_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `start_date` date DEFAULT NULL COMMENT '入伙开始时间',
  `end_date` date DEFAULT NULL COMMENT '入伙结束时间',
  `intake_state` int(4) DEFAULT NULL COMMENT '入伙状态（1已入伙，0为未入伙）',
  `intake_amount` double DEFAULT NULL COMMENT '入伙缴费金额',
  `intake_price` double DEFAULT NULL COMMENT '入伙缴费单价',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '登记人  员工id',
  `trans_actor` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '办理人id',
  `management_fee_charging_time` date DEFAULT NULL COMMENT '管理费默认计费时间',
  `choose_to_prepay_fees_months` int(30) DEFAULT NULL COMMENT '选择预交管理费月数',
  `take_one` tinyint(4) DEFAULT NULL COMMENT '承担人类型',
  PRIMARY KEY (`intake_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_intake` */

/*Table structure for table `t_intake_activity` */

DROP TABLE IF EXISTS `t_intake_activity`;

CREATE TABLE `t_intake_activity` (
  `intake_activity_id` varchar(36) DEFAULT NULL COMMENT '入伙活动id',
  `start_date` date DEFAULT NULL COMMENT '入伙活动开始时间',
  `end_date` date DEFAULT NULL COMMENT '入伙活动结束时间',
  `management_fee_charging_time` date DEFAULT NULL COMMENT '管理费默认计费时间',
  `choose_to_prepay_fees_months` int(30) DEFAULT NULL COMMENT '选择预交管理费月数',
  `take_one` tinyint(11) DEFAULT NULL COMMENT '承担人类型',
  `intake_amount` int(36) DEFAULT NULL COMMENT '入伙数量',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '负责人  人员id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_intake_activity` */

/*Table structure for table `t_intake_activity_relation` */

DROP TABLE IF EXISTS `t_intake_activity_relation`;

CREATE TABLE `t_intake_activity_relation` (
  `intake_activity_relation_id` varchar(36) DEFAULT NULL COMMENT '入伙活动关系id',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '人员id',
  `intake_activity_id` varchar(36) DEFAULT NULL COMMENT '入伙活动id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_intake_activity_relation` */

/*Table structure for table `t_intake_gift_relation` */

DROP TABLE IF EXISTS `t_intake_gift_relation`;

CREATE TABLE `t_intake_gift_relation` (
  `intake_gift_relation_id` varchar(36) NOT NULL COMMENT '入伙礼包关系id',
  `intake_id` varchar(108) DEFAULT NULL,
  `gift_id` varchar(108) DEFAULT NULL,
  `building_structure_id` varchar(108) DEFAULT NULL,
  PRIMARY KEY (`intake_gift_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_intake_gift_relation` */

/*Table structure for table `t_items` */

DROP TABLE IF EXISTS `t_items`;

CREATE TABLE `t_items` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键id',
  `number` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '序号',
  `item_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '物品名称',
  `amount` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '数量',
  `note` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `release_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '放行条id',
  `contait_state` tinyint(4) DEFAULT '1' COMMENT '0 表示物品禁止放行 1表示物品能放行',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_items` */

insert  into `t_items`(`id`,`number`,`item_name`,`amount`,`note`,`release_id`,`contait_state`,`operate_date`) values ('1786f08c-0788-11e6-b42c-507b9d2ee731',NULL,'1','1','1','cf6469b1-c9d0-4af0-a026-624eea87ef79',1,NULL);

/*Table structure for table `t_lease_contract` */

DROP TABLE IF EXISTS `t_lease_contract`;

CREATE TABLE `t_lease_contract` (
  `contract_id` varchar(36) NOT NULL COMMENT '租赁合同id',
  `product_bs_id` varchar(36) DEFAULT NULL COMMENT '产品关系id',
  `lease_start_date` datetime DEFAULT NULL COMMENT '租约开始日期',
  `lease_end_date` datetime DEFAULT NULL COMMENT '租约结束日期',
  `free_start_date` datetime DEFAULT NULL COMMENT '免租开始日期',
  `free_end_date` datetime DEFAULT NULL COMMENT '免租结束日期',
  `strAttach` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '承租人id',
  PRIMARY KEY (`contract_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_lease_contract` */

/*Table structure for table `t_log` */

DROP TABLE IF EXISTS `t_log`;

CREATE TABLE `t_log` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '日志id',
  `relevance_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联id',
  `thing` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '事情',
  `service` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '业务',
  `staff` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人员',
  `site` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '地点',
  `operation` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作(新增、修改)',
  `time` date DEFAULT NULL COMMENT '操作时间',
  `table` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '表名',
  `log_type_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '日志类型id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_log` */

insert  into `t_log`(`id`,`relevance_id`,`thing`,`service`,`staff`,`site`,`operation`,`time`,`table`,`log_type_id`) values ('0643cbf2-0088-11e6-a5ea-507b9d2ee731','5edd0c97-b3ca-4a6e-8078-38b9e9b79ba7',NULL,'资产',NULL,NULL,'新增',NULL,'t_property','fc4483c6-a5af-4e44-b73a-a6b9b5fe8e79'),('196533f6-0088-11e6-a5ea-507b9d2ee731','44e61f19-fe3e-424e-b7cb-34a87af6bd89',NULL,'资产',NULL,NULL,'新增',NULL,'t_property','6c77d98a-7c4d-49aa-8d26-de08fd864a18'),('42351977-007c-11e6-a5ea-507b9d2ee731','941c74a3-07db-4c45-9320-3c7c0557dc6b','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','ea71636c-c175-4200-9fac-c9b853ecef6d'),('6ba51fed-007c-11e6-a5ea-507b9d2ee731','3a4545d9-c274-4d3a-ac85-f9fd76b49e57','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','ce640ef2-2bf2-4872-a3d7-3b427a484765'),('6d04a5fd-007d-11e6-a5ea-507b9d2ee731','bbc19e4a-8176-4248-b771-b66b818740d9',NULL,'资产',NULL,NULL,'新增',NULL,'t_property','4d26a4b1-588e-4743-aee8-be31c8672abb'),('a32bac84-0096-11e6-a5ea-507b9d2ee731','21e1b314-50fe-4f1a-a460-83a81dd606bb',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','29eef90f-f605-4c93-a1aa-9967eb180bab'),('aa844a31-0096-11e6-a5ea-507b9d2ee731','21e1b314-50fe-4f1a-a460-83a81dd606bb',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','eee66d97-7c88-4e93-aeec-adf4c50457eb'),('bad0111c-0096-11e6-a5ea-507b9d2ee731','948a4023-c69f-4fcf-b227-b698cdeca853',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','8c9e97ee-d2db-4002-9714-1f7977188f1d'),('be30de98-0087-11e6-a5ea-507b9d2ee731','e17aa7ce-bd7a-453f-8234-5643ee9c18f3','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','ef1d8667-5fe9-46e9-8e5e-8c4de9967355'),('c580e096-0096-11e6-a5ea-507b9d2ee731','948a4023-c69f-4fcf-b227-b698cdeca853',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','1850f765-6389-4cd9-bc39-75a0227bc19c'),('c7780649-0087-11e6-a5ea-507b9d2ee731','948a4023-c69f-4fcf-b227-b698cdeca853','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','8ba5fb30-b91b-4ac9-aa86-2e93d9ff8433'),('cd3345f6-0087-11e6-a5ea-507b9d2ee731','21e1b314-50fe-4f1a-a460-83a81dd606bb','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','350ca49d-2e40-48e9-a5d2-9dfb07db1bfc'),('d110c1c6-0096-11e6-a5ea-507b9d2ee731','52992f14-9e33-41fc-9e9b-13577ca3ce4e',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','0d35acad-f206-46b1-a916-f74915bddf1a'),('d27b5b6a-0087-11e6-a5ea-507b9d2ee731','52992f14-9e33-41fc-9e9b-13577ca3ce4e','新增专业','专业',NULL,NULL,'新增','2016-04-12','t_property_type','22d9fa91-8f87-4009-8882-4f5529fcdb5e'),('d3a3750e-0096-11e6-a5ea-507b9d2ee731','52992f14-9e33-41fc-9e9b-13577ca3ce4e',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','b8f82e47-2ca9-44c5-aa2e-fb534a2fbd4f'),('d7ce5720-0096-11e6-a5ea-507b9d2ee731','948a4023-c69f-4fcf-b227-b698cdeca853',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','ac9802f4-3855-4ec0-a8fd-4f59143b525b'),('e1f4c238-0096-11e6-a5ea-507b9d2ee731','948a4023-c69f-4fcf-b227-b698cdeca853',NULL,'专业',NULL,NULL,'修改',NULL,'t_property_type','07e2810e-be67-4027-9f4c-9243606c38e5'),('eae5a1de-0087-11e6-a5ea-507b9d2ee731','7a25c044-2577-4dd6-bc6f-127e2e6ae740',NULL,'资产',NULL,NULL,'新增',NULL,'t_property','29ebbda0-85c0-4b21-9f72-3a95f3f9878c'),('f9dec283-0087-11e6-a5ea-507b9d2ee731','3a347d01-04c1-4960-8218-b2d57cbd39e8',NULL,'资产',NULL,NULL,'新增',NULL,'t_property','6c6e755f-51b7-43b6-9a4d-c7693dd49257');

/*Table structure for table `t_log_type` */

DROP TABLE IF EXISTS `t_log_type`;

CREATE TABLE `t_log_type` (
  `log_type_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '日志类型id',
  `log_type_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '日志类型名称',
  `note` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`log_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_log_type` */

insert  into `t_log_type`(`log_type_id`,`log_type_name`,`note`) values ('07e2810e-be67-4027-9f4c-9243606c38e5','类型名','备注'),('0d35acad-f206-46b1-a916-f74915bddf1a','类型名','备注'),('1850f765-6389-4cd9-bc39-75a0227bc19c','类型名','备注'),('22d9fa91-8f87-4009-8882-4f5529fcdb5e','类型名','备注'),('29ebbda0-85c0-4b21-9f72-3a95f3f9878c','类型名','备注'),('29eef90f-f605-4c93-a1aa-9967eb180bab','类型名','备注'),('350ca49d-2e40-48e9-a5d2-9dfb07db1bfc','类型名','备注'),('4d26a4b1-588e-4743-aee8-be31c8672abb','类型名','备注'),('4f3c50d2-63b6-4685-8f61-3dc342df7904','类型名','备注'),('6c6e755f-51b7-43b6-9a4d-c7693dd49257','类型名','备注'),('6c77d98a-7c4d-49aa-8d26-de08fd864a18','类型名','备注'),('8ba5fb30-b91b-4ac9-aa86-2e93d9ff8433','类型名','备注'),('8c9e97ee-d2db-4002-9714-1f7977188f1d','类型名','备注'),('ac2ae169-27fd-482b-ad4c-8f838a24f583','类型名','备注'),('ac9802f4-3855-4ec0-a8fd-4f59143b525b','类型名','备注'),('b8f82e47-2ca9-44c5-aa2e-fb534a2fbd4f','类型名','备注'),('ce640ef2-2bf2-4872-a3d7-3b427a484765','类型名','备注'),('ea71636c-c175-4200-9fac-c9b853ecef6d','类型名','备注'),('eee66d97-7c88-4e93-aeec-adf4c50457eb','类型名','备注'),('ef1d8667-5fe9-46e9-8e5e-8c4de9967355','类型名','备注'),('f81add86-720e-4534-8844-99377d8849c0','类型名','备注'),('fc4483c6-a5af-4e44-b73a-a6b9b5fe8e79','类型名','备注');

/*Table structure for table `t_lost` */

DROP TABLE IF EXISTS `t_lost`;

CREATE TABLE `t_lost` (
  `article_id` varchar(36) NOT NULL COMMENT '遗失id',
  `article_name` varchar(30) DEFAULT NULL COMMENT '遗失物名称',
  `article_amount` int(10) DEFAULT NULL COMMENT '遗失数量',
  `article_place` varchar(50) DEFAULT NULL COMMENT '遗失地点',
  `article_people` varchar(36) DEFAULT NULL COMMENT '拾取人（id）',
  `article_claimant` varchar(36) DEFAULT NULL COMMENT '领取人(id)',
  `article_timePicker` date DEFAULT NULL COMMENT '拾取时间',
  `article_timeClaim` date DEFAULT NULL COMMENT '领取时间',
  `article_describe` varchar(100) DEFAULT NULL COMMENT '遗失物品描述',
  `article_timeCheck` date DEFAULT NULL,
  `lost_state` int(4) DEFAULT NULL COMMENT '物品遗失状态（0表示拾取到的，1表示遗失的物品，2表示已领取）',
  `remarks` varchar(36) DEFAULT NULL COMMENT '备注',
  `pick_place` varchar(36) DEFAULT NULL COMMENT '拾取地点',
  `lost_time` date DEFAULT NULL COMMENT '遗失时间',
  `article_lostpeople` varchar(36) DEFAULT NULL COMMENT '失主id',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_lost` */

/*Table structure for table `t_meter_reading_complaints` */

DROP TABLE IF EXISTS `t_meter_reading_complaints`;

CREATE TABLE `t_meter_reading_complaints` (
  `meter_reading_complaints_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '抄表投诉id',
  `complainant_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉人',
  `complaint_description` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉描述',
  `meter_reading_data_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表数据id',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`meter_reading_complaints_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_meter_reading_complaints` */

/*Table structure for table `t_meter_reading_data` */

DROP TABLE IF EXISTS `t_meter_reading_data`;

CREATE TABLE `t_meter_reading_data` (
  `meter_reading_data_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '抄表数据id',
  `water_meter_record_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表使用记录id',
  `last_month_reading` double DEFAULT NULL COMMENT '上月读数',
  `reading` double DEFAULT NULL COMMENT '读数',
  `meter_reading_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表人',
  `meter_reading_state` tinyint(4) DEFAULT NULL COMMENT '抄表状态',
  `meter_reading_date` date DEFAULT NULL COMMENT '抄表日期',
  `reading_state` tinyint(4) DEFAULT NULL COMMENT '读数状态',
  `note` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `audit_state` tinyint(4) DEFAULT NULL COMMENT '审核状态',
  `audit_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `correction` double DEFAULT NULL COMMENT '修正量',
  `reason` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '原因',
  `water_damage` double DEFAULT NULL COMMENT '水损量',
  `abnormal_state` tinyint(4) DEFAULT NULL COMMENT '异常状态',
  `meter_reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划id',
  `teamwork_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '团队id',
  `building_structure_id` varbinary(36) DEFAULT NULL COMMENT '建筑结构id',
  `meter_executive_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表执行结果ID',
  `corrected_reading_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '读数修正ID',
  `surplus` double(20,2) DEFAULT NULL COMMENT '用余量',
  PRIMARY KEY (`meter_reading_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_meter_reading_data` */

/*Table structure for table `t_meter_reading_program` */

DROP TABLE IF EXISTS `t_meter_reading_program`;

CREATE TABLE `t_meter_reading_program` (
  `meter_reading_program_id` varchar(36) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '抄表计划id',
  `project_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '计划名称',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `settlement_day` int(30) DEFAULT NULL COMMENT '月结日',
  `reviewers` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人员',
  `program_execution_status` tinyint(4) DEFAULT NULL COMMENT '计划执行状态',
  `meter_reading_num` int(30) DEFAULT NULL COMMENT '抄表数量',
  `unfinished_num` int(30) DEFAULT NULL COMMENT '未完成数量',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '核实时间',
  `verify_time` date DEFAULT NULL COMMENT '结束时间',
  `meter_reading_type` tinyint(4) DEFAULT NULL COMMENT '抄表负责人类型(团队或人员)',
  `meter_reading_warning_num` int(30) DEFAULT NULL COMMENT '警告抄表数量',
  `meter_reading_error_num` int(30) DEFAULT NULL COMMENT '错误抄表数量',
  `no_meter_reading_num` int(30) DEFAULT NULL COMMENT '未抄表数量',
  `review_meter_num` int(30) DEFAULT NULL COMMENT '已审核数量',
  `meter_reading_normal_num` int(30) DEFAULT NULL COMMENT '正常抄表数量',
  `current_executor` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表人',
  `executive_team` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '执行团队',
  `all_num` int(30) DEFAULT NULL COMMENT '总表数',
  `automatic_execution` tinyint(4) DEFAULT '0' COMMENT '是否自动执行',
  `log_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '日志Id',
  PRIMARY KEY (`meter_reading_program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_meter_reading_program` */

/*Table structure for table `t_meter_reading_results` */

DROP TABLE IF EXISTS `t_meter_reading_results`;

CREATE TABLE `t_meter_reading_results` (
  `meter_executive_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '执行结果Id',
  `meter_reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划Id',
  `meter_executive_time` date DEFAULT NULL COMMENT '抄表执行时间',
  `meter_reading_num` int(30) DEFAULT '0' COMMENT '抄表数量',
  `unfinished_num` int(30) DEFAULT '0' COMMENT '未完成数量',
  `meter_reading_warning_num` int(30) DEFAULT '0' COMMENT '警告抄表数量',
  `meter_reading_error_num` int(30) DEFAULT '0' COMMENT '错误抄表数量',
  `no_meter_reading_num` int(30) DEFAULT '0' COMMENT '未抄表数量',
  `review_meter_num` int(30) DEFAULT '0' COMMENT '已审核数量',
  `meter_reading_normal_num` int(30) DEFAULT '0' COMMENT '正常抄表数量',
  `current_executor` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '当前执行人',
  `whether_upload_success` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '是否上传成功',
  PRIMARY KEY (`meter_executive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_meter_reading_results` */

/*Table structure for table `t_newlease` */

DROP TABLE IF EXISTS `t_newlease`;

CREATE TABLE `t_newlease` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `honse_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋外键id',
  `house_id_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '0为住宅，1为商铺',
  `hire_start_date` date DEFAULT NULL COMMENT '合同开始时间',
  `hire_finish_date` date DEFAULT NULL COMMENT '合同结束时间',
  `contract_number` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同编号',
  `leasePerson_id` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '租客外键id',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '员工外键id',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '业主外键id',
  `createDate` date DEFAULT NULL COMMENT '受理时间',
  `user_opinion` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '业主意见',
  `staff_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '受理人姓名（预留字段）',
  `cust_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '业主姓名（预留字段）',
  `houseAddress` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '新增 房屋地址（预留字段）',
  `lease_delete` tinyint(4) DEFAULT '1' COMMENT '新增  租赁信息删除状态',
  `lease_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  租客id（预留字段）',
  `lease_person_cardNum` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  租客身份证号（预留字段）',
  `lease_person_name` varchar(250) COLLATE utf8_bin DEFAULT NULL COMMENT '新增  租客姓名（预留字段）',
  `operate_date` date DEFAULT NULL COMMENT '新增   操作时间',
  `rent` double DEFAULT NULL COMMENT '租金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_newlease` */

insert  into `t_newlease`(`id`,`honse_id`,`house_id_type`,`hire_start_date`,`hire_finish_date`,`contract_number`,`leasePerson_id`,`staff_id`,`cust_id`,`createDate`,`user_opinion`,`staff_name`,`cust_name`,`houseAddress`,`lease_delete`,`lease_person_id`,`lease_person_cardNum`,`lease_person_name`,`operate_date`,`rent`) values ('d456fb58-27df-4829-84d9-5813c3708785','c359d1c5-e232-4f3e-8e85-6afd3e54481c','0','2016-05-01','2016-05-31','001','f343dbda-f7f0-451f-815b-bbe4a7cf655d',NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,NULL,NULL,NULL,'02区002栋1单元0201房',1,NULL,NULL,'陈浪','2016-05-03',5000);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `work_order_id` int(36) NOT NULL AUTO_INCREMENT COMMENT '工单id',
  `cust_id` int(36) DEFAULT NULL COMMENT '客户id',
  `LAST_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户名称',
  `houst_id` int(30) DEFAULT NULL COMMENT '房屋id',
  `HOUSE_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋名称',
  `SRA_SR_ID` int(36) DEFAULT NULL COMMENT '服务请求id',
  `enterprise_id` int(36) DEFAULT NULL COMMENT '企业id',
  `ENTPRISE_NAME` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '企业名称',
  `asking_id` int(36) DEFAULT NULL COMMENT '内部请求人员id',
  `ASKING_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '内部请求人员',
  `ASKING_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '内部请求人员工号',
  `EMAIL_SNDR_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '联系人',
  `CALLED_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '呼入电话',
  `CELL_PH_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '注册电话',
  `WC_TYPE_CD` int(4) DEFAULT NULL COMMENT '工单来源',
  `TODO_CD` int(4) DEFAULT NULL COMMENT '工单类型',
  `TurnState` int(10) DEFAULT NULL COMMENT '是否转单',
  `classify` int(30) DEFAULT NULL COMMENT '分类',
  `CAL_TYPE_CD` int(30) DEFAULT NULL COMMENT '专业/1级部件',
  `BILLABLE_FLG` tinyint(4) DEFAULT NULL COMMENT '是否保内',
  `woner_id` int(36) DEFAULT NULL COMMENT '负责人id',
  `OWNER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人',
  `COMMENTS_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务名称',
  `COMMENTS_LONG` varchar(1500) COLLATE utf8_bin DEFAULT NULL COMMENT '任务描述',
  `OWNER_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人工号',
  `EMAIL_BCC_LINE` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '服务描述/不接受工单描述',
  `CREATED` datetime DEFAULT NULL COMMENT '派单时间',
  `EVT_STAT_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '1,待处理、2，正在处理、3，已处理',
  `PYMNT_FLG` tinyint(4) DEFAULT NULL COMMENT '转专项标志',
  `EVT_PRIORITY_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '优先级',
  `RECREATE_RCPT_FLG` tinyint(4) DEFAULT NULL COMMENT '是否委外',
  `RECPT_REQ_FLG` tinyint(4) DEFAULT NULL COMMENT '是否抢单',
  `REF_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户满意度',
  `PAPER_SIGN_FLG` tinyint(4) DEFAULT NULL COMMENT '客户确认',
  `PARTICIPANT_NUM` int(11) DEFAULT NULL COMMENT '催办次数',
  `footings` double DEFAULT NULL COMMENT '结算总额',
  `PROCESSER_id` int(36) DEFAULT NULL COMMENT '处理人id',
  `PROCESSER_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理人',
  `PROCESSER_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理人工号',
  `EMAIL_RECIP_ADDR` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `TODO_PLAN_START_DT` datetime DEFAULT NULL COMMENT '开始时间/处理时间',
  `TODO_PLAN_END_DT` date DEFAULT NULL COMMENT '完成时间',
  `TODO_DUE_DT` date DEFAULT NULL COMMENT '预约时间(指定处理时间)',
  `DONE_FLG` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '完成标志',
  `RPLY_PH_NUM` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '二维码',
  `EMAIL_RECIP_NAME` varchar(1000) COLLATE utf8_bin DEFAULT NULL COMMENT '录音文件url',
  `MANDATORY_FLG` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '重大事项标志',
  `PAR_EVT_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '相关工单号',
  `COMMENTS` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '收费描述',
  `CREDIT_ACT_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '有效投诉',
  `complaint_source` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉来源',
  `complaint_state` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉状态',
  `complaint_matter` varchar(1500) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉事情',
  `comp_id` int(36) DEFAULT NULL COMMENT '投诉对象id',
  `COMP_TARGET_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉对象',
  `comp_target_num` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉对象工号',
  `comp_start_date` date DEFAULT NULL COMMENT '投诉时间',
  `comp_end_date` date DEFAULT NULL COMMENT '处理时间',
  `EMAIL_TO_LINE` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉申述',
  `EMAIL_BCC_LINE_desc` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '处理描述(事务助理)',
  `EMAIL_CC_LINE_result` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉表扬处理结果(行政部)',
  `COMMENTS_LONG_desc` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '索赔请求描述',
  `claim_check_desc` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '索赔核实描述',
  `SUBTYPE_OBJECT` tinyint(4) DEFAULT NULL COMMENT '索赔对象',
  `subtype_cd` tinyint(4) DEFAULT NULL COMMENT '赔付类型',
  `TTL_EXP_AMT` double DEFAULT NULL COMMENT '总金额',
  `AUTHORITY_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '审批状态:1,未审批2,已审批',
  `approver_id` int(36) DEFAULT NULL COMMENT '审批人id',
  `APPROVER_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '审批人工号',
  `APPROVER_NAME` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '审批人',
  `SRA_RESOLUTION_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '赔付方案类型',
  `EMAIL_CC_LINE` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '方案',
  `LEAD_TM_UOM_CD` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '月数',
  `ASSESS_FOR` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '价值',
  `insurance` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '保险',
  `is_add_order` tinyint(4) DEFAULT NULL COMMENT '是否追加工单',
  `old_work_order_id` int(36) DEFAULT NULL COMMENT '原工单id',
  `wait_or_not` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '是否集中处理',
  `pass_or_not` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '是否审核通过:1,审核通过2,审核未通过',
  `accpet_or_not` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '是否通过验收：1，通过验收2，未通过',
  `appoint_id` int(11) DEFAULT NULL COMMENT '指派人id',
  `press_or_not` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '是否催办:1,催办2，未催办。',
  `project_time` date DEFAULT NULL COMMENT '保护期',
  `grab_time` date DEFAULT NULL COMMENT '抢单期',
  `lease_id` int(11) DEFAULT NULL COMMENT '租赁id',
  `LOC_DESC_id` int(11) DEFAULT NULL COMMENT '项目id',
  `LOC_DESC` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '项目',
  `ZIPCODE` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '区',
  `NOSALE_RES_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '栋/座',
  `CEM_TIME_UOM_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '单元',
  `SKIN_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '层',
  `PUBLISH_CD` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '公共位置',
  `PRIV_FLG` tinyint(4) DEFAULT NULL COMMENT '主要负责人标志',
  `COMPOSITE_ID` int(11) DEFAULT NULL COMMENT '集中处理ID',
  `LOT_NUM` int(11) DEFAULT NULL COMMENT '集中处理批次',
  `ACT_COMP_FLG` tinyint(4) DEFAULT NULL COMMENT '集中处理工单标志',
  `COMP_STATUS` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '集中处理状态',
  `task_id` int(30) DEFAULT NULL COMMENT '关联任务id',
  `server_id` int(30) DEFAULT NULL COMMENT '关联服务请求id',
  `creation_time` date DEFAULT NULL COMMENT '工单创建时间',
  `completion_time` date DEFAULT NULL COMMENT '工单完成时间',
  PRIMARY KEY (`work_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_order` */

/*Table structure for table `t_order_attachment` */

DROP TABLE IF EXISTS `t_order_attachment`;

CREATE TABLE `t_order_attachment` (
  `order_Attachment_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '工单附件id',
  `work_order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单id',
  `FILE_NAME` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '文件名称',
  `FILE_path` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '文件路径',
  `FILE_SRC_TYPE` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '附件类型',
  `DB_LAST_UPD_SRC` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '文件类型',
  `PUBLISH_CD` tinyint(4) DEFAULT NULL COMMENT '文件状态',
  `FILE_DOCK_STAT_FLG` tinyint(4) DEFAULT NULL COMMENT '已入档',
  `FILE_REV_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '文件版本',
  `FILE_DATE` datetime DEFAULT NULL COMMENT '文件日期',
  `COMMENTS` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `process` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理类型：1.投诉2.申诉',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id',
  `frek_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '外键信息',
  PRIMARY KEY (`order_Attachment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_order_attachment` */

/*Table structure for table `t_pet` */

DROP TABLE IF EXISTS `t_pet`;

CREATE TABLE `t_pet` (
  `pet_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '宠物ID号码',
  `pet_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物名称',
  `pet_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物类型',
  `pet_no` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物证件号',
  `pet_sex` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物性别',
  `pet_describe` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物描述',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '登记人',
  `person_building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户房屋关系表id',
  `registration_time` date DEFAULT NULL COMMENT '登记时间',
  `pet_pic` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物图片',
  `pet_status` tinyint(4) DEFAULT '1' COMMENT '宠物删除状态(1为启用，0为弃用)',
  `pet_breeds` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宠物品种',
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_pet` */

insert  into `t_pet`(`pet_id`,`pet_name`,`pet_type`,`pet_no`,`pet_sex`,`pet_describe`,`cust_id`,`person_building_id`,`registration_time`,`pet_pic`,`pet_status`,`pet_breeds`) values ('5324c648-0afb-11e6-8899-507b9d2ee731','1','1',NULL,'0',NULL,'f22cd363-2809-4af4-9199-872c68ffc9be','775ac943-8709-438b-a5ad-7049fc92b38b','2016-04-25',NULL,1,NULL);

/*Table structure for table `t_post` */

DROP TABLE IF EXISTS `t_post`;

CREATE TABLE `t_post` (
  `post_id` varchar(36) NOT NULL COMMENT '岗位id',
  `professional_line_id` varchar(36) DEFAULT NULL COMMENT '专业线id',
  `name_of_custom` varchar(30) DEFAULT NULL COMMENT '岗位名称',
  `is_core_post` tinyint(4) DEFAULT NULL COMMENT '核心岗位(0不是，1是)',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id(无用)',
  `state` tinyint(4) DEFAULT NULL COMMENT '岗位开启状态(0未开启,1开启)',
  `post_num` int(20) DEFAULT NULL COMMENT '岗位人数(新增)',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位表';

/*Data for the table `t_post` */

insert  into `t_post`(`post_id`,`professional_line_id`,`name_of_custom`,`is_core_post`,`project_id`,`state`,`post_num`) values ('001','6','消防司机',0,'1',1,NULL),('002','6','消防设备管理员',0,'1',1,NULL),('003','6','消防战士',0,'1',0,NULL),('1','7','安保经理',1,NULL,0,10),('119eb584-7d71-4352-a778-5222d6b6aea0','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','收银员',0,NULL,1,10),('12','3','维修主管',1,NULL,0,NULL),('13','1','门控机经理',1,NULL,1,10),('14','1','门控机主管',0,NULL,1,40),('16','1','门控工作人员',0,NULL,1,20),('18','1','门控机组长',0,NULL,0,50),('19','4','项目经理',1,NULL,1,NULL),('1fc8844d-7e26-4c46-a7aa-7486f7a450af','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','收银组长',0,NULL,1,10),('2','5','园林经理',1,NULL,0,20),('20','4','项目主管',0,NULL,0,NULL),('3','5','产品经理',1,'',0,30),('4','2','清洁经理',1,NULL,1,40),('4d26d5c1-6c17-4754-aea9-a77603560a9d','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','出纳',0,NULL,1,10),('5','5','领班',0,'1',1,NULL),('50945449-31a8-11e5-b859-74d435','3','维修经理',1,NULL,0,NULL),('6','2','主管',0,NULL,0,NULL),('7','2','清洁工',0,NULL,1,NULL),('8','2','小时工',0,NULL,1,NULL),('f720af54-629b-4c15-8741-d2672afe86cc','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','会计',0,NULL,1,10),('ffe2fdff-dd11-487c-9711-800edd83c43d','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','财务经理',1,NULL,1,NULL);

/*Table structure for table `t_post_type` */

DROP TABLE IF EXISTS `t_post_type`;

CREATE TABLE `t_post_type` (
  `post_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位类型id',
  `post_type_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位类型名称',
  `division_id` int(11) DEFAULT NULL COMMENT '部门id',
  `remark` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_post_type` */

insert  into `t_post_type`(`post_type_id`,`post_type_name`,`division_id`,`remark`) values (2,'固定岗',2,''),(3,'巡逻岗',4,''),(8,'机动岗',4,''),(19,'经理',NULL,'gen'),(22,'dsfij',NULL,'aasas');

/*Table structure for table `t_prepare` */

DROP TABLE IF EXISTS `t_prepare`;

CREATE TABLE `t_prepare` (
  `prepare_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '编制id',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `post_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位id',
  `prepare_number` int(20) DEFAULT NULL COMMENT '编制数量',
  `prepare_num` int(20) DEFAULT NULL COMMENT '已分配数量',
  PRIMARY KEY (`prepare_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_prepare` */

insert  into `t_prepare`(`prepare_id`,`project_id`,`post_id`,`prepare_number`,`prepare_num`) values ('79b9470f-742b-43d9-801e-3d195860722e','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','119eb584-7d71-4352-a778-5222d6b6aea0',50,NULL),('be9c403e-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','16',10,NULL),('be9c43ae-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','119eb584-7d71-4352-a778-5222d6b6aea0',10,NULL),('be9c444b-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','1fc8844d-7e26-4c46-a7aa-7486f7a450af',10,NULL),('be9c44a7-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','4d26d5c1-6c17-4754-aea9-a77603560a9d',10,NULL),('be9c44f8-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','f720af54-629b-4c15-8741-d2672afe86cc',10,NULL),('de131aac-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','14',50,NULL),('de138c8d-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','16',50,NULL);

/*Table structure for table `t_produce_price` */

DROP TABLE IF EXISTS `t_produce_price`;

CREATE TABLE `t_produce_price` (
  `PRODUCT_ID` int(36) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `PRODUCT_NAME` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
  `PART_NUM` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '产品号',
  `STD_PRI_UNIT` double(17,2) DEFAULT NULL COMMENT '价格',
  `TYPE` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '产品类型',
  `papar` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '简述',
  `state` tinyint(1) DEFAULT '1' COMMENT '状态',
  `product_state` tinyint(4) DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_produce_price` */

/*Table structure for table `t_project` */

DROP TABLE IF EXISTS `t_project`;

CREATE TABLE `t_project` (
  `project_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '项目id',
  `project_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目编号',
  `project_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名称',
  `stall_matching` double(30,0) DEFAULT NULL COMMENT '车位配比',
  `park_area` double(30,0) DEFAULT NULL COMMENT '停车场面积',
  `car_entri_num` int(11) DEFAULT NULL COMMENT '车辆出入口数量',
  `person_entri_num` int(11) DEFAULT NULL COMMENT '人行出入口数量',
  `car_stall_num` int(11) DEFAULT NULL COMMENT '机动车位泊位总数',
  `add_capacitance_area` double DEFAULT NULL COMMENT '核增计容面积',
  `capacitance_area` double DEFAULT NULL COMMENT '计容面积',
  `private_stall_num` int(11) DEFAULT NULL COMMENT '私家车位总数',
  `private_stall_sold` int(11) DEFAULT NULL COMMENT '私家已售出总数',
  `private_stall_unsold` int(11) DEFAULT NULL COMMENT '私家未售出总数',
  `garage_num` int(11) DEFAULT NULL COMMENT '车库总数',
  `garage_sold` int(11) DEFAULT NULL COMMENT '车库已售出总数',
  `garage_ubsold` int(20) DEFAULT NULL COMMENT '车库未售出总数',
  `project_total_area` double DEFAULT NULL COMMENT '项目总占地面积',
  `discount_price` double DEFAULT NULL COMMENT '折合楼面价',
  `house_total_num` int(11) DEFAULT NULL COMMENT '住宅总户数',
  `build_area_num` int(11) DEFAULT NULL COMMENT '楼宇数量区',
  `build_unit_num` int(11) DEFAULT NULL COMMENT '楼宇数量单元',
  `build_build_num` int(11) DEFAULT NULL COMMENT '楼宇数量栋',
  `stall_num` int(11) DEFAULT NULL COMMENT '车位总数',
  `underground_parking_spaces_total` int(11) DEFAULT NULL COMMENT '地下车位总数',
  `ground_parking_space_total` int(11) DEFAULT NULL COMMENT '地面车位总数',
  `greening_rate` double DEFAULT NULL COMMENT '绿化率',
  `total_build_area` double DEFAULT NULL COMMENT '实际总建筑面积',
  `basement_area` double DEFAULT NULL COMMENT '实际地下室面积',
  `province` tinyint(4) DEFAULT NULL COMMENT '省',
  `full_address` tinyint(4) DEFAULT NULL COMMENT '市',
  `postcode` tinyint(4) DEFAULT NULL COMMENT '区',
  `street` tinyint(4) DEFAULT NULL COMMENT '街道',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '全地址',
  `post_code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮编',
  `company` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司ID',
  `outline` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '概要',
  `phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `parcel` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '宗地信息',
  `planning` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '规划信息',
  `cust_id` int(10) DEFAULT NULL COMMENT '用户id',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目经理',
  `is_use_system` tinyint(11) DEFAULT '1' COMMENT '是否使用收费系统0使用1未使用',
  `billing_type` tinyint(11) DEFAULT NULL COMMENT '计费类型',
  `billing_date` date DEFAULT NULL COMMENT '计费时间',
  `civil_air_defence_area` double(30,2) DEFAULT NULL COMMENT '人防面积',
  `state` tinyint(4) DEFAULT '0' COMMENT '项目状态 0.在用 1.停用 5.默认物业项目',
  `instance_id` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `means_payments` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `sort_date` datetime DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_project` */

insert  into `t_project`(`project_id`,`project_number`,`project_name`,`stall_matching`,`park_area`,`car_entri_num`,`person_entri_num`,`car_stall_num`,`add_capacitance_area`,`capacitance_area`,`private_stall_num`,`private_stall_sold`,`private_stall_unsold`,`garage_num`,`garage_sold`,`garage_ubsold`,`project_total_area`,`discount_price`,`house_total_num`,`build_area_num`,`build_unit_num`,`build_build_num`,`stall_num`,`underground_parking_spaces_total`,`ground_parking_space_total`,`greening_rate`,`total_build_area`,`basement_area`,`province`,`full_address`,`postcode`,`street`,`address`,`post_code`,`company`,`outline`,`phone`,`parcel`,`planning`,`cust_id`,`staff_id`,`is_use_system`,`billing_type`,`billing_date`,`civil_air_defence_area`,`state`,`instance_id`,`means_payments`,`sort_date`) values ('3c435785-745b-1127-f1ae-2a5e8cc64a3b','002','财务项目',0,0,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,4002,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,4001,0,NULL,NULL,NULL,NULL,'武汉',NULL,'6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'7f9bd177-0702-43b6-8207-3622687054cb',0,NULL,NULL,NULL,0,NULL,NULL,'2016-04-13 13:38:08'),('89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','001','枫林上城',0,0,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,503,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,302,0,NULL,NULL,NULL,NULL,'武汉光谷软件园',NULL,'6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'7f9bd177-0702-43b6-8207-3622687054cb',1,NULL,NULL,NULL,0,NULL,NULL,'2016-04-07 16:28:57'),('960045b9-2f34-4cd0-a5d1-2860e177781d',NULL,'物业公司',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,5,NULL,NULL,NULL);

/*Table structure for table `t_project_completion` */

DROP TABLE IF EXISTS `t_project_completion`;

CREATE TABLE `t_project_completion` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `company_id` varchar(36) DEFAULT NULL COMMENT '公司id',
  `area_type` tinyint(10) DEFAULT '0' COMMENT '面积类型完成情况',
  `building` tinyint(10) DEFAULT '0' COMMENT '建筑完成情况',
  `person` tinyint(10) DEFAULT '0' COMMENT '个人客户完成情况',
  `enterprise` tinyint(10) DEFAULT '0' COMMENT '企业客户完成情况',
  `assetbinding` tinyint(10) DEFAULT '0' COMMENT '资产绑定完成情况'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目完成情况记录表';

/*Data for the table `t_project_completion` */

insert  into `t_project_completion`(`id`,`project_id`,`company_id`,`area_type`,`building`,`person`,`enterprise`,`assetbinding`) values ('a729ebb4-9991-4d5e-95f2-cc6cad948938','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','6af6cb54-df65-4128-84a7-29a76af9c723',1,NULL,NULL,NULL,NULL),('f387e76f-a8f7-47aa-9c08-31cc361e39b5','3c435785-745b-1127-f1ae-2a5e8cc64a3b','6af6cb54-df65-4128-84a7-29a76af9c723',1,NULL,NULL,NULL,NULL);

/*Table structure for table `t_property` */

DROP TABLE IF EXISTS `t_property`;

CREATE TABLE `t_property` (
  `property_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '资产id',
  `property_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '资产编号',
  `property_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '资产名称',
  `property_specification` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '资产规格',
  `property_type_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '分类id',
  `expiration_date` double DEFAULT NULL COMMENT '质保期',
  `brand` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '品牌',
  `producing_area` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '产地',
  `manufacturer` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '厂商',
  `manufacturer_phone` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '厂商电话',
  `founder_time` datetime DEFAULT NULL COMMENT '资产创建时间',
  `company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_property` */

insert  into `t_property`(`property_id`,`property_number`,`property_name`,`property_specification`,`property_type_id`,`expiration_date`,`brand`,`producing_area`,`manufacturer`,`manufacturer_phone`,`founder_time`,`company_id`) values ('3a347d01-04c1-4960-8218-b2d57cbd39e8','0010020001','元器件','10*10*10','e17aa7ce-bd7a-453f-8234-5643ee9c18f3',NULL,NULL,NULL,NULL,'13911452236','2016-04-12 16:24:14','6af6cb54-df65-4128-84a7-29a76af9c723'),('44e61f19-fe3e-424e-b7cb-34a87af6bd89','0020020001','节能灯泡','0.50*4','52992f14-9e33-41fc-9e9b-13577ca3ce4e',NULL,NULL,NULL,NULL,'13078984521','2016-04-12 16:25:07','6af6cb54-df65-4128-84a7-29a76af9c723'),('5edd0c97-b3ca-4a6e-8078-38b9e9b79ba7','0020010001','白炽灯','0.56','21e1b314-50fe-4f1a-a460-83a81dd606bb',NULL,NULL,NULL,NULL,'15944585236','2016-04-12 16:24:34','6af6cb54-df65-4128-84a7-29a76af9c723'),('7a25c044-2577-4dd6-bc6f-127e2e6ae740','0010010002','变压器线','1200*0.12','3a4545d9-c274-4d3a-ac85-f9fd76b49e57',NULL,NULL,NULL,NULL,'15122552523','2016-04-12 16:23:49','6af6cb54-df65-4128-84a7-29a76af9c723'),('bbc19e4a-8176-4248-b771-b66b818740d9','0010010001','变压器零件','10*10*10','3a4545d9-c274-4d3a-ac85-f9fd76b49e57',12,NULL,NULL,NULL,'15112452252','2016-04-12 15:08:42','6af6cb54-df65-4128-84a7-29a76af9c723');

/*Table structure for table `t_property_type` */

DROP TABLE IF EXISTS `t_property_type`;

CREATE TABLE `t_property_type` (
  `property_type_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '资产类型id',
  `property_type_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '分类编号',
  `property_type_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '专业分类名称',
  `founder` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `founder_time` datetime DEFAULT NULL COMMENT '创建时间',
  `parent_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '父节点id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人ID',
  `company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`property_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='资产专业表';

/*Data for the table `t_property_type` */

insert  into `t_property_type`(`property_type_id`,`property_type_number`,`property_type_name`,`founder`,`founder_time`,`parent_id`,`modify_time`,`modifier`,`company_id`) values ('21e1b314-50fe-4f1a-a460-83a81dd606bb','002001','灯泡','liyan@lii.cn','2016-04-12 16:22:59','948a4023-c69f-4fcf-b227-b698cdeca853','2016-04-12 18:09:23','liyan@lii.cn','6af6cb54-df65-4128-84a7-29a76af9c723'),('3a4545d9-c274-4d3a-ac85-f9fd76b49e57','001001','变压器','变压器变压器变压器变压器变压器变压器变压器变压器变压器变压器','2016-04-12 15:01:31','941c74a3-07db-4c45-9320-3c7c0557dc6b','2016-04-12 15:01:31','变压器变压器变压器变压器变压器变压器变压器变压器变压器变压器','6af6cb54-df65-4128-84a7-29a76af9c723'),('52992f14-9e33-41fc-9e9b-13577ca3ce4e','002002','节能灯','liyan@lii.cn','2016-04-12 16:23:08','948a4023-c69f-4fcf-b227-b698cdeca853','2016-04-12 18:10:32','liyan@lii.cn','6af6cb54-df65-4128-84a7-29a76af9c723'),('941c74a3-07db-4c45-9320-3c7c0557dc6b','001','强电','liyan@lii.cn1111111111','2016-04-12 15:00:21',NULL,'2016-04-12 15:00:21','liyan@lii.cn1111111111','6af6cb54-df65-4128-84a7-29a76af9c723'),('948a4023-c69f-4fcf-b227-b698cdeca853','002','弱电','liyan@lii.cn','2016-04-12 16:22:49',NULL,'2016-04-12 18:10:56','liyan@lii.cn','6af6cb54-df65-4128-84a7-29a76af9c723'),('e17aa7ce-bd7a-453f-8234-5643ee9c18f3','001002','元件','liyan@lii.cn','2016-04-12 16:22:34','941c74a3-07db-4c45-9320-3c7c0557dc6b',NULL,NULL,'6af6cb54-df65-4128-84a7-29a76af9c723');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` varchar(36) NOT NULL COMMENT '主键id',
  `role_type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  `role_name` varchar(36) DEFAULT NULL COMMENT '角色名',
  `create_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `modifytime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块角色表';

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`role_type`,`role_name`,`create_id`,`createtime`,`modify_id`,`modifytime`) values ('5fa85bec-cc34-42b3-bb8c-18bb7ea9a9d8','3','系统管理员',NULL,NULL,NULL,NULL),('681ea2e9-74b9-4dde-9f46-2f7b0d7ee423','0','超级管理员',NULL,NULL,NULL,NULL),('85d89e6d-e270-41ef-87c0-5923cfc8071d','1','HR管理员',NULL,NULL,NULL,NULL),('9334c6c2-5fd0-4400-9070-2a74de0fadca','4','团队操作员',NULL,NULL,NULL,NULL),('d408f764-cdad-48cc-9530-2c86d617802f','2','普通用户',NULL,NULL,NULL,NULL);

/*Table structure for table `t_rules` */

DROP TABLE IF EXISTS `t_rules`;

CREATE TABLE `t_rules` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `brief_content` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '简要内容',
  `detail_info` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '详细信息',
  `record_creater` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '记录创建人',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `last_modifier` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '最后修改人',
  `last_mod_time` date DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_rules` */

insert  into `t_rules`(`id`,`title`,`brief_content`,`detail_info`,`record_creater`,`create_time`,`last_modifier`,`last_mod_time`) values (1,'夏季上班时间','根据公司相关规定，从本月起，上班时间调整为9:00--18:00','根据公司相关规定，从本月起，上班时间调整为9:00--18:00','管理员','2016-03-07','管理员','2016-03-07'),(2,'关于加班的相关规定','根据公司规章制度，加班必须向公司提出申请，批准后才能计算有效工时','根据公司规章制度，加班必须向公司提出申请，批准后才能计算有效工时','行政部','2015-02-14','行政部','2015-02-14'),(3,'新员工入职培训流程','新员工入职公司后需要参加为期两天的入职培训，主要为熟悉公司制度和工作流程','新员工入职公司后需要参加为期两天的入职培训，主要为熟悉公司制度和工作流程','人事部','2015-02-12','人事部','2015-02-12'),(4,'调休的相关安排','申请调休需要提前一至两天提出申请，由上级批准后计算为有效假期','申请调休需要提前一至两天提出申请，由上级批准后计算为有效假期','行政部','2015-02-14','行政部','2015-02-14'),(5,'员工培训的相关制度','员工必须参加公司举办的关于职业技术的相关培训，不参加者必须提前提出请假申请','员工必须参加公司举办的关于职业技术的相关培训，不参加者必须提前提出请假申请','人事部','2016-01-01','人事部','2016-01-01');

/*Table structure for table `t_scheduling` */

DROP TABLE IF EXISTS `t_scheduling`;

CREATE TABLE `t_scheduling` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '排班id',
  `staff_id` int(11) DEFAULT NULL COMMENT '员工id',
  `staff_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '员工名称',
  `classes_type_id` int(11) DEFAULT NULL COMMENT '班次类型id',
  `classes_type_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次类型名称',
  `classes_id` int(11) DEFAULT NULL COMMENT '班次id',
  `classes_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次名称',
  `currentDate` date DEFAULT NULL COMMENT '日期',
  `STATUS_CD` tinyint(30) DEFAULT NULL COMMENT '状态',
  `START_DT` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '开始时间',
  `END_DT` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '结束时间',
  `post_id` int(11) DEFAULT NULL COMMENT '岗位id',
  `post_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位名称',
  `division_id` int(11) DEFAULT NULL COMMENT '部门id',
  `division_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排班表';

/*Data for the table `t_scheduling` */

/*Table structure for table `t_scheduling_log` */

DROP TABLE IF EXISTS `t_scheduling_log`;

CREATE TABLE `t_scheduling_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `staff_id` int(11) DEFAULT NULL COMMENT '员工id',
  `staff_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '员工名称',
  `classes_type_id` int(11) DEFAULT NULL COMMENT '班次类型id',
  `classes_type_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次类型名称',
  `classes_id` int(11) DEFAULT NULL COMMENT '班次id',
  `classes_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '班次名称',
  `currentDate` date DEFAULT NULL COMMENT '日期',
  `STATUS_CD` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `START_DT` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '开始时间',
  `END_DT` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '结束时间',
  `post_id` int(11) DEFAULT NULL COMMENT '岗位id',
  `post_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位名称',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作人id',
  `operator_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人名称',
  `operator_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_scheduling_log` */

/*Table structure for table `t_specialty_info` */

DROP TABLE IF EXISTS `t_specialty_info`;

CREATE TABLE `t_specialty_info` (
  `specialty_id` varchar(36) NOT NULL COMMENT '专业线id',
  `specialty_name` varchar(30) DEFAULT NULL COMMENT '专业线名称',
  `specialty_describle` varchar(100) DEFAULT NULL COMMENT '专业线描述',
  `instance_id` int(20) DEFAULT NULL COMMENT '实例id',
  `state` tinyint(4) DEFAULT NULL COMMENT '0未开启 1开启',
  `will_options` tinyint(4) DEFAULT '0' COMMENT '必选项(0非必选,1必选)',
  `company_id` varchar(36) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`specialty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_specialty_info` */

insert  into `t_specialty_info`(`specialty_id`,`specialty_name`,`specialty_describle`,`instance_id`,`state`,`will_options`,`company_id`) values ('1','门控机','管理门控机设备',NULL,1,0,'1'),('2','清洁','物业保洁是指对单元性房地产，永久性建筑物的清洁与保养。开展经常性物业保洁的目的是：被清洁的物品在不受损坏的前提下，恢复完美状态，并延长其使用功能，增加使用寿命，实现物有所值或增值。',NULL,0,0,'1'),('3','维修','设备维修是指设备技术状态劣化或发生故障后，为恢复其功能而进行的技术活动，包括各类计划修理和计划外的故障修理及事故修理。又称设备修理。设备维修的基本内容包括：设备维护保养、设备检查和设备修理。',NULL,0,0,'1'),('4','项目','项目项目项目',NULL,1,0,'1'),('5','园林','在一定的地域运用工程技术和艺术手段，通过改造地形（或进一步筑山、叠石、理水）、种植树木花草、营造建筑和布置园路等途径创作而成的美的自然环境和游憩境域，就称为园林。',NULL,0,0,'1'),('6','消防','防火防跳楼',NULL,0,0,'1'),('7','安保',NULL,NULL,0,0,'1'),('c13123e3-01d1-4b5a-9a9d-bdb00588ce53','财务','此专业线的员工主要进行计费收费上的工作',NULL,1,0,'1');

/*Table structure for table `t_staff` */

DROP TABLE IF EXISTS `t_staff`;

CREATE TABLE `t_staff` (
  `staff_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '员工id',
  `company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  `staff_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '员工编号',
  `first_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓氏',
  `last_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '名字',
  `first_name_spell` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓氏拼音',
  `last_name_spell` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '名字拼音',
  `sex` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `native_place` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `married` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '婚否',
  `edu_lever` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '学历',
  `landscape` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '政治面貌',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `hobby` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '兴趣爱好',
  `card_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '证件类型',
  `staff_no` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '员工工号',
  `card_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `telphone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `QQ` int(30) DEFAULT NULL COMMENT 'QQ号码',
  `position` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '职务',
  `division_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '部门id',
  `divisionName` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '部门名称',
  `post_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位id(无用)',
  `work_count` int(36) DEFAULT NULL COMMENT '连续工作天数',
  `state` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '状态（0失效 1有效）',
  `staff_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '员工姓名',
  `team_work_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '团队id（无用）',
  `account` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_staff` */

insert  into `t_staff`(`staff_id`,`company_id`,`staff_number`,`first_name`,`last_name`,`first_name_spell`,`last_name_spell`,`sex`,`native_place`,`married`,`edu_lever`,`landscape`,`birthday`,`hobby`,`card_type`,`staff_no`,`card_num`,`address`,`telphone`,`email`,`QQ`,`position`,`division_id`,`divisionName`,`post_id`,`work_count`,`state`,`staff_name`,`team_work_id`,`account`,`password`) values ('3e4e7bf6-2aa4-4743-950b-eaadad291b97','6af6cb54-df65-4128-84a7-29a76af9c723','10001',NULL,NULL,NULL,NULL,'0',NULL,'0',NULL,NULL,'2016-04-01',NULL,'0','1','421003199901123456S',NULL,'13111254412',NULL,NULL,NULL,NULL,NULL,NULL,0,'1','1',NULL,NULL,NULL),('7f9bd177-0702-43b6-8207-3622687054cb','6af6cb54-df65-4128-84a7-29a76af9c723','10000',NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'2016-04-01',NULL,'0','123456','421003199302054152S',NULL,'15123568541',NULL,NULL,NULL,NULL,NULL,NULL,0,'1','小二',NULL,NULL,NULL),('cbcc541d-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'1',NULL,NULL,'1991-03-10',NULL,'0','YG1000','420123199010123456S','','13926234010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','张静初',NULL,NULL,NULL),('cbcc5cc8-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1990-03-10',NULL,'0','YG1001','420701199103123456S','','13926234011',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','刘德华',NULL,NULL,NULL),('cbcc5e02-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1992-03-10',NULL,'0','YG1002','420612199210123456S','','13926234012',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','王阳',NULL,NULL,NULL),('cbcc5ed4-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'1',NULL,NULL,'1985-03-10',NULL,'0','YG1003','420403198510123456S','深圳市布吉','13926234013',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','刘璐',NULL,NULL,NULL),('cbcc5fa7-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'1',NULL,NULL,'1988-03-10',NULL,'0','YG1004','420123198809123456S','','13926234014',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','王琴',NULL,NULL,NULL),('cbcc628a-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1987-03-10',NULL,'0','YG1005','420805198910123456S','','13926234015',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','周轩',NULL,NULL,NULL),('cbcc6383-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'0',NULL,NULL,'1986-03-10',NULL,'0','YG1006','420123198710123456S','','13926234016',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','熊莲妹',NULL,NULL,NULL),('cbcc644b-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'0',NULL,NULL,'1986-03-10',NULL,'0','YG1007','420154198610123456S','','13926234017',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','宋梦槐',NULL,NULL,NULL),('cbcc671e-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'0',NULL,NULL,'1976-03-10',NULL,'0','YG1008','420123199010123456S','','13926234018',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','张娟',NULL,NULL,NULL),('cbcc67db-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'0',NULL,NULL,'1979-03-10',NULL,'0','YG1009','420123197605123456S','','13926234019',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','刘锦宇',NULL,NULL,NULL),('cbcc69a1-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'1',NULL,'0',NULL,NULL,'1979-03-10',NULL,'0','YG1010','420123197910123456S','','13926234020',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','甘婷婷',NULL,NULL,NULL),('cbcc6a73-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'0',NULL,NULL,'1965-03-10',NULL,'0','YG1011','420123196510123456S','','13926234021',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','刘建国',NULL,NULL,NULL),('cbcc6b25-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1993-08-12',NULL,'0','YG1012','420123199308123456S','深圳南山区','13926234022',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','尹磊',NULL,NULL,NULL),('cbcc6bdd-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1991-12-12',NULL,'0','YG1013','420123199112123456S','','13926234023',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','林海',NULL,NULL,NULL),('cbcc6c84-fd65-11e5-9433-507b9d2ee731','6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL,NULL,'0',NULL,'1',NULL,NULL,'1992-04-12',NULL,'0','YG1014','420123199204123456S','','13926234024',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','张鲁',NULL,NULL,NULL);

/*Table structure for table `t_team_permissions` */

DROP TABLE IF EXISTS `t_team_permissions`;

CREATE TABLE `t_team_permissions` (
  `team_permissions_id` varchar(36) NOT NULL COMMENT '团队权限id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `professional_line_id` varchar(36) DEFAULT NULL COMMENT '专业线id',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '人员id',
  `teamwork_id` varchar(36) DEFAULT NULL COMMENT '团队id(暂存)',
  `core_position_id` varchar(36) DEFAULT NULL COMMENT '核心岗位Id',
  PRIMARY KEY (`team_permissions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_team_permissions` */

insert  into `t_team_permissions`(`team_permissions_id`,`project_id`,`professional_line_id`,`staff_id`,`teamwork_id`,`core_position_id`) values ('1a233186-6448-4197-ae91-8d0056026ae0','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','4','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'eb7ee931-25af-4a3e-9d69-b649f9240954'),('582c3937-02ac-4bea-b4b3-e61c61130549','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'eb7ee931-25af-4a3e-9d69-b649f9240954'),('81c172eb-8f1d-4fbf-b6e5-db1a1928470c','3c435785-745b-1127-f1ae-2a5e8cc64a3b','4','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'eb7ee931-25af-4a3e-9d69-b649f9240954'),('95557d1d-0348-4b69-ab5d-e872212e50b8','3c435785-745b-1127-f1ae-2a5e8cc64a3b','c13123e3-01d1-4b5a-9a9d-bdb00588ce53','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'eb7ee931-25af-4a3e-9d69-b649f9240954'),('dd8e11ac-2ea7-4faf-b11d-e297ec6dc173','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','1','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'eb7ee931-25af-4a3e-9d69-b649f9240954');

/*Table structure for table `t_teamwork` */

DROP TABLE IF EXISTS `t_teamwork`;

CREATE TABLE `t_teamwork` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'ID',
  `manage` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '管理岗位',
  `team_members` int(11) DEFAULT NULL COMMENT '团队成员数量',
  `team_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '团队名称',
  `team_major` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '团队专业',
  `leader` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '团队领袖',
  `management_item` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '管理项目',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `instance_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  `team_work_amount` int(30) DEFAULT NULL COMMENT '团队人数',
  `core_position_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '核心岗位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_teamwork` */

insert  into `t_teamwork`(`id`,`manage`,`team_members`,`team_name`,`team_major`,`leader`,`management_item`,`project_id`,`instance_id`,`team_work_amount`,`core_position_id`) values ('b5f3e1f9-fc9a-11e5-9433-507b9d2ee731',NULL,4,NULL,NULL,'7f9bd177-0702-43b6-8207-3622687054cb',NULL,NULL,NULL,3,'eb7ee931-25af-4a3e-9d69-b649f9240954');

/*Table structure for table `t_teamwork_staff` */

DROP TABLE IF EXISTS `t_teamwork_staff`;

CREATE TABLE `t_teamwork_staff` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `teamwork_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '团队工作id',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '员工id',
  `prepare_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '编制id',
  `post_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位id',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `professional_line_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '专业线id',
  `state` int(11) DEFAULT '0' COMMENT '关系启用状态（0:启用，1:弃用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_teamwork_staff` */

insert  into `t_teamwork_staff`(`id`,`teamwork_id`,`staff_id`,`prepare_id`,`post_id`,`project_id`,`professional_line_id`,`state`) values ('1631e060-ac74-4e3a-be2a-1d0767c0f58c','b5f3e1f9-fc9a-11e5-9433-507b9d2ee731','cbcc541d-fd65-11e5-9433-507b9d2ee731','be9c444b-012c-11e6-a5ea-507b9d2ee731','1fc8844d-7e26-4c46-a7aa-7486f7a450af','3c435785-745b-1127-f1ae-2a5e8cc64a3b','c13123e3-01d1-4b5a-9a9d-bdb00588ce53',0),('596479b4-529a-420f-a1ee-c338c27d08af','b5f3e1f9-fc9a-11e5-9433-507b9d2ee731','cbcc541d-fd65-11e5-9433-507b9d2ee731','be9c43ae-012c-11e6-a5ea-507b9d2ee731','119eb584-7d71-4352-a778-5222d6b6aea0','3c435785-745b-1127-f1ae-2a5e8cc64a3b','c13123e3-01d1-4b5a-9a9d-bdb00588ce53',0),('7ebc105c-28e1-411e-97c4-ccb410d08e8a','b5f3e1f9-fc9a-11e5-9433-507b9d2ee731','cbcc5cc8-fd65-11e5-9433-507b9d2ee731',NULL,NULL,NULL,NULL,0),('98147c86-ca72-4d6a-91e4-a3ad01074ef2','b5f3e1f9-fc9a-11e5-9433-507b9d2ee731','cbcc5e02-fd65-11e5-9433-507b9d2ee731',NULL,NULL,NULL,NULL,0);

/*Table structure for table `t_teamwork_staff_role` */

DROP TABLE IF EXISTS `t_teamwork_staff_role`;

CREATE TABLE `t_teamwork_staff_role` (
  `id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'ID',
  `teamwork_staff_id` varchar(36) DEFAULT NULL COMMENT '团队成员id',
  `user_role_id` varchar(36) DEFAULT NULL COMMENT '用户角色关联id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_teamwork_staff_role` */

insert  into `t_teamwork_staff_role`(`id`,`teamwork_staff_id`,`user_role_id`) values ('f3c9d018-31b5-4c55-818d-28540e522981','64f19063-9e3e-4784-9d2a-b993aae169a3','53665ce5-3bf1-4a33-ac5b-c8d81e3db421'),('fd886df6-60fa-443a-84a1-ba3d85f9742c','596479b4-529a-420f-a1ee-c338c27d08af','4a80fd06-9e29-4f41-8b75-0f74340254ab');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` varchar(36) NOT NULL COMMENT '主键id',
  `employ_id` varchar(36) DEFAULT NULL COMMENT '员工id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `login_name` varchar(64) DEFAULT NULL COMMENT '用户登录名',
  `password` varchar(36) DEFAULT NULL COMMENT '用户密码',
  `tel` char(11) DEFAULT NULL COMMENT '联系电话',
  `document_type` varchar(20) DEFAULT NULL COMMENT '证件类型',
  `document_num` varchar(25) DEFAULT NULL COMMENT '证件号码',
  `creater_id` varchar(30) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_id` varchar(30) DEFAULT NULL COMMENT '修改人id',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `state` tinyint(10) DEFAULT NULL COMMENT '状态；0禁用1启用',
  `company_id` varchar(36) DEFAULT NULL COMMENT '公司id',
  `cashier_status` varchar(36) DEFAULT NULL,
  `cashierLeader_status` varchar(36) DEFAULT NULL,
  `teller_status` varchar(36) DEFAULT NULL,
  `accountant_status` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`employ_id`,`user_name`,`login_name`,`password`,`tel`,`document_type`,`document_num`,`creater_id`,`create_time`,`modify_id`,`modify_time`,`state`,`company_id`,`cashier_status`,`cashierLeader_status`,`teller_status`,`accountant_status`) values ('0b559007-8c7f-4145-aa5b-89806d218c13','7f9bd177-0702-43b6-8207-3622687054cb',NULL,'xe123456','A65F93943B20A3EDFAB103E8511CE6BF',NULL,NULL,NULL,NULL,'2016-04-07 17:52:05',NULL,NULL,1,'6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL),('0fb05f66-9a2b-42e0-adab-78be5634c065','cbcc541d-fd65-11e5-9433-507b9d2ee731',NULL,'zjcYG1000','E10ADC3949BA59ABBE56E057F20F883E',NULL,NULL,NULL,NULL,'2016-04-12 14:14:05',NULL,NULL,1,'6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL),('1fb37077-bbee-44f9-b235-9af0f0e53e3e',NULL,NULL,'liyan@lii.cn','E10ADC3949BA59ABBE56E057F20F883E',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'6af6cb54-df65-4128-84a7-29a76af9c723',NULL,NULL,NULL,NULL);

/*Table structure for table `t_user_permissions` */

DROP TABLE IF EXISTS `t_user_permissions`;

CREATE TABLE `t_user_permissions` (
  `role_permissions_id` varchar(36) NOT NULL COMMENT '角色权限id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id(暂存)',
  `permissions_id` varchar(36) DEFAULT NULL COMMENT '功能权限id(必填)',
  `anthorty_id` varchar(36) DEFAULT NULL COMMENT '操作权限id',
  `create_id` varchar(36) DEFAULT NULL COMMENT '创建时间',
  `create_time` datetime DEFAULT NULL,
  `update_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id（必填）',
  PRIMARY KEY (`role_permissions_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

/*Data for the table `t_user_permissions` */

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT 'hr管理员id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统模块用户角色关联表';

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`user_id`,`role_id`,`create_time`) values ('4a80fd06-9e29-4f41-8b75-0f74340254ab','0fb05f66-9a2b-42e0-adab-78be5634c065','9334c6c2-5fd0-4400-9070-2a74de0fadca',NULL),('aec99f9b-586e-4599-8758-7d604375fc1f','1fb37077-bbee-44f9-b235-9af0f0e53e3e','681ea2e9-74b9-4dde-9f46-2f7b0d7ee423',NULL),('dfb883f4-0ac9-41fb-80e4-ec49984087ad','0fb05f66-9a2b-42e0-adab-78be5634c065','d408f764-cdad-48cc-9530-2c86d617802f','2016-04-12 14:14:05'),('fdf093aa-a129-4e68-904e-1882cf622b42','0b559007-8c7f-4145-aa5b-89806d218c13','d408f764-cdad-48cc-9530-2c86d617802f','2016-04-07 17:52:05');

/*Table structure for table `t_userscheduling` */

DROP TABLE IF EXISTS `t_userscheduling`;

CREATE TABLE `t_userscheduling` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '员工id',
  `scheduling_id` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '排班次id',
  `t_hillock` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '岗位id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='排班与员工关联表';

/*Data for the table `t_userscheduling` */

/*Table structure for table `t_vacation` */

DROP TABLE IF EXISTS `t_vacation`;

CREATE TABLE `t_vacation` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '假期id',
  `vacation_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '假期名称',
  `vacation_start_date` date DEFAULT NULL COMMENT '开始时间',
  `vacation_end_date` date DEFAULT NULL COMMENT '结束时间',
  `dayCount` int(11) DEFAULT NULL COMMENT '天数',
  `state` tinyint(4) DEFAULT '1' COMMENT '状态(是否为删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_vacation` */

/*Table structure for table `t_vip_project_staff` */

DROP TABLE IF EXISTS `t_vip_project_staff`;

CREATE TABLE `t_vip_project_staff` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `vip_id` varchar(36) DEFAULT NULL COMMENT '关联vip人员id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '关联项目id',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '关联专员id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='VIP客户关联项目(t_project)及专员(t_staff.staffId)';

/*Data for the table `t_vip_project_staff` */

/*Table structure for table `t_water_meter` */

DROP TABLE IF EXISTS `t_water_meter`;

CREATE TABLE `t_water_meter` (
  `water_meter_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '水表id',
  `assets_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `water_meter_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '表编号',
  `state` tinyint(4) DEFAULT NULL COMMENT '表状态',
  `ratio` double DEFAULT NULL COMMENT '倍率',
  `max` double DEFAULT NULL COMMENT '最大数值',
  `min` double DEFAULT NULL COMMENT '最小数值',
  `whether_repeated_use` tinyint(4) DEFAULT NULL COMMENT '是否循环使用',
  `operator` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`water_meter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_water_meter` */

/*Table structure for table `t_water_meter_project` */

DROP TABLE IF EXISTS `t_water_meter_project`;

CREATE TABLE `t_water_meter_project` (
  `water_meter_project_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '水表抄表计划关系表id',
  `water_meter_records_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表使用记录id',
  `reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划id',
  PRIMARY KEY (`water_meter_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_water_meter_project` */

/*Table structure for table `t_water_meter_records` */

DROP TABLE IF EXISTS `t_water_meter_records`;

CREATE TABLE `t_water_meter_records` (
  `water_meter_records_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '水表使用记录id',
  `water_meter_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表id',
  `installation_time` date DEFAULT NULL COMMENT '安装时间',
  `enabling_time` date DEFAULT NULL COMMENT '启用时间',
  `install` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '安装人',
  `outage_time` date DEFAULT NULL COMMENT '停用时间',
  `using_nature` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '使用性质',
  `water_meter_building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表所属建筑id',
  `assets_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `state` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '表状态',
  `reading_way` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表方式',
  `parent_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '父表id',
  `is_billing` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '是否计费表',
  `initial_reading` double DEFAULT NULL COMMENT '初始读数',
  `stop_reading` double DEFAULT NULL COMMENT '停用读数',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `parent_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '父表编号',
  PRIMARY KEY (`water_meter_records_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_water_meter_records` */

/*Table structure for table `t_water_meter_types` */

DROP TABLE IF EXISTS `t_water_meter_types`;

CREATE TABLE `t_water_meter_types` (
  `water_meter_types_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '水表所属建筑类型id',
  `water_meter_types_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '水表所有建筑类型名称',
  `water_meter_described` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '表描述',
  PRIMARY KEY (`water_meter_types_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_water_meter_types` */

/*Table structure for table `tb_gating` */

DROP TABLE IF EXISTS `tb_gating`;

CREATE TABLE `tb_gating` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT 'id',
  `equipment_num` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备id',
  `account_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '账户id',
  `equipment_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备名称',
  `equipment_model` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备型号',
  `batch_nummer` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '批次编号',
  `Manufacture_date` date DEFAULT NULL COMMENT '出厂日期',
  `quality_time_start` date DEFAULT NULL COMMENT '质保开始日期',
  `scrap_time` date DEFAULT NULL COMMENT '报废日期',
  `scrap_cause` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '报废原因',
  `quality_term` int(11) DEFAULT NULL COMMENT '质保年限',
  `employ_term` int(11) DEFAULT NULL COMMENT '使用年限',
  `facility_state` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '当前门控机的状态（未销售，已销售，正在使用，维修中，报废）',
  `market_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '销售合同ID',
  `purchase_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '采购订单ID',
  `production_firm` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产厂商',
  `production_site` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '生产地址',
  `district` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '位置',
  `two_dimension_code` varchar(2000) CHARACTER SET utf8 DEFAULT NULL COMMENT '二维码',
  `open_gating_state` tinyint(1) DEFAULT '0' COMMENT '门控机开门状态（1开门2关门）',
  `is_wall_gating` tinyint(4) DEFAULT '0' COMMENT '是否为围墙机(0不是1是)',
  `sip` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT 'sip账号id',
  `employ_company` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '所属公司名',
  `employ_project` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '所属项目名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tb_gating` */

/*Table structure for table `tb_info` */

DROP TABLE IF EXISTS `tb_info`;

CREATE TABLE `tb_info` (
  `info_id` varchar(36) NOT NULL,
  `info1` varchar(100) DEFAULT NULL,
  `info2` varchar(100) DEFAULT NULL,
  `info3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_info` */

/*Table structure for table `tb_menu` */

DROP TABLE IF EXISTS `tb_menu`;

CREATE TABLE `tb_menu` (
  `menu_id` varchar(36) NOT NULL,
  `menu_name` varchar(20) DEFAULT NULL,
  `menu_url` varchar(100) DEFAULT NULL,
  `parent_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_menu` */

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `role_id` varchar(36) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` varchar(10) NOT NULL,
  `loginname` varchar(64) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `rights` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `role_id` varchar(10) DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `self_sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `photo` varchar(50) DEFAULT '201501281132084175879265618.jpg' COMMENT '头像',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `group_id` varchar(12) DEFAULT NULL COMMENT '分组编号',
  `permission` int(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

/*Table structure for table `tc_acceptance_house` */

DROP TABLE IF EXISTS `tc_acceptance_house`;

CREATE TABLE `tc_acceptance_house` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '验房管理主键',
  `person_in_charge` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人',
  `person_in_charge_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人姓名',
  `start_date` datetime DEFAULT NULL COMMENT '验房开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '验房结束日期',
  `acceptance_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '类型（验房类型）',
  `issuer` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '任务发布创建人',
  `issuer_date` datetime DEFAULT NULL COMMENT '发布日期',
  `project_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '项目的id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_acceptance_house` */

/*Table structure for table `tc_acceptance_house_relation` */

DROP TABLE IF EXISTS `tc_acceptance_house_relation`;

CREATE TABLE `tc_acceptance_house_relation` (
  `id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '验房团队建筑关系表主键',
  `acceptance_house_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '验房活动id(验房表tc_acceptance)',
  `staff_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '团队成员id(团队成员表t_staff)',
  `building_structure_id` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id（来源于建筑结构表tc_building_structure）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_acceptance_house_relation` */

/*Table structure for table `tc_account` */

DROP TABLE IF EXISTS `tc_account`;

CREATE TABLE `tc_account` (
  `account_id` varchar(36) NOT NULL COMMENT '账户id',
  `account_num` varchar(36) DEFAULT NULL COMMENT '账户编号',
  `is_bank_card` tinyint(11) DEFAULT NULL COMMENT '是否绑定银行卡（0已绑定1未绑定）',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目ID',
  `disposable_balance` double DEFAULT NULL COMMENT '可支配余额',
  `total_balance` double DEFAULT NULL COMMENT '总余额',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `enterprise_id` varchar(36) DEFAULT NULL COMMENT '企业客户id',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_account` */

insert  into `tc_account`(`account_id`,`account_num`,`is_bank_card`,`project_id`,`disposable_balance`,`total_balance`,`cust_id`,`enterprise_id`) values ('023f9681-ad26-467f-bf0d-fe17c577863c','10001',0,NULL,0,0,'fe8956e5-33c7-458b-9ff9-c9d24bae600d',NULL),('22c182fd-cf0a-4147-881b-432590f7031b','10000',0,NULL,0,0,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL),('8c0fd309-2197-46e5-bf2d-e72d046e7ae7','10002',0,NULL,0,0,'f343dbda-f7f0-451f-815b-bbe4a7cf655d',NULL);

/*Table structure for table `tc_account_record` */

DROP TABLE IF EXISTS `tc_account_record`;

CREATE TABLE `tc_account_record` (
  `account_record_id` varchar(36) NOT NULL COMMENT '交账记录id',
  `account_total_num` int(30) DEFAULT NULL COMMENT '交账笔数',
  `cash_sum` double DEFAULT NULL COMMENT '现金金额',
  `credit_card_sum` double DEFAULT NULL COMMENT '刷卡金额',
  `wechat_sum` double DEFAULT NULL COMMENT '微信金额',
  `refund_sum` double DEFAULT NULL COMMENT '退款金额',
  `financial_staff_id` varchar(36) DEFAULT NULL COMMENT '交账人id',
  `account_time` date DEFAULT NULL COMMENT '交账时间',
  `account_state` tinyint(11) DEFAULT NULL COMMENT '交账状态（0待收账账1交账中2已完成3已取消）',
  `total_sum` double DEFAULT NULL COMMENT '总金额',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '收账人id',
  `batch_num` varchar(36) DEFAULT NULL COMMENT '批次',
  `account_type` tinyint(11) DEFAULT NULL COMMENT '交账状态(0现金交账1结算)',
  `parent_id` varchar(380) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`account_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_account_record` */

insert  into `tc_account_record`(`account_record_id`,`account_total_num`,`cash_sum`,`credit_card_sum`,`wechat_sum`,`refund_sum`,`financial_staff_id`,`account_time`,`account_state`,`total_sum`,`staff_id`,`batch_num`,`account_type`,`parent_id`) values ('758b4538-f825-4f84-b508-595131685a30',1,1,0,0,0,'cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-04-28',2,0,'cbcc541d-fd65-11e5-9433-507b9d2ee731','1461813751661',0,NULL),('769ab3c3-957e-4012-89e5-00bd9e33404d',1,0,0,0,0,'cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-04-28',2,0,'cbcc541d-fd65-11e5-9433-507b9d2ee731','1461813751661',1,NULL);

/*Table structure for table `tc_account_relation` */

DROP TABLE IF EXISTS `tc_account_relation`;

CREATE TABLE `tc_account_relation` (
  `account_relation_id` varchar(36) NOT NULL COMMENT '账户关系id',
  `account_id` varchar(36) DEFAULT NULL COMMENT '账户id',
  `asset_account` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '资产账户id',
  PRIMARY KEY (`account_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_account_relation` */

insert  into `tc_account_relation`(`account_relation_id`,`account_id`,`asset_account`) values ('27421937-b428-4c23-bfa1-2474f2f7287b','22c182fd-cf0a-4147-881b-432590f7031b','6390c3c6-17a5-43d4-8976-f617301ffc16'),('3ac210d4-00cc-4340-bd20-349a736a64c4','22c182fd-cf0a-4147-881b-432590f7031b','dad0a850-e56d-426d-ba8e-6f3f300cad19'),('3e1c2ada-ce5a-4fa9-9ba8-d4433cfc21c1','22c182fd-cf0a-4147-881b-432590f7031b','01aa848c-7392-4ab0-b585-80182da4a8dc'),('51d774d3-e427-4262-8ef4-93cb3dd97fce','22c182fd-cf0a-4147-881b-432590f7031b','c389d85d-8c6a-40a7-bf91-604b322410d6'),('ae082b24-967b-4000-82bf-2291e43b2815','023f9681-ad26-467f-bf0d-fe17c577863c','8416ebed-a4fb-41b2-95fe-1378a5d66343'),('e2457cd9-75fa-43fe-8475-22f62213ccb5','8c0fd309-2197-46e5-bf2d-e72d046e7ae7','3fc63d3e-b323-486e-b096-8cb53f75d417');

/*Table structure for table `tc_action` */

DROP TABLE IF EXISTS `tc_action`;

CREATE TABLE `tc_action` (
  `action_id` varchar(36) NOT NULL COMMENT '操作权限id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '功能权限id',
  `action_name` varchar(50) DEFAULT NULL COMMENT '操作名称',
  `action_type` tinyint(4) DEFAULT NULL COMMENT '操作分类',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标识',
  `action_instruction` varchar(50) DEFAULT NULL COMMENT '操作描述',
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_action` */

/*Table structure for table `tc_advance_payments_details` */

DROP TABLE IF EXISTS `tc_advance_payments_details`;

CREATE TABLE `tc_advance_payments_details` (
  `advance_payments_details_id` varchar(36) NOT NULL COMMENT '预收款明细id',
  `is_out_in` tinyint(11) DEFAULT NULL COMMENT '收支类别(0收入1支出)',
  `asset_account_num` varchar(36) DEFAULT NULL COMMENT '资产账户编号',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '计费id',
  `payment_type` tinyint(11) DEFAULT NULL COMMENT '支付类型（0现金1刷卡2微信）',
  `transaction_amount` double DEFAULT NULL COMMENT '交易金额',
  `transaction_date` date DEFAULT NULL COMMENT '交易时间',
  `account_balance` double DEFAULT NULL COMMENT '账户余额',
  `note` varchar(100) DEFAULT NULL COMMENT '说明',
  `asset_account_id` varchar(36) DEFAULT NULL COMMENT '资产账户id',
  `refundable_deposit_amount` double DEFAULT NULL COMMENT '可退押金金额',
  `charge_item_name` varchar(36) DEFAULT NULL COMMENT '可抵扣收费项目',
  `deposit_num` varchar(36) DEFAULT NULL COMMENT '押金单号',
  PRIMARY KEY (`advance_payments_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_advance_payments_details` */

insert  into `tc_advance_payments_details`(`advance_payments_details_id`,`is_out_in`,`asset_account_num`,`bill_id`,`payment_type`,`transaction_amount`,`transaction_date`,`account_balance`,`note`,`asset_account_id`,`refundable_deposit_amount`,`charge_item_name`,`deposit_num`) values ('2f3a5f08-34a6-42de-b19c-8634b368ec99',0,'house10004',NULL,0,1,'2016-04-28',0,NULL,'dad0a850-e56d-426d-ba8e-6f3f300cad19',1,'水费','1461813655610');

/*Table structure for table `tc_architecture` */

DROP TABLE IF EXISTS `tc_architecture`;

CREATE TABLE `tc_architecture` (
  `architecture_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公建信息id',
  `architecture_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公建名称',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '位置描述',
  `usable_area` double DEFAULT NULL COMMENT '实用面积',
  `building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑id',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_architecture` */

/*Table structure for table `tc_area` */

DROP TABLE IF EXISTS `tc_area`;

CREATE TABLE `tc_area` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '面积表主键',
  `building_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑id',
  `area_type_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '面积类型id',
  `building_area` double DEFAULT NULL COMMENT '建筑面积',
  `commonality_area` double DEFAULT NULL COMMENT '公摊面积',
  `inside_area` double DEFAULT NULL COMMENT '套内面积',
  `utility_ratio` double DEFAULT NULL COMMENT '实用率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_area` */

insert  into `tc_area`(`id`,`building_id`,`area_type_id`,`building_area`,`commonality_area`,`inside_area`,`utility_ratio`) values ('dca13240-129c-11e6-a92c-507b9d2ee731','a165026d-4452-40e4-abb1-74b1cf8d2cf8','49eb98be-97d9-11e5-ae0b-74d4359b657c',100,0,100,100),('dca857f4-129c-11e6-a92c-507b9d2ee731','a165026d-4452-40e4-abb1-74b1cf8d2cf8','577f0d21-97da-11e5-ae0b-74d4359b657c',100,0,100,100),('dca8abc0-129c-11e6-a92c-507b9d2ee731','a165026d-4452-40e4-abb1-74b1cf8d2cf8','a4631b06-97da-11e5-ae0b-74d4359b657c',100,0,100,100),('fa9e2e52-17f3-11e6-8b95-507b9d2ee731','19c160ac-4fb4-4ade-9abe-efe312d267aa','49eb98be-97d9-11e5-ae0b-74d4359b657c',1,1,1,1);

/*Table structure for table `tc_area_division` */

DROP TABLE IF EXISTS `tc_area_division`;

CREATE TABLE `tc_area_division` (
  `area_division_id` varchar(36) NOT NULL COMMENT '面积划分id',
  `area_division_name` varchar(36) DEFAULT NULL COMMENT '面积划分名称',
  `areas` varchar(36) DEFAULT NULL COMMENT '面积',
  `area_division_num` varchar(36) DEFAULT NULL COMMENT '面积划分序号',
  `unit_price` double DEFAULT NULL COMMENT '单价',
  `sum` double DEFAULT NULL COMMENT '总金额',
  `product_id` varchar(36) DEFAULT NULL COMMENT '产品id',
  PRIMARY KEY (`area_division_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='面积划分表';

/*Data for the table `tc_area_division` */

insert  into `tc_area_division`(`area_division_id`,`area_division_name`,`areas`,`area_division_num`,`unit_price`,`sum`,`product_id`) values ('570303f4-e94b-41d3-9dad-502c07c32e95','1','1','1',1,1,'e107efa3-2dd7-4787-a18e-4368edbe126b'),('5bce08bf-d232-42b5-bb38-273d1e595cd6','1','100.5','1',4999.5,502449.75,'63352b6c-999f-4f7f-89f8-61f76b59d18c'),('91950f4e-41e1-4d4d-b4ba-9c290e5b344a','2','200','2',2555,511000,'63352b6c-999f-4f7f-89f8-61f76b59d18c'),('9e700ba0-85a0-442d-947d-2a72d818bb46','灯箱1','1.7','2',1200,2040,'adefd4bd-6bd1-4e49-ba50-04ea89a873dc'),('a400412b-fbc1-48b0-9e6c-a68017aa4587','单间','15','1',46.6667,700,'d3c4d849-4277-40d4-b059-32684c09d806'),('d27c8015-4f9f-4b42-ab89-21064b8fbbbc','单间','20','1',50,1000,'7949d625-e231-4696-a8f7-c3ab63c63a2c'),('e018c828-cce0-4f95-af90-72c403d256bc','1','1','1',1,1,'4a604c0c-7b53-4500-b44b-1178787ace94'),('e4f7a1a0-185f-4f52-bcb8-0a157ff2d6f4','3','100','3',3995.5,399550,'63352b6c-999f-4f7f-89f8-61f76b59d18c'),('f8241081-7bfd-4b17-8b5d-9125452ffd60','广告牌1','0.50','1',1000,500,'adefd4bd-6bd1-4e49-ba50-04ea89a873dc');

/*Table structure for table `tc_area_type` */

DROP TABLE IF EXISTS `tc_area_type`;

CREATE TABLE `tc_area_type` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '面积类型主键',
  `area_type_code` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '面积类型代号',
  `area_type_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '面积类型名称',
  `remark` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_area_type` */

insert  into `tc_area_type`(`id`,`area_type_code`,`area_type_name`,`remark`,`create_time`) values ('49eb98be-97d9-11e5-ae0b-74d4359b657c','house','住宅',NULL,'2015-12-01 00:00:00'),('5088ca09-97da-11e5-ae0b-74d4359b657c','publicbuild','公建',NULL,'2015-12-01 00:00:00'),('577f0d21-97da-11e5-ae0b-74d4359b657c','store','商铺',NULL,'2015-12-01 00:00:00'),('a4631b06-97da-11e5-ae0b-74d4359b657c','parkspace','车位',NULL,'2015-12-01 00:00:00'),('aa25b8a9-97da-11e5-ae0b-74d4359b657c','pool','公摊',NULL,'2015-12-01 00:00:00');

/*Table structure for table `tc_article` */

DROP TABLE IF EXISTS `tc_article`;

CREATE TABLE `tc_article` (
  `article_id` varchar(36) NOT NULL COMMENT '物品id',
  `article_name` varchar(50) DEFAULT NULL COMMENT '物品名称',
  `article_describe` varchar(400) DEFAULT NULL COMMENT '物品描述',
  `state` int(4) DEFAULT NULL COMMENT '状态（0是拾到物品，1是遗失物品）',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_article` */

/*Table structure for table `tc_article_state` */

DROP TABLE IF EXISTS `tc_article_state`;

CREATE TABLE `tc_article_state` (
  `article_state_id` varchar(36) NOT NULL COMMENT '遗失物品关系id',
  `article_id` varchar(36) DEFAULT NULL COMMENT '物品id',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '失主id',
  `time` datetime DEFAULT NULL COMMENT '拾到时间',
  `site` varchar(400) DEFAULT NULL COMMENT '地点描述',
  `remark` varchar(400) DEFAULT NULL COMMENT '备注',
  `state` int(4) DEFAULT NULL COMMENT '0关系开启，1关系关闭',
  PRIMARY KEY (`article_state_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_article_state` */

/*Table structure for table `tc_asset_account` */

DROP TABLE IF EXISTS `tc_asset_account`;

CREATE TABLE `tc_asset_account` (
  `asset_account_id` varchar(36) NOT NULL COMMENT '资产账户id',
  `asset_account_name` varchar(50) DEFAULT NULL COMMENT '资产账户名称',
  `asset_num` varchar(36) DEFAULT NULL COMMENT '资产编号',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `full_name` varchar(50) DEFAULT NULL COMMENT '房屋全名',
  `asset_account_num` varchar(36) DEFAULT NULL COMMENT '资产账户编号',
  `is_bank_card` tinyint(11) DEFAULT NULL COMMENT '是否绑定银行卡（0已绑定1未绑定）',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目ID',
  `asset_account_balance` double DEFAULT NULL COMMENT '资产账户余额',
  `asset_account_type` tinyint(11) DEFAULT NULL COMMENT '账户类型（0资产账户1押金账户）',
  `total_deposits` double DEFAULT NULL COMMENT '押金总额',
  `total_refundable_deposit` double DEFAULT NULL COMMENT '可退还押金总额',
  `general_balance` double DEFAULT NULL COMMENT '通用余额',
  PRIMARY KEY (`asset_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_asset_account` */

insert  into `tc_asset_account`(`asset_account_id`,`asset_account_name`,`asset_num`,`building_id`,`full_name`,`asset_account_num`,`is_bank_card`,`project_id`,`asset_account_balance`,`asset_account_type`,`total_deposits`,`total_refundable_deposit`,`general_balance`) values ('01aa848c-7392-4ab0-b585-80182da4a8dc',NULL,NULL,'0da2d314-cb9d-42de-aa64-d492af535475','10区地下车库栋地下1层00001号','stall10011',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('289410ab-0ae5-47df-9e68-17eedc014ee9',NULL,NULL,'15eb7bce-4f87-40c0-9a6c-f9f84e439de8','02区002栋2单元0208房','house10010',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('289f9a78-374b-4a53-8be0-18330cd3f6fb',NULL,NULL,'6715c00d-7531-48b1-b931-147cec2e579e','1区1栋1单元101','house10014',0,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,0,0,0,0),('3fc63d3e-b323-486e-b096-8cb53f75d417',NULL,NULL,NULL,NULL,'cust10002',1,NULL,0,1,0,0,0),('5a665d7b-1a9e-4626-a85b-a8b2965fb189',NULL,NULL,'2d2e387b-d204-428e-a56a-87a2c3484041','123234345','house10015',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('626cf742-bf09-481c-b9c3-de074851eb8b',NULL,NULL,'af7df170-e172-45a2-abf5-82eea7679e58','02区002栋2单元0205房','house10007',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('6390c3c6-17a5-43d4-8976-f617301ffc16',NULL,NULL,NULL,NULL,'cust10000',1,NULL,0,1,0,0,0),('7fc96dbe-495b-4684-b761-da06156a48b8',NULL,NULL,'2406fdec-5064-4adc-bac9-29aea87c5663','02区002栋2单元0206房','house10008',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('8416ebed-a4fb-41b2-95fe-1378a5d66343',NULL,NULL,NULL,NULL,'cust10001',1,NULL,0,1,0,0,0),('87657125-ae06-471a-bdc1-5aa69dfd91e6',NULL,NULL,'24fd05c6-be8b-4372-badb-a2ea353f55d2','02区002栋1单元0203房','house10005',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('8f950682-104c-4342-a16d-b6a49a77d4b6',NULL,NULL,'fc4591d6-fbdb-497b-8e31-c675a56d6134','02区002栋1单元0204房','house10006',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('adafef4b-9d17-4c6b-a3d3-10d29b088c1f',NULL,NULL,'8a4acd23-4285-4307-a603-1823e61089ae','10区地下车库栋地下1层00002号','stall10012',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('aebbaf40-ea46-4511-bbac-0e977e9f3c3e',NULL,NULL,'20c646ab-1346-4298-9b50-912da0c2ddc3','02区002栋2单元0207房','house10009',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('b98585d2-7284-4d2c-9b38-e03e91c0d83b',NULL,NULL,'3a32b958-4498-4cc2-bfaa-cd2bea469fcc','1区1栋1单元103','stall10013',0,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,2,0,0,0),('c389d85d-8c6a-40a7-bf91-604b322410d6',NULL,NULL,'16030350-17e5-481b-9d39-7973353d20b9','02区002栋1单元0201房','house10003',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0),('dad0a850-e56d-426d-ba8e-6f3f300cad19',NULL,NULL,'775ac943-8709-438b-a5ad-7049fc92b38b','02区002栋1单元0202房','house10004',0,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,0,0,0,0);

/*Table structure for table `tc_asset_account_detail` */

DROP TABLE IF EXISTS `tc_asset_account_detail`;

CREATE TABLE `tc_asset_account_detail` (
  `asset_account_detail_id` varchar(36) NOT NULL COMMENT '资产账户详情id',
  `asset_account_id` varchar(36) DEFAULT NULL COMMENT '资产账户id',
  `detail_name` varchar(36) DEFAULT NULL COMMENT '详情名称',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id',
  `disposable_balance` double(36,2) DEFAULT NULL COMMENT '可支配余额',
  PRIMARY KEY (`asset_account_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_asset_account_detail` */

insert  into `tc_asset_account_detail`(`asset_account_detail_id`,`asset_account_id`,`detail_name`,`charge_item_id`,`disposable_balance`) values ('061357f1-4a45-49d6-b88a-f373909d3114','dad0a850-e56d-426d-ba8e-6f3f300cad19','水费','5e27d07a-46a2-4691-b483-472a3d460888',1.00);

/*Table structure for table `tc_bank_deposit` */

DROP TABLE IF EXISTS `tc_bank_deposit`;

CREATE TABLE `tc_bank_deposit` (
  `bank_deposit_id` varchar(36) NOT NULL COMMENT '银行存单id',
  `bank_deposit_num` varchar(36) DEFAULT NULL COMMENT '银行存单号',
  `sum` double DEFAULT NULL COMMENT '金额',
  `account_record_id` varchar(36) DEFAULT NULL COMMENT '交账记录id',
  PRIMARY KEY (`bank_deposit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_bank_deposit` */

/*Table structure for table `tc_bill` */

DROP TABLE IF EXISTS `tc_bill`;

CREATE TABLE `tc_bill` (
  `bill_id` varchar(36) NOT NULL COMMENT '账单id',
  `asset_type` tinyint(11) DEFAULT NULL COMMENT '资产类型',
  `bill_num` varchar(36) DEFAULT NULL COMMENT '账单编号',
  `building_billing_id` varchar(36) DEFAULT NULL COMMENT '建筑收费项目计费id',
  `billing_sum` double DEFAULT NULL COMMENT '账单金额',
  `bill_date` datetime DEFAULT NULL COMMENT '账单时间',
  `bill_state` tinyint(11) DEFAULT NULL COMMENT '账单状态（0已交账1未交账）',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `full_name` varchar(36) DEFAULT NULL COMMENT '房屋全名',
  `charge_item_name` varchar(36) DEFAULT NULL COMMENT '收费项目名称',
  `project_name` varchar(36) DEFAULT NULL COMMENT '项目名称',
  `collect_sum` double DEFAULT NULL COMMENT '实收金额',
  `no_collect_sum` double DEFAULT NULL COMMENT '未收金额',
  `overdue` double DEFAULT NULL COMMENT '滯納金',
  `last_overdue` double DEFAULT NULL COMMENT '上期滞纳金',
  `current_overdue` double DEFAULT NULL COMMENT '本期滞纳金',
  `electronic_billing_id` varchar(36) DEFAULT NULL COMMENT '电子账单id',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  `current_owe_sum` double DEFAULT NULL COMMENT '本期欠款金额',
  `last_owe_sum` double DEFAULT NULL COMMENT '上期欠款金额',
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_bill` */

/*Table structure for table `tc_bill_advance_payments_details_relation` */

DROP TABLE IF EXISTS `tc_bill_advance_payments_details_relation`;

CREATE TABLE `tc_bill_advance_payments_details_relation` (
  `bill_advance_payments_details_relation_id` varchar(36) NOT NULL COMMENT '主键id',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '应收款id',
  `advance_payments_details_id` varchar(36) DEFAULT NULL COMMENT '预付款明细id',
  PRIMARY KEY (`bill_advance_payments_details_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_bill_advance_payments_details_relation` */

/*Table structure for table `tc_bill_payment_relation` */

DROP TABLE IF EXISTS `tc_bill_payment_relation`;

CREATE TABLE `tc_bill_payment_relation` (
  `bill_payment_relation_id` varchar(36) NOT NULL COMMENT '关系id',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '账单id',
  `payment_details_id` varchar(36) DEFAULT NULL COMMENT '支付明细id',
  `wx_sum` double(36,2) DEFAULT NULL COMMENT '微信金额',
  `cash_sum` double(36,2) DEFAULT NULL COMMENT '现金金额',
  `card_sum` double(36,2) DEFAULT NULL COMMENT '刷卡金额',
  `sum` double(36,2) DEFAULT NULL COMMENT '支付总金额',
  PRIMARY KEY (`bill_payment_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_bill_payment_relation` */

/*Table structure for table `tc_billing` */

DROP TABLE IF EXISTS `tc_billing`;

CREATE TABLE `tc_billing` (
  `billing_id` varbinary(36) NOT NULL COMMENT '计费id',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  `billing_start_time` date DEFAULT NULL COMMENT '计费开始时间',
  `billing_end_time` date DEFAULT NULL COMMENT '计费结束时间',
  `billing_balance` double DEFAULT NULL COMMENT '计费金额',
  `scheme_datails_id` varchar(36) DEFAULT NULL COMMENT '方案详情id',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `billing_state` tinyint(11) DEFAULT NULL COMMENT '计费状态',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `building_billing_id` varchar(36) DEFAULT NULL COMMENT '建筑收费项目计费id',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '应收款id',
  `is_deposit_deduct` tinyint(11) DEFAULT NULL COMMENT '是否为押金扣款',
  PRIMARY KEY (`billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_billing` */

/*Table structure for table `tc_building` */

DROP TABLE IF EXISTS `tc_building`;

CREATE TABLE `tc_building` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '建筑主键',
  `building_num` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑编号',
  `building_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑名称',
  `region_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '区域id',
  `stage_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '期id',
  `building_area` double DEFAULT NULL COMMENT '总建筑面积',
  `total_area` double DEFAULT NULL COMMENT '总用地面积',
  `commonality_area` double DEFAULT NULL COMMENT '公摊面积',
  `inside_area` double DEFAULT NULL COMMENT '套内面积',
  `completion_area` double DEFAULT NULL COMMENT '竣工面积',
  `utility_ratio` double DEFAULT NULL COMMENT '实用率',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `parcel_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宗地id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_building` */

insert  into `tc_building`(`id`,`building_num`,`building_name`,`region_id`,`stage_id`,`building_area`,`total_area`,`commonality_area`,`inside_area`,`completion_area`,`utility_ratio`,`project_id`,`parcel_id`) values ('19c160ac-4fb4-4ade-9abe-efe312d267aa',NULL,'123',NULL,NULL,1,2,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b','be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('1c94733c-f5f0-439e-91d5-79cf028f3e92',NULL,'10区地下车库栋',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b','be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('60cde92b-5879-449f-bcb9-594813ab1ec3',NULL,'02区002栋',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b','be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('a165026d-4452-40e4-abb1-74b1cf8d2cf8',NULL,'1区1栋',NULL,NULL,300,500,NULL,NULL,NULL,NULL,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','de14b7c2-fc9a-11e5-9433-507b9d2ee731');

/*Table structure for table `tc_building_billing` */

DROP TABLE IF EXISTS `tc_building_billing`;

CREATE TABLE `tc_building_billing` (
  `building_billing_id` varchar(36) NOT NULL COMMENT '建筑收费项目计费id',
  `billing_start_time` date DEFAULT NULL COMMENT '计费开始时间',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  `billing_end_time` date DEFAULT NULL COMMENT '计费结束时间',
  `billing_balance` double DEFAULT NULL COMMENT '计费金额',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `billing_state` tinyint(11) DEFAULT NULL COMMENT '计费状态',
  `charge_item_billing_id` varchar(36) DEFAULT NULL COMMENT '收费项目计费id',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id',
  PRIMARY KEY (`building_billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_building_billing` */

/*Table structure for table `tc_building_component` */

DROP TABLE IF EXISTS `tc_building_component`;

CREATE TABLE `tc_building_component` (
  `component_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '建筑组件id',
  `component_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑组件编码',
  `component_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑组件名称',
  `component_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑组件类型id(建筑面积属性)',
  `create_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人姓名',
  `creater_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人信息',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `sort_date` datetime DEFAULT NULL,
  PRIMARY KEY (`component_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_building_component` */

insert  into `tc_building_component`(`component_id`,`component_num`,`component_name`,`component_type`,`create_id`,`creater_date`,`update_id`,`update_date`,`sort_date`) values ('5b11d593-1b3e-484d-bac5-40da688564e8','10001','组件2','49eb98be-97d9-11e5-ae0b-74d4359b657c','1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-05-05 16:16:14',NULL,NULL,'2016-05-05 16:16:14'),('8e0b3a0f-aa28-4eb7-8946-a39718a51fe0','10000','组件1','49eb98be-97d9-11e5-ae0b-74d4359b657c','1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-04-12 15:09:09',NULL,NULL,'2016-04-12 15:09:09');

/*Table structure for table `tc_building_structure` */

DROP TABLE IF EXISTS `tc_building_structure`;

CREATE TABLE `tc_building_structure` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '建筑结构主键',
  `full_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '全名',
  `node_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '节点名称',
  `building_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑id',
  `parent_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '父节点id',
  `building_area` double DEFAULT '0' COMMENT '建筑面积',
  `total_area` double DEFAULT '0' COMMENT '总用地面积',
  `commonality_area` double DEFAULT '0' COMMENT '公摊面积',
  `inside_area` double DEFAULT '0' COMMENT '套内面积',
  `completion_area` double DEFAULT '0' COMMENT '竣工面积',
  `utility_ratio` double DEFAULT '0' COMMENT '实用率',
  `building_type` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `area_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `is_binding_assets` tinyint(4) DEFAULT NULL COMMENT '是否绑定资产(0未绑定 1绑定)',
  `product_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联产品表id',
  `parcel_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '宗地id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_building_structure` */

insert  into `tc_building_structure`(`id`,`full_name`,`node_name`,`building_id`,`parent_id`,`building_area`,`total_area`,`commonality_area`,`inside_area`,`completion_area`,`utility_ratio`,`building_type`,`area_id`,`project_id`,`is_binding_assets`,`product_id`,`parcel_id`) values ('0bd55270-8c25-43dd-8a64-9e3545b35480','10区地下车库栋地下1层','地下1层','1c94733c-f5f0-439e-91d5-79cf028f3e92','f5333e99-9f20-4f25-ae6c-0380245f2e3b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('0d349bc0-66db-4446-96d0-b74cdcc583df','1区1栋1单元','1单元','a165026d-4452-40e4-abb1-74b1cf8d2cf8','9b864a25-9710-42e3-bcad-be4291ea1377',NULL,NULL,NULL,NULL,NULL,NULL,'','','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,'de14b7c2-fc9a-11e5-9433-507b9d2ee731'),('0da2d314-cb9d-42de-aa64-d492af535475','10区地下车库栋地下1层00001号','00001号','1c94733c-f5f0-439e-91d5-79cf028f3e92','0bd55270-8c25-43dd-8a64-9e3545b35480',NULL,NULL,NULL,NULL,NULL,NULL,'车位',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',1,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('0e91dcc8-d97f-46fa-831b-eb9b5e439eb7','02区002栋1单元','1单元','60cde92b-5879-449f-bcb9-594813ab1ec3','4b941035-5d6a-4ec9-baf6-5d2ad17623c8',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('15eb7bce-4f87-40c0-9a6c-f9f84e439de8','02区002栋2单元0208房','0208房','60cde92b-5879-449f-bcb9-594813ab1ec3','6a5c10a9-5730-4e89-b698-665e8b0440bd',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('16030350-17e5-481b-9d39-7973353d20b9','02区002栋1单元0201房','0201房','60cde92b-5879-449f-bcb9-594813ab1ec3','0e91dcc8-d97f-46fa-831b-eb9b5e439eb7',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',1,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('1d5272c6-b284-4d7f-8bbf-8d5b38286343','123234','234','19c160ac-4fb4-4ade-9abe-efe312d267aa','3517be42-c183-438a-9180-81b9efdf180f',NULL,NULL,NULL,NULL,NULL,NULL,'','','3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('20c646ab-1346-4298-9b50-912da0c2ddc3','02区002栋2单元0207房','0207房','60cde92b-5879-449f-bcb9-594813ab1ec3','6a5c10a9-5730-4e89-b698-665e8b0440bd',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('2406fdec-5064-4adc-bac9-29aea87c5663','02区002栋2单元0206房','0206房','60cde92b-5879-449f-bcb9-594813ab1ec3','6a5c10a9-5730-4e89-b698-665e8b0440bd',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('24fd05c6-be8b-4372-badb-a2ea353f55d2','02区002栋1单元0203房','0203房','60cde92b-5879-449f-bcb9-594813ab1ec3','0e91dcc8-d97f-46fa-831b-eb9b5e439eb7',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('2d2e387b-d204-428e-a56a-87a2c3484041','123234345','345','19c160ac-4fb4-4ade-9abe-efe312d267aa','1d5272c6-b284-4d7f-8bbf-8d5b38286343',NULL,NULL,NULL,NULL,NULL,NULL,'住宅','49eb98be-97d9-11e5-ae0b-74d4359b657c','3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('3517be42-c183-438a-9180-81b9efdf180f','123','123','19c160ac-4fb4-4ade-9abe-efe312d267aa',NULL,1,2,1,1,NULL,1,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('3a32b958-4498-4cc2-bfaa-cd2bea469fcc','1区1栋1单元103','103','a165026d-4452-40e4-abb1-74b1cf8d2cf8','0d349bc0-66db-4446-96d0-b74cdcc583df',NULL,NULL,NULL,NULL,NULL,NULL,'车位','a4631b06-97da-11e5-ae0b-74d4359b657c','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,'de14b7c2-fc9a-11e5-9433-507b9d2ee731'),('4b941035-5d6a-4ec9-baf6-5d2ad17623c8','02区002栋','02区002栋','60cde92b-5879-449f-bcb9-594813ab1ec3',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('6715c00d-7531-48b1-b931-147cec2e579e','1区1栋1单元101','101','a165026d-4452-40e4-abb1-74b1cf8d2cf8','0d349bc0-66db-4446-96d0-b74cdcc583df',NULL,NULL,NULL,NULL,NULL,NULL,'住宅','49eb98be-97d9-11e5-ae0b-74d4359b657c','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,'de14b7c2-fc9a-11e5-9433-507b9d2ee731'),('6a5c10a9-5730-4e89-b698-665e8b0440bd','02区002栋2单元','2单元','60cde92b-5879-449f-bcb9-594813ab1ec3','4b941035-5d6a-4ec9-baf6-5d2ad17623c8',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('775ac943-8709-438b-a5ad-7049fc92b38b','02区002栋1单元0202房','0202房','60cde92b-5879-449f-bcb9-594813ab1ec3','0e91dcc8-d97f-46fa-831b-eb9b5e439eb7',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',1,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('8a4acd23-4285-4307-a603-1823e61089ae','10区地下车库栋地下1层00002号','00002号','1c94733c-f5f0-439e-91d5-79cf028f3e92','0bd55270-8c25-43dd-8a64-9e3545b35480',NULL,NULL,NULL,NULL,NULL,NULL,'车位',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('9b864a25-9710-42e3-bcad-be4291ea1377','1区1栋','1区1栋','a165026d-4452-40e4-abb1-74b1cf8d2cf8',NULL,300,500,0,300,NULL,1,NULL,NULL,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,'de14b7c2-fc9a-11e5-9433-507b9d2ee731'),('af7df170-e172-45a2-abf5-82eea7679e58','02区002栋2单元0205房','0205房','60cde92b-5879-449f-bcb9-594813ab1ec3','6a5c10a9-5730-4e89-b698-665e8b0440bd',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('c15ba4e4-f34c-440b-b2b6-95011ea81039','1区1栋1单元102','102','a165026d-4452-40e4-abb1-74b1cf8d2cf8','0d349bc0-66db-4446-96d0-b74cdcc583df',NULL,NULL,NULL,NULL,NULL,NULL,'商铺','577f0d21-97da-11e5-ae0b-74d4359b657c','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,'de14b7c2-fc9a-11e5-9433-507b9d2ee731'),('f5333e99-9f20-4f25-ae6c-0380245f2e3b','10区地下车库栋','10区地下车库栋','1c94733c-f5f0-439e-91d5-79cf028f3e92',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731'),('fc4591d6-fbdb-497b-8e31-c675a56d6134','02区002栋1单元0204房','0204房','60cde92b-5879-449f-bcb9-594813ab1ec3','0e91dcc8-d97f-46fa-831b-eb9b5e439eb7',NULL,NULL,NULL,NULL,NULL,NULL,'住宅',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',0,NULL,'be9ce4bd-012c-11e6-a5ea-507b9d2ee731');

/*Table structure for table `tc_casset_repository` */

DROP TABLE IF EXISTS `tc_casset_repository`;

CREATE TABLE `tc_casset_repository` (
  `asset_repository_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '资产库id',
  `property_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `property_number` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `property_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `property_specification` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `property_type_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `expiration_date` double DEFAULT NULL,
  `brand` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `producing_area` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `manufacturer` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `manufacturer_phone` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `property_count` double DEFAULT NULL COMMENT '资产数量',
  `property_area` double DEFAULT NULL COMMENT '面积',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `building_component_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '组件id',
  `functional_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '功能区id',
  `functional_name` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `production_date` datetime DEFAULT NULL,
  `contract_expiration_date` double DEFAULT NULL,
  `start_using_date` datetime DEFAULT NULL,
  `building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `asset_operation_state` tinyint(4) DEFAULT NULL COMMENT '资产运行状态 0停用 1正常 2维修',
  `contract_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同id',
  PRIMARY KEY (`asset_repository_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_casset_repository` */

/*Table structure for table `tc_charge_item` */

DROP TABLE IF EXISTS `tc_charge_item`;

CREATE TABLE `tc_charge_item` (
  `charge_item_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '收费项id',
  `charge_item_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收费类型',
  `charge_item_area` double DEFAULT NULL COMMENT '收费面积',
  `unit_price` double DEFAULT NULL COMMENT '单价',
  `money` double DEFAULT NULL COMMENT '金额',
  `charge_unit` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收费单位（年/月）',
  `pact_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '物业合同id',
  PRIMARY KEY (`charge_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_charge_item` */

/*Table structure for table `tc_charge_item_billing` */

DROP TABLE IF EXISTS `tc_charge_item_billing`;

CREATE TABLE `tc_charge_item_billing` (
  `charge_item_billing_id` varchar(36) NOT NULL COMMENT '收费项目计费id',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `billing_start_time` date DEFAULT NULL COMMENT '计费开始时间',
  `billing_end_time` date DEFAULT NULL COMMENT '计费结束时间',
  `sum` double DEFAULT NULL COMMENT '总金额',
  `billing_type` tinyint(11) DEFAULT NULL COMMENT '计费状态',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  `project_billing_id` varchar(36) DEFAULT NULL COMMENT '项目计费id',
  PRIMARY KEY (`charge_item_billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收费项目计费表';

/*Data for the table `tc_charge_item_billing` */

/*Table structure for table `tc_charge_item_new` */

DROP TABLE IF EXISTS `tc_charge_item_new`;

CREATE TABLE `tc_charge_item_new` (
  `ci_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '收费项目主键id',
  `ci_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '收费项目编号',
  `ci_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收费项目名称',
  `start_date` date DEFAULT NULL COMMENT '收费项目生效时间',
  `end_date` date DEFAULT NULL COMMENT '收费项目失效时间',
  `start_type` tinyint(11) DEFAULT NULL COMMENT '启用状态（0已启用1未启用）',
  `account_type` tinyint(11) DEFAULT NULL COMMENT '账户类型（0资产账户1押金账户）',
  `parent_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '父级id',
  `billing_type` tinyint(11) DEFAULT NULL COMMENT '计费类型(1.自动，2.手动)',
  `billing_date` date DEFAULT NULL COMMENT '计费时间',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `priority` tinyint(11) DEFAULT NULL COMMENT '优先级',
  `is_deposit_deduct` tinyint(11) DEFAULT NULL COMMENT '是否为押金扣款',
  PRIMARY KEY (`ci_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_charge_item_new` */

insert  into `tc_charge_item_new`(`ci_id`,`ci_num`,`ci_name`,`start_date`,`end_date`,`start_type`,`account_type`,`parent_id`,`billing_type`,`billing_date`,`project_id`,`priority`,`is_deposit_deduct`) values ('009bd7d1-03ed-4bda-9f2c-4c7d7a94e215','2','超标水费',NULL,NULL,0,0,'5e27d07a-46a2-4691-b483-472a3d460888',NULL,NULL,NULL,NULL,0),('4030db24-a3fc-4ee2-aa44-16e7c161b3f1','1','标准水费',NULL,NULL,0,0,'5e27d07a-46a2-4691-b483-472a3d460888',NULL,NULL,NULL,NULL,0),('464d4777-e415-4461-8de5-d432b02be1fb','1','11',NULL,NULL,0,0,'7d1c1e9e-6b6d-400e-9bd8-4e24a59abd4f',NULL,NULL,NULL,NULL,0),('5e27d07a-46a2-4691-b483-472a3d460888','1','水费','2016-04-01','2016-04-30',0,0,NULL,2,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',1,0),('7d1c1e9e-6b6d-400e-9bd8-4e24a59abd4f','1','1','2016-04-01','2016-04-23',0,0,NULL,2,NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,0),('9d340cd4-761d-44e6-ad83-e5ab3105827e','1','1',NULL,NULL,0,0,'7d1c1e9e-6b6d-400e-9bd8-4e24a59abd4f',NULL,NULL,NULL,NULL,0);

/*Table structure for table `tc_collection_manage` */

DROP TABLE IF EXISTS `tc_collection_manage`;

CREATE TABLE `tc_collection_manage` (
  `collection_manage_id` varchar(36) NOT NULL COMMENT '托收id',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `cust_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `bank_name` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `bank_account` varchar(36) DEFAULT NULL COMMENT '银行账号',
  `start_time` date DEFAULT NULL COMMENT '启用时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `province` varchar(36) DEFAULT NULL COMMENT '省',
  `city` varchar(36) DEFAULT NULL COMMENT '市',
  `collection_type` tinyint(11) DEFAULT NULL COMMENT '托收类型0银联托收1金融联托收',
  `message` varchar(100) DEFAULT NULL COMMENT '留言',
  `account_type` tinyint(11) DEFAULT NULL COMMENT '账号类型（0银行卡号1存折号）',
  `contract_number` varchar(50) DEFAULT NULL COMMENT '合同号',
  `id` varchar(36) DEFAULT NULL COMMENT '建筑结构id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='托收管理';

/*Data for the table `tc_collection_manage` */

/*Table structure for table `tc_company` */

DROP TABLE IF EXISTS `tc_company`;

CREATE TABLE `tc_company` (
  `company_id` varchar(36) NOT NULL COMMENT '公司ID',
  `company_address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `company_location` varchar(50) DEFAULT NULL COMMENT '公司所在地',
  `zip_code` int(11) DEFAULT NULL COMMENT '邮编',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `company_phone` varchar(20) DEFAULT NULL COMMENT '公司联系电话',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_company` */

/*Table structure for table `tc_component_property` */

DROP TABLE IF EXISTS `tc_component_property`;

CREATE TABLE `tc_component_property` (
  `component_property_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '组件与资产关联id',
  `component_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '组件id',
  `property_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `property_number` double DEFAULT NULL COMMENT '数量',
  `property_area` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '面积',
  `functional_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`component_property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_component_property` */

insert  into `tc_component_property`(`component_property_id`,`component_id`,`property_id`,`property_number`,`property_area`,`functional_id`) values ('3a6a3f3c-fbbc-11e5-9433-507b9d2ee731','cd850965-94fa-4c67-8aef-a16a274fafca','46b24ef5-425d-4df8-ba7d-4a44bb3ad124',1,'wwwdb44c-e6cc-4fe0-9d7c-a990e864a393','83dce486-dee1-440f-8e06-2f78331bafa9'),('7ced5ed1-007d-11e6-a5ea-507b9d2ee731','8e0b3a0f-aa28-4eb7-8946-a39718a51fe0','bbc19e4a-8176-4248-b771-b66b818740d9',10,'wwwdb44c-e6cc-4fe0-9d7c-a990e864a39b','b9e3529c-ebde-4eab-b57b-f02a8a7c4abb'),('bb5e7eda-1299-11e6-a92c-507b9d2ee731','5b11d593-1b3e-484d-bac5-40da688564e8','5edd0c97-b3ca-4a6e-8078-38b9e9b79ba7',1,'wwwdb44c-e6cc-4fe0-9d7c-a990e864a39b','b9e3529c-ebde-4eab-b57b-f02a8a7c4abb');

/*Table structure for table `tc_component_structure` */

DROP TABLE IF EXISTS `tc_component_structure`;

CREATE TABLE `tc_component_structure` (
  `component_structure_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '组件与建筑结构关系主键',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `component_property_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '组件id',
  PRIMARY KEY (`component_structure_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_component_structure` */

/*Table structure for table `tc_condition` */

DROP TABLE IF EXISTS `tc_condition`;

CREATE TABLE `tc_condition` (
  `condition_id` varchar(36) NOT NULL COMMENT '条件id',
  `condition_name` varchar(50) DEFAULT NULL COMMENT '条件名称',
  `formula_id` varchar(36) DEFAULT NULL COMMENT '公式id',
  `condition_expression` varchar(100) DEFAULT NULL COMMENT '条件表达式',
  PRIMARY KEY (`condition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='条件表';

/*Data for the table `tc_condition` */

insert  into `tc_condition`(`condition_id`,`condition_name`,`formula_id`,`condition_expression`) values ('14e302bb-39be-4dc7-92ca-e4822747e11b','[用水量]<=100','2e0701a9-7ae6-47f0-a653-53393269edf0','w <= 100 '),('8c0e7595-d0d8-469e-9591-5f67cd8900bc','[用水量]>=100','fe4bc429-a223-47b5-b0a2-a740b535016c','w >= 100 ');

/*Table structure for table `tc_constant` */

DROP TABLE IF EXISTS `tc_constant`;

CREATE TABLE `tc_constant` (
  `constant_id` varchar(36) NOT NULL COMMENT '常量id',
  `constant_name` varchar(50) DEFAULT NULL COMMENT '常量名称',
  `scheme_id` varchar(36) DEFAULT NULL COMMENT '方案id',
  `value` double DEFAULT NULL COMMENT '常量值',
  `constant_num` varchar(36) DEFAULT NULL COMMENT '常量编号',
  `common_value` varchar(50) DEFAULT NULL COMMENT '通用常量值',
  `parents_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`constant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_constant` */

insert  into `tc_constant`(`constant_id`,`constant_name`,`scheme_id`,`value`,`constant_num`,`common_value`,`parents_id`) values ('1','常量','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,NULL,NULL),('10001','[水费单价]','f9c7f4d4-8f49-4210-8588-835bc485992b',1.7,NULL,'wp','1'),('10002','[电费单价]','f9c7f4d4-8f49-4210-8588-835bc485992b',1.2,NULL,'ep','1'),('10003','[用水量]','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'w','1'),('10004','[用电量]','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'e','1'),('10005','[物业管理费单价]','f9c7f4d4-8f49-4210-8588-835bc485992b',2,NULL,'pmf','1'),('10006','[车位管理费单价]','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'cmf','1'),('2','计算项目','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,NULL,NULL),('20001','[建筑面积]','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'b_area','2'),('3','运算符号','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,NULL,NULL),('30001','+','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'+','3'),('30002','-','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'-','3'),('30003','*','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'*','3'),('30004','/','f9c7f4d4-8f49-4210-8588-835bc485992b',NULL,NULL,'/','3');

/*Table structure for table `tc_deposit_deduct` */

DROP TABLE IF EXISTS `tc_deposit_deduct`;

CREATE TABLE `tc_deposit_deduct` (
  `deposit_deduct_id` varchar(36) NOT NULL COMMENT '押金扣款项id',
  `deductions_date` date DEFAULT NULL COMMENT '扣款日期',
  `deductions_sum` double DEFAULT NULL COMMENT '扣款金额',
  `deductions_name` varchar(36) DEFAULT NULL COMMENT '扣款项名称',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '应收款id',
  PRIMARY KEY (`deposit_deduct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_deposit_deduct` */

/*Table structure for table `tc_electronic_billing` */

DROP TABLE IF EXISTS `tc_electronic_billing`;

CREATE TABLE `tc_electronic_billing` (
  `electronic_billing_id` varchar(36) NOT NULL COMMENT '电子账单id',
  `electronic_billing_num` varchar(36) DEFAULT NULL,
  `overdue` double DEFAULT NULL COMMENT '滯納金',
  `last_overdue` double DEFAULT NULL COMMENT '上期滞纳金',
  `current_overdue` double DEFAULT NULL COMMENT '本期滞纳金',
  `billing_sum` double DEFAULT NULL COMMENT '总金额',
  `bill_date` date DEFAULT NULL COMMENT '账单生成时间',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `collect_sum` double DEFAULT NULL COMMENT '已交金额',
  `no_collect_sum` double DEFAULT NULL COMMENT '未交金额',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  `current_owe_sum` double DEFAULT NULL COMMENT '本期欠款金额',
  `last_owe_sum` double DEFAULT NULL COMMENT '上期欠款金额',
  PRIMARY KEY (`electronic_billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_electronic_billing` */

/*Table structure for table `tc_enterprise_cust` */

DROP TABLE IF EXISTS `tc_enterprise_cust`;

CREATE TABLE `tc_enterprise_cust` (
  `enterprise_id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '企业id',
  `enterprise_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业名称',
  `address` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '注册地址',
  `representative` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '法定代表人',
  `office_phone` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '办公电话',
  `fax_number` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '传真',
  `enterprise_url` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业网址',
  `tax_certificate` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '税务资质',
  `enterprise_property` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '单位属性',
  `trading_date` date DEFAULT NULL COMMENT '营业证书有效期',
  `trading_number` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '营业执照号',
  `tax_number` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '税务登记证号',
  `tax_date` date DEFAULT NULL COMMENT '税务证书有效期',
  `manage_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '经营类型',
  `unit_number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '单位编号',
  `e_mail` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `business_address` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '办公地址',
  `principal` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '单位委托人',
  `emergency_contact` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '单位紧急联系人',
  `emergency_contact_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人电话',
  `organization_code` varchar(80) COLLATE utf8_bin DEFAULT NULL COMMENT '组织机构代码',
  `register_date` date DEFAULT NULL COMMENT '注册时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_enterprise_cust` */

insert  into `tc_enterprise_cust`(`enterprise_id`,`enterprise_name`,`address`,`representative`,`office_phone`,`fax_number`,`enterprise_url`,`tax_certificate`,`enterprise_property`,`trading_date`,`trading_number`,`tax_number`,`tax_date`,`manage_type`,`unit_number`,`e_mail`,`business_address`,`principal`,`emergency_contact`,`emergency_contact_phone`,`organization_code`,`register_date`,`modify_time`,`company_id`) values ('de404d2a-7a79-436e-bb28-de4fc3202fe7','qiye','1','个人客户','15111255541',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'餐饮类','10000','11111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'6af6cb54-df65-4128-84a7-29a76af9c723');

/*Table structure for table `tc_financial_group_detail` */

DROP TABLE IF EXISTS `tc_financial_group_detail`;

CREATE TABLE `tc_financial_group_detail` (
  `financial_group_detail_id` varchar(36) NOT NULL COMMENT '托收明细文件id',
  `bank_type` varchar(255) DEFAULT NULL COMMENT '行别',
  `bank_num` varchar(36) DEFAULT NULL COMMENT '开户行号',
  `collection_manage_id` varchar(36) DEFAULT NULL COMMENT '托收管理id',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '账单id',
  `deductions_tag` tinyint(11) DEFAULT NULL COMMENT '扣款标记',
  `collection_state` tinyint(11) DEFAULT NULL COMMENT '托收状态（0未托收1已托收）',
  `birth_date` date DEFAULT NULL COMMENT '生成日期',
  `collection_type` tinyint(11) DEFAULT NULL COMMENT '托收类型(0托收1回盘)',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `financial_group_total_id` varchar(36) DEFAULT NULL COMMENT '金融联托收总结文件id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='托收明细文件表';

/*Data for the table `tc_financial_group_detail` */

/*Table structure for table `tc_financial_group_total` */

DROP TABLE IF EXISTS `tc_financial_group_total`;

CREATE TABLE `tc_financial_group_total` (
  `financial_group_total_id` varchar(36) NOT NULL COMMENT '托收总结文件id',
  `bank_type` tinyint(11) DEFAULT NULL COMMENT '代办银行（行别）',
  `bank_num` varchar(36) DEFAULT NULL COMMENT '代办单位代码（开户行号）',
  `coin_type` tinyint(11) DEFAULT NULL COMMENT '币种(0人民币1港币)',
  `payment_state` tinyint(11) DEFAULT NULL COMMENT '收付标志(0已收1未收)',
  `collection_total_num` varchar(36) DEFAULT NULL COMMENT '收付代码',
  `collection_total_name` varchar(50) DEFAULT NULL COMMENT '交易文件名称',
  `house_number` int(30) DEFAULT NULL COMMENT '户数',
  `sum` double DEFAULT NULL COMMENT '总金额',
  `deductions_house_number` int(30) DEFAULT NULL COMMENT '已划款户数',
  `deductions_sum` double DEFAULT NULL COMMENT '已划款金额',
  `tobank_date` date DEFAULT NULL COMMENT '送银行日期',
  `prepare_deductions_date` date DEFAULT NULL COMMENT '应划款日期',
  `deductions_date` date DEFAULT NULL COMMENT '划款日期',
  `collection_state` tinyint(11) DEFAULT NULL COMMENT '托收状态（0未托收1已托收）',
  `collection_type` tinyint(11) DEFAULT NULL COMMENT '托收类型（0托收1回盘）',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='托收总结文件表';

/*Data for the table `tc_financial_group_total` */

/*Table structure for table `tc_financial_staff` */

DROP TABLE IF EXISTS `tc_financial_staff`;

CREATE TABLE `tc_financial_staff` (
  `financial_staff_id` varchar(36) NOT NULL COMMENT '财务人员id',
  `financial_staff_name` varchar(36) DEFAULT NULL COMMENT '财务人员名称',
  `parent_id` varchar(36) DEFAULT NULL COMMENT '上级id',
  `staff_id` varchar(36) DEFAULT NULL,
  `post_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`financial_staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务人员表';

/*Data for the table `tc_financial_staff` */

/*Table structure for table `tc_formula` */

DROP TABLE IF EXISTS `tc_formula`;

CREATE TABLE `tc_formula` (
  `formula_id` varchar(36) NOT NULL COMMENT '公式主键',
  `formula_name` varchar(50) DEFAULT NULL COMMENT '公式名称',
  `formula_content` varchar(50) DEFAULT NULL COMMENT '公式内容',
  `formula_expression` varchar(100) DEFAULT NULL COMMENT '公式表达式',
  `condition_use_type` tinyint(11) DEFAULT NULL COMMENT '条件使用类型',
  `formula_num` varchar(36) DEFAULT NULL COMMENT '公式编号',
  PRIMARY KEY (`formula_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_formula` */

insert  into `tc_formula`(`formula_id`,`formula_name`,`formula_content`,`formula_expression`,`condition_use_type`,`formula_num`) values ('2e0701a9-7ae6-47f0-a653-53393269edf0','[水费单价]*[用水量]',NULL,'wp*w',NULL,NULL),('fe4bc429-a223-47b5-b0a2-a740b535016c','[用水量]*[水费单价]',NULL,'w*wp',NULL,NULL);

/*Table structure for table `tc_functional` */

DROP TABLE IF EXISTS `tc_functional`;

CREATE TABLE `tc_functional` (
  `functional_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '功能区id',
  `functional_no` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '功能区编号',
  `functional_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '功能区名称',
  `creater_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `creater_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `update_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `update_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`functional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_functional` */

insert  into `tc_functional`(`functional_id`,`functional_no`,`functional_name`,`creater_name`,`creater_date`,`create_id`,`update_name`,`update_date`,`update_id`) values ('b9e3529c-ebde-4eab-b57b-f02a8a7c4abb','10000','卫生间',NULL,'2016-04-12 14:59:48','1fb37077-bbee-44f9-b235-9af0f0e53e3e',NULL,NULL,NULL);

/*Table structure for table `tc_house` */

DROP TABLE IF EXISTS `tc_house`;

CREATE TABLE `tc_house` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键(uuid)',
  `building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑id',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  `house_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '住宅编号',
  `property` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '属性（关联面积表）',
  `land_price` double DEFAULT NULL COMMENT '地价',
  `last_transcation_price` double DEFAULT NULL COMMENT '最新成交价',
  `house_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋名称',
  `house_postcode` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋邮编',
  `manage_fee` double DEFAULT NULL COMMENT '管理费单价',
  `complete_date` date DEFAULT NULL COMMENT '竣工日期',
  `elevator` tinyint(4) DEFAULT NULL COMMENT '电梯',
  `gate_guard` tinyint(4) DEFAULT NULL COMMENT '门禁',
  `join_date` date DEFAULT NULL COMMENT '入伙日期',
  `join_state` tinyint(4) DEFAULT NULL COMMENT '入伙状态',
  `designer_draw` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '设计图(关联附件)',
  `is_billing` tinyint(4) DEFAULT NULL COMMENT '是否计费',
  `price` double DEFAULT NULL COMMENT '售价',
  `land_certificate` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '土地证（关联附件）',
  `market_state` tinyint(4) DEFAULT NULL COMMENT '销售状态',
  `special_fund` tinyint(4) DEFAULT NULL COMMENT '专项资金',
  `capital_type` tinyint(4) DEFAULT NULL COMMENT '资产类型(住宅1，商铺2，车位3)',
  `password` varchar(50) COLLATE utf8_bin DEFAULT '123456' COMMENT '密码',
  `sip_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'sipId',
  `usable_area` double DEFAULT NULL COMMENT '实用面积',
  `house_area` double DEFAULT NULL COMMENT '房屋面积',
  `house_attribute` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `house_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋类型',
  `share_area` double DEFAULT NULL,
  `premises_permit` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `house_address` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋地址',
  `complete_area` double DEFAULT NULL COMMENT '竣工面积',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `management_unit_price` double DEFAULT NULL COMMENT '管理费单价',
  `join_gang_state` tinyint(4) DEFAULT '0' COMMENT '入伙状态（0未入伙，1已入伙）',
  `building_certificate` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房产证号',
  `equity` tinyint(4) DEFAULT NULL COMMENT '产权',
  `towards` tinyint(4) DEFAULT NULL COMMENT '朝向',
  `floor` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '楼层',
  `indoor_sip_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '室内机sipId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_house` */

insert  into `tc_house`(`id`,`building_id`,`building_structure_id`,`house_num`,`property`,`land_price`,`last_transcation_price`,`house_name`,`house_postcode`,`manage_fee`,`complete_date`,`elevator`,`gate_guard`,`join_date`,`join_state`,`designer_draw`,`is_billing`,`price`,`land_certificate`,`market_state`,`special_fund`,`capital_type`,`password`,`sip_id`,`usable_area`,`house_area`,`house_attribute`,`house_type`,`share_area`,`premises_permit`,`house_address`,`complete_area`,`project_id`,`management_unit_price`,`join_gang_state`,`building_certificate`,`equity`,`towards`,`floor`,`indoor_sip_id`) values ('146461a5-78cb-45e0-b980-e991f4116c73','60cde92b-5879-449f-bcb9-594813ab1ec3','24fd05c6-be8b-4372-badb-a2ea353f55d2','1',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',1,1,'多层','一房一厅',1,NULL,'02区002栋1单元0203房',1,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,0,NULL,NULL,NULL,NULL,NULL),('37ddd3d7-ca8d-45c3-aa67-2b4c05fe1fc9','60cde92b-5879-449f-bcb9-594813ab1ec3','775ac943-8709-438b-a5ad-7049fc92b38b','2',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',2,2,'小高层','单房',2,NULL,'02区002栋1单元0202房',2,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,0,NULL,NULL,NULL,NULL,NULL),('8fc3d34c-fe96-45e1-8c92-cc1edd7c5892','60cde92b-5879-449f-bcb9-594813ab1ec3','15eb7bce-4f87-40c0-9a6c-f9f84e439de8','3',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',3,3,'高层','两房一厅',3,NULL,'02区002栋2单元0208房',3,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,0,NULL,NULL,NULL,NULL,NULL),('a298c587-4d9d-49be-942e-de471f507679','60cde92b-5879-449f-bcb9-594813ab1ec3','2406fdec-5064-4adc-bac9-29aea87c5663','4',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',4,4,'高层','两房两厅',4,NULL,'02区002栋2单元0206房',4,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,1,NULL,NULL,NULL,NULL,NULL),('a6b4f5f2-e56d-4b10-8374-e4fbbc0f08d9','60cde92b-5879-449f-bcb9-594813ab1ec3','20c646ab-1346-4298-9b50-912da0c2ddc3','5',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',5,5,'小高层','一房一厅',5,NULL,'02区002栋2单元0207房',5,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,0,NULL,NULL,NULL,NULL,NULL),('b3cba6fc-45fa-4545-b570-9e1ad01f09fd','60cde92b-5879-449f-bcb9-594813ab1ec3','af7df170-e172-45a2-abf5-82eea7679e58','6',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',6,6,'多层','两房两厅',6,NULL,'02区002栋2单元0205房',6,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,1,NULL,NULL,NULL,NULL,NULL),('c359d1c5-e232-4f3e-8e85-6afd3e54481c','60cde92b-5879-449f-bcb9-594813ab1ec3','16030350-17e5-481b-9d39-7973353d20b9','house001',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',100,500,'多层','一房两厅',100,NULL,'02区002栋1单元0201房',100,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,1,NULL,NULL,NULL,NULL,NULL),('d8c47a6e-d746-4302-b1b3-1d30e47f3c14','60cde92b-5879-449f-bcb9-594813ab1ec3','fc4591d6-fbdb-497b-8e31-c675a56d6134','hosue002',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',100,100,'小高层','两房两厅',100,NULL,'02区002栋1单元0204房',100,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,1,NULL,NULL,NULL,NULL,NULL),('dcc3da8b-129c-11e6-a92c-507b9d2ee731','a165026d-4452-40e4-abb1-74b1cf8d2cf8','6715c00d-7531-48b1-b931-147cec2e579e',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',NULL,NULL,NULL,NULL,NULL,NULL,'1区1栋1单元101',NULL,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',NULL,0,NULL,NULL,NULL,NULL,''),('faa890ad-17f3-11e6-8b95-507b9d2ee731','19c160ac-4fb4-4ade-9abe-efe312d267aa','2d2e387b-d204-428e-a56a-87a2c3484041','house003',NULL,NULL,NULL,NULL,NULL,NULL,'2016-05-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'123456','',100,100,'高层','两房两厅',100,NULL,'123234345',100,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,1,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `tc_house_article` */

DROP TABLE IF EXISTS `tc_house_article`;

CREATE TABLE `tc_house_article` (
  `article_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '物品主键',
  `article_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '物品名称',
  `article_state` tinyint(4) DEFAULT NULL COMMENT '物品领取状态(0未领取1已领取)',
  `quantity` int(36) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_house_article` */

/*Table structure for table `tc_news` */

DROP TABLE IF EXISTS `tc_news`;

CREATE TABLE `tc_news` (
  `news_id` varchar(36) NOT NULL COMMENT '新闻id',
  `news_title` varchar(100) DEFAULT NULL COMMENT '新闻标题',
  `news_text` text COMMENT '新闻正文',
  `news_abstract` varchar(100) DEFAULT NULL COMMENT '新闻摘要',
  `news_type` int(11) DEFAULT NULL COMMENT '新闻分类',
  `news_model` int(11) DEFAULT NULL COMMENT '新闻划分（1.项目内部公告，2.小区消息）',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '发布人id',
  `division_id` varchar(36) DEFAULT NULL COMMENT '部门id',
  `news_date` date DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_news` */

/*Table structure for table `tc_organization_structure` */

DROP TABLE IF EXISTS `tc_organization_structure`;

CREATE TABLE `tc_organization_structure` (
  `o_id` varchar(36) NOT NULL COMMENT '组织结构主键id',
  `o_name` varchar(50) DEFAULT NULL COMMENT '组织结构名称',
  `pid` varchar(36) DEFAULT NULL COMMENT '组织结构父级节点id',
  `leader_name` varchar(20) DEFAULT NULL COMMENT '组织结构节点负责人名称',
  `leader_id` varchar(36) DEFAULT NULL COMMENT '组织结构节点负责人id',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_organization_structure` */

/*Table structure for table `tc_parcel` */

DROP TABLE IF EXISTS `tc_parcel`;

CREATE TABLE `tc_parcel` (
  `parcel_id` varchar(36) NOT NULL DEFAULT '' COMMENT '宗地ID',
  `project_id` varchar(36) DEFAULT NULL COMMENT '管理项目ID',
  `parcel_num` varchar(30) DEFAULT NULL COMMENT '宗地编号',
  `stall_matching` double(30,2) DEFAULT NULL COMMENT '车位配比',
  `parcel_area` double(30,2) DEFAULT NULL COMMENT '宗地面积',
  `civil_air_defence_area` double(30,2) DEFAULT NULL COMMENT '人防面积',
  `floor_area` double(30,2) DEFAULT NULL COMMENT '占地面积',
  `build_area` double(30,2) DEFAULT NULL COMMENT '建筑面积',
  `road_area` double(30,2) DEFAULT NULL COMMENT '道路面积',
  `greening_area` double(30,2) DEFAULT NULL COMMENT '绿化面积',
  `ground_parking_space` int(11) DEFAULT NULL COMMENT '地面车位',
  `underground_parking_space` int(11) DEFAULT NULL COMMENT '地下车位',
  `plot_ratio` double(10,2) DEFAULT NULL COMMENT '容积率',
  `basement_area` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`parcel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_parcel` */

insert  into `tc_parcel`(`parcel_id`,`project_id`,`parcel_num`,`stall_matching`,`parcel_area`,`civil_air_defence_area`,`floor_area`,`build_area`,`road_area`,`greening_area`,`ground_parking_space`,`underground_parking_space`,`plot_ratio`,`basement_area`) values ('be9ce4bd-012c-11e6-a5ea-507b9d2ee731','3c435785-745b-1127-f1ae-2a5e8cc64a3b','B10-001',NULL,500.00,NULL,NULL,NULL,NULL,NULL,0,0,NULL,0.00),('de14b7c2-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','A117-0028',NULL,1.00,NULL,NULL,NULL,NULL,NULL,0,0,NULL,0.00),('de2c26c3-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','A117-0092',NULL,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00),('de2c28d9-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','A117-0093',NULL,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00),('de2c2966-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','A117-0094',NULL,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00),('de2c29e7-fc9a-11e5-9433-507b9d2ee731','89ea04fd-557d-6b95-0fa7-f2ed7b472fe4','A117-0095',NULL,1.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00);

/*Table structure for table `tc_payment_details` */

DROP TABLE IF EXISTS `tc_payment_details`;

CREATE TABLE `tc_payment_details` (
  `payment_details_id` varchar(36) NOT NULL COMMENT '收支明细id',
  `transaction_amount` double DEFAULT NULL COMMENT '交易金额',
  `transaction_date` datetime DEFAULT NULL COMMENT '交易时间',
  `note` varchar(100) DEFAULT NULL COMMENT '说明',
  `financial_staff_id` varchar(36) DEFAULT NULL COMMENT '操作人 员工id',
  `financial_staff_name` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `person_id` varchar(36) DEFAULT NULL COMMENT '交账人 员工id',
  `person_name` varchar(50) DEFAULT NULL COMMENT '交账人',
  `refund_state` tinyint(11) DEFAULT NULL COMMENT '款状态',
  `cash_sum` double DEFAULT NULL COMMENT '现金金额',
  `credit_card_sum` double DEFAULT NULL COMMENT '刷卡金额',
  `wechat_sum` double DEFAULT NULL COMMENT '微信金额',
  `payment_num` varchar(36) DEFAULT NULL COMMENT '交易单号',
  `batch_num` varchar(36) DEFAULT NULL COMMENT '批次',
  `account_record_id` varchar(36) DEFAULT NULL,
  `asset_account_id` varchar(36) DEFAULT NULL COMMENT '资产账户id',
  `ci_name` varchar(36) DEFAULT NULL COMMENT '收费项目名',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '客户id',
  `is_out_in` varchar(36) DEFAULT NULL COMMENT '收支类别(0收入1支出)',
  PRIMARY KEY (`payment_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_payment_details` */

insert  into `tc_payment_details`(`payment_details_id`,`transaction_amount`,`transaction_date`,`note`,`financial_staff_id`,`financial_staff_name`,`person_id`,`person_name`,`refund_state`,`cash_sum`,`credit_card_sum`,`wechat_sum`,`payment_num`,`batch_num`,`account_record_id`,`asset_account_id`,`ci_name`,`cust_id`,`is_out_in`) values ('fef74203-705c-4e5e-9eb1-c1c7f3a77adf',NULL,'2016-04-28 11:21:02',NULL,'cbcc541d-fd65-11e5-9433-507b9d2ee731','张静初',NULL,NULL,1,1,NULL,NULL,'1461813662670','1461813751661','769ab3c3-957e-4012-89e5-00bd9e33404d',NULL,NULL,NULL,NULL);

/*Table structure for table `tc_payment_records` */

DROP TABLE IF EXISTS `tc_payment_records`;

CREATE TABLE `tc_payment_records` (
  `payment_records_id` varchar(36) NOT NULL COMMENT '收款记录id',
  `payment_date` date DEFAULT NULL COMMENT '收款日期',
  `cash_sum` double DEFAULT NULL COMMENT '现金金额',
  `credit_card_sum` double DEFAULT NULL COMMENT '刷卡金额',
  `wechat_sum` double DEFAULT NULL COMMENT '微信金额',
  `total_sum` double DEFAULT NULL COMMENT '总金额',
  `financial_staff_id` varchar(36) DEFAULT NULL COMMENT '财务人员id',
  `refund_sum` double DEFAULT NULL COMMENT '退款金额',
  `no_handed_sum` double DEFAULT NULL COMMENT '未上交金额',
  `handed_sum` double DEFAULT NULL COMMENT '已上交金额',
  PRIMARY KEY (`payment_records_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_payment_records` */

insert  into `tc_payment_records`(`payment_records_id`,`payment_date`,`cash_sum`,`credit_card_sum`,`wechat_sum`,`total_sum`,`financial_staff_id`,`refund_sum`,`no_handed_sum`,`handed_sum`) values ('6cf0fb58-7e01-4b18-b2aa-dc716c7e44b0',NULL,1,0,0,0,'',0,0,0),('81498295-ef0a-4660-9c5f-0b4e6e345f39',NULL,1,0,0,0,'',0,0,0),('8cf48cdc-124d-4ca7-8afa-38de0c465db8',NULL,0,0,0,0,'',0,0,0),('942a9568-6b3f-42e3-8d0d-cd6c892f4d3a',NULL,0,0,0,0,'',0,0,0);

/*Table structure for table `tc_pending_approval` */

DROP TABLE IF EXISTS `tc_pending_approval`;

CREATE TABLE `tc_pending_approval` (
  `pending_approval_id` varchar(36) NOT NULL COMMENT '审批待办id',
  `types` tinyint(4) DEFAULT NULL COMMENT '审批类型（0vip申请1vip失效申请2重点申请3重点失效申请）',
  `theme` varchar(100) DEFAULT NULL COMMENT '主题',
  `current_dates` date DEFAULT NULL COMMENT '当前时间',
  PRIMARY KEY (`pending_approval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_pending_approval` */

insert  into `tc_pending_approval`(`pending_approval_id`,`types`,`theme`,`current_dates`) values ('70c1a485-ab23-4ed8-8ce9-d7d2f62af619',2,'重点客户申请','2016-04-27'),('b97deaf9-4aaf-445d-b74a-c0a350d4329a',0,'vip客户申请','2016-04-27');

/*Table structure for table `tc_person_building` */

DROP TABLE IF EXISTS `tc_person_building`;

CREATE TABLE `tc_person_building` (
  `person_building_id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '客户房屋关系id',
  `cust_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人客户id',
  `enterprise_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业id',
  `building_structure_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑结构id',
  `state` tinyint(4) DEFAULT '0' COMMENT '关联状态(0开启，1禁用)',
  `cust_type` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户类型',
  `enterprise_call_type` tinyint(4) DEFAULT NULL COMMENT '企业呼叫人状态',
  `accessory` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '附件',
  `relation_date` date DEFAULT NULL COMMENT '关联时间',
  PRIMARY KEY (`person_building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_person_building` */

insert  into `tc_person_building`(`person_building_id`,`cust_id`,`enterprise_id`,`building_structure_id`,`state`,`cust_type`,`enterprise_call_type`,`accessory`,`relation_date`) values ('2a23f620-0c20-11e6-b057-507b9d2ee731','f343dbda-f7f0-451f-815b-bbe4a7cf655d',NULL,'16030350-17e5-481b-9d39-7973353d20b9',0,'租客',NULL,NULL,'2016-04-27'),('37203e1e-0b81-11e6-8899-507b9d2ee731','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'16030350-17e5-481b-9d39-7973353d20b9',0,'业主',NULL,NULL,'2016-04-26'),('480ae7cc-0c20-11e6-b057-507b9d2ee731','fe8956e5-33c7-458b-9ff9-c9d24bae600d',NULL,'775ac943-8709-438b-a5ad-7049fc92b38b',0,'亲属',NULL,NULL,'2016-04-27'),('61a2e03d-0c20-11e6-b057-507b9d2ee731','f343dbda-f7f0-451f-815b-bbe4a7cf655d',NULL,'775ac943-8709-438b-a5ad-7049fc92b38b',0,'亲属',NULL,NULL,'2016-04-27'),('c95f212b-0b7f-11e6-8899-507b9d2ee731','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'0da2d314-cb9d-42de-aa64-d492af535475',0,'业主',NULL,NULL,'2016-04-26'),('de406791-761f-455d-bd85-585def9f7da4','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'16030350-17e5-481b-9d39-7973353d20b9',1,'业主',NULL,NULL,'2016-04-19'),('e4bcf358-2921-4c07-91c3-d15ca3564955','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'775ac943-8709-438b-a5ad-7049fc92b38b',0,'业主',NULL,NULL,'2016-04-19');

/*Table structure for table `tc_person_cust` */

DROP TABLE IF EXISTS `tc_person_cust`;

CREATE TABLE `tc_person_cust` (
  `cust_id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '客户id',
  `cust_code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '客户编号',
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `sex` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '性别',
  `native_place` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `census` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '户口所在地',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `card_type` tinyint(4) DEFAULT NULL COMMENT '证件类型',
  `card_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `jiajia_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '家家客户端id',
  `weixin_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '微信帐号',
  `work_units` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '工作单位',
  `position` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '职务',
  `marrie_state` tinyint(4) DEFAULT NULL COMMENT '婚否',
  `edu_level` tinyint(4) DEFAULT NULL COMMENT '学历',
  `social` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '社会关系(需要询问)',
  `landscape` tinyint(4) DEFAULT NULL COMMENT '政治面貌',
  `hobby` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '兴趣爱好',
  `cust_level` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '客户等级',
  `is_enterprise` tinyint(4) DEFAULT NULL COMMENT '是否有企业联系',
  `urgent_contact_person` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人',
  `urgent_contact_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系电话',
  `upload_image` varchar(10000) COLLATE utf8_bin DEFAULT NULL COMMENT '上传图片',
  `phone_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `register_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '注册电话',
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮件',
  `phone_num1` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话1',
  `phone_num2` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话2',
  `nation` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '民族',
  `company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_person_cust` */

insert  into `tc_person_cust`(`cust_id`,`cust_code`,`name`,`sex`,`native_place`,`census`,`birthday`,`card_type`,`card_num`,`jiajia_num`,`weixin_num`,`work_units`,`position`,`marrie_state`,`edu_level`,`social`,`landscape`,`hobby`,`cust_level`,`is_enterprise`,`urgent_contact_person`,`urgent_contact_phone`,`upload_image`,`phone_num`,`register_phone`,`email`,`phone_num1`,`phone_num2`,`nation`,`company_id`) values ('f22cd363-2809-4af4-9199-872c68ffc9be','10000','朱琪','0',NULL,NULL,'2016-04-01',0,'422002199410123456S',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'18978521236',NULL,NULL,NULL,'苗族',NULL),('f343dbda-f7f0-451f-815b-bbe4a7cf655d','10002','陈浪','0',NULL,NULL,NULL,0,'421003199301024321S',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'15112455632',NULL,NULL,NULL,'汉族',NULL),('fe8956e5-33c7-458b-9ff9-c9d24bae600d','10001','卫龙','0',NULL,NULL,'2016-04-01',0,'421003199301021234S',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'15112452541',NULL,NULL,NULL,'汉族',NULL);

/*Table structure for table `tc_person_emphasis` */

DROP TABLE IF EXISTS `tc_person_emphasis`;

CREATE TABLE `tc_person_emphasis` (
  `emphasis_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '重点客户id',
  `username` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名username',
  `applyreason` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '申请理由 applyreason',
  `applyfilepath` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT '上传申请的资料路径applyfilepath',
  `applydate` date DEFAULT NULL COMMENT '申请日期applydate',
  `applystatus` tinyint(4) DEFAULT NULL COMMENT '审核状态applystatus--0:待审核；1：审核通过；2：审核不通过',
  `idcard` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码idcard',
  `failreason` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '未通过原因failreason',
  `phonenum` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话phonenum',
  `enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '企业客户id',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '个人客户id',
  `applyeddate` date DEFAULT NULL COMMENT '审核日期applyeddate',
  `approval_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审批代办id',
  `theme` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '主题',
  `applystype` tinyint(4) DEFAULT NULL COMMENT '申请类型(0申请1失效)',
  PRIMARY KEY (`emphasis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_person_emphasis` */

insert  into `tc_person_emphasis`(`emphasis_id`,`username`,`applyreason`,`applyfilepath`,`applydate`,`applystatus`,`idcard`,`failreason`,`phonenum`,`enterprise_id`,`cust_id`,`applyeddate`,`approval_id`,`theme`,`applystype`) values ('265238ed-5d60-42c8-ae24-88754983b478','朱琪','申请一个',NULL,'2016-04-27',0,'422002199410123456S',NULL,'18978521236',NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'70c1a485-ab23-4ed8-8ce9-d7d2f62af619','重点客户申请',2);

/*Table structure for table `tc_person_vip` */

DROP TABLE IF EXISTS `tc_person_vip`;

CREATE TABLE `tc_person_vip` (
  `vip_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键',
  `cust_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '个人客户id',
  `enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '企业客户id',
  `vip_grade` tinyint(4) DEFAULT NULL COMMENT 'vip客户等级',
  `vip_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT 'vip编号',
  `vip_start` date DEFAULT NULL COMMENT 'vip开始时间',
  `vip_end` date DEFAULT NULL COMMENT 'vip结束时间',
  `apply_reason` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '申请理由',
  `refuse_reason` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '拒绝理由',
  `review_state` tinyint(4) DEFAULT NULL COMMENT '审核状态',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'VIP专员id',
  `applyfile_path` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT '上传申请的资料路径',
  `approval_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审批代办id',
  `theme` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '主题',
  `applystype` tinyint(4) DEFAULT NULL COMMENT '申请类型（0申请1失效）',
  `name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '申请人姓名',
  PRIMARY KEY (`vip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_person_vip` */

insert  into `tc_person_vip`(`vip_id`,`cust_id`,`enterprise_id`,`vip_grade`,`vip_num`,`vip_start`,`vip_end`,`apply_reason`,`refuse_reason`,`review_state`,`staff_id`,`applyfile_path`,`approval_id`,`theme`,`applystype`,`name`) values ('8b2a24b6-987e-4d0b-aa88-0f1ec2e17856','f343dbda-f7f0-451f-815b-bbe4a7cf655d',NULL,NULL,NULL,'2016-04-27',NULL,'111',NULL,0,'cbcc541d-fd65-11e5-9433-507b9d2ee731','/upload\\20160427\\20160427191635_993.jpg','b97deaf9-4aaf-445d-b74a-c0a350d4329a','vip客户申请',0,'陈浪');

/*Table structure for table `tc_person_vip_project` */

DROP TABLE IF EXISTS `tc_person_vip_project`;

CREATE TABLE `tc_person_vip_project` (
  `tc_person_vip_project_id` varchar(36) NOT NULL COMMENT 'vip项目关系id',
  `vip_id` varchar(36) DEFAULT NULL COMMENT 'vip主键id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`tc_person_vip_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_person_vip_project` */

/*Table structure for table `tc_plan_link_building_structure` */

DROP TABLE IF EXISTS `tc_plan_link_building_structure`;

CREATE TABLE `tc_plan_link_building_structure` (
  `plan_link_building_structure_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '抄表计划与建筑结构关联表ID',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构ID',
  `meter_reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划ID',
  PRIMARY KEY (`plan_link_building_structure_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_plan_link_building_structure` */

/*Table structure for table `tc_pooled` */

DROP TABLE IF EXISTS `tc_pooled`;

CREATE TABLE `tc_pooled` (
  `pooled_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '公摊id',
  `pooled_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '公摊名称',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `usable_area` double DEFAULT NULL COMMENT '实用面积',
  `building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑id',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_pooled` */

/*Table structure for table `tc_post_authority` */

DROP TABLE IF EXISTS `tc_post_authority`;

CREATE TABLE `tc_post_authority` (
  `post_authority_id` varchar(36) NOT NULL COMMENT '岗位权限id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '功能权限id',
  `action_id` varchar(36) DEFAULT NULL COMMENT '操作权限id',
  `post_id` varchar(36) DEFAULT NULL COMMENT '岗位id',
  `creater_id` varchar(36) DEFAULT NULL COMMENT '创建人ID',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `modify_id` varchar(36) DEFAULT NULL COMMENT '最后修改人ID',
  `modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标识',
  PRIMARY KEY (`post_authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_post_authority` */

/*Table structure for table `tc_product` */

DROP TABLE IF EXISTS `tc_product`;

CREATE TABLE `tc_product` (
  `product_id` varchar(36) NOT NULL COMMENT '产品id',
  `product_name` varchar(36) DEFAULT NULL COMMENT '产品名称',
  `product_num` varchar(36) DEFAULT NULL COMMENT '产品编号',
  `effect_date` date DEFAULT NULL COMMENT '生效日期',
  `product_attributes` varchar(36) DEFAULT NULL COMMENT '产品属性',
  `price` double DEFAULT NULL COMMENT '价格',
  `average_price` double DEFAULT NULL COMMENT '均价',
  `product_type` tinyint(4) DEFAULT NULL COMMENT '产品类型',
  `deposit_way` varchar(36) DEFAULT NULL COMMENT '押金方式',
  `pay_way` varchar(36) DEFAULT NULL COMMENT '支付方式',
  `prepaid_date` date DEFAULT NULL COMMENT '预付日期',
  `increasing_rent` tinyint(11) DEFAULT NULL COMMENT '租金递增',
  `rent_proportion` varchar(36) DEFAULT NULL COMMENT '递增比例',
  `rent_type` varchar(36) DEFAULT NULL COMMENT '递增类型',
  `lntroduction` varchar(100) DEFAULT NULL COMMENT '简介',
  `stall_id` varchar(36) DEFAULT NULL COMMENT '车位id',
  `state` varchar(10) DEFAULT NULL COMMENT '是否失效 0/有效，1/失效',
  `is_rent_free` int(4) DEFAULT NULL COMMENT '是否有免租期 0/有，1/没有',
  `free_time` int(10) DEFAULT NULL COMMENT '免租期时长',
  `modify_time` datetime DEFAULT NULL COMMENT '改动时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

/*Data for the table `tc_product` */

insert  into `tc_product`(`product_id`,`product_name`,`product_num`,`effect_date`,`product_attributes`,`price`,`average_price`,`product_type`,`deposit_way`,`pay_way`,`prepaid_date`,`increasing_rent`,`rent_proportion`,`rent_type`,`lntroduction`,`stall_id`,`state`,`is_rent_free`,`free_time`,`modify_time`) values ('4a604c0c-7b53-4500-b44b-1178787ace94','广告1',NULL,NULL,'10',1,1,5,'0','0',NULL,1,NULL,NULL,NULL,NULL,'0',1,NULL,'2016-04-26 14:06:16'),('94d41eac-9676-48e3-82a0-493afd0ee85a','装修套餐1','zxtc1','2016-04-01',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2016-04-20 18:03:51'),('b7e990fb-35c0-4207-b80f-f490a6ec76d5','1','1','2016-04-01',NULL,1.1,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2016-04-26 14:07:45'),('d3c4d849-4277-40d4-b059-32684c09d806','建筑租赁1',NULL,NULL,'1',700,46.6667,0,'1','0',NULL,1,NULL,NULL,NULL,NULL,'0',1,NULL,'2016-04-20 15:13:54'),('d55aed3b-8210-4c10-abcd-4ccac7e06434','3','3','2016-04-01',NULL,3,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2016-04-26 14:08:18'),('d55b76f9-590d-4aed-96fe-7f0142b4d3ec','2','2','2016-04-01',NULL,2,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2016-04-26 14:08:03'),('ddce50ef-402c-4ef0-8ad0-9f15cbe0f308','4','4','2016-04-02',NULL,2,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,'2016-04-26 14:08:32'),('e107efa3-2dd7-4787-a18e-4368edbe126b','建筑租赁12',NULL,NULL,'0',1,1,0,'2','0',NULL,1,NULL,NULL,NULL,NULL,'1',1,NULL,'2016-04-22 16:47:32');

/*Table structure for table `tc_product_bs` */

DROP TABLE IF EXISTS `tc_product_bs`;

CREATE TABLE `tc_product_bs` (
  `product_bs_id` varchar(36) NOT NULL COMMENT '主键id',
  `product_id` varchar(36) DEFAULT NULL COMMENT '产品id',
  `building_structure_id` varchar(36) DEFAULT NULL COMMENT '建筑结构主键id',
  `state` int(4) DEFAULT NULL COMMENT '状态(0启用，1弃用)',
  PRIMARY KEY (`product_bs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_product_bs` */

insert  into `tc_product_bs`(`product_bs_id`,`product_id`,`building_structure_id`,`state`) values ('e31a6f7b-28d5-45a5-b6f5-3b5a500f19bd','d55aed3b-8210-4c10-abcd-4ccac7e06434','0da2d314-cb9d-42de-aa64-d492af535475',0);

/*Table structure for table `tc_project_billing` */

DROP TABLE IF EXISTS `tc_project_billing`;

CREATE TABLE `tc_project_billing` (
  `project_billing_id` varchar(36) NOT NULL COMMENT '项目计费id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `billing_start_time` date DEFAULT NULL COMMENT '计费开始时间',
  `billing_end_time` date DEFAULT NULL COMMENT '计费结束时间',
  `sum` double DEFAULT NULL COMMENT '总金额',
  `is_posting` varchar(11) DEFAULT NULL COMMENT '0.已过账 1.未过帐 2.已计费',
  `month` varchar(30) DEFAULT NULL COMMENT '月份',
  `current_sum` double DEFAULT NULL COMMENT '本期金额',
  `last_sum` double DEFAULT NULL COMMENT '上期金额',
  PRIMARY KEY (`project_billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_project_billing` */

/*Table structure for table `tc_region` */

DROP TABLE IF EXISTS `tc_region`;

CREATE TABLE `tc_region` (
  `id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '区域主键',
  `project_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '项目id',
  `region_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '区域名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_region` */

/*Table structure for table `tc_role` */

DROP TABLE IF EXISTS `tc_role`;

CREATE TABLE `tc_role` (
  `id` varchar(36) NOT NULL COMMENT '功能id',
  `nam` varchar(50) DEFAULT NULL COMMENT '功能名称',
  `url` varchar(36) DEFAULT NULL COMMENT '功能地址',
  `description` varchar(50) DEFAULT NULL COMMENT '功能描述',
  `type` tinyint(4) DEFAULT NULL COMMENT '功能类型',
  `state` tinyint(4) DEFAULT NULL COMMENT '功能状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能权限表';

/*Data for the table `tc_role` */

/*Table structure for table `tc_role_post` */

DROP TABLE IF EXISTS `tc_role_post`;

CREATE TABLE `tc_role_post` (
  `id` varchar(36) NOT NULL COMMENT '岗位权限id',
  `role_id` varchar(36) DEFAULT NULL COMMENT '功能权限id',
  `action_id` varchar(36) DEFAULT NULL COMMENT '操作权限id',
  `post_id` varchar(36) DEFAULT NULL COMMENT '岗位id',
  `creater_id` varchar(36) DEFAULT NULL COMMENT '创建人ID',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `modify_id` varchar(36) DEFAULT NULL COMMENT '最后修改人ID',
  `modify_time` date DEFAULT NULL COMMENT '最后修改时间',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='岗位权限表';

/*Data for the table `tc_role_post` */

/*Table structure for table `tc_scheme` */

DROP TABLE IF EXISTS `tc_scheme`;

CREATE TABLE `tc_scheme` (
  `scheme_id` varchar(36) NOT NULL COMMENT '方案主键',
  `scheme_name` varchar(50) DEFAULT NULL COMMENT '方案名称',
  `start_date` date DEFAULT NULL COMMENT '生效日期',
  `end_date` date DEFAULT NULL COMMENT '失效日期',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `scheme_num` varchar(36) DEFAULT NULL COMMENT '方案编号',
  PRIMARY KEY (`scheme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_scheme` */

insert  into `tc_scheme`(`scheme_id`,`scheme_name`,`start_date`,`end_date`,`project_id`,`project_name`,`scheme_num`) values ('c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a','测试','2016-04-01','2016-04-30','3c435785-745b-1127-f1ae-2a5e8cc64a3b','财务项目',NULL);

/*Table structure for table `tc_scheme_datails` */

DROP TABLE IF EXISTS `tc_scheme_datails`;

CREATE TABLE `tc_scheme_datails` (
  `scheme_datails_id` varchar(36) NOT NULL COMMENT '方案详细主键',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id',
  `charge_item_name` varchar(50) DEFAULT NULL COMMENT '收费项目名称',
  `formula_id` varchar(36) DEFAULT NULL COMMENT '计算公式id',
  `formula_name` varchar(50) DEFAULT NULL COMMENT '计算公式名称',
  `scheme_id` varchar(36) DEFAULT NULL COMMENT '方案id',
  `charging_frequency` varchar(20) DEFAULT NULL COMMENT '收费频率',
  `building_id` varchar(36) DEFAULT NULL COMMENT '建筑结构id',
  `full_name` varchar(36) DEFAULT NULL COMMENT '房屋全名',
  PRIMARY KEY (`scheme_datails_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_scheme_datails` */

insert  into `tc_scheme_datails`(`scheme_datails_id`,`charge_item_id`,`charge_item_name`,`formula_id`,`formula_name`,`scheme_id`,`charging_frequency`,`building_id`,`full_name`) values ('1d203d1c-149b-4392-9c0e-a75b055a5662','009bd7d1-03ed-4bda-9f2c-4c7d7a94e215','超标水费','2e0701a9-7ae6-47f0-a653-53393269edf0','[水费单价]*[用水量]','c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a',NULL,'16030350-17e5-481b-9d39-7973353d20b9',NULL),('35d6bf01-ac08-44b0-a27d-d6b1e7cb2432','4030db24-a3fc-4ee2-aa44-16e7c161b3f1','标准水费','fe4bc429-a223-47b5-b0a2-a740b535016c','[用水量]*[水费单价]','c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a',NULL,'24fd05c6-be8b-4372-badb-a2ea353f55d2',NULL),('8b2ed564-9d7e-47d7-ab24-fba0b76711d8','4030db24-a3fc-4ee2-aa44-16e7c161b3f1','标准水费','fe4bc429-a223-47b5-b0a2-a740b535016c','[用水量]*[水费单价]','c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a',NULL,'16030350-17e5-481b-9d39-7973353d20b9',NULL),('da6f5a74-74f6-4494-82fb-e71f28eacd7d','009bd7d1-03ed-4bda-9f2c-4c7d7a94e215','超标水费','2e0701a9-7ae6-47f0-a653-53393269edf0','[水费单价]*[用水量]','c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a',NULL,'24fd05c6-be8b-4372-badb-a2ea353f55d2',NULL);

/*Table structure for table `tc_scheme_ic_relation` */

DROP TABLE IF EXISTS `tc_scheme_ic_relation`;

CREATE TABLE `tc_scheme_ic_relation` (
  `scheme_ic_relation_id` varchar(36) NOT NULL COMMENT '主键id',
  `scheme_id` varchar(36) DEFAULT NULL COMMENT '方案id',
  `charge_item_id` varchar(36) DEFAULT NULL COMMENT '收费项目id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='方案收费项目关系表';

/*Data for the table `tc_scheme_ic_relation` */

insert  into `tc_scheme_ic_relation`(`scheme_ic_relation_id`,`scheme_id`,`charge_item_id`) values ('30a268a7-7f9a-45a7-9028-3d65e0f04ab3','c0d081b4-52f6-0cff-cfa7-da0ffaf3bd7a','5e27d07a-46a2-4691-b483-472a3d460888'),('824d5d21-3686-4ffb-93e3-5733fb1d02c3','dab5a9bc-8066-739a-c4b6-0a25eec656c9','7d1c1e9e-6b6d-400e-9bd8-4e24a59abd4f');

/*Table structure for table `tc_service_project` */

DROP TABLE IF EXISTS `tc_service_project`;

CREATE TABLE `tc_service_project` (
  `service_project_id` varchar(36) NOT NULL COMMENT '服务项目id',
  `unit_price` double DEFAULT NULL COMMENT '单价',
  `unit` varchar(36) DEFAULT NULL COMMENT '单位',
  `onsite_verification` tinyint(11) DEFAULT NULL COMMENT '现场核实',
  `service_project_name` varchar(36) DEFAULT NULL COMMENT '服务项目名称',
  `product_id` varchar(36) DEFAULT NULL COMMENT '产品id',
  PRIMARY KEY (`service_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务项目表';

/*Data for the table `tc_service_project` */

insert  into `tc_service_project`(`service_project_id`,`unit_price`,`unit`,`onsite_verification`,`service_project_name`,`product_id`) values ('19c66029-7f99-49ff-82b0-8f43adf1e4dd',2,'2个',0,'2','94d41eac-9676-48e3-82a0-493afd0ee85a'),('958b5eb1-3635-46c2-b326-dd8d075a4508',500,'米',0,'铺线','0af7480d-a478-4a4b-8e3b-ccf0a301c92c'),('a372c44b-3c59-4740-912c-7a83a9ccdf5d',1,'1',1,'1','94d41eac-9676-48e3-82a0-493afd0ee85a');

/*Table structure for table `tc_sipmanage` */

DROP TABLE IF EXISTS `tc_sipmanage`;

CREATE TABLE `tc_sipmanage` (
  `sip_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '主键id',
  `sip_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT 'sip账户名称',
  `sip_pwd` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '账户密码',
  `login_state` tinyint(4) DEFAULT '0' COMMENT '登录状态（0未登录1已登录2登录失败）',
  `state` tinyint(4) DEFAULT '0' COMMENT '使用状态（0有效，1失效）',
  PRIMARY KEY (`sip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_sipmanage` */

insert  into `tc_sipmanage`(`sip_id`,`sip_name`,`sip_pwd`,`login_state`,`state`) values ('6ba1f38a-f73d-11e5-8662-0050568e0e15','00503','1415926',1,1),('6bac7d3e-f73d-11e5-8662-0050568e0e15','00504','1415926',1,1),('6bbc6754-f73d-11e5-8662-0050568e0e15','00505','1415926',1,1),('6bca8447-f73d-11e5-8662-0050568e0e15','00506','1415926',1,1),('6bdb0dd6-f73d-11e5-8662-0050568e0e15','00507','1415926',1,1),('6be9a4b1-f73d-11e5-8662-0050568e0e15','00508','1415926',1,1),('6bf8082d-f73d-11e5-8662-0050568e0e15','00509','1415926',1,1),('6c0244b7-f73d-11e5-8662-0050568e0e15','00510','1415926',1,1),('6c0e9aa3-f73d-11e5-8662-0050568e0e15','00511','1415926',1,1),('6c182922-f73d-11e5-8662-0050568e0e15','00512','1415926',1,1),('6c213541-f73d-11e5-8662-0050568e0e15','00513','1415926',1,1),('6c2c6c46-f73d-11e5-8662-0050568e0e15','00514','1415926',1,1),('6c38cf15-f73d-11e5-8662-0050568e0e15','00515','1415926',1,1),('6c44ecba-f73d-11e5-8662-0050568e0e15','00516','1415926',1,1),('6c50e67b-f73d-11e5-8662-0050568e0e15','00517','1415926',1,1),('6c5c4436-f73d-11e5-8662-0050568e0e15','00518','1415926',1,1),('6c6479a6-f73d-11e5-8662-0050568e0e15','00519','1415926',1,1),('6c6e7018-f73d-11e5-8662-0050568e0e15','00520','1415926',1,1),('6c798291-f73d-11e5-8662-0050568e0e15','00521','1415926',1,1),('6c85c76b-f73d-11e5-8662-0050568e0e15','00522','1415926',1,1),('6c964875-f73d-11e5-8662-0050568e0e15','00524','1415926',1,1),('6caa64fc-f73d-11e5-8662-0050568e0e15','00525','1415926',1,1),('6cb28fc0-f73d-11e5-8662-0050568e0e15','00526','1415926',1,1),('6cbb4451-f73d-11e5-8662-0050568e0e15','00527','1415926',1,1),('6cc43386-f73d-11e5-8662-0050568e0e15','00528','1415926',1,1),('6cd0d13d-f73d-11e5-8662-0050568e0e15','00529','1415926',1,1),('6cd95f86-f73d-11e5-8662-0050568e0e15','00530','1415926',1,1),('6ce19b0e-f73d-11e5-8662-0050568e0e15','00531','1415926',1,1),('6cec9e9d-f73d-11e5-8662-0050568e0e15','00532','1415926',1,1),('6cf9f939-f73d-11e5-8662-0050568e0e15','00533','1415926',1,1),('6d04572f-f73d-11e5-8662-0050568e0e15','00534','1415926',1,1),('6d127a7d-f73d-11e5-8662-0050568e0e15','00535','1415926',1,1),('6d1cd244-f73d-11e5-8662-0050568e0e15','00536','1415926',1,1),('6d2725b8-f73d-11e5-8662-0050568e0e15','00537','1415926',1,1),('6d302cdd-f73d-11e5-8662-0050568e0e15','00538','1415926',1,1),('6d3e6d21-f73d-11e5-8662-0050568e0e15','00539','1415926',1,1),('6d49656f-f73d-11e5-8662-0050568e0e15','00540','1415926',1,1),('6d567366-f73d-11e5-8662-0050568e0e15','00541','1415926',1,1),('6d65f21b-f73d-11e5-8662-0050568e0e15','00542','1415926',1,1),('6d73afa9-f73d-11e5-8662-0050568e0e15','00543','1415926',1,1),('6d7c0bda-f73d-11e5-8662-0050568e0e15','00544','1415926',1,1),('6d8034b3-f73d-11e5-8662-0050568e0e15','00545','1415926',1,1),('6d87bfd7-f73d-11e5-8662-0050568e0e15','00546','1415926',1,1),('6d8c05de-f73d-11e5-8662-0050568e0e15','00547','1415926',1,1),('6d8eec52-f73d-11e5-8662-0050568e0e15','00548','1415926',1,1),('6d9478d0-f73d-11e5-8662-0050568e0e15','00549','1415926',1,1),('6d99a595-f73d-11e5-8662-0050568e0e15','00550','1415926',1,1),('6d9e13c9-f73d-11e5-8662-0050568e0e15','00551','1415926',1,1),('6da4205e-f73d-11e5-8662-0050568e0e15','00552','1415926',1,1),('6daf3110-f73d-11e5-8662-0050568e0e15','00553','1415926',1,1),('6dbe390b-f73d-11e5-8662-0050568e0e15','00554','1415926',1,1),('6dc812c5-f73d-11e5-8662-0050568e0e15','00555','1415926',1,1),('6dd2ec27-f73d-11e5-8662-0050568e0e15','00556','1415926',1,1),('6de3fd0b-f73d-11e5-8662-0050568e0e15','00557','1415926',1,1),('6deb5bf0-f73d-11e5-8662-0050568e0e15','00558','1415926',1,1),('6df28848-f73d-11e5-8662-0050568e0e15','00559','1415926',1,1),('6df79358-f73d-11e5-8662-0050568e0e15','00560','1415926',1,1),('6dfe4613-f73d-11e5-8662-0050568e0e15','00561','1415926',1,1),('6e056aee-f73d-11e5-8662-0050568e0e15','00562','1415926',1,1),('6e09c053-f73d-11e5-8662-0050568e0e15','00563','1415926',1,1),('6e0da3a3-f73d-11e5-8662-0050568e0e15','00564','1415926',1,1),('6e1589cf-f73d-11e5-8662-0050568e0e15','00565','1415926',1,1),('6e19881a-f73d-11e5-8662-0050568e0e15','00566','1415926',1,1),('6e1d5725-f73d-11e5-8662-0050568e0e15','00567','1415926',1,1),('6e211259-f73d-11e5-8662-0050568e0e15','00568','1415926',1,1),('6e255fb2-f73d-11e5-8662-0050568e0e15','00569','1415926',1,1),('6e28dd83-f73d-11e5-8662-0050568e0e15','00570','1415926',1,1),('6e3a49ea-f73d-11e5-8662-0050568e0e15','00571','1415926',1,1),('6e45036e-f73d-11e5-8662-0050568e0e15','00572','1415926',1,1),('6e500f00-f73d-11e5-8662-0050568e0e15','00573','1415926',1,1),('6e59ff38-f73d-11e5-8662-0050568e0e15','00574','1415926',1,1),('6e62b3e2-f73d-11e5-8662-0050568e0e15','00575','1415926',1,1),('6e6f18a7-f73d-11e5-8662-0050568e0e15','00576','1415926',1,1),('6e77cd1a-f73d-11e5-8662-0050568e0e15','00577','1415926',1,1),('6e7df015-f73d-11e5-8662-0050568e0e15','00578','1415926',1,1),('6e81a22d-f73d-11e5-8662-0050568e0e15','00579','1415926',1,1),('6e8568b5-f73d-11e5-8662-0050568e0e15','00580','1415926',1,1),('6e892af4-f73d-11e5-8662-0050568e0e15','00581','1415926',1,1),('6e8e81ec-f73d-11e5-8662-0050568e0e15','00582','1415926',1,1),('6e920f51-f73d-11e5-8662-0050568e0e15','00583','1415926',1,1),('6e9632aa-f73d-11e5-8662-0050568e0e15','00584','1415926',1,1),('6e9cd086-f73d-11e5-8662-0050568e0e15','00585','1415926',1,1),('6ea2ea5f-f73d-11e5-8662-0050568e0e15','00586','1415926',1,1),('6ea87041-f73d-11e5-8662-0050568e0e15','00587','1415926',1,1),('6eb18689-f73d-11e5-8662-0050568e0e15','00588','1415926',1,1),('6eb5738e-f73d-11e5-8662-0050568e0e15','00589','1415926',1,1),('6eb8cf39-f73d-11e5-8662-0050568e0e15','00590','1415926',1,1),('6ec0e2ed-f73d-11e5-8662-0050568e0e15','00591','1415926',1,1),('6ec506a0-f73d-11e5-8662-0050568e0e15','00592','1415926',1,1),('6ec8d701-f73d-11e5-8662-0050568e0e15','00593','1415926',1,1),('6ed75618-f73d-11e5-8662-0050568e0e15','00594','1415926',1,1),('6ee4bbca-f73d-11e5-8662-0050568e0e15','00595','1415926',1,1),('6eeec9f8-f73d-11e5-8662-0050568e0e15','00596','1415926',1,1),('6efb5b21-f73d-11e5-8662-0050568e0e15','00597','1415926',1,1),('6f0499b0-f73d-11e5-8662-0050568e0e15','00598','1415926',1,1),('6f0e435a-f73d-11e5-8662-0050568e0e15','00599','1415926',1,1),('6f1664b8-f73d-11e5-8662-0050568e0e15','00600','1415926',1,1),('6f21ad0a-f73d-11e5-8662-0050568e0e15','00601','1415926',1,1),('6f2d7632-f73d-11e5-8662-0050568e0e15','00602','1415926',1,1),('6f354f2e-f73d-11e5-8662-0050568e0e15','00603','1415926',1,1),('6f417c7b-f73d-11e5-8662-0050568e0e15','00604','1415926',1,1),('6f4adbdb-f73d-11e5-8662-0050568e0e15','00605','1415926',1,1),('6f55222e-f73d-11e5-8662-0050568e0e15','00606','1415926',1,1),('6f605fdb-f73d-11e5-8662-0050568e0e15','00607','1415926',1,1),('6f6a4247-f73d-11e5-8662-0050568e0e15','00608','1415926',1,1),('6f78a1b0-f73d-11e5-8662-0050568e0e15','00609','1415926',1,1),('6f829b6c-f73d-11e5-8662-0050568e0e15','00610','1415926',1,1),('6f8a3a3c-f73d-11e5-8662-0050568e0e15','00611','1415926',1,1),('6f8fd80e-f73d-11e5-8662-0050568e0e15','00612','1415926',1,1),('6f97d3f2-f73d-11e5-8662-0050568e0e15','00613','1415926',1,1),('6f9e539d-f73d-11e5-8662-0050568e0e15','00614','1415926',1,1),('6fa7df5e-f73d-11e5-8662-0050568e0e15','00615','1415926',1,1),('6fb08c14-f73d-11e5-8662-0050568e0e15','00616','1415926',1,1),('6fbcd119-f73d-11e5-8662-0050568e0e15','00617','1415926',1,1),('6fc6bc9b-f73d-11e5-8662-0050568e0e15','00618','1415926',1,1),('6fceb3bb-f73d-11e5-8662-0050568e0e15','00619','1415926',1,1),('6fd77c30-f73d-11e5-8662-0050568e0e15','00620','1415926',1,1),('6fdee074-f73d-11e5-8662-0050568e0e15','00621','1415926',1,1),('6fe80034-f73d-11e5-8662-0050568e0e15','00622','1415926',1,1),('6ff567dc-f73d-11e5-8662-0050568e0e15','00623','1415926',1,1),('6ffe7999-f73d-11e5-8662-0050568e0e15','00624','1415926',1,1),('7007d1c6-f73d-11e5-8662-0050568e0e15','00625','1415926',1,1),('7014c318-f73d-11e5-8662-0050568e0e15','00626','1415926',1,1),('701dca1a-f73d-11e5-8662-0050568e0e15','00627','1415926',1,1),('7027a5c1-f73d-11e5-8662-0050568e0e15','00628','1415926',1,1),('70342500-f73d-11e5-8662-0050568e0e15','00629','1415926',1,1),('703ecfea-f73d-11e5-8662-0050568e0e15','00630','1415926',1,1),('7049ec2a-f73d-11e5-8662-0050568e0e15','00631','1415926',1,1),('7053f179-f73d-11e5-8662-0050568e0e15','00632','1415926',1,1),('705cc221-f73d-11e5-8662-0050568e0e15','00633','1415926',1,1),('70681cd9-f73d-11e5-8662-0050568e0e15','00634','1415926',1,1),('707270dc-f73d-11e5-8662-0050568e0e15','00635','1415926',1,1),('707b9596-f73d-11e5-8662-0050568e0e15','00636','1415926',1,1),('70878f7e-f73d-11e5-8662-0050568e0e15','00637','1415926',1,1),('7092d1a7-f73d-11e5-8662-0050568e0e15','00638','1415926',1,1),('709b5138-f73d-11e5-8662-0050568e0e15','00639','1415926',1,1),('70a466e9-f73d-11e5-8662-0050568e0e15','00640','1415926',1,1),('70b0f75a-f73d-11e5-8662-0050568e0e15','00641','1415926',1,1),('70b929d2-f73d-11e5-8662-0050568e0e15','00642','1415926',1,1),('70c22950-f73d-11e5-8662-0050568e0e15','00643','1415926',1,1),('70d0213d-f73d-11e5-8662-0050568e0e15','00644','1415926',1,1),('70db67bf-f73d-11e5-8662-0050568e0e15','00645','1415926',1,1),('70e82a06-f73d-11e5-8662-0050568e0e15','00646','1415926',1,1),('70f1f49e-f73d-11e5-8662-0050568e0e15','00647','1415926',1,1),('70fd7b9e-f73d-11e5-8662-0050568e0e15','00648','1415926',1,1),('71068261-f73d-11e5-8662-0050568e0e15','00649','1415926',1,1),('71104a09-f73d-11e5-8662-0050568e0e15','00650','1415926',1,1),('7119d992-f73d-11e5-8662-0050568e0e15','00651','1415926',1,1),('7125ce80-f73d-11e5-8662-0050568e0e15','00652','1415926',1,1),('712fd37b-f73d-11e5-8662-0050568e0e15','00653','1415926',1,1),('713d7b2f-f73d-11e5-8662-0050568e0e15','00654','1415926',1,1),('71482615-f73d-11e5-8662-0050568e0e15','00655','1415926',1,1),('7157576d-f73d-11e5-8662-0050568e0e15','00656','1415926',1,1),('715ef9e5-f73d-11e5-8662-0050568e0e15','00657','1415926',1,1),('716c5a22-f73d-11e5-8662-0050568e0e15','00658','1415926',1,1),('7175a919-f73d-11e5-8662-0050568e0e15','00659','1415926',1,1),('717eae48-f73d-11e5-8662-0050568e0e15','00661','1415926',1,1),('718b8e3e-f73d-11e5-8662-0050568e0e15','00662','1415926',1,1),('71944335-f73d-11e5-8662-0050568e0e15','00663','1415926',1,1),('719d83c4-f73d-11e5-8662-0050568e0e15','00664','1415926',1,1),('71a7191d-f73d-11e5-8662-0050568e0e15','00665','1415926',1,1),('71b26f2c-f73d-11e5-8662-0050568e0e15','00666','1415926',1,1),('71bb5167-f73d-11e5-8662-0050568e0e15','00667','1415926',1,1),('71ca0670-f73d-11e5-8662-0050568e0e15','00668','1415926',1,1),('71d4b895-f73d-11e5-8662-0050568e0e15','00669','1415926',1,1),('71e21b60-f73d-11e5-8662-0050568e0e15','00670','1415926',1,1),('71ebf1ba-f73d-11e5-8662-0050568e0e15','00671','1415926',1,1),('71f95908-f73d-11e5-8662-0050568e0e15','00672','1415926',1,1),('720273dd-f73d-11e5-8662-0050568e0e15','00673','1415926',1,1),('720d7bf3-f73d-11e5-8662-0050568e0e15','00674','1415926',1,1),('72182ab6-f73d-11e5-8662-0050568e0e15','00675','1415926',1,1),('7221e46a-f73d-11e5-8662-0050568e0e15','00676','1415926',1,1),('722a9629-f73d-11e5-8662-0050568e0e15','00677','1415926',1,1),('72355982-f73d-11e5-8662-0050568e0e15','00678','1415926',1,1),('723d6f3d-f73d-11e5-8662-0050568e0e15','00679','1415926',1,1),('72470bc3-f73d-11e5-8662-0050568e0e15','00680','1415926',1,1),('7251dc8b-f73d-11e5-8662-0050568e0e15','00681','1415926',1,1),('725cfa3e-f73d-11e5-8662-0050568e0e15','00682','1415926',1,1),('7266395c-f73d-11e5-8662-0050568e0e15','00683','1415926',1,1),('726f654d-f73d-11e5-8662-0050568e0e15','00684','1415926',1,1),('727c5fe8-f73d-11e5-8662-0050568e0e15','00685','1415926',1,1),('728587fa-f73d-11e5-8662-0050568e0e15','00686','1415926',1,1),('7290f468-f73d-11e5-8662-0050568e0e15','00687','1415926',1,1),('729d73c2-f73d-11e5-8662-0050568e0e15','00688','1415926',1,1),('72a67a28-f73d-11e5-8662-0050568e0e15','00689','1415926',1,1),('72ae03d0-f73d-11e5-8662-0050568e0e15','00690','1415926',1,1),('72b7294d-f73d-11e5-8662-0050568e0e15','00691','1415926',1,1),('72c02dfc-f73d-11e5-8662-0050568e0e15','00692','1415926',1,1),('72ca281f-f73d-11e5-8662-0050568e0e15','00693','1415926',1,1),('72d38693-f73d-11e5-8662-0050568e0e15','00694','1415926',1,1),('72dd7156-f73d-11e5-8662-0050568e0e15','00695','1415926',1,1),('72e91af9-f73d-11e5-8662-0050568e0e15','00696','1415926',1,1),('72f2e597-f73d-11e5-8662-0050568e0e15','00697','1415926',1,1),('72faee8f-f73d-11e5-8662-0050568e0e15','00698','1415926',1,1),('7302a61c-f73d-11e5-8662-0050568e0e15','00699','1415926',1,1),('730be90e-f73d-11e5-8662-0050568e0e15','00700','1415926',1,1),('73184674-f73d-11e5-8662-0050568e0e15','00701','1415926',1,1),('73228abc-f73d-11e5-8662-0050568e0e15','00702','1415926',1,1),('732be411-f73d-11e5-8662-0050568e0e15','00703','1415926',1,1),('733506de-f73d-11e5-8662-0050568e0e15','00704','1415926',1,1),('7340ce13-f73d-11e5-8662-0050568e0e15','00705','1415926',1,1),('7348db31-f73d-11e5-8662-0050568e0e15','00706','1415926',1,1),('73506df8-f73d-11e5-8662-0050568e0e15','00707','1415926',1,1),('735c96b2-f73d-11e5-8662-0050568e0e15','00708','1415926',1,1),('7364f7be-f73d-11e5-8662-0050568e0e15','00709','1415926',1,1),('736961af-f73d-11e5-8662-0050568e0e15','00710','1415926',1,1),('736faab6-f73d-11e5-8662-0050568e0e15','00711','1415926',1,1),('73739547-f73d-11e5-8662-0050568e0e15','00712','1415926',1,1),('7377cf4f-f73d-11e5-8662-0050568e0e15','00713','1415926',1,1),('737bcb06-f73d-11e5-8662-0050568e0e15','00714','1415926',1,1),('7382c33e-f73d-11e5-8662-0050568e0e15','00715','1415926',1,1),('738684c7-f73d-11e5-8662-0050568e0e15','00716','1415926',1,1),('738ab695-f73d-11e5-8662-0050568e0e15','00717','1415926',1,1),('739109e8-f73d-11e5-8662-0050568e0e15','00718','1415926',1,1),('73954e97-f73d-11e5-8662-0050568e0e15','00719','1415926',1,1),('73999a6f-f73d-11e5-8662-0050568e0e15','00720','1415926',1,1),('73a138ec-f73d-11e5-8662-0050568e0e15','00721','1415926',1,1),('73a57696-f73d-11e5-8662-0050568e0e15','00722','1415926',1,1),('73a99070-f73d-11e5-8662-0050568e0e15','00723','1415926',1,1),('73ae1f80-f73d-11e5-8662-0050568e0e15','00724','1415926',1,1),('73bdbf10-f73d-11e5-8662-0050568e0e15','00725','1415926',1,1),('73c84bfd-f73d-11e5-8662-0050568e0e15','00726','1415926',1,1),('73d1db2c-f73d-11e5-8662-0050568e0e15','00727','1415926',1,1),('73dcf8c1-f73d-11e5-8662-0050568e0e15','00728','1415926',1,1),('73e4b4ae-f73d-11e5-8662-0050568e0e15','00729','1415926',1,1),('73edc072-f73d-11e5-8662-0050568e0e15','00730','1415926',1,1),('73f8b72b-f73d-11e5-8662-0050568e0e15','00731','1415926',1,1),('7403e85e-f73d-11e5-8662-0050568e0e15','00732','1415926',1,1),('740ee016-f73d-11e5-8662-0050568e0e15','00733','1415926',1,1),('741d5741-f73d-11e5-8662-0050568e0e15','00734','1415926',1,1),('742b37c8-f73d-11e5-8662-0050568e0e15','00735','1415926',1,1),('7434eff9-f73d-11e5-8662-0050568e0e15','00736','1415926',1,1),('7445a93a-f73d-11e5-8662-0050568e0e15','00737','1415926',1,1),('744e2881-f73d-11e5-8662-0050568e0e15','00738','1415926',1,1),('74560102-f73d-11e5-8662-0050568e0e15','00739','1415926',1,1),('74654f3f-f73d-11e5-8662-0050568e0e15','00740','1415926',1,1),('7472f067-f73d-11e5-8662-0050568e0e15','00741','1415926',1,1),('7484ffcb-f73d-11e5-8662-0050568e0e15','00742','1415926',1,1),('74912926-f73d-11e5-8662-0050568e0e15','00743','1415926',1,1),('749b8662-f73d-11e5-8662-0050568e0e15','00744','1415926',1,1),('74a7fea9-f73d-11e5-8662-0050568e0e15','00745','1415926',1,1),('74b1d857-f73d-11e5-8662-0050568e0e15','00746','1415926',1,1),('74bbd383-f73d-11e5-8662-0050568e0e15','00747','1415926',1,1),('74c741d1-f73d-11e5-8662-0050568e0e15','00748','1415926',1,1),('74d03ab6-f73d-11e5-8662-0050568e0e15','00749','1415926',1,1),('74da2adf-f73d-11e5-8662-0050568e0e15','00750','1415926',1,1),('74e6dd53-f73d-11e5-8662-0050568e0e15','00751','1415926',1,1),('74f1203b-f73d-11e5-8662-0050568e0e15','00752','1415926',1,1),('74fe5d36-f73d-11e5-8662-0050568e0e15','00753','1415926',1,1),('750c579c-f73d-11e5-8662-0050568e0e15','00754','1415926',1,1),('75156823-f73d-11e5-8662-0050568e0e15','00755','1415926',1,1),('751e0a00-f73d-11e5-8662-0050568e0e15','00756','1415926',1,1),('7527d8d2-f73d-11e5-8662-0050568e0e15','00757','1415926',1,1),('7530ec3e-f73d-11e5-8662-0050568e0e15','00758','1415926',1,1),('753e61f3-f73d-11e5-8662-0050568e0e15','00759','1415926',1,1),('75472cad-f73d-11e5-8662-0050568e0e15','00760','1415926',1,1),('755420cb-f73d-11e5-8662-0050568e0e15','00761','1415926',1,1),('755cc725-f73d-11e5-8662-0050568e0e15','00762','1415926',1,1),('75659890-f73d-11e5-8662-0050568e0e15','00763','1415926',1,1),('757300bd-f73d-11e5-8662-0050568e0e15','00764','1415926',1,1),('757d50c9-f73d-11e5-8662-0050568e0e15','00765','1415926',1,1),('7587aea4-f73d-11e5-8662-0050568e0e15','00766','1415926',1,1),('759321ba-f73d-11e5-8662-0050568e0e15','00767','1415926',1,1),('759b4c33-f73d-11e5-8662-0050568e0e15','00768','1415926',1,1),('75a4af44-f73d-11e5-8662-0050568e0e15','00769','1415926',1,1),('75ab598b-f73d-11e5-8662-0050568e0e15','00770','1415926',1,1),('75b50410-f73d-11e5-8662-0050568e0e15','00771','1415926',1,1),('75bd4b57-f73d-11e5-8662-0050568e0e15','00772','1415926',1,1),('75caf1d8-f73d-11e5-8662-0050568e0e15','00773','1415926',1,1),('75d62d60-f73d-11e5-8662-0050568e0e15','00774','1415926',1,1),('75e0527b-f73d-11e5-8662-0050568e0e15','00775','1415926',1,1),('75ea08a8-f73d-11e5-8662-0050568e0e15','00776','1415926',1,1),('75f4e096-f73d-11e5-8662-0050568e0e15','00777','1415926',1,1),('75ff8d4a-f73d-11e5-8662-0050568e0e15','00778','1415926',1,1),('7609994f-f73d-11e5-8662-0050568e0e15','00779','1415926',1,1),('76135aa8-f73d-11e5-8662-0050568e0e15','00780','1415926',1,1),('761b0cc7-f73d-11e5-8662-0050568e0e15','00781','1415926',1,1),('76275e6a-f73d-11e5-8662-0050568e0e15','00782','1415926',1,1),('7633f56f-f73d-11e5-8662-0050568e0e15','00783','1415926',1,1),('763e0506-f73d-11e5-8662-0050568e0e15','00784','1415926',1,1),('76481a8c-f73d-11e5-8662-0050568e0e15','00785','1415926',1,1),('76523b4b-f73d-11e5-8662-0050568e0e15','00786','1415926',1,1),('765daa16-f73d-11e5-8662-0050568e0e15','00787','1415926',1,1),('76684abd-f73d-11e5-8662-0050568e0e15','00788','1415926',1,1),('7675b603-f73d-11e5-8662-0050568e0e15','00789','1415926',1,1),('76808d7b-f73d-11e5-8662-0050568e0e15','00790','1415926',1,1),('768af73c-f73d-11e5-8662-0050568e0e15','00791','1415926',1,1),('7693232f-f73d-11e5-8662-0050568e0e15','00792','1415926',1,1),('769caf9d-f73d-11e5-8662-0050568e0e15','00793','1415926',1,1),('76a6512c-f73d-11e5-8662-0050568e0e15','00794','1415926',1,1),('76b07128-f73d-11e5-8662-0050568e0e15','00795','1415926',1,1),('76baf248-f73d-11e5-8662-0050568e0e15','00796','1415926',1,1),('76c3b1d5-f73d-11e5-8662-0050568e0e15','00798','1415926',1,1),('76cde75d-f73d-11e5-8662-0050568e0e15','00799','1415926',1,1),('76d551b3-f73d-11e5-8662-0050568e0e15','00800','1415926',1,1),('76e22791-f73d-11e5-8662-0050568e0e15','00801','1415926',1,1),('76ea0f62-f73d-11e5-8662-0050568e0e15','00802','1415926',1,1),('76f4929d-f73d-11e5-8662-0050568e0e15','00803','1415926',1,1),('77015017-f73d-11e5-8662-0050568e0e15','00804','1415926',1,1),('770a09ce-f73d-11e5-8662-0050568e0e15','00805','1415926',1,1),('7714ceac-f73d-11e5-8662-0050568e0e15','00806','1415926',1,1),('77221253-f73d-11e5-8662-0050568e0e15','00807','1415926',1,1),('772ae978-f73d-11e5-8662-0050568e0e15','00808','1415926',1,1),('7737f485-f73d-11e5-8662-0050568e0e15','00809','1415926',1,1),('77424e60-f73d-11e5-8662-0050568e0e15','00810','1415926',1,1),('7748c038-f73d-11e5-8662-0050568e0e15','00811','1415926',1,1),('7757830c-f73d-11e5-8662-0050568e0e15','00812','1415926',1,1),('7760e00c-f73d-11e5-8662-0050568e0e15','00813','1415926',1,1),('776aaaf3-f73d-11e5-8662-0050568e0e15','00814','1415926',1,1),('7777905d-f73d-11e5-8662-0050568e0e15','00815','1415926',1,1),('7786c28e-f73d-11e5-8662-0050568e0e15','00816','1415926',1,1),('77902689-f73d-11e5-8662-0050568e0e15','00817','1415926',1,1),('7799f06c-f73d-11e5-8662-0050568e0e15','00818','1415926',1,1),('77a52c0b-f73d-11e5-8662-0050568e0e15','00819','1415926',1,1),('77af9486-f73d-11e5-8662-0050568e0e15','00820','1415926',1,1),('77bb0069-f73d-11e5-8662-0050568e0e15','00821','1415926',1,1),('77c4949a-f73d-11e5-8662-0050568e0e15','00822','1415926',1,1),('77cd85fc-f73d-11e5-8662-0050568e0e15','00823','1415926',1,1),('77d79d50-f73d-11e5-8662-0050568e0e15','00824','1415926',1,1),('77e3ac71-f73d-11e5-8662-0050568e0e15','00825','1415926',1,1),('77ee40fb-f73d-11e5-8662-0050568e0e15','00826','1415926',1,1),('77fc4537-f73d-11e5-8662-0050568e0e15','00827','1415926',1,1),('7803fc68-f73d-11e5-8662-0050568e0e15','00828','1415926',1,1),('780c9408-f73d-11e5-8662-0050568e0e15','00829','1415926',1,1),('78160b4f-f73d-11e5-8662-0050568e0e15','00830','1415926',1,1),('78222fea-f73d-11e5-8662-0050568e0e15','00831','1415926',1,1),('782c532b-f73d-11e5-8662-0050568e0e15','00832','1415926',1,1),('7836c733-f73d-11e5-8662-0050568e0e15','00833','1415926',1,1),('783fb7cb-f73d-11e5-8662-0050568e0e15','00834','1415926',1,1),('784a3e73-f73d-11e5-8662-0050568e0e15','00835','1415926',1,1),('7853caca-f73d-11e5-8662-0050568e0e15','00836','1415926',1,1),('785c8f24-f73d-11e5-8662-0050568e0e15','00837','1415926',1,1),('78679e9e-f73d-11e5-8662-0050568e0e15','00838','1415926',1,1),('7870ad4d-f73d-11e5-8662-0050568e0e15','00839','1415926',1,1),('787b6c3b-f73d-11e5-8662-0050568e0e15','00840','1415926',1,1),('78882aa8-f73d-11e5-8662-0050568e0e15','00841','1415926',1,1),('7891f34f-f73d-11e5-8662-0050568e0e15','00842','1415926',1,1),('789d8870-f73d-11e5-8662-0050568e0e15','00843','1415926',1,1),('78a94f1f-f73d-11e5-8662-0050568e0e15','00844','1415926',1,1),('78b33601-f73d-11e5-8662-0050568e0e15','00845','1415926',1,1),('78be53eb-f73d-11e5-8662-0050568e0e15','00846','1415926',1,1),('78c64ef0-f73d-11e5-8662-0050568e0e15','00847','1415926',1,1),('78d05cc8-f73d-11e5-8662-0050568e0e15','00848','1415926',1,1),('78dd89a6-f73d-11e5-8662-0050568e0e15','00849','1415926',1,1),('78e8e753-f73d-11e5-8662-0050568e0e15','00850','1415926',1,1),('78f4fe75-f73d-11e5-8662-0050568e0e15','00851','1415926',1,1),('78fe316c-f73d-11e5-8662-0050568e0e15','00852','1415926',1,1),('7908879b-f73d-11e5-8662-0050568e0e15','00853','1415926',1,1),('7916931b-f73d-11e5-8662-0050568e0e15','00854','1415926',1,1),('791fda53-f73d-11e5-8662-0050568e0e15','00855','1415926',1,1),('792ba0d7-f73d-11e5-8662-0050568e0e15','00856','1415926',1,1),('7937a5ea-f73d-11e5-8662-0050568e0e15','00857','1415926',1,1),('794178f0-f73d-11e5-8662-0050568e0e15','00858','1415926',1,1),('794a7664-f73d-11e5-8662-0050568e0e15','00859','1415926',1,1),('7955b554-f73d-11e5-8662-0050568e0e15','00860','1415926',1,1),('79634819-f73d-11e5-8662-0050568e0e15','00861','1415926',1,1),('796d2c8b-f73d-11e5-8662-0050568e0e15','00862','1415926',1,1),('797a5d8a-f73d-11e5-8662-0050568e0e15','00863','1415926',1,1),('79837b07-f73d-11e5-8662-0050568e0e15','00864','1415926',1,1),('798ee20a-f73d-11e5-8662-0050568e0e15','00865','1415926',1,1),('7998ecf9-f73d-11e5-8662-0050568e0e15','00866','1415926',1,1),('79a0409f-f73d-11e5-8662-0050568e0e15','00867','1415926',1,1),('79a88f64-f73d-11e5-8662-0050568e0e15','00868','1415926',1,1),('79ae6713-f73d-11e5-8662-0050568e0e15','00869','1415926',1,1),('79b82b4c-f73d-11e5-8662-0050568e0e15','00870','1415926',1,1),('79bfb1ca-f73d-11e5-8662-0050568e0e15','00871','1415926',1,1),('79c94dcd-f73d-11e5-8662-0050568e0e15','00872','1415926',1,1),('79d0f6da-f73d-11e5-8662-0050568e0e15','00873','1415926',1,1),('79d9ed80-f73d-11e5-8662-0050568e0e15','00874','1415926',1,1),('79e36137-f73d-11e5-8662-0050568e0e15','00875','1415926',1,1),('79ee1b11-f73d-11e5-8662-0050568e0e15','00876','1415926',1,1),('79f886a8-f73d-11e5-8662-0050568e0e15','00877','1415926',1,1),('79ffe11d-f73d-11e5-8662-0050568e0e15','00878','1415926',1,1),('7a08977c-f73d-11e5-8662-0050568e0e15','00879','1415926',1,1),('7a15e028-f73d-11e5-8662-0050568e0e15','00880','1415926',1,1),('7a2098e8-f73d-11e5-8662-0050568e0e15','00881','1415926',1,1),('7a2ca4f1-f73d-11e5-8662-0050568e0e15','00882','1415926',1,1),('7a351ecc-f73d-11e5-8662-0050568e0e15','00883','1415926',1,1),('7a3a6b1a-f73d-11e5-8662-0050568e0e15','00884','1415926',1,1),('7a3deff2-f73d-11e5-8662-0050568e0e15','00885','1415926',1,1),('7a44bbac-f73d-11e5-8662-0050568e0e15','00886','1415926',1,1),('7a48cb4f-f73d-11e5-8662-0050568e0e15','00887','1415926',1,1),('7a4f1c38-f73d-11e5-8662-0050568e0e15','00888','1415926',1,1),('7a567928-f73d-11e5-8662-0050568e0e15','00889','1415926',1,1),('7a5edfd0-f73d-11e5-8662-0050568e0e15','00890','1415926',1,1),('7a69ffeb-f73d-11e5-8662-0050568e0e15','00891','1415926',1,1),('7a75ca6b-f73d-11e5-8662-0050568e0e15','00892','1415926',1,1),('7a8152f4-f73d-11e5-8662-0050568e0e15','00893','1415926',1,1),('7a8c9a29-f73d-11e5-8662-0050568e0e15','00894','1415926',1,1),('7a96b0bc-f73d-11e5-8662-0050568e0e15','00895','1415926',1,1),('7a9eb0bc-f73d-11e5-8662-0050568e0e15','00896','1415926',1,1),('7aa71b05-f73d-11e5-8662-0050568e0e15','00897','1415926',1,1),('7ab1ba32-f73d-11e5-8662-0050568e0e15','00898','1415926',1,1),('7aba8d9a-f73d-11e5-8662-0050568e0e15','00899','1415926',1,1),('7ac26a1a-f73d-11e5-8662-0050568e0e15','00900','1415926',1,1),('7acb9450-f73d-11e5-8662-0050568e0e15','00901','1415926',1,1),('7ad896f2-f73d-11e5-8662-0050568e0e15','00902','1415926',1,1),('7ae16cc7-f73d-11e5-8662-0050568e0e15','00903','1415926',1,1),('7ae97e43-f73d-11e5-8662-0050568e0e15','00904','1415926',1,1),('7af4067d-f73d-11e5-8662-0050568e0e15','00905','1415926',1,1),('7affd230-f73d-11e5-8662-0050568e0e15','00906','1415926',1,1),('7b0733d5-f73d-11e5-8662-0050568e0e15','00907','1415926',1,1),('7b10f6bb-f73d-11e5-8662-0050568e0e15','00908','1415926',1,1),('7b1bb803-f73d-11e5-8662-0050568e0e15','00909','1415926',1,1),('7b264c29-f73d-11e5-8662-0050568e0e15','00910','1415926',1,1),('7b308fb4-f73d-11e5-8662-0050568e0e15','00911','1415926',1,1),('7b3a3201-f73d-11e5-8662-0050568e0e15','00912','1415926',1,1),('7b45a1fc-f73d-11e5-8662-0050568e0e15','00913','1415926',1,1),('7b4ebb14-f73d-11e5-8662-0050568e0e15','00914','1415926',1,1),('7b583e5d-f73d-11e5-8662-0050568e0e15','00915','1415926',1,1),('7b617d4f-f73d-11e5-8662-0050568e0e15','00916','1415926',1,1),('7b6b8af5-f73d-11e5-8662-0050568e0e15','00917','1415926',1,1),('7b75988a-f73d-11e5-8662-0050568e0e15','00918','1415926',1,1),('7b834245-f73d-11e5-8662-0050568e0e15','00919','1415926',1,1),('7b8c70c2-f73d-11e5-8662-0050568e0e15','00920','1415926',1,1),('7b93117c-f73d-11e5-8662-0050568e0e15','00921','1415926',1,1),('7b9c50f8-f73d-11e5-8662-0050568e0e15','00922','1415926',1,1),('7ba6d2ed-f73d-11e5-8662-0050568e0e15','00923','1415926',1,1),('7bae6028-f73d-11e5-8662-0050568e0e15','00924','1415926',1,1),('7bb7e076-f73d-11e5-8662-0050568e0e15','00925','1415926',1,1),('7bc12696-f73d-11e5-8662-0050568e0e15','00926','1415926',1,1),('7bcb3b83-f73d-11e5-8662-0050568e0e15','00927','1415926',1,1),('7bd40dd6-f73d-11e5-8662-0050568e0e15','00928','1415926',1,1),('7bdcd65d-f73d-11e5-8662-0050568e0e15','00929','1415926',1,1),('7be5f22f-f73d-11e5-8662-0050568e0e15','00930','1415926',1,1),('7bf0894e-f73d-11e5-8662-0050568e0e15','00931','1415926',1,1),('7bf9af3e-f73d-11e5-8662-0050568e0e15','00932','1415926',1,1),('7c050140-f73d-11e5-8662-0050568e0e15','00933','1415926',1,1),('7c102ca3-f73d-11e5-8662-0050568e0e15','00935','1415926',1,1),('7c1904a1-f73d-11e5-8662-0050568e0e15','00936','1415926',1,1),('7c22ff64-f73d-11e5-8662-0050568e0e15','00937','1415926',1,1),('7c2e996a-f73d-11e5-8662-0050568e0e15','00938','1415926',1,1),('7c38b776-f73d-11e5-8662-0050568e0e15','00939','1415926',1,1),('7c40e3d6-f73d-11e5-8662-0050568e0e15','00940','1415926',1,1),('7c4afd90-f73d-11e5-8662-0050568e0e15','00941','1415926',1,1),('7c53bc32-f73d-11e5-8662-0050568e0e15','00942','1415926',1,1),('7c5ee829-f73d-11e5-8662-0050568e0e15','00943','1415926',1,1),('7c6802dc-f73d-11e5-8662-0050568e0e15','00944','1415926',1,1),('7c70df08-f73d-11e5-8662-0050568e0e15','00945','1415926',1,1),('7c7b89bc-f73d-11e5-8662-0050568e0e15','00946','1415926',1,1),('7c86dda8-f73d-11e5-8662-0050568e0e15','00947','1415926',1,1),('7c912484-f73d-11e5-8662-0050568e0e15','00948','1415926',1,1),('7c9c6a50-f73d-11e5-8662-0050568e0e15','00949','1415926',1,1),('7ca69717-f73d-11e5-8662-0050568e0e15','00950','1415926',1,1),('7cafb6e2-f73d-11e5-8662-0050568e0e15','00951','1415926',1,1),('7cb80c09-f73d-11e5-8662-0050568e0e15','00952','1415926',1,1),('7cc31d2b-f73d-11e5-8662-0050568e0e15','00953','1415926',1,1),('7cce5197-f73d-11e5-8662-0050568e0e15','00954','1415926',1,1),('7cd6e276-f73d-11e5-8662-0050568e0e15','00955','1415926',1,1),('7ce0bbc2-f73d-11e5-8662-0050568e0e15','00956','1415926',1,1),('7ce9cd58-f73d-11e5-8662-0050568e0e15','00957','1415926',1,1),('7cf38b5b-f73d-11e5-8662-0050568e0e15','00958','1415926',1,1),('7cfbc177-f73d-11e5-8662-0050568e0e15','00959','1415926',1,1),('7d04a40d-f73d-11e5-8662-0050568e0e15','00960','1415926',1,1),('7d114460-f73d-11e5-8662-0050568e0e15','00961','1415926',1,1),('7d1bd97f-f73d-11e5-8662-0050568e0e15','00962','1415926',1,1),('7d25d086-f73d-11e5-8662-0050568e0e15','00963','1415926',1,1),('7d306e76-f73d-11e5-8662-0050568e0e15','00964','1415926',1,1),('7d3b4899-f73d-11e5-8662-0050568e0e15','00965','1415926',1,1),('7d453a3b-f73d-11e5-8662-0050568e0e15','00966','1415926',1,1),('7d4cb716-f73d-11e5-8662-0050568e0e15','00967','1415926',1,1),('7d559cbe-f73d-11e5-8662-0050568e0e15','00968','1415926',1,1),('7d6326f9-f73d-11e5-8662-0050568e0e15','00969','1415926',1,1),('7d6c4252-f73d-11e5-8662-0050568e0e15','00970','1415926',1,1),('7d777f83-f73d-11e5-8662-0050568e0e15','00971','1415926',1,1),('7d810dcd-f73d-11e5-8662-0050568e0e15','00972','1415926',1,1),('7d8abbad-f73d-11e5-8662-0050568e0e15','00973','1415926',1,1),('7d9506f7-f73d-11e5-8662-0050568e0e15','00974','1415926',1,1),('7d9e154b-f73d-11e5-8662-0050568e0e15','00975','1415926',1,1),('7da7b78d-f73d-11e5-8662-0050568e0e15','00976','1415926',1,1),('7db141c5-f73d-11e5-8662-0050568e0e15','00977','1415926',1,1),('7db9d733-f73d-11e5-8662-0050568e0e15','00978','1415926',1,1),('7dc5c2d5-f73d-11e5-8662-0050568e0e15','00979','1415926',1,1),('7dce696b-f73d-11e5-8662-0050568e0e15','00980','1415926',1,1),('7dd958c0-f73d-11e5-8662-0050568e0e15','00981','1415926',1,1),('7de457de-f73d-11e5-8662-0050568e0e15','00982','1415926',1,1),('7deef7b7-f73d-11e5-8662-0050568e0e15','00983','1415926',1,1),('7df8c5a9-f73d-11e5-8662-0050568e0e15','00984','1415926',1,1),('7e022c95-f73d-11e5-8662-0050568e0e15','00985','1415926',1,1),('7e0cd43a-f73d-11e5-8662-0050568e0e15','00986','1415926',1,1),('7e152725-f73d-11e5-8662-0050568e0e15','00987','1415926',1,1),('7e1f2476-f73d-11e5-8662-0050568e0e15','00988','1415926',1,1),('7e281ac2-f73d-11e5-8662-0050568e0e15','00989','1415926',1,1),('7e3184ac-f73d-11e5-8662-0050568e0e15','00990','1415926',1,1),('7e3b80f4-f73d-11e5-8662-0050568e0e15','00991','1415926',1,1),('7e453022-f73d-11e5-8662-0050568e0e15','00992','1415926',1,1),('7e4f1c0d-f73d-11e5-8662-0050568e0e15','00993','1415926',1,1),('7e5907eb-f73d-11e5-8662-0050568e0e15','00994','1415926',1,1),('7e6172db-f73d-11e5-8662-0050568e0e15','00995','1415926',1,1),('7e6aafbb-f73d-11e5-8662-0050568e0e15','00996','1415926',1,1),('7e748e30-f73d-11e5-8662-0050568e0e15','00997','1415926',1,1),('7e7ff978-f73d-11e5-8662-0050568e0e15','00998','1415926',1,1),('7e8995ba-f73d-11e5-8662-0050568e0e15','00999','1415926',1,1),('7e92c5d6-f73d-11e5-8662-0050568e0e15','01000','1415926',1,1),('7e9aaff1-f73d-11e5-8662-0050568e0e15','01001','1415926',1,1),('7ea449a0-f73d-11e5-8662-0050568e0e15','01002','1415926',1,1),('7eaea5b7-f73d-11e5-8662-0050568e0e15','01003','1415926',1,1),('7eb9596b-f73d-11e5-8662-0050568e0e15','01004','1415926',1,1),('7ec2cdbf-f73d-11e5-8662-0050568e0e15','01005','1415926',1,1),('7ecd5190-f73d-11e5-8662-0050568e0e15','01006','1415926',1,1),('7ed8a010-f73d-11e5-8662-0050568e0e15','01007','1415926',1,1),('7ee1fde2-f73d-11e5-8662-0050568e0e15','01008','1415926',1,1),('7eeace30-f73d-11e5-8662-0050568e0e15','01009','1415926',1,1),('7ef1dd66-f73d-11e5-8662-0050568e0e15','01010','1415926',1,1),('7efa2565-f73d-11e5-8662-0050568e0e15','01011','1415926',1,1),('7f04ed60-f73d-11e5-8662-0050568e0e15','01012','1415926',1,1),('7f0ef55a-f73d-11e5-8662-0050568e0e15','01013','1415926',1,1),('7f166b3b-f73d-11e5-8662-0050568e0e15','01014','1415926',1,1),('7f205409-f73d-11e5-8662-0050568e0e15','01015','1415926',1,1),('7f29ea90-f73d-11e5-8662-0050568e0e15','01016','1415926',1,1),('7f355eeb-f73d-11e5-8662-0050568e0e15','01017','1415926',1,1),('7f3d52b3-f73d-11e5-8662-0050568e0e15','01018','1415926',1,1),('7f4575c7-f73d-11e5-8662-0050568e0e15','01019','1415926',1,1),('7f4f12a4-f73d-11e5-8662-0050568e0e15','01020','1415926',1,1),('7f5bc27b-f73d-11e5-8662-0050568e0e15','01021','1415926',1,1),('7f645305-f73d-11e5-8662-0050568e0e15','01022','1415926',1,1),('7f6c6aea-f73d-11e5-8662-0050568e0e15','01023','1415926',1,1),('7f764ad0-f73d-11e5-8662-0050568e0e15','01024','1415926',1,1),('7f837586-f73d-11e5-8662-0050568e0e15','01025','1415926',1,1),('7f8cfe91-f73d-11e5-8662-0050568e0e15','01026','1415926',1,1),('7f96df0b-f73d-11e5-8662-0050568e0e15','01027','1415926',1,1),('7fa1281b-f73d-11e5-8662-0050568e0e15','01028','1415926',1,1),('7faa7d05-f73d-11e5-8662-0050568e0e15','01029','1415926',1,1),('7fb2e392-f73d-11e5-8662-0050568e0e15','01030','1415926',1,1),('7fbc2180-f73d-11e5-8662-0050568e0e15','01031','1415926',1,1),('7fc704b9-f73d-11e5-8662-0050568e0e15','01032','1415926',1,1),('7fd18a51-f73d-11e5-8662-0050568e0e15','01033','1415926',1,1),('7fda1465-f73d-11e5-8662-0050568e0e15','01034','1415926',1,1),('7fe37aec-f73d-11e5-8662-0050568e0e15','01035','1415926',1,1),('7fed573e-f73d-11e5-8662-0050568e0e15','01036','1415926',1,1),('7ff75185-f73d-11e5-8662-0050568e0e15','01037','1415926',1,1),('8000613f-f73d-11e5-8662-0050568e0e15','01038','1415926',1,1),('8009b2c4-f73d-11e5-8662-0050568e0e15','01039','1415926',1,1),('80133f2f-f73d-11e5-8662-0050568e0e15','01040','1415926',1,1),('801e0f1f-f73d-11e5-8662-0050568e0e15','01041','1415926',1,1),('802635c6-f73d-11e5-8662-0050568e0e15','01042','1415926',1,1),('802f90bc-f73d-11e5-8662-0050568e0e15','01043','1415926',1,1),('803d4fc7-f73d-11e5-8662-0050568e0e15','01044','1415926',1,1),('80461397-f73d-11e5-8662-0050568e0e15','01045','1415926',1,1),('804fe720-f73d-11e5-8662-0050568e0e15','01046','1415926',1,1),('805c9ed4-f73d-11e5-8662-0050568e0e15','01047','1415926',1,1),('806719e6-f73d-11e5-8662-0050568e0e15','01048','1415926',1,1),('8071d5b9-f73d-11e5-8662-0050568e0e15','01049','1415926',1,1),('807d86c6-f73d-11e5-8662-0050568e0e15','01050','1415926',1,1),('8087cd3d-f73d-11e5-8662-0050568e0e15','01051','1415926',1,1),('808f4701-f73d-11e5-8662-0050568e0e15','01052','1415926',1,1),('809d5b8f-f73d-11e5-8662-0050568e0e15','01053','1415926',1,1),('80a70776-f73d-11e5-8662-0050568e0e15','01054','1415926',1,1),('80b10ff6-f73d-11e5-8662-0050568e0e15','01055','1415926',1,1),('80ba4d2d-f73d-11e5-8662-0050568e0e15','01056','1415926',1,1),('80ca2391-f73d-11e5-8662-0050568e0e15','01057','1415926',1,1),('80d56514-f73d-11e5-8662-0050568e0e15','01058','1415926',1,1),('80defbf0-f73d-11e5-8662-0050568e0e15','01059','1415926',1,1),('80e92d39-f73d-11e5-8662-0050568e0e15','01060','1415926',1,1),('80f29453-f73d-11e5-8662-0050568e0e15','01061','1415926',1,1),('80fba14e-f73d-11e5-8662-0050568e0e15','01062','1415926',1,1),('81059315-f73d-11e5-8662-0050568e0e15','01063','1415926',1,1),('81100762-f73d-11e5-8662-0050568e0e15','01064','1415926',1,1),('81197a2c-f73d-11e5-8662-0050568e0e15','01065','1415926',1,1),('81243947-f73d-11e5-8662-0050568e0e15','01066','1415926',1,1),('812cf270-f73d-11e5-8662-0050568e0e15','01067','1415926',1,1),('8135567b-f73d-11e5-8662-0050568e0e15','01068','1415926',1,1),('8141734e-f73d-11e5-8662-0050568e0e15','01069','1415926',1,1),('814cd528-f73d-11e5-8662-0050568e0e15','01070','1415926',1,1),('8158174f-f73d-11e5-8662-0050568e0e15','01072','1415926',1,1),('81616923-f73d-11e5-8662-0050568e0e15','01073','1415926',1,1),('816e7b72-f73d-11e5-8662-0050568e0e15','01074','1415926',1,1),('8178c199-f73d-11e5-8662-0050568e0e15','01075','1415926',1,1),('8185771e-f73d-11e5-8662-0050568e0e15','01076','1415926',1,1),('818dc05d-f73d-11e5-8662-0050568e0e15','01077','1415926',1,1),('81950c76-f73d-11e5-8662-0050568e0e15','01078','1415926',1,1),('819df7b4-f73d-11e5-8662-0050568e0e15','01079','1415926',1,1),('81a641c1-f73d-11e5-8662-0050568e0e15','01080','1415926',1,1),('81ae5918-f73d-11e5-8662-0050568e0e15','01081','1415926',1,1),('81b6c862-f73d-11e5-8662-0050568e0e15','01082','1415926',1,1),('81c0f916-f73d-11e5-8662-0050568e0e15','01083','1415926',1,1),('81ca7a1a-f73d-11e5-8662-0050568e0e15','01084','1415926',1,1),('81d51d7d-f73d-11e5-8662-0050568e0e15','01085','1415926',1,1),('81dce043-f73d-11e5-8662-0050568e0e15','01086','1415926',1,1),('81e5d5df-f73d-11e5-8662-0050568e0e15','01087','1415926',1,1),('81efde44-f73d-11e5-8662-0050568e0e15','01088','1415926',1,1),('81fc119e-f73d-11e5-8662-0050568e0e15','01089','1415926',1,1),('82084a12-f73d-11e5-8662-0050568e0e15','01090','1415926',1,1),('82120caa-f73d-11e5-8662-0050568e0e15','01091','1415926',1,1),('821b10e3-f73d-11e5-8662-0050568e0e15','01092','1415926',1,1),('8224c933-f73d-11e5-8662-0050568e0e15','01093','1415926',1,1),('822e5206-f73d-11e5-8662-0050568e0e15','01094','1415926',1,1),('82380ace-f73d-11e5-8662-0050568e0e15','01095','1415926',1,1),('82425319-f73d-11e5-8662-0050568e0e15','01096','1415926',1,1),('824cd9ec-f73d-11e5-8662-0050568e0e15','01097','1415926',1,1),('825702f1-f73d-11e5-8662-0050568e0e15','01098','1415926',1,1),('82619d05-f73d-11e5-8662-0050568e0e15','01099','1415926',1,1),('826b618d-f73d-11e5-8662-0050568e0e15','01100','1415926',1,1),('82760e64-f73d-11e5-8662-0050568e0e15','01101','1415926',1,1),('8280c797-f73d-11e5-8662-0050568e0e15','01102','1415926',1,1),('8287c599-f73d-11e5-8662-0050568e0e15','01103','1415926',1,1),('829398cf-f73d-11e5-8662-0050568e0e15','01104','1415926',1,1),('829c1b43-f73d-11e5-8662-0050568e0e15','01105','1415926',1,1),('82a88a37-f73d-11e5-8662-0050568e0e15','01106','1415926',1,1),('82b21316-f73d-11e5-8662-0050568e0e15','01107','1415926',1,1),('82bf7623-f73d-11e5-8662-0050568e0e15','01108','1415926',1,1),('82d00da6-f73d-11e5-8662-0050568e0e15','01109','1415926',1,1),('82d97b14-f73d-11e5-8662-0050568e0e15','01110','1415926',1,1),('82e701c9-f73d-11e5-8662-0050568e0e15','01111','1415926',1,1),('82f1aaa3-f73d-11e5-8662-0050568e0e15','01112','1415926',1,1),('82f95185-f73d-11e5-8662-0050568e0e15','01113','1415926',1,1),('83048b70-f73d-11e5-8662-0050568e0e15','01114','1415926',1,1),('830f5bc9-f73d-11e5-8662-0050568e0e15','01115','1415926',1,1),('83189bbd-f73d-11e5-8662-0050568e0e15','01116','1415926',1,1),('8321ba84-f73d-11e5-8662-0050568e0e15','01117','1415926',1,1),('832b4b62-f73d-11e5-8662-0050568e0e15','01118','1415926',1,1),('83360707-f73d-11e5-8662-0050568e0e15','01119','1415926',1,1),('833e8d1d-f73d-11e5-8662-0050568e0e15','01120','1415926',1,1),('83477880-f73d-11e5-8662-0050568e0e15','01121','1415926',1,1),('8355fbc8-f73d-11e5-8662-0050568e0e15','01122','1415926',1,1),('835e84ef-f73d-11e5-8662-0050568e0e15','01123','1415926',1,1),('836b07b8-f73d-11e5-8662-0050568e0e15','01124','1415926',1,1),('8373c820-f73d-11e5-8662-0050568e0e15','01125','1415926',1,1),('837cc202-f73d-11e5-8662-0050568e0e15','01126','1415926',1,1),('8386227d-f73d-11e5-8662-0050568e0e15','01127','1415926',1,1),('8392ef55-f73d-11e5-8662-0050568e0e15','01128','1415926',1,1),('83a2c6ba-f73d-11e5-8662-0050568e0e15','01129','1415926',1,1),('83ac5ce0-f73d-11e5-8662-0050568e0e15','01130','1415926',1,1),('83b9134b-f73d-11e5-8662-0050568e0e15','01131','1415926',1,1),('83c3483e-f73d-11e5-8662-0050568e0e15','01132','1415926',1,1),('83cc5586-f73d-11e5-8662-0050568e0e15','01133','1415926',1,1),('83d8d0f9-f73d-11e5-8662-0050568e0e15','01134','1415926',1,1),('83e162cb-f73d-11e5-8662-0050568e0e15','01135','1415926',1,1),('83eaeef7-f73d-11e5-8662-0050568e0e15','01136','1415926',1,1),('83f7c5bf-f73d-11e5-8662-0050568e0e15','01137','1415926',1,1),('83ff90f8-f73d-11e5-8662-0050568e0e15','01138','1415926',1,1),('840c16a2-f73d-11e5-8662-0050568e0e15','01139','1415926',1,1),('8416d3e5-f73d-11e5-8662-0050568e0e15','01140','1415926',1,1),('84203f3f-f73d-11e5-8662-0050568e0e15','01141','1415926',1,1),('84286fb5-f73d-11e5-8662-0050568e0e15','01142','1415926',1,1),('84324658-f73d-11e5-8662-0050568e0e15','01143','1415926',1,1),('843f3a48-f73d-11e5-8662-0050568e0e15','01144','1415926',1,1),('844a1922-f73d-11e5-8662-0050568e0e15','01145','1415926',1,1),('84587628-f73d-11e5-8662-0050568e0e15','01146','1415926',1,1),('8460b75f-f73d-11e5-8662-0050568e0e15','01147','1415926',1,1),('846deac0-f73d-11e5-8662-0050568e0e15','01148','1415926',1,1),('8478ed2f-f73d-11e5-8662-0050568e0e15','01149','1415926',1,1),('8484481a-f73d-11e5-8662-0050568e0e15','01150','1415926',1,1),('848defa1-f73d-11e5-8662-0050568e0e15','01151','1415926',1,1),('849a6d05-f73d-11e5-8662-0050568e0e15','01152','1415926',1,1),('84a4d2d1-f73d-11e5-8662-0050568e0e15','01153','1415926',1,1),('84ad8062-f73d-11e5-8662-0050568e0e15','01154','1415926',1,1),('84b6f82b-f73d-11e5-8662-0050568e0e15','01155','1415926',1,1),('84bf422a-f73d-11e5-8662-0050568e0e15','01156','1415926',1,1),('84cae938-f73d-11e5-8662-0050568e0e15','01157','1415926',1,1),('84d59464-f73d-11e5-8662-0050568e0e15','01158','1415926',1,1),('84e20049-f73d-11e5-8662-0050568e0e15','01159','1415926',1,1),('84ea3991-f73d-11e5-8662-0050568e0e15','01160','1415926',1,1),('84f274ef-f73d-11e5-8662-0050568e0e15','01161','1415926',1,1),('84fd4800-f73d-11e5-8662-0050568e0e15','01162','1415926',1,1),('8508dc1c-f73d-11e5-8662-0050568e0e15','01163','1415926',1,1),('85111818-f73d-11e5-8662-0050568e0e15','01164','1415926',1,1),('8520808b-f73d-11e5-8662-0050568e0e15','01165','1415926',1,1),('85294b0c-f73d-11e5-8662-0050568e0e15','01166','1415926',1,1),('85326d2f-f73d-11e5-8662-0050568e0e15','01167','1415926',1,1),('853fb071-f73d-11e5-8662-0050568e0e15','01168','1415926',1,1),('854aa015-f73d-11e5-8662-0050568e0e15','01169','1415926',1,1),('855747a1-f73d-11e5-8662-0050568e0e15','01170','1415926',1,1),('85629872-f73d-11e5-8662-0050568e0e15','01171','1415926',1,1),('856f31d6-f73d-11e5-8662-0050568e0e15','01172','1415926',1,1),('85775a8b-f73d-11e5-8662-0050568e0e15','01173','1415926',1,1),('857e3f2a-f73d-11e5-8662-0050568e0e15','01174','1415926',1,1),('8586454e-f73d-11e5-8662-0050568e0e15','01175','1415926',1,1),('858eb93e-f73d-11e5-8662-0050568e0e15','01176','1415926',1,1),('859680c0-f73d-11e5-8662-0050568e0e15','01177','1415926',1,1),('85a0d5d5-f73d-11e5-8662-0050568e0e15','01178','1415926',1,1),('85ac9071-f73d-11e5-8662-0050568e0e15','01179','1415926',1,1),('85b6a118-f73d-11e5-8662-0050568e0e15','01180','1415926',1,1),('85c54e6e-f73d-11e5-8662-0050568e0e15','01181','1415926',1,1),('85d28bd4-f73d-11e5-8662-0050568e0e15','01182','1415926',1,1),('85dc903a-f73d-11e5-8662-0050568e0e15','01183','1415926',1,1),('85eb8c2b-f73d-11e5-8662-0050568e0e15','01184','1415926',1,1),('85f8c04b-f73d-11e5-8662-0050568e0e15','01185','1415926',1,1),('8604c096-f73d-11e5-8662-0050568e0e15','01186','1415926',1,1),('860e653d-f73d-11e5-8662-0050568e0e15','01187','1415926',1,1),('861a61a8-f73d-11e5-8662-0050568e0e15','01188','1415926',1,1),('862a00c6-f73d-11e5-8662-0050568e0e15','01189','1415926',1,1),('86329298-f73d-11e5-8662-0050568e0e15','01190','1415926',1,1),('863a488b-f73d-11e5-8662-0050568e0e15','01191','1415926',1,1),('864503c3-f73d-11e5-8662-0050568e0e15','01192','1415926',1,1),('8651ad21-f73d-11e5-8662-0050568e0e15','01193','1415926',1,1),('865b7e99-f73d-11e5-8662-0050568e0e15','01194','1415926',1,1),('8664747a-f73d-11e5-8662-0050568e0e15','01195','1415926',1,1),('86732015-f73d-11e5-8662-0050568e0e15','01196','1415926',1,1),('867eb195-f73d-11e5-8662-0050568e0e15','01197','1415926',1,1),('86891ea1-f73d-11e5-8662-0050568e0e15','01198','1415926',1,1),('8693bb54-f73d-11e5-8662-0050568e0e15','01199','1415926',1,1),('86a6c721-f73d-11e5-8662-0050568e0e15','01200','1415926',1,1),('86b9cb42-f73d-11e5-8662-0050568e0e15','01201','1415926',1,1),('86c6d752-f73d-11e5-8662-0050568e0e15','01202','1415926',1,1),('86d1a47f-f73d-11e5-8662-0050568e0e15','01203','1415926',1,1),('86df6756-f73d-11e5-8662-0050568e0e15','01204','1415926',1,1),('86e7df2e-f73d-11e5-8662-0050568e0e15','01205','1415926',1,1),('86f5078c-f73d-11e5-8662-0050568e0e15','01206','1415926',1,1),('8703df19-f73d-11e5-8662-0050568e0e15','01207','1415926',1,1),('870e97e0-f73d-11e5-8662-0050568e0e15','01209','1415926',1,1),('871801ef-f73d-11e5-8662-0050568e0e15','01210','1415926',1,1),('87243535-f73d-11e5-8662-0050568e0e15','01211','1415926',1,1),('872c6c92-f73d-11e5-8662-0050568e0e15','01212','1415926',1,1),('873641f5-f73d-11e5-8662-0050568e0e15','01213','1415926',1,1),('8743747c-f73d-11e5-8662-0050568e0e15','01214','1415926',1,1),('874d73f1-f73d-11e5-8662-0050568e0e15','01215','1415926',1,1),('8755d09d-f73d-11e5-8662-0050568e0e15','01216','1415926',1,1),('8762544f-f73d-11e5-8662-0050568e0e15','01217','1415926',1,1),('876abb40-f73d-11e5-8662-0050568e0e15','01218','1415926',1,1),('87735be2-f73d-11e5-8662-0050568e0e15','01219','1415926',1,1),('877bac88-f73d-11e5-8662-0050568e0e15','01220','1415926',1,1),('878409a8-f73d-11e5-8662-0050568e0e15','01221','1415926',1,1),('878cfdc9-f73d-11e5-8662-0050568e0e15','01222','1415926',1,1),('879950b6-f73d-11e5-8662-0050568e0e15','01223','1415926',1,1),('87a26164-f73d-11e5-8662-0050568e0e15','01224','1415926',1,1),('87b08156-f73d-11e5-8662-0050568e0e15','01225','1415926',1,1),('87ba27c5-f73d-11e5-8662-0050568e0e15','01226','1415926',1,1),('87c3d6a1-f73d-11e5-8662-0050568e0e15','01227','1415926',1,1),('87cfb3d1-f73d-11e5-8662-0050568e0e15','01228','1415926',1,1),('87d82e16-f73d-11e5-8662-0050568e0e15','01229','1415926',1,1),('87e01b23-f73d-11e5-8662-0050568e0e15','01230','1415926',1,1),('87ef013c-f73d-11e5-8662-0050568e0e15','01231','1415926',1,1),('87f8fd72-f73d-11e5-8662-0050568e0e15','01232','1415926',1,1),('8802ce55-f73d-11e5-8662-0050568e0e15','01233','1415926',1,1),('880e1633-f73d-11e5-8662-0050568e0e15','01234','1415926',1,1),('881635b2-f73d-11e5-8662-0050568e0e15','01235','1415926',1,1),('881f6a33-f73d-11e5-8662-0050568e0e15','01236','1415926',1,1),('88288e32-f73d-11e5-8662-0050568e0e15','01237','1415926',1,1),('883486d7-f73d-11e5-8662-0050568e0e15','01238','1415926',1,1),('883d1964-f73d-11e5-8662-0050568e0e15','01239','1415926',1,1),('884507a4-f73d-11e5-8662-0050568e0e15','01240','1415926',1,1),('884ed6f4-f73d-11e5-8662-0050568e0e15','01241','1415926',1,1),('88575f55-f73d-11e5-8662-0050568e0e15','01242','1415926',1,1),('88666bcf-f73d-11e5-8662-0050568e0e15','01243','1415926',1,1),('8870f2a7-f73d-11e5-8662-0050568e0e15','01244','1415926',1,1),('887b95b1-f73d-11e5-8662-0050568e0e15','01245','1415926',1,1),('8883be3a-f73d-11e5-8662-0050568e0e15','01246','1415926',1,1),('888c1f44-f73d-11e5-8662-0050568e0e15','01247','1415926',1,1),('88965aee-f73d-11e5-8662-0050568e0e15','01248','1415926',1,1),('88a4d074-f73d-11e5-8662-0050568e0e15','01249','1415926',1,1),('88adcbf2-f73d-11e5-8662-0050568e0e15','01250','1415926',1,1),('88b9df8f-f73d-11e5-8662-0050568e0e15','01251','1415926',1,1),('88c229c7-f73d-11e5-8662-0050568e0e15','01252','1415926',1,1),('88caddc8-f73d-11e5-8662-0050568e0e15','01253','1415926',1,1),('88d39fba-f73d-11e5-8662-0050568e0e15','01254','1415926',1,1),('88dcac19-f73d-11e5-8662-0050568e0e15','01255','1415926',1,1),('88e92c1f-f73d-11e5-8662-0050568e0e15','01256','1415926',1,1),('88f035d9-f73d-11e5-8662-0050568e0e15','01257','1415926',1,1),('88f9d512-f73d-11e5-8662-0050568e0e15','01258','1415926',1,1),('890660b9-f73d-11e5-8662-0050568e0e15','01259','1415926',1,1),('89127a7c-f73d-11e5-8662-0050568e0e15','01260','1415926',1,1),('891f0a4c-f73d-11e5-8662-0050568e0e15','01261','1415926',1,1),('8928bd32-f73d-11e5-8662-0050568e0e15','01262','1415926',1,1),('8936e0bd-f73d-11e5-8662-0050568e0e15','01263','1415926',1,1),('89421e84-f73d-11e5-8662-0050568e0e15','01264','1415926',1,1),('89503368-f73d-11e5-8662-0050568e0e15','01265','1415926',1,1),('8958ca5a-f73d-11e5-8662-0050568e0e15','01266','1415926',1,1),('8965a6a5-f73d-11e5-8662-0050568e0e15','01267','1415926',1,1),('89754b52-f73d-11e5-8662-0050568e0e15','01268','1415926',1,1),('897ec407-f73d-11e5-8662-0050568e0e15','01269','1415926',1,1),('8989b6ca-f73d-11e5-8662-0050568e0e15','01270','1415926',1,1),('89949d71-f73d-11e5-8662-0050568e0e15','01271','1415926',1,1),('899de83a-f73d-11e5-8662-0050568e0e15','01272','1415926',1,1),('89a6d03b-f73d-11e5-8662-0050568e0e15','01273','1415926',1,1),('89b3c72a-f73d-11e5-8662-0050568e0e15','01274','1415926',1,1),('89bde5cd-f73d-11e5-8662-0050568e0e15','01275','1415926',1,1),('89cc7ceb-f73d-11e5-8662-0050568e0e15','01276','1415926',1,1),('89d5cb03-f73d-11e5-8662-0050568e0e15','01277','1415926',1,1),('89deb0b4-f73d-11e5-8662-0050568e0e15','01278','1415926',1,1),('89ea1cee-f73d-11e5-8662-0050568e0e15','01279','1415926',1,1),('89f2b41b-f73d-11e5-8662-0050568e0e15','01280','1415926',1,1),('89fb3d32-f73d-11e5-8662-0050568e0e15','01281','1415926',1,1),('8a04f1c5-f73d-11e5-8662-0050568e0e15','01282','1415926',1,1),('8a117513-f73d-11e5-8662-0050568e0e15','01283','1415926',1,1),('8a1a137f-f73d-11e5-8662-0050568e0e15','01284','1415926',1,1),('8a24e5cb-f73d-11e5-8662-0050568e0e15','01285','1415926',1,1),('8a30b27e-f73d-11e5-8662-0050568e0e15','01286','1415926',1,1),('8a3c4877-f73d-11e5-8662-0050568e0e15','01287','1415926',1,1),('8a46da25-f73d-11e5-8662-0050568e0e15','01288','1415926',1,1),('8a50faf1-f73d-11e5-8662-0050568e0e15','01289','1415926',1,1),('8a5995cf-f73d-11e5-8662-0050568e0e15','01290','1415926',1,1),('8a65134c-f73d-11e5-8662-0050568e0e15','01291','1415926',1,1),('8a72275e-f73d-11e5-8662-0050568e0e15','01292','1415926',1,1),('8a7ec5db-f73d-11e5-8662-0050568e0e15','01293','1415926',1,1),('8a880a6f-f73d-11e5-8662-0050568e0e15','01294','1415926',1,1),('8a948836-f73d-11e5-8662-0050568e0e15','01295','1415926',1,1),('8a9dffd8-f73d-11e5-8662-0050568e0e15','01296','1415926',1,1),('8aa80fd8-f73d-11e5-8662-0050568e0e15','01297','1415926',1,1),('8ab2f8d7-f73d-11e5-8662-0050568e0e15','01298','1415926',1,1),('8abd5982-f73d-11e5-8662-0050568e0e15','01299','1415926',1,1),('8ac68d56-f73d-11e5-8662-0050568e0e15','01300','1415926',1,1),('8ad433cc-f73d-11e5-8662-0050568e0e15','01301','1415926',1,1),('8adc3f75-f73d-11e5-8662-0050568e0e15','01302','1415926',1,1),('8ae4b9ec-f73d-11e5-8662-0050568e0e15','01303','1415926',1,1),('8aef1454-f73d-11e5-8662-0050568e0e15','01304','1415926',1,1),('8af7cb86-f73d-11e5-8662-0050568e0e15','01305','1415926',1,1),('8b060775-f73d-11e5-8662-0050568e0e15','01306','1415926',1,1),('8b157b3d-f73d-11e5-8662-0050568e0e15','01307','1415926',1,1),('8b1dba33-f73d-11e5-8662-0050568e0e15','01308','1415926',1,1),('8b2b6824-f73d-11e5-8662-0050568e0e15','01309','1415926',1,1),('8b3a2d69-f73d-11e5-8662-0050568e0e15','01310','1415926',1,1),('8b44318c-f73d-11e5-8662-0050568e0e15','01311','1415926',1,1),('8b4db6f7-f73d-11e5-8662-0050568e0e15','01312','1415926',1,1),('8b596b08-f73d-11e5-8662-0050568e0e15','01313','1415926',1,1),('8b618e75-f73d-11e5-8662-0050568e0e15','01314','1415926',1,1),('8b6ab1b1-f73d-11e5-8662-0050568e0e15','01315','1415926',1,1),('8b734ffa-f73d-11e5-8662-0050568e0e15','01316','1415926',1,1),('8b7fb3dc-f73d-11e5-8662-0050568e0e15','01317','1415926',1,1),('8b883940-f73d-11e5-8662-0050568e0e15','01318','1415926',1,1),('8b91c51e-f73d-11e5-8662-0050568e0e15','01319','1415926',1,1),('8b9d464a-f73d-11e5-8662-0050568e0e15','01320','1415926',1,1),('8ba76f4f-f73d-11e5-8662-0050568e0e15','01321','1415926',1,1),('8bb184fd-f73d-11e5-8662-0050568e0e15','01322','1415926',1,1),('8bbcc776-f73d-11e5-8662-0050568e0e15','01323','1415926',1,1),('8bc6ae58-f73d-11e5-8662-0050568e0e15','01324','1415926',1,1),('8bcf570c-f73d-11e5-8662-0050568e0e15','01325','1415926',1,1),('8bd9d0a2-f73d-11e5-8662-0050568e0e15','01326','1415926',1,1),('8be5bfd0-f73d-11e5-8662-0050568e0e15','01327','1415926',1,1),('8bee694c-f73d-11e5-8662-0050568e0e15','01328','1415926',1,1),('8bf67dc6-f73d-11e5-8662-0050568e0e15','01329','1415926',1,1),('8c052396-f73d-11e5-8662-0050568e0e15','01330','1415926',1,1),('8c0d52a0-f73d-11e5-8662-0050568e0e15','01331','1415926',1,1),('8c16e26a-f73d-11e5-8662-0050568e0e15','01332','1415926',1,1),('8c2461c3-f73d-11e5-8662-0050568e0e15','01333','1415926',1,1),('8c2ea847-f73d-11e5-8662-0050568e0e15','01334','1415926',1,1),('8c389ba2-f73d-11e5-8662-0050568e0e15','01335','1415926',1,1),('8c43b2e0-f73d-11e5-8662-0050568e0e15','01336','1415926',1,1),('8c4b481a-f73d-11e5-8662-0050568e0e15','01337','1415926',1,1),('8c542d23-f73d-11e5-8662-0050568e0e15','01338','1415926',1,1),('8c5d3bff-f73d-11e5-8662-0050568e0e15','01339','1415926',1,1),('8c66701b-f73d-11e5-8662-0050568e0e15','01340','1415926',1,1),('8c727853-f73d-11e5-8662-0050568e0e15','01341','1415926',1,1),('8c7ba5c6-f73d-11e5-8662-0050568e0e15','01342','1415926',1,1),('8c8510f0-f73d-11e5-8662-0050568e0e15','01343','1415926',1,1),('8c91a8f3-f73d-11e5-8662-0050568e0e15','01344','1415926',1,1),('8c9bc2de-f73d-11e5-8662-0050568e0e15','01346','1415926',1,1),('8ca5d25d-f73d-11e5-8662-0050568e0e15','01347','1415926',1,1),('8cb0f847-f73d-11e5-8662-0050568e0e15','01348','1415926',1,1),('8cb911d8-f73d-11e5-8662-0050568e0e15','01349','1415926',1,1),('8cc4da5e-f73d-11e5-8662-0050568e0e15','01350','1415926',1,1),('8cd0390e-f73d-11e5-8662-0050568e0e15','01351','1415926',1,1),('8cda411c-f73d-11e5-8662-0050568e0e15','01352','1415926',1,1),('8ce3d092-f73d-11e5-8662-0050568e0e15','01353','1415926',1,1),('8cef639c-f73d-11e5-8662-0050568e0e15','01354','1415926',1,1),('8cf9063f-f73d-11e5-8662-0050568e0e15','01355','1415926',1,1),('8d030a0f-f73d-11e5-8662-0050568e0e15','01356','1415926',1,1),('8d0f0428-f73d-11e5-8662-0050568e0e15','01357','1415926',1,1),('8d1982d5-f73d-11e5-8662-0050568e0e15','01358','1415926',1,1),('8d2a2967-f73d-11e5-8662-0050568e0e15','01359','1415926',1,1),('8d35e2c0-f73d-11e5-8662-0050568e0e15','01360','1415926',1,1),('8d4137de-f73d-11e5-8662-0050568e0e15','01361','1415926',1,1),('8d4d3973-f73d-11e5-8662-0050568e0e15','01362','1415926',1,1),('8d54c5e3-f73d-11e5-8662-0050568e0e15','01363','1415926',1,1),('8d60ee50-f73d-11e5-8662-0050568e0e15','01364','1415926',1,1),('8d6c651d-f73d-11e5-8662-0050568e0e15','01365','1415926',1,1),('8d749d8f-f73d-11e5-8662-0050568e0e15','01366','1415926',1,1),('8d7dff40-f73d-11e5-8662-0050568e0e15','01367','1415926',1,1),('8d87a389-f73d-11e5-8662-0050568e0e15','01368','1415926',1,1),('8d928ef4-f73d-11e5-8662-0050568e0e15','01369','1415926',1,1),('8d9c8b7b-f73d-11e5-8662-0050568e0e15','01370','1415926',1,1),('8da63eac-f73d-11e5-8662-0050568e0e15','01371','1415926',1,1),('8db2328f-f73d-11e5-8662-0050568e0e15','01372','1415926',1,1),('8dbafc28-f73d-11e5-8662-0050568e0e15','01373','1415926',1,1),('8dc33c8d-f73d-11e5-8662-0050568e0e15','01374','1415926',1,1),('8dce8d57-f73d-11e5-8662-0050568e0e15','01375','1415926',1,1),('8dda0893-f73d-11e5-8662-0050568e0e15','01376','1415926',1,1),('8de3028b-f73d-11e5-8662-0050568e0e15','01377','1415926',1,1),('8dedfca2-f73d-11e5-8662-0050568e0e15','01378','1415926',1,1),('8df92cce-f73d-11e5-8662-0050568e0e15','01379','1415926',1,1),('8e014427-f73d-11e5-8662-0050568e0e15','01380','1415926',1,1),('8e0ac1f6-f73d-11e5-8662-0050568e0e15','01381','1415926',1,1),('8e169fb6-f73d-11e5-8662-0050568e0e15','01382','1415926',1,1),('8e1fc77d-f73d-11e5-8662-0050568e0e15','01383','1415926',1,1),('8e27bad8-f73d-11e5-8662-0050568e0e15','01384','1415926',1,1),('8e3313f3-f73d-11e5-8662-0050568e0e15','01385','1415926',1,1),('8e3ed556-f73d-11e5-8662-0050568e0e15','01386','1415926',1,1),('8e48d1e6-f73d-11e5-8662-0050568e0e15','01387','1415926',1,1),('8e524e20-f73d-11e5-8662-0050568e0e15','01388','1415926',1,1),('8e615537-f73d-11e5-8662-0050568e0e15','01389','1415926',1,1),('8e70000c-f73d-11e5-8662-0050568e0e15','01390','1415926',1,1),('8e787a7f-f73d-11e5-8662-0050568e0e15','01391','1415926',1,1),('8e7f7595-f73d-11e5-8662-0050568e0e15','01392','1415926',1,1),('8e886051-f73d-11e5-8662-0050568e0e15','01393','1415926',1,1),('8e9526eb-f73d-11e5-8662-0050568e0e15','01394','1415926',1,1),('8e9e2765-f73d-11e5-8662-0050568e0e15','01395','1415926',1,1),('8ea6c158-f73d-11e5-8662-0050568e0e15','01396','1415926',1,1),('8eb468ca-f73d-11e5-8662-0050568e0e15','01397','1415926',1,1),('8ebda670-f73d-11e5-8662-0050568e0e15','01398','1415926',1,1),('8ec5df90-f73d-11e5-8662-0050568e0e15','01399','1415926',1,1),('8ecee8dc-f73d-11e5-8662-0050568e0e15','01400','1415926',1,1),('8eddb586-f73d-11e5-8662-0050568e0e15','01401','1415926',1,1),('8ee4e7d4-f73d-11e5-8662-0050568e0e15','01402','1415926',1,1),('8eef1595-f73d-11e5-8662-0050568e0e15','01403','1415926',1,1),('8ef8f990-f73d-11e5-8662-0050568e0e15','01404','1415926',1,1),('8f03647c-f73d-11e5-8662-0050568e0e15','01405','1415926',1,1),('8f0b5025-f73d-11e5-8662-0050568e0e15','01406','1415926',1,1),('8f177a2f-f73d-11e5-8662-0050568e0e15','01407','1415926',1,1),('8f21bdb2-f73d-11e5-8662-0050568e0e15','01408','1415926',1,1),('8f2d3134-f73d-11e5-8662-0050568e0e15','01409','1415926',1,1),('8f383918-f73d-11e5-8662-0050568e0e15','01410','1415926',1,1),('8f41db5e-f73d-11e5-8662-0050568e0e15','01411','1415926',1,1),('8f4b665c-f73d-11e5-8662-0050568e0e15','01412','1415926',1,1),('8f56011c-f73d-11e5-8662-0050568e0e15','01413','1415926',1,1),('8f5e81f1-f73d-11e5-8662-0050568e0e15','01414','1415926',1,1),('8f67a7d7-f73d-11e5-8662-0050568e0e15','01415','1415926',1,1),('8f70ec9b-f73d-11e5-8662-0050568e0e15','01416','1415926',1,1),('8f7a09ff-f73d-11e5-8662-0050568e0e15','01417','1415926',1,1),('8f82832d-f73d-11e5-8662-0050568e0e15','01418','1415926',1,1),('8f8eeab4-f73d-11e5-8662-0050568e0e15','01419','1415926',1,1),('8f995f22-f73d-11e5-8662-0050568e0e15','01420','1415926',1,1),('8fa176e1-f73d-11e5-8662-0050568e0e15','01421','1415926',1,1),('8fae2446-f73d-11e5-8662-0050568e0e15','01422','1415926',1,1),('8fb86616-f73d-11e5-8662-0050568e0e15','01423','1415926',1,1),('8fc6b8d2-f73d-11e5-8662-0050568e0e15','01424','1415926',1,1),('8fd4f61b-f73d-11e5-8662-0050568e0e15','01425','1415926',1,1),('8fdd28f0-f73d-11e5-8662-0050568e0e15','01426','1415926',1,1),('8fe46e13-f73d-11e5-8662-0050568e0e15','01427','1415926',1,1),('8feebbaf-f73d-11e5-8662-0050568e0e15','01428','1415926',1,1),('8ff8276e-f73d-11e5-8662-0050568e0e15','01429','1415926',1,1),('9004f49e-f73d-11e5-8662-0050568e0e15','01430','1415926',1,1),('900f1ff5-f73d-11e5-8662-0050568e0e15','01431','1415926',1,1),('901b751d-f73d-11e5-8662-0050568e0e15','01432','1415926',1,1),('9026858c-f73d-11e5-8662-0050568e0e15','01433','1415926',1,1),('90350d74-f73d-11e5-8662-0050568e0e15','01434','1415926',1,1),('903d5c5d-f73d-11e5-8662-0050568e0e15','01435','1415926',1,1),('9048c362-f73d-11e5-8662-0050568e0e15','01436','1415926',1,1),('9053a197-f73d-11e5-8662-0050568e0e15','01437','1415926',1,1),('905c8af6-f73d-11e5-8662-0050568e0e15','01438','1415926',1,1),('9065c603-f73d-11e5-8662-0050568e0e15','01439','1415926',1,1),('9075021c-f73d-11e5-8662-0050568e0e15','01440','1415926',1,1),('9080ed44-f73d-11e5-8662-0050568e0e15','01441','1415926',1,1),('9089c833-f73d-11e5-8662-0050568e0e15','01442','1415926',1,1),('90986b5f-f73d-11e5-8662-0050568e0e15','01443','1415926',1,1),('90a1217c-f73d-11e5-8662-0050568e0e15','01444','1415926',1,1),('90abed87-f73d-11e5-8662-0050568e0e15','01445','1415926',1,1),('90b7c959-f73d-11e5-8662-0050568e0e15','01446','1415926',1,1),('90c0b708-f73d-11e5-8662-0050568e0e15','01447','1415926',1,1),('90cbf2d4-f73d-11e5-8662-0050568e0e15','01448','1415926',1,1),('90d8e272-f73d-11e5-8662-0050568e0e15','01449','1415926',1,1),('90e1491a-f73d-11e5-8662-0050568e0e15','01450','1415926',1,1),('90e917b9-f73d-11e5-8662-0050568e0e15','01451','1415926',1,1),('90f6177f-f73d-11e5-8662-0050568e0e15','01452','1415926',1,1),('91004fb8-f73d-11e5-8662-0050568e0e15','01453','1415926',1,1),('9109353f-f73d-11e5-8662-0050568e0e15','01454','1415926',1,1),('9115526e-f73d-11e5-8662-0050568e0e15','01455','1415926',1,1),('9124f190-f73d-11e5-8662-0050568e0e15','01456','1415926',1,1),('912dd34d-f73d-11e5-8662-0050568e0e15','01457','1415926',1,1),('9135da66-f73d-11e5-8662-0050568e0e15','01458','1415926',1,1),('913e3e4a-f73d-11e5-8662-0050568e0e15','01459','1415926',1,1),('914861cd-f73d-11e5-8662-0050568e0e15','01460','1415926',1,1),('91520667-f73d-11e5-8662-0050568e0e15','01461','1415926',1,1),('915bf159-f73d-11e5-8662-0050568e0e15','01462','1415926',1,1),('9165896a-f73d-11e5-8662-0050568e0e15','01463','1415926',1,1),('916f7fbb-f73d-11e5-8662-0050568e0e15','01464','1415926',1,1),('9180d2b7-f73d-11e5-8662-0050568e0e15','01465','1415926',1,1),('918c39f4-f73d-11e5-8662-0050568e0e15','01466','1415926',1,1),('919620e3-f73d-11e5-8662-0050568e0e15','01467','1415926',1,1),('91a1e1e0-f73d-11e5-8662-0050568e0e15','01468','1415926',1,1),('91ab8a57-f73d-11e5-8662-0050568e0e15','01469','1415926',1,1),('91b6fb22-f73d-11e5-8662-0050568e0e15','01470','1415926',1,1),('91c1467d-f73d-11e5-8662-0050568e0e15','01471','1415926',1,1),('91ca3c99-f73d-11e5-8662-0050568e0e15','01472','1415926',1,1),('91d2eab5-f73d-11e5-8662-0050568e0e15','01473','1415926',1,1),('91e05eb1-f73d-11e5-8662-0050568e0e15','01474','1415926',1,1),('91e8353f-f73d-11e5-8662-0050568e0e15','01475','1415926',1,1),('91f027c0-f73d-11e5-8662-0050568e0e15','01476','1415926',1,1),('91fb4cfb-f73d-11e5-8662-0050568e0e15','01477','1415926',1,1),('9207420d-f73d-11e5-8662-0050568e0e15','01478','1415926',1,1),('9210a624-f73d-11e5-8662-0050568e0e15','01479','1415926',1,1),('921ea33e-f73d-11e5-8662-0050568e0e15','01480','1415926',1,1),('9227f1c4-f73d-11e5-8662-0050568e0e15','01481','1415926',1,1),('92316ec8-f73d-11e5-8662-0050568e0e15','01483','1415926',1,1),('923e0a33-f73d-11e5-8662-0050568e0e15','01484','1415926',1,1),('9247267a-f73d-11e5-8662-0050568e0e15','01485','1415926',1,1),('925116fb-f73d-11e5-8662-0050568e0e15','01486','1415926',1,1),('9258371e-f73d-11e5-8662-0050568e0e15','01487','1415926',1,1),('9261ca39-f73d-11e5-8662-0050568e0e15','01488','1415926',1,1),('926cdfc3-f73d-11e5-8662-0050568e0e15','01489','1415926',1,1),('92760ce4-f73d-11e5-8662-0050568e0e15','01490','1415926',1,1),('927edcc6-f73d-11e5-8662-0050568e0e15','01491','1415926',1,1),('92878fbb-f73d-11e5-8662-0050568e0e15','01492','1415926',1,1),('92945ffd-f73d-11e5-8662-0050568e0e15','01493','1415926',1,1),('929fd002-f73d-11e5-8662-0050568e0e15','01494','1415926',1,1),('92a975d6-f73d-11e5-8662-0050568e0e15','01495','1415926',1,1),('92b360d4-f73d-11e5-8662-0050568e0e15','01496','1415926',1,1),('92bdc9dc-f73d-11e5-8662-0050568e0e15','01497','1415926',1,1),('92caaad0-f73d-11e5-8662-0050568e0e15','01498','1415926',1,1),('92d2781c-f73d-11e5-8662-0050568e0e15','01499','1415926',1,1),('92da6f1b-f73d-11e5-8662-0050568e0e15','01500','1415926',1,1),('92e3d427-f73d-11e5-8662-0050568e0e15','01501','1415926',1,1),('92ed525d-f73d-11e5-8662-0050568e0e15','01502','1415926',1,1),('92f59636-f73d-11e5-8662-0050568e0e15','01503','1415926',1,1),('93022ad5-f73d-11e5-8662-0050568e0e15','01504','1415926',1,1),('930d13ca-f73d-11e5-8662-0050568e0e15','01505','1415926',1,1),('9318b5e2-f73d-11e5-8662-0050568e0e15','01506','1415926',1,1),('932171ce-f73d-11e5-8662-0050568e0e15','01507','1415926',1,1),('932c71a2-f73d-11e5-8662-0050568e0e15','01508','1415926',1,1),('9337ef07-f73d-11e5-8662-0050568e0e15','01509','1415926',1,1),('93410665-f73d-11e5-8662-0050568e0e15','01510','1415926',1,1),('93498ad4-f73d-11e5-8662-0050568e0e15','01511','1415926',1,1),('9353580d-f73d-11e5-8662-0050568e0e15','01512','1415926',1,1),('9361d8d3-f73d-11e5-8662-0050568e0e15','01513','1415926',1,1),('936db790-f73d-11e5-8662-0050568e0e15','01514','1415926',1,1),('93766881-f73d-11e5-8662-0050568e0e15','01515','1415926',1,1),('93860ad1-f73d-11e5-8662-0050568e0e15','01516','1415926',1,1),('938ed8e4-f73d-11e5-8662-0050568e0e15','01517','1415926',1,1),('9398785a-f73d-11e5-8662-0050568e0e15','01518','1415926',1,1),('93a559fb-f73d-11e5-8662-0050568e0e15','01519','1415926',1,1),('93b0d85f-f73d-11e5-8662-0050568e0e15','01520','1415926',1,1),('93c008d1-f73d-11e5-8662-0050568e0e15','01521','1415926',1,1),('93cbf77d-f73d-11e5-8662-0050568e0e15','01522','1415926',1,1),('93d5b613-f73d-11e5-8662-0050568e0e15','01523','1415926',1,1),('93e3b70c-f73d-11e5-8662-0050568e0e15','01524','1415926',1,1),('93ee118a-f73d-11e5-8662-0050568e0e15','01525','1415926',1,1),('93fbe035-f73d-11e5-8662-0050568e0e15','01526','1415926',1,1),('94067796-f73d-11e5-8662-0050568e0e15','01527','1415926',1,1),('9412adad-f73d-11e5-8662-0050568e0e15','01528','1415926',1,1),('941c88f1-f73d-11e5-8662-0050568e0e15','01529','1415926',1,1),('94269b31-f73d-11e5-8662-0050568e0e15','01530','1415926',1,1),('942feabd-f73d-11e5-8662-0050568e0e15','01531','1415926',1,1),('943a9f59-f73d-11e5-8662-0050568e0e15','01532','1415926',1,1),('9448a282-f73d-11e5-8662-0050568e0e15','01533','1415926',1,1),('94516e06-f73d-11e5-8662-0050568e0e15','01534','1415926',1,1),('945adee5-f73d-11e5-8662-0050568e0e15','01535','1415926',1,1),('94688c07-f73d-11e5-8662-0050568e0e15','01536','1415926',1,1),('947119a5-f73d-11e5-8662-0050568e0e15','01537','1415926',1,1),('9478f455-f73d-11e5-8662-0050568e0e15','01538','1415926',1,1),('94825bc6-f73d-11e5-8662-0050568e0e15','01539','1415926',1,1),('948f778c-f73d-11e5-8662-0050568e0e15','01540','1415926',1,1),('9498dde5-f73d-11e5-8662-0050568e0e15','01541','1415926',1,1),('94a35d91-f73d-11e5-8662-0050568e0e15','01542','1415926',1,1),('94aeb3dc-f73d-11e5-8662-0050568e0e15','01543','1415926',1,1),('94b8adcd-f73d-11e5-8662-0050568e0e15','01544','1415926',1,1),('94c0a5a3-f73d-11e5-8662-0050568e0e15','01545','1415926',1,1),('94c854a0-f73d-11e5-8662-0050568e0e15','01546','1415926',1,1),('94d26654-f73d-11e5-8662-0050568e0e15','01547','1415926',1,1),('94de6f0b-f73d-11e5-8662-0050568e0e15','01548','1415926',1,1),('94eddbb5-f73d-11e5-8662-0050568e0e15','01549','1415926',1,1),('94f95108-f73d-11e5-8662-0050568e0e15','01550','1415926',1,1),('95040447-f73d-11e5-8662-0050568e0e15','01551','1415926',1,1),('950d305b-f73d-11e5-8662-0050568e0e15','01552','1415926',1,1),('9515570c-f73d-11e5-8662-0050568e0e15','01553','1415926',1,1),('951f597b-f73d-11e5-8662-0050568e0e15','01554','1415926',1,1),('952b9a06-f73d-11e5-8662-0050568e0e15','01555','1415926',1,1),('953425d5-f73d-11e5-8662-0050568e0e15','01556','1415926',1,1),('953c68ba-f73d-11e5-8662-0050568e0e15','01557','1415926',1,1),('9545b4d1-f73d-11e5-8662-0050568e0e15','01558','1415926',1,1),('9550e3ac-f73d-11e5-8662-0050568e0e15','01559','1415926',1,1),('955a7a1d-f73d-11e5-8662-0050568e0e15','01560','1415926',1,1),('95628e34-f73d-11e5-8662-0050568e0e15','01561','1415926',1,1),('956bc4a0-f73d-11e5-8662-0050568e0e15','01562','1415926',1,1),('95755d27-f73d-11e5-8662-0050568e0e15','01563','1415926',1,1),('9582da71-f73d-11e5-8662-0050568e0e15','01564','1415926',1,1),('958d3c59-f73d-11e5-8662-0050568e0e15','01565','1415926',1,1),('9598f425-f73d-11e5-8662-0050568e0e15','01566','1415926',1,1),('95a0907e-f73d-11e5-8662-0050568e0e15','01567','1415926',1,1),('95a9cccc-f73d-11e5-8662-0050568e0e15','01568','1415926',1,1),('95b46d0e-f73d-11e5-8662-0050568e0e15','01569','1415926',1,1),('95c1720d-f73d-11e5-8662-0050568e0e15','01570','1415926',1,1),('95d017a7-f73d-11e5-8662-0050568e0e15','01571','1415926',1,1),('95d951eb-f73d-11e5-8662-0050568e0e15','01572','1415926',1,1),('95e35f17-f73d-11e5-8662-0050568e0e15','01573','1415926',1,1),('95ef8004-f73d-11e5-8662-0050568e0e15','01574','1415926',1,1),('95f78f04-f73d-11e5-8662-0050568e0e15','01575','1415926',1,1),('960093ef-f73d-11e5-8662-0050568e0e15','01576','1415926',1,1),('960b69e8-f73d-11e5-8662-0050568e0e15','01577','1415926',1,1),('9615e351-f73d-11e5-8662-0050568e0e15','01578','1415926',1,1),('961f85cc-f73d-11e5-8662-0050568e0e15','01579','1415926',1,1),('962ad7ea-f73d-11e5-8662-0050568e0e15','01580','1415926',1,1),('9634599f-f73d-11e5-8662-0050568e0e15','01581','1415926',1,1),('9644b753-f73d-11e5-8662-0050568e0e15','01582','1415926',1,1),('96581256-f73d-11e5-8662-0050568e0e15','01583','1415926',1,1),('9664ab37-f73d-11e5-8662-0050568e0e15','01584','1415926',1,1),('96757959-f73d-11e5-8662-0050568e0e15','01585','1415926',1,1),('967f81ae-f73d-11e5-8662-0050568e0e15','01586','1415926',1,1),('968e538e-f73d-11e5-8662-0050568e0e15','01587','1415926',1,1),('969c263d-f73d-11e5-8662-0050568e0e15','01588','1415926',1,1),('96a6bc4b-f73d-11e5-8662-0050568e0e15','01589','1415926',1,1),('96b20d83-f73d-11e5-8662-0050568e0e15','01590','1415926',1,1),('96b9c771-f73d-11e5-8662-0050568e0e15','01591','1415926',1,1),('96c3889f-f73d-11e5-8662-0050568e0e15','01592','1415926',1,1),('96d14456-f73d-11e5-8662-0050568e0e15','01593','1415926',1,1),('96dae103-f73d-11e5-8662-0050568e0e15','01594','1415926',1,1),('96e505c0-f73d-11e5-8662-0050568e0e15','01595','1415926',1,1),('96f0a855-f73d-11e5-8662-0050568e0e15','01596','1415926',1,1),('96f90326-f73d-11e5-8662-0050568e0e15','01597','1415926',1,1),('97001e2e-f73d-11e5-8662-0050568e0e15','01598','1415926',1,1),('970a8e1a-f73d-11e5-8662-0050568e0e15','01599','1415926',1,1),('9715acce-f73d-11e5-8662-0050568e0e15','01600','1415926',1,1),('971f5ab0-f73d-11e5-8662-0050568e0e15','01601','1415926',1,1),('972672fd-f73d-11e5-8662-0050568e0e15','01602','1415926',1,1),('972ace54-f73d-11e5-8662-0050568e0e15','01603','1415926',1,1),('9731ccb0-f73d-11e5-8662-0050568e0e15','01604','1415926',1,1),('97362072-f73d-11e5-8662-0050568e0e15','01605','1415926',1,1),('973a35e9-f73d-11e5-8662-0050568e0e15','01606','1415926',1,1),('97408632-f73d-11e5-8662-0050568e0e15','01607','1415926',1,1),('9744bd27-f73d-11e5-8662-0050568e0e15','01608','1415926',1,1),('97488c2d-f73d-11e5-8662-0050568e0e15','01609','1415926',1,1),('974f1738-f73d-11e5-8662-0050568e0e15','01610','1415926',1,1),('9752d04f-f73d-11e5-8662-0050568e0e15','01611','1415926',1,1),('9757b7ef-f73d-11e5-8662-0050568e0e15','01612','1415926',1,1),('975dcc56-f73d-11e5-8662-0050568e0e15','01613','1415926',1,1),('9760ef01-f73d-11e5-8662-0050568e0e15','01614','1415926',1,1),('9763d9c5-f73d-11e5-8662-0050568e0e15','01615','1415926',1,1),('9767139c-f73d-11e5-8662-0050568e0e15','01616','1415926',1,1),('976d9bd6-f73d-11e5-8662-0050568e0e15','01617','1415926',1,1),('97706a5e-f73d-11e5-8662-0050568e0e15','01618','1415926',1,1),('977785c0-f73d-11e5-8662-0050568e0e15','01620','1415926',1,1),('97819a81-f73d-11e5-8662-0050568e0e15','01621','1415926',1,1),('978cd637-f73d-11e5-8662-0050568e0e15','01622','1415926',1,1),('97959a6f-f73d-11e5-8662-0050568e0e15','01623','1415926',1,1),('979db159-f73d-11e5-8662-0050568e0e15','01624','1415926',1,1),('97a7ece0-f73d-11e5-8662-0050568e0e15','01625','1415926',1,1),('97b487f8-f73d-11e5-8662-0050568e0e15','01626','1415926',1,1),('97be7eb3-f73d-11e5-8662-0050568e0e15','01627','1415926',1,1),('97cb6ff8-f73d-11e5-8662-0050568e0e15','01628','1415926',1,1),('97d43c20-f73d-11e5-8662-0050568e0e15','01629','1415926',1,1),('97dc8ef2-f73d-11e5-8662-0050568e0e15','01630','1415926',1,1),('97e50786-f73d-11e5-8662-0050568e0e15','01631','1415926',1,1),('97f132a6-f73d-11e5-8662-0050568e0e15','01632','1415926',1,1),('97fb7a00-f73d-11e5-8662-0050568e0e15','01633','1415926',1,1),('9803c5ad-f73d-11e5-8662-0050568e0e15','01634','1415926',1,1),('980e1122-f73d-11e5-8662-0050568e0e15','01635','1415926',1,1),('98196468-f73d-11e5-8662-0050568e0e15','01636','1415926',1,1),('981f7a1f-f73d-11e5-8662-0050568e0e15','01637','1415926',1,1),('9828f081-f73d-11e5-8662-0050568e0e15','01638','1415926',1,1),('983287ab-f73d-11e5-8662-0050568e0e15','01639','1415926',1,1),('983bb303-f73d-11e5-8662-0050568e0e15','01640','1415926',1,1),('98480a2a-f73d-11e5-8662-0050568e0e15','01641','1415926',1,1),('98521e20-f73d-11e5-8662-0050568e0e15','01642','1415926',1,1),('985c37cf-f73d-11e5-8662-0050568e0e15','01643','1415926',1,1),('98674f82-f73d-11e5-8662-0050568e0e15','01644','1415926',1,1),('98706dbb-f73d-11e5-8662-0050568e0e15','01645','1415926',1,1),('987a4fff-f73d-11e5-8662-0050568e0e15','01646','1415926',1,1),('988282eb-f73d-11e5-8662-0050568e0e15','01647','1415926',1,1),('988d49e1-f73d-11e5-8662-0050568e0e15','01648','1415926',1,1),('9896e338-f73d-11e5-8662-0050568e0e15','01649','1415926',1,1),('98a1e81e-f73d-11e5-8662-0050568e0e15','01650','1415926',1,1),('98ad440d-f73d-11e5-8662-0050568e0e15','01651','1415926',1,1),('98b7a23b-f73d-11e5-8662-0050568e0e15','01652','1415926',1,1),('98c07499-f73d-11e5-8662-0050568e0e15','01653','1415926',1,1),('98d1328b-f73d-11e5-8662-0050568e0e15','01654','1415926',1,1),('98ddd9b8-f73d-11e5-8662-0050568e0e15','01655','1415926',1,1),('98e69563-f73d-11e5-8662-0050568e0e15','01656','1415926',1,1),('98efdf94-f73d-11e5-8662-0050568e0e15','01657','1415926',1,1),('98fa9637-f73d-11e5-8662-0050568e0e15','01658','1415926',1,1),('9904205b-f73d-11e5-8662-0050568e0e15','01659','1415926',1,1),('990cff9b-f73d-11e5-8662-0050568e0e15','01660','1415926',1,1),('99160734-f73d-11e5-8662-0050568e0e15','01661','1415926',1,1),('991f4075-f73d-11e5-8662-0050568e0e15','01662','1415926',1,1),('992a3705-f73d-11e5-8662-0050568e0e15','01663','1415926',1,1),('9936a210-f73d-11e5-8662-0050568e0e15','01664','1415926',1,1),('99401f9c-f73d-11e5-8662-0050568e0e15','01665','1415926',1,1),('994982a5-f73d-11e5-8662-0050568e0e15','01666','1415926',1,1),('995430f1-f73d-11e5-8662-0050568e0e15','01667','1415926',1,1),('99614bb7-f73d-11e5-8662-0050568e0e15','01668','1415926',1,1),('9969afa4-f73d-11e5-8662-0050568e0e15','01669','1415926',1,1),('99753e49-f73d-11e5-8662-0050568e0e15','01670','1415926',1,1),('99806abd-f73d-11e5-8662-0050568e0e15','01671','1415926',1,1),('9989972a-f73d-11e5-8662-0050568e0e15','01672','1415926',1,1),('99929632-f73d-11e5-8662-0050568e0e15','01673','1415926',1,1),('999bef37-f73d-11e5-8662-0050568e0e15','01674','1415926',1,1),('99a68440-f73d-11e5-8662-0050568e0e15','01675','1415926',1,1),('99aefdea-f73d-11e5-8662-0050568e0e15','01676','1415926',1,1),('99b75e86-f73d-11e5-8662-0050568e0e15','01677','1415926',1,1),('99c03025-f73d-11e5-8662-0050568e0e15','01678','1415926',1,1),('99c93880-f73d-11e5-8662-0050568e0e15','01679','1415926',1,1),('99d33faa-f73d-11e5-8662-0050568e0e15','01680','1415926',1,1),('99dc4906-f73d-11e5-8662-0050568e0e15','01681','1415926',1,1),('99e5d0e1-f73d-11e5-8662-0050568e0e15','01682','1415926',1,1),('99ef3ef9-f73d-11e5-8662-0050568e0e15','01683','1415926',1,1),('99f8c3d1-f73d-11e5-8662-0050568e0e15','01684','1415926',1,1),('99ffd45c-f73d-11e5-8662-0050568e0e15','01685','1415926',1,1),('9a094e1a-f73d-11e5-8662-0050568e0e15','01686','1415926',1,1),('9a16ce46-f73d-11e5-8662-0050568e0e15','01687','1415926',1,1),('9a2099db-f73d-11e5-8662-0050568e0e15','01688','1415926',1,1),('9a2c4f4e-f73d-11e5-8662-0050568e0e15','01689','1415926',1,1),('9a35b8de-f73d-11e5-8662-0050568e0e15','01690','1415926',1,1),('9a403a1b-f73d-11e5-8662-0050568e0e15','01691','1415926',1,1),('9a4b6de0-f73d-11e5-8662-0050568e0e15','01692','1415926',1,1),('9a55af4d-f73d-11e5-8662-0050568e0e15','01693','1415926',1,1),('9a6334b1-f73d-11e5-8662-0050568e0e15','01694','1415926',1,1),('9a6e9de8-f73d-11e5-8662-0050568e0e15','01695','1415926',1,1),('9a7a6092-f73d-11e5-8662-0050568e0e15','01696','1415926',1,1),('9a8305d1-f73d-11e5-8662-0050568e0e15','01697','1415926',1,1),('9a8b5354-f73d-11e5-8662-0050568e0e15','01698','1415926',1,1),('9a999594-f73d-11e5-8662-0050568e0e15','01699','1415926',1,1),('9aa17917-f73d-11e5-8662-0050568e0e15','01700','1415926',1,1),('9aacc494-f73d-11e5-8662-0050568e0e15','01701','1415926',1,1),('9ab93760-f73d-11e5-8662-0050568e0e15','01702','1415926',1,1),('9ac404b5-f73d-11e5-8662-0050568e0e15','01703','1415926',1,1),('9ad18630-f73d-11e5-8662-0050568e0e15','01704','1415926',1,1),('9adb242e-f73d-11e5-8662-0050568e0e15','01705','1415926',1,1),('9ae7a1df-f73d-11e5-8662-0050568e0e15','01706','1415926',1,1),('9af0bf2d-f73d-11e5-8662-0050568e0e15','01707','1415926',1,1),('9afa50ec-f73d-11e5-8662-0050568e0e15','01708','1415926',1,1),('9b027a4a-f73d-11e5-8662-0050568e0e15','01709','1415926',1,1),('9b0f6a44-f73d-11e5-8662-0050568e0e15','01710','1415926',1,1),('9b1f4c5d-f73d-11e5-8662-0050568e0e15','01711','1415926',1,1),('9b2a0502-f73d-11e5-8662-0050568e0e15','01712','1415926',1,1),('9b33c337-f73d-11e5-8662-0050568e0e15','01713','1415926',1,1),('9b405d46-f73d-11e5-8662-0050568e0e15','01714','1415926',1,1),('9b4db6d8-f73d-11e5-8662-0050568e0e15','01715','1415926',1,1),('9b571440-f73d-11e5-8662-0050568e0e15','01716','1415926',1,1),('9b60b251-f73d-11e5-8662-0050568e0e15','01717','1415926',1,1),('9b6b7ca7-f73d-11e5-8662-0050568e0e15','01718','1415926',1,1),('9b742773-f73d-11e5-8662-0050568e0e15','01719','1415926',1,1),('9b7ec92a-f73d-11e5-8662-0050568e0e15','01720','1415926',1,1),('9b8cc533-f73d-11e5-8662-0050568e0e15','01721','1415926',1,1),('9b95e270-f73d-11e5-8662-0050568e0e15','01722','1415926',1,1),('9ba2ff4e-f73d-11e5-8662-0050568e0e15','01723','1415926',1,1),('9badaede-f73d-11e5-8662-0050568e0e15','01724','1415926',1,1),('9bb7bf11-f73d-11e5-8662-0050568e0e15','01725','1415926',1,1),('9bc476ec-f73d-11e5-8662-0050568e0e15','01726','1415926',1,1),('9bd216e5-f73d-11e5-8662-0050568e0e15','01727','1415926',1,1),('9be14ecb-f73d-11e5-8662-0050568e0e15','01728','1415926',1,1),('9be9547f-f73d-11e5-8662-0050568e0e15','01729','1415926',1,1),('9bf0d58b-f73d-11e5-8662-0050568e0e15','01730','1415926',1,1),('9bfaeb81-f73d-11e5-8662-0050568e0e15','01731','1415926',1,1),('9c04fd66-f73d-11e5-8662-0050568e0e15','01732','1415926',1,1),('9c0c7031-f73d-11e5-8662-0050568e0e15','01733','1415926',1,1),('9c1ab303-f73d-11e5-8662-0050568e0e15','01734','1415926',1,1),('9c227edc-f73d-11e5-8662-0050568e0e15','01735','1415926',1,1),('9c3078e3-f73d-11e5-8662-0050568e0e15','01736','1415926',1,1),('9c39a7f8-f73d-11e5-8662-0050568e0e15','01737','1415926',1,1),('9c44fd74-f73d-11e5-8662-0050568e0e15','01738','1415926',1,1),('9c4f34ba-f73d-11e5-8662-0050568e0e15','01739','1415926',1,1),('9c585ef4-f73d-11e5-8662-0050568e0e15','01740','1415926',1,1),('9c632088-f73d-11e5-8662-0050568e0e15','01741','1415926',1,1),('9c6e41c5-f73d-11e5-8662-0050568e0e15','01742','1415926',1,1),('9c76b6d2-f73d-11e5-8662-0050568e0e15','01743','1415926',1,1),('9c815602-f73d-11e5-8662-0050568e0e15','01744','1415926',1,1),('9c898937-f73d-11e5-8662-0050568e0e15','01745','1415926',1,1),('9c94e400-f73d-11e5-8662-0050568e0e15','01746','1415926',1,1),('9ca1162b-f73d-11e5-8662-0050568e0e15','01747','1415926',1,1),('9cac72b8-f73d-11e5-8662-0050568e0e15','01748','1415926',1,1),('9cb4385d-f73d-11e5-8662-0050568e0e15','01749','1415926',1,1),('9cbccf8a-f73d-11e5-8662-0050568e0e15','01750','1415926',1,1),('9cc68303-f73d-11e5-8662-0050568e0e15','01751','1415926',1,1),('9ccf8e54-f73d-11e5-8662-0050568e0e15','01752','1415926',1,1),('9cdb6e36-f73d-11e5-8662-0050568e0e15','01753','1415926',1,1),('9ce74b7a-f73d-11e5-8662-0050568e0e15','01754','1415926',1,1),('9cf35eba-f73d-11e5-8662-0050568e0e15','01755','1415926',1,1),('9cfbe0a1-f73d-11e5-8662-0050568e0e15','01757','1415926',1,1),('9d05cae0-f73d-11e5-8662-0050568e0e15','01758','1415926',1,1),('9d11b5ad-f73d-11e5-8662-0050568e0e15','01759','1415926',1,1),('9d1b2498-f73d-11e5-8662-0050568e0e15','01760','1415926',1,1),('9d2544bc-f73d-11e5-8662-0050568e0e15','01761','1415926',1,1),('9d337a8c-f73d-11e5-8662-0050568e0e15','01762','1415926',1,1),('9d3d9b58-f73d-11e5-8662-0050568e0e15','01763','1415926',1,1),('9d48a4cd-f73d-11e5-8662-0050568e0e15','01764','1415926',1,1),('9d51447e-f73d-11e5-8662-0050568e0e15','01765','1415926',1,1),('9d58a806-f73d-11e5-8662-0050568e0e15','01766','1415926',1,1),('9d5e7502-f73d-11e5-8662-0050568e0e15','01767','1415926',1,1),('9d67e135-f73d-11e5-8662-0050568e0e15','01768','1415926',1,1),('9d6e65a8-f73d-11e5-8662-0050568e0e15','01769','1415926',1,1),('9d77a54f-f73d-11e5-8662-0050568e0e15','01770','1415926',1,1),('9d8719e5-f73d-11e5-8662-0050568e0e15','01771','1415926',1,1),('9d96fc62-f73d-11e5-8662-0050568e0e15','01772','1415926',1,1),('9da65aef-f73d-11e5-8662-0050568e0e15','01773','1415926',1,1),('9db1986b-f73d-11e5-8662-0050568e0e15','01774','1415926',1,1),('9dc59346-f73d-11e5-8662-0050568e0e15','01775','1415926',1,1),('9dd12186-f73d-11e5-8662-0050568e0e15','01776','1415926',1,1),('9ddbd844-f73d-11e5-8662-0050568e0e15','01777','1415926',1,1),('9de56bf3-f73d-11e5-8662-0050568e0e15','01778','1415926',1,1),('9deb0da3-f73d-11e5-8662-0050568e0e15','01779','1415926',1,1),('9def4358-f73d-11e5-8662-0050568e0e15','01780','1415926',1,1),('9df828f3-f73d-11e5-8662-0050568e0e15','01781','1415926',1,1),('9dfc5972-f73d-11e5-8662-0050568e0e15','01782','1415926',1,1),('9e040771-f73d-11e5-8662-0050568e0e15','01783','1415926',1,1),('9e098289-f73d-11e5-8662-0050568e0e15','01784','1415926',1,1),('9e0dd524-f73d-11e5-8662-0050568e0e15','01785','1415926',1,1),('9e13a612-f73d-11e5-8662-0050568e0e15','01786','1415926',1,1),('9e1834d7-f73d-11e5-8662-0050568e0e15','01787','1415926',1,1),('9e1bd620-f73d-11e5-8662-0050568e0e15','01788','1415926',1,1),('9e1fb86d-f73d-11e5-8662-0050568e0e15','01789','1415926',1,1),('9e238e0f-f73d-11e5-8662-0050568e0e15','01790','1415926',1,1),('9e27c4c7-f73d-11e5-8662-0050568e0e15','01791','1415926',1,1),('9e2c856d-f73d-11e5-8662-0050568e0e15','01792','1415926',1,1),('9e32e44a-f73d-11e5-8662-0050568e0e15','01793','1415926',1,1),('9e3755d8-f73d-11e5-8662-0050568e0e15','01794','1415926',1,1),('9e3b0971-f73d-11e5-8662-0050568e0e15','01795','1415926',1,1),('9e42bbda-f73d-11e5-8662-0050568e0e15','01796','1415926',1,1),('9e4797ae-f73d-11e5-8662-0050568e0e15','01797','1415926',1,1),('9e4ce5ca-f73d-11e5-8662-0050568e0e15','01798','1415926',1,1),('9e555691-f73d-11e5-8662-0050568e0e15','01799','1415926',1,1),('9e59819c-f73d-11e5-8662-0050568e0e15','01800','1415926',1,1),('9e5d0688-f73d-11e5-8662-0050568e0e15','01801','1415926',1,1),('9e61bc83-f73d-11e5-8662-0050568e0e15','01802','1415926',1,1),('9e655dbc-f73d-11e5-8662-0050568e0e15','01803','1415926',1,1),('9e6915c2-f73d-11e5-8662-0050568e0e15','01804','1415926',1,1),('9e6d1db5-f73d-11e5-8662-0050568e0e15','01805','1415926',1,1),('9e746eaa-f73d-11e5-8662-0050568e0e15','01806','1415926',1,1),('9e781b44-f73d-11e5-8662-0050568e0e15','01807','1415926',1,1),('9e7c7a05-f73d-11e5-8662-0050568e0e15','01808','1415926',1,1),('9e83690a-f73d-11e5-8662-0050568e0e15','01809','1415926',1,1),('9e876e97-f73d-11e5-8662-0050568e0e15','01810','1415926',1,1),('9e8b086b-f73d-11e5-8662-0050568e0e15','01811','1415926',1,1),('9e913e44-f73d-11e5-8662-0050568e0e15','01812','1415926',1,1),('9ea25d77-f73d-11e5-8662-0050568e0e15','01813','1415926',1,1),('9ea99313-f73d-11e5-8662-0050568e0e15','01814','1415926',1,1),('9eb256cd-f73d-11e5-8662-0050568e0e15','01815','1415926',1,1),('9ebab2c1-f73d-11e5-8662-0050568e0e15','01816','1415926',1,1),('9ec8eca0-f73d-11e5-8662-0050568e0e15','01817','1415926',1,1),('9ed39aef-f73d-11e5-8662-0050568e0e15','01818','1415926',1,1),('9edec8a1-f73d-11e5-8662-0050568e0e15','01819','1415926',1,1),('9ee82d4d-f73d-11e5-8662-0050568e0e15','01820','1415926',1,1),('9eeeb60d-f73d-11e5-8662-0050568e0e15','01821','1415926',1,1),('9ef2793d-f73d-11e5-8662-0050568e0e15','01822','1415926',1,1),('9ef71ea3-f73d-11e5-8662-0050568e0e15','01823','1415926',1,1),('9efa406a-f73d-11e5-8662-0050568e0e15','01824','1415926',1,1),('9efe65d5-f73d-11e5-8662-0050568e0e15','01825','1415926',1,1),('9f02a7f0-f73d-11e5-8662-0050568e0e15','01826','1415926',1,1),('9f05dc85-f73d-11e5-8662-0050568e0e15','01827','1415926',1,1),('9f094dde-f73d-11e5-8662-0050568e0e15','01828','1415926',1,1),('9f108226-f73d-11e5-8662-0050568e0e15','01829','1415926',1,1),('9f142382-f73d-11e5-8662-0050568e0e15','01830','1415926',1,1),('9f1f0765-f73d-11e5-8662-0050568e0e15','01831','1415926',1,1),('9f29443f-f73d-11e5-8662-0050568e0e15','01832','1415926',1,1),('9f33c2d7-f73d-11e5-8662-0050568e0e15','01833','1415926',1,1),('9f3d4532-f73d-11e5-8662-0050568e0e15','01834','1415926',1,1),('9f462b7e-f73d-11e5-8662-0050568e0e15','01835','1415926',1,1),('9f508936-f73d-11e5-8662-0050568e0e15','01836','1415926',1,1),('9f5ba897-f73d-11e5-8662-0050568e0e15','01837','1415926',1,1),('9f66c3c4-f73d-11e5-8662-0050568e0e15','01838','1415926',1,1),('9f71d4dc-f73d-11e5-8662-0050568e0e15','01839','1415926',1,1),('9f7afcb2-f73d-11e5-8662-0050568e0e15','01840','1415926',1,1),('9f8328d6-f73d-11e5-8662-0050568e0e15','01841','1415926',1,1),('9f8cc036-f73d-11e5-8662-0050568e0e15','01842','1415926',1,1),('9f964fb5-f73d-11e5-8662-0050568e0e15','01843','1415926',1,1),('9fa10b36-f73d-11e5-8662-0050568e0e15','01844','1415926',1,1),('9fa9e799-f73d-11e5-8662-0050568e0e15','01845','1415926',1,1),('9fb1baa7-f73d-11e5-8662-0050568e0e15','01846','1415926',1,1),('9fb963cb-f73d-11e5-8662-0050568e0e15','01847','1415926',1,1),('9fc29051-f73d-11e5-8662-0050568e0e15','01848','1415926',1,1),('9fc8ed96-f73d-11e5-8662-0050568e0e15','01849','1415926',1,1),('9fcf7c8c-f73d-11e5-8662-0050568e0e15','01850','1415926',1,1),('9fda49b3-f73d-11e5-8662-0050568e0e15','01851','1415926',1,1),('9fe3f3a5-f73d-11e5-8662-0050568e0e15','01852','1415926',1,1),('9fef9138-f73d-11e5-8662-0050568e0e15','01853','1415926',1,1),('9ff85bba-f73d-11e5-8662-0050568e0e15','01854','1415926',1,1),('a007677d-f73d-11e5-8662-0050568e0e15','01855','1415926',1,1),('a0113b74-f73d-11e5-8662-0050568e0e15','01856','1415926',1,1),('a01b57f8-f73d-11e5-8662-0050568e0e15','01857','1415926',1,1),('a0269772-f73d-11e5-8662-0050568e0e15','01858','1415926',1,1),('a02fb66c-f73d-11e5-8662-0050568e0e15','01859','1415926',1,1),('a037c29f-f73d-11e5-8662-0050568e0e15','01860','1415926',1,1),('a0477907-f73d-11e5-8662-0050568e0e15','01861','1415926',1,1),('a0518a79-f73d-11e5-8662-0050568e0e15','01862','1415926',1,1),('a05da953-f73d-11e5-8662-0050568e0e15','01863','1415926',1,1),('a0699e82-f73d-11e5-8662-0050568e0e15','01864','1415926',1,1),('a074b403-f73d-11e5-8662-0050568e0e15','01865','1415926',1,1),('a07f1b02-f73d-11e5-8662-0050568e0e15','01866','1415926',1,1),('a08b4ac8-f73d-11e5-8662-0050568e0e15','01867','1415926',1,1),('a0943876-f73d-11e5-8662-0050568e0e15','01868','1415926',1,1),('a09d6baa-f73d-11e5-8662-0050568e0e15','01869','1415926',1,1),('a0a84e2e-f73d-11e5-8662-0050568e0e15','01870','1415926',1,1),('a0b32adf-f73d-11e5-8662-0050568e0e15','01871','1415926',1,1),('a0ba7844-f73d-11e5-8662-0050568e0e15','01872','1415926',1,1),('a0c3e7e8-f73d-11e5-8662-0050568e0e15','01873','1415926',1,1),('a0ce45eb-f73d-11e5-8662-0050568e0e15','01874','1415926',1,1),('a0da3aa3-f73d-11e5-8662-0050568e0e15','01875','1415926',1,1),('a0e535cd-f73d-11e5-8662-0050568e0e15','01876','1415926',1,1),('a0f1a266-f73d-11e5-8662-0050568e0e15','01877','1415926',1,1),('a0fa1ebb-f73d-11e5-8662-0050568e0e15','01878','1415926',1,1),('a10269bd-f73d-11e5-8662-0050568e0e15','01879','1415926',1,1),('a10b2026-f73d-11e5-8662-0050568e0e15','01880','1415926',1,1),('a115ab19-f73d-11e5-8662-0050568e0e15','01881','1415926',1,1),('a1207c54-f73d-11e5-8662-0050568e0e15','01882','1415926',1,1),('a1290f46-f73d-11e5-8662-0050568e0e15','01883','1415926',1,1),('a1317d3f-f73d-11e5-8662-0050568e0e15','01884','1415926',1,1),('a13fceab-f73d-11e5-8662-0050568e0e15','01885','1415926',1,1),('a14e9010-f73d-11e5-8662-0050568e0e15','01886','1415926',1,1),('a158f095-f73d-11e5-8662-0050568e0e15','01887','1415926',1,1),('a162a10b-f73d-11e5-8662-0050568e0e15','01888','1415926',1,1),('a16e93cb-f73d-11e5-8662-0050568e0e15','01889','1415926',1,1),('a1745b0f-f73d-11e5-8662-0050568e0e15','01890','1415926',1,1),('a17e2ddc-f73d-11e5-8662-0050568e0e15','01891','1415926',1,1),('a184cc1e-f73d-11e5-8662-0050568e0e15','01892','1415926',1,1),('a18dce46-f73d-11e5-8662-0050568e0e15','01894','1415926',1,1),('a193bb73-f73d-11e5-8662-0050568e0e15','01895','1415926',1,1),('a19d6949-f73d-11e5-8662-0050568e0e15','01896','1415926',1,1),('a1a56a8f-f73d-11e5-8662-0050568e0e15','01897','1415926',1,1),('a1ae11a8-f73d-11e5-8662-0050568e0e15','01898','1415926',1,1),('a1b6c1b6-f73d-11e5-8662-0050568e0e15','01899','1415926',1,1),('a1bf1890-f73d-11e5-8662-0050568e0e15','01900','1415926',1,1),('a1c6b9b9-f73d-11e5-8662-0050568e0e15','01901','1415926',1,1),('a1cf562c-f73d-11e5-8662-0050568e0e15','01902','1415926',1,1),('a1d9f530-f73d-11e5-8662-0050568e0e15','01903','1415926',1,1),('a1e4fa18-f73d-11e5-8662-0050568e0e15','01904','1415926',1,1),('a1f2f589-f73d-11e5-8662-0050568e0e15','01905','1415926',1,1),('a1fc7a99-f73d-11e5-8662-0050568e0e15','01906','1415926',1,1),('a2070131-f73d-11e5-8662-0050568e0e15','01907','1415926',1,1),('a2105388-f73d-11e5-8662-0050568e0e15','01908','1415926',1,1),('a21615b2-f73d-11e5-8662-0050568e0e15','01909','1415926',1,1),('a224674e-f73d-11e5-8662-0050568e0e15','01910','1415926',1,1),('a22ceebe-f73d-11e5-8662-0050568e0e15','01911','1415926',1,1),('a234871f-f73d-11e5-8662-0050568e0e15','01912','1415926',1,1),('a24183f1-f73d-11e5-8662-0050568e0e15','01913','1415926',1,1),('a24a9691-f73d-11e5-8662-0050568e0e15','01914','1415926',1,1),('a253c79f-f73d-11e5-8662-0050568e0e15','01915','1415926',1,1),('a25df9c5-f73d-11e5-8662-0050568e0e15','01916','1415926',1,1),('a26d437b-f73d-11e5-8662-0050568e0e15','01917','1415926',1,1),('a27847dc-f73d-11e5-8662-0050568e0e15','01918','1415926',1,1),('a281572f-f73d-11e5-8662-0050568e0e15','01919','1415926',1,1),('a28b3405-f73d-11e5-8662-0050568e0e15','01920','1415926',1,1),('a293c254-f73d-11e5-8662-0050568e0e15','01921','1415926',1,1),('a29f1d57-f73d-11e5-8662-0050568e0e15','01922','1415926',1,1),('a2a6ae52-f73d-11e5-8662-0050568e0e15','01923','1415926',1,1),('a2aec5d7-f73d-11e5-8662-0050568e0e15','01924','1415926',1,1),('a2b78c82-f73d-11e5-8662-0050568e0e15','01925','1415926',1,1),('a2bfe7d4-f73d-11e5-8662-0050568e0e15','01926','1415926',1,1),('a2cc0ec9-f73d-11e5-8662-0050568e0e15','01927','1415926',1,1),('a2d838ce-f73d-11e5-8662-0050568e0e15','01928','1415926',1,1),('a2e1da03-f73d-11e5-8662-0050568e0e15','01929','1415926',1,1),('a2f50c56-f73d-11e5-8662-0050568e0e15','01930','1415926',1,1),('a2ff4437-f73d-11e5-8662-0050568e0e15','01931','1415926',1,1),('a3088cfe-f73d-11e5-8662-0050568e0e15','01932','1415926',1,1),('a314356c-f73d-11e5-8662-0050568e0e15','01933','1415926',1,1),('a31bc7c3-f73d-11e5-8662-0050568e0e15','01934','1415926',1,1),('a325435b-f73d-11e5-8662-0050568e0e15','01935','1415926',1,1),('a3337293-f73d-11e5-8662-0050568e0e15','01936','1415926',1,1),('a33db4b1-f73d-11e5-8662-0050568e0e15','01937','1415926',1,1),('a34645be-f73d-11e5-8662-0050568e0e15','01938','1415926',1,1),('a352ad97-f73d-11e5-8662-0050568e0e15','01939','1415926',1,1),('a35ad4b8-f73d-11e5-8662-0050568e0e15','01940','1415926',1,1),('a3654521-f73d-11e5-8662-0050568e0e15','01941','1415926',1,1),('a371ead5-f73d-11e5-8662-0050568e0e15','01942','1415926',1,1),('a37c84f8-f73d-11e5-8662-0050568e0e15','01943','1415926',1,1),('a3861af1-f73d-11e5-8662-0050568e0e15','01944','1415926',1,1),('a391260f-f73d-11e5-8662-0050568e0e15','01945','1415926',1,1),('a39a7738-f73d-11e5-8662-0050568e0e15','01946','1415926',1,1),('a3a6958a-f73d-11e5-8662-0050568e0e15','01947','1415926',1,1),('a3b09e49-f73d-11e5-8662-0050568e0e15','01948','1415926',1,1),('a3b9a1b1-f73d-11e5-8662-0050568e0e15','01949','1415926',1,1),('a3c3893b-f73d-11e5-8662-0050568e0e15','01950','1415926',1,1),('a3cb9c55-f73d-11e5-8662-0050568e0e15','01951','1415926',1,1),('a3d73894-f73d-11e5-8662-0050568e0e15','01952','1415926',1,1),('a3df69bc-f73d-11e5-8662-0050568e0e15','01953','1415926',1,1),('a3e8d7a4-f73d-11e5-8662-0050568e0e15','01954','1415926',1,1),('a3f47391-f73d-11e5-8662-0050568e0e15','01955','1415926',1,1),('a3fe75d8-f73d-11e5-8662-0050568e0e15','01956','1415926',1,1),('a40597d9-f73d-11e5-8662-0050568e0e15','01957','1415926',1,1),('a40e184b-f73d-11e5-8662-0050568e0e15','01958','1415926',1,1),('a416d9f3-f73d-11e5-8662-0050568e0e15','01959','1415926',1,1),('a420c05f-f73d-11e5-8662-0050568e0e15','01960','1415926',1,1),('a42d6c55-f73d-11e5-8662-0050568e0e15','01961','1415926',1,1),('a435fb22-f73d-11e5-8662-0050568e0e15','01962','1415926',1,1),('a43fede8-f73d-11e5-8662-0050568e0e15','01963','1415926',1,1),('a447d64a-f73d-11e5-8662-0050568e0e15','01964','1415926',1,1),('a45694e3-f73d-11e5-8662-0050568e0e15','01965','1415926',1,1),('a45f596b-f73d-11e5-8662-0050568e0e15','01966','1415926',1,1),('a46bd918-f73d-11e5-8662-0050568e0e15','01967','1415926',1,1),('a473a875-f73d-11e5-8662-0050568e0e15','01968','1415926',1,1),('a47d32fe-f73d-11e5-8662-0050568e0e15','01969','1415926',1,1),('a486e7e4-f73d-11e5-8662-0050568e0e15','01970','1415926',1,1),('a4933c55-f73d-11e5-8662-0050568e0e15','01971','1415926',1,1),('a49fcd04-f73d-11e5-8662-0050568e0e15','01972','1415926',1,1),('a4aa3f48-f73d-11e5-8662-0050568e0e15','01973','1415926',1,1),('a4b22c34-f73d-11e5-8662-0050568e0e15','01974','1415926',1,1);

/*Table structure for table `tc_stall` */

DROP TABLE IF EXISTS `tc_stall`;

CREATE TABLE `tc_stall` (
  `stall_id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '车位id',
  `maintenance_price` double DEFAULT NULL COMMENT '管理费单价',
  `garage_id` int(36) DEFAULT NULL COMMENT '车库id',
  `person_id` int(30) DEFAULT NULL COMMENT '个人客户id',
  `floor_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '楼层号',
  `bairro` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '所在区',
  `is_mechanical_stall` tinyint(4) DEFAULT NULL COMMENT '是否机械车位',
  `stall_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车位号',
  `stall_position` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车位位置',
  `stall_property` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车位属性',
  `fixed_parking` tinyint(4) DEFAULT NULL COMMENT '是否固定车位',
  `is_fixed_stall` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `intake_date` date DEFAULT NULL COMMENT '入伙日期',
  `sales_state` tinyint(4) DEFAULT NULL COMMENT '销售状态',
  `intake_state` tinyint(4) DEFAULT NULL COMMENT '入伙状态',
  `rent_state` tinyint(4) DEFAULT NULL COMMENT '租赁状态',
  `project_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目编号',
  `project_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名称',
  `parcel_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '宗地号',
  `stall_coding` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '车位编码',
  `garage_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车库编号',
  `garage_position` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '车库位置',
  `contract_number` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '合同编号',
  `subscription_date` date DEFAULT NULL COMMENT '认购日期',
  `contract_date` date DEFAULT NULL COMMENT '签约日期',
  `Property_person` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '产权归属人',
  `property_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '产权类型',
  `register_price` double DEFAULT NULL COMMENT '登记价',
  `mortgage_amount` double DEFAULT NULL COMMENT '按揭金额',
  `registrant` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '登记人',
  `registration_date` date DEFAULT NULL COMMENT '登记时间',
  `down_payment_amount` double DEFAULT NULL COMMENT '首付金额',
  `payment_method` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '付款方式',
  `transaction_type` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '交易类型',
  `discounted_prices` double DEFAULT NULL COMMENT '折后实价',
  `house_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房屋编号',
  `parking_information` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '停车信息',
  `trade_information` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '交易信息',
  `stall_Type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '车位类型',
  `building_structure_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑结构id',
  `building_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑id',
  `usable_area` double DEFAULT NULL,
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `stall_state` tinyint(4) DEFAULT NULL COMMENT '新增  车位状态（1表示正常，2表示欠费，3表示已办卡）',
  `completion_date` date DEFAULT NULL,
  `building_certificate` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房产证号',
  PRIMARY KEY (`stall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_stall` */

insert  into `tc_stall`(`stall_id`,`maintenance_price`,`garage_id`,`person_id`,`floor_number`,`bairro`,`is_mechanical_stall`,`stall_number`,`stall_position`,`stall_property`,`fixed_parking`,`is_fixed_stall`,`intake_date`,`sales_state`,`intake_state`,`rent_state`,`project_number`,`project_name`,`parcel_number`,`stall_coding`,`garage_number`,`garage_position`,`contract_number`,`subscription_date`,`contract_date`,`Property_person`,`property_type`,`register_price`,`mortgage_amount`,`registrant`,`registration_date`,`down_payment_amount`,`payment_method`,`transaction_type`,`discounted_prices`,`house_number`,`parking_information`,`trade_information`,`stall_Type`,`building_structure_id`,`building_id`,`usable_area`,`project_id`,`stall_state`,`completion_date`,`building_certificate`) values ('baf78f96-b111-4290-ab41-080f33dcdd22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'3a32b958-4498-4cc2-bfaa-cd2bea469fcc','a165026d-4452-40e4-abb1-74b1cf8d2cf8',NULL,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',NULL,NULL,NULL),('d3295e3c-c6f1-44fd-926a-b72f387fed37',NULL,NULL,NULL,NULL,NULL,0,'2',NULL,'标准车位',NULL,NULL,'2016-05-01',NULL,0,NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0da2d314-cb9d-42de-aa64-d492af535475','1c94733c-f5f0-439e-91d5-79cf028f3e92',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,NULL,NULL),('ff4f07ba-e7b0-490e-81e8-1fb57326c3b0',NULL,NULL,NULL,NULL,NULL,0,'3',NULL,'微型车位',NULL,NULL,'2016-05-01',NULL,0,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'8a4acd23-4285-4307-a603-1823e61089ae','1c94733c-f5f0-439e-91d5-79cf028f3e92',NULL,'3c435785-745b-1127-f1ae-2a5e8cc64a3b',NULL,NULL,NULL);

/*Table structure for table `tc_store` */

DROP TABLE IF EXISTS `tc_store`;

CREATE TABLE `tc_store` (
  `store_id` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '商铺id',
  `store_tyoe` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '商铺类型',
  `store_bairro` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '所在区',
  `sta_date` date DEFAULT NULL COMMENT '签约日期',
  `property_type` tinyint(4) DEFAULT NULL COMMENT '产权类型',
  `register_price` double DEFAULT NULL COMMENT '登记价',
  `mortgage_amount` double DEFAULT NULL COMMENT '按揭金额',
  `registrant_cust` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '登记人',
  `registration_date` date DEFAULT NULL COMMENT '登记时间',
  `down_payment_amount` double DEFAULT NULL COMMENT '付款方式',
  `payment_method` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '首付金额',
  `transaction_type` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '交易类型',
  `discounted_prices` double DEFAULT NULL COMMENT '折后实价',
  `building_structure_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑结构id',
  `building_id` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '建筑id',
  `intake_date` date DEFAULT NULL COMMENT '竣工日期',
  `building_area` double DEFAULT NULL COMMENT '建筑面积',
  `commonality_area` double DEFAULT NULL COMMENT '分摊面积',
  `inside_area` double DEFAULT NULL COMMENT '套内面积',
  `completion_area` double DEFAULT NULL COMMENT '竣工面积',
  `store_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '商铺号',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `intake_state` tinyint(4) DEFAULT NULL COMMENT '新增',
  `building_certificate` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '房产证号',
  `store_code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '商铺编码',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_store` */

insert  into `tc_store`(`store_id`,`store_tyoe`,`store_bairro`,`sta_date`,`property_type`,`register_price`,`mortgage_amount`,`registrant_cust`,`registration_date`,`down_payment_amount`,`payment_method`,`transaction_type`,`discounted_prices`,`building_structure_id`,`building_id`,`intake_date`,`building_area`,`commonality_area`,`inside_area`,`completion_area`,`store_number`,`project_id`,`intake_state`,`building_certificate`,`store_code`) values ('dcc10140-129c-11e6-a92c-507b9d2ee731',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'c15ba4e4-f34c-440b-b2b6-95011ea81039','a165026d-4452-40e4-abb1-74b1cf8d2cf8',NULL,NULL,NULL,NULL,NULL,NULL,'89ea04fd-557d-6b95-0fa7-f2ed7b472fe4',0,NULL,NULL);

/*Table structure for table `tc_subcompany` */

DROP TABLE IF EXISTS `tc_subcompany`;

CREATE TABLE `tc_subcompany` (
  `subCompany_id` varchar(36) NOT NULL COMMENT '子公司id',
  `subCompany_name` varchar(100) DEFAULT NULL COMMENT '子公司名称',
  `company_id` varchar(36) DEFAULT NULL COMMENT '公司id',
  `create_person_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_person_id` varchar(36) DEFAULT NULL COMMENT '修改人id',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`subCompany_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_subcompany` */

/*Table structure for table `tc_subcompany_project_relation` */

DROP TABLE IF EXISTS `tc_subcompany_project_relation`;

CREATE TABLE `tc_subcompany_project_relation` (
  `subCompany_project_relation_id` varchar(36) NOT NULL,
  `subCompany_id` varchar(36) DEFAULT NULL,
  `project_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`subCompany_project_relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_subcompany_project_relation` */

/*Table structure for table `tc_tenement_insurance` */

DROP TABLE IF EXISTS `tc_tenement_insurance`;

CREATE TABLE `tc_tenement_insurance` (
  `insurance_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '物业保险id',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '保险公司',
  `enterprise_money` double DEFAULT NULL COMMENT '保险金额',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `area_insurance_company_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '区域保险公司',
  `insurance_type` tinyint(4) DEFAULT NULL COMMENT '保险类型',
  `premium_money` double DEFAULT NULL COMMENT '保费金额',
  `settling_fee` double DEFAULT NULL COMMENT '理赔金额',
  `staff_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '责任人',
  `insurance_num` double DEFAULT NULL COMMENT '保险单号',
  `settling_fee_sum` double DEFAULT NULL COMMENT '累计理赔',
  PRIMARY KEY (`insurance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_tenement_insurance` */

/*Table structure for table `tc_tenement_pact` */

DROP TABLE IF EXISTS `tc_tenement_pact`;

CREATE TABLE `tc_tenement_pact` (
  `pact_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '物业合同id',
  `pre_enterprise` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '甲方公司',
  `aft_enterprise` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '乙方公司',
  `sta_time` date DEFAULT NULL COMMENT '合同签订日期',
  `end_time` date DEFAULT NULL COMMENT '合同结束日期',
  `pact_code` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '物业合同编号',
  `pact_type` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同类型',
  `property_project` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '物业项目',
  `pact_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同名称',
  `total_price` double DEFAULT NULL COMMENT '合同金额',
  `total_price_type` tinyint(4) DEFAULT NULL COMMENT '合同金额类型，0收入，1支出',
  `per_price` double DEFAULT NULL COMMENT '管理单价',
  `manage_area` double DEFAULT NULL COMMENT '管里面积',
  `pact_describle` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '合同简介',
  `accessory_src` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '附件路径',
  `third_enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '丙方公司id',
  `four_enterprise_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '丁方公司id',
  `state` tinyint(4) DEFAULT NULL COMMENT '合同状态',
  PRIMARY KEY (`pact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tc_tenement_pact` */

/*Table structure for table `tc_unionpay_collection_detail` */

DROP TABLE IF EXISTS `tc_unionpay_collection_detail`;

CREATE TABLE `tc_unionpay_collection_detail` (
  `unionpay_collection_detai_id` varchar(36) NOT NULL COMMENT '主键id',
  `merchants_date` date DEFAULT NULL COMMENT '商户日期',
  `cust_num` varchar(36) DEFAULT NULL COMMENT '客户号',
  `bank_account` varchar(36) DEFAULT NULL COMMENT '银行账号',
  `account_type` tinyint(11) DEFAULT NULL COMMENT '账号类型(0银行卡1存折)',
  `sum` double DEFAULT NULL COMMENT '金额',
  `private_domain` varchar(36) DEFAULT NULL COMMENT '私有域',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `unionpay_counteroffer_detai_id` varchar(36) DEFAULT NULL COMMENT '银联回盘明细文件id',
  `unionpay_collection_totall_id` varchar(36) DEFAULT NULL COMMENT '总结文件ID',
  `bill_id` varchar(36) DEFAULT NULL COMMENT '应收款id',
  `cust_name` varchar(36) DEFAULT NULL COMMENT '户主',
  `collection_state` int(4) DEFAULT NULL COMMENT '托收状态（0未托收1已托收）',
  PRIMARY KEY (`unionpay_collection_detai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_unionpay_collection_detail` */

/*Table structure for table `tc_unionpay_collection_totall` */

DROP TABLE IF EXISTS `tc_unionpay_collection_totall`;

CREATE TABLE `tc_unionpay_collection_totall` (
  `unionpay_collection_totall_id` varchar(36) NOT NULL COMMENT '主键id',
  `project_id` varchar(36) DEFAULT NULL COMMENT '项目id',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `merchants_num` varchar(36) DEFAULT NULL COMMENT '商户号',
  `batch_num` varchar(36) DEFAULT NULL COMMENT '批次号',
  `total_sum` double DEFAULT NULL COMMENT '总金额',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `total_trade_num` int(30) DEFAULT NULL COMMENT '总笔数',
  PRIMARY KEY (`unionpay_collection_totall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_unionpay_collection_totall` */

/*Table structure for table `tc_unionpay_counteroffer_detai` */

DROP TABLE IF EXISTS `tc_unionpay_counteroffer_detai`;

CREATE TABLE `tc_unionpay_counteroffer_detai` (
  `unionpay_counteroffer_detai_id` varchar(36) NOT NULL COMMENT '主键id',
  `cp_date` date DEFAULT NULL COMMENT 'cp日期',
  `cp_running` varchar(36) DEFAULT NULL COMMENT 'cp流水',
  `cust_num` varchar(36) DEFAULT NULL COMMENT '客户编号',
  `cust_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `card_host` varchar(50) DEFAULT NULL COMMENT '持卡人姓名',
  `card_type` tinyint(11) DEFAULT NULL COMMENT '证件类型（0身份证1学生证2驾驶证）',
  `card_num` varchar(36) DEFAULT NULL COMMENT '证件号',
  `account_type` tinyint(11) DEFAULT NULL COMMENT '账户类型（0银行卡1存折）',
  `account_num` varchar(36) DEFAULT NULL COMMENT '卡号/存折号',
  `bank_num` varchar(36) DEFAULT NULL COMMENT '开户行行号',
  `transaction_date` date DEFAULT NULL COMMENT '交易日期',
  `transaction_type` tinyint(11) DEFAULT NULL COMMENT '交易状态',
  `response_code` varchar(36) DEFAULT NULL COMMENT '响应码',
  `sum` double DEFAULT NULL COMMENT '金额',
  `private_domain` varchar(36) DEFAULT NULL COMMENT '私有域',
  `unionpay_counteroffer_total_id` varchar(36) DEFAULT NULL COMMENT '银联托收回盘总结文件id',
  PRIMARY KEY (`unionpay_counteroffer_detai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_unionpay_counteroffer_detai` */

/*Table structure for table `tc_unionpay_counteroffer_total` */

DROP TABLE IF EXISTS `tc_unionpay_counteroffer_total`;

CREATE TABLE `tc_unionpay_counteroffer_total` (
  `unionpay_counteroffer_total_id` varchar(36) NOT NULL COMMENT '主键id',
  `file_name` varchar(36) DEFAULT NULL COMMENT '文件名称',
  `total_sum` double DEFAULT NULL COMMENT '总金额',
  `success_sum` double DEFAULT NULL COMMENT '成功金额',
  `unionpay_collection_detail_id` varchar(36) DEFAULT NULL COMMENT '银联托收回盘总结文件id',
  `up_date` date DEFAULT NULL COMMENT '上传时间',
  `total_trade_num` int(30) DEFAULT NULL COMMENT '总笔数',
  `success_trade_num` int(30) DEFAULT NULL COMMENT '成功笔数',
  PRIMARY KEY (`unionpay_counteroffer_total_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tc_unionpay_counteroffer_total` */

/*Table structure for table `tc_user` */

DROP TABLE IF EXISTS `tc_user`;

CREATE TABLE `tc_user` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `staff_id` varchar(36) DEFAULT NULL COMMENT '员工id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_person_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `last_modify_id` varchar(36) DEFAULT NULL COMMENT '最后修改人id',
  `last_modify_date` date DEFAULT NULL COMMENT '最后修改日期',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标识',
  `phone_num` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `card_type` tinyint(4) DEFAULT NULL COMMENT '证件类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tc_user` */

/*Table structure for table `tc_user_post` */

DROP TABLE IF EXISTS `tc_user_post`;

CREATE TABLE `tc_user_post` (
  `id` varchar(36) NOT NULL,
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
  `post_id` varchar(36) DEFAULT NULL COMMENT '岗位id',
  `create_person_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `last_modify_id` varchar(36) DEFAULT NULL COMMENT '最后修改人id',
  `last_modify_date` date DEFAULT NULL COMMENT '最后修改日期',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标识(0开启，1关闭)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户岗位表';

/*Data for the table `tc_user_post` */

/*Table structure for table `te_electricity_meter` */

DROP TABLE IF EXISTS `te_electricity_meter`;

CREATE TABLE `te_electricity_meter` (
  `electricity_meter_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '电表id',
  `assets_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `electricity_meter_num` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '表编号',
  `state` tinyint(4) DEFAULT NULL COMMENT '表状态',
  `ratio` double DEFAULT NULL COMMENT '倍率',
  `max` double DEFAULT NULL COMMENT '最大数值',
  `min` double DEFAULT NULL COMMENT '最小数值',
  PRIMARY KEY (`electricity_meter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter` */

/*Table structure for table `te_electricity_meter_project` */

DROP TABLE IF EXISTS `te_electricity_meter_project`;

CREATE TABLE `te_electricity_meter_project` (
  `electricity_meter_project_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '电表抄表计划关系表id',
  `electricity_meter_records_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表使用记录id',
  `reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划id',
  PRIMARY KEY (`electricity_meter_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_project` */

/*Table structure for table `te_electricity_meter_reading_complaints` */

DROP TABLE IF EXISTS `te_electricity_meter_reading_complaints`;

CREATE TABLE `te_electricity_meter_reading_complaints` (
  `electricity_meter_reading_complaints_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '电表抄表投诉id',
  `complainant_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉人',
  `complaint_description` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '投诉描述',
  `electricity_meter_reading_data_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表抄表数据id',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  PRIMARY KEY (`electricity_meter_reading_complaints_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_reading_complaints` */

/*Table structure for table `te_electricity_meter_reading_data` */

DROP TABLE IF EXISTS `te_electricity_meter_reading_data`;

CREATE TABLE `te_electricity_meter_reading_data` (
  `electricity_meter_reading_data_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '抄表数据id',
  `electricity_meter_record_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表使用记录id',
  `last_month_reading` double DEFAULT NULL COMMENT '上月读数',
  `reading` double DEFAULT NULL COMMENT '读数',
  `meter_reading_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表人',
  `meter_reading_state` tinyint(4) DEFAULT NULL COMMENT '抄表状态',
  `meter_reading_date` date DEFAULT NULL COMMENT '抄表日期',
  `reading_state` tinyint(4) DEFAULT NULL COMMENT '读数状态',
  `note` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `audit_state` tinyint(4) DEFAULT NULL COMMENT '审核状态',
  `audit_people` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人',
  `correction` double DEFAULT NULL COMMENT '修正量',
  `reason` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '原因',
  `electricity_damage` double DEFAULT NULL COMMENT '电损量',
  `abnormal_state` tinyint(4) DEFAULT NULL COMMENT '异常状态',
  `electricity_meter_reading_program_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表计划id',
  `teamwork_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '团队id',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  PRIMARY KEY (`electricity_meter_reading_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_reading_data` */

/*Table structure for table `te_electricity_meter_reading_program` */

DROP TABLE IF EXISTS `te_electricity_meter_reading_program`;

CREATE TABLE `te_electricity_meter_reading_program` (
  `electricity_meter_reading_program_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '抄表计划id',
  `project_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '计划名称',
  `project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `settlement_day` int(30) DEFAULT NULL COMMENT '月结日',
  `reviewers` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人员',
  `program_execution_status` tinyint(4) DEFAULT NULL COMMENT '计划执行状态',
  `meter_reading_num` int(30) DEFAULT NULL COMMENT '抄表数量',
  `unfinished_num` int(30) DEFAULT NULL COMMENT '未完成数量',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '核实时间',
  `verify_time` date DEFAULT NULL COMMENT '结束时间',
  `meter_reading_type` tinyint(4) DEFAULT NULL COMMENT '抄表负责人类型(团队或人员)',
  `meter_reading_warning_num` int(30) DEFAULT NULL COMMENT '警告抄表数量',
  `meter_reading_error_num` int(30) DEFAULT NULL COMMENT '错误抄表数量',
  `no_meter_reading_num` int(30) DEFAULT NULL COMMENT '未抄表数量',
  `review_meter_num` int(30) DEFAULT NULL COMMENT '已审核数量',
  `meter_reading_normal_num` int(30) DEFAULT NULL COMMENT '正常抄表数量',
  `current_executor` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '当前执行人',
  `executive_team` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '执行团队',
  PRIMARY KEY (`electricity_meter_reading_program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_reading_program` */

/*Table structure for table `te_electricity_meter_records` */

DROP TABLE IF EXISTS `te_electricity_meter_records`;

CREATE TABLE `te_electricity_meter_records` (
  `electricity_meter_records_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '电表使用记录id',
  `electricity_meter_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表id',
  `installation_time` date DEFAULT NULL COMMENT '安装时间',
  `enabling_time` date DEFAULT NULL COMMENT '启用时间',
  `install` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '安装人',
  `outage_time` date DEFAULT NULL COMMENT '停用时间',
  `using_nature` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '使用性质',
  `electricity_meter_building_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表所属建筑id',
  `assets_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '资产id',
  `state` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '表状态',
  `reading_way` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '抄表方式',
  `parent_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '父表id',
  `is_billing` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '是否计费表',
  `last_time_reading` double DEFAULT NULL COMMENT '上次读数',
  `initial_reading` double DEFAULT NULL COMMENT '初始读数',
  `stop_reading` double DEFAULT NULL COMMENT '停用读数',
  `building_structure_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '建筑结构id',
  PRIMARY KEY (`electricity_meter_records_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_records` */

/*Table structure for table `te_electricity_meter_types` */

DROP TABLE IF EXISTS `te_electricity_meter_types`;

CREATE TABLE `te_electricity_meter_types` (
  `electricity_meter_types_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '电表所属建筑类型id',
  `electricity_meter_types_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '电表所有建筑类型名称',
  `electricity_meter_described` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '表描述',
  PRIMARY KEY (`electricity_meter_types_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `te_electricity_meter_types` */

/*Table structure for table `tl_loginlog` */

DROP TABLE IF EXISTS `tl_loginlog`;

CREATE TABLE `tl_loginlog` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(36) DEFAULT NULL COMMENT '登录ip'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登录日志表';

/*Data for the table `tl_loginlog` */

/*Table structure for table `tl_role_user` */

DROP TABLE IF EXISTS `tl_role_user`;

CREATE TABLE `tl_role_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `role_id` varchar(36) NOT NULL COMMENT '角色id',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色用户关联表';

/*Data for the table `tl_role_user` */

/*Table structure for table `tl_user` */

DROP TABLE IF EXISTS `tl_user`;

CREATE TABLE `tl_user` (
  `id` varchar(36) NOT NULL COMMENT '主键id',
  `username` varchar(36) DEFAULT NULL COMMENT '登录用户帐号',
  `password` varchar(36) DEFAULT NULL COMMENT '登录用户密码',
  `real_name` varchar(36) DEFAULT NULL COMMENT '真实姓名',
  `reg_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(36) DEFAULT NULL COMMENT '是否启用，0启用、1停用',
  `description` varchar(100) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录信息表';

/*Data for the table `tl_user` */

/*Table structure for table `ts_acceptance_information_records` */

DROP TABLE IF EXISTS `ts_acceptance_information_records`;

CREATE TABLE `ts_acceptance_information_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '验收记录项id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `acceptance_item_type` tinyint(4) DEFAULT NULL COMMENT '验收项类型',
  `acceptance_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '验收项名称',
  `acceptance_item_result` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '验收结果',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_acceptance_information_records` */

/*Table structure for table `ts_acceptance_orders` */

DROP TABLE IF EXISTS `ts_acceptance_orders`;

CREATE TABLE `ts_acceptance_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '验收工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `satisfaction` tinyint(4) DEFAULT NULL COMMENT '满意度（五颗星）',
  `signatory` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '签字人',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `acceptance_item_result` tinyint(4) DEFAULT NULL COMMENT '验收结果',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_acceptance_orders` */

/*Table structure for table `ts_actual_consumption_records` */

DROP TABLE IF EXISTS `ts_actual_consumption_records`;

CREATE TABLE `ts_actual_consumption_records` (
  `consumption_record_id` varchar(36) NOT NULL COMMENT '资源耗费记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `product_type` varchar(36) DEFAULT NULL COMMENT '产品类型',
  `product_id` varchar(36) DEFAULT NULL COMMENT '产品id',
  `product_name` varchar(36) DEFAULT NULL COMMENT '产品名称',
  `num` tinyint(4) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`consumption_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实际耗费资源记录表';

/*Data for the table `ts_actual_consumption_records` */

/*Table structure for table `ts_annex` */

DROP TABLE IF EXISTS `ts_annex`;

CREATE TABLE `ts_annex` (
  `annex_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '附件id',
  `relation_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联id（可以是服务请求、任务、工单）',
  `annex_type` tinyint(4) DEFAULT NULL COMMENT '附件类型（业主签名、图片、录音、文档等）',
  `annex_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '附件地址(不是附件本身)',
  `annex_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '附件名称',
  `annex_time` datetime DEFAULT NULL COMMENT '附件时间',
  `pact_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '合同id',
  `is_main` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '主辅图（0主图，1辅图）关联产品表',
  PRIMARY KEY (`annex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_annex` */

insert  into `ts_annex`(`annex_id`,`relation_id`,`annex_type`,`annex_address`,`annex_name`,`annex_time`,`pact_id`,`is_main`) values ('0451a418-0b75-11e6-8899-507b9d2ee731','4a604c0c-7b53-4500-b44b-1178787ace94',NULL,'/upload\\20160426\\20160426140612_869.jpg','-7_54c5ca4c9d6a9.jpg','2016-04-26 14:06:16',NULL,'0'),('565cfcd2-10df-11e6-a92c-507b9d2ee731','d456fb58-27df-4829-84d9-5813c3708785',NULL,'/upload\\20160427\\20160427103119_619.jpg','1.jpg','2016-05-03 11:29:52',NULL,NULL),('5adbcf09-0c69-11e6-b057-507b9d2ee731','265238ed-5d60-42c8-ae24-88754983b478',NULL,'/upload\\20160427\\20160427191450_403.jpg','-7_54c5ca4c9d6a9.jpg','2016-04-27 19:15:20',NULL,NULL),('5b609e00-02ec-11e6-90ea-507b9d2ee731','7949d625-e231-4696-a8f7-c3ab63c63a2c',NULL,'/upload\\20160415\\20160415172753_546.gif','74b7a88egw1exp1mfuqsog20b4098b2a.gif','2016-04-15 17:28:05',NULL,'0'),('7511b7cd-06c7-11e6-b42c-507b9d2ee731','d3c4d849-4277-40d4-b059-32684c09d806',NULL,'/upload\\20160420\\20160420151346_724.jpg','-7_54f7c72898a27.jpg','2016-04-20 15:13:54',NULL,'0'),('8857dea9-02ba-11e6-90ea-507b9d2ee731','f22cd363-2809-4af4-9199-872c68ffc9be',NULL,'/upload\\20160415\\20160415113100_346.jpg','1445565400.jpg','2016-04-15 11:31:24',NULL,NULL),('88a48884-0c69-11e6-b057-507b9d2ee731','8b2a24b6-987e-4d0b-aa88-0f1ec2e17856',NULL,'/upload\\20160427\\20160427191635_993.jpg',NULL,'2016-04-27 19:16:37',NULL,NULL),('ad242b41-ffc0-11e5-a5ea-507b9d2ee731','adefd4bd-6bd1-4e49-ba50-04ea89a873dc',NULL,'/upload\\20160411\\20160411163447_561.gif','7e01d815fd7738da4a54ff8750d11a0a.gif','2016-04-11 16:37:50',NULL,'0'),('ad2474b8-ffc0-11e5-a5ea-507b9d2ee731','adefd4bd-6bd1-4e49-ba50-04ea89a873dc',NULL,'/upload\\20160411\\20160411163455_205.png','09.png','2016-04-11 16:37:50',NULL,'1'),('ad24bf57-ffc0-11e5-a5ea-507b9d2ee731','adefd4bd-6bd1-4e49-ba50-04ea89a873dc',NULL,'/upload\\20160411\\20160411163520_138.png','-1324875_50fe2515354fd.png','2016-04-11 16:37:50',NULL,'1'),('eedd34ef-0866-11e6-b42c-507b9d2ee731','e107efa3-2dd7-4787-a18e-4368edbe126b',NULL,'/upload\\20160422\\20160422163333_888.jpg','-7_54c5ca4c9d6a9.jpg','2016-04-22 16:47:32',NULL,NULL),('eeddb30b-0866-11e6-b42c-507b9d2ee731','e107efa3-2dd7-4787-a18e-4368edbe126b',NULL,'/upload\\20160422\\20160422164729_346.jpg','1.jpg','2016-04-22 16:47:32',NULL,'0'),('fd34d413-0557-11e6-83b2-507b9d2ee731','63352b6c-999f-4f7f-89f8-61f76b59d18c',NULL,'/upload\\20160408\\20160408162118_453.jpg','-7_54f7e7f792140.jpg','2016-04-18 19:23:25',NULL,NULL),('fd35242e-0557-11e6-83b2-507b9d2ee731','63352b6c-999f-4f7f-89f8-61f76b59d18c',NULL,'/upload\\20160415\\20160415172328_767.jpg','1.jpg','2016-04-18 19:23:25',NULL,'0');

/*Table structure for table `ts_appeal_orders` */

DROP TABLE IF EXISTS `ts_appeal_orders`;

CREATE TABLE `ts_appeal_orders` (
  `order_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态(0:关闭，1:完成)',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人ID',
  `finish_time` date DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '申诉说明',
  `close_time` date DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_appeal_orders` */

/*Table structure for table `ts_application_delay_records` */

DROP TABLE IF EXISTS `ts_application_delay_records`;

CREATE TABLE `ts_application_delay_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '操作人id',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `delay_time` datetime DEFAULT NULL COMMENT '延长到具体时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_application_delay_records` */

/*Table structure for table `ts_centralized_treatment_projects` */

DROP TABLE IF EXISTS `ts_centralized_treatment_projects`;

CREATE TABLE `ts_centralized_treatment_projects` (
  `project_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '集中处理项目id',
  `project_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '集中处理项目名称',
  `project_state` tinyint(4) DEFAULT NULL COMMENT '集中处理项状态',
  `project_type` tinyint(4) DEFAULT NULL COMMENT '集中处理项目类别',
  `project_professional` tinyint(4) DEFAULT NULL COMMENT '集中处理项目专业',
  `project_create` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '集中处理项目创建人',
  `project_start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `project_end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `project_estimate_area` double DEFAULT NULL COMMENT '项目累计面积',
  `project_estimate_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目预计个数',
  `project_reality_area` double DEFAULT NULL COMMENT '项目实际面积',
  `project_reality_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目实际个数',
  `remarks` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '备注说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_centralized_treatment_projects` */

/*Table structure for table `ts_centralized_treatment_projects_journal` */

DROP TABLE IF EXISTS `ts_centralized_treatment_projects_journal`;

CREATE TABLE `ts_centralized_treatment_projects_journal` (
  `record_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '项目日志记录id',
  `project_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '项目id',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `operation_person_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `change_state` tinyint(4) DEFAULT NULL COMMENT '改变状态',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='集中处理项日志记录表';

/*Data for the table `ts_centralized_treatment_projects_journal` */

/*Table structure for table `ts_check_item_records` */

DROP TABLE IF EXISTS `ts_check_item_records`;

CREATE TABLE `ts_check_item_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '检测记录id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `check_item_type` tinyint(4) DEFAULT NULL COMMENT '检测类型',
  `check_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '检测项名称',
  `check_item_result` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '检测结果',
  `is_through_insurance` tinyint(4) DEFAULT NULL COMMENT '是否过保',
  `is_abnormal` tinyint(4) DEFAULT NULL COMMENT '检查结果是否异常',
  `is_aftermarket` tinyint(4) DEFAULT NULL COMMENT '是否售后',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_check_item_records` */

/*Table structure for table `ts_check_orders` */

DROP TABLE IF EXISTS `ts_check_orders`;

CREATE TABLE `ts_check_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '检测工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `signatory` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '签字人',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_check_orders` */

/*Table structure for table `ts_claim_to_customer_methods` */

DROP TABLE IF EXISTS `ts_claim_to_customer_methods`;

CREATE TABLE `ts_claim_to_customer_methods` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '工单id',
  `claim_money` double(10,2) DEFAULT NULL COMMENT '赔付金案',
  `claim_state` tinyint(4) DEFAULT NULL COMMENT '赔付方式',
  `claim_cycle` tinyint(4) DEFAULT NULL COMMENT '赔付周期',
  `start_time` datetime DEFAULT NULL COMMENT '赔付开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '赔付结束时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='向客户索赔方案表';

/*Data for the table `ts_claim_to_customer_methods` */

/*Table structure for table `ts_claim_to_customer_orders` */

DROP TABLE IF EXISTS `ts_claim_to_customer_orders`;

CREATE TABLE `ts_claim_to_customer_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `customer_object_id` varchar(36) DEFAULT NULL COMMENT '索赔对象',
  `customer_object_name` varchar(36) DEFAULT NULL COMMENT '索赔对象名称',
  `customer_object_phonenum` varchar(36) DEFAULT NULL COMMENT '索赔对象号码',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `signature` varchar(36) DEFAULT NULL COMMENT '签字人',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='向客户索赔单';

/*Data for the table `ts_claim_to_customer_orders` */

/*Table structure for table `ts_closed` */

DROP TABLE IF EXISTS `ts_closed`;

CREATE TABLE `ts_closed` (
  `order_id` varchar(36) NOT NULL COMMENT '工单 id',
  `order_num` varchar(36) DEFAULT NULL COMMENT '工单编号',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` date DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '失效说明',
  `close_time` date DEFAULT NULL COMMENT '失效时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '失效操作人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_closed` */

/*Table structure for table `ts_compensate_methods` */

DROP TABLE IF EXISTS `ts_compensate_methods`;

CREATE TABLE `ts_compensate_methods` (
  `compensate_method_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '方案id',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `customer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联赔偿对象id',
  `compensate_sum` double(20,2) DEFAULT NULL COMMENT '赔付金额',
  `compensate_means` tinyint(4) DEFAULT NULL COMMENT '赔付方式（物业费、水费）',
  `compensate_cycle` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '赔付周期',
  `compensate_start_time` datetime DEFAULT NULL COMMENT '赔付开始时间',
  `compensate_end_time` datetime DEFAULT NULL COMMENT '赔付结束时间',
  PRIMARY KEY (`compensate_method_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_compensate_methods` */

/*Table structure for table `ts_compensate_object` */

DROP TABLE IF EXISTS `ts_compensate_object`;

CREATE TABLE `ts_compensate_object` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '记录id',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `customer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id（赔偿对象）',
  `compensate_sum` decimal(10,2) DEFAULT NULL COMMENT '赔偿金额（赔偿给业主金额、业主索赔金额）',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_compensate_object` */

/*Table structure for table `ts_compensate_owner` */

DROP TABLE IF EXISTS `ts_compensate_owner`;

CREATE TABLE `ts_compensate_owner` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '赔偿给业主工单表',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '任务ID',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '服务请求ID',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人ID',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人id',
  `close_remarks` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  `signature` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '签字人',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_compensate_owner` */

/*Table structure for table `ts_complaint_orders` */

DROP TABLE IF EXISTS `ts_complaint_orders`;

CREATE TABLE `ts_complaint_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '投诉工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `complaint_object_id` varchar(50) DEFAULT NULL COMMENT '投诉对象id',
  `complaint_object_name` varchar(50) DEFAULT NULL COMMENT '投诉对象姓名',
  `remarks` varchar(300) DEFAULT NULL COMMENT '投诉说明',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_complaint_orders` */

/*Table structure for table `ts_construction_acceptance_orders` */

DROP TABLE IF EXISTS `ts_construction_acceptance_orders`;

CREATE TABLE `ts_construction_acceptance_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `inspection_normal` tinyint(4) DEFAULT NULL COMMENT '是否正常',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='施工验收单';

/*Data for the table `ts_construction_acceptance_orders` */

/*Table structure for table `ts_construction_acceptance_records` */

DROP TABLE IF EXISTS `ts_construction_acceptance_records`;

CREATE TABLE `ts_construction_acceptance_records` (
  `record_id` varchar(36) NOT NULL COMMENT '验收记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '核查项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '核查项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '核查项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '验收项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='施工验收记录表';

/*Data for the table `ts_construction_acceptance_records` */

/*Table structure for table `ts_construction_annex` */

DROP TABLE IF EXISTS `ts_construction_annex`;

CREATE TABLE `ts_construction_annex` (
  `record_id` varchar(36) NOT NULL DEFAULT '' COMMENT '施工图纸附件(记录id)',
  `apply_id` varchar(36) DEFAULT NULL COMMENT '关联施工申请id',
  `drawing_type1` tinyint(4) DEFAULT NULL COMMENT '图纸类型1',
  `drawing_type2` tinyint(4) DEFAULT NULL COMMENT '图纸类型2',
  `annex_address` varchar(50) DEFAULT NULL COMMENT '附件地址',
  `annex_name` varchar(50) DEFAULT NULL COMMENT '附件名称',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_annex` */

/*Table structure for table `ts_construction_associated_record` */

DROP TABLE IF EXISTS `ts_construction_associated_record`;

CREATE TABLE `ts_construction_associated_record` (
  `record_id` varchar(36) NOT NULL COMMENT '施工单位关联表(记录id)',
  `apply_id` varchar(36) DEFAULT NULL COMMENT '关联施工申请id',
  `construction_id` varchar(36) DEFAULT NULL COMMENT '施工公司id',
  `head_id` varchar(36) DEFAULT NULL COMMENT '现场负责人id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_associated_record` */

/*Table structure for table `ts_construction_check_orders` */

DROP TABLE IF EXISTS `ts_construction_check_orders`;

CREATE TABLE `ts_construction_check_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `whether_to_continue` tinyint(4) DEFAULT NULL COMMENT '是否正常',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  `architectural_design` tinyint(4) DEFAULT NULL COMMENT '建筑设计图是否合理',
  `water_pipe_design` tinyint(4) DEFAULT NULL COMMENT '水施图是否合理',
  `circuit_design` tinyint(4) DEFAULT NULL COMMENT '电施图是否合理',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='施工核查单';

/*Data for the table `ts_construction_check_orders` */

/*Table structure for table `ts_construction_check_records` */

DROP TABLE IF EXISTS `ts_construction_check_records`;

CREATE TABLE `ts_construction_check_records` (
  `record_id` varchar(36) NOT NULL COMMENT '核查记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '核查项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '核查项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '核查项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '核查项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='施工核查结果记录表';

/*Data for the table `ts_construction_check_records` */

/*Table structure for table `ts_construction_component_records` */

DROP TABLE IF EXISTS `ts_construction_component_records`;

CREATE TABLE `ts_construction_component_records` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '施工组建记录（记录id)',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联施工申请id',
  `component_id` varchar(36) DEFAULT NULL,
  `component_name` varchar(50) DEFAULT NULL COMMENT '组建名称',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_component_records` */

/*Table structure for table `ts_construction_disclose_information` */

DROP TABLE IF EXISTS `ts_construction_disclose_information`;

CREATE TABLE `ts_construction_disclose_information` (
  `file_id` varchar(36) NOT NULL COMMENT '施工单位提交资料记录表(文件id)',
  `apply_id` varchar(36) DEFAULT NULL COMMENT '关联施工申请id',
  `file_type` tinyint(4) DEFAULT NULL COMMENT '文件类型',
  `file_name` varchar(50) DEFAULT NULL COMMENT '文件名称',
  `file_address` varchar(50) DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_disclose_information` */

/*Table structure for table `ts_construction_inspection_orders` */

DROP TABLE IF EXISTS `ts_construction_inspection_orders`;

CREATE TABLE `ts_construction_inspection_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `inspection_normal` tinyint(4) DEFAULT NULL COMMENT '是否正常',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='施工巡检单';

/*Data for the table `ts_construction_inspection_orders` */

/*Table structure for table `ts_construction_inspection_records` */

DROP TABLE IF EXISTS `ts_construction_inspection_records`;

CREATE TABLE `ts_construction_inspection_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '巡检项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '巡检项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '巡检项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '巡检项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='施工巡检记录表';

/*Data for the table `ts_construction_inspection_records` */

/*Table structure for table `ts_construction_personnel_associated` */

DROP TABLE IF EXISTS `ts_construction_personnel_associated`;

CREATE TABLE `ts_construction_personnel_associated` (
  `record_id` varchar(36) NOT NULL DEFAULT '' COMMENT '施工人员关联表(记录id)',
  `apply_id` varchar(36) DEFAULT NULL COMMENT '关联施工申请id',
  `personnel_id` varchar(36) DEFAULT NULL COMMENT '施工人员id',
  `personnel_name` varchar(50) DEFAULT NULL COMMENT '施工人员姓名',
  `personnel_phone` varchar(30) DEFAULT NULL COMMENT '施工人员电话',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_personnel_associated` */

/*Table structure for table `ts_construction_record_card` */

DROP TABLE IF EXISTS `ts_construction_record_card`;

CREATE TABLE `ts_construction_record_card` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '备案证id',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请Id',
  `property_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '物业公司id',
  `property_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '物业公司名称',
  `card_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '证件号',
  `cust_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '业主id',
  `address_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '施工地址id',
  `construction_star_time` datetime DEFAULT NULL COMMENT '施工开始时间',
  `construction_finish_time` datetime DEFAULT NULL COMMENT '施工结束时间',
  `decorate_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修单位id',
  `head_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '现场负责人Id',
  `fire_approval` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '消防批文号',
  `decorate_project` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修项目',
  `angent_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '签发人id',
  `construction_scope` tinyint(4) DEFAULT NULL COMMENT '0.装修施工 1.装饰施工 2.临时施工',
  `registration_time` datetime DEFAULT NULL COMMENT '办证时间',
  `daily_star_time` datetime DEFAULT NULL COMMENT '每日施工开始时间',
  `daily_finish_time` datetime DEFAULT NULL COMMENT '每日施工结束时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_record_card` */

/*Table structure for table `ts_construction_service_request_associated` */

DROP TABLE IF EXISTS `ts_construction_service_request_associated`;

CREATE TABLE `ts_construction_service_request_associated` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '施工服务请求关联表（记录ID）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联施工申请id',
  `service_request_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_construction_service_request_associated` */

/*Table structure for table `ts_consultation_orders` */

DROP TABLE IF EXISTS `ts_consultation_orders`;

CREATE TABLE `ts_consultation_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `problem_type` tinyint(4) DEFAULT NULL COMMENT '客户问题类型',
  `problem_professional` tinyint(4) DEFAULT NULL COMMENT '客户问题专业',
  `problem_remarks` varchar(300) DEFAULT NULL COMMENT '客户问题描述',
  `remarks` varchar(300) DEFAULT NULL COMMENT '说明',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `order_num` varchar(36) DEFAULT NULL COMMENT '工单编号',
  `faq_question_id` varchar(36) DEFAULT NULL COMMENT '引用FAQid',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_consultation_orders` */

/*Table structure for table `ts_decorate_annex` */

DROP TABLE IF EXISTS `ts_decorate_annex`;

CREATE TABLE `ts_decorate_annex` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修图纸附件（记录id）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请Id',
  `drawing_type1` tinyint(4) DEFAULT NULL COMMENT '0.原图 1.设计图',
  `drawing_type2` tinyint(4) DEFAULT NULL COMMENT '0.建筑图 1.水路图 2.电路图',
  `annex_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '附件地址',
  `annex_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '附件名称',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decorate_annex` */

/*Table structure for table `ts_decorate_apply_journal` */

DROP TABLE IF EXISTS `ts_decorate_apply_journal`;

CREATE TABLE `ts_decorate_apply_journal` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修申请日志（记录id）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请id',
  `operator_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `change_state` tinyint(4) DEFAULT NULL COMMENT '状态变更',
  `remarks` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decorate_apply_journal` */

/*Table structure for table `ts_decorate_associated_record` */

DROP TABLE IF EXISTS `ts_decorate_associated_record`;

CREATE TABLE `ts_decorate_associated_record` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修单位关联表（记录ID）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请ID',
  `decorate_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修公司ID',
  `head_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '现场负责人ID',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decorate_associated_record` */

/*Table structure for table `ts_decorate_component_records` */

DROP TABLE IF EXISTS `ts_decorate_component_records`;

CREATE TABLE `ts_decorate_component_records` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修组件记录表（记录ID）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请id',
  `component_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '组件ID',
  `component_name` varchar(50) DEFAULT NULL COMMENT '组件名称',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decorate_component_records` */

/*Table structure for table `ts_decorate_personnel_associated` */

DROP TABLE IF EXISTS `ts_decorate_personnel_associated`;

CREATE TABLE `ts_decorate_personnel_associated` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修人员关联表（记录id）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请id',
  `personnel_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修人员id',
  `personnel_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修人员姓名',
  `personnel_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修人员电话',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decorate_personnel_associated` */

/*Table structure for table `ts_decoration_inspection_plans` */

DROP TABLE IF EXISTS `ts_decoration_inspection_plans`;

CREATE TABLE `ts_decoration_inspection_plans` (
  `decoration_inspection_plan_id` varchar(36) NOT NULL COMMENT '装修巡检方案id',
  `decoration_inspection_plan_num` varchar(36) DEFAULT NULL COMMENT '巡检方案id',
  `decoration_inspection_plan_name` varchar(50) DEFAULT NULL COMMENT '装修巡检方案名称',
  `decoration_inspection_plan_remarks` varchar(300) DEFAULT NULL COMMENT '装修巡检方案说明',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `cre_user_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `cre_tme` datetime DEFAULT NULL COMMENT '创建时间',
  `effective_time` datetime DEFAULT NULL COMMENT '生效时间',
  `failure_time` datetime DEFAULT NULL COMMENT '失效时间',
  PRIMARY KEY (`decoration_inspection_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decoration_inspection_plans` */

/*Table structure for table `ts_decoreate_disclose_information` */

DROP TABLE IF EXISTS `ts_decoreate_disclose_information`;

CREATE TABLE `ts_decoreate_disclose_information` (
  `file_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '文件id',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请ID',
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '文件名称',
  `file_type` tinyint(4) DEFAULT NULL COMMENT '文件类型',
  `file_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '文件地址',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decoreate_disclose_information` */

/*Table structure for table `ts_decoreate_inspection_records` */

DROP TABLE IF EXISTS `ts_decoreate_inspection_records`;

CREATE TABLE `ts_decoreate_inspection_records` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修巡检记录表（记录id)',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请id',
  `order_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修关联巡检工单Id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decoreate_inspection_records` */

/*Table structure for table `ts_decoreate_service_request_associated` */

DROP TABLE IF EXISTS `ts_decoreate_service_request_associated`;

CREATE TABLE `ts_decoreate_service_request_associated` (
  `record_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修服务请求关联表（记录id）',
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联装修申请id',
  `service_request_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '装修关联服务请求id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_decoreate_service_request_associated` */

/*Table structure for table `ts_department_orders` */

DROP TABLE IF EXISTS `ts_department_orders`;

CREATE TABLE `ts_department_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '部门质检工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `order_writer` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单负责人',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注说明',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_department_orders` */

/*Table structure for table `ts_department_records` */

DROP TABLE IF EXISTS `ts_department_records`;

CREATE TABLE `ts_department_records` (
  `result_record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '结果记录id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `check_object_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '检查对象id',
  `check_object_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '检查对象姓名',
  `check_time` datetime DEFAULT NULL COMMENT '检查日期',
  `score` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`result_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_department_records` */

/*Table structure for table `ts_dispose_information_records` */

DROP TABLE IF EXISTS `ts_dispose_information_records`;

CREATE TABLE `ts_dispose_information_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '处理记录项id',
  `order_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `check_item_type` tinyint(4) DEFAULT NULL COMMENT '处理项类型',
  `check_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理项名称',
  `check_item_result` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理结果',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_dispose_information_records` */

/*Table structure for table `ts_dispose_order` */

DROP TABLE IF EXISTS `ts_dispose_order`;

CREATE TABLE `ts_dispose_order` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '处理工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单关闭人',
  `close_time` datetime DEFAULT NULL COMMENT '工单关闭时间',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_dispose_order` */

/*Table structure for table `ts_execution_time_records` */

DROP TABLE IF EXISTS `ts_execution_time_records`;

CREATE TABLE `ts_execution_time_records` (
  `executive_num_id` varchar(36) NOT NULL COMMENT '执行次数id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `record_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求执行频率率id',
  `executive_num` tinyint(4) DEFAULT NULL COMMENT '执行次数序号',
  `executive_num_time` datetime DEFAULT NULL COMMENT '执行时间',
  PRIMARY KEY (`executive_num_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_execution_time_records` */

/*Table structure for table `ts_faq_journals` */

DROP TABLE IF EXISTS `ts_faq_journals`;

CREATE TABLE `ts_faq_journals` (
  `faq_journal_id` varchar(36) NOT NULL COMMENT 'FAQ日志记录id',
  `relation_id` varchar(36) DEFAULT NULL COMMENT '关联对象id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '操作人id',
  `change_state` varchar(36) DEFAULT NULL COMMENT '状态变更',
  `operation_remarks` varchar(36) DEFAULT NULL COMMENT '操作说明',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`faq_journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='faq日志记录表';

/*Data for the table `ts_faq_journals` */

/*Table structure for table `ts_faq_types` */

DROP TABLE IF EXISTS `ts_faq_types`;

CREATE TABLE `ts_faq_types` (
  `faq_type_id` varchar(36) NOT NULL DEFAULT '' COMMENT 'faq类别主键',
  `faq_type_name` varchar(36) DEFAULT NULL COMMENT 'faq类别名称',
  `cre_time` datetime DEFAULT NULL COMMENT '创建时间',
  `cre_person_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`faq_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='FAQ类别表';

/*Data for the table `ts_faq_types` */

insert  into `ts_faq_types`(`faq_type_id`,`faq_type_name`,`cre_time`,`cre_person_id`) values ('1d4a2900-e032-4e9f-8ba6-f863fe3466db','1','2016-05-09 18:13:01','cbcc541d-fd65-11e5-9433-507b9d2ee731');

/*Table structure for table `ts_faqs` */

DROP TABLE IF EXISTS `ts_faqs`;

CREATE TABLE `ts_faqs` (
  `faq_question_id` varchar(36) NOT NULL COMMENT '问题id',
  `faq_question_num` varchar(36) DEFAULT NULL COMMENT '问题编号',
  `faq_question_state` tinyint(4) DEFAULT NULL COMMENT '问题状态',
  `faq_question_name` varchar(50) DEFAULT NULL COMMENT '问题内容',
  `faq_question_answer` varchar(500) DEFAULT NULL COMMENT '答案',
  `faq_type_id` varchar(36) DEFAULT NULL COMMENT 'faq类别id',
  `keyword` varchar(36) DEFAULT NULL COMMENT '关键字',
  `cre_person_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `cre_time` datetime DEFAULT NULL COMMENT '创建时间',
  `person_cust_id` varchar(36) DEFAULT NULL COMMENT '关联客户id',
  PRIMARY KEY (`faq_question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_faqs` */

insert  into `ts_faqs`(`faq_question_id`,`faq_question_num`,`faq_question_state`,`faq_question_name`,`faq_question_answer`,`faq_type_id`,`keyword`,`cre_person_id`,`cre_time`,`person_cust_id`) values ('3d881365-4b12-4145-8a7e-a4a0cf8976d6','',0,'1','1','1d4a2900-e032-4e9f-8ba6-f863fe3466db',NULL,'cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-09 18:13:04',NULL);

/*Table structure for table `ts_fixed_parking_orders` */

DROP TABLE IF EXISTS `ts_fixed_parking_orders`;

CREATE TABLE `ts_fixed_parking_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `parking_operation` tinyint(4) DEFAULT NULL COMMENT '固定车位取消和开启操作',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_fixed_parking_orders` */

/*Table structure for table `ts_frequency_record` */

DROP TABLE IF EXISTS `ts_frequency_record`;

CREATE TABLE `ts_frequency_record` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '记录id',
  `relation_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '服务请求id',
  `frequency_type` tinyint(4) DEFAULT NULL COMMENT '频率类型',
  `execution_frequency` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '执行频率',
  `execution_frequency_num` tinyint(4) DEFAULT NULL COMMENT '执行次数',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_frequency_record` */

/*Table structure for table `ts_handle_mechanism` */

DROP TABLE IF EXISTS `ts_handle_mechanism`;

CREATE TABLE `ts_handle_mechanism` (
  `handle_id` varchar(36) NOT NULL COMMENT '处理机制id',
  `handle_type` tinyint(4) DEFAULT NULL COMMENT '处理机制类型',
  `important_event_type_id` varchar(36) DEFAULT NULL COMMENT '关联重大事项类型id',
  `establish_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `principal` varchar(36) DEFAULT NULL COMMENT '负责人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '处理描述',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态（0有效1失效）',
  PRIMARY KEY (`handle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处理机制表';

/*Data for the table `ts_handle_mechanism` */

insert  into `ts_handle_mechanism`(`handle_id`,`handle_type`,`important_event_type_id`,`establish_id`,`principal`,`create_time`,`remarks`,`state`) values ('0dcbd393-d09c-45b4-b49b-99bda2ad0bb1',2,'c9c236a6-39b4-44a1-b8ee-e903a60721ff','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 00:00:00','78',0),('4d2e59c0-8278-4575-8066-90b36c85e993',1,'c9c236a6-39b4-44a1-b8ee-e903a60721ff','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 00:00:00','312',1),('5c0757ab-8eed-44df-9fa9-dfaabb81520f',11,'c9c236a6-39b4-44a1-b8ee-e903a60721ff','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 00:00:00','1',1),('a8dbdf07-871f-4779-88ea-b41c1a2f58aa',0,'0bcec7d4-9ca8-4b1d-9d18-f7dba5f84b61','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 00:00:00','任务1',1),('cc01b28d-7111-45ff-a21a-871bd6a2cd45',2,'26e1ef82-7d4e-4460-821b-92c3e3c317cd','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 16:02:05','111',1),('f1ae0e78-23ef-45fd-8304-0c1eb453a433',1,'94a7e2a4-9bf4-4a82-8c4c-07b8e4932606','1fb37077-bbee-44f9-b235-9af0f0e53e3e','cbcc541d-fd65-11e5-9433-507b9d2ee731','2016-05-06 00:00:00','123',1);

/*Table structure for table `ts_important_event_type` */

DROP TABLE IF EXISTS `ts_important_event_type`;

CREATE TABLE `ts_important_event_type` (
  `important_event_type_id` varchar(36) NOT NULL COMMENT '重大事项类型id',
  `important_event_num` varchar(36) DEFAULT NULL COMMENT '重大事项编号',
  `important_event_type_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `establish_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`important_event_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='重大事项类型表';

/*Data for the table `ts_important_event_type` */

insert  into `ts_important_event_type`(`important_event_type_id`,`important_event_num`,`important_event_type_name`,`state`,`establish_id`,`create_time`,`remarks`) values ('0bcec7d4-9ca8-4b1d-9d18-f7dba5f84b61',NULL,'重大事项1',1,'1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-05-06 14:41:02',NULL),('26e1ef82-7d4e-4460-821b-92c3e3c317cd',NULL,'重大事项3',1,'1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-05-06 14:45:46',NULL),('94a7e2a4-9bf4-4a82-8c4c-07b8e4932606',NULL,'重大事项2',1,'1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-05-06 14:43:25',NULL),('c9c236a6-39b4-44a1-b8ee-e903a60721ff',NULL,'5555',1,'1fb37077-bbee-44f9-b235-9af0f0e53e3e','2016-05-06 16:02:41',NULL);

/*Table structure for table `ts_important_event_type_journal` */

DROP TABLE IF EXISTS `ts_important_event_type_journal`;

CREATE TABLE `ts_important_event_type_journal` (
  `reord_id` varchar(36) NOT NULL COMMENT '记录id',
  `important_event_type_id` varchar(36) DEFAULT NULL COMMENT '关联重大事项类型id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '操作人id',
  `change_state` tinyint(4) DEFAULT NULL COMMENT '状态变更',
  `operator_time` datetime DEFAULT NULL COMMENT '操作时间',
  `remarks` varchar(36) DEFAULT NULL COMMENT '操作说明',
  PRIMARY KEY (`reord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='重大事项类型日志记录表';

/*Data for the table `ts_important_event_type_journal` */

insert  into `ts_important_event_type_journal`(`reord_id`,`important_event_type_id`,`operator_id`,`change_state`,`operator_time`,`remarks`) values ('4d2e59c0-8278-4575-8066-90b36c85e993','c9c236a6-39b4-44a1-b8ee-e903a60721ff','1fb37077-bbee-44f9-b235-9af0f0e53e3e',NULL,'2016-05-06 00:00:00','超级管理员创建了处理机制'),('5c0757ab-8eed-44df-9fa9-dfaabb81520f','c9c236a6-39b4-44a1-b8ee-e903a60721ff','1fb37077-bbee-44f9-b235-9af0f0e53e3e',NULL,'2016-05-06 00:00:00','超级管理员创建了处理机制');

/*Table structure for table `ts_inspection_configuration` */

DROP TABLE IF EXISTS `ts_inspection_configuration`;

CREATE TABLE `ts_inspection_configuration` (
  `reord_id` varchar(36) NOT NULL COMMENT '记录id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `principal_id` varchar(36) DEFAULT NULL COMMENT '巡检负责人id',
  `inspection_property_id` varchar(36) DEFAULT NULL COMMENT '巡检目标id',
  `inspection_ plan_id` varchar(36) DEFAULT NULL COMMENT '关联巡检方案id',
  PRIMARY KEY (`reord_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_inspection_configuration` */

/*Table structure for table `ts_inspection_plan` */

DROP TABLE IF EXISTS `ts_inspection_plan`;

CREATE TABLE `ts_inspection_plan` (
  `inspection_plan_id` varchar(36) NOT NULL COMMENT '巡检方案id',
  `plan_cycle` varchar(36) DEFAULT NULL COMMENT '巡检周期',
  `department_id` varchar(36) DEFAULT NULL COMMENT '部门id',
  `inspection_plan_name` varchar(36) DEFAULT NULL COMMENT '巡检方案名称',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(36) DEFAULT NULL COMMENT '巡检方案描述',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `create_person_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `close_time` date DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭说明',
  PRIMARY KEY (`inspection_plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_inspection_plan` */

/*Table structure for table `ts_inspection_property_check_item` */

DROP TABLE IF EXISTS `ts_inspection_property_check_item`;

CREATE TABLE `ts_inspection_property_check_item` (
  `inspection_check_item_id` varchar(36) NOT NULL COMMENT '记录id',
  `inspection_plan_id` varchar(36) DEFAULT NULL COMMENT '关联巡检方案id',
  `num` varchar(36) DEFAULT NULL COMMENT '巡检项序号',
  `check_item_name` varchar(36) DEFAULT NULL COMMENT '巡检项名称',
  `check_item_unit` varchar(36) DEFAULT NULL COMMENT '巡检项单位',
  `check_item_reference` varchar(300) DEFAULT NULL COMMENT '巡检项说明',
  `input_type` tinyint(4) DEFAULT NULL COMMENT '输入类型',
  PRIMARY KEY (`inspection_check_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_inspection_property_check_item` */

/*Table structure for table `ts_inspector_order` */

DROP TABLE IF EXISTS `ts_inspector_order`;

CREATE TABLE `ts_inspector_order` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `task_id` varchar(36) DEFAULT NULL COMMENT '任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '服务请求id',
  `create_person_id` varchar(36) DEFAULT NULL COMMENT '负责人',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `inspector_normal` tinyint(4) DEFAULT NULL COMMENT '验房情况(0正常,1不正常)',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `close_person` varchar(36) DEFAULT NULL COMMENT '关闭人',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验房工单';

/*Data for the table `ts_inspector_order` */

/*Table structure for table `ts_inspector_record` */

DROP TABLE IF EXISTS `ts_inspector_record`;

CREATE TABLE `ts_inspector_record` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '工单id',
  `check_items_id` varchar(36) DEFAULT NULL COMMENT '检测项id',
  `check_items_name` varchar(36) DEFAULT NULL COMMENT '检测项名称',
  `check_items_normal` tinyint(4) DEFAULT NULL COMMENT '检测项是否正常',
  `guarantee_period` tinyint(4) DEFAULT NULL COMMENT '0已过保，1未过保',
  `whether_after_sale` tinyint(4) DEFAULT NULL COMMENT '0否，1是',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='验房记录表';

/*Data for the table `ts_inspector_record` */

/*Table structure for table `ts_letter_records` */

DROP TABLE IF EXISTS `ts_letter_records`;

CREATE TABLE `ts_letter_records` (
  `record_id` varchar(36) NOT NULL COMMENT '是否发函记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `letter_id` varchar(36) DEFAULT NULL COMMENT '函件id',
  `letter_name` varchar(50) DEFAULT NULL COMMENT '函件名称',
  `whether_letter` tinyint(4) DEFAULT NULL COMMENT '是否建议发函',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_letter_records` */

/*Table structure for table `ts_meter_reading_orders` */

DROP TABLE IF EXISTS `ts_meter_reading_orders`;

CREATE TABLE `ts_meter_reading_orders` (
  `order_id` varchar(36) NOT NULL,
  `order_state` tinyint(4) DEFAULT NULL,
  `order_type` tinyint(4) DEFAULT NULL,
  `task_id` varchar(36) DEFAULT NULL,
  `service_request_id` varchar(36) DEFAULT NULL,
  `operator_id` varchar(36) DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `remarks` varchar(300) DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `close_person_id` varchar(36) DEFAULT NULL,
  `close_remarks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电表抄表工单';

/*Data for the table `ts_meter_reading_orders` */

/*Table structure for table `ts_meter_reading_records` */

DROP TABLE IF EXISTS `ts_meter_reading_records`;

CREATE TABLE `ts_meter_reading_records` (
  `record_id` varchar(36) NOT NULL,
  `order_id` varchar(36) DEFAULT NULL,
  `meter_id` varchar(36) DEFAULT NULL,
  `water_meter_reading` double(10,2) DEFAULT NULL,
  `water_meter_last_reading` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电表抄表结果记录表';

/*Data for the table `ts_meter_reading_records` */

/*Table structure for table `ts_owner_construction_apply` */

DROP TABLE IF EXISTS `ts_owner_construction_apply`;

CREATE TABLE `ts_owner_construction_apply` (
  `apply_id` varchar(36) NOT NULL DEFAULT '' COMMENT '施工申请id',
  `cust_id` varchar(36) DEFAULT NULL COMMENT '业主id',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_type` tinyint(4) DEFAULT NULL COMMENT '申请状态',
  `construction_type` tinyint(4) DEFAULT NULL COMMENT '施工类型',
  `estimated_star_time` datetime DEFAULT NULL COMMENT '施工预计开始时间',
  `estimated_finish_time` datetime DEFAULT NULL COMMENT '施工预计结束时间',
  `dismantles_wall_area` double(10,2) DEFAULT NULL COMMENT '预计拆墙面积',
  `actual_dismantles_wall_area` double(10,2) DEFAULT NULL COMMENT '实际拆墙面积',
  `angent_id` varchar(36) DEFAULT NULL COMMENT '经办人id',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `server_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_owner_construction_apply` */

/*Table structure for table `ts_owner_renovation_apply` */

DROP TABLE IF EXISTS `ts_owner_renovation_apply`;

CREATE TABLE `ts_owner_renovation_apply` (
  `apply_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '装修申请ID',
  `cust_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '业主ID',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_type` tinyint(4) DEFAULT NULL COMMENT '申请状态',
  `decorate_type` tinyint(4) DEFAULT NULL COMMENT '装修类型',
  `estimated_star_time` datetime DEFAULT NULL COMMENT '装修预计开始时间',
  `estimated_finish_time` datetime DEFAULT NULL COMMENT '装修预计结束时间',
  `angent_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '经办人id',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  `dismantles_wall_area` double(10,2) DEFAULT NULL COMMENT '预计拆墙面积',
  `actual_dismantles_wall_area` double(10,2) DEFAULT NULL COMMENT '实际拆墙面积',
  `server_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求',
  PRIMARY KEY (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_owner_renovation_apply` */

/*Table structure for table `ts_praise_orders` */

DROP TABLE IF EXISTS `ts_praise_orders`;

CREATE TABLE `ts_praise_orders` (
  `order_id` varchar(36) NOT NULL,
  `order_type` tinyint(4) NOT NULL,
  `order_state` tinyint(4) NOT NULL,
  `task_id` varchar(36) NOT NULL,
  `service_request_id` varchar(36) NOT NULL,
  `operator_id` varchar(36) NOT NULL,
  `finish_time` datetime NOT NULL,
  `praise_object_id` varchar(36) NOT NULL,
  `praise_object_name` varchar(50) NOT NULL COMMENT '表扬对象姓名',
  `remarks` varchar(300) DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `close_person_id` varchar(36) DEFAULT NULL,
  `close_remarks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_praise_orders` */

/*Table structure for table `ts_quote_item_records` */

DROP TABLE IF EXISTS `ts_quote_item_records`;

CREATE TABLE `ts_quote_item_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '报价记录id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `quote_item_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '报价项id',
  `quote_item_type` tinyint(4) DEFAULT NULL COMMENT '报价项类型',
  `quote_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '报价项名称',
  `quote_item_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '报价项数量',
  `quote_item_total` double(10,2) DEFAULT NULL COMMENT '报价项总价',
  `quote_item_price` double(10,2) DEFAULT NULL COMMENT '报价项单价',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_quote_item_records` */

/*Table structure for table `ts_quote_orders` */

DROP TABLE IF EXISTS `ts_quote_orders`;

CREATE TABLE `ts_quote_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '报价工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `discount` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '折扣',
  `final_price` double(10,2) DEFAULT NULL COMMENT '最终价格',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `all_total` decimal(10,0) DEFAULT NULL COMMENT '全部总价',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注说明',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭时间',
  `signature` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '签字人',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_quote_orders` */

/*Table structure for table `ts_renovation_acceptance_orders` */

DROP TABLE IF EXISTS `ts_renovation_acceptance_orders`;

CREATE TABLE `ts_renovation_acceptance_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '装修验收工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `inspector_normal` tinyint(4) DEFAULT NULL COMMENT '是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '描述',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `wall_area` double(10,2) DEFAULT NULL COMMENT '拆墙面积',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_renovation_acceptance_orders` */

/*Table structure for table `ts_renovation_acceptance_records` */

DROP TABLE IF EXISTS `ts_renovation_acceptance_records`;

CREATE TABLE `ts_renovation_acceptance_records` (
  `record_id` varchar(36) NOT NULL COMMENT '验收记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '检验项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '检验项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '检验项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '检验项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_renovation_acceptance_records` */

/*Table structure for table `ts_renovation_check_orders` */

DROP TABLE IF EXISTS `ts_renovation_check_orders`;

CREATE TABLE `ts_renovation_check_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '装修核查工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `whether_to_continue` tinyint(4) DEFAULT NULL COMMENT '是否可继续装修',
  `remarks` varchar(300) DEFAULT NULL COMMENT '描述',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `wall_area` double(10,2) DEFAULT NULL COMMENT '拆墙面积',
  `architectural_design` tinyint(4) DEFAULT NULL COMMENT '建筑设计图是否合理',
  `water_pipe_design` tinyint(4) DEFAULT NULL COMMENT '水施图是否合理',
  `circuit_design` tinyint(4) DEFAULT NULL COMMENT '电施图是否合理',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_renovation_check_orders` */

/*Table structure for table `ts_renovation_check_records` */

DROP TABLE IF EXISTS `ts_renovation_check_records`;

CREATE TABLE `ts_renovation_check_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '核查项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '核查项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '核查项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '检查项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='装修核查记录表';

/*Data for the table `ts_renovation_check_records` */

/*Table structure for table `ts_renovation_inspection_orders` */

DROP TABLE IF EXISTS `ts_renovation_inspection_orders`;

CREATE TABLE `ts_renovation_inspection_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '创建时间',
  `inspection_normal` tinyint(4) DEFAULT NULL COMMENT '是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '描述',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭原因',
  `wall_area` double(10,2) DEFAULT NULL COMMENT '拆墙面积',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_renovation_inspection_orders` */

/*Table structure for table `ts_renovation_inspection_records` */

DROP TABLE IF EXISTS `ts_renovation_inspection_records`;

CREATE TABLE `ts_renovation_inspection_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `inspect_id` varchar(36) DEFAULT NULL COMMENT '巡检项id',
  `inspect_name` varchar(50) DEFAULT NULL COMMENT '巡检项名称',
  `normal` tinyint(4) DEFAULT NULL COMMENT '巡检项是否正常',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注说明',
  `conduct` tinyint(4) DEFAULT NULL COMMENT '巡检项是否进行',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_renovation_inspection_records` */

/*Table structure for table `ts_repair_orders` */

DROP TABLE IF EXISTS `ts_repair_orders`;

CREATE TABLE `ts_repair_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_num` varchar(36) DEFAULT NULL COMMENT '工单编号',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '操作人id',
  `node_id` varchar(36) DEFAULT NULL COMMENT '分类id',
  `remarks` varchar(300) DEFAULT NULL COMMENT '说明',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_remarks` varchar(100) DEFAULT NULL COMMENT '关闭说明',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修单';

/*Data for the table `ts_repair_orders` */

/*Table structure for table `ts_return_visit_orders` */

DROP TABLE IF EXISTS `ts_return_visit_orders`;

CREATE TABLE `ts_return_visit_orders` (
  `order_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '回访工单ID',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务ID',
  `service_request_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `completion_score` tinyint(4) DEFAULT NULL COMMENT '完成情况评分',
  `attitude_score` tinyint(4) DEFAULT NULL COMMENT '处理态度评分',
  `processing_time_score` tinyint(4) DEFAULT NULL COMMENT '处理时间评分',
  `finish_time` date DEFAULT NULL COMMENT '完成时间',
  `remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注描述',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '关闭说明',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_return_visit_orders` */

/*Table structure for table `ts_score_criteria` */

DROP TABLE IF EXISTS `ts_score_criteria`;

CREATE TABLE `ts_score_criteria` (
  `scoring_criteria_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '评分标准id',
  `scoring_criteria_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '评分标准名称',
  `cycle` tinyint(4) DEFAULT NULL COMMENT '周期类型',
  `scoring_criteria_type` tinyint(4) DEFAULT NULL COMMENT '评分标准类型',
  `scoring_criteria_state` tinyint(4) DEFAULT NULL COMMENT '评分标准状态',
  `relation_post` tinyint(4) DEFAULT NULL COMMENT '岗位',
  `department` tinyint(4) DEFAULT NULL COMMENT '部门',
  `remarks` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_person_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭备注',
  PRIMARY KEY (`scoring_criteria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_score_criteria` */

/*Table structure for table `ts_score_criteria_items` */

DROP TABLE IF EXISTS `ts_score_criteria_items`;

CREATE TABLE `ts_score_criteria_items` (
  `scoring_criteria_item_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '评分项id',
  `scoring_criteria_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '评分项名称',
  `scoring_criteria_item_number` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '序号',
  `scoring_criteria_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联评分标准id',
  `weight` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '权重',
  PRIMARY KEY (`scoring_criteria_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_score_criteria_items` */

/*Table structure for table `ts_score_subitem_items` */

DROP TABLE IF EXISTS `ts_score_subitem_items`;

CREATE TABLE `ts_score_subitem_items` (
  `score_subitem_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '评分子项id',
  `score_subitem_name` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '评分子项名称',
  `score_subitem_number` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '评分子项序号',
  `scoring_criteria_item_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联评分项id（这就是评分子项的父项）',
  `weight` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '权重',
  `score_1` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '评分1评分标准描述',
  `score_2` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '评分2评分标准描述',
  `score_3` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '评分3评分标准描述',
  `score_4` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '评分4评分标准描述',
  `score_5` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '评分5评分标准描述',
  PRIMARY KEY (`score_subitem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_score_subitem_items` */

/*Table structure for table `ts_service_object_records` */

DROP TABLE IF EXISTS `ts_service_object_records`;

CREATE TABLE `ts_service_object_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '记录id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '服务请求id',
  `service_object_type` tinyint(4) DEFAULT NULL COMMENT '服务对象类型',
  `service_object_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '服务对象id',
  `criteria_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '评分标准id',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_service_object_records` */

/*Table structure for table `ts_service_request` */

DROP TABLE IF EXISTS `ts_service_request`;

CREATE TABLE `ts_service_request` (
  `service_request_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '服务请求id',
  `request_time` datetime DEFAULT NULL COMMENT '请求时间',
  `service_request_type` tinyint(4) unsigned DEFAULT NULL COMMENT '服务请求类型(判断报事类型)',
  `request_source` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '请求来源',
  `service_request_state` tinyint(4) DEFAULT NULL COMMENT '服务请求状态',
  `service_request_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '服务请求名称',
  `customer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id',
  `direction_type` tinyint(4) DEFAULT NULL COMMENT '服务请求类型（内部服务请求，外部服务请求）',
  `quality_company_type` tinyint(4) DEFAULT NULL COMMENT '质检下级单位',
  `review_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '回访对象id',
  `important_event` tinyint(4) DEFAULT NULL COMMENT '是否重大事项',
  `important_event_type_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '重大事项类型id',
  `writer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注描述',
  `anxious` tinyint(4) DEFAULT NULL COMMENT '加急',
  `access_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '接入电话',
  PRIMARY KEY (`service_request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_service_request` */

insert  into `ts_service_request`(`service_request_id`,`request_time`,`service_request_type`,`request_source`,`service_request_state`,`service_request_name`,`customer_id`,`direction_type`,`quality_company_type`,`review_id`,`important_event`,`important_event_type_id`,`writer_id`,`remarks`,`anxious`,`access_phone`) values ('f0236bba-baec-4007-8856-d21352814faa','2016-05-03 14:08:01',0,'前台',2,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',0,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',0,NULL,'f22cd363-2809-4af4-9199-872c68ffc9be',NULL,0,NULL);

/*Table structure for table `ts_service_request_journal` */

DROP TABLE IF EXISTS `ts_service_request_journal`;

CREATE TABLE `ts_service_request_journal` (
  `service_request_journal_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '服务请求日志id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `cre_task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建任务id',
  `cre_task_type` tinyint(4) DEFAULT NULL COMMENT '创建的任务类型',
  `change_state` tinyint(4) DEFAULT NULL COMMENT '状态修改',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注描述',
  PRIMARY KEY (`service_request_journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_service_request_journal` */

insert  into `ts_service_request_journal`(`service_request_journal_id`,`service_request_id`,`operator_id`,`operation_time`,`cre_task_id`,`cre_task_type`,`change_state`,`remarks`) values ('6e1dae72-10f5-11e6-a92c-507b9d2ee731','f0236bba-baec-4007-8856-d21352814faa',NULL,'2016-05-03 14:08:01','c935dc24-c1a2-4b4e-a76b-100495ff8f16',0,2,NULL);

/*Table structure for table `ts_settle_accounts_item_records` */

DROP TABLE IF EXISTS `ts_settle_accounts_item_records`;

CREATE TABLE `ts_settle_accounts_item_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '记录id',
  `order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联工单id',
  `settle_accounts_item_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '结算项id',
  `settle_accounts_item_type` tinyint(4) DEFAULT NULL COMMENT '结算类型',
  `settle_accounts_item_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '结算项名称',
  `settle_accounts_item_num` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '结算项数量',
  `settle_accounts_item_total` double(10,2) DEFAULT NULL COMMENT '结算项总价',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_settle_accounts_item_records` */

/*Table structure for table `ts_settle_accounts_orders` */

DROP TABLE IF EXISTS `ts_settle_accounts_orders`;

CREATE TABLE `ts_settle_accounts_orders` (
  `order_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '结算工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联任务id',
  `service_request_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `all_total` double(10,2) DEFAULT NULL COMMENT '全部总价',
  `remarks` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭操作人',
  `close_remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '关闭原因',
  `signature` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '签字人',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_settle_accounts_orders` */

/*Table structure for table `ts_special_repair_project` */

DROP TABLE IF EXISTS `ts_special_repair_project`;

CREATE TABLE `ts_special_repair_project` (
  `special_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '专项id',
  `special_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '专项名称',
  `special_type` tinyint(4) DEFAULT NULL COMMENT '专项类型',
  `special_state` tinyint(4) DEFAULT NULL COMMENT '专项状态',
  `special_cer_time` datetime DEFAULT NULL COMMENT '创建时间',
  `special_writer` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `special_startover_time` datetime DEFAULT NULL COMMENT '启动时间',
  `remarks` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`special_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='专项表(服务请求)';

/*Data for the table `ts_special_repair_project` */

/*Table structure for table `ts_special_repair_project_journal` */

DROP TABLE IF EXISTS `ts_special_repair_project_journal`;

CREATE TABLE `ts_special_repair_project_journal` (
  `record_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '日志记录id',
  `special_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '专项id',
  `operation_time` datetime NOT NULL COMMENT '操作时间',
  `operation_person_id` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '操作人id',
  `change_state` tinyint(4) NOT NULL COMMENT '修改状态的记录',
  `remarks` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='专项日志记录表(服务请求)';

/*Data for the table `ts_special_repair_project_journal` */

/*Table structure for table `ts_task_shift_special_records` */

DROP TABLE IF EXISTS `ts_task_shift_special_records`;

CREATE TABLE `ts_task_shift_special_records` (
  `record_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '转专项记录id',
  `special_repair_project_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '专项id',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '任务id',
  `remarks` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_task_shift_special_records` */

/*Table structure for table `ts_tasks` */

DROP TABLE IF EXISTS `ts_tasks`;

CREATE TABLE `ts_tasks` (
  `task_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '任务id',
  `server_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '关联服务请求id',
  `customer_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '客户id',
  `task_type` tinyint(4) DEFAULT NULL COMMENT '任务类型',
  `task_state` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `professional` tinyint(4) DEFAULT NULL COMMENT '专业',
  `product` tinyint(4) DEFAULT NULL COMMENT '产品',
  `address_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '地址id',
  `estimated_time` datetime DEFAULT NULL COMMENT '预计完成时间',
  `finish_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `task_description` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '任务描述',
  `principal` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人',
  `subordinate_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '从属id',
  `subordinate_type` tinyint(4) DEFAULT NULL COMMENT '从属类型(专项，集中处理)',
  `subordinate_operation` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '从属操作人',
  `subordinate_time` datetime DEFAULT NULL COMMENT '从属操作时间',
  `create_person_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_tasks` */

insert  into `ts_tasks`(`task_id`,`server_id`,`customer_id`,`task_type`,`task_state`,`professional`,`product`,`address_id`,`estimated_time`,`finish_time`,`create_time`,`task_description`,`principal`,`subordinate_id`,`subordinate_type`,`subordinate_operation`,`subordinate_time`,`create_person_id`) values ('c935dc24-c1a2-4b4e-a76b-100495ff8f16','f0236bba-baec-4007-8856-d21352814faa','f22cd363-2809-4af4-9199-872c68ffc9be',0,4,NULL,NULL,NULL,NULL,NULL,'2016-05-03 14:08:01',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `ts_tasks_journal` */

DROP TABLE IF EXISTS `ts_tasks_journal`;

CREATE TABLE `ts_tasks_journal` (
  `tasks_journal_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '任务日志id',
  `task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '任务id',
  `operator_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人id',
  `operation_time` datetime DEFAULT NULL COMMENT '操作时间',
  `cre_order_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '工单id',
  `cre_order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `change_state` tinyint(4) DEFAULT NULL COMMENT '任务状态修改',
  `change_order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态修改',
  `remarks` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '备注描述',
  PRIMARY KEY (`tasks_journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_tasks_journal` */

/*Table structure for table `ts_tasks_merge` */

DROP TABLE IF EXISTS `ts_tasks_merge`;

CREATE TABLE `ts_tasks_merge` (
  `tasks_merge_id` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '任务合并id',
  `main_task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '主任务id',
  `lesser_task_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT '子任务id',
  PRIMARY KEY (`tasks_merge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ts_tasks_merge` */

/*Table structure for table `ts_urge_task_records` */

DROP TABLE IF EXISTS `ts_urge_task_records`;

CREATE TABLE `ts_urge_task_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `task_id` varchar(36) DEFAULT NULL COMMENT '关联任务id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '操作人id',
  `urge_time` datetime DEFAULT NULL COMMENT '催促时间',
  `urge_remarks` varchar(300) DEFAULT NULL COMMENT '催促备注',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='催办任务记录表';

/*Data for the table `ts_urge_task_records` */

/*Table structure for table `ts_water_meter_reading_orders` */

DROP TABLE IF EXISTS `ts_water_meter_reading_orders`;

CREATE TABLE `ts_water_meter_reading_orders` (
  `order_id` varchar(36) NOT NULL COMMENT '工单id',
  `order_type` tinyint(4) DEFAULT NULL COMMENT '工单类型',
  `order_state` tinyint(4) DEFAULT NULL COMMENT '工单状态',
  `task_id` varchar(36) DEFAULT NULL COMMENT '任务id',
  `service_request_id` varchar(36) DEFAULT NULL COMMENT '服务请求id',
  `operator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注描述',
  `close_time` datetime DEFAULT NULL COMMENT '关闭时间',
  `close_person_id` varchar(36) DEFAULT NULL COMMENT '关闭人id',
  `close_remarks` varchar(300) DEFAULT NULL COMMENT '关闭说明',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水表抄表工单';

/*Data for the table `ts_water_meter_reading_orders` */

/*Table structure for table `ts_water_meter_reading_records` */

DROP TABLE IF EXISTS `ts_water_meter_reading_records`;

CREATE TABLE `ts_water_meter_reading_records` (
  `record_id` varchar(36) NOT NULL COMMENT '记录id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '关联工单id',
  `water_meter_id` varchar(36) DEFAULT NULL COMMENT '水表id',
  `water_meter_reading` double(10,2) DEFAULT NULL COMMENT '当前读数',
  `water_meter_last_reading` double(10,2) DEFAULT NULL COMMENT '上次读数',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水表抄表结果记录表';

/*Data for the table `ts_water_meter_reading_records` */

/*Table structure for table `myview` */

DROP TABLE IF EXISTS `myview`;

/*!50001 DROP VIEW IF EXISTS `myview` */;
/*!50001 DROP TABLE IF EXISTS `myview` */;

/*!50001 CREATE TABLE  `myview`(
 `id` varchar(36) ,
 `honse_id` varchar(36) ,
 `hire_start_date` date ,
 `hire_finish_date` date ,
 `contract_number` varchar(36) ,
 `leasePerson_id` varchar(500) ,
 `staff_id` varchar(36) ,
 `cust_id` varchar(36) ,
 `createDate` date ,
 `user_opinion` varchar(255) ,
 `staff_name` varchar(50) ,
 `cust_name` varchar(50) ,
 `houseAddress` varchar(300) 
)*/;

/*View structure for view myview */

/*!50001 DROP TABLE IF EXISTS `myview` */;
/*!50001 DROP VIEW IF EXISTS `myview` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `myview` AS select `home_jiajia`.`t_newlease`.`id` AS `id`,`home_jiajia`.`t_newlease`.`honse_id` AS `honse_id`,`home_jiajia`.`t_newlease`.`hire_start_date` AS `hire_start_date`,`home_jiajia`.`t_newlease`.`hire_finish_date` AS `hire_finish_date`,`home_jiajia`.`t_newlease`.`contract_number` AS `contract_number`,`home_jiajia`.`t_newlease`.`leasePerson_id` AS `leasePerson_id`,`home_jiajia`.`t_newlease`.`staff_id` AS `staff_id`,`home_jiajia`.`t_newlease`.`cust_id` AS `cust_id`,`home_jiajia`.`t_newlease`.`createDate` AS `createDate`,`home_jiajia`.`t_newlease`.`user_opinion` AS `user_opinion`,`home_jiajia`.`t_newlease`.`staff_name` AS `staff_name`,`home_jiajia`.`t_newlease`.`cust_name` AS `cust_name`,`home_jiajia`.`t_newlease`.`houseAddress` AS `houseAddress` from `t_newlease` */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
