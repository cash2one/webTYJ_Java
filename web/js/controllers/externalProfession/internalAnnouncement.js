/**
 * Created by Administrator on 2015/4/20.
 * 内部公告
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("intAnnounceCtrl",function($scope,$http,Paginator,$rootScope){
        //var url = $rootScope.url;
    	 // $scope.Inform={page:{}};
    	 // $scope.allInform={};
      	//var fetchFunction = function(page,callback) {
    		//$scope.Inform.page=page;
        //    $http.post(url + '/Inform/listPageinform', {Inform:$scope.Inform}).success(callback);
        //};
        //$scope.searchPaginator = Paginator(fetchFunction,10);
        //
        //
        //$scope.view=function(id)
        //{
        //	$http.get(url+'/Inform/getInformById/'+id).success(function(data)
        //	{
        //		$scope.inform=data.Inform;
        //    });
        //};
        //
        //$scope.update=function()
        //{
        //	$http.put(url+'/Inform/UpdateInform',{Inform:$scope.inform}).success(function()
        //	{
        //		$scope.searchPaginator._load();//修改数据
        //		alert("修改成功");
        //    }).error(function(data, status, headers, config){
  	   //         alert("修改失败");
  	   //     }) ;
        //};
        //
        //$scope.insert=function()
        //{
        //	console.log($scope.allInform);
        //	$http.post(url+'/Inform/AllInform',{Inform:$scope.allInform}).success(function()
        //	{
        //		$scope.searchPaginator._load();//添加数据
        //		alert("添加成功");
        //    }).error(function(data, status, headers, config){
  	   //         alert("添加失败");
  	   //     }) ;
        //};
    });
});
