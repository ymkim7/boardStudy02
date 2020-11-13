<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<style>
	body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
	ul { padding:0; margin:0; list-style:none;  }
	
	div#root { width:90%; margin:0 auto; }
	
	header#header { font-size:60px; padding:20px 0; }
	header#header h1 a { color:#000; font-weight:bold; }
	
	nav#nav { padding:10px; text-align:right; }
	nav#nav ul li { display:inline-block; margin-left:10px; }
	
	section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	aside { float:left; width:200px; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }
	
	aside ul li { text-align:center; margin-bottom:10px; }
	aside ul li a {display:block; width:100%; padding:10px 0;}
	aside ul li a:hover {background:#eee;}
	
	footer#footer { background:#f9f9f9; padding:20px; }
	footer#footer ul li { display:inline-block; margin-right:10px; }
</style>

<style>
	.inputArea { margin:10px 0; }
	.select_img img { width:500px; margin:20pz 0; }
	.gdsDes img { max-width:400px; height:auto; }
	select { width:100px; }
	label { display:inline-block; width:70px; padding:5px; }
	label[for='gdsDes'] { display:block; }
	input { width:150px; }
	textarea#gdsDes { width:400px; height:180px; }
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/ckeditor/ckeditor.js"></script>
<title></title>
</head>
<script type="text/javascript">
var select_cateCode = '${goods.cateCode}';
var select_cateCodeRef = '${goods.cateCodeRef}';
var select_cateName = '${goods.cateName}';
var regExp = /[^0-9]/gi;
$("#gdsPrice").keyup(function({numCheck($(this));});
$("#gdsStock").keyup(function({numCheck($(this));});
	
	$(document).ready(function(){
		$("#back_Btn").click(function(){
			location.href = "/admin/goods/view?n=" + ${goods.gdsNum};
		});
		
		if(select_cateCodeRef != null && select_cateCodeRef != ''){
			$(".category1").val(select_cateCodeRef);
			$(".category2").val(select_cateCode);
			$(".category2").children().remove();
			$(".category2").append("<option value='" + select_cateCode + "'>" + select_cateName + "</option>");
		} else {
			$(".category1").val(select_cateCode);
			$(".category2").append("<option value='" + select_cateCode + "' selected='selected'>전체</option>");
		}
		
		$("#gdsImg").change(function(){
			if(this.files && this.files[0]) {
				var reader = new FileReader;
				
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(500);
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
	});
	
	function numCheck(selector) {
		var tempVal = selector.val();
		selecttor.val(tempVal.replace(regExp, ""));
	}
	
</script>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="/WEB-INF/views/admin/include/header.jsp" %>
			</div>
		</header>
		
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="/WEB-INF/views/admin/include/nav.jsp" %>
			</div>
		</nav>
		
		<section id="container">
			<aside>
				<%@ include file="/WEB-INF/views/admin/include/aside.jsp" %>
			</aside>
			<div id="container_box">
				<h2>상품수정</h2>
				
				<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">
					<input type="hidden" id="gdsNum" name="gdsNum" value="${goods.gdsNum }"/>
					
					<div class="inputArea">
						<label>1차 분류</label>
						<select class="category1">
							<option value="">전체</option>
						</select>
						
						<label>2차 분류</label>
						<select class="category2" name="cateCode">
							<option value="">전체</option>
						</select>
					</div>
					
					<div class="inputArea">
						<label for="gdsName">상품명</label>
						<input type="text" id="gdsName" name="gdsName" value="${goods.gdsName }"/>
					</div>
					
					<div class="inputArea">
						<label for="gdsPrice">상품가격</label>
						<input type="text" id="gdsPrice" name="gdsPrice" value="${goods.gdsPrice }"/>
					</div>
					
					<div class="inputArea">
						<label for="gdsStock">상품수량</label>
						<input type="text" id="gdsStock" name="gdsStock" value="${goods.gdsStock }"/>
					</div>
					
					<div class="inputArea">
						<label for="gdsDes">상품소개</label>
						<textarea rows="5" cols="50" id="gdsDes" name="gdsDes">${goods.gdsDes }</textarea>
						
						<!-- CK에디터 사용 -->
						<script type="text/javascript">
							var ckeditor_config = {
									resize_enaleb : false
									, enterMode : CKEDITOR.ENTER_BR
									, shiftEnterMode : CKEDITOR.ENTER_P
									, filebrowserUploadUrl : "/admin/goods/ckUpload"
							};
							CKEDITOR.replace("gdsDes", ckeditor_config);
						</script>
						
					</div>
					
					<div class="inputArea">
						<label for="gdsImg">이미지</label>
						<input type="file" id="gdsImg" name="file"/>
						
						<div class="select_img">
							<img src="${goods.gdsImg }">
							<input type="hidden" name="gdsImg" value="${goods.gdsImg }"/>
							<input type="hidden" name="gdsThumbImg" value="${goods.gdsThumbImg }"/>
						</div>
						
						<%=request.getRealPath("/") %>
						
					</div>
					
					<div class="inputArea">
						<button class="btn btn-primary" type="submit" id="update_Btn" name="update_Btn">완료</button>
						<button class="btn btn-warning" type="submit" id="back_Btn" name="back_Btn">취소</button>
					</div>
				</form>
				
			</div>
		</section>
		
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="/WEB-INF/views/admin/include/footer.jsp" %>
			</div>
		</footer>
	</div>
</body>
</html>