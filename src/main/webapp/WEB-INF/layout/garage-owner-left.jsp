<%-- 
    Document   : garage-owner-left
    Created on : Aug 27, 2022, 2:23:32 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <ul class="nav navbar-nav" style="width: 100%;">
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/garage-owner/garage-add" />" class="nav-link">Tạo form đăng ký mới nhà xe</a>
            </li>
            <li><hr></li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/garage-owner/garage-add-route" />" class="nav-link">Thêm tuyến xe</a>
            </li>
            <li class="nav-item" style="background: #cff4fc; padding-left: 8px; margin-bottom: 8px;">
                <a href="<c:url value="/garage-owner/garage-add-trip" />" class="nav-link">Thêm chuyến xe</a>
            </li>
        </ul>
    </div>
</nav>
