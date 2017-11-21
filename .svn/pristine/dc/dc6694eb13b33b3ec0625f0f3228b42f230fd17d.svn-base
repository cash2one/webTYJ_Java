/**
 * Created by 彭婷婷 on 2015/4/13.
 * 修改人：李斌
 * 修改时间：2015/6/8
 *
 */

'use strict';
define(['tyjApp','pageServices'],function(module){
    module.controller("empowerCtrl",function($scope,$http,Paginator,$rootScope){
    	var url = $rootScope.url;
    	
    	//全选判定
    	$scope.all=false; 
        
    	$scope.checkAll=function(){
    		if($scope.all){
        		$scope.addAuthorization.accessCard=1; //门禁卡(0)否 1 是
        		$scope.addAuthorization.vehicle=1; //车辆登记
        		$scope.addAuthorization.parkingCard=1; //停车卡
        		$scope.addAuthorization.carportManage=1; //车位管理
        		$scope.addAuthorization.ropertyChanges=1; //产权变更
        		$scope.addAuthorization.lease=1;  //租赁
        		$scope.addAuthorization.articleRelease=1; //放行条
        		$scope.addAuthorization.decorate=1;  //装修
        		$scope.addAuthorization.partnership=1;  //入伙
        		/*$scope.addAuthorization.entrance=1;//门禁卡
*/        	}
    		else{
    			  $scope.addAuthorization.accessCard=0; //门禁卡(0)否 1 是
        		  $scope.addAuthorization.vehicle=0; //车辆登记
        		  $scope.addAuthorization.parkingCard=0; //停车卡
        		  $scope.addAuthorization.carportManage=0; //车位管理
        		  $scope.addAuthorization.ropertyChanges=0; //产权变更
        		  $scope.addAuthorization.lease=0;  //租赁
        		  $scope.addAuthorization.articleRelease=0; //放行条
        		  $scope.addAuthorization.decorate=0;  //装修
        		  $scope.addAuthorization.partnership=0;  //入伙
        		  $scope.addAuthorization.entrance=0;//门禁卡
    			}
    	};
    	
    	
    	//测试复选框的内容值
    	$scope.testCheckbox=function(){
    		console.log($scope.all);
    		console.log($scope.addAuthorization.vehicle);
    		console.log($scope.addAuthorization.accessCard);
    		console.log($scope.addAuthorization.parkingCard);
    		console.log($scope.addAuthorization.carportManage);
    		console.log($scope.addAuthorization.ropertyChanges);
    		console.log($scope.addAuthorization.lease);
    		console.log($scope.addAuthorization.articleRelease);
    		console.log($scope.addAuthorization.decorate);
    		console.log($scope.addAuthorization.partnership);
    		console.log($scope.addAuthorization.authorizationType);
    		console.log($scope.addAuthorization.staDate);
    		console.log($scope.addAuthorization.endDate);
    	};
    	
    	//通过条件搜索人或者资产
    	$scope.search={};
    	$scope.search.staff=false;
		$scope.search.property=false;
    	$scope.selectHouseAndPerson=function(){
    		
    		/*$scope.search.staff=true;
			$scope.search.property=true;*/
    		$http.post(url + '/PersonCustNew/propertyServiceSearch',{Search:$scope.search}).success(function(data)
        			{
    			
        			   console.log("搜索请求成功");
        			   $scope.propertyService=data.propertyService;
        			   console.log("显示搜索结果");
                 	   console.log($scope.propertyService);
        			   $scope.persons= $scope.propertyService.personCusts;
        			   $scope.houses=$scope.propertyService.houses;        			     
        			});
    	};
    	
    	//选中人员
    	$scope.personone={};
    	$scope.choicePerson=function(person){
    		$scope.personone=person;
    		console.log($scope.personone);
    		$scope.addAuthorization.authorizerPersonid=$scope.personone.custId;
    	};
    	
    	//选中房屋
    	$scope.houseone={};   	
    	$scope.choiceHouse=function(house){
    		console.log("点击房屋事件");
    		
    		$scope.houseone=house;
    		console.log($scope.houseone); 
    		$scope.addAuthorization.houseId=$scope.houseone.id;
    		console.log($scope.addAuthorization.houseId);
    	};
    	
    	//取消数据增加
    	$scope.resetAuthorization=function(){
    		$scope.propertyService={};
    		$scope.search={};
    		$scope.houseone={};
    		$scope.personone={};
    		 console.log("重置成功");
    	};
    	
    	//添加授权信息
    	$scope.addAuthorization={};
    	
    	$scope.addAuthorizationone=function(){
    		$scope.addAuthorization.authorizedPersonid="1";
    		console.log($scope.addAuthorization);
    		$http.post(url+'/Authorization/AddAuthorization',{Authorization:$scope.addAuthorization}).success(function()
    	 	        {   	        	
    	 	    	  console.log("添加授权成功");
    	 	          }).error(function(data, status, headers, config){
    	 	        	 console.log("添加授权失败");
    	 		     }) ;
    	};
    	
    	
    	//测试计算年龄
    	$scope.getAge=function(){
    		var a=new Date();
    		console.log(a.getFullYear().toString());
    		console.log($scope.perosonage.birthday);
    		var str =$scope.perosonage.birthday;
    		/*str = str.replace(/-/g,"/");*/
    		console.log(str); 
    		var date = new Date(str);
    		console.log(date.getFullYear());
    		var age = a.getFullYear()- date.getFullYear();
    		console.log(age);
    	};
    
    	//测试放行条
    
    	$scope.test=function(){
    		
    		/*var a={};
    		a.houseId="666666";
    		a.custId="6";
    		a.personId="7";
    		a.enterpriseId="99999";
    		a.customerType=1;
    		a.item=[{number:"77777777"}];
    		$http.post(url+'/ArticleRelease/insertArticleRelease',{ArticleRelease:a}).success(function()
    	 	        {   	        	
    	 	    	  console.log("添加授权成功");
    	 	          }).error(function(data, status, headers, config){
    	 	        	 console.log("添加授权失败");
    	 		     }) ;*/	
    		var a={};
    		a.custId="3";
    		
    		
    		$http.post(url+'/ChangeTitle/insertChangeTitleRestful',{ChangeTitle:a}).success(function(data)
    	 	        {   	        	
    	 	    	  console.log("查询成功");
    	 	    	 console.log(data);
    	 	          }).error(function(data, status, headers, config){
    	 	        	 console.log("查询失败");
    	 		     })
    	 		     
    	 		     $http.get(url+'/PersonCustNew/getPersonCustNewByIdRestful/'+1).success(function(data)
    	 	        { 
    	 		    	 $scope.perosonage=data.PersonCustNew;
    	 	    	  console.log("查询成功");
    	 	    	 console.log(data);
    	 	          }).error(function(data, status, headers, config){
    	 	        	 console.log("查询失败");
    	 		     })
    			
    	};
    	
    	
    });
});

