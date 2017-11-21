/**
 * Created with Intellij IDEA. Author:LiuYang Date: 14.11.12 Time: 18:58
 * 2015/5/14. 【假期管理】内部专业线
 */
'use strict';
define(
		[ 'tyjApp', 'pageServices' ],
		function(module) {
			module
					.controller(
							"vacationCtrl",
							function($scope, $http, Paginator, $rootScope) {
								var url = $rootScope.url;
								$scope.Vacation = {
									page : {}
								};
								$scope.addVacation = {};

								/**
								 * 获取所有的假期管理对象集合(分页)
								 */
								var fetchFunction = function(page, callback) {
									$scope.Vacation.page = page;
									$http
											.post(
													url
															+ '/Vacation/getPageRestfulVacation',
													{
														Vacation : $scope.Vacation
													}).success(callback);
								};
								$scope.searchPaginator = Paginator(
										fetchFunction, 8);

								/**
								 * 根据id获取假期对象信息
								 */
								$scope.view = function(id) {
									$http
											.get(
													url
															+ "/Vacation/getVacationById/"
															+ id)
											.success(
													function(data) {
														$scope.vacations = data.Vacation;
													})
								}

								/**
								 * 判断是增加或修改假期信息
								 */
								$scope.addOrUpdateVacation = function() {
									// 进行修改假期信息
									if ($scope.vacations.id != null
											&& $scope.vacations.id != 0) {
										$http
												.post(
														url
																+ "/Vacation/editVacation/",
														{
															Vacation : $scope.vacations
														})
												.success(
														function() {
															$scope.searchPaginator
																	._load();
															alert("修改成功");
														})
												.error(
														function(data, status,
																headers, config) {
															alert("系统繁忙,请稍后再试!");
														});
									} else {
										// 否则进行增加假期信息
										$http.post(
												url + "/Vacation/addVacation/",
												{
													Vacation : $scope.vacations
												}).success(function() {
											$scope.searchPaginator._load();
											alert("新增成功");
										}).error(
												function(data, status, headers,
														config) {
													alert("系统繁忙,请稍后再试!");
												});
									}
								}

								/**
								 * 删除假期信息(修改假期状态)
								 */
								$scope.deleteVacations = function() {
									if (confirm("你确定删除吗？")) {
										var indexchekbox = 0;
										var indexsuccess = 0;
										for ( var i = 0; i < $scope.searchPaginator.object.vacations.length; i++) {
											if ($scope.searchPaginator.object.vacations[i].checkbox == true) {
												indexchekbox++;
												$http(
														{
															method : 'DELETE',
															url : url
																	+ '/Vacation/delVacationById/'
																	+ $scope.searchPaginator.object.vacations[i].id
														})
														.success(
																function(
																		data,
																		status,
																		headers,
																		config) {
																	indexsuccess++;
																	if (indexchekbox == indexsuccess) {
																		$scope.searchPaginator
																				._load();
																		alert("删除成功");
																	}
																})
														.error(
																function(
																		data,
																		status,
																		headers,
																		config) {
																	alert("删除失败");
																	return;
																});
											}
											;
										}
									}
								};

							});
		});

/*
 * // 【数据来源】 var url="data/vacationInfo.txt"; // 【查询】 $scope.allChecked=false;
 * $scope.list=function(){ $http.get(url).success(function(resJson){
 * $scope.items = resJson; angular.forEach($scope.items, function(item) {
 * item.checked=false; }); }); }; // 【加载查询信息】 $scope.list();
 */

/*
 * $scope.toUpdate = function(index) { $scope.currentIndex=index;
 * $scope.currentItem=tyjUtil.jsonClone($scope.items[index]); }; // 【添加】
 * $scope.toAdd=function(){ $scope.currentIndex=null; $scope.currentItem={}; }; //
 * 【保存】 $scope.save=function(item){ // 判断是添加还是修改 if(null!=$scope.currentIndex){ //
 * 【修改】 $scope.items[$scope.currentIndex]=tyjUtil.jsonClone($scope.currentItem);
 * }else{ // 【添加】 $scope.items.push($scope.currentItem); } }; // 全选
 * $scope.checkAll = function(checked) { angular.forEach($scope.items,
 * function(item) { item.$checked = checked; }); }; // 【全选删除】
 * $scope.delete=function(checked){ if(confirm("确定要删除？")){ var checkList=[]; var
 * delIds=[]; angular.forEach($scope.items, function (item, index) {
 * if(item.$checked){ delIds.push(item.id); checkList.push(index); } });
 * if(checkList.length>0){ // 发送请求,请求带上delIds console.log("删除"+delIds); var
 * url="data/success.txt"; $http.get(url).success(function(resJson){
 * $scope.reqItems=resJson; if($scope.reqItems.status==='success'){ for(var
 * i=0;i<checkList.length;i++){ $scope.items.splice(i,1); } } else{
 * alert("删除失败！"); } }); } else{ alert("请选择删除项！"); } } };
 */
