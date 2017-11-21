/**
 * Created by 倪明 on 2015/3/11.
 * 物业服务
 */
'use strict';

define(['tyjApp',
    'controllers/propertyService/staffHome',
    'controllers/propertyService/carHome',
    'controllers/propertyService/housesHome',
    'controllers/propertyService/parkingHome',
    'controllers/propertyService/shopHome'
],function(module){
    module.filter('len',function(){
        return function(items,start,end){
            var it =[];
            for(var i=start;i<end;i++){
                it.push(items[i]);
            }
            return it;
        }
    });
    module.controller("psCtrl",function($scope,$http,$rootScope){
        $scope.n='';//n的初始值赋值为0
        $scope.user='';
        $scope.cardNumber='';
        $scope.phoneNumber='';
        $scope.personnel='';
        //人员模块
        $scope.panel= [
                {title:'客户信息',personnel:'1',name:'周润发',cardNum:'420100199012011121',phoneNum:'8300000'},
                {title:'客户信息',personnel:'1',name:'李宁',cardNum:'420100199012011122',phoneNum:'8300001'},
                {title:'客户信息',personnel:'1',name:'张三',cardNum:'420100199012011123',phoneNum:'8300002'}
            ];
        //设置人员空数组
        $scope.panelsed=[{}];
        $scope.check=function(){
            alert('显示人员信息');
            if($scope.panelsed.length>1){
                $scope.panelsed.splice(1,$scope.panelsed.length);
            }
            for(var i= 0;i<$scope.panel.length;i++){
                if( $scope.panel[i].title==$scope.n ||
                    $scope.panel[i].name==$scope.user ||
                    $scope.panel[i].cardNum==$scope.cardNumber ||
                    $scope.panel[i].phoneNum==$scope.phoneNumber ||
                    $scope.panel[i].personnel==$scope.personnel
                ){
                    $scope.panelsed.push($scope.panel[i]);
                }
            }
        };

        $scope.panels={
            countShow:3,
            currentIndex:0,
            panelList:[
                {title1:'车辆信息1',title2:'房屋信息1',title3:'车位信息1',title4:'商铺信息1',title5:'账单信息1'},
                {title1:'车辆信息2',title2:'房屋信息2',title3:'车位信息2',title4:'商铺信息2',title5:'账单信息2'},
                {title1:'车辆信息3',title2:'房屋信息3',title3:'车位信息3',title4:'商铺信息3',title5:'账单信息3'},
                {title1:'车辆信息4',title2:'房屋信息4',title3:'车位信息4',title4:'商铺信息4',title5:'账单信息4'},
                {title1:'车辆信息5',title2:'房屋信息5',title3:'车位信息5',title4:'商铺信息5',title5:'账单信息5'},
                {title1:'车辆信息6',title2:'房屋信息6',title3:'车位信息6',title4:'商铺信息6',title5:'账单信息6'}
            ]
        };

        $scope.turnLeft=function(){
            var index=$scope.panels.currentIndex;
            $scope.panels.currentIndex=index>0?index-1:0;
        };
        $scope.turnRight=function(){
            var index=$scope.panels.currentIndex;
            var maxIndex=$scope.panels.panelList.length-$scope.panels.countShow;
            $scope.panels.currentIndex=index<maxIndex?index+1:index;
        };
        $scope.togglePanel=function(index){
            $scope.panels.panelList[index].active=!$scope.panels.panelList[index].active;
        };
        $scope.showMore=function(index){

        };

        $scope.tip="房屋信息";
        $scope.houses={};
        var url = $rootScope.url;
        $http.get(url + '/House/listPagehouseRest').success(function(data) {
            console.log(data);
            $scope.House = data.House;
            $scope.itemss = data.House[0];
            console.log($scope.itemss);
        });

        $scope.tip="规章制度";
        $scope.ruless={};
        $http.get(url + '/Rules/listAllRules').success(function(data) {
            console.log(data);
            $scope.Rules = data.Rules;
            $scope.myitem = data.Rules[0];
            console.log($scope.myitem);
        });



        $scope.tip="车辆信息";
        $scope.carInfos={};
        $http.get(url + '/CarInfo/listAllCarInfo').success(function(data) {
            console.log(data);

            $scope.CarInfo = data.CarInfo;
            $scope.item = data.CarInfo[0];
            console.log($scope.item);
        });

        $scope.tip="商铺信息";
        $scope.shops={};
        $http.get(url + '/Shop/listAllShop').success(function(data) {
            console.log(data);

            $scope.Shop = data.Shop;
            $scope.items = data.Shop[0];
            console.log($scope.items);
        });

        $scope.personCusts={};
        $http.get(url + '/PersonCust/listAllPersonCustRestful').success(function(data) {
            console.log(data);

            $scope.PersonCust = data.PersonCust;
            $scope.itemses = data.PersonCust[0];
            $rootScope.personCust=$scope.itemses;
            console.log($scope.itemses);
        });

        $scope.stalls={};
        $http.get(url + '/Stall/listAllStall').success(function(data) {
            console.log(data);

            $scope.Stall = data.Stall;
            $scope.myitemses = data.Stall[0];
            console.log($scope.myitemses);
        });

            	$scope.createpersonCust=function(personCust){
         $rootScope.personCust=personCust;
         };

        $scope.personCusts=[];
         $scope.stalls=[];
         var name="寰瑧";
         var url = 'http://localhost:8080/Home/cxfws/rest';
         $http.get(url + '/PersonCust/getPersonCustByNameRestful/'+name).success(function(data) {
         $scope.personCusts = data.PersonCust;
         });

         $http.get(url + '/Stall/getStallbyName/'+name).success(function(data) {
         $scope.stalls = data.Stall;
         });


         $scope.createpersonCust=function(personCust)
         {
         $rootScope.personCust=personCust;
         }; 
    	var url = $rootScope.url;
    	$scope.personCusts={};
        $scope.personCusts.staffName="陈庆华  ";
        $scope.personCusts.property=false;
        $scope.personCusts.staff=true;
       
        $http.post(url + '/PersonCustNew/propertyServiceSearch',{Search:$scope.personCusts}).success(function(data) {

            console.log(data);
            
            alert("成功");
        }).error(function(err){
           
        	 alert("失败");
         
        });
    });
});