/*define(['tyjApp'],function(module){
    module.controller("empowerCtrl",function($scope,$upload,$rootScope,$http){


        var url = $rootScope.url;
        *//**
         * 通过人员信息条件搜索人员
         *//*

        $scope.selectPersonBycustId = function() {
            $http
                .post(
                url
                + '/PersonCust/listAllPersonCustRestfulone',
                {
                    PersonCust : $scope.PersonCust
                })
                .success(
                function(data) {
                    $scope.personCust1 = data.PersonCust;
                    console
                        .log($scope.personCust1);
                    alert("人员信息获取成功");
                }).error(
                function(data, status,
                         headers, config) {
                    alert("人员信息获取失败");
                });
        };

        <!--实现全选/反选功能-->
        $scope.checkAll=function(){
            var allCheckBoxs=document.getElementsByName("isBuy");
            for(var i = 0; i<allCheckBoxs.length;i++)
            {
                if(allCheckBoxs[i].type="checkbox")
                {
                    if(allCheckBoxs[i].checked==true){
                        allCheckBoxs[i].checked=false;
                    }else if(allCheckBoxs[i].checked==false){
                        allCheckBoxs[i].checked=true;
                    }
                }
            }
        };




        //var url = $rootScope.url;
    	
    	var file =null;  //保存上传的文件
   	 $scope.onFileSelect = function($files) {    //$files: an array of files selected, each file has name, size, and type.
   		 
   		 for (var i = 0; i < $files.length; i++) {      
   		    	file = $files[i];
   		    	alert(file);
   		    }   
   		  };
   		  
   		  
   		$scope.authorization={}; // 授权对象
   		$scope.addAuthorization= function(){
   			$scope.authorization.authorizedPersonid=1;  //设置被授权人id
   			$scope.authorization.authorizerPersonid=2;  //设置授权人id
   			$scope.authorization.houseId=8;  //设置资产id
   		   $scope.upload = $upload.upload({
		    	  url:'../Authorization/addAuthorization.do', //upload.php script, node.js route, or servlet url
		          method: 'POST' ,
		        //headers: {'header-key': 'header-value'},
		        //withCredentials: true,
		        data: {Authorization: $scope.authorization},
		        file: file // or list of files ($files) for html5 only
		        //fileName: 'doc.jpg' or ['1.jpg', '2.jpg', ...] // to modify the name of the file(s)
		        // customize file formData name ('Content-Disposition'), server side file variable name. 
		        //fileFormDataName: myFile, //or a list of names for multiple files (html5). Default is 'file' 
		        // customize how data is added to formData. See #40#issuecomment-28612000 for sample code
		        //formDataAppender: function(formData, key, val){}
		      }).progress(function(evt) {        console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
		      }).success(function(data, status, headers, config) {        // file is uploaded successfully
		        console.log(data);
		      });  
   			
   		};
   	   
    });
});/**
 * Created by Administrator on 2015/4/23.
 */
