/**
 * Created by Administrator on 2015/4/13.
 * 装修历史记录
 * author:耿小江
 * modifytime:2015-06-01
 */

define(['tyjApp'],function(module){
    module.controller("historyCtrl",function($scope,$http,$rootScope){
    	
    	var url = $rootScope.url;
        $scope.test="装修历史记录";
        $scope.PersonCusts={};
	     
	    	$http.get(url + '/PersonCust/listAllPersonCustRestful').success(function(data) {
	    		console.log(data);
	    		$scope.PersonCust = data.PersonCust;
	    	});
        
        
        
    });
});