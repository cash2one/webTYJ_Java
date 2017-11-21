/**
 * Created by 彭婷婷 on 2015/5/20.
 * 物业服务--人员主页--宠物登记--新增宠物
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("newPetCtrl",function($scope,$http,$rootScope){
    	
    	var url = $rootScope.url;
        $scope.test='新增宠物';
        $scope.PetRegistrations={};
	      $scope.addPetRegistration={};
	    	$http.get(url + '/PetRegistration/listAllPetRegistration').success(function(data) {
	    		console.log(data);
	    		$scope.PetRegistration = data.PetRegistration;
	    	});
	    
	    	$scope.AddPetRegistration=function(){  
	    		console.log($scope.PetRegistration);
	    		if($scope.PetRegistration.petId==0 || $scope.PetRegistration.petId==null) {
	    			$http.post(url + '/PetRegistration/insertPetRegistration',{PetRegistration:$scope.addPetRegistration}).success(function(data) {
	    				$http.get(url + '/PetRegistration/listAllPetRegistration').success(function(data) {
	    					alert("添加成功！");
	    					  $scope.searchPaginator._load();
	    					console.log(data);
	    			        $scope.PetRegistration = data.PetRegistration;
	    			        $scope.searchPaginator._load();
	    			        
	    			    });
	    		    }).error(function(data, status, headers, config){
	    		    	alert("添加失败");
	    	            alert("error"+status);
	    	        }) ;
	    		}
	    	};
    	
    });
        
    });
