/**
 * Created by Administrator on 2015/5/8.
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("searchCtrl",function($scope){
        $scope.items=[
            {name:'张三'}, {name:'李四'}, {name:'王五'}, {name:'赵六'},  {name:'李七'},  {name:'杨明'}
        ]
    });
});