/**
 * Created by 肖聪 on 2015/5/8.
 */
'use strict';
define([ 'tyjApp', 'pageServices' ], function(module) {
	module.controller("leaseHistoryCtrl", function($scope, $http, Paginator,
			$rootScope) {
		/*
		 * var url = $rootScope.url; $scope.NewLease = { page : {} }; var
		 * fetchFunction = function(page, callback) {
		 * 
		 * $scope.NewLease.page = page;
		 * 
		 * $http.post(url + '/NewLease/listPageNewLeaseRestful', { NewLease :
		 * $scope.NewLease }).success(callback); }; $scope.searchPaginator =
		 * Paginator(fetchFunction, 3); }); });
		 */
		// alert( $rootScope.houses);
		var url = $rootScope.url;
		$scope.NewLease = {
			page : {}
		};
		var fetchFunction = function(page, callback) {

			$scope.NewLease.page = page;

			$http.post(url + '/NewLease/listPageNewLeaseRestful', {
				NewLease : $scope.NewLease
			}).success(callback);
		};
		$scope.searchPaginator = Paginator(fetchFunction, 8);

		$scope.deleteLease = function(id) {
			alert("winPhone");
			$http.put(url + '/NewLease/deleteNewLeaseRestful/' + id).success(
					function() {

						alert("修改成功");
					}).error(function(data, status, headers, config) {
				alert("修改失败");
			});
		};

	});
});