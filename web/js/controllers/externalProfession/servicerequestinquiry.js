/**
 * 【服务请求查询】外部专业线
 * 创建人:王志刚
 * 创建时间：2015/5/7
 * 修改人：刘洋
 * 修改内容：数据显示动态效果
 * 修改时间：2015/6/1
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("servicerequestinquiryCtrl",function($scope,$http){
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
            {title:'修',reqId:1001,taskId:'B7686',orderId:'0001',taskType:'维修',startTime:'2015-04-05 13:00'
                ,fishTime:'2015-04-05 16：00',userName:'刘晓明',address:'桃源居7区3栋301',phone:'1333222111'
                ,projectName:'桃源居1',stageName:'1',building:'A',unitName:'一单元',houseName:'101'},
            {title:'修',reqId:1002,taskId:'A7683',orderId:'0002',taskType:'清洁',startTime:'2015-04-05 13:00'
                ,fishTime:'2015-04-05 16：00',userName:'李冰冰',address:'桃源居7区3栋301',phone:'13012343323'
                ,projectName:'桃源居2',stageName:'2',building:'B',unitName:'二单元',houseName:'102'},
            {title:'修',reqId:1003,taskId:'B7685',orderId:'0003',taskType:'园林',startTime:'2015-04-05 13:00'
                ,fishTime:'2015-04-05 16：00',userName:'周润发',address:'桃源居7区3栋301',phone:'13012343325'
                ,projectName:'桃源居3',stageName:'3',building:'C',unitName:'三单元',houseName:'102'},
            {title:'修',reqId:1004,taskId:'B7689',orderId:'0004',taskType:'安保',startTime:'2015-04-05 13:00'
                ,fishTime:'2015-04-05 16：00',userName:'刘德华',address:'桃源居7区3栋301',phone:'13012343326 '
                ,projectName:'桃源居2',stageName:'1',building:'A',unitName:'一单元',houseName:'102'},
            {title:'修',reqId:1005,taskId:'A7600',orderId:'0005',taskType:'园林',startTime:'2015-04-05 13:00'
                ,fishTime:'2015-04-05 16：00',userName:'周润发',address:'桃源居7区3栋301',phone:'13012343327'
                ,projectName:'桃源居3',stageName:'3',building:'C',unitName:'三单元',houseName:'103'},
        ];

        //下拉选数据源
        //$scope.classes = [
        //    {
        //        selectName: '项目名称',
        //        options: ['桃源居1' , '桃源居2', '桃源居3']
        //    },
        //    {
        //        selectName: "区/期 ",
        //        options: ['1' , '2', '3']
        //    },
        //    {
        //        selectName: "栋 ",
        //        options: ['A' , 'B', 'C']
        //    },
        //    {
        //        selectName: "单元 ",
        //        options: ['一单元' , '二单元', '三单元']
        //    },
        //    {
        //        selectName: "房号 ",
        //        options : ['101' , '102', '103']
        //    }
        //];
        //项目名称
        $scope.projectName = [{
            id : 1001,
            title : '桃源居1'
        },{
            id : 1002,
            title : '桃源居2'
        },{
            id : 1003,
            title : '桃源居3'
        }];
        //区/期
        $scope.stage = [{
            id : 1004,
            title : '1'
        },{
            id : 1005,
            title : '2'
        },{
            id : 1006,
            title : '3'
        }];
        //栋
        $scope.buildings = [{
            id : 1007,
            title : 'A'
        },{
            id : 1008,
            title : 'C'
        },{
            id : 1009,
            title : 'D'
        }];
        //单元
        $scope.unit = [{
            id : 1010,
            title : '一单元'
        },{
            id : 1011,
            title : '二单元'
        },{
            id : 1012,
            title : '三单元'
        }];
        //房号
        $scope.houseNum = [{
            id : 1010,
            title : '101'
        },{
            id : 1011,
            title : '102'
        },{
            id : 1012,
            title : '103'
        }];



        //下拉选集合
        $scope.selectedCollection ={};


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
                    $scope.orderId==$scope.tasks[i].orderId||
                    $scope.selectName==$scope.tasks[i].projectName||
                    $scope.stageName==$scope.tasks[i].stageName||
                    $scope.building==$scope.tasks[i].building||
                    $scope.unitName==$scope.tasks[i].unitName||
                    $scope.houseName==$scope.tasks[i].houseName
                ){
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
                    $scope.itemsone.splice($scope.itemsone.length,1);
                    $scope.itemsone.push($scope.tasks[i]);
                }
            }
        };

    });
});