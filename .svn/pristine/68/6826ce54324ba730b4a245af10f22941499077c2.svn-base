/**
 * Created by Administrator on 2015/6/4.
 * 
 * author:耿小江
 * 
 */

define(['../../../../tyjApp'],function(module){
    module.controller("collectManageCtrl",function($scope){
        $scope.test="收费信息";
        
        
//        获取房屋信息的id 
        $scope.getHouseByhouseId=function(id)        
        {         	 
        	$http.get(url+'/House/getHouseById/'+id).success(function(data)
        	{
        		$scope.house1=data.House;  
        		console.log($scope.house1);
        		alert("房屋信息注入成功"); 
            }).error(function(data, status, headers, config){
	            alert("房屋信息注入失败"); 
	        }) ;
        };
   
        /**
         * 获取人员信息
         * 
         */
       
   $scope.selectPersonBycustId=function()  {   	   	        		
            $http.post(url + '/PersonCust/listAllPersonCustRestfulone',{PersonCust:$scope.PersonCust}).success(function(data)
                 	{
         		$scope.personCust1=data.PersonCust; 
         		console.log($scope.personCust1);
         		alert("人员信息获取成功"); 
             }).error(function(data, status, headers, config){
 	            alert("人员信息获取失败"); 
 	        }) ;                          
   };
   
    });
});