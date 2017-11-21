/**
 * Created by daniel on 2015/4/17.
 */
'use strict';

define(['tyjApp',],function(module){
    module.controller("faqCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	  $scope.Faq={page:{}};
      	var fetchFunction = function(page,callback) {
    		$scope.Faq.page=page;
            $http.post(url + '/Faq/listPageFAQ', {Faq:$scope.Faq}).success(callback);  
        };  
        $scope.searchPaginator = Paginator(fetchFunction,10);
    });
});
