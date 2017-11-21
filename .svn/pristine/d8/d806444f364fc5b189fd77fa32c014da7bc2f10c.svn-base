/**
 * Created by Administrator on 2015/5/19.
 */

'use strict';
define(['tyjApp','pageServices'],function(module,tyjUtil){
    module.controller("checkEntranceGuardCtrl",function($scope,$http,Paginator,$rootScope){/*
        $scope.vms=[
            {id:'987654',startDate:'2015/5/15',endDate:'2015/9/15',name:'范冰冰',status:'正常',time:'2015/5/15'},
            {id:'987655',startDate:'2015/5/15',endDate:'2015/8/15',name:'章程',status:'正常',time:'2015/5/15'},
            {id:'987656',startDate:'2015/5/15',endDate:'2015/10/15',name:'李成',status:'正常',time:'2015/5/15'},
            {id:'987657',startDate:'2015/5/5',endDate:'2015/8/5',name:'张三',status:'正常',time:'2015/5/5'},
            {id:'987658',startDate:'2015/5/15',endDate:'2015/10/15',name:'王晓晓',status:'正常',time:'2015/5/15'},
            {id:'987659',startDate:'2015/6/15',endDate:'2015/11/15',name:'张芬芬',status:'正常',time:'2015/6/15'}
        ];
        //定义一个变量来接收数据来源
        var url=$scope.vms;

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
            $scope.vms[$scope.currentIndex]=tyjUtil.jsonClone($scope.vm);
        };
    */
    	
    	
    	//通过条件查询门禁卡信息
       var url = $rootScope.url;	
       $scope.search={};
    	 	
       $scope.search.custId=1;
       $http.post(url+'/Entrance/listAllEntranceBySearch',{Search:$scope.search}).success(function(data)
    	 {
    	   console.log("搜索门禁卡成功");
    	   $scope.entrances=data.Entrance;
    	   console.log("根据条件查到的门禁卡信息");
    	   console.log($scope.entrances);
    	    			   
    	 }).error(function(data, status, headers, config){
    	   console.log("门禁卡查询失败");
    	 }) ;	    
        
         //选择门禁卡
         $scope.entranceone={};
         $scope.choiceEntrance=function(entrance){
        	 console.log("选择门禁卡");
        	 $scope.entranceone = entrance;
        	 console.log($scope.entranceone);
         };
         
         //更换门禁卡 newCarNum为新卡的卡号
         $scope.newCardNum=0;
         $scope.changeEntrance=function(){
        	 console.log("跟换门禁卡信息");
        	 if($scope.entranceone.cardState!=3){
        		 $http.get(url+'/Entrance/getEntrance/'+$scope.entranceone.cardId).success(function(data)
       	    			{
             		      console.log("门禁卡获取成功");
             		      $scope.changeEntranceone=data.Entrance;
             		      $scope.changeEntranceone.newCardNum=$scope.newCardNum;
             		      console.log( $scope.changeEntranceone);
             		      console.log( $scope.changeEntranceone.newCardNum);
             		      $http.put(url+'/Entrance/updateEntranceByIdRest', {Entrance:$scope.changeEntranceone}).success(function(data)
           	    			{
             		    	  
           	    			   console.log("更换门禁卡成功");	    			   	    	 
           			         }).error(function(data, status, headers, config){
           			            console.log("门禁卡更换失败");
           			        }) ;
       	    			  	    			   	    	 
       			         }).error(function(data, status, headers, config){
       			            console.log("门禁卡获取失败");
       			        }) ;
        	 }
        	 else
        		 alert("门禁卡已被禁用，无法更换");
        	 
        	 
         };
         
         //门禁卡退费
         $scope.returnEntrance=function(){
        	 console.log($scope.entranceone.cardId);
        	 if($scope.entranceone.cardState!=3){
        	 $http.put(url+'/Entrance/updateEntranceByIdAndReturn/'+$scope.entranceone.cardId).success(function()
  	    			{
  	    			   console.log("更换门禁卡成功");	    			   	    	 
  			         }).error(function(data, status, headers, config){
  			            console.log("门禁卡更换失败");
  			        }) ;
         }
        	 else
        		 alert("门禁卡已被禁用，无法退费");
         };
         
         //门禁卡挂失
         $scope.loseeEntrance=function(){
        	 console.log($scope.entranceone.cardId);
        	 alert($scope.entranceone.cardId);
        	 if($scope.entranceone.cardState!=3){
        	 $http.put(url+'/Entrance/updateEntranceByIdAndLost/'+$scope.entranceone.cardId).success(function()
   	    			{
   	    			   console.log("挂失门禁卡成功");	    			   	    	 
   			         }).error(function(data, status, headers, config){
   			            console.log("挂失门禁卡失败");
   			        }) ; 
        	 }
        	 else
        		 alert("门禁卡已被禁用，无法挂失");
         };
    });
});