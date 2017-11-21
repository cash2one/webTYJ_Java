/**
 * Created by 彭婷婷 on 2015/4/17.
 * 修改时间:2015/6/3
 * 修改人：彭婷婷
 * 修改内容:搜素功能
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("institutionNext02Ctrl",function($scope){
        //搜索条件
        $scope.projectName='';
        $scope.houseData=[
            {houseId:'1',name:'桃源居一期',department:'一区一栋',detailedInformation:'详细信息',project:1},
            {houseId:'2',name:'桃源居二期',department:'一区二栋',detailedInformation:'详细信息',project:2},
            {houseId:'3',name:'桃源居三期',department:'二区三栋',detailedInformation:'详细信息',project:3},
            {houseId:'4',name:'桃源居一期',department:'一区四栋',detailedInformation:'详细信息',project:1},
            {houseId:'5',name:'桃源居二期',department:'三区一栋',detailedInformation:'详细信息',project:2},
            {houseId:'6',name:'桃源居一期',department:'一区二栋',detailedInformation:'详细信息',project:1},
            {houseId:'7',name:'桃源居四期',department:'四区三栋',detailedInformation:'详细信息',project:4},
            {houseId:'8',name:'桃源居一期',department:'一区四栋',detailedInformation:'详细信息',project:1}
        ];
        $scope.projectName=[
                {id: '1', name: '桃源居一期'},
                {id: '2', name: '桃源居二期'},
                {id: '3', name: '桃源居三期'},
                {id: '4', name: '桃源居四期'}
           ];
        //下拉选集合
        $scope.selectedCollection ={};
        //根据条件查询以后存放数据
        $scope.itemsData=[{}];
        /**
         * 搜索查询任务
         */
        $scope.searchTask=function(){
            //清空存放的数据
            if($scope.itemsData.length>1){
                $scope.itemsData.splice(1,$scope.itemsData.length);
            }
            for(var i=0;i<$scope.houseData.length;i++){
                //输入单个条件查询
                if($scope.project==$scope.houseData[i].project){
                    $scope.itemsData.push($scope.houseData[i]);
                }
            }
        };
    });
});