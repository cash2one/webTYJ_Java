/**
 * Created by 陶勇超 on 2015/5/27.
 * 模板详情
 *
 * 修改时间：2015/6/2
 * 修改人：陶勇超
 * 修改内容：页面数据通过JS传输
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("templateDetailsCtrl",function($scope,$http,Paginator,$rootScope){
        var url = $rootScope.url;           //定义当前的路径
        //获取传来的值
        $scope.template1={
            name:'',
            weeks:'',
            describe:'',
            classify:'',
            post:''
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



        $scope.template={
            name:'园林部门质检模板-地面',
            weeks:'日检',
            describe:'描述描述模板模板',
            classify:'园林',
            post:'清洁'
        };
        $scope.thead={
            title1:'序号',
            title2:'',
            title3:'评分项',
            title4:'权重',
            title5:'评分',
            title6:'描述',
            title7:'评分标准',
            title8:'权重'
        };
        $scope.item= {td1:'1',td2:'地面',td3:'水渍',td4:'30%',td5:'1',td6:'非常不满意/差',td7:'地面有杂物',td8:'30%'};
        $scope.item1={
            td1:'2',
            td2:'不满意/差',
            td3:'地面有灰尘'
        };
        $scope.item2={
            td1:'3',
            td2:'满意',
            td3:'很干净'
        };
        $scope.item3={
            td1:'4',
            td2:'非常满意',
            td3:'没有灰尘'
        };
        $scope.item4={
            td1:'5',
            td2:'特别满意',
            td3:'地面亮的反光'
        };
        $scope.item5={
            td4:'杂物',
            td5:'70%',
            td1:'1',
            td2:'不满意/差',
            td3:'地面有灰尘'
        };
        $scope.item6={
            td1:'2',
            td2:'不满意/差',
            td3:'地面有杂物'
        };
        $scope.item7={
            td1:'3',
            td2:'满意',
            td3:'很干净'
        };
        $scope.item8={
            td1:'4',
            td2:'非常满意',
            td3:'地面没有灰尘'
        };
        $scope.item9={
            td1:'5',
            td2:'特别满意',
            td3:'地面亮的反光'
        }
    });
});