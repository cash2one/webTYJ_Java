/**
 * Created by Administrator on 2015/5/29. 
 * author:王志刚 尹磊
 * jsName:物业服务人员主页---停车卡历史记录查询js
 * 修改时间：2015/6/1  修改人：尹磊
 */
define(['tyjApp'],function(module){
        module.controller("historyRecordCtrl", function($scope,$http,$rootScope) {
            $scope.tip="停车卡";
            $scope.Caraccesscards={};
            //停车卡信息初始化
            $scope.addCaraccesscard={};
            // 新增停车卡初始化
            $scope.caraccesscards1={};
            //客户持有停车卡信息初始化
            $scope.payCost={};
            //缴费信息初始化
            $scope.newcardId="";
            //新卡号初始化
//            var personId= 7;
            var url = $rootScope.url;
            //根据客户id查询停车卡历史记录
          /*  $http.get(url + '/Caraccesscard/listCaraccesscardByCustId/'+7).success(function(data) {
                console.log(data);
                $scope.caraccesscards = data.Caraccesscard;
            });*/
            
            $http.get(url + '/Caraccesscard/getCaraccesscardbyId/'+1).success(function(data) {
                console.log(data);
                $scope.caraccesscards1 = data.Caraccesscard;
                console.log($scope.caraccesscards1);
                $scope.caraccesscards1.startDate=$scope.caraccesscards1.startDate.substring(0, 10);
                $scope.caraccesscards1.endDate=$scope.caraccesscards1.endDate.substring(0, 10);
            });
           
            //根据停车卡id查询车辆卡信息
            $scope.getCaraccesscardbycardId=function(cardId){
                console.log($scope.Caraccesscard);
                $http.get(url + '/Caraccesscard/getCaraccesscardbyId/'+1).success(function(data) {
                    console.log(data);
                    $scope.caraccesscards1 = data.Caraccesscard;
                    console.log($scope.caraccesscards1);
                    $scope.caraccesscards1.startDate=$scope.caraccesscards1.startDate.substring(0, 10);
                    $scope.caraccesscards1.endDate=$scope.caraccesscards1.endDate.substring(0, 10);
                });
            };
            //更换停车卡
            $scope.updateCaraccessBycardId=function(){
                console.log($scope.newcardId); 
                $scope.caraccesscards1.newcardId= $scope.newcardId;
                console.log($scope.caraccesscards1.newcardId); 
                $http.put(url + '/Caraccesscard/updateCaraccessBycardId',{Caraccesscard:$scope.caraccesscards1}).success(function(data) {     
                		alert("更换成功");
                    }).error(function(data, status, headers, config){
        	            alert("更换失败");
        	        }) ;
                $http.get(url + '/Caraccesscard/listCaraccesscardByCustId/'+7).success(function(data) {
                    console.log(data);
                    $scope.caraccesscards = data.Caraccesscard;
                });
            };
            
            //停车卡挂失
            $scope.LossCaraccesscardById=function(){    
            	//卡状态修改为挂失
                $http.put(url + '/Caraccesscard/LossCaraccessBycardId/'+$scope.caraccesscards1.cardId).success(function(data) {                    		
                    }).error(function(data, status, headers, config){
        	            alert("挂失失败");
        	        }) ;
                $scope.payCost.paymentType="挂失";
                $scope.payCost.cardId=$scope.caraccesscards1.cardId; // 将停车卡id赋值给费用表的cardId
                $http.post(url + '/PayCost/AddPayCost',{PayCost:$scope.payCost}).success(function(data) {     
            		alert("挂失成功");
                }).error(function(data, status, headers, config){
    	            alert("挂失失败");
    	        }) ;
                //刷新页面
                $http.get(url + '/Caraccesscard/listCaraccesscardByCustId/'+7).success(function(data) {
                    console.log(data);
                    $scope.caraccesscards = data.Caraccesscard;
                });
            };
            
            //停车卡退卡
            $scope.RefundCaraccessBycardId=function(){           
            	//卡状态修改为禁用
                $http.put(url + '/Caraccesscard/RefundCaraccessBycardId/'+$scope.caraccesscards1.cardId).success(function(data) {                    		
                    }).error(function(data, status, headers, config){
        	            alert("退卡失败");
        	        }) ;
                $scope.payCost.paymentType="退卡";
                $scope.payCost.cardId=$scope.caraccesscards1.cardId;// 将停车卡id赋值给费用表的cardId
                $http.post(url + '/PayCost/AddPayCost',{PayCost:$scope.payCost}).success(function(data) {     
            		alert("退卡成功");
                }).error(function(data, status, headers, config){
    	            alert("退卡失败");
    	        }) ;
                //页面刷新
                $http.get(url + '/Caraccesscard/listCaraccesscardByCustId/'+7).success(function(data) {
                    console.log(data);
                    $scope.caraccesscards = data.Caraccesscard;
                });
            };
            
            //停车卡缴费
            $scope.PayCaraccessBycardId=function(){
            	 $scope.payCost.paymentType="缴费";
            	 $scope.payCost.cardId=$scope.caraccesscards1.cardId; // 将停车卡id赋值给费用表的cardId
            	$http.post(url + '/PayCost/AddPayCost',{PayCost:$scope.payCost}).success(function(data) {     
            		alert("缴费成功");
                }).error(function(data, status, headers, config){
    	            alert("缴费失败");
    	        }) ;
            	$http.get(url + '/Caraccesscard/listCaraccesscardByCustId/'+7).success(function(data) {
                    console.log(data);
                    $scope.caraccesscards = data.Caraccesscard;
                });
            };
            
        });
});