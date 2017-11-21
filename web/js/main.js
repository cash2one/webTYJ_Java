/**
 * 前端负责人 倪明
 * 后端负责人：
 * 名称：主页js加载
 * 创建时间：2015/4/1
 * 修改时间：2015/5/25
 */
'use strict';
define(['tyjApp',
    'top',
    'left',
    'controllers/enterprise',
    'controllers/workBench',
    'controllers/order',
    'controllers/propertyService',
    'controllers/externalProfession',
    'controllers/internalProfession',
    'controllers/business',
    'controllers/account'
    ],function(module){
    module.controller("mainCtrl",function($scope,$rootScope){
    	$rootScope.url="http://localhost:8080/webTYJ/cxfws/rest";
    });
});