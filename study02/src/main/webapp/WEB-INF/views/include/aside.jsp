<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>카테고리</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<h3>카테고리</h3>
	<ul>
		<li><a href="/shop/list?c=100&l=1">무기</a>
			<ul class="low">
		 		<li><a href="/shop/list?c=101&l=1">돌격소총</a></li>
		 		<li><a href="/shop/list?c=102&l=1">기관단총</a></li>
		 		<li><a href="/shop/list?c=103&l=1">경기관총</a></li>
		 		<li><a href="/shop/list?c=104&l=1">산탄총</a></li>
		 		<li><a href="/shop/list?c=105&l=1">지정사수소총</a></li>
		 		<li><a href="/shop/list?c=106&l=1">저격소총</a></li>
		 		<li><a href="/shop/list?c=107&l=1">기타</a></li>
		 	</ul>
		 </li>
		 <li><a href="/shop/list?c=200&l=1">탄약</a></li>
		 <li><a href="/shop/list?c=300&l=1">방어구</a></li>
		 <li><a href="/shop/list?c=400&l=1">회복제</a></li>
	 </ul>
</body>
</html>