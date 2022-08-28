<%-- 
    Document   : login
    Created on : Aug 23, 2022, 11:08:11 PM
    Author     : HIEU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action"/>

<h3 style="margin-top: 48px;">Đăng nhập</h3>
<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra. Vui lòng quay lại sau
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập
    </div>    
</c:if>
    
<form method="post" action="${action}">
    <br/>
    <div class="form-group">
        <label for="username">Tên đăng nhập</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <br/>
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <input type="password" id="password" name="password"  class="form-control"/>
    </div>
    <br/>
    <div class="form-group">
        <input type="submit" value="Đăng nhập" class="btn btn-primary"/>
    </div>
</form>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>



