var className='pingpushoujibizhi/',classId=1;
$(function () {
    //分类选择
    layui.form.render('select');
    $.ajax({
        "url":siteUrl+"zhiqu/PicClassServlet",
        "type":"POST",
        "data":{"num":1},
        "dataType":"json",
        "success":show
    });
    function show(data){
        $.each(data.classAll,function(k,v){
            var $select=$('<option value="'+v.classId+'" data-class="'+v.classSite+'">'+v.classTitle+'</option>');
            $("#diy-class>select").append($select);
        });
        layui.form.render('select');
    }
    layui.form.on('select(class)', function(data){
        ajdata.classId=data.value;
        classId=data.value;
        className=$('#diy-class>select').find("option:selected").attr('data-class');
        $('.sec').masonry('remove',$('.template-item'));//清除
        tfscroll=true;
        $('.dbom').hide();
        $('.scrollarea').scrollTop(0);
        tuijian(serUrl,ajdata);
    });
})
var loading=true;
/*推荐模板*/
var pageNo=0;//页数
var pageNum=0;//单次数
var pageSize=0;//每页大小
var serUrl=siteUrl+"zhiqu/SysPicServlet";
var ajdata={"pageNo":pageNo=0,"num":2,"classId":1,"userId":10000};
function tuijian(jsonurl,jsondata){
    $.ajax({
        "url":jsonurl,
        "type":"POST",
        "data":jsondata,
        "dataType":"json",
        "success":show
    });
    function show(data){
        var pic="";
        $.each(data.picList,function(k,v){
            if(jsondata.num==0){
                pic=v.apic.sysPicBSite;
            }else if(jsondata.num==1||jsondata.num==3){
                pic=zhiqu+v.userPicSite;
            }else if (jsondata.num==2) {
                if(jsonurl==siteUrl+"zhiqu/FavoriteServlet"){
                    pic=v.sysPicBSite;
                }else if(jsonurl=siteUrl+"zhiqu/SysPicServlet"){
                    pic='http://zhiqutuku.test.upcdn.net/zhiqu/sysImg/'+className+v.apic.sysPicBSite;
                }
            }
            var dom=$("<div class='template-item'><div class='kongzj' onclick='uptoll(this)'>"+
                "<img src='"+pic+"' alt="+pic+"></div></div>");
            $('.sec').append(dom).masonry('appended',dom);
        });
        pageNum=data.picList.length;
        pageSize=data.pageSize;
        $('.sec').imagesLoaded().always( function( instance ) {
            if(loading){
                loading=false;
                loadingS();//加载
            }
            $('.sec').masonry();//从新布局
        });
    }
}
/*模板更换*/
function uptoll(dom){
    var path=$(dom).find("img").attr("src");
    var pathalt=$(dom).find("img").attr("alt");
    $("#topimg").attr("src",path);
    $("#topimg").attr("alt",pathalt);
    recoverSize();//恢复默认设置大小
}
var like=2;
$(function(){
    $(".clearfix").click(function(){
        $('.sec').masonry('remove',$('.template-item'));//清除
        $('.dbom').css('display','none');
        $(".scrollarea").scrollTop(0);
        like=$(this).attr("like");
        ajdata={"pageNo":pageNo=0,"num":like,"userId":10000};
        if(like!=0&&$(this).attr("url")=="FavoriteServlet"){
            $('#diy-class').hide();
            serUrl=siteUrl+"zhiqu/FavoriteServlet";
            tuijian(serUrl,ajdata);
        }else if(like==2&&$(this).attr("url")=="SysPicServlet"){
            $('#diy-class').show();
            serUrl=siteUrl+"zhiqu/SysPicServlet";
            ajdata.classId=classId;
            tuijian(serUrl,ajdata);
        }
        tfscroll=true;
        $('.dbom').hide();
    });
    scrollarea();
});
var tfscroll=true;
var scrollarea=function () {
    /*滚动监听*/
    $(".scrollarea").bind("scroll",function(){
        var scrollTop = $(this).scrollTop();
        var clien=$(".sec").height();//获取页面高度
        var winHei=$(this).height();//获取窗体高度
        if(scrollTop>=(clien-winHei-5)&&tfscroll){
            tfscroll=false;
            if(pageNum==pageSize){
                ajdata={"pageNo":pageNo=pageNo+pageSize,"num":like,"classId":classId,"userId":10000};
                tuijian(serUrl,ajdata);
                setTimeout(function(){tfscroll=true;},1000);
            }else {
                $('.dbom').show();
            }
        }
    });
}