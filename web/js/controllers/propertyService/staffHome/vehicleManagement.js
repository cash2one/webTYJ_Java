/**
 * Created by Administrator on 2015/4/13.
 * * author:钟加诚
 * jsName:物业服务人员主页---停车卡页面js
 * 最后修改时间：2015/5/28
 * 房屋信息车辆管理
 */

define(['tyjApp',
    'controllers/propertyService/staffHome/vehicleManagement/vehicleManagementAdd',
    'controllers/propertyService/staffHome/vehicleManagement/vehicleManagementCheck'
],function(module){
    module.controller("vehicleCtrl",function($scope,$http,$rootScope){

    	var url = $rootScope.url;
    	$scope.stalls={};
    	$http.get(url + '/Stall/listAllStall').success(function(data) {
    		console.log(data);
    		
    		$scope.Stall = data.Stall;
            $scope.myitemses = data.Stall[0];
            console.log($scope.myitemses);
    	  });
    	
    	$scope.tip="车辆信息";
    	$scope.carInfos={};
    	$http.get(url + '/CarInfo/listAllCarInfo').success(function(data) {
    		console.log(data);
    		
    		$scope.CarInfo = data.CarInfo;
            $scope.it = data.CarInfo[0];
            console.log($scope.it);
    	  });
    	
    	
    	$scope.caraccesscards={};
    	$http.get(url + '/Caraccesscard/listAllCaraccesscard').success(function(data) {
    		console.log(data);
    		$scope.Caraccesscard = data.Caraccesscard;
    		$scope.item = data.Caraccesscard[0];
            console.log($scope.item);
    	});
    	
    	
    	$scope.interiorServes={};
    	$http.get(url + '/InteriorServe/getInteriorServeByIdRestful'+1).success(function(data) {
    		console.log(data);
    		$scope.Interiorserve = data.InteriorServe;
    		$scope.ite = data.InteriorServe[0];
    		console.log($scope.ite);
    	});
    	
    	$scope.hastenItems={};
    	$http.get(url + '/HastenItem/listPagehastenItem').success(function(data) {
    		console.log(data);
    		$scope.HastenItem = data.HastenItem;
    		$scope.ites = data.HastenItem[0];
    		console.log($scope.ites);
    	});
    	
    });
});