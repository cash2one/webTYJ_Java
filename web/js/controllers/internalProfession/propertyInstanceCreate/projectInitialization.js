/**
 * Created by 彭婷婷 on 2015/6/9.
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("projectInitializationCtrl",function($scope,$http,$rootScope){
        var url = $rootScope.url;
        $http.get(url + '/Project/listAllProject').success(function(data) {
            console.log(data);
            $scope.projects= data.Project;
        });

        $scope.insert=function(){
            console.log("Proud Winphone");
            $http.post(url+'/Project/insertProject',{Project:$scope.addProject}).success(function(){
                alert("添加成功");
            }).error(function(data, status, headers, config){
                alert("添加失败");
            }) ;

        };

    });
});
