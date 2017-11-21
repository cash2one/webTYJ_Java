/**
 * Created by lenovo on 2015/5/6.
 * 项目团队管理
 * author:王志刚
 *
 */
'use strict';

define(['tyjApp',
        'controllers/internalProfession/projectManagementTeam/checkProject',
        'controllers/internalProfession/projectManagementTeam/checkPerson',
		'controllers/internalProfession/projectManagementTeam/search'
    ],
    function(module){
    module.controller("projectTeamCtrl",function($scope){
        $scope.test='111123';
    });
});