/**
 * 创建人：李斌
 * 创建时间： 2015/5/17.
 * 名称：物业服务的人员主页的产权变更JS
 *
 * 修改时间：2015/6/9
 * 修改人：李斌
 */

define(['tyjApp',
    'controllers/propertyService/staffHome/changeTitle/addHousingInformation',

],function(module){
    module.controller("changeCtrl",function($scope,$http,$rootScope){
    	 var url = $rootScope.url;
         $scope.waterCheck=false;
         $scope.updatePlans1=false;
         $scope.planDetailss1=true;
         $scope.planExecutions1=false;
         $scope.planDetailss=function(){
             $scope.updatePlans1=false;
             $scope.planDetailss1=true;
             $scope.planExecutions1=false;
         };
         $scope.updatePlans=function(){
             $scope.updatePlans1=true;
             $scope.planDetailss1=false;
             $scope.planExecutions1=false;
         };
         $scope.planExecutions=function(){
             $scope.updatePlans1=false;
             $scope.planDetailss1=false;
             $scope.planExecutions1=true;
         };
         
         //搜索业主的资产信息  车位，房屋，商铺
         $scope.selectPropety=function(){
        	 
         };
         
         //选择车位
         $scope.stallone={};
         $scope.choiceStall=function(stall){
        	 $scope.stallone=stall;
         };
         
         //选择商铺
         $scope.storeone={};
         $scope.choiceStore=function(store){
        	 $scope.storeone=store;
         };
         
         //根据条件搜索出房屋信息
         $scope.search={};
     	$scope.selectHouse=function(){
     		
     		$http.post(url+'/HouseNew/listAllHouseNewBySearch',{Search:$scope.search}).success(function(data)
     			{
     			   console.log("搜索成功");
     			   $scope.house=data.HouseNew;
     			   console.log("根据条件查到的房屋");
     			   console.log($scope.house);
     			   
     			});
     	};
         
         //选择房屋
         $scope.houseone={}; 
         $scope.personBuildingone=[];//该栋房屋的户主关系对象
     	$scope.choiceHouse=function(house){
     		console.log("点击房屋事件");
     		console.log($scope.house);
     		$scope.houseone=house;
     		console.log($scope.houseone);
     		$scope.addEntrance.houseId=$scope.houseone.id;
     		console.log("房屋获取成功(⊙０⊙)"+$scope.houseone);
         	$http.get(url+'/PersonBuildingNew/listAllPersonAndHouseByHouseId/'+$scope.houseone.id).success(function(data)
         	        { 
         		     $scope.personBuildingNew=data.PersonBuildingNew;
         		     console.log($scope.personBuildingNew);
         		     console.log("获取人员房屋关系成功");
         		     for(var i=0;i<$scope.personBuildingNew.length;i++){
         		    	 if($scope.personBuildingNew[i].custType="户主"){
         		    		 $scope.personBuildingone.push($scope.personBuildingNew[i]); 
             		     }
         		     }
         		     console.log($scope.personBuildingone);
         	          }).error(function(data, status, headers, config){
         	        	  console.log("获取人员房屋关系添加失败");
         		     }) ;
     	};
     	
         //通过条件搜索人员
     	$scope.searchone={};
     	$scope.selectPerson=function(){   		
     		$http.post(url+'/PersonCustNew/listAllPersonBySearch',{Search:$scope.search}).success(function(data)
     			{
     			   console.log("搜索成功");
     			   $scope.person=data.PersonCustNew;
     			   console.log($scope.person);   			   
     			});
     	};
     	
         //选择人员
     	$scope.personone={};
     	$scope.choicePerson=function(person){
     		$scope.personone=person;
     		console.log($scope.personone);
     		$scope.addEntrance.custCode=$scope.personone.custId;
     	};
         
         //添加产权变更记录
     	$scope.addChangeTitle={};//新增产权变更记录对象
     	$scope.insertChangeTitle=function(){
  	       $http.post(url+'/ChangeTitle/insertChangeTitleRestful',{ChangeTitle:$scope.addChangeTitle}).success(function()
  	        {   	        	
  	    	  console.log("添加产权变更成功");
  	          }).error(function(data, status, headers, config){
  	        	 console.log("添加产权变更失败");
  		     }) ;
     	};



    });
});