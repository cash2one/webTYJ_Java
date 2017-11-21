/**
 * Created by daniel on 2015/5/7.
 */

'use strict';
define(['tyjApp',
    'controllers/externalProfession/compensation/compensationCheck/balanceorder',
    'controllers/externalProfession/compensation/compensationCheck/checkorder',
    'controllers/externalProfession/compensation/compensationCheck/log',
    'controllers/externalProfession/compensation/compensationCheck/manageorder',
    'controllers/externalProfession/compensation/compensationCheck/offerorder',
    'controllers/externalProfession/compensation/compensationCheck/order'
],function(module){
    module.controller("compensationCheckCtrl",function($scope){
        $scope.test='123';
    });
});