package com.note.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.note.entities.Note;
import com.note.helper.Factory;


@WebServlet("/UpdateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("context");
			int noteId = Integer.parseInt(request.getParameter("noteID").trim());
			
			Session s = Factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			Note note = (Note)s.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setAddDate( new Date() );
			
			tx.commit();
			s.close();
			
			response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
