/**
 * Created by 彭婷婷 on 2015/4/13.
 * 物业服务--人员主页--宠物登记
 */

define(['tyjApp',
    'controllers/propertyService/staffHome/petRegistration/newPet',
    'controllers/propertyService/staffHome/petRegistration/history'
],function(module){

	module.controller("petCtrl",function($scope,$http,$rootScope){
		  $scope.PetRegistrations={};
	      $scope.addPetRegistration={};
	    	var url = $rootScope.url;
	    	$http.get(url + '/PetRegistration/listAllPetRegistration').success(function(data) {
	    		console.log(data);
	    		$scope.PetRegistration = data.PetRegistration;
	    	});
	    	$scope.AddPetRegistration=function(){  
	    		console.log($scope.PetRegistration);
	    		if($scope.PetRegistration.petId==0 || $scope.PetRegistration.petId==null)
	    		{
	    			$http.post(url + '/PetRegistration/insertPetRegistration',{PetRegistration:$scope.addPetRegistration}).success(function(data) {
	    				$http.get(url + '/PetRegistration/PetRegistration').success(function(data) {
	    					console.log(data);
	    			        $scope.PetRegistration = data.PetRegistration;
	    			    });
	    		    }).error(function(data, status, headers, config){
	    	            alert("error"+status);
	    	        }) ;
	    		}
	    	};
	    	
	    });
	});
   

    

