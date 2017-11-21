/**
 * Created by 彭婷婷on 2015/4/17.
 *合同初始化--新增合同
 * 修改人：王志刚
 * 最后修改时间：2015/6/4
 */
'use strict';
define(['tyjApp'],function(module){
    module.controller("addContractCtrl",function($scope){
        //$scope.seleted = '';
        //$scope.Datil= {
        //    /**任务类型**/
        //    contractType: [
        //        {id: '1', name: '施工合同'}
        //    ],
        //    contractProject: [
        //        {id: '1', name: '施工合同'}
        //    ],
        //    contract1: [
        //        {id: '1', name: ''}
        //    ],
        //    contract2: [
        //        {id: '1', name: ''}
        //    ]
        //}
        //var vm = $scope.vm = {};
        //vm.contractProject=[
        //    {id: '1', name: '施工合同'}
        //];
        //vm.contractType=[
        //    {id: '1', name: '施工合同'},
        //    {id: '2', name: 'www'}
        //];
        //$scope.selectChange = function(){
        //    //添加了ng-change事件来试试id值的输出
        //    alert(vm.selectVal);
        //}
        ////文件上传
        //var file =null;  //保存上传的文件
        //$scope.onFileSelect = function($files) {    //$files: an array of files selected, each file has name, size, and type.
        //    for (var i = 0; i < $files.length; i++) {
        //        file = $files[i];
        //        alert(file);
        //    }
        //};
        //var json = [
        //        {"name":"01强电","list":
        //            [
        //                {"name":"0101室内照明","url":"#a1"},
        //                {"name":"0102室内照明","url":"#a1"},
        //                {"name":"0103线材","url":"#a1"},
        //            ]
        //        },
        //        {"name":"02弱电"},
        //        {"name":"03消防"},
        //        {"name":"04设备"},
        //        {"name":"05消防"},
        //        {"name":"06土建"},
        //        {"name":"07防水"},
        //        {"name":"08家私"},
        //        {"name":"09给水"},
        //        {"name":"10排水"}
        //]
        ///*递归实现获取无级树数据并生成DOM结构*/
        //var str = "";
        //var forTree = function(o){
        //    for(var i=0;i<o.length;i++){
        //        var urlstr = "";
        //        try{
        //            if(typeof o[i]["url"] == "undefined"){
        //                urlstr = "<div><span>"+ o[i]["name"] +"</span><ul>";
        //            }else{
        //                urlstr = "<div><span><a href="+ o[i]["url"] +">"+ o[i]["name"] +"</a></span><ul>";
        //            }
        //            str += urlstr;
        //            if(o[i]["list"] != null){
        //                forTree(o[i]["list"]);
        //            }
        //            str += "</ul></div>";
        //        }catch(e){}
        //    }
        //    return str;
        //}
        ///*添加无级树*/
        //document.getElementById("menuTree").innerHTML = forTree(json);
        ///*树形菜单*/
        //var menuTree = function(){
        //    //给有子对象的元素加[+-]
        //    $("#menuTree ul").each(function(index, element) {
        //        var ulContent = $(element).html();
        //        var spanContent = $(element).siblings("span").html();
        //        if(ulContent){
        //            $(element).siblings("span").html("[+] " + spanContent)
        //        }
        //    });
        //    $("#menuTree").find("div span").click(function(){
        //        var ul = $(this).siblings("ul");
        //        var spanStr = $(this).html();
        //        var spanContent = spanStr.substr(3,spanStr.length);
        //        if(ul.find("div").html() != null){
        //            if(ul.css("display") == "none"){
        //                ul.show(300);
        //                $(this).html("[-] " + spanContent);
        //            }else{
        //                ul.hide(300);
        //                $(this).html("[+]" + spanContent);
        //            }
        //        }
        //    })
        //}()
        //function curzt(v){
        //    $("#menuTree span").each(function(index, element) {
        //        var ul = $(this).siblings("ul");
        //        var spanStr = $(this).html();
        //        var spanContent = spanStr.substr(3,spanStr.length);
        //        if(ul.find("div").html() != null){
        //            $(this).html("["+ v +"] " + spanContent);
        //        }
        //    });
        //}
    });
});