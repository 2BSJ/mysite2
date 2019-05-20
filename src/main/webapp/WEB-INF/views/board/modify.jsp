<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
				<form class="board-form" method="post" action="">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">ê¸ìì </th>
						</tr>
						<tr>
							<td class="label">ì ëª©</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">ë´ì©</td>
							<td>
								<textarea id="content" name="content">ìì í´ì¼ í  ê¸ì ê³ ëë¡ 
ì´ë ê² textareaì ë¿ë ¤ì¼ í©ëë¤.
ê°íë¬¸ì ë³ê²½ë íì§ë§ì¸ì.
ííííí
ì¦ê±´ ì½ë© ëì¸ì~~~~</textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="">ì·¨ì</a>
						<input type="submit" value="ìì ">
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