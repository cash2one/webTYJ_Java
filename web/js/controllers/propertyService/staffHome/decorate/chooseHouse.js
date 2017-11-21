/**
 * Created by Administrator on 2015/5/3.
 */

define(['tyjApp'],function(module){
    module.controller("chooseHouseCtrl",function($scope,$http,$rootScope){
    	var url = $rootScope.url;
    	 $scope.test=' 选择房屋信息';
    	 //获取房子的Id号
    	 $scope.getHouseId=function(houseId){
    	 
         	$http.get(url+'/House/getHouseById/'+houseId).success(function(data){
         		console.log(data);
				$scope.house = data.House;
         	
         		
             });
       
 	};
       
        
  
    	 $http.get(url + '/House/listPagehouseRest').success(function(data) {
	    		console.log(data);
	    		$scope.House = data.House;
	    	});
    	 
       
    });
});