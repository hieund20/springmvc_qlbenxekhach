<%-- 
    Document   : header
    Created on : Aug 1, 2022, 11:17:18 PM
    Author     : HIEU
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-sm navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/" />">OU Bus Station</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto ">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
                </li>             
            </ul>
        </div>
        <ul class="navbar-nav me-auto ">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <i class="fa fa-user"></i> 
                    <a class="nav-link d-inline" href="<c:url value="/login" />">Đăng nhập</a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-check"></i> 
                    <a class="nav-link d-inline" href="<c:url value="/register" />">Đăng ký</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <sec:authorize access="hasAuthority('ADMIN')">
                    <li class="nav-item">
                        <a href="<c:url value="/admin/garage-admin" />" class="nav-link">
                            Trang Admin
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAuthority('GARAGE_OWNER')">
                    <li class="nav-item">
                        <a href="<c:url value="/garage-owner/garage-add" />" class="nav-link">
                            Trang chủ nhà xe
                        </a>
                    </li>
                </sec:authorize>

                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fas fa-cart-plus" style="color: black"></i>
                        <div class="badge badge-danger" id="cart-counter-icon">0</div>
                    </a>
                </li>
                <li class="nav-item" style="margin-right: 10px; margin-left: 10px;">
                    <c:if test="${currentUser.avatar != null}">
                        <img src="${currentUser.avatar}" class="img-fluid"
                             style="width: 25px; height: 25px; border-radius: 50%; vertical-align: middle;"/>
                    </c:if>
                    <c:if test="${currentUser.avatar == null}">
                        <i class="fa fa-user"></i>
                    </c:if>
                    <a class="nav-link d-inline-block" href="<c:url value="/" />">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="nav-item">
                    <i class="fa fa-sign-out"></i>
                    <a class="nav-link d-inline-block" 
                       href="<c:url value="/logout" />">Đăng xuất</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
