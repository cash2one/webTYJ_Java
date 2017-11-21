/**
 * Created by daniel on 2015/4/30.
 */


'use strict';

define(['tyjApp',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/balanceordertolerance',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/checkordertolerance',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/handleordertolerance',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/journal',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/ordertolerance',
    'controllers/internalProfession/ServiceRequest/ServiceCheck/quoteordertolerance'
],function(module){
    module.controller("ServiceCheckCtrl",function($scope){
        $scope.test='111';
    });
});
