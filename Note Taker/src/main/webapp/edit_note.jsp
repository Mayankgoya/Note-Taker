<%@page import="com.note.entities.Note"%>
<%@page import="com.note.helper.Factory"%>
<%@page import="org.hibernate.Session"%>
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

		<h1 style="text-align: center">Please edit your content here :</h1>
		
		<%
			int id = Integer.parseInt(request.getParameter("note_id").trim());
			Session s = Factory.getFactory().openSession();
			Note note = (Note)s.get(Note.class, id);
		%>
			<form action="UpdateNoteServlet" method="post">
	
			<input value= "<%= note.getId() %> " name = noteID type="hidden" />
			
			<div class="form-group">
				<label for="title">Title</label>
				 <input required type="text"
					    class="form-control" 
					    name = "title" 
					    id="title" 
					    placeholder="Enter Title"
					    value = "<%= note.getTitle() %>"
					/>
			</div>
			<div class="form-group">
				<label for="context">Context</label>
				<textarea required class="form-control" 
				          id="context" 
				          name = "context"
						  placeholder="Enter your Context" 
						  style="height: 300px;">
					<%=note.getContext() %>
				</textarea>

			</div>

			<div class = "container text-center">
				<button type="submit" class="btn btn-success">Save your note</button>
			</div>

		</form>
	</div>
</body>
</html>