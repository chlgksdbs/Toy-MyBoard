<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한윤개발부스</title>
<link href="${root}/resources/favicon.ico" rel="icon">
<!-- Bootstrap v5.2.3 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container" style="display: flex; justify-content: right;">
			<!-- 로그인 정보가 없는 경우 -->
			<c:if test="${empty sessionScope.loginInfo}">
				<a href="${root}/user/login" class="btn btn-primary me-2">로그인</a>
				<a href="#" class="btn btn-primary me-2">회원가입</a>
			</c:if>
			<!-- 로그인 정보가 있는 경우 -->
			<c:if test="${not empty sessionScope.loginInfo}">
				${loginInfo.userName}(${loginInfo.userId})님 환영합니다!
				<a href="${root}/user/logout" class="btn btn-primary ms-2">로그아웃</a>
			</c:if>
		</div>
	</nav>
	<div class="container">
			<h1 class="text-center mt-5 mb-5">
			<a href="${root}" style="text-decoration: none;"> <mark>한윤이의 개발 놀이터</mark>
			</a>
		</h1>
	</div>