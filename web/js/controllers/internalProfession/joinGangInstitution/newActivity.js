/**
 * Created by 彭婷婷 on 2015/5/14.
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("newActivityCtrl",function($scope){
        var vm = $scope.vm = {};
        vm.joinGangStartTime='';
        vm.joinGangEndTime='';
        vm.defaultTime='';
        vm.chooseMonth='';
        vm.pds='';
        //选择预交管理费月数
        vm.chooseMonth=[
            {id: '1', name: '1'},
            {id: '2', name: '2'},
            {id: '3', name: '3'},
            {id: '4', name: '4'},
            {id: '5', name: '5'},
            {id: '6', name: '6'},
            {id: '7', name: '7'},
            {id: '8', name: '8'},
            {id: '9', name: '9'},
            {id: '10', name: '10'},
            {id: '11', name: '11'},
            {id: '12', name: '12'}
        ];
        //$scope.change = function () {
        //    alert(vm.defaultTime);
        //}
        //checkbox的值
        vm.pds = [
            {id:'1',name: '开发商'},
            {id:'2',name: '业主'}
        ];
        //团队成员
        vm.teams=[
            {id:'1',name:'张三',department:'清洁部'},
            {id:'2',name:'丽丽',department:'维修部'},
            {id:'3',name:'张旭',department:'安保部'},
            {id:'4',name:'方小兰',department:'园林部'},
            {id:'5',name:'章大西',department:'清洁部'}
        ];

    });
});