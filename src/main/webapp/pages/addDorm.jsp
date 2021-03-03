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
        #apartmentid {
            width: 60px;
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
        <h1>添加寝室</h1>

    </div>
    <!--左标题-->
    <div id="breadcrumb">
        <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 主页</a>
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
                        <h5>输入</h5>
                    </div>

                    <div class="widget-content nopadding">
                        <form action="/dorm/insert" method="get" class="form-horizontal" />
                        <div class="control-group">
                            <label class="control-label">公寓编号</label>
                            <div class="controls">
                               <select name="apartmentid">
                                   <c:forEach var="apartmentId" items="${apIds}">
                                       <option id="apartmentid">${apartmentId}</option>
                                   </c:forEach>
                               </select>
                                <span class="help-block">请选择公寓编号</span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">门的状态</label>
                            <div class="controls">
                                <select name="door">
                                    <option value="0">坏</option>
                                    <option value="1" selected="selected">好</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">灯的状态</label>
                            <div class="controls">
                                <select name="lamp">
                                    <option value="0">坏</option>
                                    <option value="1" selected="selected">好</option>
                                </select>

                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">床的状态</label>
                            <select name="bed">
                                <option value="0">坏</option>
                                <option value="1" selected="selected">好</option>
                            </select>
                        </div>
                        <div class="control-group">
                            <label class="control-label">水龙头状态</label>
                            <div class="controls">
                                <select name="watertap">
                                    <option value="0">坏</option>
                                    <option value="1" selected="selected">好</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">蓬蓬头状态</label>
                            <div class="controls">
                                <select name="shower">
                                    <option value="0">坏</option>
                                    <option value="1" selected="selected">好</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">厕所状态</label>
                            <div class="controls">
                                <select name="toilet">
                                    <option value="0">坏</option>
                                    <option value="1" selected="selected">好</option>
                                </select>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">备注</label>
                            <div class="controls">
                                <input type="text" placeholder="请输入备注"  name="comment"/>
                            </div>
                        </div>
                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">保存</button>
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



<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.ui.custom.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-colorpicker.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/jquery.uniform.js"></script>
<script src="../js/select2.min.js"></script>
<script src="../js/unicorn.js"></script>
<script src="../js/unicorn.form_common.js"></script>

<script>

</script>
</body>
</html>

