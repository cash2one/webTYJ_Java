/**
 * Created by 倪明 on 2015/5/29.
 * 重大事项查看
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("majorMatterCheckCtrl",function($scope){
        //重大事项历史信息
        $scope.historyItem={
            id:'',
            serveType:'',
            classify:'',
            specialty:'',
            houseId:'',
            ownerName:'',
            area:'',
            unit:'',
            storey:'',
            house:'',
            priority:'',
            importance:'',
            describe:'',
            workId:'',
            importantMatters:'',
            requestType:'',
            classifyTow:'',
            specialtyTow:'',
            principalId:'',
            principal:''
        };
        $scope.historyShow=false;            //是否显示重大事项
        $scope.historyItem=[];               //重大事项历史信息
        $scope.historyItemTip="";            //重大事项历史信息提示

        //显示重大事项具体信息
        $scope.historyItem=function(){
            $scope.historyShow=true;
            var url="";                      //url
            var args={id:'取出ID'};            //参数
            $get(url,args)
                .success(function(data){
                    if(data&&data.status==="success"){
                        $scope.historyItem=data;
                    }
                    else{
                        $scope.historyItem=[];
                        $scope.historyItemTip="暂无信息"
                    }
                }
                    .error(function(err){
                        $scope.historyItem=[];
                        $scope.historyItemTip="无法连接服务器";
                    })
            )
        };
        //关闭重大事项
        $scope.historyShow=function(){
            $scope.historyShow=false;
        }
    });
});