/**
 * 页面名称：【专业资产初始化】新增专业
 * 页面路径：page/internalProfession/majorAssetInitialization/newProfessional.html
 * 前端负责人：刘洋
 * 后端负责人：
 * 创建时间：2015/5/6.
 * 修改日期：
 */
'use strict';
define([], function () {
    var tyjUtil={};
    /**
     * JSON克隆
     * @param jsonObject 传递要克隆的json对象
     * @param targetJson 可以是对象也可以是字符串
     * @returns tyjUtil
     */
    tyjUtil.jsonClone=function(jsonObject,targetJson){
        if(typeof jsonObject =='object'){
            var cloneItem=targetJson?targetJson:{};
            for(var key in jsonObject){
                cloneItem[key]=jsonObject[key];
                console.log(key+"---"+jsonObject[key]);
            }
            return cloneItem;
        }
        else{
            return jsonObject;
        }
    };
    return tyjUtil;
});
