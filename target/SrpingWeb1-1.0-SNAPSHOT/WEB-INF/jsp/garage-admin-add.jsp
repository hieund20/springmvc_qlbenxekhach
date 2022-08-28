<%-- 
    Document   : garage-admin-add
    Created on : Aug 26, 2022, 11:28:08 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center">Thêm mới nhà xe</h4>

<c:url value="/admin/garage-admin-add" var="action"/>
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
    <div class="form-group">
        <label for="isActive">Trạng thái</label>
        <form:select path="isActive">
            <form:option value="1">Đang hoạt động</form:option>
            <form:option value="0">Khóa</form:option>
        </form:select>
    </div>
    <br>
    <input type="submit" value="Thêm mới" class="btn btn-primary"/>
    <br>
</form:form>
