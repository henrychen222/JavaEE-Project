$(document).ready(function(){  
	addPagination();
});  
function addPagination(){
	$(".page-nav").empty();
	var url = $(".page-nav").attr("data-url");
	var currentPage = $(".page-nav").attr("data-cup");
	var mumberOfPage = $(".page-nav").attr("data-num");
	var pageCount = $(".page-nav").attr("data-pgc");
    if(pageCount<2)
        return false;
    //初始起始页数、结束页数
    var start=1,end=7;
    if(currentPage>=4)         
        start=currentPage-3;
 
	if(Number(pageCount)>(Number(currentPage)+3))
        end=Number(currentPage)+3;
    else
        end=pageCount;
	
    var html='';
    if(currentPage!=1)
        //如果不是第一页则有前一页
        html+="<a href='javascript:;' title='上一页' onclick='redirectTo(\"before\")'><</a>";
    for(var i=start;i<=end;i++){
        if(i==currentPage)
        	html+="<a href='javascript:;' title='"+i+"' class='active' style='margin-top: 10px;'>"+i+"</a>";
        else
        	html+="<a href='javascript:;' title='"+i+"' onclick='redirectTo("+i+")'>"+i+"</a>";
    }
    if(currentPage!=pageCount)
    	html+="<a href='javascript:;' title='下一页' onclick='redirectTo(\"next\")'>></a>";
     
    $(".page-nav").append(html);
}

function redirectTo(currentPage){
	var url = $(".page-nav").attr("data-url");
	var currentPageNow = $(".page-nav").attr("data-cup");
	var mumberOfPage = $(".page-nav").attr("data-num");
	var pageCount = $(".page-nav").attr("data-pgc");
	if(currentPage=='before')
		currentPage = Number(currentPageNow)-1;
	if(currentPage=='next')
		currentPage = Number(currentPageNow)+1;
	
	$(".page-nav").attr("data-cup",currentPage);
	addPagination();
	
	var func=eval(url);
	new func(currentPage,mumberOfPage,pageCount);
}

