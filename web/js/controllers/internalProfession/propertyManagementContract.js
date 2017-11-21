/**
 * 页面名称：【物业合同管理】内部专业线
 * 页面路径：page/internalProfession/majorAssetInitialization/newProfessional.html
 * 前端负责人：刘洋
 * 后端负责人：
 * 创建时间：2015/5/6.
 * 修改日期：2015/5/29
 * 修改人：钟加诚
 * 修改日期：2015/6/3
 */
'use strict';

define(['tyjApp','tyjUtil'],function(module,tyjUtil) {
    module.controller("contractCtrl", function ($scope, $http) {

        //json数组作为数据来源【items】
        $scope.items = [
            {
                contractId: '1',
                dateStart: '2015-04-15',
                contractType: '售房合同',
                firstParty: '刘德华',
                secondParty: '周星驰',
                sketch: '刘德华卖给周星驰一套房'
            },
            {
                contractId: '2',
                dateStart: '2015-04-16',
                contractType: '售房合同',
                firstParty: '周润发',
                secondParty: '周星驰',
                sketch: '刘德华卖给周星驰一套房'
            },
            {
                contractId: '3',
                dateStart: '2015-04-17',
                contractType: '租赁合同',
                firstParty: '张三',
                secondParty: '周星驰',
                sketch: '刘德华卖给周星驰一套房'
            },
            {
                contractId: '4',
                dateStart: '2015-04-18',
                contractType: '租赁合同',
                firstParty: '李四',
                secondParty: '周星驰',
                sketch: '刘德华卖给周星驰一套房'
            },
            {
                contractId: '5',
                dateStart: '2015-04-19',
                contractType: '售房合同',
                firstParty: '王五',
                secondParty: '周星驰',
                sketch: '刘德华卖给周星驰一套房'
            }
        ];
        //定义一个变量来接收数据来源
        var url = $scope.items;
        //搜索
        $scope.itemsone = [{}];
        $scope.change = function () {
            if ($scope.itemsone.length > 1) {
                $scope.itemsone.splice(1, $scope.itemsone.length)
            }
            for (var i = 0; i < $scope.items.length; i++) {
                if ($scope.items[i].contractId == $scope.n ||
                    $scope.items[i].contractType == $scope.contractType ||
                    $scope.items[i].firstParty == $scope.firstParty ||
                    $scope.items[i].secondParty == $scope.secondParty) {
                    $scope.itemsone.push($scope.items[i]);
                }
            }
        };
        //模态框数据传递
        $scope.show = function (contractId) {
            $scope.contractId = $scope.items[contractId - 1].contractId;
            $scope.dateStart = $scope.items[contractId - 1].dateStart;
            $scope.contractType = $scope.items[contractId - 1].contractType;
            $scope.firstParty = $scope.items[contractId - 1].firstParty;
            $scope.secondParty = $scope.items[contractId - 1].secondParty;
            $scope.sketch = $scope.items[contractId - 1].sketch;
        };

        //全选先不选中
        $scope.allChecked = false;
        /**
         * 【查询】物业合同信息
         * @param resJson 返回的json数据
         * @param  item json数据中的某一个对象
         * @param currentPage 当前页
         * @param pageSize 每页显示数量
         */
        $scope.list = function () {
            $http.get(url).success(function (resJson) {
                $scope.itemsone = resJson;

                angular.forEach($scope.itemsone, function (itemsone) {
                    itemsone.checked = false;
                });
            });
        };
        $scope.list();
        //【修改】
        $scope.toUpdate = function (index) {
            //获得当前修改行的索引
            $scope.currentIndex = index;
            //获取页面数据到文本框中
            $scope.currentItem = tyjUtil.jsonClone($scope.itemsone[index]);
        };
        //【添加】
        $scope.toAdd = function () {
            $scope.currentIndex = null;
            //清空文本框信息
            $scope.currentItem = {};
        };
        //【保存】
        $scope.save = function (items) {
            //判断是添加还是修改
            if (null != $scope.currentIndex) {
                //修改
                $scope.itemsone[$scope.currentIndex] = tyjUtil.jsonClone($scope.currentItem);
            } else {
                //添加
                $scope.items.push($scope.currentItem);
            }
        };
        //全选
        $scope.checkAll = function (checked) {
            angular.forEach($scope.items, function (contractId) {
                contractId.$checked = checked;
            });
        };
        /**
         * 全选删除
         * @param checked
         */
        $scope.delete = function (checked) {
            if (confirm("确定要删除？")) {
                var checkList = [];
                var delIds = [];
                angular.forEach($scope.items, function (items) {
                    if (items.$checked) {
                        delIds.push(items.contractId);
                        checkList.push(items.contractId);
                    }
                });
                if (checkList.length > 0) {
                    //发送请求,请求带上delIds
                    console.log("删除" + delIds);
                    var url = "data/success.txt";
                    $http.get(url).success(function (resJson) {
                        $scope.reqItems = resJson;
                        if ($scope.reqItems.status === 'success') {
                            for (var i = 0; i < checkList.length; i++) {
                                $scope.itemsone.splice(i, 1);
                            }
                        }
                        else {
                            alert("删除失败！");
                        }
                    });
                }
                else {
                    alert("请选择删除项！");
                }
            }
        };
    });
    //define(['tyjApp'], function (module) {
    //    module.controller("contractCtrl", function ($scope, $http, $rootScope, Paginator) {
    //        var url = $rootScope.url;
    //        $scope.Propertycontract = {page: {}};
    //        $scope.addpropertycontract = {};
    //        $scope.propertycontract = {};
    //        var fetchFunction = function (page, callback) {
    //            $scope.Propertycontract.page = page;
    //            $http.post(url + '/Propertycontract/listPagePropertycontract', {Propertycontract: $scope.Propertycontract}).success(callback);
    //        };
    //        $scope.searchPaginator = Paginator(fetchFunction, 8);
    //
    //        $scope.GetProduceprice = function (id) {
    //            console.log(id);
    //            if (id != 0) {
    //                $http.get(url + '/Propertycontract/getPropertycontractById/' + id).success(function (data) {
    //                    console.log(data);
    //
    //                    $scope.propertycontract = data.Propertycontract;
    //
    //                });
    //            }
    //
    //        };
    //
    //        $scope.editItem = function () {
    //            $http.put(url + '/Propertycontract/UpdatePropertycontract', {Propertycontract: $scope.propertycontract}).success(function (data) {
    //                $scope.searchPaginator._load();//刷新数据
    //            }).error(function (data, status, headers, config) {
    //                alert("error" + status);
    //            });
    //
    //
    //            $scope.AddPropertycontract = function () {
    //                $http.post(url + '/Propertycontract/AddPropertycontract', {Propertycontract: $scope.addpropertycontract}).success(function (data) {
    //                    $scope.searchPaginator._load();//刷新数据
    //                }).error(function (data, status, headers, config) {
    //                    alert("error" + status);
    //                });
    //            };
    //        };
    //        $scope.deletePropertycontract = function () {
    //            if (confirm("是否要删除勾选项？")) {
    //                var indexchekbox = 0;
    //                var indexsuccess = 0;
    //                for (var i = 0; i < $scope.searchPaginator.object.propertycontracts.length; i++) {
    //                    if ($scope.searchPaginator.object.propertycontracts[i].checkbox == true) {
    //                        indexchekbox++;
    //                        $http({
    //                            method: 'DELETE',
    //                            url: url + '/Propertycontract/DeletePropertycontractById/' + $scope.searchPaginator.object.propertycontracts[i].id
    //                        })
    //                            .success(function (data, status, headers, config) {
    //                                indexsuccess++;
    //                                if (indexchekbox == indexsuccess) {
    //                                    $scope.searchPaginator._load();//刷新数据
    //                                    alert("删除成功！");
    //                                }
    //                            }).error(function (data, status, headers, config) {
    //                                alert("删除失败！");
    //                                return;
    //                            });
    //                    }
    //                }
    //            }
    //        };
    //    });
    //});
    });