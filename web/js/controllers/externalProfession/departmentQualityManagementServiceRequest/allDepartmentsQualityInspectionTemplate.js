/**
 * Created by 陶勇超 on 2015/6/1.
 * 全部质检模板
 */
'use strict';

define(['tyjApp',
    'controllers/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/dayTemplates',
    'controllers/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/weekTemplates',
    'controllers/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/biWeekTemplates',
    'controllers/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/monthTemplates',

],function(module){
    module.controller("allDepartmentsQualityInspectionTemplateCtrl",function($scope){
        $scope.test='111222';
    });
});