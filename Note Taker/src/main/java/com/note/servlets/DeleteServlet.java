package com.note.servlets;

import java.io.IOException;
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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int note_id = Integer.parseInt(request.getParameter("note_id").trim());

			Session session = Factory.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			Note note = (Note) session.get(Note.class, note_id);

			session.delete(note);
			tx.commit();
			session.close();

			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
