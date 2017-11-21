/**
 * Created by Administrator on 2015/4/17.
 * 客户管理
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("customerCtrl",function($scope,$http,Paginator,$rootScope){
        var url=$rootScope.url;
        $scope.AfterSale={page:{}};
        $scope.addAfterSale={};
        var fetchFunction = function(page,callback) {
    		$scope.AfterSale.page=page;
            $http.post(url + '/AfterSale/listPageAfterSaleRestful',{AfterSale:$scope.AfterSale}).success(callback);
        };  

        $scope.searchPaginator=Paginator(fetchFunction,8);
       
        
        $scope.view=function(id)
        {
        	$http.get(url+'/AfterSale/getAfterSaleByIdRestful/'+id).success(function(data)
        	{
        		$scope.afterSale=data.AfterSale;
            });
        };
        
        $scope.update=function()
        {
        	$http.put(url+'/AfterSale/updateAfterSaleRestful',{AfterSale:$scope.afterSale}).success(function()
        	{
        		$scope.searchPaginator._load();//ˢ�����
        		alert("�޸ĳɹ���");
            }).error(function(data, status, headers, config){
	            alert("�޸�ʧ�ܣ�");
	        }) ;
        };
        
        $scope.insert=function()
        {
        	$http.post(url+'/AfterSale/insertAfterSaleRestful',{AfterSale:$scope.addAfterSale}).success(function()
        	{
        		$scope.searchPaginator._load();//ˢ�����
        		alert("��ӳɹ���");
            }).error(function(data, status, headers, config){
	            alert("���ʧ�ܣ�");
	        }) ;
        };
        
        
        $scope.deleteAfterSales=function()
        {
        	if(confirm("�Ƿ�Ҫɾ��ѡ�"))
        	{
        		var indexchekbox=0;
        		var indexsuccess=0;
        		for(var i=0;i<$scope.searchPaginator.object.afterSales.length;i++){
	    			if($scope.searchPaginator.object.afterSales[i].checkbox==true){
	    				indexchekbox++;
	    				$http({
	    					method:'DELETE',
	    					url:url + '/AfterSale/deleteAfterSaleRestful/'+$scope.searchPaginator.object.afterSales[i].id
	    				})
	    				.success(function(data, status, headers, config){
	    					indexsuccess++;
	    					if(indexchekbox==indexsuccess)
	    					{
	    						$scope.searchPaginator._load();//ˢ�����
	    						alert("ɾ��ɹ���");
	    					}
	    				}).error(function(data, status, headers, config){
	    		            alert("ɾ��ʧ�ܣ�");
	    		            return;
	    		        }) ;
	    			};
	    		}
        	}
        };
    });
});