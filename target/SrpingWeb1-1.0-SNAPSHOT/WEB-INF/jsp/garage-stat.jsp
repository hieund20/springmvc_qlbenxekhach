<%-- 
    Document   : garage-stat
    Created on : Aug 25, 2022, 4:43:29 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Thống kê số lượng tuyến theo nhà xe</h4>

<div style="position: relative; height:40vh; margin-bottom: 32px;">
  <canvas id="myGarageStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã nhà xe</th>
        <th>Tên nhà xe</th>
        <th>Số lượng tuyến</th>
    </tr>
    <c:forEach items="${garageStat}" var="c"> 
        <tr>
            <td>${c[0]}</td>
            <td>${c[1]}</td>
            <td>${c[2]}</td>
        </tr>
    </c:forEach>
</table>
<br>

<script>
    let garageLabels=[], garageInfo=[];
    <c:forEach items="${garageStat}" var="c">
        garageLabels.push('${c[1]}')
        garageInfo.push(${c[2]})
    </c:forEach>
        
    window.onload = () => {
        garageChart("myGarageStatsChart", garageLabels, garageInfo);
    }
</script>
