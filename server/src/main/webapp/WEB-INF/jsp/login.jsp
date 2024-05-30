<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" flush="true"/>
<p> 로그인 </p>

<input type="text"/>
<input type="password" />

<a href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
<a href="/oauth2/login" class="btn btn-success active" role="button">Login</a>

<jsp:include page="layout/footer.jsp" flush="true"/>