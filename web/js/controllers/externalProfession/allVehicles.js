/**
 * 创建时间：2015/5/19
 * author:钟加诚
 * 修改人：钟加诚
 * 修改内容：添加车辆数据，查询和筛选数据，页面与模态框中数据传输
 * 最后修改时间：2015/6/1
 * jsName:外部专业线全部车辆
 */

'use strict';
define(['tyjApp'],function(module){
    module.controller("allVehiclesCtrl",function($scope){
        //输入框input
        $scope.n=0;//n的初始值赋值为0
        $scope.numberCard='';
        $scope.per='';
        $scope.typ='';
        //全部车辆数据
        $scope.vehiclesItem=[
            {vehiclesId:'1',typ:'1',numberplate:'12313',color:'蓝',transactor:'周润发',operate:'范冰冰',licence:'鄂F12133',vehicleModels:'宝马',commissionAgent:'章子怡',operateTime:'2015-2-3'},
            {vehiclesId:'2',typ:'2',numberplate:'42414',color:'黄',transactor:'张无忌',operate:'李冰冰',licence:'鄂F33333',vehicleModels:'奥迪',commissionAgent:'汪峰',operateTime:'2015-2-3'},
            {vehiclesId:'3',typ:'3',numberplate:'24134',color:'红',transactor:'李逍遥',operate:'范玮琪',licence:'鄂F11233',vehicleModels:'路虎',commissionAgent:'头条',operateTime:'2015-2-3'}
        ];
        //查询数组
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.vehiclesItem.length;i++){
                if($scope.vehiclesItem[i].vehiclesId==$scope.n ||
                    $scope.vehiclesItem[i].numberplate==$scope.numberCard ||
                    $scope.vehiclesItem[i].transactor==$scope.per||
                    $scope.vehiclesItem[i].typ==$scope.typ){
                    $scope.itemsone.push($scope.vehiclesItem[i]);
                }
            }
        };
        //模态框数据
        $scope.show = function(vehiclesId) {
            $scope.vehiclesId = $scope.vehiclesItem[vehiclesId-1].vehiclesId;
            $scope.numberplate = $scope.vehiclesItem[vehiclesId-1].numberplate;
            $scope.color = $scope.vehiclesItem[vehiclesId-1].color;
            $scope.operateTime = $scope.vehiclesItem[vehiclesId-1].operateTime;
            $scope.vehicleModels = $scope.vehiclesItem[vehiclesId-1].vehicleModels;
            $scope.operateTime = $scope.vehiclesItem[vehiclesId-1].operateTime;
            $scope.licence = $scope.vehiclesItem[vehiclesId-1].licence;

        };
    });
});