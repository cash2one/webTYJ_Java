/**
 * Created by Administrator on 2015/4/22.
 */
define(['tyjApp'],function(module){
    module.controller("applicationDataCtrl",function($scope){
    	
    	var url = $rootScope.url;
    	$scope.tip="获取房屋编号";
        $scope.houses={};
    	$http.get(url + '/House/listPagehouseRest').success(function(data) {
    		console.log(data);
    		
    		$scope.House = data.House;
            $scope.item = data.House[0];
            console.log($scope.item);
    	  });
    });
});