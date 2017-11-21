/**
 * 更改 by 肖聪 on 2015/6/1.
 * 添加相关功能的实现
 */

'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("staffsuperviseITAddCtrl",function($scope,$http,Paginator,$rootScope){   	
   	    	var url = $rootScope.url;
   	    	    $scope.search={page:{}};
    	        $scope.Staff={page:{}};
                $scope.seleted = '';
    	        /**
    	         * creat xiaocong
    	         * 2015/6/1
    	         * 
    	         */
    	        $scope.sexs=[{id:3,sex:"请选择性别"},{id:0,sex:"男"},{id:1,sex:"女"}];
                $scope.marriage=[{id:0,married:"已婚"},{id:1,married:"未婚"}];
    	        $scope.search.id=3;
    	        $scope.addStaff={};
    	        $scope.getSex=function(id){
    	        	$scope.addStaff.sex=id;
    	        	alert($scope.search.id );
    	        };
               	$scope.insert=function(){
    	         	 console.log("Proud Winphone");
    	         	$http.post(url+'/staff/insertStaffRestful',{Staff:$scope.addStaff}).success(function(){
    	         		alert("添加成功");
    	             }).error(function(data, status, headers, config){
    	 	            alert("添加失败");
    	 	        }) ;
    	         };
    	    });
    });
    
