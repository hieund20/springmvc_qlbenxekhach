<%-- 
    Document   : garage-add-route
    Created on : Aug 27, 2022, 5:01:53 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Thêm mới tuyến xe</h4>

<c:url value="/garage-owner/garage-add-route" var="action"/>
<form:form action="${action}" method="post" modelAttribute="route" enctype="multipart/form-data">
    <div class="form-group">
        <label for="departure">Điểm khởi hành</label>
        <form:input type="text" id="departure" path="departure" cssClass="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label for="destination">Điểm kết thúc</label>
        <form:input type="text" id="destination" path="destination" cssClass="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label for="price">Giá vé</label>
        <form:input type="text" id="price" path="price" cssClass="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label for="file">Ảnh thumbnail</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <br>
    <input type="submit" value="Thêm mới" class="btn btn-primary"/>
    <br>
</form:form>
<br>
<br>

