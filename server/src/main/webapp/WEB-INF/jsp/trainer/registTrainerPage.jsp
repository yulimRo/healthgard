<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" flush="true" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12 text-center m-4">
	<h1>신규 트레이너 등록</h1>
</div>
<div class="col-md-12 mt-1">
    <div class="col-md-12 text-center">
        <form>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">이름</label>
                <div class="col-sm-8">
                	<input type="text" class="form-control trainer-save-form" id="name" placeholder="이름을 입력해주세요">
                </div>
            </div>
            <div class="form-group row">
                <label for="dept" class="col-sm-2 col-form-label">소속 지점명</label>
                <div class="col-sm-8">
                	<input type="text" class="form-control trainer-save-form" id="dept" placeholder="소속지점명을 입력해주세요">
                </div>
            </div>
            
        </form>
        <div class="text-center">
			<a href="/" role="button" class="btn btn-secondary">취소</a>
			<button type="button" class="btn btn-primary" id="trainerSaveBtn">등록</button>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp" flush="true" />