/**
 * Created by 倪明 on 2015/6/5.
 * 规章制度
 */
'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("institutionCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	  $scope.Rules={page:{}};
      	var fetchFunction = function(page,callback) {
    		$scope.Rules.page=page;
            $http.post(url + '/Rules/listPageRules', {Rules:$scope.Rules}).success(callback);  
        };  
        $scope.searchPaginator = Paginator(fetchFunction,10);
    });
});

