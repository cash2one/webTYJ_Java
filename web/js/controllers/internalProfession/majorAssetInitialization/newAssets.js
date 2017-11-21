/**
 * 页面名称：【专业资产初始化】新增资产
 * 页面路径：page/internalProfession/majorAssetInitialization/newAssets.html
 * 前端负责人：刘洋
 * 后端负责人：
 * 创建时间：2015/5/6.
 * 修改日期：
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("newAssetsCtrl",function($scope,$http,$cookieStore,$rootScope){
    	var url = $rootScope.url;
    	$http.get(url + '/PropertyType/listPropertyType/').success(function(data) {
      		console.log(data);
      		$scope.propertyTypes = data.PropertyType;
          });
    	
    	$http.get(url + '/Property/listProperty/').success(function(data) {
      		console.log(data);
      		$scope.propertys = data.Property;
          });
    	
    	
    	$scope.property={};
    	$scope.findpropertyById=function(propertyId ){
    		
    		$http.get(url + '/Property/getPropertyByIdRest/'+propertyId).success(function(data) {
				console.log(data);
				$scope.property = data.Property;
			});
    	};
    });
});