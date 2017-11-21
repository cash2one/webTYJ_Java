/**
 * Created by Administrator on 2015/4/17.
 * VIP管理
 */

'use strict';

define(['tyjApp'],function(module){
    module.controller("VIPCtrl",function($scope,$http,Paginator,$rootScope){
       	var url = $rootScope.url;
        $scope.PersonCust={page:{}};
        
        var fetchFunction = function(page,callback) {
    		$scope.PersonCust.page=page;
            $http.post(url + '/PersonCust/listPersonCustByblacklist',{PersonCust:$scope.PersonCust}).success(callback);
        };  
        $scope.searchPaginator=Paginator(fetchFunction,2);
        

      	//查询重要客户信息
        $scope.personCust={};
      	$scope.GetPersonCust=function(custId){
    		if(custId!=0)
    		{
    			$http.get(url + '/PersonCust/getPersonCustByIdRestful/'+custId).success(function(data) {
    				console.log(data);
    				$scope.personCust = data.PersonCust;
    			});
    		}else{
    			$scope.personCust={};
    		}
    	};
    	
    	
    	$scope.AddOrUpdatePersonCust=function(custId){
    	
    		console.log($scope.personCust);
    		if(custId==0)
    		{
    			$scope.personCust.blacklist=1;  //标示为重要客户
    			$http.post(url + '/PersonCust/insertPersonCustRestful',{PersonCust:$scope.personCust}).success(function(data) {
    				$('#addvipCustomer').modal('hide');  //关闭模态框
    				$scope.searchPaginator._load();//刷新数据
    				
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}else
    		{
    			$http.put( url + '/PersonCust/updatePersonCustRestful',{PersonCust:$scope.personCust}).
    			success(function(data){	
    				$('#updatevipCustome').modal('hide'); //关闭模态框
    				$scope.searchPaginator._load();//刷新数据
    	        }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}
    	};
    	
    	
    	$scope.deletePersonCust=function(){
    		if(confirm("是否删除?"))
    		{ 
	    		for(var i=0;i<$scope.searchPaginator.object.personCusts.length;i++){
		    			if($scope.searchPaginator.object.personCusts[i].value==true){
		    				var id=$scope.searchPaginator.object.personCusts[i].custId;
		    				$http({
		    					method:'DELETE',
		    					url:url + '/PersonCust/deletePersonCustRestful/'+id
		    				})
		    				.success(function(data, status, headers, config){
		    					$scope.searchPaginator._load();//刷新数据
		    				});	
		    	    	};
	    		};
	    		
    		} ;
				
				
    	};

    });
});
       	