/**
 * Created by 肖聪 on 2015/6/2.
 */
'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("vehicleManagementAddCtrl",function($scope,$http,Paginator,$rootScope){ 
    	var url = $rootScope.url;   	  		   	
    	$scope.personBuildings=[{id:0,custName:"请选择车辆所有人",relation:""}];//用于下拉选择人员对应关系
    	$scope.personBuildings.id=0;
    	
    	//根据条件搜索出房屋信息
    	$scope.search={};
    	$scope.selectHouse=function(){
    		
    		$http.post(url+'/HouseNew/listAllHouseNewBySearch',{Search:$scope.search}).success(function(data)
    			{
    			console.log("搜索成功");
    			   $scope.house=data.HouseNew;
    			   $scope.house=data.HouseNew;
    			   console.log($scope.house);
    			   
    			});
    	};
    
    	
    	//选择获取到的一栋房屋
    	$scope.houseone={};
    	
    	$scope.choiceHouse=function(houseId){
    	   	for(var i=0;i<$scope.house.length;i++)
    	   		{
    	   		   if($scope.house[i].id==houseId){
    	   			$scope.houseone= $scope.house[i];
    	   			console.log("房屋获取成功"+$scope.houseone);
    	   			console.log($scope.houseone.houseAddress);
    	   			continue;
    	   		   }
    	   		}
    	};
    	
    	//取消新增车辆填写的数据
    	$scope.resetAddCar=function(){
    		$scope.addCarInfo={};
    		$scope.search={};
    		$scope.houseone={};
    		$scope.personBuildingNew={};
    		console.log("重置成功");
    	};
    	
    	console.log($scope.houseone);
    	//获取与该栋房屋相关的人员建筑关系信息
        $scope.selectPersonBuilding=function(){
        	console.log("房屋获取成功(⊙０⊙)"+$scope.houseone);
        	$http.get(url+'/PersonBuildingNew/listAllPersonAndHouseByHouseId/'+$scope.houseone.id).success(function(data)
        	        { 
        		     $scope.personBuildingNew=data.PersonBuildingNew;
        		     console.log($scope.personBuildingNew);
        		     console.log("获取人员房屋关系成功");
       	        	 for(var i=0;i<$scope.personBuildingNew.length;i++)
              		   { 
       	        		console.log($scope.personBuildingNew[i].custType);
              		     $scope.option= {id:$scope.personBuildingNew[i].personCustNew.custId,custName:$scope.personBuildingNew[i].personCustNew.name,relation:$scope.personBuildingNew[i].custType};
                         $scope.personBuildings.push($scope.option);
              		   }
        	          }).error(function(data, status, headers, config){
        	        	  console.log("获取人员房屋关系添加失败");
        		     }) ;
    	};
    	
    	//获取选择人员信息
        $scope.choicePerson=function(personId){
    	   $scope.addCarInfo.owner = personId;
    	   console.log("选取人员信息成功");
    	   console.log( $scope.addCarInfo.owner);
    	};
    	
    	//添加车辆信息
    	$scope.addCarInfo={};  	
    	$scope.insertCar=function(){
    		console.log("房屋获取成功(⊙０⊙)"+ $scope.addCarInfo.owner);
    	       $http.post(url+'/CarInfo/AddCarInfo',{CarInfo:$scope.addCarInfo}).success(function()
    	        {   	        	
   	        	console.log("添加成功");
   	        	$scope.personBuildings=[{id:0,custName:"请选择车辆所有人",relation:""}];//用于下拉选择人员对应关系
   	     	    $scope.personBuildings.id=0;
    	          }).error(function(data, status, headers, config){
    	        	  console.log("添加失败");
    		     }) ;
    	       
    	};
  
        
    });
});