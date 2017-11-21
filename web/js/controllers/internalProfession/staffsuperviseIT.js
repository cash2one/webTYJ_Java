/**
 * Created by daniel on 2015/5/11.
 */



'use strict';

define(['tyjApp',
    'controllers/internalProfession/staffsuperviseIT/staffsuperviseITAdd',
    'controllers/internalProfession/staffsuperviseIT/staffsuperviseITCheck'
],function(module){
    module.controller("staffsuperviseITCtrl",function($scope){
        $scope.test='111';
    });
});


/**
 * Created by Administrator on 2015/4/17.
 *developer
 */

/**
 * Created by Administrator on 2015/4/17.
 *developer
 */

'use strict';

define(['tyjApp',
    'controllers/internalProfession/staffsuperviseIT/staffsuperviseITAdd',
    'controllers/internalProfession/staffsuperviseIT/staffsuperviseITCheck'
],function(module){
    module.controller("staffsuperviseITCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
        console.log("aaaaaa");
        $scope.Staff={page:{}};
        $scope.addStaff={}; 
       
        var fetchFunction = function(page,callback) {
    		$scope.Staff.page=page;  		
            $http.post(url + '/Staff/listPagestaff',{Staff:$scope.Staff}).success(callback);
        };              
        $scope.searchPaginator=Paginator(fetchFunction,8);      
                  
        $scope.view=function(id)
        {
        	$http.get(url+'/Staff/getDeveloperByIdRestful/'+id).success(function(data)
        	{
        		$scope.staff=data.Staff;
        		console.log($scope.staff);
            });
        };
        
        $scope.update=function()
        {
        	$http.put(url+'/Staff/updateDeveloperRestful',{Developer:$scope.developer}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("修改成功");
            }).error(function(data, status, headers, config){
	            alert("修改失败");
	        }) ;
        };
        
        $scope.insert=function()
        {
        	$http.post(url+'/Staff/insertDeveloperRestful',{Developer:$scope.addDeveloper}).success(function()
        	{
        		$scope.searchPaginator._load();
        		alert("添加成功");
            }).error(function(data, status, headers, config){
	            alert("添加失败");
	        }) ;
        };
        
        
        
        
        $scope.deleteStaffs=function()
        {
        	if(confirm("确定删除？"))
        	{
        		var indexchekbox=0;
        		var indexsuccess=0;
        		for(var i=0;i<$scope.searchPaginator.object.staffs.length;i++){
	    			if($scope.searchPaginator.object.staffs[i].checkbox==true){
	    				indexchekbox++;
	    				$http({
	    					method:'DELETE',
	    					url:url + '/Staff/deleteDeveloperRestful/'+$scope.searchPaginator.object.developers[i].developersId
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