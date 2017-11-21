/**
 * 前端负责人： 倪明
 * 后端负责人：
 * 名称：tyjApp总路由js加载
 * 创建时间：2015/4/1
 * 创建时间：2015/5/25
 */

'use strict';

(function() {
    define(['angular',
        'angularUiRouter',
        'angularResource',
        'angularSanitize',
        'angularRoute',
        'uiBootStrap',
        'cookies',
        'angularTreeControl',
        'angularFileUpload'
    ], function (angular) {

        // 定义angular的module
        var module=angular.module('tyjApp', ['ui.router.util','ngResource', 'ngSanitize', 'ngRoute','ui.bootstrap','ui.router','ngCookies','treeControl','angularFileUpload']);
        module.config(function($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('index');
            $stateProvider
                .state('index', {
                    url: '/index',
                    views: {
                        '': {
                            templateUrl: 'page/index.html'
                        },
                        'head@index': {
                            templateUrl: 'page/head.html'
                        },
                        'top@index': {
                            templateUrl: 'page/top.html',
                            controller: 'topCtrl'
                        },
                        'left@index': {
                            templateUrl: 'page/left.html'
                        },
                        'main@index': {
                            templateUrl: 'page/enterprise/index.html',
                            controller: 'entCtrl'
                        },
                        'down@index': {
                            templateUrl: 'page/down.html'
                        }
                    }
                })

                //企业信息start
                .state('index.enterprise', {
                    url: '/enterprise',
                    views: {
                        'main@index': {
                            templateUrl: 'page/enterprise/index.html',
                            controller: 'entCtrl'
                        }
                    }
                })
                //企业信息end

                //工作台start
                .state('index.workBench', {
                    url: '/workBench',
                    views: {
                        'main@index': {
                            templateUrl: 'page/workBench/index.html',
                            controller: 'workCtrl'
                        }
                    }
                })
                .state('index.workBench.task', {
                    url: '/task',
                    views: {
                        'main@index': {
                            templateUrl: 'page/workBench/task.html',
                            controller: 'taskCtrl'
                        }
                    }
                })
                .state('index.workBench.pending', {
                    url: '/pending',
                    views: {
                        'main@index': {
                            templateUrl: 'page/workBench/pending.html',
                            controller: 'pendingCtrl'
                        }
                    }
                })
                .state('index.workBench.worksheet', {
                    url: '/worksheet',
                    views: {
                        'main@index': {
                            templateUrl: 'page/workBench/worksheet.html',
                            controller: 'worksheetCtrl'
                        }
                    }
                })
                .state('index.workBench.performance', {
                    url: '/performance',
                    views: {
                        'main@index': {
                            templateUrl: 'page/workBench/performance.html',
                            controller: 'performanceCtrl'
                        }
                    }
                })
                //工作台end

                //工单管理start
                .state('index.order', {
                    url: '/order',
                    views: {
                        'main@index': {
                            templateUrl: 'page/order/index.html',
                            controller: 'orderCtrl'
                        }
                    }
                })
                //工单管理end

                //物业服务start
                .state('index.propertyService', {
                    url: '/propertyService',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/index.html',
                            controller: 'psCtrl'
                        }
                    }
                })

                //人员主页start
                .state('index.propertyService.staffHome', {
                    url: '/staffHome',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/staffHome.html',
                            controller: 'staffCtrl'
                        }
                    }
                })
                //常用start
                .state('index.propertyService.staffHome.commonUser', {
                    url: '/commonUser',
                    templateUrl: 'page/propertyService/staffHome/commonUser.html',
                    controller: 'commonUserCtrl'
                })
                //常用end

                //车辆管理开始
                .state('index.propertyService.staffHome.vehicleManagement', {
                    url: '/vehicleManagement',
                    templateUrl: 'page/propertyService/staffHome/vehicleManagement.html',
                    controller: 'vehicleCtrl'
                })
                .state('index.propertyService.staffHome.vehicleManagement.vehicleManagementAdd', {
                    url: '/vehicleManagementAdd',
                    templateUrl: 'page/propertyService/staffHome/vehicleManagement/vehicleManagementAdd.html',
                    controller: 'vehicleManagementAddCtrl'
                })
                .state('index.propertyService.staffHome.vehicleManagement.vehicleManagementCheck', {
                    url: '/vehicleManagementCheck',
                    templateUrl: 'page/propertyService/staffHome/vehicleManagement/vehicleManagementCheck.html',
                    controller: 'vehicleManagementCheckCtrl'
                })
                //车辆管理结束

                //【服务请求】物业服务
                .state('index.propertyService.staffHome.serviceRequest', {
                    url: '/serviceRequest',
                    templateUrl: 'page/propertyService/staffHome/serviceRequest.html',
                    controller: 'serviceCtrl'
                })
                //【添加服务请求】物业服务
                .state('index.propertyService.staffHome.newServiceRequest', {
                    url: '/newServiceRequest',
                            templateUrl: 'page/propertyService/staffHome/newServiceRequest.html',
                            controller: 'newServiceRequestCtrl'
                })

                //物业服务门禁卡开
                .state('index.propertyService.staffHome.entranceGuard', {
                    url: '/entranceGuard',
                    templateUrl: 'page/propertyService/staffHome/entranceGuard.html',
                    controller: 'entranceGuardCtrl'
                })

                //新增门禁卡业
                .state('index.propertyService.staffHome.entranceGuard.addEntranceGuard', {
                    url: '/addEntranceGuard',
                    templateUrl: 'page/propertyService/staffHome/entranceGuard/addEntranceGuard.html',
                    controller: 'addEntranceGuardCtrl'
                })
                //查询门禁卡历史记
                .state('index.propertyService.staffHome.entranceGuard.checkEntranceGuard', {
                    url: '/checkEntranceGuard',
                    templateUrl: 'page/propertyService/staffHome/entranceGuard/checkEntranceGuard.html',
                    controller: 'checkEntranceGuardCtrl'
                })

                //物业服务门禁卡结
                .state('index.propertyService.staffHome.lease', {
                    url: '/lease',
                    templateUrl: 'page/propertyService/staffHome/lease.html',
                    controller: 'leaseCtrl'
                })

                .state('index.propertyService.staffHome.lease.leaseAdd', {
                    url: '/leaseAdd',
                    templateUrl: 'page/propertyService/staffHome/lease/leaseAdd.html',
                    controller: 'leaseAddCtrl'
                })
                .state('index.propertyService.staffHome.lease.leaseHistory', {
                    url: '/leaseHistory',
                    templateUrl: 'page/propertyService/staffHome/lease/leaseHistory.html',
                    controller: 'leaseHistoryCtrl'
                })
                .state('index.propertyService.staffHome.lease.leaseAdd.leaseAddrenyuan', {
                    url: '/leaseAddrenyuan',
                    templateUrl: 'page/propertyService/staffHome/lease/leaseAdd/leaseAddrenyuan.html',
                    controller: 'leaseAddrenyuanCtrl'
                })
                .state('index.propertyService.staffHome.lease.leaseAdd.leaseAddzichan', {
                    url: '/leaseAddzichan',
                    templateUrl: 'page/propertyService/staffHome/lease/leaseAdd/leaseAddzichan.html',
                    controller: 'leaseAddzichanCtrl'
                })
                .state('index.propertyService.staffHome.lease.leaseAdd.leaseAddchanpin', {
                    url: '/leaseAddchanpin',
                    templateUrl: 'page/propertyService/staffHome/lease/leaseAdd/leaseAddchanpin.html',
                    controller: 'leaseAddchanpinCtrl'
                })

                //租赁结束

                //停车卡开始
                .state('index.propertyService.staffHome.parkingCard', {
                    url: '/parkingCard',
                    templateUrl: 'page/propertyService/staffHome/parkingCard.html',
                    controller: 'parkingCardCtrl'
                })
                .state('index.propertyService.staffHome.parkingCard.newCard', {
                    url: '/newCard',
                    templateUrl: 'page/propertyService/staffHome/parkingCard/newCard.html',
                    controller: 'newCardCtrl'
                })

                .state('index.propertyService.staffHome.parkingCard.historyRecord', {
                    url: '/historyRecord',
                    templateUrl: 'page/propertyService/staffHome/parkingCard/historyRecord.html',
                    controller: 'historyRecordCtrl'
                })
                //停车卡结束

                //宠物登记开始
                .state('index.propertyService.staffHome.petRegistration', {
                    url: '/petRegistration',
                    templateUrl: 'page/propertyService/staffHome/petRegistration.html',
                    controller: 'petCtrl'
                })

                .state('index.propertyService.staffHome.petRegistration.newPet', {
                    url: '/newPet',
                    templateUrl: 'page/propertyService/staffHome/petRegistration/newPet.html',
                    controller: 'newPetCtrl'
                })

                .state('index.propertyService.staffHome.petRegistration.history', {
                    url: '/history',
                    templateUrl: 'page/propertyService/staffHome/petRegistration/history.html',
                    controller: 'historyPetCtrl'
                })
                //宠物登记结束

                //授权管理start
                .state('index.propertyService.staffHome.empowerManagement', {
                    url: '/empowerManagement',
                    templateUrl: 'page/propertyService/staffHome/empowerManagement.html',
                    controller: 'empowerManagementCtrl'
                })
                .state('index.propertyService.staffHome.empowerManagement.empower', {
                    url: '/empower',
                    templateUrl: 'page/propertyService/staffHome/empowerManagement/empower.html',
                    controller: 'empowerCtrl'
                })
                .state('index.propertyService.staffHome.empowerManagement.history', {
                    url: '/history',
                    templateUrl: 'page/propertyService/staffHome/empowerManagement/history.html',
                    controller: 'authorizationhistoryCtrl'
                })
                //授权管理end

                .state('index.propertyService.staffHome.parkingManagement', {
                    url: '/parkingManagement',
                    templateUrl: 'page/propertyService/staffHome/parkingManagement.html',
                    controller: 'parkManCtrl'
                })

                //装修start
                .state('index.propertyService.staffHome.decorate', {
                    url: '/decorate',
                    templateUrl: 'page/propertyService/staffHome/decorate.html',
                    controller: 'decorateCtrl'
                })
                //办理装修start
                .state('index.propertyService.staffHome.decorate.decoration', {
                    url: '/decoration',
                    templateUrl: 'page/propertyService/staffHome/decorate/decoration.html',
                    controller: 'decorationCtrl'
                })
                    //选择房屋开始
                    .state('index.propertyService.staffHome.decorate.decoration.chooseHouse', {
                        url: '/chooseHouse',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/chooseHouse.html',
                        controller: 'chooseHouseCtrl'
                    })
                    //选择房屋结束
                    //申请资料开始
                    .state('index.propertyService.staffHome.decorate.decoration.applicationData', {
                        url: '/applicationData',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/applicationData.html',
                        controller: 'applicationDataCtrl'
                    })
                    //申请资料结束
                    //现场核查开始
                    .state('index.propertyService.staffHome.decorate.decoration.verification', {
                        url: '/verification',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/verification.html',
                        controller: 'verificationCtrl'
                    })
                    //现场核查结束
                    //缴纳押金开始
                    .state('index.propertyService.staffHome.decorate.decoration.payDeposit', {
                        url: '/payDeposit',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/payDeposit.html',
                        controller: 'payDepositCtrl'
                    })
                    //缴纳押金结束
                    //发放许可证开始
                    .state('index.propertyService.staffHome.decorate.decoration.Alicence', {
                        url: '/Alicence',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/Alicence.html',
                        controller: 'AlicenceCtrl'
                    })
                    //发放许可证结束
                    //施工过程start
                    .state('index.propertyService.staffHome.decorate.decoration.workProgress', {
                        url: '/workProgress',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/workProgress.html',
                        controller: 'workProgressCtrl'
                    })
                    .state('index.propertyService.staffHome.decorate.decoration.workProgress.defaultFine', {
                        url: '/defaultFine',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/workProgress/defaultFine.html',
                        controller: 'defaultFineCtrl'
                    })
                    .state('index.propertyService.staffHome.decorate.decoration.workProgress.rectificationNotice', {
                        url: '/rectificationNotice',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/workProgress/rectificationNotice.html',
                        controller: 'rectificationNoticeCtrl'
                    })
                    //施工过程end
                    //验收开始
                    .state('index.propertyService.staffHome.decorate.decoration.acceptance', {
                        url: '/acceptance',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/acceptance.html',
                        controller: 'acceptanceCtrl'
                    })
                    //验收结束
                    //费用结算开始
                    .state('index.propertyService.staffHome.decorate.decoration.costClearing', {
                        url: '/costClearing',
                        templateUrl: 'page/propertyService/staffHome/decorate/decoration/costClearing.html',
                        controller: 'costClearingCtrl'
                    })
                    //费用结算结束
                //办理装修end

                .state('index.propertyService.staffHome.decorate.history', {
                    url: '/history',
                    templateUrl: 'page/propertyService/staffHome/decorate/history.html',
                    controller: 'historyCtrl'
                })
                //装修end

                //入伙start
                .state('index.propertyService.staffHome.joinGang', {
                    url: '/joinGang',
                    templateUrl: 'page/propertyService/staffHome/joinGang.html',
                    controller: 'joinGangCtrl'
                })
                    //选择房屋start
                    .state('index.propertyService.staffHome.joinGang.choiceHousing', {
                        url: '/choiceHousing',
                        templateUrl: 'page/propertyService/staffHome/joinGang/choiceHousing.html',
                        controller: 'choiceHousingCtrl'
                    })
                    //选择房屋end
                    //收管理费start
                    .state('index.propertyService.staffHome.joinGang.collectingManagement', {
                        url: '/collectingManagement',
                        templateUrl: 'page/propertyService/staffHome/joinGang/collectingManagement.html',
                        controller: 'collectManageCtrl'
                    })
                    //收管理费end
                    //物品领取start
                    .state('index.propertyService.staffHome.joinGang.goodsReceipt', {
                        url: '/goodsReceipt',
                        templateUrl: 'page/propertyService/staffHome/joinGang/goodsReceipt.html',
                        controller: 'goodsReceiptCtrl'
                    })
                    //物品领取end
                    //业主收房start
                    .state('index.propertyService.staffHome.joinGang.ownersShoufang', {
                        url: '/ownersShoufang',
                        templateUrl: 'page/propertyService/staffHome/joinGang/ownersShoufang.html',
                        controller: 'ownersShouCtrl'
                    })
                    //业主收房end
                //办理授权end

                .state('index.propertyService.staffHome.joinGang.historicRecords', {
                    url: '/historicRecords',
                    templateUrl: 'page/propertyService/staffHome/joinGang/historicRecords.html',
                    controller: 'historicCtrl'
                })
                //入伙end

                //产权变更start
                .state('index.propertyService.staffHome.changeTitle', {
                    url: '/changeTitle',
                    templateUrl: 'page/propertyService/staffHome/changeTitle.html',
                    controller: 'changeCtrl'
                })


                .state('index.propertyService.staffHome.changeTitle.addHousingInformation', {
                    url: '/addHousingInformation',
                    templateUrl: 'page/propertyService/staffHome/changeTitle/addHousingInformation.html',
                    controller: 'addHousingInformationCtrl'
                })

                //产权变更end

                //放行条start
                .state('index.propertyService.staffHome.releasePass', {
                    url: '/releasePass',
                    templateUrl: 'page/propertyService/staffHome/releasePass.html',
                    controller: 'releasePassCtrl'
                })
                //【新增放行条】人员主页
                .state('index.propertyService.staffHome.releasePass.addReleasePass', {
                    url: '/addReleasePass',
                    templateUrl: 'page/propertyService/staffHome/releasePass/addReleasePass.html',
                    controller: 'addReleasePassCtrl'
                })
                //【新增企业放行条】人员主页
                .state('index.propertyService.staffHome.releasePass.addCompanyPass', {
                    url: '/addCompanyPass',
                    templateUrl: 'page/propertyService/staffHome/releasePass/addCompanyPass.html',
                    controller: 'addCompanyPassCtrl'
                })
                //【放行条历史记录】人员主页
                .state('index.propertyService.staffHome.releasePass.historicRecords', {
                    url: '/historicRecords',
                    templateUrl: 'page/propertyService/staffHome/releasePass/historicRecords.html',
                    controller: 'historicRecordesCtrl'
                })
                //放行条end

                //人员主页end

                //车辆主页start
                .state('index.propertyService.carHome', {
                    url: '/carHome',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/carHome.html',
                            controller: 'carHomeCtrl'
                        }
                    }
                })
                .state('index.propertyService.carHome.parkingCard', {
                    url: '/parkingCard',
                    templateUrl: 'page/propertyService/carHome/parkingCard.html',
                    controller: 'parkingCardCtrl'
                })

                .state('index.propertyService.carHome.vehicleManagement', {
                    url: '/vehicleManagement',
                    templateUrl: 'page/propertyService/carHome/vehicleManagement.html',
                    controller: 'vehicleManCtrl'
                })
                .state('index.propertyService.carHome.claimManagement', {
                    url: '/claimManagement',
                    templateUrl: 'page/propertyService/carHome/claimManagement.html',
                    controller: 'claimManCtrl'
                })
                .state('index.propertyService.carHome.collectFees', {
                    url: '/collectFees',
                    templateUrl: 'page/propertyService/carHome/collectFees.html',
                    controller: 'collectCtrl'
                })
                //车辆主页end

                //房屋主页start
                .state('index.propertyService.housesHome', {
                    url: '/housesHome',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/housesHome.html',
                            controller: 'housesCtrl'
                        }
                    }
                })
                .state('index.propertyService.housesHome.homePage', {
                    url: '/homePage',
                    templateUrl: 'page/propertyService/housesHome/homePage.html',
                    controller: 'homePageHouseCtrl'
                })

                //入伙start
                .state('index.propertyService.housesHome.joinGang', {
                    url: '/joinGang',
                    templateUrl: 'page/propertyService/housesHome/joinGang.html',
                    controller: 'joinGangCarCtrl'
                })
                //办理授权start
                .state('index.propertyService.housesHome.joinGang.licensing', {
                    url: '/licensing',
                    templateUrl: 'page/propertyService/housesHome/joinGang/licensing.html',
                    controller: 'licensingHouseCtrl'
                })
                .state('index.propertyService.housesHome.joinGang.licensing.choiceHousing', {
                    url: '/choiceHousing',
                    templateUrl: 'page/propertyService/housesHome/joinGang/licensing/choiceHousing.html',
                    controller: 'choiceHousingCtrl'
                })
                .state('index.propertyService.housesHome.joinGang.licensing.collectingManagement', {
                    url: '/collectingManagement',
                    templateUrl: 'page/propertyService/housesHome/joinGang/licensing/collectingManagement.html',
                    controller: 'collectManageHouseCtrl'
                })
                .state('index.propertyService.housesHome.joinGang.licensing.goodsReceipt', {
                    url: '/goodsReceipt',
                    templateUrl: 'page/propertyService/housesHome/joinGang/licensing/goodsReceipt.html',
                    controller: 'goodsReceiptHouseCtrl'
                })
                .state('index.propertyService.housesHome.joinGang.licensing.ownersShoufang', {
                    url: '/ownersShoufang',
                    templateUrl: 'page/propertyService/housesHome/joinGang/licensing/ownersShoufang.html',
                    controller: 'ownersHouseCtrl'
                })
                //办理授权end

                .state('index.propertyService.housesHome.joinGang.historicRecords', {
                    url: '/historicRecords',
                    templateUrl: 'page/propertyService/housesHome/joinGang/historicRecords.html',
                    controller: 'historicHouseCtrl'
                })
                //入伙end

                .state('index.propertyService.housesHome.decorate', {
                    url: '/decorate',
                    templateUrl: 'page/propertyService/housesHome/decorate.html',
                    controller: 'decorateHouseCtrl'
                })
                .state('index.propertyService.housesHome.changeTitle', {
                    url: '/changeTitle',
                    templateUrl: 'page/propertyService/housesHome/changeTitle.html',
                    controller: 'changeHouseCtrl'
                })
                .state('index.propertyService.housesHome.lease', {
                    url: '/lease',
                    templateUrl: 'page/propertyService/housesHome/lease.html',
                    controller: 'leaseHouseCtrl'
                })
                //房屋主页end

                //车位主页start
                .state('index.propertyService.parkingHome', {
                    url: '/parkingHome',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/parkingHome.html',
                            controller: 'parkingCtrl'
                        }
                    }
                })
                //车位主页end

                //商铺主页start
                .state('index.propertyService.shopHome', {
                    url: '/shopHome',
                    views: {
                        'main@index': {
                            templateUrl: 'page/propertyService/shopHome.html',
                            controller: 'shopsCtrl'
                        }
                    }
                })
                .state('index.propertyService.shopHome.homePage', {
                    url: '/homePage',
                    templateUrl: 'page/propertyService/shopsHome/homePage.html',
                    controller: 'homePageCtrl'
                })
                .state('index.propertyService.shopHome.housing', {
                    url: '/housing',
                    templateUrl: 'page/propertyService/shopsHome/housing.html',
                    controller: 'housingCtrl'
                })
                .state('index.propertyService.shopHome.partnership', {
                    url: '/partnership',
                    templateUrl: 'page/propertyService/shopsHome/partnership.html',
                    controller: 'partnershipCtrl'
                })
                .state('index.propertyService.shopHome.decorate', {
                    url: '/decorate',
                    templateUrl: 'page/propertyService/shopsHome/decorate.html',
                    controller: 'decorateShopCtrl'
                })
                .state('index.propertyService.shopHome.change', {
                    url: '/change',
                    templateUrl: 'page/propertyService/shopsHome/change.html',
                    controller: 'changeShopCtrl'
                })
                .state('index.propertyService.shopHome.lease', {
                    url: '/lease',
                    templateUrl: 'page/propertyService/shopsHome/lease.html',
                    controller: 'leaseShopCtrl'
                })
                //商铺主页end

                //物业服务end

                //外部专业线start
                .state('index.externalProfession', {
                    url: '/externalProfession',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/index.html',
                            controller: 'epCtrl'
                        }
                    }
                })

                //外部专业线工单查询
                .state('index.externalProfession.inquiry', {
                    url: '/inquiry',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/inquiry.html',
                            controller: 'inquiryCtrl'
                        }
                    }
                })


                //外部专业线工单查询 end

                //外部专业线【部门质检活动详情】
                .state('index.externalProfession.qualityActivityDetails', {
                    url: '/qualityActivityDetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityActivityDetails.html',
                            controller: 'qualityActivityDetailsCtrl'
                        }
                    }
                })
                //外部专业线【质检活动详情】 end

                //外部专业线【个人评分详情】
                .state('index.externalProfession.personalScoreDetails', {
                    url: '/personalScoreDetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/personalScoreDetails.html',
                            controller: 'personalScoreDetailsCtrl'
                        }
                    }
                })


                //外部专业线【个人评分详情】 end

                //外部专业线重大事项设
                .state('index.externalProfession.majorIssuesSet', {
                    url: '/majorIssuesSet',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/majorIssuesSet.html',
                            controller: 'majorIssuesSetCtrl'
                        }
                    }
                })
                .state('index.externalProfession.majorIssuesSet.claims', {
                    url: '/claims',
                    templateUrl: 'page/externalProfession/majorIssuesSet/claims.html',
                    controller: 'claims01Ctrl'
                })
                .state('index.externalProfession.majorIssuesSet.cleaning', {
                    url: '/cleaning',
                    templateUrl: 'page/externalProfession/majorIssuesSet/cleaning.html',
                    controller: 'cleaning01Ctrl'
                })
                .state('index.externalProfession.majorIssuesSet.repair', {
                    url: '/repair',
                    templateUrl: 'page/externalProfession/majorIssuesSet/repair.html',
                    controller: 'repair01Ctrl'
                })
                .state('index.externalProfession.majorIssuesSet.majorMatters', {
                    url: '/majorMatters',
                    templateUrl: 'page/externalProfession/majorIssuesSet/majorMatters.html',
                    controller: 'majorMatters01Ctrl'
                })
                .state('index.externalProfession.majorIssuesSet.park', {
                    url: '/park',
                    templateUrl: 'page/externalProfession/majorIssuesSet/park.html',
                    controller: 'park01Ctrl'
                })
                .state('index.externalProfession.majorIssuesSet.Security', {
                    url: '/Security',
                    templateUrl: 'page/externalProfession/majorIssuesSet/Security.html',
                    controller: 'Security01Ctrl'
                })
                //重大事项设置结束
                //重大事项
                .state('index.externalProfession.majorMatter', {
                    url: '/majorMatter',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/majorMatter.html',
                            controller: 'majorMatterCtrl'
                        }
                    }
                })
                //新增重大事项开始
                .state('index.externalProfession.majorMatter.majorMatterAdd', {
                    url: '/majorMatterAdd',
                    templateUrl: 'page/externalProfession/majorMatter/majorMatterAdd.html',
                    controller: 'majorMatterAddCtrl'
                })
                //新增重大事项结束
                //查询重大事项开始
                .state('index.externalProfession.majorMatter.majorMatterCheck', {
                    url: '/majorMatterCheck',
                    templateUrl: 'page/externalProfession/majorMatter/majorMatterCheck.html',
                    controller: 'majorMatterCheckCtrl'
                })
                //查询重大事项结束
                //重大事项结束


                //服务请求详情start
                .state('index.externalProfession.serviceRequestDatil', {
                    url: '/serviceRequestDatil',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/serviceRequestDatil.html',
                            controller: 'serviceRequestDatilCtrl'
                        }
                    }
                })

                .state('index.externalProfession.serviceRequestDatil.allWorkOrders', {
                    url: '/allWorkOrders',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/allWorkOrders.html',
                    controller: 'allWorkOrdersCtrl'
                })

                //清洁start
                .state('index.externalProfession.serviceRequestDatil.cleaning', {
                    url: '/cleaning',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleaning.html',
                    controller: 'cleaningCtrl'
                })
                //清洁查询start
                .state('index.externalProfession.serviceRequestDatil.cleanQuery', {
                    url: '/cleanQuery',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery.html',
                    controller: 'cleanQueryCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.taskDetails', {
                    url: '/taskDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/taskDetails.html',
                    controller: 'taskDetailsCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.quotationDetails', {
                    url: '/quotationDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/quotationDetails.html',
                    controller: 'quotationDetailsCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.handlingDetails', {
                    url: '/handlingDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/handlingDetails.html',
                    controller: 'handlingDetailsCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.acceptanceDetails', {
                    url: '/acceptanceDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/acceptanceDetails.html',
                    controller: 'acceptanceDetailsCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.settlementDetails', {
                    url: '/settlementDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/settlementDetails.html',
                    controller: 'settlementDetailsCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.cleanQuery.logDetails', {
                    url: '/logDetails',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/cleanQuery/logDetails.html',
                    controller: 'logDetailsCtrl'
                })
                //清洁查询end
                //清洁start

                .state('index.externalProfession.serviceRequestDatil.maintain', {
                    url: '/maintain',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/maintain.html',
                    controller: 'maintainCtrl'
                })

                .state('index.externalProfession.serviceRequestDatil.park', {
                    url: '/park',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/park.html',
                    controller: 'parkCtrl'
                })

                .state('index.externalProfession.serviceRequestDatil.security', {
                    url: '/security',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/security.html',
                    controller: 'securityCtrl'
                })

                .state('index.externalProfession.serviceRequestDatil.complaint', {
                    url: '/complaint',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/complaint.html',
                    controller: 'complaintCtrl'
                })

                .state('index.externalProfession.serviceRequestDatil.compensation', {
                    url: '/compensation',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/compensation.html',
                    controller: 'compensationCtrl'
                })

                .state('index.externalProfession.serviceRequestDatil.visit', {
                    url: '/visit',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/visit.html',
                    controller: 'visitCtrl'
                })
                .state('index.externalProfession.serviceRequestDatil.addTask', {
                    url: '/addTask',
                    templateUrl: 'page/externalProfession/serviceRequestDatil/addTask.html',
                    controller: 'addTaskCtrl'
                })

                //服务请求详情end
                //服务请求查询
                .state('index.externalProfession.servicerequestinquiry', {
                    url: '/servicerequestinquiry',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/servicerequestinquiry.html',
                            controller: 'servicerequestinquiryCtrl'
                        }
                    }
                })
                //服务请求查询结束
                //索赔
                .state('index.externalProfession.compensation', {
                    url: '/compensation',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/compensation.html',
                            controller: 'compensationCtrl'
                        }
                    }
                })
                .state('index.externalProfession.compensation.compensationAdd', {
                    url: '/compensationAdd',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/compensation/compensationAdd.html',
                            controller: 'compensationAddCtrl'
                        }
                    }
                })
                .state('index.externalProfession.compensation.compensationCheck', {
                    url: '/compensationCheck',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/compensation/compensationCheck.html',
                            controller: 'compensationCheckCtrl'
                        }
                    }
                })

                //遗失物品start
                .state('index.externalProfession.lostArticles', {
                    url: '/lostArticles',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/lostArticles.html',
                            controller: 'lostArticlesCtrl'
                        }
                    }
                })
                //遗失物品end

                //抄表管理
                .state('index.externalProfession.meterReadingManagement', {
                    url: '/meterReadingManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/meterReadingManagement.html',
                            controller: 'meterReadingManagementCtrl'
                        }
                    }
                })


                .state('index.externalProfession.meterReadingManagement.newActivities', {
                    url: '/newActivities',
                    templateUrl: 'page/externalProfession/meterReadingManagement/newActivities.html',
                    controller: 'newActivitiesCtrl'
                })
                .state('index.externalProfession.meterReadingManagement.meterReading01', {
                    url: '/meterReading01',
                            templateUrl: 'page/externalProfession/meterReadingManagement/meterReading01.html',
                            controller: 'meterReading01Ctrl'
                })
                .state('index.externalProfession.meterReadingManagement.detailedInformation', {
                    url: '/detailedInformation',
                    templateUrl: 'page/externalProfession/meterReadingManagement/detailedInformation.html',
                    controller: 'detailedInformationCtrl'
                })
                .state('index.externalProfession.meterReadingManagement.meterReading03', {
                    url: '/meterReading03',
                            templateUrl: 'page/externalProfession/meterReadingManagement/meterReading03.html',
                            controller: 'meterReading03Ctrl'
                })

                .state('index.externalProfession.meterReadingManagement.history01', {
                    url: '/history01',
                    templateUrl: 'page/externalProfession/meterReadingManagement/history01.html',
                    controller: 'history01Ctrl'
                })
                //抄表管理结束

                //全部宠物start
                .state('index.externalProfession.allPets', {
                    url: '/allPets',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allPets.html',
                            controller: 'allPetsCtrl'
                        }
                    }
                })
                //全部宠物end

                //索赔查看中导航开
                .state('index.externalProfession.compensation.compensationCheck.log', {
                    url: '/log',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/log.html',
                    controller: 'logCtrl'
                })
                .state('index.externalProfession.compensation.compensationCheck.balanceorder', {
                    url: '/balanceorder',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/balanceorder.html',
                    controller: 'balanceorderCtrl'
                })
                .state('index.externalProfession.compensation.compensationCheck.checkorder', {
                    url: '/checkorder',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/checkorder.html',
                    controller: 'checkorderCtrl'
                })
                .state('index.externalProfession.compensation.compensationCheck.manageorder', {
                    url: '/manageorder',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/manageorder.html',
                    controller: 'manageorderCtrl'
                })
                .state('index.externalProfession.compensation.compensationCheck.offerorder', {
                    url: '/offerorder',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/offerorder.html',
                    controller: 'offerorderCtrl'
                })
                .state('index.externalProfession.compensation.compensationCheck.order', {
                    url: '/order',
                    templateUrl: 'page/externalProfession/compensation/compensationCheck/order.html',
                    controller: 'orderIntCtrl'
                })
                //索赔查看中导航结
                //索赔结束


                //维修BOM
                .state('index.externalProfession.repairBom', {
                    url: '/repairBom',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/repairBom.html',
                            controller: 'repairBomCtrl'
                        }
                    }
                })

                //维修BOM结束




                //外部专业线个人客户管理
                .state('index.externalProfession.individualCustomerManagement', {
                    url: '/individualCustomerManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/individualCustomerManagement.html',
                            controller: 'individualCustomerCtrl'
                        }
                    }
                })
                //新增客户个人客户管理
                .state('index.externalProfession.individualCustomerManagement.newCustomers', {
                    url: '/newCustomers',

                    templateUrl: 'page/externalProfession/individualCustomerManagement/newCustomers.html',
                    controller: 'newCustomersCtrl'

                })

                //查询客户个人客户管理
                .state('index.externalProfession.individualCustomerManagement.queryCustomers', {
                    url: '/queryCustomers',

                    templateUrl: 'page/externalProfession/individualCustomerManagement/queryCustomers.html',
                    controller: 'queryCustomersCtrl'
                })

                //外部专业线个人客户管理 end

                //任务查询
                .state('index.externalProfession.queryTask', {
                    url: '/queryTask',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/queryTask.html',
                            controller: 'queryTaskCtrl'
                        }
                    }
                })
                //任务查询结束

                //产权变更
                .state('index.externalProfession.changeOfTitle', {
                    url: '/changeOfTitle',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/changeOfTitle.html',
                            controller: 'changeOfTitleCtrl'
                        }
                    }
                })
                //产权变更结束

                //部门
                .state('index.externalProfession.departmentOfInspection', {
                    url: '/departmentOfInspection',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentOfInspection.html',
                            controller: 'departmentOfInspectionCtrl'
                        }
                    }
                })
                .state('index.externalProfession.departmentOfInspection.cleaning', {
                    url: '/cleaning',
                    templateUrl: 'page/externalProfession/departmentOfInspection/cleaning.html',
                    controller: 'cleaning1Ctrl'
                })
                .state('index.externalProfession.departmentOfInspection.gardens', {
                    url: '/gardens',
                    templateUrl: 'page/externalProfession/departmentOfInspection/gardens.html',
                    controller: 'gardens1Ctrl'
                })
                .state('index.externalProfession.departmentOfInspection.security', {
                    url: '/security',
                    templateUrl: 'page/externalProfession/departmentOfInspection/security.html',
                    controller: 'security1Ctrl'
                })
                //部门清洁
                .state('index.externalProfession.departmentOfInspection.cleaning.cleaningAdd', {
                    url: '/cleaningAdd',
                    templateUrl: 'page/externalProfession/departmentOfInspection/cleaning/cleaningAdd.html',
                    controller: 'cleaningAddCtrl'
                })
                .state('index.externalProfession.departmentOfInspection.cleaning.cleaningCheck', {
                    url: '/cleaningCheck',
                    templateUrl: 'page/externalProfession/departmentOfInspection/cleaning/cleaningCheck.html',
                    controller: 'cleaningCheckCtrl'
                })
                //部门清洁结束
                //部门结束

                //企业客户管理
                .state('index.externalProfession.enterpriseCustomerManagement', {
                    url: '/enterpriseCustomerManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/enterpriseCustomerManagement.html',
                            controller: 'enterpriseCustomerManagementCtrl'
                        }
                    }
                })

                .state('index.externalProfession.enterpriseCustomerManagement.enterpriseCustomerManagementCheck', {
                    url: '/enterpriseCustomerManagementCheck',
                    templateUrl: 'page/externalProfession/enterpriseCustomerManagement/enterpriseCustomerManagementCheck.html',
                    controller: 'enterpriseCustomerManagementCheckCtrl'
                })

                .state('index.externalProfession.enterpriseCustomerManagement.enterpriseCustomerManagementAdd', {
                    url: '/enterpriseCustomerManagementAdd',
                    templateUrl: 'page/externalProfession/enterpriseCustomerManagement/enterpriseCustomerManagementAdd.html',
                    controller: 'enterpriseCustomerManagementAddCtrl'
                })

                //企业客户管理结束


                //配置部门?
                .state('index.externalProfession.allocationInspectionDepartment', {
                    url: '/allocationInspectionDepartment',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allocationInspectionDepartment.html',
                            controller: 'allocationInspectionDepartmentCtrl'
                        }
                    }
                })
                .state('index.externalProfession.allocationInspectionDepartment.allocationDepartmentCheck', {
                    url: '/allocationDepartmentCheck',
                    templateUrl: 'page/externalProfession/allocationInspectionDepartment/allocationDepartmentCheck.html',
                    controller: 'allocationDepartmentCheckCtrl'
                })
                .state('index.externalProfession.allocationInspectionDepartment.allocationDepartmentAdd', {
                    url: '/allocationDepartmentAdd',
                    templateUrl: 'page/externalProfession/allocationInspectionDepartment/allocationDepartmentAdd.html',
                    controller: 'allocationDepartmentAddCtrl'
                })
                //配置部门?

                //部门
                .state('index.externalProfession.departmentCheck', {
                    url: '/departmentCheck',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentCheck.html',
                            controller: 'departmentCheckCtrl'
                        }
                    }
                })
                .state('index.externalProfession.departmentCheck.plan', {
                    url: '/plan',
                    templateUrl: 'page/externalProfession/departmentCheck/plan.html',
                    controller: 'planCtrl'
                })

                .state('index.externalProfession.departmentCheck.plan.page1', {
                    url: '/page1',
                    templateUrl: 'page/externalProfession/departmentCheck/plan/page1.html',
                    controller: 'page1Ctrl'
                })

                .state('index.externalProfession.departmentCheck.plan.page2', {
                    url: '/page2',
                    templateUrl: 'page/externalProfession/departmentCheck/plan/page2.html',
                    controller: 'page2Ctrl'
                })

                .state('index.externalProfession.departmentCheck.task', {
                    url: '/task',
                    templateUrl: 'page/externalProfession/departmentCheck/task.html',
                    controller: 'taskedCtrl'
                })

                .state('index.externalProfession.departmentCheck.task.chooseTask', {
                    url: '/chooseTask',
                    templateUrl: 'page/externalProfession/departmentCheck/task/chooseTask.html',
                    controller: 'chooseTaskCtrl'
                })

                .state('index.externalProfession.departmentCheck.task.chooseTeam', {
                    url: '/chooseTeam',
                    templateUrl: 'page/externalProfession/departmentCheck/task/chooseTeam.html',
                    controller: 'chooseTeamCtrl'
                })

                .state('index.externalProfession.departmentCheck.task.makeTask', {
                    url: '/makeTask',
                    templateUrl: 'page/externalProfession/departmentCheck/task/makeTask.html',
                    controller: 'makeTaskCtrl'
                })

                .state('index.externalProfession.departmentCheck.task.finish', {
                    url: '/finish',
                    templateUrl: 'page/externalProfession/departmentCheck/task/finish.html',
                    controller: 'finishCtrl'
                })


                //部门????结束
                //外部专业线全部门禁卡????
                .state('index.externalProfession.allentraceCard', {
                    url: '/allentraceCard',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allentraceCard.html',
                            controller: 'allCardCtrl'
                        }
                    }
                })

                //外部专业线全部门禁卡结束


                //外部专业线质量检查V2
                .state('index.externalProfession.qualityInspection', {
                    url: '/qualityInspection',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityInspection.html',
                            controller: 'qualityInspectionCtrl'
                        }
                    }
                })

                //外部专业线质量检查V2结束

                //全部停车卡开
                .state('index.externalProfession.allParkingCard', {
                    url: '/allParkingCard',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allParkingCard.html',
                            controller: 'allParkingCardCtrl'

                        }
                    }
                })
                //全部停车卡结


                //VIP客户管理start
                .state('index.externalProfession.VIPcustomer', {
                    url: '/VIPcustomer',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/VIPcustomer.html',
                            controller: 'VIPCtrl'
                        }
                    }
                })
                //VIP客户管理end

                //全部业主租赁

                .state('index.externalProfession.allOwnersLease', {
                    url: '/allOwnersLease',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allOwnersLease.html',
                            controller: 'allOwnersLeaseCtrl'

                        }
                    }
                })
                //全部业主租赁结束



                //小区公告start
                .state('index.externalProfession.communityAnnouncement', {
                    url: '/communityAnnouncement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/communityAnnouncement.html',
                            controller: 'comAnnounceCtrl'
                        }
                    }
                })
                //小区公告end

                //FAQstart
                .state('index.externalProfession.FAQ', {
                    url: '/FAQ',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/FAQ.html',
                            controller: 'faqCtrl'
                        }
                    }
                })
                //FAQend

                //重点客户start
                .state('index.externalProfession.importantClient', {
                    url: '/importantClient',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/importantClient.html',
                            controller: 'imClientCtrl'
                        }
                    }
                })
                //重点客户end

                //规章制度start
                .state('index.externalProfession.institution', {
                    url: '/institution',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/institution.html',
                            controller: 'institutionCtrl'
                        }
                    }
                })
                //规章制度end

                //内部公告start
                .state('index.externalProfession.internalAnnouncement', {
                    url: '/internalAnnouncement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/internalAnnouncement.html',
                            controller: 'intAnnounceCtrl'
                        }
                    }
                })
                //内部公告end


                //全部放行条开??
                .state('index.externalProfession.allarticleRelease', {
                    url: '/allarticleRelease',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allarticleRelease.html',
                            controller: 'allReleaseCtrl'
                        }
                    }
                })
                //全部放行条结??

                //全部车辆????
                .state('index.externalProfession.allVehicles', {
                    url: '/allVehicles',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allVehicles.html',
                            controller: 'allVehiclesCtrl'
                        }
                    }
                })
                //全部车辆结束

                //部门质检活动评分标准表新建开始
                .state('index.externalProfession.qualityScoremark', {
                    url: '/qualityScoremark',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityScoremark.html',
                            controller: 'qualityScoremarkCtrl'
                        }
                    }
                })
                //部门质检活动评分标准表新建结束


                //部门检查结果表开始
                .state('index.externalProfession.departChecktable', {
                    url: '/departChecktable',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departChecktable.html',
                            controller: 'departChecktableCtrl'
                        }
                    }
                })
                //部门检查结果表结束


                //全部待完成任务开始
                .state('index.externalProfession.allWaitingTask', {
                    url: '/allWaitingTask',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/allWaitingTask.html',
                            controller: 'allWaitingTaskCtrl'
                        }
                    }
                })
                //全部待完成任务结束

                //个人检查详情开始
                .state('index.externalProfession.personalCheckdetails', {
                    url: '/personalCheckdetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/personalCheckdetails.html',
                            controller: 'personalCheckdetailsCtrl'
                        }
                    }
                })
                //个人检查详情结束


                //添加部门质量????标准????
                .state('index.externalProfession.addDepartmentQuality', {
                    url: '/addDepartmentQuality',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/addDepartmentQuality.html',
                            controller: 'addDepartmentQualityCtrl'
                        }
                    }
                })
                .state('index.externalProfession.addDepartmentQuality.newDepartmentQuality', {
                    url: '/newDepartmentQuality',
                    templateUrl: 'page/externalProfession/addDepartmentQuality/newDepartmentQuality.html',
                    controller: 'newDepartmentQualityCtrl'
                })
                //添加部门质量????标准结束

                //添加质检标准????
                .state('index.externalProfession.addQuality', {
                    url: '/addQuality',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/addQuality.html',
                            controller: 'addQualityCtrl'
                        }
                    }
                })
                .state('index.externalProfession.addQuality.newQuality', {
                    url: '/newQuality',
                    templateUrl: 'page/externalProfession/addQuality/newQuality.html',
                    controller: 'newQualityCtrl'
                })
                //添加质检标准结束

                //部门质检模板新增和查看v3start
                .state('index.externalProfession.departmentQualityTemplet', {
                    url: '/departmentQualityTemplet',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentQualityTemplet.html',
                            controller: 'departmentQualityTempletCtrl'
                        }
                    }
                })
                .state('index.externalProfession.departmentQualityTemplet.allActivity', {
                    url: '/allActivity',
                    templateUrl: 'page/externalProfession/departmentQualityTemplet/allActivity.html',
                    controller: 'allActivityCtrl'
                })
                .state('index.externalProfession.departmentQualityTemplet.allTemplet', {
                    url: '/allTemplet',
                    templateUrl: 'page/externalProfession/departmentQualityTemplet/allTemplet.html',
                    controller: 'allTempletCtrl'
                })
                //部门质检模板新增和查看v3end


                //质检活动管理开始
                .state('index.externalProfession.qualityInspectionManagement', {
                    url: '/qualityInspectionManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityInspectionManagement.html',
                            controller: 'qualityInspectionManagementCtrl'
                        }
                    }
                })

                .state('index.externalProfession.qualityInspectionManagement.allActivities', {
                    url: '/allActivities',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allActivities.html',
                    controller: 'allActivitiesCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allTemplates', {
                    url: '/allTemplates',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allTemplates.html',
                    controller: 'allTemplatesCtrl'
                })
                //质检模版日，周，月
                .state('index.externalProfession.qualityInspectionManagement.allTemplates.dayTemplates', {
                    url: '/dayTemplates',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allTemplates/dayTemplates.html',
                    controller: 'dayTemplatesCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allTemplates.weekTemplates', {
                    url: '/weekTemplates',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allTemplates/weekTemplates.html',
                    controller: 'weekTemplatesCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allTemplates.biWeekTemplates', {
                    url: '/biWeekTemplates',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allTemplates/biWeekTemplates.html',
                    controller: 'biWeekTemplatesCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allTemplates.monthTemplates', {
                    url: '/monthTemplates',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allTemplates/monthTemplates.html',
                    controller: 'monthTemplatesCtrl'
                })

                //质检活动日，周，月
                .state('index.externalProfession.qualityInspectionManagement.allActivities.dayActivity', {
                    url: '/dayActivity',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allActivities/dayActivity.html',
                    controller: 'dayActivityCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allActivities.weekActivity', {
                    url: '/weekActivity',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allActivities/weekActivity.html',
                    controller: 'weekActivityCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allActivities.biWeekActivity', {
                    url: '/biWeekActivity',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allActivities/biWeekActivity.html',
                    controller: 'biWeekActivityCtrl'
                })
                .state('index.externalProfession.qualityInspectionManagement.allActivities.monthActivity', {
                    url: '/monthActivity',
                    templateUrl: 'page/externalProfession/qualityInspectionManagement/allActivities/monthActivity.html',
                    controller: 'monthActivityCtrl'
                })
                //质检活动管理结束


                //工单详情开始
                .state('index.externalProfession.workingSingleDetail', {
                    url: '/workingSingleDetail',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/workingSingleDetail.html',
                            controller: 'workingSingleDetailCtrl'
                        }
                    }
                })
                //工单详情结束

                //新建模版开始
                .state('index.externalProfession.newTemplate', {
                    url: '/newTemplate',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/newTemplate.html',
                            controller: 'newTemplateCtrl'
                        }
                    }
                })
                //新建模版结束

                //任务详情开始
                .state('index.externalProfession.taskDetails', {
                    url: '/taskDetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/taskDetails.html',
                            controller: 'taskDetailCtrl'
                        }
                    }
                })
                .state('index.externalProfession.taskDetails.quote', {
                    url: '/quote',
                    templateUrl: 'page/externalProfession/taskDetails/quote.html',
                    controller: 'quoteCtrl'
                })

                .state('index.externalProfession.taskDetails.taskQuoteEditor', {
                    url: '/taskQuoteEditor',
                    templateUrl: 'page/externalProfession/taskDetails/taskQuoteEditor.html',
                    controller: 'taskQuoteEditorCtrl'
                })

                .state('index.externalProfession.taskDetails.detection', {
                    url: '/detection',
                    templateUrl: 'page/externalProfession/taskDetails/detection.html',
                    controller: 'detectionCtrl'
                })
                .state('index.externalProfession.taskDetails.checkList', {
                    url: '/checkList',
                    templateUrl: 'page/externalProfession/taskDetails/checkList.html',
                    controller: 'taskQuoteEditorCtrl'
                })

                .state('index.externalProfession.taskDetails.handle', {
                    url: '/handle',
                    templateUrl: 'page/externalProfession/taskDetails/handle.html',
                    controller: 'handleCtrl'
                })

                //任务详情结束
                //新增质检活动开始
                .state('index.externalProfession.qualityinspectionactivity', {
                    url: '/qualityinspectionactivity',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityinspectionactivity.html',
                            controller: 'qualityinspectionactivityCtrl'
                        }
                    }
                })
                //新增质检活动结束

                //部门质检管理(服务请求)开始
                .state('index.externalProfession.departmentQualityManagementServiceRequest', {
                    url: '/departmentQualityManagementServiceRequest',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest.html',
                            controller: 'departmentQualityManagementServiceRequestCtrl'
                        }
                    }
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentQualityManagementServiceRequest', {
                    url: '/allDepartmentQualityManagementServiceRequest',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentQualityManagementServiceRequest.html',
                    controller: 'allDepartmentQualityManagementServiceRequestCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentsQualityInspectionTemplate', {
                    url: '/allDepartmentsQualityInspectionTemplate',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate.html',
                    controller: 'allDepartmentsQualityInspectionTemplateCtrl'
                })
                //质检模版日，周，月
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentsQualityInspectionTemplate.dayTemplates', {
                    url: '/dayTemplates',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/dayTemplates.html',
                    controller: 'dayTemplatesCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentsQualityInspectionTemplate.weekTemplates', {
                    url: '/weekTemplates',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/weekTemplates.html',
                    controller: 'weekTemplatesCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentsQualityInspectionTemplate.biWeekTemplates', {
                    url: '/biWeekTemplates',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/biWeekTemplates.html',
                    controller: 'biWeekTemplatesCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentsQualityInspectionTemplate.monthTemplates', {
                    url: '/monthTemplates',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentsQualityInspectionTemplate/monthTemplates.html',
                    controller: 'monthTemplatesCtrl'
                })

                //质检活动日，周，月
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentQualityManagementServiceRequest.dayActivity', {
                    url: '/dayActivity',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentQualityManagementServiceRequest/dayActivity.html',
                    controller: 'dayActivityCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentQualityManagementServiceRequest.weekActivity', {
                    url: '/weekActivity',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentQualityManagementServiceRequest/weekActivity.html',
                    controller: 'weekActivityCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentQualityManagementServiceRequest.biWeekActivity', {
                    url: '/biWeekActivity',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentQualityManagementServiceRequest/biWeekActivity.html',
                    controller: 'biWeekActivityCtrl'
                })
                .state('index.externalProfession.departmentQualityManagementServiceRequest.allDepartmentQualityManagementServiceRequest.monthActivity', {
                    url: '/monthActivity',
                    templateUrl: 'page/externalProfession/departmentQualityManagementServiceRequest/allDepartmentQualityManagementServiceRequest/monthActivity.html',
                    controller: 'monthActivityCtrl'
                })
                //部门质检管理(服务请求)结束
                //质检任务详情开始
                .state('index.externalProfession.qualityinspectiontaskdetails', {
                    url: '/qualityinspectiontaskdetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityinspectiontaskdetails.html',
                            controller: 'qualityinspectiontaskdetailsCtrl'
                        }
                    }
                })
                //质检任务详情结束

                //部门之间服务请求详情开始
                .state('index.externalProfession.departmentServiceRequestForDetails', {
                    url: '/departmentServiceRequestForDetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentServiceRequestForDetails.html',
                            controller: 'departmentServiceRequestForDetailsCtrl'
                        }
                    }
                })
            //部门之间服务请求详情结束
                //新增服务请求开始
                .state('index.externalProfession.newServiceRequest', {
                    url: '/newServiceRequest',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/newServiceRequest.html',
                            controller: 'newServiceRequestCtrl'
                        }
                    }
                })
                //新增服务请求结束

                //服务请求回访开始
                .state('index.externalProfession.qervicerequestreturnvisit', {
                    url: '/qervicerequestreturnvisit',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qervicerequestreturnvisit.html',
                            controller: 'qervicerequestreturnvisitCtrl'
                        }
                    }
                })
                //服务请求回访结束

                //部门质检活动新建V4开始
                .state('index.externalProfession.departmentInspectionActivitiesV4', {
                    url: '/departmentInspectionActivitiesV4',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentInspectionActivitiesV4.html',
                            controller: 'departmentInspectionActivitiesV4Ctrl'
                        }
                    }
                })
                //部门质检活动新建V4结束
                //部门质检全部活动查看V3开始
                .state('index.externalProfession.departmentOfQualityInspectionAllActivities', {
                    url: '/departmentOfQualityInspectionAllActivities',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentOfQualityInspectionAllActivities.html',
                            controller: 'departmentOfQualityInspectionAllActivitiesCtrl'
                        }
                    }
                })
                //部门质检全部活动查看V3结束


                //质检管理开始
                .state('index.externalProfession.qualityManagement', {
                    url: '/qualityManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/qualityManagement.html',
                            controller: 'qualityManagementCtrl'
                        }
                    }
                })
                // 质检管理结束


                //部门质检活动新建V3开始
                .state('index.externalProfession.departmentInspectionV3', {
                    url: '/departmentInspectionV3',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/departmentInspectionV3.html',
                            controller: 'departmentInspectionV3Ctrl'
                        }
                    }
                })
                // 部门质检活动新建V3结束


                //个人评分记录表开始
                .state('index.externalProfession.personalScoreRecord', {
                    url: '/personalScoreRecord',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/personalScoreRecord.html',
                            controller: 'personalScoreRecordCtrl'
                        }
                    }
                })

                .state('index.externalProfession.personalScoreRecord.page1', {
                    url: '/page1',
                    templateUrl: 'page/externalProfession/personalScoreRecord/page1.html',
                    controller: 'page1Ctrl'

                })

                .state('index.externalProfession.personalScoreRecord.page2', {
                    url: '/page2',
                    templateUrl: 'page/externalProfession/personalScoreRecord/page2.html',
                    controller: 'page2Ctrl'

                })

                .state('index.externalProfession.personalScoreRecord.page3', {
                    url: '/page3',
                    templateUrl: 'page/externalProfession/personalScoreRecord/page3.html',
                    controller: 'page3Ctrl'

                })
                // 个人评分记录表结束

                //模板详情开始
                .state('index.externalProfession.templateDetails', {
                    url: '/templateDetails',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/templateDetails.html',
                            controller: 'templateDetailsCtrl'
                        }
                    }
                })
                // 模板详情结束

                //消息管理开始
                .state('index.externalProfession.messageManagement', {
                    url: '/messageManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/messageManagement.html',
                            controller: 'messageManagementCtrl'
                        }
                    }
                })
                //消息管理结束
                //计费管理开始
                .state('index.externalProfession.accounting', {
                    url: '/accounting',
                    views: {
                        'main@index': {
                            templateUrl: 'page/externalProfession/accounting.html',
                            controller: 'accountingCtrl'
                        }
                    }
                })
                //物业管理费管理开始
                .state('index.externalProfession.accounting.propertyGeneralExpenses', {
                    url: '/propertyGeneralExpenses',
                    templateUrl: 'page/externalProfession/accounting/propertyGeneralExpenses.html',
                    controller: 'propertyGeneralExpensesCtrl'
                })
                .state('index.externalProfession.accounting.propertyGeneralExpenses.expenseEntering', {
                    url: '/expenseEntering',
                    templateUrl: 'page/externalProfession/accounting/propertyGeneralExpenses/expenseEntering.html',
                    controller: 'expenseEnteringCtrl'
                })
                .state('index.externalProfession.accounting.propertyGeneralExpenses.expensePlanEntering', {
                    url: '/expensePlanEntering',
                    templateUrl: 'page/externalProfession/accounting/propertyGeneralExpenses/expensePlanEntering.html',
                    controller: 'expensePlanEnteringCtrl'
                })
                //物业管理费管理结束
                //计费管理结束

                //外部专业线end



                //内部专业线start
                .state('index.internalProfession', {
                    url: '/internalProfession',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/index.html',
                            controller: 'intCtrl'
                        }
                    }
                })
                .state('index.internalProfession.propertyManagementContract', {
                    url: '/propertyManagementContract',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyManagementContract.html',
                            controller: 'contractCtrl'
                        }
                    }
                })

                //【售后管理??
                .state('index.internalProfession.customerServiceManagement', {
                    url: '/customerServiceManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/customerServiceManagement.html',
                            controller: 'customerServiceManagementCtrl'
                        }
                    }
                })
                //【售后管理??end

                //【任务类型设置??
                .state('index.internalProfession.taskSet', {
                    url: '/taskSet',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/taskSet.html',
                            controller: 'taskSetCtrl'
                        }
                    }
                })

                //【任务类型设置??清洁
                .state('index.internalProfession.taskSet.clean', {
                    url: '/clean',
                    templateUrl: 'page/internalProfession/taskSet/clean.html',
                    controller: 'cleanCtrl'
                })
                //【任务类型设置??end

                //【任务类型设置??园林
                .state('index.internalProfession.taskSet.gardens', {
                    url: '/gardens',
                    templateUrl: 'page/internalProfession/taskSet/gardens.html',
                    controller: 'gardensCtrl'
                })
                //【任务类型设置??end

                //【任务类型设置??维修
                .state('index.internalProfession.taskSet.repair', {
                    url: '/repair',
                    templateUrl: 'page/internalProfession/taskSet/repair.html',
                    controller: 'repairCtrl'
                })
                //【任务类型设置??end

                //【任务类型设置??保安
                .state('index.internalProfession.taskSet.security', {
                    url: '/security',
                    templateUrl: 'page/internalProfession/taskSet/security.html',
                    controller: 'securityCtrl'
                })
                //【任务类型设置??end

                //【任务类型设置??索赔
                .state('index.internalProfession.taskSet.claims', {
                    url: '/claims',
                    templateUrl: 'page/internalProfession/taskSet/claims.html',
                    controller: 'claimsSetCtrl'
                })
                //【任务类型设置??end


                //【任务类型设置??索赔
                .state('index.internalProfession.taskSet.majorIssues', {
                    url: '/majorIssues',
                    templateUrl: 'page/internalProfession/taskSet/majorIssues.html',
                    controller: 'majorIssuesCtrl'
                })
                //【任务类型设置??end


                //房型初始化start
                .state('index.internalProfession.initialization', {
                    url: '/initialization',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/initialization.html',
                            controller: 'initializationCtrl'
                        }
                    }
                })
                .state('index.internalProfession.initialization.houseAdd', {
                    url: '/houseAdd',
                    templateUrl: 'page/internalProfession/initialization/houseAdd.html',
                    controller: 'houseAddCtrl'

                })

                .state('index.internalProfession.initialization.houseSelect', {
                    url: '/houseSelect',
                    templateUrl: 'page/internalProfession/initialization/houseSelect.html',
                    controller: 'houseSelectCtrl'

                })

                .state('index.internalProfession.initialization.areaMaintain', {
                    url: '/areaMaintain',
                    templateUrl: 'page/internalProfession/initialization/areaMaintain.html',
                    controller: 'areaMaintainCtrl'

                })
                //房型初始化end

                .state('index.internalProfession.vacationManagement', {
                    url: '/vacationManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/vacationManagement.html',
                            controller: 'vacationCtrl'
                        }
                    }
                })
                .state('index.internalProfession.customerManagement', {
                    url: '/customerManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/customerManagement.html',
                            controller: 'customerCtrl'
                        }
                    }
                })

                //产品管理start
                .state('index.internalProfession.productManagement', {
                    url: '/productManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/productManagement.html',
                            controller: 'productCtrl'
                        }
                    }
                })
                .state('index.internalProfession.productManagement.productLaunch', {
                    url: '/productLaunch',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/productManagement/productLaunch.html',
                            controller: 'productLaunchCtrl'
                        }
                    }
                })
                .state('index.internalProfession.productManagement.productInformation', {
                    url: '/productInformation',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/productManagement/productInformation.html',
                            controller: 'productInCtrl'
                        }
                    }
                })
                //产品管理end

                .state('index.internalProfession.enterpriseNews', {
                    url: '/enterpriseNews',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/enterpriseNews.html',
                            controller: 'entNewsCtrl'
                        }
                    }
                })

                //合同初始化开
                .state('index.internalProfession.contractInitialization', {
                    url: '/contractInitialization',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/contractInitialization.html',
                            controller: 'contractInitializationCtrl'
                        }
                    }
                })

                .state('index.internalProfession.contractInitialization.addContractone', {
                    url: '/addContractone',
                    templateUrl: 'page/internalProfession/contractInitialization/addContractone.html',
                    controller: 'addContractCtrl'
                })

                .state('index.internalProfession.contractInitialization.contractCheck', {
                    url: '/contractCheck',
                    templateUrl: 'page/internalProfession/contractInitialization/contractCheck.html',
                    controller: 'contractCheckCtrl'
                })

                //合同初始化结束

                //房屋与合同初始化start
                .state('index.internalProfession.relationshipInitialize', {
                    url: '/relationshipInitialize',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/relationshipInitialize.html',
                            controller: 'relationshipInitializeCtrl'
                        }
                    }
                })
                .state('index.internalProfession.relationshipInitialize.addProfessional', {
                    url: '/addProfessional',
                    templateUrl: 'page/internalProfession/relationshipInitialize/addProfessional.html',
                    controller: 'addProfessionalCtrl'

                })
                .state('index.internalProfession.relationshipInitialize.addProperty', {
                    url: '/addProperty',
                    templateUrl: 'page/internalProfession/relationshipInitialize/addProperty.html',
                    controller: 'addPropertyCtrl'

                })
                .state('index.internalProfession.relationshipInitialize.queryProperty', {
                    url: '/queryProperty',
                    templateUrl: 'page/internalProfession/relationshipInitialize/queryProperty.html',
                    controller: 'queryPropertyCtrl'

                })
                //房屋与合同初始化end

                .state('index.internalProfession.builder', {
                    url: '/builder',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/builder.html',
                            controller: 'builderCtrl'
                        }
                    }
                })
                .state('index.internalProfession.developer', {
                    url: '/developer',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/developer.html',
                            controller: 'developerCtrl'
                        }
                    }
                })

                //入伙初始化开??
                .state('index.internalProfession.joinGangInstitution', {
                    url: '/joinGangInstitution',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/joinGangInstitution.html',
                            controller: 'joinGangInstitutionCtrl'
                        }
                    }
                })

                .state('index.internalProfession.joinGangInstitution.newActivity', {
                    url: '/newActivity',
                    templateUrl: 'page/internalProfession/joinGangInstitution/newActivity.html',
                    controller: 'newActivityCtrl'

                })

                .state('index.internalProfession.joinGangInstitution.historyActivity', {
                    url: '/historyActivity',
                    templateUrl: 'page/internalProfession/joinGangInstitution/historyActivity.html',
                    controller: 'historyActivityCtrl'

                })


                .state('index.internalProfession.joinGangInstitution.institutionNext02', {
                    url: '/institutionNext02',
                    templateUrl: 'page/internalProfession/joinGangInstitution/institutionNext02.html',
                    controller: 'institutionNext02Ctrl'

                })
                .state('index.internalProfession.joinGangInstitution.detailHouse', {
                    url: '/detailHouse',
                    templateUrl: 'page/internalProfession/joinGangInstitution/detailHouse.html',
                    controller: 'detailHouseCtrl'

                })
                .state('index.internalProfession.joinGangInstitution.institutionNext03', {

                    url: '/institutionNext03',
                    templateUrl: 'page/internalProfession/joinGangInstitution/institutionNext03.html',
                    controller: 'institutionNext03Ctrl'

                })
                .state('index.internalProfession.joinGangInstitution.institutionNext04', {
                    url: '/institutionNext04',

                    templateUrl: 'page/internalProfession/joinGangInstitution/institutionNext04.html',
                    controller: 'institutionNext04Ctrl'

                })

                //入伙初始化结


                //内部服务请求
                .state('index.internalProfession.ServiceRequest', {
                    url: '/ServiceRequest',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/ServiceRequest.html',
                            controller: 'ServiceRequestCtrl'
                        }
                    }
                })
                //添加服务请求
                .state('index.internalProfession.ServiceRequest.ServiceAdd', {
                    url: '/ServiceAdd',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/ServiceRequest/ServiceAdd.html',
                            controller: 'ServiceAddCtrl'
                        }
                    }
                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck', {
                    url: '/ServiceCheck',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck.html',
                            controller: 'ServiceCheckCtrl'
                        }
                    }
                })
                //查看内导航开??
                .state('index.internalProfession.ServiceRequest.ServiceCheck.balanceordertolerance', {
                    url: '/balanceordertolerance',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/balanceordertolerance.html',
                    controller: 'balanceordertoleranceCtrl'

                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck.checkordertolerance', {
                    url: '/checkordertolerance',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/checkordertolerance.html',
                    controller: 'checkordertoleranceCtrl'

                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck.handleordertolerance', {
                    url: '/handleordertolerance',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/handleordertolerance.html',
                    controller: 'handleordertoleranceCtrl'

                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck.journal', {
                    url: '/journal',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/journal.html',
                    controller: 'journalCtrl'

                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck.ordertolerance', {
                    url: '/ordertolerance',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/ordertolerance.html',
                    controller: 'ordertoleranceCtrl'

                })
                .state('index.internalProfession.ServiceRequest.ServiceCheck.quoteordertolerance', {
                    url: '/quoteordertolerance',

                    templateUrl: 'page/internalProfession/ServiceRequest/ServiceCheck/quoteordertolerance.html',
                    controller: 'quoteordertoleranceCtrl'

                })
                //查看内导航开始结??
                //内部服务请求结束
                //合同管理????
                .state('index.internalProfession.contractManagement', {
                    url: '/contractManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/contractManagement.html',
                            controller: 'contractManagementCtrl'
                        }
                    }
                })
                .state('index.internalProfession.contractManagement.newContract', {
                    url: '/newContract',

                    templateUrl: 'page/internalProfession/contractManagement/newContract.html',
                    controller: 'newContractCtrl'

                })
                .state('index.internalProfession.contractManagement.contractInquiry', {
                    url: '/contractInquiry',

                    templateUrl: 'page/internalProfession/contractManagement/contractInquiry.html',
                    controller: 'contractInquiryCtrl'

                })
                //合同管理结束


                //内部专业线??专业资产初始化??
                .state('index.internalProfession.majorAssetInitialization', {
                    url: '/majorAssetInitialization',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/majorAssetInitialization.html',
                            controller: 'majorAssetCtrl'
                        }
                    }
                })

                //【专业资产初始化】新增专??
                .state('index.internalProfession.majorAssetInitialization.newProfessional', {
                    url: '/newProfessional',
                    templateUrl: 'page/internalProfession/majorAssetInitialization/newProfessional.html',
                    controller: 'newProfessionalCtrl'
                })
                //【专业资产初始化】新增资??
                .state('index.internalProfession.majorAssetInitialization.newAssets', {
                    url: '/newAssets',
                    templateUrl: 'page/internalProfession/majorAssetInitialization/newAssets.html',
                    controller: 'newAssetsCtrl'
                })
                //【专业资产初始化】查询资??
                .state('index.internalProfession.majorAssetInitialization.queryAssets', {
                    url: '/queryAssets',
                    templateUrl: 'page/internalProfession/majorAssetInitialization/queryAssets.html',
                    controller: 'queryAssetsCtrl'
                })

                //内部专业线??专业资产初始化??end
                //项目建筑分区start
                .state('index.internalProfession.projectbuildpartition', {
                    url: '/projectbuildpartition',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/projectbuildpartition.html',
                            controller: 'projectbuildpartitionCtrl'
                        }
                    }
                })
                .state('index.internalProfession.projectbuildpartition.ruleAdd', {
                    url: '/ruleAdd',
                    templateUrl: 'page/internalProfession/projectbuildpartition/ruleAdd.html',
                    controller: 'ruleAddCtrl'
                })
                .state('index.internalProfession.projectbuildpartition.ruleCheck', {
                    url: '/ruleCheck',
                    templateUrl: 'page/internalProfession/projectbuildpartition/ruleCheck.html',
                    controller: 'ruleCheckCtrl'
                })
                //项目建筑分区end

                //内部专业线项目团队管理
                .state('index.internalProfession.projectManagementTeam', {
                    url: '/projectManagementTeam',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/projectManagementTeam.html',
                            controller: 'projectTeamCtrl'
                        }
                    }
                })

                //【项目团队管理查询项目
                .state('index.internalProfession.projectManagementTeam.checkProject', {
                    url: '/checkProject',
                    templateUrl: 'page/internalProfession/projectManagementTeam/checkProject.html',
                    controller: 'checkProjectCtrl'
                })

                .state('index.internalProfession.projectManagementTeam.search', {
                    url: '/search',
                    templateUrl: 'page/internalProfession/projectManagementTeam/search.html',
                    controller: 'searchCtrl'
                })

                //【项目团队管理查询人员
                .state('index.internalProfession.projectManagementTeam.checkPerson', {
                    url: '/checkPerson',
                    templateUrl: 'page/internalProfession/projectManagementTeam/checkPerson.html',
                    controller: 'checkPersonCtrl'
                })

                // 项目建筑初始化start
                .state('index.internalProfession.projectConstruction', {
                    url: '/projectConstruction',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/projectConstruction.html',
                            controller: 'projectConstructionCtrl'
                        }
                    }
                })


                .state('index.internalProfession.projectConstruction.newProjectConstruction', {
                    url: '/newProjectConstruction',
                    templateUrl: 'page/internalProfession/projectConstruction/newProjectConstruction.html',
                    controller: 'newProjectConstructionCtrl'
                })

                .state('index.internalProfession.projectConstruction.projectConstructionInquiry', {
                    url: '/projectConstructionInquiry',
                    templateUrl: 'page/internalProfession/projectConstruction/projectConstructionInquiry.html',
                    controller: 'projectConstructionInquiryCtrl'
                })
                // 项目建筑初始化end

                //我的团队(专业)start
                .state('index.internalProfession.myTeamProfession', {
                    url: '/myTeamProfession',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/myTeamProfession.html',
                            controller: 'myTeamProfessionCtrl'
                        }
                    }
                })
                //我的团队(专业)end


                //我的团队(项目经理)start
                .state('index.internalProfession.myTeamProjectManager', {
                    url: '/myTeamProjectManager',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/myTeamProjectManager.html',
                            controller: 'myTeamProjectManagerCtrl'
                        }
                    }
                })
                //我的团队(项目经理)end

                //施工管理start
                .state('index.internalProfession.constructionSupervision', {
                    url: '/constructionSupervision',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/constructionSupervision.html',
                            controller: 'constructionSupervisionCtrl'
                        }
                    }
                })

                //办理授权start
                .state('index.internalProfession.constructionSupervision.licensing', {
                    url: '/licensing',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing.html',
                    controller: 'licensing01Ctrl'
                })
                .state('index.internalProfession.constructionSupervision.licensing.constructApply', {
                    url: '/constructApply',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructApply.html',
                    controller: 'apply01Ctrl'
                })
                .state('index.internalProfession.constructionSupervision.licensing.constructExamine', {
                    url: '/constructExamine',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructExamine.html',
                    controller: 'examine01Ctrl'
                })
                //施工过程????
                .state('index.internalProfession.constructionSupervision.licensing.constructCourse', {
                    url: '/constructCourse',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructCourse.html',
                    controller: 'course01Ctrl'
                })
                .state('index.internalProfession.constructionSupervision.licensing.constructCourse.defaultFine', {
                    url: '/defaultFine',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructCourse/defaultFine.html',
                    controller: 'defaultFine01Ctrl'
                })
                .state('index.internalProfession.constructionSupervision.licensing.constructCourse.rectificationNotice', {
                    url: '/rectificationNotice',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructCourse/rectificationNotice.html',
                    controller: 'rectificationNotice01Ctrl'
                })
                //施工过程结束
                .state('index.internalProfession.constructionSupervision.licensing.constructAccepts', {
                    url: '/constructAccepts',
                    templateUrl: 'page/internalProfession/constructionSupervision/licensing/constructAccepts.html',
                    controller: 'accepts01Ctrl'
                })
                //办理授权end

                .state('index.internalProfession.constructionSupervision.historicRecords', {
                    url: '/historicRecords',
                    templateUrl: 'page/internalProfession/constructionSupervision/historicRecords.html',
                    controller: 'historic01Ctrl'
                })
                //施工管理end
                //人员管理????
                .state('index.internalProfession.staffsuperviseIT', {
                    url: '/staffsuperviseIT',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/staffsuperviseIT.html',
                            controller: 'staffsuperviseITCtrl'
                        }
                    }
                })
                .state('index.internalProfession.staffsuperviseIT.staffsuperviseITAdd', {
                    url: '/staffsuperviseITAdd',
                    templateUrl: 'page/internalProfession/staffsuperviseIT/staffsuperviseITAdd.html',
                    controller: 'staffsuperviseITAddCtrl'
                })
                .state('index.internalProfession.staffsuperviseIT.staffsuperviseITCheck', {
                    url: '/staffsuperviseITCheck',
                    templateUrl: 'page/internalProfession/staffsuperviseIT/staffsuperviseITCheck.html',
                    controller: 'staffsuperviseITCheckCtrl'
                })
                //人员管理结束

                //项目人员管理设置????
                .state('index.internalProfession.projectmanagementpersonnell', {
                    url: '/projectmanagementpersonnell',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/projectmanagementpersonnell.html',
                            controller: 'projectmanagementpersonnellCtrl'
                        }
                    }
                })
                //项目人员管理设置结束
                //专业线管理开??
                .state('index.internalProfession.professionallinemanagement', {
                    url: '/professionallinemanagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/professionallinemanagement.html',
                            controller: 'professionallinemanagementCtrl'
                        }
                    }
                })
                //专业线管理结??
                //公司组织架构????
                .state('index.internalProfession.organizationalstructure', {
                    url: '/organizationalstructure',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/organizationalstructure.html',
                            controller: 'organizationalstructureCtrl'
                        }
                    }
                })
                //公司组织架构结束

                //人员管理设置开始
                .state('index.internalProfession.personnelManagement', {
                    url: '/personnelManagement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/personnelManagement.html',
                            controller: 'personnelManagementCtrl'
                        }
                    }
                })
                //人员管理设置结束

                //岗位人员配置开始
                .state('index.internalProfession.postPersonnelConfiguration', {
                    url: '/postPersonnelConfiguration',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/postPersonnelConfiguration.html',
                            controller: 'postPersonnelConfigurationCtrl'
                        }
                    }
                })
                //岗位人员配置结束

                //员工录入开始
                .state('index.internalProfession.employeeInput', {
                    url: '/employeeInput',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/employeeInput.html',
                            controller: 'employeeInputCtrl'
                        }
                    }
                })
                //员工录入结束

                //项目初始化开始
                .state('index.internalProfession.projectInitialization', {
                    url: '/projectInitialization',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/projectInitialization.html',
                            controller: 'projectInitializationCtrl'
                        }
                    }
                })
                //项目初始化结束

                //组织结构开始
                .state('index.internalProfession.organizationStructure', {
                    url: '/organizationStructure',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/organizationStructure.html',
                            controller: 'organizationStructureCtrl'
                        }
                    }
                })
                //组织结构结束
                //权限角色开始
                .state('index.internalProfession.authorizationRole', {
                    url: '/authorizationRole',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/authorizationRole.html',
                            controller: 'authorizationRoleCtrl'
                        }
                    }
                })
                //权限角色结束

                //内部专业线云平台物业实例主页
                .state('index.internalProfession.propertyInstancepage', {
                    url: '/propertyInstancepage',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstancepage.html',
                            controller: 'propertyInstancepageCtrl'
                        }
                    }
                })
                //内部专业线云平台物业实例主页结束

                //内部专业线云平台物业实例查询开始
                .state('index.internalProfession.propertyInstanceCheck', {
                    url: '/propertyInstanceCheck',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstanceCheck.html',
                            controller: 'propertyInstanceCheckCtrl'
                        }
                    }
                })
                //内部专业线云平台物业实例查询结束

                //内部专业线云平台物业实例创建开始
                .state('index.internalProfession.propertyInstanceCreate', {
                    url: '/propertyInstanceCreate',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstanceCreate.html',
                            controller: 'propertyInstanceCreateCtrl'
                        }
                    }
                })

                .state('index.internalProfession.propertyInstanceCreate.choosePost', {
                    url: '/choosePost',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstanceCreate/choosePost.html',
                            controller: 'choosePostCtrl'
                        }
                    }
                })

                .state('index.internalProfession.propertyInstanceCreate.personSet', {
                    url: '/personSet',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstanceCreate/personSet.html',
                            controller: 'personSetCtrl'
                        }
                    }
                })

                .state('index.internalProfession.propertyInstanceCreate.projectInitialization', {
                    url: '/projectInitialization',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/propertyInstanceCreate/projectInitialization.html',
                            controller: 'projectInitializationCtrl'
                        }
                    }
                })
                //内部专业线云平台物业实例创建结束

                //内部专业线个人成就开始
                .state('index.internalProfession.achievement', {
                    url: '/achievement',
                    views: {
                        'main@index': {
                            templateUrl: 'page/internalProfession/achievement.html',
                            controller: 'achievementCtrl'
                        }
                    }
                })
                //内部专业线个人成就结束



                //内部专业线end

                //商业智能start
                .state('index.business', {
                    url: '/business',
                    views: {
                        'main@index': {
                            templateUrl: 'page/business/index.html',
                            controller: 'busCtrl'
                        }
                    }
                })
            //商业智能end
        });
        return module;
    });
})();