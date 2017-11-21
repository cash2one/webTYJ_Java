/**
 * 对应页面：新增企业放行条——物业服务人员主页【historicRecords.html】
 * 页面路径：page/propertyService/staffHome/releasePass/historicRecords.html
 * 前端负责人：刘洋
 * 创建时间：2015/5/13.
 * 后端负责人：
 * 修改时间：
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("historicRecordesCtrl",function($scope){
        $scope.test="111";
        $scope.historys=[
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},
            {name:'周润发',householdType:'业主',proposerName:'周润发',phone:1231231313},

        ]
    });
});