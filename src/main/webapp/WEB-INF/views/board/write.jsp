<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>MySite</h1>
			<ul>
				<li><a href="">ë¡ê·¸ì¸</a><li>
				<li><a href="">íìê°ì</a><li>
				<li><a href="">íìì ë³´ìì </a><li>
				<li><a href="">ë¡ê·¸ìì</a><li>
				<li>ë ìëíì¸ì ^^;</li>
			</ul>
		</div>
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="/board">
					<input type = "hidden" name = "a" value="write">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">ê¸ì°ê¸°</th>
						</tr>
						<tr>
							<td class="label">ì ëª©</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">ë´ì©</td>
							<td>
								<textarea id="content" name="content"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="/board">ì·¨ì</a>
						<input type="submit" value="ë±ë¡">
					</div>
				</form>				
			</div>
		</div>
		<div id="navigation">
			<ul>
				<li><a href="">ìëí</a></li>
				<li><a href="">ë°©ëªë¡</a></li>
				<li><a href="">ê²ìí</a></li>
			</ul>
		</div>
		<div id="footer">
			<p>(c)opyright 2015, 2016, 2017, 2018</p>
		</div>
	</div>
</body>
</html>