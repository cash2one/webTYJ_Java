/**
 * Created by Administrator on 2015/4/13.
 * 工作台任务
 */
'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("taskCtrl",function($scope,$http,Paginator,$rootScope){
        var url=$rootScope.url;
        $scope.Order={page:{}};
        $scope.order={};
        var fetchFunction = function(page,callback) {
    		$scope.Order.page=page;
            $http.post(url + '/Order/listPageOrderRestfulByTodoCd',{Order:$scope.Order}).success(callback);
        };  

        $scope.searchPaginator=Paginator(fetchFunction,8);
       
        
        $scope.view=function(id)
        {
        	console.log(id);
        	$http.get(url+'/Order/getOrderbyIdRestful/'+id).success(function(data)
        	{
        		console.log(data);
        		$scope.order=data.Order;
            });
        };
        
        $scope.update=function()
        {
        	$http.put(url+'/Order/updateOrderRestful',{Order:$scope.order}).success(function()
        	{
        		$scope.order={};
        		$scope.searchPaginator._load();//ˢ�����
        		$('#myModal_task').modal('hide');  //关闭模态框
        		alert("修改成功！");
            }).error(function(data, status, headers, config){
	            alert("修改失败！");
	        }) ;
        };
        
        $scope.insert=function()
        {
        	$scope.insertOrder.todoCd=3;
        	$http.post(url+'/Order/insertOrderRestful',{Order:$scope.insertOrder}).success(function()
        	{
        		$scope.searchPaginator._load();//ˢ�����
        		$('#myModal_service').modal('hide');  //关闭模态框
        		alert("添加成功！");
        		$scope.insertOrder={};
            }).error(function(data, status, headers, config){
	            alert("添加失败！");
	        }) ;
        };
        
        
        $scope.remove=function()
        {
        	if(confirm("是否删除勾选项？"))
        	{
        		var indexchekbox=0;
        		var indexsuccess=0;
        		for(var i=0;i<$scope.searchPaginator.object.orders.length;i++){
	    			if($scope.searchPaginator.object.orders[i].checkbox==true){
	    				indexchekbox++;
	    				$http({
	    					method:'DELETE',
	    					url:url + '/Order/deleteOrderRestful/'+$scope.searchPaginator.object.orders[i].workOrderId
	    				})
	    				.success(function(data, status, headers, config){
	    					indexsuccess++;
	    					if(indexchekbox==indexsuccess)
	    					{
	    						$scope.searchPaginator._load();//ˢ�����
	    						alert("删除成功！");
	    					}
	    				}).error(function(data, status, headers, config){
	    		            alert("删除失败！");
	    		            return;
	    		        }) ;
	    			};
	    		}
        	}
        };
    });
});