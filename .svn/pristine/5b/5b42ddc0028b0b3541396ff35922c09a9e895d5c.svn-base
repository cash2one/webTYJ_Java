/**
 * Created by Administrator on 2015/4/22.
 */
define(['tyjApp'],function(module){
    module.controller("payDepositCtrl",function($scope,$http,$rootScope){
    	var url = $rootScope.url;
        $scope.test="查看缴纳押金";
        $scope.Charges={};
	     
    	$http.get(url + '/Charge/listAllCharge').success(function(data) {
    		console.log(data);
    		$scope.Charge = data.Charge;
    	});
    });
});