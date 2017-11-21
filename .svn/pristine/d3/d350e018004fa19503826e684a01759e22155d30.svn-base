/**
 * Created by LM on 2015/3/11
 * 登录验证页面
 */
'use strict';

define(['tyjApp'],function(module){
    module.controller("accountCtrl", ['$scope', '$http', 'UserService', function(scope, $http, User){
        scope.login = function() {
            var config = { /* ... */ }; // configuration object

            $http(config)
                .success(function(data, status, headers, config) {
                    if (data.status) {
                        // succefull login
                        User.isLogged = true;
                        User.username = data.username;
                    }
                    else {
                        User.isLogged = false;
                        User.username = '';
                    }
                })
                .error(function(data, status, headers, config) {
                    User.isLogged = false;
                    User.username = '';
                });
        }
    }]);
});