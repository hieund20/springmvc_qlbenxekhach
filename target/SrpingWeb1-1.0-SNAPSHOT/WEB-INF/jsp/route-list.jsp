<%-- 
    Document   : route-list
    Created on : Aug 22, 2022, 7:58:35 PM
    Author     : HIEU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="w-100 mt-5">
    <h4>${garage.name}</h4>
    <br/>
    <h5 class="text-primary">Danh sách tuyến</h5>
    <br/>
    <div class="d-flex w-100 flex-wrap justify-content-between">
        <c:forEach items="${routeList}" var="r">
            <c:url value="/" var="rUrl">
                <c:param name="id" value="${r.id}" />
            </c:url>

            <div class="card w-30">
                <img class="card-img-top" src="${r.thumbnail}" alt="Card image cap">
                <div class="card-body">
                    <p class="card-title text-info"><b>${r.departure} ⇒ ${r.destination}</b></p>                  
                    <p class="card-text">Giá vé: ${r.price} VND</p>
                    <a href="<c:url value="/routes/${r.id}" />" class="btn btn-primary">Xem tuyến</a>
                </div>
            </div>
        </c:forEach>
    </div>    
    <br/>
    <br/>
    <h5 class="text-primary">Bình luận về nhà xe</h5>
    <br/>
    <c:if test="${currentUser != null}">
        <form>
            <div class="form-group">
                <textarea class="form-control" 
                          id="commentId"
                          placeholder="Nhập bình luận của bạn..."></textarea>
                <br/>
                <input type="button" value="Gửi bình luận" class="btn btn-primary" onclick="addComment(${garage.id}, ${currentUser.id})"/>
            </div>
        </form>
    </c:if>
    <c:if test="${currentUser == null}">
        <h4><b>Vui lòng đăng nhập để bình luận</b></h4>
    </c:if>
    <br/>

    <div id="commentArea">
        <c:forEach items="${garage.commentCollection}" var="comment">
            <div style="margin-bottom: 4px;">
                <img src="https://res.cloudinary.com/dwgjmgf6o/image/upload/v1661172802/L%E1%BA%ADp%20tr%C3%ACnh%20Java/Garage_Thumbnail/baytau_xrqp5w.jpg" 
                     alt="Avatar" 
                     class="avatar" 
                     style="vertical-align: middle;
                     width: 50px;
                     height: 50px;
                     border-radius: 50%;">
                <span style="margin-left: 4px"><b>${comment.userId.user_name}</b></span>
                <span style="margin-left: 4px"><i id="commentCreatedDate">${comment.created_date}</i></span>
            </div>
            <p style="margin-left:60px">${comment.content}</p>
        </c:forEach>
    </div>
</div>
        
<script src=" <c:url value="/resources/js/main.js" />"></script>
<script>
    window.onload = () => {
        let dates = document.querySelectorAll("#commentCreatedDate");
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i];
            d.innerText = moment(d.innerText).fromNow();
        }
        
        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
    };   
</script>
