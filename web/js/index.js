/**
 * 前端负责人 倪明
 * 后端负责人：
 * 名称：所有常用js加载
 * 创建时间：2015/4/1
 * 修改时间：2015/5/25
 */
'use strict';
require.config({
    paths:{
        text:'lib/require/text',
        jquery:'lib/jquery/jquery-1.11.2',
        angular:'lib/angular/angular',
        angularAnimate:'lib/angular/angular-animate',
        angularUiRouter:'lib/angular/angular-ui-router',
        angularRoute: 'lib/angular/angular-route',
        angularResource:'lib/angular/angular-resource',
        angularSanitize:'lib/angular/angular-sanitize',
        bootStrap:'lib/bootstrap/bootstrap',
        uiBootStrap:'lib/bootstrap/ui-bootstrap-tpls-0.12.1',
        cookies:'lib/angular/angular-cookies.min',
        angularTreeControl:'lib/angular/tree/angular-tree-control',
        tyjUtil:'utils/tyjUtil',
        pageServices:'core/PageServices',
        angularFileUpload:'lib/angular/angular-file-upload'
    },
    shim:{
        bootStrap:['jquery'],
        angular:{
            exports:'angular'
        },
        angularAnimate: ['angular'],
        angularUiRouter: ['angular'],
        angularRoute: ['angular'],
        angularResource: ['angular'],
        angularSanitize: ['angular'],
        uiBootStrap: ['angular'],
        cookies:['angular'],
        angularTreeControl: ['angular'],
        angularFileUpload: ['angular']
    },
    priority:[
        'angular'
    ],
    urlArgs:'v=1.1'
});
require([
    'bootStrap',
    'angular',
    'angularAnimate',
    'angularUiRouter',
    'angularRoute',
    'angularResource',
    'angularSanitize',
    'uiBootStrap',
    'cookies',
    'angularTreeControl',
    'angularFileUpload',
    'tyjApp',
    'main'
], function () {
    angular.bootstrap($(document).get(), ['tyjApp']);
});
