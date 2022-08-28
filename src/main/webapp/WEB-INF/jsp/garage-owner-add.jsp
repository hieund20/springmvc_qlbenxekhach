<%-- 
    Document   : garage-owner-add
    Created on : Aug 27, 2022, 2:11:36 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center">Form đăng ký nhà xe</h4>

<c:url value="/garage-owner/garage-add" var="action"/>
<form:form action="${action}" method="post" modelAttribute="garage" enctype="multipart/form-data">
    <div class="form-group">
        <label for="name">Tên nhà xe</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label for="file">Ảnh nhà xe</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <br>
    <input type="submit" value="Đăng ký" class="btn btn-primary"/>
    <br>
</form:form>
<br>
<br>
