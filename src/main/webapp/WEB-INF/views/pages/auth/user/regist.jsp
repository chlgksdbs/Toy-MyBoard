<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../components/header.jsp" %>
<div class="container text-center mt-5">
	<form action="${root}/user/regist" method="post">
		<div class="row mb-2 d-flex justify-content-center">
			<div class="col col-lg-5">
				<input type="text" name="userId" placeholder="아이디" />
			</div>
		</div>
		<div class="row mb-2 d-flex justify-content-center">
			<div class="col col-lg-5">
				<input type="text" name="userName" placeholder="이름" />
			</div>
		</div>
		<div class="row mb-2 d-flex justify-content-center">
			<div class="col col-lg-5">
				<input type="password" name="userPw" placeholder="비밀번호" />
			</div>
		</div>
		<div class="row mt-3 d-flex justify-content-center">
			<div class="col col-lg-5">
				<input type="submit" value="회원가입" class="btn btn-primary" style="width: 185px;" />
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../components/footer.jsp" %>
