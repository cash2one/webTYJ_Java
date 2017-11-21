/**
 * Created by 彭婷婷  on 2015/4/13.
 *
 */
'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("authorizationhistoryCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	$scope.authorizedPersonId=1;//假定被授权人id为1
    		$http.get(url+'/Authorization/getAuthorizedbyId/'+$scope.authorizedPersonId).success(function(data)
    			{
    			   console.log("搜索成功");
    			   $scope.authorizations=data.Authorization;
    			   console.log("根据被授权人id查询");
             	   console.log($scope.authorizations);  
    			});
    		/*
    		//测试
        	$scope.test=function(){
        		var a={};
        		$http.post(url+'/EnterpriseCustNew/findEnterpriseCustNewRestful',{EnterpriseCustNew:a}).success(function(data)
        	 	        {   	        	
        	 	    	  console.log("添加授权成功");
        	 	          }).error(function(data, status, headers, config){
        	 	        	 console.log("添加授权失败");
        	 		     }) ;
        	};*/
    });
});