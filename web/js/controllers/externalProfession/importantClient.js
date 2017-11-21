/**
 * Created by Administrator on 2015/4/17.
 * 重要客户
 */

'use strict';

/**
 * Created by Administrator on 2015/4/17.
 */

'use strict';

define(['tyjApp','pageServices'],function(module){
    module.controller("imClientCtrl",function($scope,$http,Paginator,$rootScope){
    	
       	var url = $rootScope.url;
        $scope.PersonCust={page:{}};
        
        var fetchFunction = function(page,callback) {
    		$scope.PersonCust.page=page;
            $http.post(url + '/PersonCust/listPersonCustByblacklist',{PersonCust:$scope.PersonCust}).success(callback);
        };  

        $scope.searchPaginator=Paginator(fetchFunction,2);
        

      	
      	
      	
      	//��ѯ��Ҫ�ͻ���Ϣ
        $scope.personCust={};
      	$scope.GetPersonCust=function(custId){
    		if(custId!=0)
    		{
    			$http.get(url + '/PersonCust/getPersonCustByIdRestful/'+custId).success(function(data) {
    				console.log(data);
    				$scope.personCust = data.PersonCust;
    			});
    		}else{
    			$scope.personCust={};
    		}
    	};
    	
    	
    	$scope.AddOrUpdatePersonCust=function(custId){
    	
    		console.log($scope.personCust);
    		if(custId==0)
    		{
    			$scope.personCust.blacklist=1;  //��ʾΪ��Ҫ�ͻ�
    			$http.post(url + '/PersonCust/insertPersonCustRestful',{PersonCust:$scope.personCust}).success(function(data) {
    				$('#addImpClinet').modal('hide');  //�ر�ģ̬��
    				$scope.searchPaginator._load();//ˢ�����
    				
    		    }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}else
    		{
    			$http.put( url + '/PersonCust/updatePersonCustRestful',{PersonCust:$scope.personCust}).
    			success(function(data){	
    				$('#updateImpClinet').modal('hide'); //�ر�ģ̬��
    				$scope.searchPaginator._load();//ˢ�����
    	        }).error(function(data, status, headers, config){
    	            alert("error"+status);
    	        }) ;
    		}
    	};
    	
    	
    	$scope.deletePersonCust=function(){
    		if(confirm("�Ƿ�ɾ��?"))
    		{ 
	    		for(var i=0;i<$scope.searchPaginator.object.personCusts.length;i++){
		    			if($scope.searchPaginator.object.personCusts[i].value==true){
		    				var id=$scope.searchPaginator.object.personCusts[i].custId;
		    				$http({
		    					method:'DELETE',
		    					url:url + '/PersonCust/deletePersonCustRestful/'+id
		    				})
		    				.success(function(data, status, headers, config){
		    					$scope.searchPaginator._load();//ˢ�����
		    				});	
	    		};
	    		
    		} ;

    	    };
    	};

    });
});