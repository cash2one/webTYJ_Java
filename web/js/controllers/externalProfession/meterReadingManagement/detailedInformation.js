/**
 * 创建人：李斌
 * 日期：2015/5/29
 * 名称：抄表管理的房屋详细信息JS
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("detailedInformationCtrl",function($scope){
        $scope.test='wwwwww';
        $scope.houes=[
            {floor:'一层',roomNumber:101,roomNumber1:102},
            {floor:'二层',roomNumber:201,roomNumber1:202},
            {floor:'三层',roomNumber:301,roomNumber1:302},
            {floor:'四层',roomNumber:401,roomNumber1:402},
            {floor:'五层',roomNumber:501,roomNumber1:502},
            {floor:'六层',roomNumber:601,roomNumber1:602}
        ]
        $scope.houes1=[
            {floor:'一层',roomNumber:'三方二厅',roomNumber1:102,roomNumber2:103},
            {floor:'二层',roomNumber:201,roomNumber1:202,roomNumber2:203},
            {floor:'三层',roomNumber:301,roomNumber1:302,roomNumber2:303},
            {floor:'四层',roomNumber:401,roomNumber1:402,roomNumber2:403},
            {floor:'五层',roomNumber:501,roomNumber1:502,roomNumber2:503},
            {floor:'六层',roomNumber:601,roomNumber1:602,roomNumber2:603}
        ]
    });
});