<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" flush="true"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12 mt-5">
<h1> 메인화면 </h1>
</div>
<div class="col-md-12 mt-3">
	<c:if test="${userName != null}">
		<a href="/logout" class="d-inline p-2 bg-danger text-white btn active" role="button"> 로그아웃 </a>
	</c:if>
	<c:if test="${userName == null || userName eq ''}">
		<a href="/login" class="d-inline p-2 bg-primary btn text-white active" role="button"> 로그인 </a>
		<a href="/join" class="ml-1 d-inline p-2 bg-dark text-white btn active" role="button"> 회원가입 </a>
	</c:if>
</div>
<jsp:include page="layout/footer.jsp" flush="true"/>