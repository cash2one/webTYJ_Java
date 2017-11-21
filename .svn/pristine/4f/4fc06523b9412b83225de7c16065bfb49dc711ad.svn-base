/**
 * Created by lenovo on 2015/5/6.
 * 项目团队管理【查看项目】
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("checkProjectCtrl",function($scope,$http,$rootScope){
        $scope.staffs={}
        //人员信息初始化
        
        
        var url = $rootScope.url;
        //根据实例id查询团队负责人信息
        $http.get(url + '/Staff/getStaffbyName/'+5).success(function(data) {
            console.log(data);
            $scope.staffs = data.Staff;
        });

        
    });
});