<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp"%>
<div class="container">
	<table class="table">
		<tr class="text-center">
			<td>번호</td>
			<td>${board.bno}</td>
		</tr>
		<tr class="text-center">
			<td>제목</td>
			<td>${board.btitle}</td>
		</tr>
		<tr class="text-center">
			<td>작성자</td>
			<td>${board.bwriter}</td>
		</tr>
		<tr class="text-center">
			<td>내용</td>
			<td>${board.bcontent}</td>
		</tr>
		<tr class="text-center">
			<td>작성일시</td>
			<td>${board.bwriteDate}</td>
		</tr>
	</table>
</div>
<div class="container text-center">
	<a href="${root}/board/list" class="btn btn-primary">목록</a>
	<a href="${root}/board/modify?bno=${board.bno}" class="btn btn-secondary">수정</a>
	<a href="${root}/board/delete?bno=${board.bno}" class="btn btn-danger">삭제</a>
</div>
<%@ include file="../../components/footer.jsp"%>
