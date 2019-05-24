<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/user.css"
	rel="stylesheet" type="text/css">
<!-- <script -->
<%-- 	src="<%=request.getContextPath()%>/assets/js/jquery/jquery-1.9.0.js"></script> --%>
<script>
	// $(function(){
	// 	$('#email').change(function(){
	// 		$('#check-button').show();
	// 		$('#check-img').hide();		
	// 	})
	// 	$('#check-button').click(function(){
	// 		var email = $('#email').val();
	// 		if(email==''){
	// 			return ;
	// 		}

	// 		/*ajax 통신 */
	// 		$.ajax({
	// 			url:"${pageContext.servletContext.contextPath }/user/api/checkemail?email=" + email,
	// 			type:"get",
	// 			dataType:"json",
	// 			data:"",
	// 			success:function(response){
	// 				if(response.result != "success"){
	// 					console.log(response.message);
	// 					return ;
	// 				}

	// 				if(response.data == true){
	// 					alert('이미 존재하는 이메일입니다.\n다른 이메일 사용 ㄱ')
	// 					$('#email').focus();
	// 					$("#email").val("");
	// 					return;
	// 				}

	// 				$('#check-button').hide();
	// 				$('#check-img').show();

	// 			},
	// 			error:function(xhr, error){
	// 				console.error("error:" + error)
	// 			}
	// 		});
	// 		console.log(email);
	// 	})
	// });
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form:form modelAttribute="userVo" id="join-form" name="joinForm"
					method="post"
					action="${pageContext.servletContext.contextPath }/user/join">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">

					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('name') }">
							<p
								style="font-weight: bold; color: red; text-align: left; padding: 0 0 0 0">
								<spring:message
									code="${errors.getFieldError( 'name' ).codes[0] }"
									text="${errors.getFieldError( 'name' ).defaultMessage }" />

							</p>
						</c:if>
					</spring:hasBindErrors>


					<label class="block-label" for="email">이메일</label>
					<form:input path="email" />
					<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('email') }">
							<p
								style="font-weight: bold; color: red; text-align: left; padding: 0 0 0 0">
								<spring:message
									code="${errors.getFieldError( 'email' ).codes[0] }"
									text="${errors.getFieldError( 'email' ).defaultMessage }" />

							</p>
						</c:if>
					</spring:hasBindErrors>
					<input type="button" id="check-button" value="체크">
					<img style="display: none" id="check-img"
						src="${pageContext.servletContext.contextPath }/assets/images/check.png" />
						<p style="font-weight:bold; color:#f00; text-align:left; padding:0; margin:0">
					<form:errors path="email" />
					</p>

					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">

					<fieldset>
						<legend>성별</legend>
						<label>여</label> <form:radiobutton path="gender" value="female" checked="checked"/>
					    <label>남</label> <form:radiobutton path="gender" value="male" />
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
<%-- 						<form:checkbox path="agreeProv" value="y"/> --%>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">

				</form:form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>