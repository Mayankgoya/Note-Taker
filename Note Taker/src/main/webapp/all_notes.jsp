<%@page import="com.note.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
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

		<h1>All Notes : Note Taker</h1>


		<div class="row">

			<div class="col-12">

				<%
				Session s = Factory.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();

				for (Note note : list) {
				%>
				<div class="card mt-3">
					<img class="card-img-top pl-4 pt-4 mx-auto" style="max-width: 80px;"
						src="IMG/note.png" alt="Card image cap">
					<div class="card-body px-5">
						<h5 class="card-title"><%=note.getTitle()%></h5>
						<p class="card-text"><%=note.getContext()%></p>
						<div class="container text-center">
							<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a> 
							<a href="edit_note.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">update</a>
						</div>

					</div>
				</div>
				<%
				}
				s.close();
				%>


			</div>

		</div>



	</div>
</body>
</html>