<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>数据表格_很简洁漂亮的Bootstrap响应式后台管理系统模板UniAdmin</title>
    <meta charset="UTF-8" />
    <meta name="author" content="order by dede58.com"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="../css/uniform.css" />
    <link rel="stylesheet" href="../css/select2.css" />
    <link rel="stylesheet" href="../css/unicorn.main.css" />
    <link rel="stylesheet" href="../css/unicorn.grey.css" class="skin-color" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style>
        .bar6 input {
            border: 2px solid #444444;
            border-radius: 5px;
            background: transparent;
            top: 0;
            right: 0;

        }
        .bar6 button {
            background: #444444;
            border-radius: 0 5px 5px 0;
            width: 60px;
            top: 0;
            right: 0;
        }
        .bar6 button:before {
            content: "搜索";
            font-size: 13px;
            color: #F9F0DA;
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
        <h1>学生信息</h1>

    </div>
    <div id="breadcrumb">
        <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 主页</a>
        <a href="#" class="current">学生信息</a>
    </div>

    <div class="search bar6" align="center">
        <form action="/student/fuzzyQuery" method="get">
            <input type="text" name="str"  placeholder="请输入您要搜索的内容...">
            <button type="submit" class="btn"></button>
        </form>
    </div>
    <div>
        <button onclick="location.href='/student/addStudent'" class="btn bg-olive btn-xs">添加学生</button>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">

                <div class="widget-box">
                    <div class="widget-title">
								<span class="icon">
									<input type="checkbox" id="title-checkbox" name="title-checkbox" />
								</span>
                        <h5>学生信息表</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered table-striped with-check">
                            <thead>
                            <tr>
                                <th><i class="icon-resize-vertical"></i></th>
                                <th>学生学号</th>
                                <th>学生密码</th>
                                <th>学生姓名</th>
                                <th>性别</th>
                                <th>寝室编号</th>
                                <th>学院</th>
                                <th>主修</th>
                                <th>电话</th>
                                <th><button onclick="deleteStudent()" class="btn btn-danger" ><i class="icon-remove icon-white"></i>删除</button></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="student">
                                <tr>
                                    <td><input type="checkbox" class="ids" value="${student.stuid}"></td>
                                    <td>${student.stuid}</td>
                                    <td>${student.stupassword}</td>
                                    <td>${student.stuname}</td>
                                    <td>${student.gender}</td>
                                    <td>${student.dormid}</td>
                                    <td>${student.college}</td>
                                    <td>${student.major}</td>
                                    <td>${student.telephone}</td>
                                    <td>
                                    <button type="button" class="btn btn-inverse" onclick="location.href='/student/updateStudent?stuid=${student.stuid}'"><i class="icon-refresh icon-white"></i>更新</button>
                                    <button type="button" class="btn btn-danger" onclick="location.href='/student/delete?stuid=${student.stuid}'"><i class="icon-remove icon-white"></i>删除</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="pagination alternate">
                    <ul>
                        <li><a href="/student/findAll?page=1&pageSize=${pageInfo.pageSize}" >首页</a></li>
                        <li><a href="/student/findAll?page=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}">上一页</a></li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                            <li><a href="/student/findAll?page=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}">${pageNum}</a></li>
                        </c:forEach>
                        <li><a href="/student/findAll?page=${pageInfo.pageNum+1}&PageSize=${pageInfo.pageSize}">下一页</a></li>
                        <li><a href="/student/findAll?page=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a></li>
                    </ul>
                </div>
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages}页，共${pageInfo.total}条数据。
                            <select class="form-control" id="changePageSize" onchange="changePageSize()">
                                <option>5</option>
                                <option>10</option>
                                <option>20</option>
                                <option>50</option>
                            </select> 条
                        </div>
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



<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.ui.custom.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.uniform.js"></script>
<script src="../js/select2.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/unicorn.js"></script>
<script src="../js/unicorn.tables.js"></script>
<script>
    function changePageSize() {
        //获取下拉框的值
        var pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变没页显示条数
        location.href = "/student/findAll?page=1&pageSize="+pageSize;
    }


    function deleteStudent() {
        var array = new Array();
        var flag;
        $("input[class='ids']:checkbox").each(function () {
            if ($(this).attr("checked")) {
                flag = true;
            }
        })
        // alert(array);
        if (flag) {
            $("input[class='ids']:checkbox").each(function () {
                if ($(this).attr("checked")) {
                    array.push($(this).val());
                }
            })
            location.href = "/student/deleteList?string=" + array;
        }else {
            alert("请至少选择一个");
        }
    }

</script>

</body>
</html>