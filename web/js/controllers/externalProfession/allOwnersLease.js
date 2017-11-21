
/**
 * 创建时间：2015/5/15
 * author:陶勇超
 * 修改人：钟加诚
 * 修改内容：添加租赁数据，查询和筛选数据，页面与模态框中数据传输
 * 最后修改时间：2015/6/1
 * jsName:外部专业线小区租赁
 */



'use strict';

define(['tyjApp'],function(module){
    module.controller("allOwnersLeaseCtrl",function($scope){
        //输入框input
        $scope.n=0;//n的初始值赋值为0
        $scope.rentere='';
        $scope.contractIde='';
        $scope.homeIde='';
        $scope.monthlyRent='';
        //小区租赁数据
        $scope.leaseItem=[
            {leaseId:1,homeId:'001',contractId:'D26584',transactor:'张无忌',renter:'陈坤',hireBegin:'2015/09/15',hireFinish:'2015/12/4',payFinish:'2015/12/15',monthlyRent:'1'},
            {leaseId:2,homeId:'002',contractId:'D26584',transactor:'张无忌',renter:'周润发',hireBegin:'2015/09/15',hireFinish:'2015/12/4',payFinish:'2015/12/15',monthlyRent:'2'},
            {leaseId:3,homeId:'003',contractId:'D26584',transactor:'张无忌',renter:'张无忌',hireBegin:'2015/09/15',hireFinish:'2015/12/4',payFinish:'2015/12/15',monthlyRent:'1'}
        ];
        //查询数组
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.leaseItem.length;i++){
                if($scope.leaseItem[i].petId==$scope.n ||
                    $scope.leaseItem[i].renter==$scope.rentere ||
                    $scope.leaseItem[i].contractId==$scope.contractIde ||
                    $scope.leaseItem[i].homeId==$scope.homeIde ||
                    $scope.leaseItem[i].monthlyRent==$scope.monthlyRent){
                    $scope.itemsone.push($scope.leaseItem[i]);
                }
            }
        };
        //模态框数据传入
        $scope.show = function(leaseId) {
            $scope.leaseId = $scope.leaseItem[leaseId-1].leaseId;
            $scope.homeId = $scope.leaseItem[leaseId-1].homeId;
            $scope.contractId = $scope.leaseItem[leaseId-1].contractId;
            $scope.transactor = $scope.leaseItem[leaseId-1].transactor;
            $scope.renter = $scope.leaseItem[leaseId-1].renter;
            $scope.hireBegin = $scope.leaseItem[leaseId-1].hireBegin;
            $scope.hireFinish = $scope.leaseItem[leaseId-1].hireFinish;
            $scope.payFinish = $scope.leaseItem[leaseId-1].payFinish;
        };
    });
});