/**
 * author:钟加诚
 * 最后修改时间：2015/5/29
 * jsName:外部专业线全部停车卡
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("allParkingCardCtrl",function($scope){

        $scope.n=0;//n的初始值赋值为0
        $scope.numberCard='';
        $scope.pers='';
        $scope.typ='';
        //全部停车卡数据
        $scope.cardItem=[
            {cardId:'1',numberplate:'鄂12313',typ:'1',condition:'正常',commissioning:'2015/3/2',personal:'周润发',icc:'32143',genre:'月卡',deadline:'2015/3/4',born:'2015/1/4'},
            {cardId:'2',numberplate:'鄂55513',typ:'1',condition:'正常',commissioning:'2015/7/2',personal:'张无忌',icc:'32143',genre:'年卡',deadline:'2015/3/4',born:'2015/1/4'},
            {cardId:'3',numberplate:'鄂11213',typ:'2',condition:'挂失',commissioning:'2015/1/2',personal:'周润发',icc:'32143',genre:'月卡',deadline:'2015/3/4',born:'2015/1/4'}
        ];
        //搜索查询
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.cardItem.length;i++){
                if($scope.cardItem[i].cardId==$scope.n ||
                    $scope.cardItem[i].numberplate==$scope.numberCard ||
                    $scope.cardItem[i].personal==$scope.pers||
                    $scope.cardItem[i].typ==$scope.typ){
                    $scope.itemsone.push($scope.cardItem[i]);
                }
            }
        };



        //模态框数据
        $scope.show = function(carId) {
            $scope.carId = $scope.cardItem[carId-1].cardId;
            $scope.numberplate = $scope.cardItem[carId-1].numberplate;
            $scope.condition = $scope.cardItem[carId-1].condition;
            $scope.commissioning = $scope.cardItem[carId-1].commissioning;
            $scope.personal = $scope.cardItem[carId-1].personal;
            $scope.icc = $scope.cardItem[carId-1].icc;
            $scope.genre = $scope.cardItem[carId-1].genre;
            $scope.deadline = $scope.cardItem[carId-1].deadline;
            $scope.born = $scope.cardItem[carId-1].born;
        };
    });
});