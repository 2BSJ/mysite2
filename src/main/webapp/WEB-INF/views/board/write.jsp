<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="${pageContext.servletContext.contextPath}/board/writeboard">
					<c:if test="${!empty vo}">
					<input type = "hidden" name = "groupNo" value="${vo.groupNo}">
					<input type = "hidden" name = "orderNo" value="${vo.orderNo}">
					<input type = "hidden" name = "depth" value="${vo.depth}">
					</c:if>
					<input type = "hidden" name = "userNo" value="${authUser.no}">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
							<td>
							${vo.groupNo}
							${vo.orderNo }
								${vo.depth }
								
								
							</td>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" placeholder="제목입력하세영"></td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="contents" placeholder="내용입력하세영"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board/list">취소</a>
						<input type="submit" value="등록">
					</div>
				</form>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>