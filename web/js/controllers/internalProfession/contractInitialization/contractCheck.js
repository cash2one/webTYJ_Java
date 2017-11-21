/**
 * Created by 彭婷婷 on 2015/4/17.
 *合同初始化--合同查询
 * 修改人：王志刚、
 * 最后修改时间：2015/6/8
 *
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("contractCheckCtrl",function($scope){
        $scope.contractItem=[
            {contractId:1,handlePerson:'黎明',houseNum:'1009527',ower:'黎明',houseAddress:'桃源居1期3区1栋7单元501',handlePeople:'张三',handleDate:'2015/5/4',shouFang:'已收房',inspectorNum:'98762',repairNum:'34567'},
            {contractId:2,handlePerson:'张思思',houseNum:'1003527',ower:'张思思',houseAddress:'桃源居1期2区1栋6单元211',handlePeople:'王晓丽',handleDate:'2015/4/4',shouFang:'已收房',inspectorNum:'91765',repairNum:'123212'},
            {contractId:3,handlePerson:'李丽丽',houseNum:'1004527',ower:'李丽丽',houseAddress:'桃源居1期1区2栋4单元403',handlePeople:'张晓东',handleDate:'2015/1/4',shouFang:'已收房',inspectorNum:'92765',repairNum:'56754'},
            {contractId:4,handlePerson:'王晓丽',houseNum:'1005527',ower:'王晓丽',houseAddress:'桃源居1期2区1栋3单元804',handlePeople:'小夏',handleDate:'2015/3/4',shouFang:'已收房',inspectorNum:'98465',repairNum:'567933'}
        ];
    });
});