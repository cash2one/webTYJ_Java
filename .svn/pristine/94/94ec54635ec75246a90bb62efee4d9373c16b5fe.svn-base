/**
 * Created by daniel on 2015/5/6.
 * jsName:controllers/internalProfession/projectbuildpartition/ruleAdd ----项目建筑分区
 * 修改人：王志刚
 * 最后修改时间：2015/6/2
 */
'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("ruleAddCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	$scope.search={page:{}};
    	$scope.projects=[{id:0,name:"请选择"}];    	
    	$scope.Area={page:{}};
        $scope.search.projectId=0;
        $scope.addArea={}; 
        $scope.addStage={}; 
        $scope.addProject={}; 
        $scope.area1={};
        $scope.building2={};

        $http.get(url + '/Project/listAllProject').success(function(data) {
            for(var i =0;i<data.Project.length;i++){
                $scope.option= {id:data.Project[i].projectId,name:data.Project[i].projectName};
                $scope.projects.push($scope.option);
            };
        });

        $http.get(url + '/Area/listAllArea').success(function(data) {
        $scope.area=data.Area;
        });

        /* $http.get(url + '/Projec/listAllProject').success(function(data) {
         console.log(data);
         $scope.project = data.Project;
         });*/

        /*$http.get(url + '/Building/listAllBuildingByState').success(function(data) {
         console.log(data);
         $scope.building1 = data.Building;
         });*/

        /*  $http.post(url + '/Stage/listAllStageRestful1',{Stage:$scope.addStage}).success(function(data) {
         console.log(data);
         $scope.stage = data.Stage;
         });*/


        $scope.getStage=function(id){

            $http.get(url + '/Stage/listAllStageRestfull/'+id).success(function(data) {
                console.log(data);
                $scope.stage = data.Stage;
            });
        };

        $scope.insertArea=function()
        {
            $http.post(url+'/Area/AddArea',{Area:$scope.addArea}).success(function()
            {
                $http.get(url + '/Area/listAllArea').success(function(data) {
                        console.log(data);
                        $scope.area = data.Area;
                });
                alert("添加成功");
            }).error(function(data, status, headers, config){
                alert("添加失败");
            }) ;
        };


        $scope.changeBuilding=function(id){
            $http.put(url+'/Building/getBuildingbyId1'+id).success(function()
            {
                alert("获取成功");
                $scope.building2 = data.Building;
            }) ;

        };
        $scope.changeBuilding=function(id)
        {

            $scope.getAreaId=function(id){
                $scope.area1.id=id;
            };

            $scope.building2.areaId=$scope.area1.id;
            $http.put(url+'/Building/UpdateBuildingById',{Building:$scope.building2}).success(function()
            {
                alert("修改成功");
            }).error(function(data, status, headers, config){
                alert("修改失败");
            }) ;
        };
    });
});