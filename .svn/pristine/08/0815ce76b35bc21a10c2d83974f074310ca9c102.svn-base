/**
 * Created by 肖聪 on 2015/5/20.
 */


/*define(['tyjApp'],function(module){
    module.controller("vehicleManagementCheckCtrl",function($scope){
        $scope.test="111";
    });
});
*/



/**
 * Created by Administrator on 2015/4/17.
 *CarInfo
 */

/**
 * Created by Administrator on 2015/4/17.
 *CarInfo
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("vehicleManagementCheckCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	$scope.searchCar={};//查询车辆条件对象
        $scope.CarInfo={page:{}};
       // $scope.addCarInfo={}; 
        
        var fetchFunction = function(page,callback) {
    		$scope.CarInfo.page=page;
    		
            $http.post(url + '/CarInfo/listPageCarInfo',{CarInfo:$scope.CarInfo}).success(callback);
        };              
        $scope.searchPaginator=Paginator(fetchFunction,9);      
                  
        $scope.view=function(id)
        {
        	$http.get(url+'/CarInfo/getCarInfoById/'+id).success(function(data)
        	{
        		$scope.carInfo=data.CarInfo;
        		console.log($scope.carInfo.carNum);
            });
        };
        
        $scope.update=function()
        {
        	$http.put(url+'/CarInfo/UpdateCarInfo',{CarInfo:$scope.carInfo}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("修改成功");
            }).error(function(data, status, headers, config){
	            alert("修改失败");
	        }) ;
        };
        
        $scope.insert=function()
        {
        	$http.post(url+'/CarInfo/insertCarInfoRestful',{CarInfo:$scope.addCarInfo}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("添加成功");
            }).error(function(data, status, headers, config){
	            alert("添加失败");
	        }) ;
        };
        
     
        
        
        $scope.deleteCarInfo=function(id)
        {
        	$http.put(url + '/CarInfo/deleteCarInfo/'+id).success(function()
	        	{
			alert("删除成功");
    		$scope.searchPaginator._load();
    		
        }).error(function(data, status, headers, config){
            alert("删除失败");
        }) ;
        	
        };
        
        
        /**
         * 创建 by 肖聪 通过条件查询车辆及相关信息
         */
        $scope.getAllCarInfo=function(){
        	$scope.searchCar.carNum=11;
        	$http.post(url+'/CarInfo/getCarInfoByPerson/',{SearchCar:$scope.searchCar}).success(function(data)
                	{
                		$scope.searchCarAll=data.SearchCar;
                		console.log($scope.searchCarAll);
                    });
       	
        };

});
});  