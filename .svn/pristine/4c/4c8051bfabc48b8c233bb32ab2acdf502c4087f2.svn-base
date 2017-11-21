
/**
 * 创建时间：2015/5/19
 * author:彭婷婷
 * 修改人：钟加诚
 * 修改内容：添加宠物数据，查询和筛选数据，页面与模态框中数据传输
 * 最后修改时间：2015/6/1
 * jsName:外部专业线小区宠物
 */

'use strict';
define(['tyjApp'],function(module){
    module.controller("allPetsCtrl",function($scope){
        //输入框input
        $scope.b=0;//n的初始值赋值为0
        $scope.petK='';
        $scope.petN='';
        $scope.petT='';
        $scope.registerP='';
        $scope.petTy='';
        //小区宠物数据
        $scope.petItem=[
            {petId:1,petName:'旺旺',petKind:'牧羊犬',desc:'活泼好动',petType:'狗',petTy:'1',petSex:'公',registerDate:'2015/5/4',registerPerson:'张三'},
            {petId:2,petName:'招财',petKind:'加菲猫',desc:'可爱',petType:'猫',petTy:'2',petSex:'母',registerDate:'2015/3/4',registerPerson:'李四'},
            {petId:3,petName:'进宝',petKind:'波斯猫',desc:'可爱',petType:'猫',petTy:'2',petSex:'公',registerDate:'2015/3/5',registerPerson:'王五'},
            {petId:4,petName:'团团',petKind:'蓝猫',desc:'可爱',petType:'猫',petTy:'2',petSex:'母',registerDate:'2015/4/9',registerPerson:'李六'}
        ];
        //查询数组
        $scope.itemsone=[{}];
        $scope.change=function(){
            if($scope.itemsone.length>1){
                $scope.itemsone.splice(1,$scope.itemsone.length)
            }
            for(var i= 0;i<$scope.petItem.length;i++){
                if($scope.petItem[i].petId==$scope.b ||
                    $scope.petItem[i].petKind==$scope.petK ||
                    $scope.petItem[i].petName==$scope.petN ||
                    $scope.petItem[i].petType==$scope.petT ||
                    $scope.petItem[i].registerPerson==$scope.registerP||
                    $scope.petItem[i].petTy==$scope.petTy ){
                    $scope.itemsone.push($scope.petItem[i]);
                }
            }
        };
        //模态框中数据传入
        $scope.show = function(petId) {
            $scope.petId = $scope.petItem[petId-1].petId;
            $scope.petName = $scope.petItem[petId-1].petName;
            $scope.petKind = $scope.petItem[petId-1].petKind;
            $scope.desc = $scope.petItem[petId-1].desc;
            $scope.petType = $scope.petItem[petId-1].petType;
            $scope.petSex = $scope.petItem[petId-1].petSex;
            $scope.registerDate = $scope.petItem[petId-1].registerDate;
            $scope.registerPerson = $scope.petItem[petId-1].registerPerson;
        };
    });
});
