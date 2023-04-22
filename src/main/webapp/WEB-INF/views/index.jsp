<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<div class="container text-center">
	<div class="row justify-content-center">
		<div class="card col-lg-2 me-2" style="width: 18rem;">
			<img src="${root}/resources/boardImg.png" class="card-img-top" alt="boardImg">
			<div class="card-body">
				<h5 class="card-title">자유 게시판</h5>
				<p class="card-text">회원 인증 후, 자유롭게 게시글을 작성할 수 있는 게시판</p>
				<a href="${root}/board/list" class="btn btn-primary">이동</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="components/footer.jsp"%>