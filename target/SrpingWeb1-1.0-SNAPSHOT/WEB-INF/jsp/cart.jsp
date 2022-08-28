<%-- 
    Document   : cart
    Created on : Aug 13, 2022, 10:31:10 AM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Các vé đã đặt</h1>

<c:if test="${carts == null}">
    <h4 class="text-dark">Không có vé nào được đặt !!</h4>
</c:if>
<c:if test="${carts != null}">
    <table class="table">
        <tr>
            <th>Mã ghế (Seat ID)</th>
            <th>Vị trí ghế</th>
            <th>Giá vé</th>
            <th>Route id</th>
            <th></th>
        </tr>    
        <c:forEach items="${carts}" var="c">
            <tr>
                <td>
                    ${c.seatId}
                </td>
                <td>
                    ${c.code}
                </td> 
                <td>
                    ${c.routePrice} VND
                </td>
                <td>
                    ${c.routeId}
                </td>
                <td>
                    <input type="button" 
                           value="Xóa" 
                           class="btn btn-danger" 
                           onclick="deleteCart(${c.seatId})"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>Thành tiền: ${cartStats.amount} VND</p>
    <button class="btn btn-primary" onclick="pay()">Thanh toán</button>
</c:if>
    
<script src=" <c:url value="/resources/js/main.js" />"></script>

<script>
    window.onload = () =>
    {        
        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
    };
</script>