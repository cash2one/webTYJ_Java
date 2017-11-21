/**
 * 前端负责人 倪明
 * 后端负责人：
 * 名称：首页加载js
 * 创建时间：2015/4/1
 * 修改时间：2015/5/25
 */
'use strict';
requirejs.config({
    baseUrl: "./js",
    paths:{
        angular:"angular",
        angularRoute: "angular-route",
        angularResource:"angular-resource",
        angularSanitize:"angular-sanitize",
        bootStrap:"bootstrap",
        jquery:"jquery-1.11.2"
    },
    shim:{
        bootStrap:{
            deps:['jquery'],
            exports:"bootStrap"
        },
        angular: {
            deps:["jquery"],
            exports:"angular"
        },
        angularRoute: ['angular'],
        angularResource:['angular'],
        angularSanitize:['angular']
    }
});
requirejs(["angular",
    'angularAnimate',
    'angularUiRouter',
    "angularRoute",
    "angularResource",
    "angularSanitize",
    "bootStrap",
    "jquery"
    ], function(angular){
    var indexApp=angular.module("indexApp", ['ngAnimate','ui.router.util',"ngRoute",
        "ngResource",
        "ngSanitize"
        ]);
    indexApp.config(function($locationProvider,$routeProvider){
        $routeProvider.when('/', {
            controller: 'mainCtrl',
            templateUrl: './page/main.html'
        })
        .otherwise({
            redirectTo: '/'
        });
    });
    indexApp.controller("indexCtrl",function($scope){

    }).controller("mainCtrl11",function($scope){
        $scope.hello="你好";
    });
    angular.bootstrap($("body").get(), ['indexApp']);
    return indexApp;
});