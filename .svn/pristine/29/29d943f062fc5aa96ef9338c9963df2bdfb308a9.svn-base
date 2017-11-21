/**
 * author:钟加诚
 * 最后修改时间：2015/5/29
 * jsName:外部专业线全部门禁卡
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("allCardCtrl",function($scope){

        //输入框input
        $scope.n=0;//n的初始值赋值为0
        $scope.iccCard='';
        $scope.per='';
        $scope.typ='';
        //数组
        $scope.cardItem=[
            {cardId:'1',icc:'12345',typ:'1',commissioning:'2015/5/4',personal:'周润发',condition:'正常',deadline:'2015/9/4',born:'2015/1/4'},
            {cardId:'2',icc:'13456',typ:'1',commissioning:'2015/9/4',personal:'张无忌',condition:'正常',deadline:'2015/8/4',born:'2015/2/4'},
            {cardId:'3',icc:'14567',typ:'2',commissioning:'2015/7/4',personal:'李逍遥',condition:'挂失',deadline:'2015/7/4',born:'2015/3/4'}
        ];
        //查询数组
        $scope.itemsone=[{}];

        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.cardItem.length;i++){
                if($scope.cardItem[i].cardId==$scope.n ||
                    $scope.cardItem[i].icc==$scope.iccCard ||
                    $scope.cardItem[i].personal==$scope.per||
                    $scope.cardItem[i].typ==$scope.typ){
                    $scope.itemsone.push($scope.cardItem[i]);
                }
            }
        };
        //模态框数据传入
        $scope.show = function(carId) {
            $scope.carId = $scope.cardItem[carId-1].cardId;
            $scope.icc = $scope.cardItem[carId-1].icc;
            $scope.commissioning = $scope.cardItem[carId-1].commissioning;
            $scope.personal = $scope.cardItem[carId-1].personal;
            $scope.condition = $scope.cardItem[carId-1].condition;
            $scope.deadline = $scope.cardItem[carId-1].deadline;
            $scope.born = $scope.cardItem[carId-1].born;
        };
    });
});