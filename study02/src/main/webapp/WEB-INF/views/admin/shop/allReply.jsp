<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<style>

 body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  aside#aside { float:left; width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
 /* ---------- */
 
 header#header div#header_box { text-align:center; padding:30px 0; }
 header#header div#header_box h1 { font-size:50px; }
 header#header div#header_box h1 a { color:#000; }
 
 nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
 nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
 nav#nav div#nav_box li a { color:#333; }
 
 section#container { }
 
 aside#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
 aside#aside li { font-size:16px; text-align:center; }
 aside#aside li a { color:#000; display:block; padding:10px 0; }
 aside#aside li a:hover { text-decoration:none; background:#eee; }
 
 aside#aside li { position:relative; }
aside#aside li:hover { background:#eee; }   
aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
aside#aside li:hover > ul.low { display:block; }
aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
aside#aside li:hover > ul.low li a:hover { background:#fff;}
aside#aside li > ul.low li { width:180px; }
 
 footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }
 footer#footer div#footer_box { padding:0 20px; }
 
 .replyControll {text-align:right; padding:10px; }
.replyControll button { border:2px solid #999; background:#fff; }
 
</style>

<style>
/*
#container_box table { width:900px; }
#container_box table th { font-size:20px; font-weight:bold;
       text-align:center; padding:10px; border-bottom:2px solid #666; }
#container_box table tr:hover { background:#eee; }
#container_box table td { padding:10px; text-align:center; }
#container_box table img { width:150px; height:auto; }
*/

#container_box ul li { margin-bottom:20px; border:10px solid #eee; }
.replyInfo { background:#eee; padding:10px; font-size:18px; }
.replyInfo span { font-size:20px; font-weight:bold; margin-right:20px; }
.replyContent { padding:10px; }
</style>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>study02</title>

<script type="text/javascript">
	
	var formObj = $('form[role="form"]');
	
	$(".delete_btn").click(function(){
		var con = confirm("삭제하시겠습니까?");
		
		if(con) {
			formObj.attr("action", "/admin/shop/deleteReply");
			formObj.submit();
		}
	});
	
</script>
</head>
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
		
		<aside id="aside">
			<%@ include file="/WEB-INF/views/include/aside.jsp" %>
		</aside>
		
		<section id="container">
			<div id="container_box">
				<section id="content">
					<ul>
						<c:forEach items="${reply }" var="reply">
							<li>
								<div class="replyInfo">
									<p><span>작성자</span>${reply.userName } (${reply.userId })</p>
									<p><span>작성된 상품</span><a href="/shop/view?n=${reply.gdsNum }">바로가기</a></p>
								</div>
								<div class="replyContent">${reply.repCon }</div>
								<div class="replyControll">
									<form role="form" method="post">
										<input type="hidden" name="repNum" value="${reply.repNum }"/>
										<button type="button" class="delete_${reply.repNum }_btn" id="delete_btn" name="delete_btn">삭제</button>
									</form>
								</div>
							</li>
						</c:forEach>
					</ul>
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
