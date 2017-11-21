INSERT INTO data_dictionary_master_project(id,master_id,project_id) VALUES  
	 ('032581b6-1d5b-4177-8f6b-c1733f0cfcc7','165ee5-1e2a-411a-966f-df74041fa55e1','960045b9-2f34-4cd0-a5d1-2860e177781d'),
	 ('032581b6-1d5b-4177-8f6b-c1733f0cfcc8','165ee5-1e2a-411a-966f-df74041fa55e2','960045b9-2f34-4cd0-a5d1-2860e177781d');

INSERT INTO data_dictionary_master(master_id,master_name,STATUS,description,create_id,create_time) VALUES
     ('165ee5-1e2a-411a-966f-df74041fa55e1','conditionusetype','0','计费模板公式条件','admin','2016-04-12 11:39:00'),
     ('165ee5-1e2a-411a-966f-df74041fa55e2','symbol','0','条件项','admin','2016-04-12 11:39:00');

INSERT INTO data_dictionary_slave(slave_id,slave_name,master_id,STATUS,description,create_id,create_time) VALUES
     ('275ee5-1e2a-411a-966f-df74041fa55e1','all','165ee5-1e2a-411a-966f-df74041fa55e1','0','全部','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e2','everyone','165ee5-1e2a-411a-966f-df74041fa55e1','0','任何','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e3','=','165ee5-1e2a-411a-966f-df74041fa55e2','0','等于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e4','!=','165ee5-1e2a-411a-966f-df74041fa55e2','0','不等于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e5','>','165ee5-1e2a-411a-966f-df74041fa55e2','0','大于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e6','<','165ee5-1e2a-411a-966f-df74041fa55e2','0','小于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e7','>=','165ee5-1e2a-411a-966f-df74041fa55e2','0','大于等于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e8','<=','165ee5-1e2a-411a-966f-df74041fa55e2','0','小于等于','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa55e9','contain','165ee5-1e2a-411a-966f-df74041fa55e2','0','包含','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa5510','exclusive','165ee5-1e2a-411a-966f-df74041fa55e2','0','不包含','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa5511','yes','165ee5-1e2a-411a-966f-df74041fa55e2','0','是','admin','2016-04-12 11:39:00'),
     ('275ee5-1e2a-411a-966f-df74041fa5512','no','165ee5-1e2a-411a-966f-df74041fa55e2','0','不是','admin','2016-04-12 11:39:00');
     
ALTER TABLE tc_constant CHANGE prents_id parents_id VARCHAR(50);

ALTER TABLE tc_product ADD COLUMN modity_time DATETIME NULL DEFAULT NULL COMMENT '改动时间' AFTER free_time;

INSERT INTO data_dictionary_master_project(id,master_id,project_id) VALUES  
	 ('032581b6-1d5b-4177-8f6b-c1733f0cfc27','0b442b50-c272-49e4-8afd-06324606c2f7','960045b9-2f34-4cd0-a5d1-2860e177781d'),
	 ('032581b6-1d5b-4177-8f6b-c1733f0cf428','89b61124-656a-40a6-abde-170eac147db5','960045b9-2f34-4cd0-a5d1-2860e177781d');

	 
INSERT INTO `data_dictionary_master` VALUES ('0b442b50-c272-49e4-8afd-06324606c2f7', 'startType', '0', '启用状态', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:15', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('c5d1b34c-9695-492b-96bc-8fc92a27c913', '1', '0b442b50-c272-49e4-8afd-06324606c2f7', '0', '未启用', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:32', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('ff5896ac-2567-48f1-9e9c-978af1fb405d', '0', '0b442b50-c272-49e4-8afd-06324606c2f7', '0', '已启用', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:15', NULL, NULL);

INSERT INTO `data_dictionary_master` VALUES ('89b61124-656a-40a6-abde-170eac147db5', 'accountType', '0', '账户类型', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:56:24', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('fbd5bfab-1182-4fe2-9c9c-a3ecf9cf5b6f', '0', '89b61124-656a-40a6-abde-170eac147db5', '0', '资产账户', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:56:24', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('48baf400-9334-492d-a26b-9192c9f80a6f', '1', '89b61124-656a-40a6-abde-170eac147db5', '0', '押金账户', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:56:34', NULL, NULL);


INSERT INTO data_dictionary_master_project(id,master_id,project_id) VALUES  
	 ('032581b6-1d5b-4177-8f6b-c1733f0cfc28','0b442b50-c272-49e4-8afd-06324606c2e7','960045b9-2f34-4cd0-a5d1-2860e177781d');

INSERT INTO `data_dictionary_master` VALUES ('0b442b50-c272-49e4-8afd-06324606c2e7', 'priority', '0', '优先级', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:15', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('c5d1b34c-9695-492b-96bc-8fc92a27c011', 'level1', '0b442b50-c272-49e4-8afd-06324606c2e7', '0', '1', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:32', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('ff5896ac-2567-48f1-9e9c-978af1fb4012', 'level2', '0b442b50-c272-49e4-8afd-06324606c2e7', '0', '2', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:15', NULL, NULL);
INSERT INTO `data_dictionary_slave` VALUES ('ff5896ac-2567-48f1-9e9c-978af1fb4013', 'level3', '0b442b50-c272-49e4-8afd-06324606c2e7', '0', '3', '70b13d0a-01c3-48ac-ad8e-18b5e7ccf2ca', '2016-4-5 15:47:15', NULL, NULL);
