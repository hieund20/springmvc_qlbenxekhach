<%-- 
    Document   : garage-add-trip
    Created on : Aug 28, 2022, 11:35:58 AM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center">Thêm mới chuyến xe</h4>

<%--<c:url value="/garage-owner/garage-add-trip" var="action"/>--%>
<form action="">
    <div class="form-group">
        <label for="departure_date">Ngày</label>
        <input type="date" name="departure_date" id="departure_date" class="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label for="start_time">Giờ khởi hành</label>
        <input type="time" name="start_time" id="start_time" class="form-control"/>
    </div>
    <br>
    <input type="submit" value="Thêm mới" class="btn btn-primary"/>
    <br>
</form>
<br>
<br>
