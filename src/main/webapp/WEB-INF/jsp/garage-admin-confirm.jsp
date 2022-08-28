<%-- 
    Document   : garage-admin-confirm
    Created on : Aug 27, 2022, 4:01:39 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="margin-top: 16px; margin-bottom: 32px;" class="text-center ">Xác nhận đăng ký mới nhà xe</h4>

<table class="table">
    <tr>
        <th>Mã nhà xe</th>
        <th>Tên nhà xe</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>
    <c:forEach items="${garageList}" var="g"> 
        <c:if test="${g.isAllowed == false}">
            <tr>
                <td>${g.id}</td>
                <td>${g.name}</td>
                <td>
                    <c:if test="${g.isAllowed == false}">
                        <span>Chưa được đăng ký</span>
                    </c:if>
                    <c:if test="${g.isActive == true}">
                        <span>Đã được đăng ký</span>
                    </c:if>
                </td>
                <td>
                    <button class="btn btn-primary" onclick="confirmRegisterGarage(${g.id}, true)">Xác nhận yêu cầu</button>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<script src="<c:url value="/resources/js/main.js" />"></script>