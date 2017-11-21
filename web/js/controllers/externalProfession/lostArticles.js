/**
 * Created by Administrator on 2015/5/7.
 */

'use strict';
define(['tyjApp'],function(module){
    module.filter('len',function(){
        return function(items,start,end){
            var it =[];
            for(var i=start;i<end;i++){
                it.push(items[i]);
            }
            return it;
        }
    });
    module.controller("lostArticlesCtrl",function($scope){

        $scope.panels={
            countShow:2,
            currentIndex:0,
            panelList:[
                {time:'2015.4.26',itemName:'身份证',number:'1张'},
                {time:'2015.4.27',itemName:'钥匙',number:'1串'},
                {time:'2015.4.28',itemName:'身份证',number:'2张'},
                {time:'2015.4.29',itemName:'钥匙',number:'2串'},
                {time:'2015.5.26',itemName:'身份证',number:'1张'},
                {time:'2015.6.26',itemName:'钥匙',number:'1串'}
            ]
        };

        $scope.turnLeft=function(){
            var index=$scope.panels.currentIndex;
            $scope.panels.currentIndex=index>0?index-1:0;
        };
        $scope.turnRight=function(){
            var index=$scope.panels.currentIndex;
            var maxIndex=$scope.panels.panelList.length-$scope.panels.countShow;
            $scope.panels.currentIndex=index<maxIndex?index+1:index;
        };
        $scope.togglePanel=function(index){
            $scope.panels.panelList[index].active=!$scope.panels.panelList[index].active;
        };
        $scope.showMore=function(index){

        };
    });
});