/**
 * Created by LM on 2015/3/11.
 * 企业信息跳转指令
 */
'use strict';

define(['tyjApp',
    'controllers/externalProfession/institution',
    'controllers/internalProfession/enterpriseNews',
    'controllers/externalProfession/communityAnnouncement',
    'controllers/externalProfession/internalAnnouncement'
    ],function(module){

    module.controller("entCtrl",function($scope,$http,$rootScope){
    	$scope.tip="项目信息";
        $scope.projects={};
	    var url = $rootScope.url;
		$http.get(url + '/Project/listAllProject').success(function(data) {
			console.log(data);
	        $scope.Project = data.Project;
	        $scope.item = data.Project[0];
            console.log($scope.item);
		});
		
	  $scope.tip="内部公告";
         $scope.Informs={};
 		$http.get(url + '/Inform/listAllinform').success(function(data) {
 			console.log(data);
 	        $scope.Informs = data.Inform;
            
 		});

    	$scope.tip="企业新闻";
        $scope.corporatenewss={};
    	$http.get(url + '/Corporatenews/listAllCorporatenews').success(function(data) {
    		console.log(data);
    		$scope.Corporatenews = data.Corporatenews;
            $scope.item = data.Corporatenews[0];
            console.log($scope.item);
    	});
    	$scope.tip="规章制度";
        $scope.ruless={};
    	$http.get(url + '/Rules/listAllRules').success(function(data) {
    		console.log(data);
    		$scope.Rules = data.Rules;
            $scope.item = data.Rules[0];
            console.log($scope.item);
    	});
   
    	$scope.tip="小区公告";
        $scope.communtitnotices={};
    	$http.get(url + '/Communtitnotice/listAllCommuntitnotice').success(function(data) {
    		console.log(data);
    		
    		$scope.Communtitnotice = data.Communtitnotice;
            $scope.item = data.Communtitnotice[0];
            console.log($scope.item);
    	  });
    });
    });
    
