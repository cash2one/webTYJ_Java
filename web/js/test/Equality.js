var appModule=angular.module("example",[]);
/*appModule.controller("Equality",function($scope){
	$scope.treedata=[
	                 { "name" : "Joe", "age" : "21", "children" : [
	                     { "name" : "Smith", "age" : "42", "children" : [] },
	                     { "name" : "Joe", "age" : "21", "children" : [
	                         { "name" : "Jenifer", "age" : "23", "children" : [
	                             { "name" : "Dani", "age" : "32", "children" : [] },
	                             { "name" : "Max", "age" : "34", "children" : [] }
	                         ]}
	                     ]}
	                 ]},
	                 { "name" : "Albert", "age" : "33", "children" : [] },
	                 { "name" : "Ron", "age" : "29", "children" : [] }
	             ];
	             $scope.opts = {
	                 equality: function(node1, node2) {
	                     return node1 === node2;
	                 }
	             }
});*/
var Equality = function($scope,$http){
	$http.get('http://localhost:8080/webTYJ/cxfws/rest/Propertycontract/getTree').success(function(data) {
		console.log(data);
		$scope.treedata = data.Tree;
	});
	/*$scope.treedata=[
	                 { "name" : "Joe", "age" : "21", "children" : [
	                     { "name" : "Smith", "age" : "42", "children" : [] },
	                     { "name" : "Joe", "age" : "21", "children" : [
	                         { "name" : "Jenifer", "age" : "23", "children" : [
	                             { "name" : "Dani", "age" : "32", "children" : [] },
	                             { "name" : "Max", "age" : "34", "children" : [] }
	                         ]}
	                     ]}
	                 ]},
	                 { "name" : "Albert", "age" : "33", "children" : [] },
	                 { "name" : "Ron", "age" : "29", "children" : [] }
	             ];
*/	             $scope.opts = {
	                 equality: function(node1, node2) {
	                     return node1 === node2;
	                 }
	             }
	};
