/**
 * Created by Administrator on 2015/4/16.
 * 房屋信息
 */

'use strict';

define(['tyjApp',
    'controllers/propertyService/staffHome/decorate/workProgress/defaultFine',
    'controllers/propertyService/staffHome/decorate/workProgress/rectificationNotice',

],function(module){
    module.controller("workProgressCtrl",function($scope,$http,$rootScope){
 	      var url = $rootScope.url;
 	    	$scope.test="核查信息";
 	    	$scope.Inspections={};
// 		    var url = $rootScope.url;
// 			$http.get(url + '/Inspection/AllInspection').success(function(data) {
// 				console.log(data);
// 		        $scope.Inspection = data.Inspection;
// 		        $scope.myitem = data.Inspection[0];
// 	            console.log($scope.myitem);
// 			});
 	    	//$scope.PersonCusts={};
 		     
	    	$http.get(url + '/Inspection/AllInspection').success(function(data) {
	    		console.log(data);
	    		$scope.Inspection = data.Inspection;
	    	});
    });
});
