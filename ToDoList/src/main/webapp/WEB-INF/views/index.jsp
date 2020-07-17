<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<!-- google fonts -->
<link href="https://fonts.googleapis.com/css?family=Courgette"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic"
	rel="stylesheet">
<link rel="stylesheet"
	type="text/css" href="/static/css/index.css" />
<script src="/static/js/indexJS.js"></script>
<title>To Do List</title>
</head>
<body>
	<div class="out">
		<div class="list-box">
		<h1>To Do List</h1>
		<form role="form" action="/todo/input" method="post" class="input_form">
			<div class="write-box">
			<input type="text" name='content' class="text-basic">
			<button type="submit" id="btnAdd">추가</button>
		</div>
		</form>
		<table class="list-table">
			<colgroup>
				<col width="10%">
				<col width="90%">
			</colgroup>
			<thead>
				<tr>
					<th>check</th>
					<th colspan="2">To do List</th>
				</tr>
			</thead>
			<tbody id="listBody">
			<c:forEach items="${list}" var="todo">
				<tr>
					<td><input type="checkbox" class="btn-chk" value="<c:out value="${todo.num}" />" ></td>
					<td colspan="2" id="td_p">
						<c:if test="${todo.status eq '미완료'}">
							<p id="content_style<c:out value='${todo.num}' />" class="p_content" onclick='update_status("${todo.num}","${todo.status}");'>
							<c:out value="${todo.content}"/>
							</p>
						</c:if>
						<c:if test="${todo.status eq '완료'}">
							<p id="content_style<c:out value='${todo.num}' />" class="p_content" onclick='update_status("${todo.num}","${todo.status}");'
							style="text-decoration: line-through; color: #7d7d7d;">
							<c:out value="${todo.content}"/>
							</p>
						</c:if>
						<input type="button" id="btn_update" value="수정" onclick='update_content_style("${todo.num}","${todo.content}");'>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="btn-area">
			<input type="button" id="DeleteSel" class="btn_delete" onclick="delete_sel();" value="선택 삭제">
			<input type="button" id="btnDelAll" class="btn_delete" onclick="delete_sel();" value="전체 삭제">
		</div>
	</div>
	</div>
</body>
</html>