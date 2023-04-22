<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp" %>
<script>
	alert("해당 게시글에 권한이 없습니다.");
	location.href="${root}/board/list";
</script>
<%@ include file="../../components/footer.jsp" %>