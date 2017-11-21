/**
 * Created by 陶勇超 on 2015/6/3.
 * 新增服务请求
 * newServiceRequest
 */
'use strict';
define(['tyjApp'], function(module){
    module.controller("newServiceRequestCtrl",function($scope,$http,$rootScope){
        /**
         * 服务请求数据来源
         * @type {{reqId: string, reqDate: string, reqType: string, serviceType: string, customerName: string}[]}
         */
        $scope.vms=[{reqId:'1-1458866852',reqDate:'2015-4-4',reqType:'清洁',serviceType:'前台',customerName:'周润发'},
            {reqId:'1-1458866853',reqDate:'2015-4-5',reqType:'园林',serviceType:'前台',customerName:'周润发'},
            ];
        $scope.trees=  [
            {
                id: 1,
                title:'桃源居',
                nodes: [
                    {
                        id: 11,
                        title: '一区',
                        nodes: [
                            {
                                id: 111,
                                title: "1栋",
                                nodes: [
                                    {
                                        id: 111,
                                        title: "101室",
                                        nodes: []
                                    },
                                    {
                                        id: 111,
                                        title: "102室",
                                        nodes: []
                                    },
                                ]
                            },
                            {
                                id: 111,
                                title: "2栋",
                                nodes: [
                                    {
                                        id: 111,
                                        title: "201室",
                                        nodes: []
                                    },
                                    {
                                        id: 111,
                                        title: "202室",
                                        nodes: []
                                    },
                                ]
                            },
                            {
                                id: 111,
                                title: "3栋",
                                nodes: []
                            }
                        ]
                    },
                    {
                        id: 12,
                        title: '2区',
                        nodes: []
                    }
                ]
            }
        ];

        //任务类型
        $scope.taskType=[{id:1,typeName:'赔偿给业主'},
            {id:1,typeName:'室内维修'},
            {id:1,typeName:'清洁'},
            {id:1,typeName:'园林'},
            {id:1,typeName:'安保'},
            {id:1,typeName:'邻里纠纷'},
            {id:1,typeName:'重大事项'}];

    });
});
