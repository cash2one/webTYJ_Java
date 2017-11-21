/**
 * Created by daniel on 2015/5/7.
 * 【任务查询】外部专业线
 * createTime:2015/04/25
 * 创建人:李斌
 * 修改人：刘洋
 * 修改内容：数据显示动态效果
 * 修改时间：2015/6/1
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("queryTaskCtrl",function($scope,$http){

        //搜索条件
        $scope.searchName='';
        //客户名称
        $scope.customerName='';
        //联系电话
        $scope.customerPhone='';
        //任务Id
        $scope.taskId='';
        //工单Id
        $scope.orderId='';
        //请求类型
        $scope.reqType='';
        /**
         * 查询任务数据来源
         * @type {{title: string, reqId: number, taskId: number, orderId: number, taskType: string, startTime: string, fishTime: string, userName: string, address: string, phone: string}[]}
         */
        $scope.tasks=[
            {title:'修',reqId:1001,taskId:'B7686',orderId:'0001',taskType:'维修',startTime:'2015-04-05 13:00',fishTime:'2015-04-05 16：00',userName:'刘晓明',address:'桃源居7区3栋301',phone:'1333222111'},
            {title:'修',reqId:1002,taskId:'A7683',orderId:'0002',taskType:'清洁',startTime:'2015-04-05 13:00',fishTime:'2015-04-05 16：00',userName:'李冰冰',address:'桃源居7区3栋301',phone:'13012343323'},
            {title:'修',reqId:1003,taskId:'B7685',orderId:'0003',taskType:'园林',startTime:'2015-04-05 13:00',fishTime:'2015-04-05 16：00',userName:'周润发',address:'桃源居7区3栋301',phone:'13012343325'},
            {title:'修',reqId:1004,taskId:'B7689',orderId:'0004',taskType:'安保',startTime:'2015-04-05 13:00',fishTime:'2015-04-05 16：00',userName:'刘德华',address:'桃源居7区3栋301',phone:'13012343326 '},
            {title:'修',reqId:1005,taskId:'A7600',orderId:'0005',taskType:'园林',startTime:'2015-04-05 13:00',fishTime:'2015-04-05 16：00',userName:'周润发',address:'桃源居7区3栋301',phone:'13012343327'},
        ];
        //根据条件查询以后存放数据
        $scope.itemsone=[{}];
        /**
         * 搜索查询任务
         */
        $scope.searchTask=function(){
            //清空存放的数据
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length);
            }
            for(var i=0;i<$scope.tasks.length;i++){
                //输入单个条件查询
                if($scope.searchName==$scope.tasks[i].reqId||
                    $scope.searchName==$scope.tasks[i].userName||
                    $scope.customerName==$scope.tasks[i].userName||
                    $scope.customerPhone==$scope.tasks[i].phone||
                    $scope.taskId==$scope.tasks[i].taskId||
                    $scope.orderId==$scope.tasks[i].orderId){
                    $scope.itemsone.push($scope.tasks[i]);
                }
                //更准确的查询
                if( $scope.customerName==$scope.tasks[i].userName&&
                    $scope.customerPhone==$scope.tasks[i].phone||
                    $scope.customerName==$scope.tasks[i].userName&&
                    $scope.taskId==$scope.tasks[i].taskId||
                    $scope.customerName==$scope.tasks[i].userName&&
                    $scope.orderId==$scope.tasks[i].orderId
                ){
                    $scope.itemsone.splice(1,$scope.itemsone.length);
                    $scope.itemsone.push($scope.tasks[i]);
                }
            }
        };


    });
});