/**
 * Created by Administrator on 2015/4/20.
 * 产品管理
 */

'use strict';

/**
 * 内产专业线_产品管理
 * 
 * 修改时间:2015-05-28
 * 
 * 修改人:阮枚星
 */
define(['tyjApp',
        'controllers/internalProfession/productManagement/productLaunch',
        'controllers/internalProfession/productManagement/productInformation',
        'pageServices'
    ],
    function(module){
        module.controller("productCtrl",function($scope,$http,Paginator,$rootScope){
        	//获取路径
        	var url = $rootScope.url;
    	    $scope.Produceprice={page:{}};
    		
    		var fetchFunction = function(page,callback) {
        		$scope.Produceprice.page=page;
                $http.post(url + '/Produceprice/listPageProduceprice',{Produceprice:$scope.Produceprice}).success(callback);
            };  
    		$scope.searchPaginator=Paginator(fetchFunction,8);
    		
    		
    		
    		$scope.GetProduceprice=function(productId){
    			console.log(productId);
    			if(productId!=0)
    			{
    				$http.get(url + '/Produceprice/getProducepriceById/'+productId).success(function(data) {
    					console.log(data);
    					
    			        $scope.produceprice = data.Produceprice;
    			      
    				  });
    			}
    		  
    		};
    		
    		$scope.updateStatebyId=function(productId){
    			$http.get(url + '/Produceprice/UpdateProduceprice/'+productId).success(function(data) {
    				$scope.searchPaginator._load();//刷新数据
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		
    		
    		$scope.AddOrUpdateUser=function(){
    			console.log($scope.produceprice);
    			$scope.propertycontracts = [];
    			if($scope.produceprice.productId==0 || $scope.produceprice.productId==null)
    			{
    				console.log($scope.produceprice);
    				$('#addImpClinet').modal('hide');  //关闭模态框
    				$http.post(url + '/Produceprice/AddProduceprice',{Produceprice:$scope.produceprice}).success(function(data) {
    					$scope.searchPaginator._load();//刷新数据
    			    }).error(function(data, status, headers, config){
    		            alert("error"+status);
    		        }) ;
    			}else
    			{
    				$http.put( url + '/Produceprice/UpdateProduceprice',{Produceprice:$scope.produceprice}).
    				success(function(data){	
    					$('#addImpClinet').modal('hide');  //关闭模态框
    					$scope.searchPaginator._load();//刷新数据
    		        }).error(function(data, status, headers, config){
    		            alert("error"+status);
    		        }) ;
    			}
    		};
    		};
    		$scope.deleteProduceprice=function()
            {
            	if(confirm("是否要删除勾选项？"))
            	{
            		var indexchekbox=0;
            		var indexsuccess=0;
            		for(var i=0;i<$scope.searchPaginator.object.produceprices.length;i++){
    	    			if($scope.searchPaginator.object.produceprices[i].value==true){
    	    				indexchekbox++;
    	    				$http({
    	    					method:'DELETE',
    	    					url:url + '/Produceprice/DeleteProducepriceById/'+$scope.searchPaginator.object.produceprices[i].productId
    	    				})
    	    				.success(function(data, status, headers, config){
    	    					indexsuccess++;
    	    					if(indexchekbox==indexsuccess)
    	    					{
    	    						$scope.searchPaginator._load();//刷新数据
    	    						alert("删除成功！");
    	    					}
    	    				}).error(function(data, status, headers, config){
    	    		            alert("删除失败！");
    	    		            return;
    	    		        }) ;
    	    			};
    	    		}
            	}
            };
    	});
    });
