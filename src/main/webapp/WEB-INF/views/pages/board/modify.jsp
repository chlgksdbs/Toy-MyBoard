<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp"%>
<div class="container">
	<form action="${root}/board/modify" method="post">
	<input type="hidden" name="bno" value="${board.bno}" />
	<input type="hidden" name="bwriter" value="${board.bwriter}" />
	<input type="hidden" name="bwriteDate" value="${board.bwriteDate}" />
		<table class="table">
			<tr class="text-center">
				<td>번호</td>
				<td>${board.bno}</td>
			</tr>
			<tr class="text-center">
				<td>제목</td>
				<td><input type="text" name="btitle" value="${board.btitle}"
					maxlength="30" style="width: 192px;" /></td>
			</tr>
			<tr class="text-center">
				<td>작성자</td>
				<td>${board.bwriter}</td>
			</tr>
			<tr class="text-center">
				<td>내용</td>
				<td><textarea rows="10" name="bcontent" cols="20"
						maxlength="300">${board.bcontent}</textarea></td>
			</tr>
			<tr class="text-center">
				<td>작성일시</td>
				<td>${board.bwriteDate}</td>
			</tr>
		</table>
		<div class="container text-center">
			<a href="${root}/board/view?bno=${board.bno}" class="btn btn-primary">이전</a>
			<input type="submit" class="btn btn-success" value="수정" />
		</div>
	</form>
</div>
<%@ include file="../../components/footer.jsp"%>
