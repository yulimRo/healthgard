<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" flush="true" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12 m-3">
	<h1>메인화면</h1>
</div>
<div class="col-md-12 m-3">
	<c:if test="${userName != null}">
		<a href="/logout" class="d-inline p-2 bg-danger text-white btn active" role="button"> 로그아웃 </a>
	</c:if>
	<c:if test="${userName == null || userName eq ''}">
		<a href="/login" class="d-inline p-2 bg-primary btn text-white active" role="button"> 로그인 </a>
		<a href="/join"class="ml-1 d-inline p-2 bg-dark text-white btn active" role="button">
			회원가입 </a>
	</c:if>
</div>
<c:if test="${userName != null}">
<form class="col-md-12 mlr-3 justify-content-end form-inline">
	<a href="/noticeList" class="col-md-2 mr-2  d-inline p-2 bg-dark text-white btn active" role="button"> 공지사항 조회</a>
	<a href="/registTrainer" class="col-md-2  d-inline p-2 bg-dark text-white btn active" role="button"> 트레이너정보 등록 </a>
</form>

<div class="col-md-12 mt-3">
<!-- 목록 출력 영역 -->
<table class="table table-horizontal table-bordered  mr-3">
	<thead class="thead-strong">
		<tr>
			<th>이름</th>
			<th>소속</th>
			<th>나이</th>
			<th>최종수정일</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${trainers == null || trainers eq ''}">
		<tr>
			<td>${trainer.id}</td>
			<td>${trainer.name}</td>
			<td>${trainer.dept}</td>
			<td>${trianer.updateDate}</td>
			<td></td>
		</tr>
	</c:if>
	<c:if test="${trainers != null}">
		<!-- posts 라는 List를 순회-->
		<c:forEach var="trainer" items="${trainers}">
				<tr>
				<td>${trainer.id}</td>
				<td>${trainer.name}</td>
				<td>${trainer.dept}</td>
				<td>${trainer.updateDate}</td>
				<td><button class="btn btn-info" id="trainerSelectBtn" >수정</button></td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
</div>

<div class="col-md-12 d-none" id="previewTrainerDetail">
<!-- 목록 출력 영역 -->
<table class="table table-horizontal table-bordered mr-3">
	<input type="hidden" id="selectTrainerId" value=""/>
	<tr class="col-md-12">
		<th class="col-md-2">이름</th>
		<td class="col-md-9"><input type="text" class="form-control trainer-update-form" id="name" value="${trainer.name}"></td>
	</tr>
	<tr>
		<th>소속지점</th>
		<td><input type="text" class="form-control trainer-update-form" id="dept" value="${trainer.dept}"></td>
	</tr>
	<tr>
		<th>생성일자</th>
		<td><p class="trainer-update-form" id="createDate">${trainer.createDate}</p></td>
	</tr>
	<tr>
		<th>변경일자</th>
		<td><p class="trainer-update-form" id="updateDate">${trainer.update}</p></td>
	</tr>
</table>
<button type="button" class="btn btn-info" id="trainerUpdateBtn">수정</button>
<button type="button" class="btn btn-danger" id="trainerRemoveBtn">삭제</button>

</div>
</c:if>
<jsp:include page="layout/footer.jsp" flush="true" />