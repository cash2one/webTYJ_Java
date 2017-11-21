/**
 * Created by Administrator on 2015/4/17.
 *Room
 */

/**
 * Created by Administrator on 2015/4/17.
 *Room
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("professionallinemanagementCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	$scope.specialtys={};
    	//专业线信息初始化
        
        $scope.insert=function()
        {
        	for(var i=0;i<$scope.specialtys.length;i++){
        	 if($scope.specialtys[i].value!=""){
 				$scope.addSpecialtyInfo.specialtyName=$scope.specialtys[i].specialtyName;
 				$scope.addSpecialtyInfo.instanceId=7;
        	$http.post(url+'/SpecialtyInfo/insertSpecialtyInfoRestful',{SpecialtyInfo:$scope.addSpecialtyInfo}).success(function(){
        		alert("保存成功");
            }).error(function(data, status, headers, config){
	            alert("保存失败");
	        }) ;
        };
        };
        };
        
       
        
        
        $scope.deleteSpecialtyInfos=function()
        {
        	if(confirm("确定删除？"))
        	{
        		var indexchekbox=0;
        		var indexsuccess=0;
        		for(var i=0;i<$scope.searchPaginator.object.specialtyInfos.length;i++){
	    			if($scope.searchPaginator.object.specialtyInfos[i].checkbox==true){
	    				indexchekbox++;
	    				$http({
	    					method:'DELETE',
	    					url:url + '/Room/deleteSpecialtyInfoRestful/'+$scope.searchPaginator.object.specialtyInfos[i].specialtyInfoId
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