/**
 * Created by 彭婷婷 on 2015/5/7.
 * 我的团队(专业)
 * 修改时间：2015/6/4
 * 修改人：彭婷婷
 * 修改内容:数据从后台显示
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("myTeamProfessionCtrl",function($scope,$http,$rootScope){
        var staffId= 2;  //员工id
        var url = $rootScope.url;
        $http.get(url + '/Teamworkstaff/getTeamworkstaffbyStaffId/'+staffId).success(function(data) {
            console.log(data);
            $scope.teamworkstaffs = data.Teamworkstaff;
        });
        $scope.titleList=[
            {title:'序号',projectname:'项目名称',clean:'清洁',maintain:'维修',park:'园林',security:'安保' }
        ];
        $scope.personList=[
            {id:'1',projectname:'深圳宝安桃源居',clean:'3',maintain:'3',park:'3',security:'3' },
            {id:'2',projectname:'深圳宝安桃源商务大厦',clean:'2',maintain:'2',park:'2',security:'2' }
        ];

    });
});