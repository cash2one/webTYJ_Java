ALTER TABLE `t_newlease`
MODIFY COLUMN `leasePerson_id`  varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '租客外键id' AFTER `contract_number`;

ALTER TABLE `t_newlease`
MODIFY COLUMN `lease_person_name`  varchar(250) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '新增  租客姓名（预留字段）' AFTER `lease_person_cardNum`;