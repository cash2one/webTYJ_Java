/**
 * Created by cg on 2015/5/29.修改时间：2015/5/29
 * 修改人：陶勇超
 * 修改内容：页面数据通过js传输
 *修改时间：2015/6/5
 * 修改内容：数据从数据库中获取
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("qualityActivityDetailsCtrl",function($scope,$http,Paginator,$rootScope){
        var url = $rootScope.url;           //定义当前的路径
       //获取传来的值
        $scope.qualityActivity1={
            level:'',
            cycle:'',
            name:'',
            describe:'',
            illustrate:''
        };
        $scope.items1={
            date:'',
            activity:'',
            name:''
        };
        //显示当前模板上面DIV信息
        $scope.tableDiv=[];
        //获取显示当前模板的详细信息
        $scope.tables={};
        $scope.qualityActivityDetails={page:{}};     //页面信息
        $http.get(url + '').success(function(data) {
            console.log(data);
            $scope.qualityActivity1 = data.qualityActivity1;
            $scope.item = data.qualityActivity1[0];
            console.log($scope.item);
        });
         //定义一个变量来接收数据来源
        var qualityActivity=$scope.qualityActivity;

        //更换
        $scope.renewal = function(index) {
            //获得当前修改行的索引
            $scope.currentIndex=index;
            //获取页面数据到文本框中
            //$scope.vm=tyjUtil.jsonClone($scope.vms[index]);
            //清空文本框中的数据
            $scope.vm={};
        };
        //保存
        $scope.save=function(){
            $scope.qualityActivity[$scope.currentIndex]=tyjUtil.jsonClone($scope.vm);
        };
        //分页
        //var fetchFunction = function(page,callback) {
        //    $scope.qualityActivityDetails.page=page;
        //    //数据库接口
        //    $http.post(url + '',{qualityActivityDetails:$scope.qualityActivityDetails}).success(callback);
        //};
        $scope.test='123';
        $scope.qualityActivity={
            level:'部门质检',
            cycle:'日检',
            name:'园林部',
            describe:'描述描述描述描述描述描述描述描述描述',
            illustrate:'每周一、周三、周五生产任务'
        };
        $scope.items=[
            {date:'2015-5-29',activity:'园林质检任务',name:'园林质检任务'},
            {date:'2015-5-20',activity:'园林质检任务',name:'园林质检任务'}
        ];
           //树形循环
        $scope.teams=[
            {quality:'园林部',ranks1:'一组',name1:'张三',name2:'李6',ranks2:'二组',name3:'张吧',name4:'李我'},
            {quality:'安保',ranks1:'一组',name1:'张一',name2:'李四',ranks2:'二组',name3:'张是',name4:'李他四'},
            {quality:'清洁',ranks1:'一组',name1:'张二',name2:'李牛',ranks2:'二组',name3:'张没',name4:'李额'},
        ];

        function addEvent(el,name,fn){
            if(el.addEventListener) return el.addEventListener(name,fn,false);
            return el.attachEvent('on'+name,fn);
        }
        function nextnode(node){
            if(!node)return ;
            if(node.nodeType == 1)
                return node;
            if(node.nextSibling)
                return nextnode(node.nextSibling);
        }
//树形JS
        addEvent(document.getElementById('root'),'click',function(e){
            e = e||window.event;
            var target = e.target||e.srcElement;
            var tp = nextnode(target.parentNode.nextSibling);
            switch(target.nodeName){
                case 'A':
                    if(tp&&tp.nodeName == 'UL'){
                        if(tp.style.display != 'block' ){
                            tp.style.display = 'block';
                            (target.parentNode.previousSibling).className = 'ren'
                        }else{
                            tp.style.display = 'none';
                            (target.parentNode.previousSibling).className = 'add'
                        }
                    }
                    break;
            }
        });


    });
});
