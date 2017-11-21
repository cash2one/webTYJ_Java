/**
 * Created by 陶勇超 on 2015/5/26.
 * 岗位人员配置
 */
'use strict';
define(['tyjApp'],function(module){
        module.controller("postPersonnelConfigurationCtrl",function($scope,$http,Paginator,$rootScope){
            var url = $rootScope.url;
            $scope.SpecialtyInfo={page:{}};
            $scope.addSpecialtyInfo={};
            $http.get(url + '/staff/listAllStaffRestful').success(function(data) {
                console.log(data);
                $scope.staff = data.Staff;
            });

            $scope.title=[{title:'序号',projectTitle:'项目',clean:'清洁',park:'园林',security:'安保',maintain:'维修',fireFighting:'消防'}];
            $scope.person=[
                {id:'1',project:'重庆桃源居',clean:'缺编1人',park:'满编',security:'缺编1人',maintain:'满编',fireFighting:'韦一笑'},
                {id:'2',project:'深圳宝安桃源大厦',clean:'缺编1人',park:'满编',security:'缺编1人',maintain:'满编',fireFighting:'张蓉'},
                {id:'3',project:'深圳宝安桃源大厦',clean:'缺编1人',park:'满编',security:'缺编1人',maintain:'满编',fireFighting:'张晓光'}
            ];
    });

});