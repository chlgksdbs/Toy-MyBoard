<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp"%>
<div class="container">
	<form action="${root}/board/write" method="post">
		<table class="table">
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" maxlength="30" style="width: 192px;" /></td>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bcontent" cols="20" maxlength="300"></textarea></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" value="작성"/>
	</form>
</div>
<%@ include file="../../components/footer.jsp"%>
