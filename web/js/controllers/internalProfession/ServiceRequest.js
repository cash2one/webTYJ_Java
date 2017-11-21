/**
 * 页面名称：【专业资产初始化】新增专业
 * 页面路径：page/controllers/internalProfession/majorAssetInitialization/newProfessional.html
 * 前端负责人：刘洋
 * 后端负责人：
 * 创建时间：2015/4/29.
 * 修改日期：
 */
'use strict';
define(['tyjApp',
    'controllers/internalProfession/ServiceRequest/ServiceAdd',
    'controllers/internalProfession/ServiceRequest/ServiceCheck',
    'pageServices'
],function(module){    
    	 module.controller("ServiceRequestCtrl",function($scope,$http,$rootScope,Paginator){
   		  console.log("aaaa");
   		 var url=$rootScope.url;
   		  $scope.InteriorServe={page:{}};
   		 var fetchFunction = function(page,callback) {
     		$scope.InteriorServe.page=page;
            $http.post(url + '/InteriorServe/listPageInteriorServeRestful',{InteriorServe:$scope.InteriorServe}).success(callback);
         };              
         $scope.searchPaginator=Paginator(fetchFunction,8);   
   		    		
   		
    });
});