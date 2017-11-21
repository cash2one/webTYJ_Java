/**
 * 对应页面：新增企业放行条——物业服务人员主页【addCompanyPass.html】
 * 页面路径：page/propertyService/staffHome/newServiceRequest.html
 * 前端负责人：刘洋
 * 创建时间：2015/4/13.
 * 后端负责人：
 * 修改时间：2015/6/1
 */
'use strict';
define(['tyjApp','pageServices'], function(module){
    module.controller("serviceCtrl",function($scope,$http,$rootScope){


        //请求访问地址
        var url = $rootScope.url;
        //定义一个服务请求对象
        $scope.reqService={};
        /**
         *根据客户ID查询服务请求信息
         */
        $scope.searchReqService=function(){
            $get(url).success(function(data){
                if(data){
                    $scope.reqService=data;
                }else{
                    alert("暂无数据！");
                }
            }).error(function(data){
                alert("服务器请求失败！");
            });
        };


        ////请求访问地址
        //var url = $rootScope.url;
        ///**
        // * 查询工单要传递的参数
        // * @type {{page: {}}}
        // */
        //$scope.reqService = {
        //    page : {}
        //};
        ///**
        // * 根据客户编号查询客户请求信息
        // * @param page
        // * @param callback
        // */
        //var fetchFunction = function(page,callback) {
        //    $scope.Order.page=page;
        //    $http.post(url,$scope.reqService.id).success(callback);
        //};
        ////查询分页
        //$scope.searchReqService=function(){
        //    $scope.searchPaginator=Paginator(fetchFunction,1);
        //};
        //
        ///**
        // * 服务请求数据来源
        // * @type {{reqId: string, reqDate: string, reqType: string, serviceType: string, customerName: string}[]}
        // */
        //$scope.vms=[{reqId:'1-1458866852',reqDate:'2015-4-4',reqType:'清洁',serviceType:'前台',customerName:'周润发'},
        //    {reqId:'1-1458866853',reqDate:'2015-4-5',reqType:'园林',serviceType:'前台',customerName:'周润发'},
        //    {reqId:'1-1458866851',reqDate:'2015-4-6',reqType:'维修',serviceType:'前台',customerName:'周润发'}];


    });
});