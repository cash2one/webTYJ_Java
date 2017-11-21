var entityMap = {
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': '&quot;',
        "'": '&#39;',
        "/": '&#x2F;'
    };
    function escapeHtml(string) {
        return String(string).replace(/[&<>"'\/]/g, function (s) {
            return entityMap[s];
        });
    }
    var nonSpace = /\S/;
    function trimIndent(content) {
        var lines = content.split("\n");
        var begin = 0;
        var end = lines.length-1;
        while ((nonSpace.exec(lines[begin]) == null) && (begin < lines.length))
            begin = begin + 1;
        while ((nonSpace.exec(lines[end]) == null) && end >= begin)
            end = end - 1;
        var ident = nonSpace.exec(lines[begin]).index;
        var formatted = "";
        for (var i = begin; i <= end; i++) {
            formatted = formatted + lines[i].slice(ident-1) + ((i < end)?"\n":"");
        }
        return formatted;
    }
    
    define(['tyjApp',"treeControl", "ui.bootstrap", "template/tabs/tab.html", "template/tabs/tabset.html"],function(module){
    	module.factory("$savedContent", function() {
            return [];
        })
        module.directive("saveContent", function($savedContent) {
            return {
                restrict: "A",
                compile: function($element, $attrs) {
                    var content = $element.html();
                    $savedContent[$attrs.saveContent] = content;
                }
            }
        })
        module.directive("applyContent", function($savedContent) {
            return {
                restrict: "EAC",
                compile: function($element, $attrs) {
                    return function($scope, $element, $attrs) {
                        var content = $savedContent[$attrs.applyContent];
                        var lang = $attrs.highlightLang;
                        if (lang == "html")
                            content = escapeHtml(content);
                        content = trimIndent(content);
                        var pre = prettyPrintOne(content, lang);
                        $element.html(pre);
                    }
                }
            }
        })
        module.directive("nav", function() {
            return {
                restrict: "A",
                compile: function($element) {
                    var sections = $("section");
                    angular.forEach(sections, function(section) {
                        var $section = $(section);
                        var id = $section.attr('id');
                        var titleHtml = $section.find("h1").html();
                        titleHtml = titleHtml.slice(0, titleHtml.indexOf("<")).trim();
                        $element.append("<li><a href='#"+id+"'>"+titleHtml+"</a></li>")
                    })
                }
            }
        });
    });
    function createSubTree(level, width, prefix) {
        if (level > 0) {
            var res = [];
            for (var i=1; i <= width; i++)
                res.push({ "label" : "Node " + prefix + i, "id" : "id"+prefix + i, "i": i, "children": createSubTree(level-1, width, prefix + i +".") });
            return res;
        }
        else
            return [];
    }