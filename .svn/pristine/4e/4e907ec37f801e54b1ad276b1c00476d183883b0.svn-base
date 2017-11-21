/**
 * Created by LM on 2015/3/11.
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("loginCtrl",function($scope,$http,$cookieStore,$rootScope){
        //登录时触发登录模态框
       // $('#login').modal('toggle');
    	var url=$rootScope.url;
    	$scope.login=function(){
    		$http.post(url+'/AppUser/login',{AppUser:$scope.AppUser}).success(function(data) {
        		if(data!='')
        		{
        			$cookieStore.put("AppUser",data.AppUser);
        			$('#login').modal('hide');  //关闭模态框
        			alert("登录成功！");
        		}else
        		{
        			alert("用户名或密码错误！");
        		}
    	    }).error(function(data, status, headers, config){
    	    	alert("登录错误！");
            }) ;
    	};
    });
});