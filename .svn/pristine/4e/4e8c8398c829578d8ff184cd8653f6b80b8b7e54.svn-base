/**
 * 创建时间：2015/5/19
 * author:钟加诚
 * 修改人：钟加诚
 * 修改内容：添加放行条数据，查询和筛选数据，页面与模态框中数据传输
 * 最后修改时间：2015/6/1
 * jsName:外部专业线小区放行条
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("allReleaseCtrl",function($scope){
        //输入框input
        $scope.a=0;//n的初始值赋值为0
        $scope.applicant='';
        $scope.identifierNb='';
        $scope.typ='';
        //小区放行条数据
        $scope.releaseItem=[
            {releaseId:'1',typ:'1',userExit:'A栋正门',applicant:'张无忌',validity:'2015/8/29',releaseClock:'15点30分',identifierNb:'001',releaseTime:'20分钟',gonePhone:'398776665',goneAutograph:'刘德华'},
            {releaseId:'2',typ:'2',userExit:'B栋正门',applicant:'陈坤',validity:'2015/12/29',releaseClock:'11点30分',identifierNb:'002',releaseTime:'20分钟',gonePhone:'818776665',goneAutograph:'刘德华'},
            {releaseId:'3',typ:'1',userExit:'C栋正门',applicant:'哈利路亚',validity:'2015/4/29',releaseClock:'19点30分',identifierNb:'004',releaseTime:'20分钟',gonePhone:'128776665',goneAutograph:'梁朝伟'}
        ];
        //查询数组
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.releaseItem.length;i++){
                if($scope.releaseItem[i].releaseId==$scope.a ||
                    $scope.releaseItem[i].applicant==$scope.applicant ||
                    $scope.releaseItem[i].identifierNb==$scope.identifierNb||
                    $scope.releaseItem[i].typ==$scope.typ){
                    $scope.itemsone.push($scope.releaseItem[i]);
                }
            }
        };
        //模态框数据
        $scope.show = function(releaseId) {
            $scope.releaseId = $scope.releaseItem[releaseId-1].releaseId;
            $scope.userExit = $scope.releaseItem[releaseId-1].userExit;
            $scope.applicant = $scope.releaseItem[releaseId-1].applicant;
            $scope.validity = $scope.releaseItem[releaseId-1].validity;
            $scope.releaseClock = $scope.releaseItem[releaseId-1].releaseClock;
            $scope.identifierNb = $scope.releaseItem[releaseId-1].identifierNb;
            $scope.releaseTime = $scope.releaseItem[releaseId-1].releaseTime;
            $scope.gonePhone = $scope.releaseItem[releaseId-1].gonePhone;
            $scope.goneAutograph = $scope.releaseItem[releaseId-1].goneAutograph;
        };
    });
});