/**
 * 修改 by 肖聪 on 2015/6/1 完善租赁的相关功能
 */
'use strict';
define([ 'tyjApp', 'pageServices' ], function(module) {
    module.controller("leaseAddCtrl", function($scope, $http, Paginator, $rootScope) {
        var url = $rootScope.url;
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
    		
    	};
    	
    	
    	//根据条件搜索人员信息
    	$scope.searchone={};
    	$scope.selectPerson=function(){
    		
    		$http.post(url+'/PersonCustNew/listAllPersonBySearch',{Search:$scope.search}).success(function(data)
    			{
    			   console.log("搜索成功");
    			   $scope.person=data.PersonCustNew;
    			   console.log($scope.person);
    			   
    			});
    	};
    	
    	//选中人员
    	/*$scope.personone={};*/
    	$scope.persons=[];
    	$scope.choicePerson=function(person){
    		if($scope.notrepeat($scope.persons,person.custId)){
    			$scope.persons.push(person);
    		}	
    		else
    			alert("人员重复，请重新选择人员");
    		console.log($scope.persons);
    	};
    	
    	
    	//添加租赁
    	$scope.addLease={};//新增租赁对象
    	$scope.addLease.personBuildingNew=[];
    	$scope.insertLease=function(){
    		
    		for(var i=0;i<$scope.persons.length;i++){
    			var addPersonBuildingNew={};//新增人员建筑关系
    			addPersonBuildingNew.buildingStructureId=$scope.houseone.buildingStructureId;
        		addPersonBuildingNew.custType="租客";
        		addPersonBuildingNew.state=0;
        		addPersonBuildingNew.custId=$scope.persons[i].custId;
        		$scope.addLease.personBuildingNew.push(addPersonBuildingNew);
        		console.log($scope.addLease.personBuildingNew);
    		}
 	       $http.post(url+'/NewLease/insertNewLeaseRestful',{NewLease:$scope.addLease}).success(function()
 	        {   	        	
 	    	  console.log("添加租赁成功");
 	    	 $scope.addLease.personBuildingNew=[];
 	    	$scope.persons=[];
 	          }).error(function(data, status, headers, config){
 	        	 console.log("添加租赁失败");
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
    	
    	//判断人员选择是否重复
    	$scope.notrepeat=function(persons,personId){
    		 var j = 0;
             for ( var i = 0; i < $scope.persons.length; i++) {
                 if ($scope.persons[i].custId == personId) {
                     j = 1;
                 }
             }
             if (j == 1) {
                 alert("人员信息重复");
                 return false;
             }
             else
            	 return true;
    	};
    	
    	//打印
    	$scope.printNewLease=function(){
    		
    	};
    });
});