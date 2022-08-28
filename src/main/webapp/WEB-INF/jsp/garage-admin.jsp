<%-- 
    Document   : garage-admin
    Created on : Aug 26, 2022, 4:21:36 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Khóa / Mở khóa nhà xe</h4>

<table class="table">
    <tr>
        <th>Mã nhà xe</th>
        <th>Tên nhà xe</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>
    <c:forEach items="${garageList}" var="g">
        <c:if test="${g.isAllowed == true}">
            <tr>
                <td>${g.id}</td>
                <td>${g.name}</td>
                <td>
                    <c:if test="${g.isActive == false}">
                        <span>Đã khóa</span>
                    </c:if>
                    <c:if test="${g.isActive == true}">
                        <span>Đang hoạt động</span>
                    </c:if>
                </td>
                <td>
                    <c:if test="${g.isActive == false}">
                        <button class="btn btn-primary" onclick="changeStatusOfGarage(${g.id}, true)">Mở khóa</button>
                    </c:if>
                    <c:if test="${g.isActive == true}">
                        <button class="btn btn-primary" onclick="changeStatusOfGarage(${g.id}, false)">Khóa</button>
                    </c:if>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<script src="<c:url value="/resources/js/main.js" />"></script>
