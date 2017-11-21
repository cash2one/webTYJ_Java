/**
 * Created by 彭婷婷 on 2015/5/7.
 * 我的团队(项目经理）
 * 修改时间：
 * 修改人：
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("myTeamProjectManagerCtrl",function($scope,$http,$rootScope){
    	var staffId= 2;  //员工id
    	var url = $rootScope.url;
      	$http.get(url + '/Teamworkstaff/getTeamworkstaffbyStaffId/'+staffId).success(function(data) {
      		console.log(data);
      		$scope.teamworkstaffs = data.Teamworkstaff;
          });
      	
    });
});