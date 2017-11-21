/**
 * Created by Administrator on 2015/5/6.
 */

'use strict';
define(['tyjApp'],function(module){
    module.controller("projectConstructionCtrl",function($scope,$http,Paginator,$rootScope){
        var url = $rootScope.url;
        $scope.addProjectBuild={};

       //获取面积属性数据
        $http.get(url+'/AreaTypeNew/listAllAreaTypeNew').success(function(data){
            $scope.areaTypes= data.AreaTypeNew;

          }).error(function(data, status, headers, config){

        }) ;

        //增加建筑名称保存到数据库方法
        $scope.addProject=function(){
            $http.post(url+'/BuildingNew/AddBuildingNew',{BuildingNew:$scope.addProjectBuild}).success(function(){

            }).error(function(data, status, headers, config){

            }) ;
        };

        //获取添加建筑的信息数据
        $http.get(url+'/BuildingNew/ListBuildingNew').success(function(data){
            $scope.buildings= data.BuildingNew;
            alert("查询成功");
        }).error(function(data, status, headers, config){
            alert("查询失败");
        }) ;

    });
});
