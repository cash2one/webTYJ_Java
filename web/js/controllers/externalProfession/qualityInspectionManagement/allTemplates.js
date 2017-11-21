/**
 * 创建人：李斌
 * 日期：2015/5/24
 * 名称：外部专业线-全部检模版JS
 */

'use strict';

define(['tyjApp',
    'controllers/externalProfession/qualityInspectionManagement/allTemplates/dayTemplates',
    'controllers/externalProfession/qualityInspectionManagement/allTemplates/weekTemplates',
    'controllers/externalProfession/qualityInspectionManagement/allTemplates/biWeekTemplates',
    'controllers/externalProfession/qualityInspectionManagement/allTemplates/monthTemplates',

],function(module){
    module.controller("allTemplatesCtrl",function($scope){
        $scope.test='111222';
    });
});