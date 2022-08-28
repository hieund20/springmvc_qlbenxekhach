<%-- 
    Document   : route-stat
    Created on : Aug 26, 2022, 2:23:18 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Thống kê doanh thu theo tuyến</h4>

<form action="">
    <div class="form-group">
        <label>Tên tuyến</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <br>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <br>
    <input type="submit" value="Báo cáo" class="btn btn-primary"/>
</form>

<div style="position: relative; height:50vh; margin-bottom: 32px; margin-top: 32px;">
  <canvas id="myRouteStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã tuyến</th>
        <th>Tên tuyến</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${routeStat}" var="r"> 
        <tr>
            <td>${r[0]}</td>
            <td>${r[1]} - ${r[2]}</td>
            <td>${r[3]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let routeLabels=[], routeInfo=[];
    <c:forEach items="${routeStat}" var="r">
        routeLabels.push('${r[1]} - ${r[2]}')
        routeInfo.push(${r[3]})
    </c:forEach>
        
    window.onload = () => {
        routeChart("myRouteStatsChart", routeLabels, routeInfo);
    }
</script>