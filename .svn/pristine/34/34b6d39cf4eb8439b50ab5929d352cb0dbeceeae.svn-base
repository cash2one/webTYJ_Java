/**
 * 创建人：李斌
 * 日期：2015/5/6
 * 名称：外部专业线-抄表管理历史记录JS
 * 修改时间：2015/5/29
 * 修改人：李斌
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("history01Ctrl",function($scope){
        $scope.historys=[
            {id:'1',name:'王大锤',meterType:'水表',startTime:'2015/05/08',taskProgress:'已完成',taskName:'范冰冰',fishTime:'2015/05/10',check:'勾选明细'},
            {id:'2',name:'王大锤',meterType:'电表',startTime:'2015/05/08',taskProgress:'已完成',taskName:'范冰冰',fishTime:'2015/05/10',check:'勾选明细'}
        ];

        //定义存放查表记录信息对象
        $scope.histroyItem={
            id:'',
            meterType:'',
            startTime:'',
            taskProgress:'',
            taskName:'',
            fishTime:''
        };
        //模态框数据传入
        $scope.show = function(id) {
            $scope.id = $scope.historys[id-1].id;
            $scope.name = $scope.historys[id-1].name;
            $scope.meterType = $scope.historys[id-1].meterType;
            $scope.startTime = $scope.historys[id-1].startTime;
            $scope.taskProgress = $scope.historys[id-1].taskProgress;
            $scope.taskName = $scope.historys[id-1].taskName;
            $scope.fishTime = $scope.historys[id-1].fishTime
        };
    });
});