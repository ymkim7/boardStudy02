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
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="/WEB-INF/views/include/header.jsp" %>
			</div>
		</header>
		
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="/WEB-INF/views/include/nav.jsp" %>
			</div>
		</nav>
		
		<section id="container">
			<div id="container_box">
				<section id="content">
					<form role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">아이디</label>
							<input type="email" id="userId" name="userId" required="required"/>
						</div>
						
						<div class="input_area">
							<label for="userPass">패스워드</label>
							<input type="password" id="userPass" name="userPass" required="required"/>
						</div>
						
						<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
						
						<c:if test="${msg == false }">
							<p style="color:#f00;">로그인에 실패했습니다.</p>
						</c:if>
					</form>
				</section>
			</div>
		</section>
		
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="/WEB-INF/views/include/footer.jsp" %>
			</div>
		</footer>
	</div>
</body>
</html>