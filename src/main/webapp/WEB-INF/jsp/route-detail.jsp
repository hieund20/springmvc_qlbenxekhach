<%-- 
    Document   : route-detail
    Created on : Aug 7, 2022, 11:11:31 AM
    Author     : HIEU
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="w-80 m-0-auto mt-5">
    <h5 class="text-primary">Tuyến ${route.departure} ⇒ ${route.destination}</h5>
    <p class="mt-3 text-secondary">Chọn giờ lên xe đi ${route.destination} từ ${route.departure} phù hợp</p>
    <div class="mt-3">
        <c:forEach items="${tripList}" var="t">
            <c:url value="/" var="tUrl">
                <c:param name="id" value="${t.id}" />
            </c:url>
            <div class="card w-100 mb-3">
                <div class="card-body">
                    <h6 class="card-title">Ngày: ${t.departure_date} - Giờ khởi hành: ${t.start_time}</h6>
                    <h6 class="card-subtitle mb-2 text-muted">Giá vé: ${route.price} VND</h6>
                    <a href="<c:url value="/trips?tripId=${t.id}&routeId=${route.id}" />" class="card-link">Đặt chỗ</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
    
<script>
    window.onload = () =>
    {        
        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
    };
</script>