/**
 * author:王志刚 ，尹磊
 * jsName:物业服务人员主页----停车卡---新增停车卡js
 * Created by Administrator on 2015/5/19.
 * 最后修改时间：2015/5/28
 */
define(['tyjApp'],function(module){
    module.controller("newCardCtrl",function($scope,$http,$rootScope){
    	$scope.caraccesscards={};
    	//停车卡集合初始化
    	$scope.caraccesscards.carId =1;
    	//车辆卡id初始化
    	$scope.carInfos={};
    	//车辆信息初始化
    	$scope.stalls={};
    	//车位信息初始化
    	var url = $rootScope.url;
    	//新增停车卡信息
    	$scope.AddCaraccesscard=function(){
            console.log($scope.Caraccesscard);                
            $http.post(url + '/Caraccesscard/insertCaraccesscard',{Caraccesscard:$scope.caraccesscards}).success(function(data) {     
            		alert("新增成功");
                }).error(function(data, status, headers, config){
    	            alert("新增失败");
    	        }) ;
        };
        //查询户主车辆信息
        $scope.getCarInfo=function(){
        	console.log($scope.CarInfo);
        	$http.get(url + '/CarInfo/getCarInfo/'+7).success(function(data) {
                console.log(data);
                $scope.carInfos = data.CarInfo;
            });
        };
        //查询户主车位信息
        $scope.getStall=function(){
        	console.log($scope.Stall);
        	$http.get(url + '/Stall/listAllStallByPersonIdRestful/'+7).success(function(data) {
                console.log(data);
                $scope.stalls = data.Stall;
            });
        };
        //导入户主车辆信息
        $scope.inCarInfo=function(CarNum){
        	$scope.carNum=CarNum;
        };
        //导入户主车位信息
        $scope.inStall=function(Coding,State,Type){
        	console.log($scope.stalls);
        	console.log(Type);
        	$scope.stallId=Coding;
        	$scope.type=Type;
        	$scope.state=State;
        	console.log($scope.type);
        };
    });
});