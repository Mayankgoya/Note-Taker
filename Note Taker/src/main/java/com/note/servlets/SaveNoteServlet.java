package com.note.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class SaveNoteServlet
 */
@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    public SaveNoteServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			String title = request.getParameter("title");
			String context = request.getParameter("context");
			
			Note note = new Note(title , context , new Date());
			
			Session s = Factory.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.print("<h1 style = 'text-align:center;'> Note is added sucessfully </h1>");

			out.print("<h1 style = 'text-align:center;'> <a href = 'add_note.jsp'>Add more notes</a> </h1>");
			
			out.print("<h1 style = 'text-align:center;'> <a href = 'all_notes.jsp'>View all notes</a> </h1>");
			
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
