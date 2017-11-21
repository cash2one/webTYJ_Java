/**
 * 创建人：李斌
 * 日期：2015/5/24
 * 名称：外部专业线-日检活动JS
 *  日期：2015/5/29
 js动态传送数据
 修改人：陶勇超
 */

'use strict';

define(['tyjApp'],function(module){
    module.controller("dayActivityCtrl",function($scope){
        $scope.test='test';

        $scope.items=[
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'},
            {date:'2015-5-20',name:'园林质检活动090'}
        ]
    });
});