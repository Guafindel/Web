<%@page import="member.LoginInfo"%>
<%@page import="member.MemberLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="userInfo" class="member.MemberInfo" scope="session"/>
<jsp:setProperty property="*" name="userInfo"/> --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery CDN 1.12.4 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="/jsp01/css/default.css" rel="stylesheet" type="text/css">

<!-- 스타일 시작 -->
<style>
</style>
<!-- 스타일 끝 -->

</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>

	<!-- 헤더 시작 -->
	<%@ include file="../frame/header.jsp"%>
	<!-- 헤더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="../frame/nav.jsp"%>
	<!-- 네이게이션 끝 -->

	<!-- 컨테이너 시작 -->
	<div id="container">
		<%
			if(loginInfo != null) {
			
			
		%>
		<h3>회원 정보 저장 페이지.</h3>
		${sessionScope.loginInfo} <!-- == Map.get("loginInfo") -->
		
		<hr>
			<%-- <img src="../images/<%=loginInfo.getuPhoto() %>"> --%> <img src="../images/${loginInfo.uPhoto}">
			<%-- <h4>이름 : <%= loginInfo.getuName() %> --%>  <h4>${loginInfo.uName}</h4>.
			<%-- <h4>아이디 : <%= loginInfo.getuId() %> --%>  <h4>${loginInfo.uId }</h4>
	
		<%
			} else {
		%>
		<script>
			alert('로그인 후 이용가능한 페이지 입니다.');
			location.href='login.jsp';
		</script>
		<%
			}
		%>

	</div>
	<!-- 컨테이너 끝 -->

	<!-- 푸터 시작 -->
	<%@ include file="../frame/footer.jsp"%>
	<!-- 푸터 끝 -->



</body>
</html>