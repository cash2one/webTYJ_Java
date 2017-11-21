/**
 * 对应页面：新增企业放行条——物业服务人员主页【addCompanyPass.html】
 * 页面路径：page/propertyService/staffHome/releasePass/addReleasePass.html
 * 前端负责人：刘洋
 * 创建时间：2015/5/19.
 * 后端负责人：
 * 修改时间：
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("addCompanyPassCtrl",function($scope){
        var items=$scope.items=[{},{},{},{}];
        //【点击添加行按钮下面表格添加一行】
        $scope.addRow=function(){
            $scope.items.push($scope.item);
        }
    });
});