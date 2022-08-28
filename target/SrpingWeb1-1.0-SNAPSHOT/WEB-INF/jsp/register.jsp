<%-- 
    Document   : register
    Created on : Aug 24, 2022, 12:33:15 PM
    Author     : HIEU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top: 48px;">
    <h3 style="margin-top: 48px;">Đăng ký</h3>
    <c:url value="/register" var="action"/>
    <form:form action="${action}" modelAttribute="user" method="post" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div" />
        <div class="form-group">
            <label for="first_name">
                Họ
            </label>
            <form:input path="first_name" id="first_name" 
                        cssClass="form-control" />
            <form:errors path="first_name" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="last_name">
                Tên
            </label>
            <form:input path="last_name" id="last_name" 
                        cssClass="form-control" />
            <form:errors path="last_name" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="emailId">
                Email
            </label>
            <form:input path="email" id="emailId" 
                        cssClass="form-control" />
            <form:errors path="email" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="phoneId">
                Số điện thoại
            </label>
            <form:input path="phone" id="phoneId" 
                        cssClass="form-control" />
            <form:errors path="phone" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="usernameId">
                Tên đăng nhập
            </label>
            <form:input path="user_name" id="usernameId" cssClass="form-control" />
            <form:errors path="user_name" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="passwordId">
                Mật khẩu
            </label>
            <form:input id="passwordId" path="password" 
                        cssClass="form-control" type="password" />
            <form:errors path="password" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="confirmPasswordId">
                Xác nhận mật khâu
            </label>
            <form:input id="confirmPasswordId" path="confirmPassword" 
                        cssClass="form-control" type="password" />
            <form:errors path="confirmPassword" cssClass="text-danger" />
        </div>
        <br/>
        <div class="form-group">
            <label for="file">Avatar</label>
            <form:input type="file" id="file" path="file" cssClass="form-control"/>
        </div>
        
        <br/>
        <div class="form-group">
            <form:button class="pull-right btn btn-primary">
                Đăng ký
            </form:button>
        </div>
    </form:form>
</div>
