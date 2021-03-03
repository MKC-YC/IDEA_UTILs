<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>通用表单页面_很简洁漂亮的Bootstrap响应式后台管理系统模板UniAdmin</title>
    <meta charset="UTF-8" />
    <meta name="author" content="order by dede58.com"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="../css/colorpicker.css" />
    <link rel="stylesheet" href="../css/datepicker.css" />
    <link rel="stylesheet" href="../css/uniform.css" />
    <link rel="stylesheet" href="../css/select2.css" />
    <link rel="stylesheet" href="../css/unicorn.main.css" />
    <link rel="stylesheet" href="../css/unicorn.grey.css" class="skin-color" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style>
        #leftName , #btn,#rightName,#selected{
            float: left;
            width: 100px;
            height: 300px;
        }
        #toRight,#toLeft{
            margin-top:100px ;
            margin-left:30px;
            width: 50px;
        }

        .border{
            height: 500px;
            padding: 100px;
        }
    </style>
</head>
<body>



<div id="header">
    <h1><a href="/index.jsp">DormManagement</a></h1>
</div>


<div id="user-nav" class="navbar navbar-inverse">
    <ul class="nav btn-group">
        <li class="btn btn-inverse"><a title="" href="/logout"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
    </ul>
</div>
<div id="sidebar">
    <a href="#" class="visible-phone"><i class="icon icon-home"></i> 首页</a>
    <ul>
        <li ><a href="/index.jsp"><i class="icon icon-home"></i> <span>首页</span></a></li>
        <li><a href="/apartment/findAll"><i class="icon icon-th-list"></i> <span>公寓管理</span> </a></li>
        <li><a href="/dorm/findAll"><i class="icon icon-tint"></i> <span>寝室管理</span></a></li>
        <li><a href="/student/findAll"><i class="icon icon-pencil"></i> <span>学生管理</span></a></li>
        <li><a href="/evaRecord/findAll"><i class="icon icon-th"></i> <span>评价记录</span></a></li>
        <li><a href="/visitor/findAll"><i class="icon icon-th-list"></i> <span>访客查询</span></a></li>
        <li>
            <a href="/administrator/findAll"><i class="icon icon-signal"></i> <span>管理员</span></a>
        </li>
    </ul>
</div>


<div id="content">
    <div id="content-header">
        <!--大标题-->
        <h1>更改评价记录信息</h1>

    </div>
    <!--左标题-->
    <div id="breadcrumb">
        <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
        <a href="#" class="tip-bottom">学生管理</a>
        <a href="#" class="current">添加学生信息</a>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>
								</span>
                        <h5>Text inputs</h5>
                    </div>

                    <div class="widget-content nopadding">
                        <form action="/evaRecord/update" method="get" class="form-horizontal" />
                        <div class="control-group">
                            <label class="control-label">记录编号</label>
                            <div class="controls">
                                <input type="text" name="evaRecordid" id="evarecordid" value="${evaRecord.evaRecordid}" readonly="readonly" />
                                <!--background-color:#cccccc-->
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">标题</label>
                            <div class="controls">
                                <input type="text" name="title" value="${evaRecord.title}" >
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">内容</label>
                            <div class="controls">
                                <input type="text" name="content" value="${evaRecord.content}">
                                <span class="help-block">This is a description</span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">寝室编号</label>
                            <div class="controls">
                                <select id="leftName" multiple="multiple">
                                    <c:forEach items="${noselectedDorm}" var="noselect"><option>${noselect.dormid}</option></c:forEach>
                                </select>
                                <div id="btn">
                                    <input type="button" id="toRight" value="-->"><br>
                                    <input type="button" id="toLeft" value="<--">
                                </div>
                                <select name="dormid" id="rightName" multiple="multiple">
                                </select>
                                <select id="selected" multiple="multiple">
                                    <c:forEach items="${selectedDorm}" var="select"><option selected="selected">${select.dormid}</option></c:forEach>
                                </select>
                                <span class="help-block">按住Ctrl键可以多选</span>
                                <!--更新记录里面的寝室编号只能增加不能减少-->
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>


        <div class="row-fluid">
            <div id="footer" class="span12">
                2020 &copy; UniAdmin.</div>
        </div>
    </div>
</div>



<%--<script src="../js/jquery.min.js"></script>--%>
<script src="../js/jquery.ui.custom.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-colorpicker.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/jquery.uniform.js"></script>
<script src="../js/select2.min.js"></script>
<script src="../js/unicorn.js"></script>
<script src="../js/unicorn.form_common.js"></script>
<script src="../js/jquery-1.8.3.min.js"></script>

<script>
    function checkTelephone() {
        var telephone = $("#telephone").val();

        var reg_tele = /[1-9][0-9]{8,10}/;
        var flag = reg_tele.test(telephone);
        if (flag){
            $("#telephone").css("border","");
        }else {
            $("#telephone").css("border","1px solid red");
        }
        return flag;
    };

    $("#telephone").blur(checkTelephone());


        function selectList() {
            var evarecordid = $("#evarecordid").val();
            $("#selected").empty();
            $.get("/evaRecord/selectedDorm",{evarecordId:evarecordid},function x(data) {
                    // alert(data);
                var obj = eval ("(" + data + ")");
                // for (var i = 0; i <obj.size() ; i++) {
                //     alert(obj[i].dormid);
                // }
                // alert(obj[0]);
                // alert(obj[1]);
                    // alert(obj);
                    // alert(obj[0].dormid);
                $("#selected").prepend("<option value='0'>请选择</option>");
                $.each(obj,function (idx,item) {
                    $('#selected').append("<option value="+ item+">"+ item+"</option>");
                })

            });
        }
    function unselectedList() {
        var evarecordid = $("#evarecordid").val();
        $("#unselected").empty();
        $.get("/evaRecord/noselectedDorm",{evarecordid:evarecordid},function x(data) {
            // alert(data);
            var obj = eval ("(" + data + ")");
            // for (var i = 0; i <obj.size() ; i++) {
            //     alert(obj[i].dormid);
            // }
            // alert(obj[0]);
            // alert(obj[1]);
            // alert(obj);
            // alert(obj[0].dormid);
            $("#selected").prepend("<option value='0'>请选择</option>");
            $.each(obj,function (idx,item) {
                $('#unselected').append("<option value="+ item+">"+ item+"</option>");
            })

        })}

    $(function () {
        //toRight
        $("#toRight").click(function () {
            //获取右边的下拉列表对象，append(左边下拉列表选中的option)
            $("#rightName").append($("#leftName > option:selected"));
        });

        //toLeft
        $("#toLeft").click(function () {
            //appendTo   获取右边选中的option，将其移动到左边下拉列表中
            $("#rightName > option:selected").appendTo($("#leftName"));

        });
    });
</script>
</body>
</html>

