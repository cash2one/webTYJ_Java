/**
 * Created by 耿小江 on 2015/06/04.
 * 人员信息-入伙-选择房屋
 */

define(['../../../../tyjApp'],function(module){
    module.controller("choiceHousingCtrl",function($scope,$http,$rootScope){
        
        //查询所有的房屋的信息
        var url = $rootScope.url;
   	 $scope.test=' 选择房屋信息';
   	 //获取房子的Id号
   	 $scope.getHouseId=function(houseId){
        	$http.get(url+'/House/getHouseById/'+houseId).success(function(data){
        		console.log(data);
				$scope.house = data.House;
            });
	};
       

   	 $http.get(url + '/House/listAllHouse').success(function(data) {
	    		console.log(data);
	    		$scope.House = data.House;
	    	});
   	 
     $scope.listAll=function() {
        $http.get(url + '/House/listAllHouse').success(function(data) {
            console.log(data);

            $scope.House = data.House;
            $scope.item = data.House[0];
            console.log($scope.item);
	  });
     };
      
   });
});