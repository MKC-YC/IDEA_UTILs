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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
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
        <h1>寝室详细详细表</h1>

    </div>
    <div id="breadcrumb">
        <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 主页</a>
        <a href="#" class="current">寝室详细信息</a>
    </div>
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">

                <div class="widget-box">
                    <div class="widget-title">
								<span class="icon">
								</span>
                        <h5>公寓</h5>
                    </div>
                    <div class="widget-content nopadding">
                        <table class="table table-bordered table-striped with-check" id="dataList">
                            <thead>
                            <tr>
                                <th>寝室编号</th>
                                <th>公寓编号</th>
                                <th>门</th>
                                <th>灯</th>
                                <th>床</th>
                                <th>水龙头</th>
                                <th>花洒</th>
                                <th>厕所</th>
                                <th>留言</th>
                            </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${dorm.dormid}</td>
                                    <td>${dorm.apartmentid}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.door eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.door eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.lamp eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.lamp eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.bed eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.bed eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.watertap eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.watertap eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.shower eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.shower eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${dorm.toilet eq 'false'}">坏</c:when>
                                            <c:when test="${dorm.toilet eq 'true'}">好</c:when>
                                            <c:otherwise >无</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${dorm.comment}</td>
                                </tr>

                            </tbody>

                        </table>
                        <div class="widget-title">
								<span class="icon">
								</span>
                            <h5>寝室关联学生</h5>
                        </div>
                        <table class="table table-bordered table-striped with-check">
                            <tr>
                                <th>学生号</th>
                                <th>学生密码</th>
                                <th>学生姓名</th>
                                <th>学生性别</th>
                                <th>寝室编号</th>
                                <th>学院</th>
                                <th>主修</th>
                                <th>电话</th>
                            </tr>
                            <c:forEach items="${students}" var="student">
                                <tr>
                                    <th>${student.stuid}</th>
                                    <th>${student.stupassword}</th>
                                    <th>${student.stuname}</th>
                                    <th>${student.gender}</th>
                                    <th>${student.dormid}</th>
                                    <th>${student.college}</th>
                                    <th>${student.major}</th>
                                    <th>${student.telephone}</th>
                                </tr>
                            </c:forEach>
                        </table>
                        <div class="widget-title">
								<span class="icon">
								</span>
                            <h5>寝室有关评价记录</h5>
                        </div>
                        <table class="table table-bordered table-striped with-check">
                            <tr>
                                <th>评价记录编号</th>
                                <th>标题</th>
                                <th>内容</th>
                            </tr>
                            <c:forEach var="record" items="${evaluationRecord}">
                                <tr>
                                    <th>${record.evaRecordid}</th>
                                    <th>${record.title}</th>
                                    <th>${record.content}</th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
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

    <script>

    </script>

    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery.ui.custom.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.uniform.js"></script>
    <script src="../js/select2.min.js"></script>

    <%--</body>--%>
</html>

