/**
 * Created by Administrator on 2015/4/13 房屋信息车位管理
 */
/**
 * 修改人:ruanmeixing 修改时间:2015-05-29 内部专业线_车位管理
 * 
 * 修改人：肖聪  2015/6/4   
 * 添加产权变更相关的方法
 */
define([ 'tyjApp', 'pageServices' ], function(module) {
	module.controller("parkManCtrl", function($scope, $http, $rootScope) {

		/**
		 * 业主id,将从授权管理中获取,先测试数据为1
		 */
		var personId = 3;
		var url = $rootScope.url;
        $scope.PersonCust = {};//人员对象
        $scope.n = 3;
        $scope.alls = [ {} ];//保存选取的人员信息数组对象
        $scope.alls1 = [ {} ];//
        $scope.addChangeTitle={};

        /**
         * 创建 by 肖聪 2015/6/4
         *  查询被授权人被授权了的车位
         */
        $http.get(url+'/Authorization/getAuthorizedbyIdLeaseAndStall/'+personId).success(function(data) {
            $scope.carPark=data.Authorization;
            console.log("Confidence Winphone");
            console.log($scope.carPark);
            alert("车位信息获取成功");
            //将所得结果集合中，授权人相同 的对象remove，只留下一条记录，来获得相应授权人授权的车位
            for(var i=0;i<$scope.carPark.length;i++){
                for(var j=0;j<$scope.carPark.length;j++){
                    if(i==j){
                        continue;
                    }
                    if($scope.carPark[i].authorizerPersonid==$scope.carPark[j].authorizerPersonid){
                        $scope.carPark[j]={};
                    }
                }console.log($scope.carPark);
            }
        }).error(function(data, status, headers, config){
            alert("房屋信息获取失败");
        }) ;

        /**
         * 通过人员信息条件搜索人员
         */
        $scope.selectPersonBycustId = function() {
            $http.post(
                url + '/PersonCust/listAllPersonCustRestfulone', {
                    PersonCust : $scope.PersonCust
                })
                .success(function(data) {
                    $scope.personCust1 = data.PersonCust;
                    console.log($scope.personCust1);
                    alert("人员信息获取成功");
                }).error(
                function(data, status, headers, config) {
                    alert("人员信息获取失败");
                });
        };

        /**
         * 通过人员id获取人员对象
         */
        $scope.getPersonBycustId = function(id) {
            var addNewLease = {};
            $http.get(url + '/PersonCust/getPersonCustByIdRestfulone/' + id)
                .success(function(data) {
                    $scope.personCust2=data.PersonCust;
                    console.log($scope.personCust2);
                    alert("人员信息注入成功");
                }).error(
                function(data, status, headers, config) {
                    alert("人员信息注入失败");
                });
        };
        /**
         * 通过人员id获取人员对象
         */
        $scope.insertNewLease = function() {
          $scope.post(url+'/ChangeTitle/insertChangeTitleRestful/',{ChangeTitle:$scope.addChangeTitle}).success(function()
          {

              alert("修改成功");
          }).error(function(data, status, headers, config){
              alert("修改失败");
          }) ;

        };

        /**
         * 取消数据
         */
        $scope.clear = function() {
            $scope.house1 = {};
            $scope.addNewLease = {};
            $scope.alls.splice(1, $scope.alls.length - 1);
        };

	});
});