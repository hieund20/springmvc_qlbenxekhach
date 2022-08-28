<%-- 
    Document   : index
    Created on : Jul 17, 2022, 12:27:15 PM
    Author     : HIEU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="w-100 mt-5">
    <h5 class="text-primary">Danh sách nhà xe</h5>
    <div class="d-flex w-100 flex-wrap justify-content-between">
        <c:forEach items="${garageList}" var="g">
            <c:if test="${g.isActive == true && g.isAllowed == true}">
                <c:url value="/" var="gUrl">
                    <c:param name="id" value="${g.id}" />
                </c:url>

                <div class="card w-30">
                    <img class="card-img-top" src="${g.thumbnail}" alt="Card image cap" style="height: 300px;">
                    <div class="card-body">
                        <p class="card-title text-info"><b>${g.name}</b></p>      
                        <p class="card-title text-info">Trạng thái: Đang hoạt động
                        </p>
                        <a href="<c:url value="/garages/${g.id}" />" class="btn btn-primary">Tìm tuyến xe</a>
                    </div>
                </div>       
            </c:if>

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