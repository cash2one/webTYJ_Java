/**
 * Created by 彭婷婷 on 2015/5/6.
 * 房型初始化---功能区域维护
 * 修改时间:
 * 修改人:
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("areaMaintainCtrl",function($scope){
        $scope.items=[
            {sectionNumber:'01',sectionName:'玄关',createName:'李冰冰',createTime:'2015/3/1',updateName:'',updateTime:''},
            {sectionNumber:'02',sectionName:'阳台',createName:'范冰冰',createTime:'2015/4/10',updateName:'',updateTime:''},
            {sectionNumber:'03',sectionName:'厨房',createName:'周润发',createTime:'2015/5/12',updateName:'',updateTime:''},
            {sectionNumber:'04',sectionName:'餐厅',createName:'李冰冰',createTime:'2015/4/25',updateName:'',updateTime:''},
            {sectionNumber:'05',sectionName:'阳台',createName:'李冰冰',createTime:'2015/5/9',updateName:'',updateTime:''},
            {sectionNumber:'06',sectionName:'主卧',createName:'李冰冰',createTime:'2015/4/28',updateName:'',updateTime:''}
        ]

        var cloneItem={};
        var items={};

        //点击修改获取值
        $scope.editItem = function(index) {
            $scope.currentIndex=index;
            items=$scope.Imoports[index];
            cloneItem={};
            for(var key in items){
                console.log(key+"--"+items[key]);
                cloneItem[key]=items[key];
            }
            $scope.import=cloneItem;
        };


        //提交确认修改信息
        $scope.updateInfo=function(){
            $scope.Imoports[$scope.currentIndex]= $scope.import;
        }


        //添加信息
        $scope.addInfo=function(items)
        {
            $scope.items[$scope.lastIndex]=items;
            $scope.items.push($scope.item);
        }

        //【删除】
        $scope.delete= function (index) {
            $scope.Imoports.splice(index, 1);
        };

    });
});