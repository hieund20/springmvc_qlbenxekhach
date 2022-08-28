<%-- 
    Document   : route-month-stat
    Created on : Aug 26, 2022, 3:10:33 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Thống kê tần suất từng tuyến xe theo tháng</h4>

<div style=" margin-bottom: 32px;">
  <canvas id="myRouteMonthStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Tên tuyến</th>
        <th>Tần suất</th>
    </tr>
    <c:forEach items="${routeMonthStat}" var="r"> 
        <tr>
            <td>${r[0]}/${r[1]}</td>
            <td>${r[2]} - ${r[3]}</td>
            <td>${r[5]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let routeLabels=[], routeInfo=[], routeName=[];
    <c:forEach items="${routeMonthStat}" var="r">
        routeLabels.push('${r[0]} - ${r[1]}')
        routeInfo.push(${r[5]})
        routeName.push('${r[2]} - ${r[3]}')
    </c:forEach>
        
    window.onload = () => {
        routeMonthChart("myRouteMonthStatsChart", routeLabels, routeInfo, routeName);
    }
</script>
