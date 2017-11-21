/**
 * Created by 陶勇超 on 2015/6/1.
 * 部门质检服务请求详情
 * 页面数据通过JS传输
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("departmentServiceRequestForDetailsCtrl",function($scope){
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
        $scope.teams=[
            {quality:'园林部',ranks1:'一组',name1:'张三',name2:'李四',ranks2:'二组',name3:'张三',name4:'李四'},
            {quality:'安保',ranks1:'一组',name1:'张一',name2:'李四',ranks2:'二组',name3:'张三',name4:'李四'},
            {quality:'清洁',ranks1:'一组',name1:'张二',name2:'李四',ranks2:'二组',name3:'张三',name4:'李四'},
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