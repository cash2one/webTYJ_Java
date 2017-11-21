/**
 * Created by Administrator on 2015/4/21.
 * 内部专业线合同初始化
 */

'use strict';

define(['tyjApp',
    'controllers/internalProfession/contractInitialization/addContract',
    'controllers/internalProfession/contractInitialization/contractCheck'
],function(module){
    module.controller("contractInitializationCtrl",function($scope){
        $scope.test='111';
    });
});