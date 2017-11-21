/**
 * Created by Administrator on 2015/4/10.
 * 人员信息跳转指令
 */

'use strict';
define(['tyjApp',
    'controllers/propertyService/staffHome/commonUser',
    'controllers/propertyService/staffHome/serviceRequest',
    'controllers/propertyService/staffHome/newServiceRequest',
    'controllers/propertyService/staffHome/entranceGuard',
    'controllers/propertyService/staffHome/lease',
    'controllers/propertyService/staffHome/parkingCard',
    'controllers/propertyService/staffHome/petRegistration',
    'controllers/propertyService/staffHome/empowerManagement',
    'controllers/propertyService/staffHome/parkingManagement',
    'controllers/propertyService/staffHome/vehicleManagement',
    'controllers/propertyService/staffHome/decorate',
    'controllers/propertyService/staffHome/joinGang',
    'controllers/propertyService/staffHome/changeTitle',
    'controllers/propertyService/staffHome/releasePass'
    ],function(module){
    module.controller("staffCtrl",function($scope,$http,$rootScope){
        $scope.personCust={
            name:'周润发', custCode:'V009',
            owner:'单业主',propertyCosts:'1000元',
            parkingCard:'缴费200元', parking:'正常',
            age:'50岁',sex:'男',
            relationship:'3人',IDCard:'420100199012011121',
            telephone:'13856888788'
        };

        //鼠标点击选中
        $scope.doClick=function(index){
            $scope.btnIndex=index;
        };
    	/* $scope.personCusts={};
 	    var url = $rootScope.url;
 	   
 		$http.get(url + '/PersonCust/listAllPersonCustRestful/').success(function(data) {
 			console.log(data);
 	        $scope.PersonCust = data.PersonCust;
 	        //$scope.item = data.PersonCust[0];
             console.log($scope.item);
 		});*/
    	//$scope.personCust=$rootScope.personCust;//从rootScope中获取用户信息
    });
});
