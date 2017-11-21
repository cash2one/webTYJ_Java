/**
 * 新增 by 肖聪 on 2015/6/1.
 */
'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("staffsuperviseITCheckCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
        $scope.Staff={page:{}};
        $scope.addSpecialtyInfo={};

        var fetchFunction = function(page,callback) {
            $scope.Staff.page=page;
            $http.post(url + '/staff/listPageStaffRestful',{Staff:$scope.Staff}).success(callback);
        };

        $scope.searchPaginator=Paginator(fetchFunction,8);


        //$http.get(url + '/staff/listAllStaffRestful').success(function(data) {
    	//	console.log(data);
    	//	$scope.staff = data.Staff;
    	//});

        $scope.view=function(staffId)
        {
            $http.get(url+'/staff/getStaffById/'+staffId).success(function(data)
            {
                $scope.staff1=data.Staff;
                console.log($scope.staff);
            });
        };

    });
});