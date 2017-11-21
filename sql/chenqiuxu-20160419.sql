ALTER TABLE tc_financial_staff 
	ADD COLUMN  staff_id varchar(36) default null COMMENT '员工id' ,
	ADD COLUMN post_id varchar(36) default null COMMENT '岗位id';