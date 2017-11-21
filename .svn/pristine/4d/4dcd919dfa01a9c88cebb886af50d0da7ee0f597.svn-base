/**
 * Created by Administrator on 2015/4/16.
 * 车辆信息首页
 */

'use strict';

define(['tyjApp',
    'controllers/propertyService/staffHome/decorate/chooseHouse',
    'controllers/propertyService/staffHome/decorate/applicationData',
    'controllers/propertyService/staffHome/decorate/verification',
    'controllers/propertyService/staffHome/decorate/payDeposit',
    'controllers/propertyService/staffHome/decorate/Alicence',
    'controllers/propertyService/staffHome/decorate/workProgress',
    'controllers/propertyService/staffHome/decorate/acceptance',
    'controllers/propertyService/staffHome/decorate/costClearing',
],function(module){
    module.controller("decorationCtrl",function($scope){

        $scope.tmpList=[
            'top-chooseHouse',
            'top-applicationData',
            'top-verification',
            'top-payDeposit',
            'top-Alicence',
            'top-workProgress',
            'top-acceptance',
            'top-costClearing'
        ];
        $scope.currentTemplate = "top-chooseHouse";
        $scope.changeTemplate = function(index){
            $scope.currentTemplate =$scope.tmpList[index];
        }

    });
});