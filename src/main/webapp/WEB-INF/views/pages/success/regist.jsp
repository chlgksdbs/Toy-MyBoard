<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../components/header.jsp" %>
<script>
	alert("${successMsg}");
	location.href="${root}";
</script>
<%@ include file="../../components/footer.jsp" %>
