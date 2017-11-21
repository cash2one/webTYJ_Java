/**
 * Created by 彭婷婷 on 2015/5/7.
 * 外部专业线--维修bom
 */

'use strict';

define(['tyjApp'],function(module){
    module.controller("repairBomCtrl",function($scope){
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
