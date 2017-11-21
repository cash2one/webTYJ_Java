/**
 * Created by Administrator on 2015/4/16.
 * 车辆信息首页
 */

'use strict';

define(['tyjApp',
    'controllers/propertyService/carHome/parkingCard',
    'controllers/propertyService/carHome/vehicleManagement',
    'controllers/propertyService/carHome/claimManagement',
    'controllers/propertyService/carHome/collectFees'
],function(module){
    module.controller("carHomeCtrl",function($scope){
        $scope.test='111';
    });
});