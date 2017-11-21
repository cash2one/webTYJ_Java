/**
 * Created by Administrator on 2015/4/17.
 *developer
 */

/**
 * Created by Administrator on 2015/4/17.
 *developer
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("developerCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
        console.log("aaaaaa");
        $scope.Developer={page:{}};
        $scope.addDeveloper={};         
        var fetchFunction = function(page,callback) {
    		$scope.Developer.page=page;
    		
            $http.post(url + '/Developer/listPageDeveloperRestful',{Developer:$scope.Developer}).success(callback);
        };              
        $scope.searchPaginator=Paginator(fetchFunction,8);      
                  
        $scope.view=function(id)
        {
        	$http.get(url+'/Developer/getDeveloperByIdRestful/'+id).success(function(data)
        	{
        		$scope.developer=data.Developer;
        		
        		console.log($scope.developer);
            });
        };
        
        $scope.update=function()
        {
        	$http.put(url+'/Developer/updateDeveloperRestful',{Developer:$scope.developer}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("修改成功");
            }).error(function(data, status, headers, config){
	            alert("修改失败");
	        }) ;
        };
        
        $scope.insert=function()
        {
        	$http.post(url+'/Developer/insertDeveloperRestful',{Developer:$scope.addDeveloper}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("添加成功");
            }).error(function(data, status, headers, config){
	            alert("添加失败");
	        }) ;
        };
        
     
        
        
        $scope.deleteDevelopers=function()
        {
        	if(confirm("确定删除？"))
        	{
        		var indexchekbox=0;
        		var indexsuccess=0;
        		for(var i=0;i<$scope.searchPaginator.object.developers.length;i++){
	    			if($scope.searchPaginator.object.developers[i].checkbox==true){
	    				indexchekbox++;
	    				$http({
	    					method:'DELETE',
	    					url:url + '/Developer/deleteDeveloperRestful/'+$scope.searchPaginator.object.developers[i].developersId
	    				})
	    				.success(function(data, status, headers, config){
	    					indexsuccess++;
	    					if(indexchekbox==indexsuccess)
	    					{
	    						$scope.searchPaginator._load();
	    						alert("删除成功");
	    					}
	    				}).error(function(data, status, headers, config){
	    		            alert("删除失败");
	    		            return;
	    		        }) ;
	    			};
	    		}
        	}
        };

});
		});