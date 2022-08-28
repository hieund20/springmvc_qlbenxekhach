<%-- 
    Document   : seat
    Created on : Aug 7, 2022, 3:50:05 PM
    Author     : HIEU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="m-0-auto w-80 mt-5">
    <h5 class="text-primary">Tuyến ${route.departure} ⇒ ${route.destination}</h5>
    <p class="mt-3 text-secondary"><b>Danh sách chỗ</b></p>
    <div class="card card-body">
        <div class="row w-80 m-0-auto">
            <div class="col">
                <div class="d-flex w-100 flex-wrap">
                    <c:forEach items="${seatList}" var="s">
                        <div class="w-50 d-flex justify-content-center">
                            <div class="w-30 d-flex justify-content-between mb-3">
                                <div class="d-flex align-items-center rounded" 
                                     style="border: 1px solid #dee2e6"
                                     id="seat-${s.id}">
                                    <div class="text-secondary">${s.code}</div>
                                </div>
                                <button class="btn btn-primary" 
                                        id="btn-seat-add-${s.id}"
                                        onclick="addToCart(${route.id}, '${s.code}', ${route.price}, ${s.id})">Chọn</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="d-flex mt-4 justify-content-center">
                    <div class="d-flex">
                        <div class="border border rounded" 
                             style="width: 25px; height: 25px;">
                        </div>Trống
                    </div>

                    <div class="d-flex">
                        <div style="width: 25px; height: 25px">
                        </div>
                    </div>

                    <div class="d-flex">
                        <div class="border border-danger rounded mr-3" 
                             style="width: 25px; height: 25px">
                        </div>Đã đặt
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="">
            <p class="text-dark"><b><span id="cartCounter"></span> Vé</b></p>
        </div>
        <a href="<c:url value="/cart" />" class="btn btn-primary">Tiếp theo</a>
    </div>
</div>

<script src=" <c:url value="/resources/js/main.js" />"></script>
<script>
    window.onload = () =>
    {
        let counter = document.getElementById("cartCounter");
        counter.innerText = 0;
        
        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
    };
</script>




