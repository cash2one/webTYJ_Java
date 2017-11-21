/**
 * Created by Administrator on 2015/4/22.
 */
define(['tyjApp'],function(module){
    module.controller("acceptanceCtrl",function($scope,$http,$rootScope){
    	var url = $rootScope.url;
    	
        $scope.test="验收信息的显示";
        $scope.personCusts={};
    	$http.get(url + '/PersonCust/listAllPersonCustRestful').success(function(data) {
    		console.log(data);
    		
    		$scope.PersonCust = data.PersonCust;
            $scope.item = data.PersonCust[0];
            console.log($scope.item);
    	  });
    });
});