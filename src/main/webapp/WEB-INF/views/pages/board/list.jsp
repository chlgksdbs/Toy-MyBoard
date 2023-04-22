<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp"%>
<div class="container text-center mb-3">
	<div class="row">
		<div class="col d-flex justify-content-start">
			<a href="${root}/board/write" class="btn btn-primary">글작성</a>
		</div>
	</div>
</div>
<div class="container">
	<table class="table table-striped">
		<tr class="text-center">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
		<c:forEach var="board" items="${boardList}">
			<tr class="text-center">
				<td>${board.bno}</td>
				<td><a href="${root}/board/view?bno=${board.bno}" style="text-decoration: none;">${board.btitle}</a></td>
				<td>${board.bwriter}</td>
				<td>${board.bwriteDate}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../../components/footer.jsp"%>
