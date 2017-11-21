/**
 * 对应页面：新增放行条——物业服务人员主页【addReleasePass.html】
 * 页面路径：page/propertyService/staffHome/releasePass/addReleasePass.html
 * 前端负责人：刘洋
 * 创建时间：2015/5/13
 * 后端负责人：
 * 修改时间：
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("addReleasePassCtrl",function($scope){
        var items=$scope.items=[{},{},{},{}];
        //【动态添加行】
        $scope.addRow=function(){
            $scope.items.push($scope.item);
        }
    });
});