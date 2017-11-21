/**
 * 创建人：李斌
 * 日期：2015/5/6
 * 名称：外部专业线-抄表管理JS
 * 修改时间：2015/5/29
 * 修改人：李斌
 */
'use strict';

define(['../../tyjApp',
        'controllers/externalProfession/meterReadingManagement/newActivities',
        'controllers/externalProfession/meterReadingManagement/history01',
        'controllers/externalProfession/meterReadingManagement/meterReading01',
        'controllers/externalProfession/meterReadingManagement/meterReading03',
        'controllers/externalProfession/meterReadingManagement/detailedInformation',
    ],
    function(module){
        module.controller("meterReadingManagementCtrl",function($scope){
            $scope.test='111123';
        });
    });