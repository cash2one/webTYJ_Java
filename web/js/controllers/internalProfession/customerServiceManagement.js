/**
 * 创建时间：2015/5/23
 * author:钟加诚
 * 修改人：钟加诚
 * 修改内容：添加数据，查询和筛选数据，页面与模态框中数据传输，修改
 * 最后修改时间：2015/6/3
 * jsName:内部专业线售后管理
 */

'use strict';

define(['tyjApp','tyjUtil'],function(module,tyjUtil){
    module.controller("customerServiceManagementCtrl",function($scope,$http){

        $scope.n=0;//n的初始值赋值为0
        $scope.specialty='';
        $scope.source='';
        $scope.condition='';
        $scope.assetName='';
        //数据源
        $scope.borderItem=[
            {borderId:1,address:'1栋单元101客厅',specialty:'强电',area:'A区',assetNumber:'0101',assetName:'实木地板',proprietor:'周润发',proprietorPh:'13567439060',condition:'已处理',source:'验房',questionDescribe:'Just so so'},
            {borderId:2,address:'2栋单元102客厅',specialty:'土建',area:'A区',assetNumber:'0201',assetName:'大理石地砖',proprietor:'梁朝伟',proprietorPh:'13567439062',condition:'处理中',source:'入伙',questionDescribe:'Just so so'},
            {borderId:3,address:'3栋单元201客厅',specialty:'装修',area:'B区',assetNumber:'0301',assetName:'大理石地砖',proprietor:'周星驰',proprietorPh:'13567439063',condition:'已受理',source:'入伙',questionDescribe:'Just so so'},
            {borderId:4,address:'4栋单元104客厅',specialty:'强电',area:'B区',assetNumber:'0401',assetName:'实木地板',proprietor:'橙沙之味',proprietorPh:'13567439064',condition:'处理完毕',source:'验房',questionDescribe:'Just so so'}
        ];

        //数据筛选
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.borderItem.length;i++){
                if($scope.borderItem[i].borderId==$scope.n ||
                    $scope.borderItem[i].specialty==$scope.specialty ||
                    $scope.borderItem[i].source==$scope.source||
                    $scope.borderItem[i].condition==$scope.condition||
                    $scope.borderItem[i].assetName==$scope.assetName){
                    $scope.itemsone.push($scope.borderItem[i]);
                }
            }
        };

       //定义一个变量来接收数据来源
        var url=$scope.itemsone;

        $scope.list=function(){
            $http.get(url).success(function(resJson){
                $scope.itemsone = resJson;

                angular.forEach($scope.itemsone, function(item) {
                    item.checked=false;
                });
            });
        };

        $scope.toUpdate = function(index) {
            //获得当前修改行的索引
            $scope.itemIndex=index;
            //获取页面数据到文本框中
            $scope.item=tyjUtil.jsonClone($scope.itemsone[index]);
        };
        $scope.save=function(){
            //判断是添加还是修改
            if(null!=$scope.itemIndex){
                //修改
                $scope.itemsone[$scope.itemIndex]=tyjUtil.jsonClone($scope.item);
            }else{
                //添加
                $scope.borderItem.push($scope.item);
            }
        };

    });
});

//
//
////define(['tyjApp'],
////    function(module){
//        module.controller("customerServiceCtrl",function($scope,$http,$rootScope){
//        	 var url=$rootScope.url;
//             $scope.AfterSale={page:{}};
//             $scope.addAfterSale={};
//             var fetchFunction = function(page,callback) {
//         		$scope.AfterSale.page=page;
//                 $http.post(url + '/AfterSale/listPageAfterSaleRestful',{AfterSale:$scope.AfterSale}).success(callback);
//             };
//
//             $scope.searchPaginator=Paginator(fetchFunction,2);
//
//
//             $scope.view=function(id)
//             {
//             	$http.get(url+'/AfterSale/getAfterSaleByIdRestful/'+id).success(function(data)
//             	{
//             		$scope.afterSale=data.AfterSale;
//                 });
//             };
//        });
////});

          
       
  