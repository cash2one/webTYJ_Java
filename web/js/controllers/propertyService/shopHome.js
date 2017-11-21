/**
 * Created by Administrator on 2015/4/16.
 * 房屋信息
 */

'use strict';

define(['tyjApp',
    'controllers/propertyService/shopsHome/homePage',
    'controllers/propertyService/shopsHome/housing',
    'controllers/propertyService/shopsHome/partnership',
    'controllers/propertyService/shopsHome/change',
    'controllers/propertyService/shopsHome/decorate',
    'controllers/propertyService/shopsHome/lease'
],function(module){
    module.controller("shopsCtrl",function($scope){
        $scope.test='111';
    });
});
