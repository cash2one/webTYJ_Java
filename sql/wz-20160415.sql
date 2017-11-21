ALTER TABLE `tc_product`
	ADD COLUMN `modify_time` DATETIME NULL DEFAULT NULL COMMENT '改动时间' AFTER `free_time`;