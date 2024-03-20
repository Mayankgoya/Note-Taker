<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class=" container">
		<%@include file="navbar.jsp"%>

		<br>

		<h1>Please Fill Your Form</h1>

		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Title</label> <input required type="text"
					class="form-control" name = "title" id="title" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="context">Context</label>
				<textarea required class="form-control" id="context" name = "context"
					placeholder="Enter your Context" style="height: 300px;">
					
				</textarea>

			</div>

			<div class = "container text-center">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>

		</form>

	</div>
</body>
</html>