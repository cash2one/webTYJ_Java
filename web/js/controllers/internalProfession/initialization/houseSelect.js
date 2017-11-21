/**
 * Created by 彭婷婷 on 2015/5/6.
 * jsName:内部专业线建筑功能区域配置查询户型
 * 修改人：王志刚
 * 最后修改时间：2015/6/2
 *
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("houseSelectCtrl",function($scope){
        $scope.n='';//n的初始值赋值为0
        $scope.items=[
            {projectName:'01',houseType:'二室二厅',houseNumber:'TYJ001',createName:'范冰冰',createTime:'2015/4/10',updateName:'杨林',updateTime:'2015/5/30'},
            {projectName:'02',houseType:'三室二厅',houseNumber:'TYJ002',createName:'范冰冰',createTime:'2015/4/10',updateName:'杨林',updateTime:'2015/5/30'},
            {projectName:'03',houseType:'四室二厅',houseNumber:'TYJ003',createName:'范冰冰',createTime:'2015/4/10',updateName:'杨林',updateTime:'2015/5/30'},
            {projectName:'04',houseType:'三室二厅',houseNumber:'TYJ004',createName:'范冰冰',createTime:'2015/4/10',updateName:'杨林',updateTime:'2015/5/30'},
            {projectName:'05',houseType:'一室一厅',houseNumber:'TYJ005',createName:'范冰冰',createTime:'2015/4/10',updateName:'杨林',updateTime:'2015/5/30'},
        ]

        $scope.itemsone=[{}];

        //点击搜索的方法
        $scope.change=function(){
            if($scope.itemsone.length>1){
              $scope.itemsone.splice(1,$scope.itemsone.length);
            }
            for(var i= 0;i<$scope.items.length;i++){
                if($scope.items[i].projectName==$scope.n ){
                    $scope.itemsone.push($scope.items[i]);
                }
            }
        }
    });
});
