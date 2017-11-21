/**
 * 创建人：陶勇超
 * 创建时间：2015/5/28
 * 页面名称：外部专业线的工单详情
 *html路径：'controllers/externalProfession/workingSingleDetail',
 * 修改时间：2015/6/4
 */
'use strict';

define(['tyjApp'],function(module){

    module.controller("workingSingleDetailCtrl",function($scope,$http,Paginator,$rootScope){

        var url = $rootScope.url;           //定义当前的路径
        //获取传来的值
        $scope.workingSingle1={
            name:'',
            relatedTask:'',
            object:'',
            describe:'',
            tableName:''
        };
        //显示当前模板上面DIV信息
        $scope.tableDiv=[];
        //显示当前模板的详细信息
        $scope.tables=[];
        $scope.workingSingleDetail={page:{}};     //页面信息
        //通过数据库获取当前页面的数据信息
        var fetchFunction = function(page,callback) {
            $scope.workingSingleDetail.page=page;
            //数据库接口
            $http.post(url + '',{workingSingleDetail:$scope.workingSingleDetail}).success(callback);
        };

        $scope.workingSingle={
            name:'园林质检活动090',
            relatedTask:'园林质检任务09',
            object:'园林部',
            describe:'描述保护园林人人有责',
            tableName:'园林部质检表-2015-04-06'
        };


        $scope.tableHead1={
            date1:'04-01',
            date2:'04-02',
            date3:'04-03',
            date4:'04-04',
            date5:'04-05'
        };

        $scope.items=[
            {departmentName:'园林',name:'张章',score1:'75',score2:'45',score3:'75',score4:'75',score5:'75'},
            {departmentName:'园林',name:'李四',score1:'78',score2:'95',score3:'35',score4:'85',score5:'85'},
            {departmentName:'园林',name:'张三',score1:'85',score2:'75',score3:'95',score4:'65',score5:'35'}
        ];



    });
});