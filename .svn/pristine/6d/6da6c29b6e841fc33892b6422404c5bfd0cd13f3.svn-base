/**
 * Created by Administrator on 2015/4/13.
 * 工作台待定
 */
'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("pendingCtrl",function($scope,$http,$cookieStore,Paginator,$rootScope){
    	var url = $rootScope.url;
        $scope.Order={page:{}};
    	var fetchFunction = function(page,callback) {
    		$scope.Order.page=page;
    		$scope.Order.processerId=$cookieStore.get('AppUser').staffId;//获取用户id
            $http.post(url + '/Order/listPageOrderRestfulByPending',{Order:$scope.Order}).success(callback);
        };  

        $scope.searchPaginator=Paginator(fetchFunction,2);
        console.log($scope.searchPaginator);
        
        
        
      //根据id查询代办工单信息信息
        $scope.order={};
      	$scope.GetOrder=function(workOrderId){
      		
    		if(workOrderId!=0)
    		{
    			$http.get(url + '/Order/getOrderbyIdRestful/'+workOrderId).success(function(data) {
    				console.log(data);
    				$scope.order = data.Order;
    			});
    		}else{
    			$scope.order={};
    		}
    	};
        
        $scope.AddOrUpdateOrder=function(workOrderId){
        	
    		console.log($scope.order);
    		if(workOrderId==0)
    		{
    			$scope.order.evtStatCd='待处理';  //标示为待处理
    			$scope.order.processerId=$cookieStore.get('AppUser').staffId;  //设置处理人为当前登录人
    			$http.post(url + '/Order/insertOrderRestful',{Order:$scope.order}).success(function(data) {
    				$('#myModal_service').modal('hide');  //关闭模态框
    				$scope.searchPaginator._load();//刷新数据
    				
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}else
    		{
    			$http.put( url + '/Order/updateOrderRestful',{Order:$scope.order}).
    			success(function(data){	
    				$('#myModal_VIP').modal('hide'); //关闭模态框
    				$scope.searchPaginator._load();//刷新数据
    	        }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}
    	};
    	
    	
    	$scope.deleteOrder=function(){
    		
    		if(confirm("是否删除?"))
    		{ 
        		for(var i=0;i<$scope.searchPaginator.object.orders.length;i++){
    	    			if($scope.searchPaginator.object.orders[i].value==true){
    	    				var id=$scope.searchPaginator.object.orders[i].workOrderId;
    	    				$http({
    	    					method:'DELETE',
    	    					url:url + '/Order/deleteOrderRestful/'+id
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
    
   
