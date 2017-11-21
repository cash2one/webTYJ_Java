/**
 * Created by 倪明 on 2015/5/29.
 * 外部专业线-新增重大事项
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("majorMatterAddCtrl",function($scope){
        $scope.click_a=function(divDisplay){
            if(document.getElementById(divDisplay).style.display != "block") {
                document.getElementById(divDisplay).style.display = "block";
            }
            else {
                document.getElementById(divDisplay).style.display = "none";
            }
        };

        $scope.newMajorMatter=[];            //新增重大事项信息
        $scope.newMajorMatterTow=[];         //新增重大事项中新增工单信息


        $scope.newMajorMatterTow=function(){
            //显示新增重大事项
            $scope.showNewMjorMatter=true;
            $scope.showNewMjorMatterTow=false

        };
        $scope.newMajorMatterTow=function(){
            //显示新增重大事项中工单
            $scope.showNewMjorMatter=true;
            $scope.showNewMjorMatterTow=true

        };
        //新增重大事项数据提交
        $scope.save=function(){
            //提交新重大事项
            var url="";                         //url
            var args=$scope.newMajorMatter;     //参数

            $post(url,args)
                .success(function(data){
                    if(data&&data.status==="success"){
                        $scope.newMajorMatter={
                            id:'',
                            time:'',
                            status:'',
                            requestType:'',
                            serviceSource:''
                        };
                    }
                    else{
                        alert("保存失败，原因："+data.message);
                    }
                }
                    .error(function(err){
                        alert("保存失败，无法连接服务器")
                    }
                )
            );
        };

    });
});