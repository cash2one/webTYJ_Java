/**
 * Created by Administrator on 2015/4/20.
 * 社区公告
 */

/**
 * Created by Administrator on 2015/4/20. 社区公告
 */

'use strict';

define([ 'tyjApp','pageServices' ], function(module) {
	module.controller("comAnnounceCtrl", function($scope, $http, Paginator,
			$rootScope) {

		// 获取父类Url地址
		var url = $rootScope.url;

		// 定义一个变量
		$scope.Communtitnotice = {
			page : {}
		};

		$scope.addCommuntitnotice = {};

		var fetchFunction = function(page, callback) {

			$scope.Communtitnotice.page = page;

			$http.post(url + '/Communtitnotice/listPageCommuntitnoticeRestful',
					{
						Communtitnotice : $scope.Communtitnotice
					}).success(callback);
		};

		$scope.searchPaginator = Paginator(fetchFunction, 10);

		$scope.view = function(id) {
			$http.get(url + '/Communtitnotice/getCommuntitnoticeById/' + id)
					.success(function(data) {
						$scope.communtitnotice = data.Communtitnotice;
					});
		};

		$scope.update = function() {
			$http.put(url + '/Communtitnotice/UpdateCommuntitnotice', {
				Communtitnotice : $scope.communtitnotice
			}).success(function() {
				$scope.searchPaginator._load();// ˢ�����
				alert("�޸ĳɹ���");
			}).error(function(data, status, headers, config) {
				alert("�޸�ʧ�ܣ�");
			});
		};

		$scope.insert = function() {
			console.log($scope.addCorporatenews);
			$http.post(url + '/Communtitnotice/AddCommuntitnotice', {
				Communtitnotice : $scope.addCommuntitnotice
			}).success(function() {
				$scope.searchPaginator._load();// ˢ�����
				alert("��ӳɹ���");
			}).error(function(data, status, headers, config) {
				alert("���ʧ�ܣ�");

			});

		};
	});
});