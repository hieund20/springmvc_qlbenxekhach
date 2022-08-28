/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global fetch, moment */
const addToCart = (routeId, code, routePrice, seatId) => {
    fetch("/QLBenXeKhach/api/cart", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "routeId": routeId,
            "seatId": seatId,
            "code": code,
            "routePrice": routePrice,
            "quantitySeat": 1
        })
    }).then((res) => {
        return res.json();
    }).then((data) => {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
        
        localStorage.setItem("cart-counter-icon", data);
        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");

        //Đổi border màu của ghế
        seatSelected = document.getElementById(`seat-${seatId}`);
        seatSelected.style.borderColor = "#dc3545";

        //Disable btn Chọn ghế
        seatBtnAddSelected = document.getElementById(`btn-seat-add-${seatId}`);
        seatBtnAddSelected.setAttribute("disabled", "disabled");
    });
};

const deleteCart = (routeId) => {
    fetch(`/QLBenXeKhach/api/cart/${routeId}`, {
        method: 'DELETE'
    }).then((res) => {
        return res.json();

    }).then((data) => {
        console.log("check data", data);
        
        localStorage.setItem("cart-counter-icon", data);

        let cartCounterIcon = document.getElementById("cart-counter-icon");
        cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
        
        location.reload();
    });
};

const pay = () => {
    if (confirm("Xác nhận thanh toán") === true) {
        fetch(`/QLBenXeKhach/api/pay`, {
            method: 'POST'
        }).then((res) => {
            console.log("check res", res);
            return res.json();
        }).then((code) => {
            console.info(code);
            
            localStorage.setItem("cart-counter-icon", 0);
            let cartCounterIcon = document.getElementById("cart-counter-icon");
            cartCounterIcon.innerText = localStorage.getItem("cart-counter-icon");
            
            location.reload();
        });
    }
};

const addComment = (garageId, userId) => {
    fetch("/QLBenXeKhach/api/add-comment", {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Credentials" : true 
        },
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "garageId": garageId,
            "userId": userId
        })
    }).then((res) => {
        location.reload();
        return res.json();
    }).then((data) => {
        console.log("Thêm bình luận thành công")
    });
};

const changeStatusOfGarage = (garageId, isActive) => {
    fetch(`/QLBenXeKhach/api/put-garage/${garageId}`, {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Credentials" : true 
        },
        body: JSON.stringify({
            "isActive": isActive,
        })
    }).then((res) => {
        location.reload();
        return res.json();
    }).then((data) => {
        console.log("Chuyển trạng thái nhà xe thành công");
    });
}

const confirmRegisterGarage = (garageId, isAllowed) => {
    fetch(`/QLBenXeKhach/api/confirm-garage/${garageId}`, {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Credentials" : true 
        },
        body: JSON.stringify({
            "isAllowed": isAllowed,
        })
    }).then((res) => {
        location.reload();
        return res.json();
    }).then((data) => {
        console.log("Xác nhận đăng ký nhà xe thành công");
    });
}
