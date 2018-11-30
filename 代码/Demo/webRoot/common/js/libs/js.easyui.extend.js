/**
 * 赵琦添加：easyui对实心父节点getChecked获取不到节点，添加扩展方法支持getChecked获取实心父节点
 */
$(function(){
    //此处是扩展tree的两个方法.
    $.extend($.fn.tree.methods,{
        getCheckedExt: function(jq){//扩展getChecked方法,使其能实心节点也一起返回
            var checked = $(jq).tree("getChecked");
            var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
            $.each(checkbox2,function(){
                var node = $.extend({}, $.data(this, "tree-node"), {
                    target : this
                });
                checked.push(node);
            });
            return checked;
        },
        getSolidExt:function(jq){//扩展一个能返回实心节点的方法
            var checked =[];
            var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
            $.each(checkbox2,function(){
                var node = $.extend({}, $.data(this, "tree-node"), {
                    target : this
                });
                checked.push(node);
            });
            return checked;
        }
    });
});