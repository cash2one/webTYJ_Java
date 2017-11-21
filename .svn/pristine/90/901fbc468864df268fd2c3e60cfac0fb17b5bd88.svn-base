/**
 * Created by Administrator on 2015/4/13.
 * 人员信息里的租赁
 */

/**
 * Created by Administrator on 2015/4/16.
 * 房屋信息里的租赁
 */

define(['tyjApp',
    'controllers/propertyService/staffHome/lease/leaseAdd',
    'controllers/propertyService/staffHome/lease/leaseHistory'
],function(module){
    module.controller("leaseCtrl",function($scope,$rootScope){
    	//$rootScope.houses=[{}];
    });
});
/*define(['tyjApp'],function(module){
    module.controller("leaseCtrl",function($scope,$http,$rootScope){
    	$scope.tip="������Ϣ";
        $scope.Leases={};
        $scope.addLease={};
    	var url = $rootScope.url;
    	$http.get(url + '/Lease/listAllLease').success(function(data) {
    		console.log(data);
    		$scope.Lease = data.Lease;
    	});
    	
    	$scope.AddOrUpdateLease=function(){
    		console.log($scope.Lease);
    		if($scope.Lease.leaseId==0 || $scope.Lease.leaseId==null)
    		{
    			$http.post(url + '/Lease/insertLease',{Lease:$scope.addLease}).success(function(data) {
    				$http.get(url + '/Lease/listAllLease').success(function(data) {
    					console.log(data);
    			        $scope.Lease = data.Lease;
    			        
    			    });
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}else
    		{
    			$http.put( url + '/Lease/updateLease',{Lease:$scope.Lease}).
    			success(function(data){	
    				$http.get(url + '/Lease/listAllLease').success(function(data) {
    					console.log(data);
    			        $scope.Lease = data.Lease;
    			    });
    	        }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}
    	};
    	
    });
});*/