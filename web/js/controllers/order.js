/**
 * Created by LM on 2015/3/11
 * 工单管理首页搜索按钮的数据集合
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("orderCtrl",function($scope){

        $scope.buttons=[
            {content:'报事'},{content:'报修'}, {content:'投诉'},{content:'门禁卡'}, {content:'放行条'},{content:'停车卡'}, {content:'资产管理'},{content:'遗失物品'}, {content:'宠物登记'},{content:'表扬'},
            {content:'贷款'},{content:'融资'}
        ];


        $scope.buttons1=[
            {content:'VIP'},{content:'VIP1'}, {content:'VIP2'},{content:'VIP3'}, {content:'VIP4'},{content:'VIP5'},
        ];
        $scope.buttons2=[
            {content:'未处理'},{content:'待回访'}, {content:'已处理'},{content:'已完成'}
        ];
        $scope.buttons3=[
            {content:'客户'},{content:'内部'}, {content:'外部'}
        ];
        $scope.buttons4=[
            {content:'高'},{content:'中'}, {content:'低'}
        ];
    });
});