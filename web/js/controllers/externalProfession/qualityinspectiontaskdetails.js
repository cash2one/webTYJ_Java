/**
 * Created by daniel on 2015/5/22.
 *修改人：陶勇超
 * 修改日期：2015/5/29
 * 修改内容：页面数据通过JS传送过来
 * 修改时间：2015/6/4
 * 修改内容：
 */

'use strict';

define(['tyjApp'],function(module){
    module.controller("qualityinspectiontaskdetailsCtrl",function($scope,$http,Paginator,$rootScope){

        var url = $rootScope.url;           //定义当前的路径
        //获取传来的值
        $scope.taskdetails1={
            name:'',
            describe:'',
            activity:''
        };
        //显示当前模板上面DIV信息
        $scope.tableDiv=[];
        //显示当前模板的详细信息
        $scope.tables=[];
        $scope.TemplateDetails={page:{}};     //页面信息
        //通过数据库获取当前页面的数据信息
        var fetchFunction = function(page,callback) {
            $scope.TemplateDetails.page=page;
            //数据库接口
            $http.post(url + '',{TemplateDetails:$scope.TemplateDetails}).success(callback);
        };

        $scope.test='111123';
        $scope.taskdetails={
            name:'园林质检任务',
            describe:'桃源居项目是很强大的',
            activity:'园林质检任务90'
        };
        $scope.items=[
            {date:'2015-5-20',activity:'园林质检任务',name:'园林质检任务090'},
            {date:'2015-5-20',activity:'园林质检任务',name:'园林质检任务090'}
        ]
    });
});