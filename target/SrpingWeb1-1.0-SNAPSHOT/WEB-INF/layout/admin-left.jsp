<%-- 
    Document   : admin-left
    Created on : Aug 25, 2022, 4:17:51 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/garage-admin-confirm" />" class="nav-link">Xác nhận đăng ký mới nhà xe</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/garage-admin" />" class="nav-link">Khóa / Mở khóa nhà xe</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/garage-admin-add" />" class="nav-link">Thêm mới nhà xe</a>
            </li>
            <li><hr></li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/garage-stat" />" class="nav-link">Thống kê số lượng chuyến trong nhà xe</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/route-stat" />" class="nav-link">Thống kê doanh thu theo từng chuyến</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/route-month-stat" />" class="nav-link">Thống kê tần suất từng tuyến xe theo tháng</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/route-year-stat" />" class="nav-link">Thống kê tần suất từng tuyến xe theo năm</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/admin/route-quarter-stat" />" class="nav-link">Thống kê tần suất từng tuyến xe theo từng quý</a>
            </li>
        </ul>
    </div>
</nav>
