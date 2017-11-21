/**
 * 页面名称：【专业资产初始化】新增专业
 * 页面路径：page/internalProfession/majorAssetInitialization/newProfessional.html
 * 前端负责人：刘洋
 * 后端负责人：
 * 创建时间：2015/5/6.
 * 修改日期：2015/6/1
 * 修改人：王志刚
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("newProfessionalCtrl",function($scope,$http,$cookieStore,$rootScope){
    	var url = $rootScope.url;
    	$http.get(url + '/PropertyType/listPropertyType/').success(function(data) {
      		console.log(data);
      		$scope.propertyTypes = data.PropertyType;
          });
    	 
    	$scope.PropertyType={};
       	$scope.addPropertyType=function(){
       		//$scope.PropertyType.founder= $cookieStore.get('AppUser').lastName;//获取创建人姓名;
    			$http.post(url + '/PropertyType/AddPropertyType',{PropertyType:$scope.PropertyType}).success(function(data) {
    				$http.get(url + '/PropertyType/listPropertyType/').success(function(data) {
    		      		console.log(data);
    		      		$scope.propertyTypes = data.PropertyType;
    		          });
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        });
    	};
    });
});