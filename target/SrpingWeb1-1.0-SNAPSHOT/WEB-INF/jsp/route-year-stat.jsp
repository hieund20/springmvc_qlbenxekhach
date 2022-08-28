<%-- 
    Document   : route-year-stat
    Created on : Aug 26, 2022, 3:56:04 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Thống kê tần suất từng tuyến xe theo năm</h4>

<div style=" margin-bottom: 32px;">
  <canvas id="myRouteYearStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Tên tuyến</th>
        <th>Tần suất</th>
    </tr>
    <c:forEach items="${routeYearStat}" var="r"> 
        <tr>
            <td>Năm ${r[0]}</td>
            <td>${r[1]} - ${r[2]}</td>
            <td>${r[4]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let routeLabels=[], routeInfo=[], routeName=[];
    <c:forEach items="${routeYearStat}" var="r">
        routeLabels.push('Năm ${r[0]}')
        routeInfo.push(${r[4]})
        routeName.push('${r[1]} - ${r[2]}')
    </c:forEach>
        
    window.onload = () => {
        routeYearChart("myRouteYearStatsChart", routeLabels, routeInfo, routeName);
    }
</script>
