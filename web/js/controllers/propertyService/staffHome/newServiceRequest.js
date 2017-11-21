/**
 * 对应页面：新增企业放行条——物业服务人员主页【addCompanyPass.html】
 * 页面路径：page/propertyService/staffHome/serviceRequest/newServiceRequest.html
 * 前端负责人：刘洋
 * 创建时间：2015/6/1.
 * 后端负责人：
 * 修改时间：2015/6/8
 * 修改人：陶勇超
 * 修改时间：2015/6/10
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("newServiceRequestCtrl",function($scope,$http,Paginator,$rootScope){
        //内页切换
        $scope.tmpList=['top-addRequest','top-addRequest1'];
        $scope.currentTemplate = "top-addRequest";
        $scope.changeTemplate = function(index){
            $scope.currentTemplate =$scope.tmpList[index];
        };
        var url = $rootScope.url;
        $scope.address={};

        //查询地址
        $scope.searchAddress=function(){
            $http.get(url,{searchAddress:$scope.searchAddress}).success(function(data) {
              if(data){
                  $scope.address=data;
              }else{
                  alert("服务器请求失败！");
              }
            });
        };

        $scope.ServiceRequest={};
        var url = $rootScope.url;
        /**
         * 新增服务请求
         * @constructor
         */
        $scope.addReqService=function(){
            console.log($scope.Caraccesscard);
            $http.post(url ,{ServiceRequest:$scope.ServiceRequest}).success(function(data) {
                if(data){
                    alert("添加成功！");
                }else{
                    alert("添加失败！");
                }
            }).error(function(data){
               alert("服务器请求失败！");
            }) ;
        };

        $scope.Task={};
        /**
         * 添加任务
         * @constructor
         */
        $scope.addTask=function(){
            console.log($scope.Caraccesscard);
            $http.post(url ,{Task:$scope.Task}).success(function(data) {
                if(data){
                    alert("添加成功！");
                }else{
                    alert("添加失败！");
                }
            }).error(function(data){
                alert("服务器请求失败！");
            }) ;
        };
        $scope.test="任务类型选择";
         $scope.taskType={};
        $http.get(url + '接口').success(function(data) {
           		console.log(data);
           	$scope.taskType = data.taskType;
            });
       $scope.test="事件描述";
        //定义存放描述信息的对象
       $scope.event={
           IfUrgent:'',              //是否加急处理
           ImportantMatters:'',     //是否是重大事项
           subjectDescription:''    //事由描述
       };
        $scope.test="创建任务的专业和产品数据";
        //初始化专业
        $scope.professional={};
        $http.get(url + '接口').success(function(data) {
            console.log(data);
            $scope.professional = data.professional;
        });
        //初始化产品
        $scope.product={};
        $http.get(url + '接口').success(function(data) {
            console.log(data);
            $scope.product = data.product;
        });
        //定义存放任务的信息
        $scope.mission={
            date:'',
            description:''
        };
        //定义存放赔偿信息
        $scope.compensation={
            compensationId:'',        //赔偿ID
            name:'',                   //业主姓名
            compensationPayable:'',  //赔偿金额
            relevantContact:'',      //相关联系人
            Tel:'',
            taskDescription:''      //事件描述
        };
        //获取提交物
        $scope.submit=function(){
            console.log([$scope.event,$scope.compensation,$scope.mission]);
        };
        /**
     * 树结构数据源
     * @type {{id: number, title: string, nodes: *[]}[]}
     */
      $scope.trees=  [
          {
              id: 1,
              title:'桃源居',
              nodes: [
                  {
                      id: 11,
                      title: '一区',
                      nodes: [
                          {
                              id: 111,
                              title: "1栋",
                              nodes: [
                                  {
                                      id: 111,
                                      title: "101室",
                                      nodes: []
                                  },
                                  {
                                      id: 111,
                                      title: "102室",
                                      nodes: []
                                  },
                              ]
                          },
                          {
                              id: 111,
                              title: "2栋",
                              nodes: [
                                  {
                                      id: 111,
                                      title: "201室",
                                      nodes: []
                                  },
                                  {
                                      id: 111,
                                      title: "202室",
                                      nodes: []
                                  },
                              ]
                          },
                          {
                              id: 111,
                              title: "3栋",
                              nodes: []
                          }
                      ]
                  },
                  {
                      id: 12,
                      title: '2区',
                      nodes: []
                  }
              ]
          }
      ];
        //创建任务
        $scope.vms=[{}];

        //任务类型
        $scope.taskType=[{id:1,typeName:'赔偿给业主'},
            {id:1,typeName:'室内维修'},
            {id:1,typeName:'清洁'},
            {id:1,typeName:'园林'},
            {id:1,typeName:'安保'},
            {id:1,typeName:'邻里纠纷'},
            {id:1,typeName:'重大事项'}];
    });
});
function myselect() {
    var s1=document.getElementById("select1");
    var select2=document.getElementById("select2");
    var number=select2.options.length;
    for(var j=select2.length-1;j>=0;j--){
        select2.removeChild(select2.childNodes.item(j));
    }
    var dopt = document.createElement("OPTION");
    dopt.text="请输入电话";
    select2.add(dopt);
    if(s1.value=="zrf")
    {
        var opt = document.createElement("OPTION");
        opt.text = "13361653494";
        opt.value = "hf";
        opt.selected=false;
        select2.add(opt);
        var opt2 = document.createElement("OPTION");
        opt2.text = "12374774373";
        opt2.value = "xc";
        opt2.selected=false;
        select2.add(opt2);

    }else if(s1.value=="chl")
    {
        var opt3 = document.createElement("OPTION");
        opt3.text = "15152364997";
        opt3.value = "cy";
        opt3.selected=false;
        select2.add(opt3);
        var opt4 = document.createElement("OPTION");
        opt4.text = "4593853092";
        opt4.value = "xc";
        opt4.selected=false;
        select2.add(opt4);
    }
    //if(s1.value=="w")
    else
    {
        var opt5 = document.createElement("OPTION");
        opt5.text = "14457867";
        opt5.value = "ztf";
        opt5.selected=false;
        select2.add(opt5);
        var opt6 = document.createElement("OPTION");
        opt6.text = "24667879890";
        opt6.value = "yhs";
        opt6.selected=false;
        select2.add(opt6);
    }
}