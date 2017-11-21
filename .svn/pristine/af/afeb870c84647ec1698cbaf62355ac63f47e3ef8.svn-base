/**
 * Created by Administrator on 2015/4/20.
 * 企业公告
 */

/**
 * Created by Administrator on 2015/4/20.
 * 企业公告
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("entNewsCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
  	  $scope.Corporatenews={page:{}};
  	  $scope.addCorporatenews={};
    	var fetchFunction = function(page,callback) {
  		$scope.Corporatenews.page=page;
          $http.post(url + '/Corporatenews/listPageCorporatenewsRestful', {Corporatenews:$scope.Corporatenews}).success(callback);  
      };  
      $scope.searchPaginator = Paginator(fetchFunction,10);
      
      $scope.view=function(id)
      {
      	$http.get(url+'/Corporatenews/getCorporatenewsById/'+id).success(function(data)
      	{
      		$scope.corporatenews=data.Corporatenews;
          });
      };
      
      $scope.update=function()
      {
      	$http.put(url+'/Corporatenews/UpdateCorporatenews',{Corporatenews:$scope.corporatenews}).success(function()
      	{
      		$scope.searchPaginator._load();//修改数据
      		alert("修改成功");
          }).error(function(data, status, headers, config){
	            alert("修改失败");
	        }) ;
      };
  
      $scope.insert=function()
      {
      	console.log($scope.addCorporatenews);
      	$http.post(url+'/Corporatenews/AddCorporatenews',{Corporatenews:$scope.addCorporatenews}).success(function()
      	{
      		$scope.searchPaginator._load();//添加数据
      		alert("添加成功");
          }).error(function(data, status, headers, config){
	            alert("添加失败");
	        }) ;
      };
    });
});




