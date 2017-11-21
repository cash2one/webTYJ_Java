/**
 * 页面名称：【专业资产初始化】查询资产
 * 页面路径：page/internalProfession/majorAssetInitialization/queryAssets.html
 * 前端负责人：刘洋
 * 创建时间：2015/5/6.
 * 修改人：王志刚
 * 最后修改日期：2015/6/2
 * 修改人：钟加诚
 * 最后修改时间：2015/6/9
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("queryAssetsCtrl",function($scope){

        //function addEvent(el,name,fn){
        //    if(el.addEventListener) return el.addEventListener(name,fn,false);
        //    return el.attachEvent('on'+name,fn);
        //}
        //function nextnode(node){
        //    if(!node)return ;
        //    if(node.nodeType == 1)
        //        return node;
        //    if(node.nextSibling)
        //        return nextnode(node.nextSibling);
        //}
        //
        //
        //addEvent(document.getElementById('root'),'click',function(e){
        //    e = e||window.event;
        //    var target = e.target||e.srcElement;
        //    var tp = nextnode(target.parentNode.nextSibling);
        //    switch(target.nodeName){
        //        case 'A':
        //            if(tp&&tp.nodeName == 'UL'){
        //                if(tp.style.display != 'block' ){
        //                    tp.style.display = 'block';
        //                    (target.parentNode.previousSibling).className = 'ren'
        //                }else{
        //                    tp.style.display = 'none';
        //                    (target.parentNode.previousSibling).className = 'add'
        //                }
        //            }
        //            break;
        //    }
        //});
        //
        //
        $scope.changState='';
        $scope.items=[
            {assetNumber:'01',assetName:'强电',sizeName:'',model:''},
            {assetNumber:'0101',assetName:'室内照明',sizeName:'',model:''},
            {assetNumber:'0102',assetName:'室外照明',sizeName:'',model:''},
            {assetNumber:'0103',assetName:'线材',sizeName:'',model:''},
            {assetNumber:'010301',assetName:'屏蔽聚氯乙烯护套软电缆',sizeName:'2*1.5cm',model:'RVVP'},
            {assetNumber:'010302',assetName:'超五类非屏蔽双绞线',sizeName:'2*1.5cm',model:'RVVP'},
            {assetNumber:'02',assetName:'弱电',sizeName:'25',model:'P-25'},
            {assetNumber:'0201',assetName:'视频线路',sizeName:'25',model:'P-25'},
            {assetNumber:'0202',assetName:'网络线路',sizeName:'25',model:'P-25'},
            {assetNumber:'0203',assetName:'电话线路',sizeName:'25',model:'P-25'},
        ]
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.items.length;i++){
                if($scope.items[i].serviceId==$scope.n || $scope.items[i].telephone==$scope.phpne || $scope.items[i].userName==$scope.cumtomerName || $scope.items[i].changState==$scope.changState ){
                    $scope.itemsone.push($scope.items[i]);
                }
            }
        }

    });
});