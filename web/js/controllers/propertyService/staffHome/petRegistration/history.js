/**
 * Created by 彭婷婷 on 2015/5/20.
 * 物业服务--人员主页--宠物登记--历史记录
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("historyPetCtrl",function($scope,$http,$rootScope){
    	var url = $rootScope.url;
    	
    	
    	$scope.view=function(petId)
        {
        	$http.get(url+'/PetRegistration/getPetRegistrationbyId/'+petId).success(function(data)
        	{
        		$scope.petRegistration=data.PetRegistration;
        		console.log($scope.petRegistration.petName);
            });
        };
        
        
        $scope.update=function()
        {
        	$http.put(url+'/PetRegistration/updatePetRegistration',{PetRegistration:$scope.petRegistration}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("修改成功");
            }).error(function(data, status, headers, config){
	            alert("修改失败");
	        }) ;
        };
        
    	
    	$scope.deletePet=function(petId)
        {
        	$http({	method:'DELETE',url:url + '/PetRegistration/deletePetRegistration/'+petId
		}).success(function()
	        	{
			alert("删除成功");
    		$scope.searchPaginator._load();
    		
        }).error(function(data, status, headers, config){
            alert("删除失败");
        }) ;
        	
        };
        		

    });

});