/**
 * Created by Administrator on 2015/5/19.
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("addEntranceGuardCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;	
    	/*//查询户主的房屋或者根据条件搜索业主的房屋，用于授权
    	$scope.selectHouse=function(){
    		$scope.houses=$rootScope.houses;
    		console.log($scope.houses);
    	};*/
    	
    	//根据条件搜索出房屋信息
    	$scope.search={};
    	$scope.selectHouse=function(){
    		
    		$http.post(url+'/HouseNew/listAllHouseNewBySearch',{Search:$scope.search}).success(function(data)
    			{
    			   console.log("搜索成功");
    			   $scope.house=data.HouseNew;
    			   console.log("根据条件查到的房屋");
    			   console.log($scope.house);
    			  
    			});
    	};
    	
    	//选中房屋
    	$scope.houseone={};
    	
    	$scope.choiceHouse=function(house){
    		console.log("点击房屋事件");
    		console.log($scope.house);
    		$scope.houseone=house;
    		console.log($scope.houseone);
    		$scope.addEntrance.houseId=$scope.houseone.id;
    	};
    	
    	
    	//根据条件搜索人员信息
    	$scope.searchone={};
    	$scope.selectPerson=function(){
    		
    		$http.post(url+'/PersonCustNew/listAllPersonBySearch',{Search:$scope.searchone}).success(function(data)
    			{
    			   console.log("搜索成功");
    			   $scope.person=data.PersonCustNew;
    			   console.log($scope.person);
    			   
    			});
    	};
    	
    	//选中人员
    	$scope.personone={};
    	$scope.choicePerson=function(person){
    		$scope.personone=person;
    		console.log($scope.personone);
    		$scope.addEntrance.custCode=$scope.personone.custId;
    	};
    	
    	
    	//添加门禁卡
    	$scope.addEntrance={};//新增门禁卡对象
    	$scope.insertEntrance=function(){
 	       $http.post(url+'/Entrance/insertEntrance',{Entrance:$scope.addEntrance}).success(function()
 	        {   	        	
 	    	  console.log("添加门禁卡成功");
 	          }).error(function(data, status, headers, config){
 	        	 console.log("添加门禁卡失败");
 		     }) ;
    	};
    	
    	//取消数据增加
    	$scope.resetAddEntrance=function(){
    		$scope.addEntrance={};
    		$scope.search={};
    		$scope.houseone={};
    		$scope.personBuildingNew={};
    		 console.log("重置成功");
    	};
    	
    	//打印
    	$scope.printEntrance=function(){
    		
    	};
    	
    });
});