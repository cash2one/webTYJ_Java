/**
 * Created by Administrator on 2015/5/17.
 * 人员信息常用
 */
'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("commonUserCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	$scope.search={};
    	$scope.search.staffName=1;
    	
        //停车卡相关
    	$http.post(url+'/PersonCustNew/propertyServiceSearchCommon',{Search:$scope.search}).success(function(data)
    			{
    			   console.log("搜索成功");
    			   $scope.propertyService=data.propertyService;
    			   console.log($scope.propertyService);
    			     
    			    //车位相关
    		    	$scope.stalls=$scope.propertyService.stalls; 
    		    	$scope.stall=$scope.stalls[1];
    		    	//门禁卡相关
    		    	$scope.caraccesscards=$scope.propertyService.caraccesscards;
    		    	$scope.caraccesscard=$scope.caraccesscards[1];
    		    	//车辆相关
    		    	$scope.carInfos=$scope.propertyService.carInfos;
    		    	$scope.carInfo=$scope.propertyService.carInfos[1]; 		    	
    		    	//门禁卡
    		    	
    		    	$scope.entrances=$scope.propertyService.entrances;
    		    	$scope.entrance=$scope.propertyService.entrances[1];
    		    	
    		    	//服务请求相关
    		    	
    		    	//计费相关
    			});  	
    });
});