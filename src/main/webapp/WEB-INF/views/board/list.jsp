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
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:forEach items='${list }' var='vo' varStatus='status'>
						<tr>
							<td>${vo.no}</td>

							<c:choose>
								<c:when test="${vo.depth!=1 }">
									<td style="text-align:left; padding-left:${vo.depth*15}px">
										<img
										src="${pageContext.servletContext.contextPath }/assets/images/reply.png" />
								</c:when>
								<c:otherwise>
									<td style="text-align: left;">
								</c:otherwise>
							</c:choose>
							<a
								href="${pageContext.servletContext.contextPath}/board/view?no=${vo.no}">${vo.title}</a>
							</td>
							<td>${vo.name}</td>
							<td>${vo.hit}</td>
							<td>${vo.regDate}</td>
							<td><c:if test="${authUser.no==vo.userNo}">

									<a
										href="${pageContext.servletContext.contextPath}/board/delete?no=${vo.no}"
										class="del">삭제</a>
								</c:if></td>
						</tr>
					</c:forEach>
					<!-- 					<tr> -->
					<!-- 						<td>2</td> -->
					<%-- 						<td style="text-align:left; padding-left:${5*1}"><img --%>
					<%-- 							src='${pageContext.servletContext.contextPath}/assets/images/reply.png'><a --%>
					<!-- 							href="">두 번째 글입니다.</a></td> -->
					<!-- 						<td>안대혁</td> -->
					<!-- 						<td>3</td> -->
					<!-- 						<td>2015-10-02 12:04:12</td> -->
					<!-- 						<td><a href="" class="del">삭제</a></td> -->
					<!-- 					</tr> -->

				</table>

				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<c:forEach begin='1' end='5' var="page">
							<c:choose>
								<c:when test="${page==count}">
									<li class="selected"><a href="">${page}</a></li>
								</c:when>
								<c:otherwise>
									<li ><a href="">${page}</a></li>
								</c:otherwise>
								
							</c:choose>
						</c:forEach>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<!-- pager 추가 -->


				<c:if test='${!empty authUser}'>
					<div class="bottom">
						<a href="${pageContext.servletContext.contextPath }/board/gowrite"
							id="new-book">글쓰기</a>
					</div>
				</c:if>

			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>