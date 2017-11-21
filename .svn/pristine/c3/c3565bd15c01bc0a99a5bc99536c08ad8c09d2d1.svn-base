/**
 * Created by Administrator on 2015/4/16.
 * 车辆信息里的车辆管理
 */

define(['tyjApp'],function(module){
	 module.controller("vehicleCtrl",function($scope,$http,$rootScope){
		 
		 
		 $scope.tip="车辆信息";
	    	$scope.carInfos={};
	    	$http.get(url + '/CarInfo/listAllCarInfo').success(function(data) {
	    		console.log(data);
	    		
	    		$scope.CarInfo = data.CarInfo;
	            $scope.item = data.CarInfo[0];
	            console.log($scope.item);
	    	  });
		 
		 /*
		  * 
		  
	    	$scope.tip="车辆管理";
	        $scope.CarInfos={};
	        $scope.addCarInfo={};
	        var personId= 7;
	    	var url = $rootScope.url;
	    	$http.get(url + '/CarInfo/listPageCarInfo').success(function(data) {
	    		console.log(data);
	    		$scope.CarInfo = data.CarInfo;
	    	});
	    	
	    	
	    	//根据id查询车辆信息
	        $scope.CarInfo={};
	      	$scope.GetCarInfo=function(carId){
	    		if(custId!=0)
	    		{
	    			$http.get(url + '/CarInfo/getCarInfoById/'+carId).success(function(data) {
	    				console.log(data); 
	    				$scope.CarInfo = data.CarInfo;
	    			});
	    		}else{
	    			$scope.CarInfo={};
	    		}
	    	};
	    	
	    	//修改添加车辆信息
	    	$scope.AddOrUpdateCarInfo=function(){
	    		console.log($scope.CarInfo);
	    		if($scope.CarInfo.carId==0 || $scope.CarInfo.carId==null)
	    		{
	    			$scope.CarInfo.personId=personId;  //设置绑定的客户id
	    			$http.post(url + '/CarInfo/AddCarInfo',{CarInfo:$scope.addCarInfo}).success(function(data) {
	    				$http.get(url + '/CarInfo/listPageCarInfo'+personId).success(function(data) {
	    					console.log(data);
	    			        $scope.CarInfo = data.CarInfo;
	    			    });
	    		    }).error(function(data, status, headers, config){
	    	            alert("error"+status);
	    	        }) ;
	    		}else
	    		{
	    			$http.put( url + '/CarInfo/UpdateCarInfo',{CarInfo:$scope.CarInfo}).
	    			success(function(data){	
	    				$('#remove').modal('hide'); //车辆移除模态框
	    				$http.get(url + '/CarInfo/listPageCarInfo'+personId).success(function(data) {
	    					console.log(data);
	    			        $scope.CarInfo = data.CarInfo;
	    			    });
	    	        }).error(function(data, status, headers, config){
	    	            alert("error"+status);
	    	        }) ;
	    		}
	    	};
	    	*/
    });
});