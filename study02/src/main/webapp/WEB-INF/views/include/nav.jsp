<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title></title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<ul>
		<c:if test="${member == null }">
			<li><a href="/member/signin">로그인</a></li>
			<li><a href="/member/signup">회원가입</a></li>
		</c:if>
		
		<c:if test="${member != null }">
			<c:if test="${member.verify == 9 }">
				<li><a href="/admin/index">관리자</a></li>
			</c:if>
		
			<li>${member.userName }님 환영합니다.</li>
			<li><a href="/shop/cartList">카트리스트</a></li>
			<li><a href="/shop/orderList">주문리스트</a></li>
			<li><a href="/member/signout">로그아웃</a></li>
		</c:if>
	</ul>
</body>
</html>