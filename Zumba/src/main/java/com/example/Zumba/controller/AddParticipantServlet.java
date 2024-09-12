package com.example.Zumba.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.Zumba.model.Participant;
import com.example.Zumba.zumba.database.Database;

/**
 * Servlet implementation class AddParticipantServlet
 */
public class AddParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddParticipantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		Participant sendToMySqlP1 = new Participant();

		sendToMySqlP1.setName(request.getParameter("name"));
		sendToMySqlP1.setPhone(request.getParameter("phone"));
		sendToMySqlP1.setEmail(request.getParameter("email"));
		int bidToInteger = Integer.parseInt(request.getParameter("bid"));
		sendToMySqlP1.setBid(bidToInteger);

		// Use the database singleton instance
		Database db = Database.getInstance();

		// SQL query to insert participant data into the database
		String insertParticipantSql = "INSERT INTO Participant (name, phone, email,bid) VALUES (?, ?, ?, ?)";

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertParticipantSql)) {

			ps.setString(1, sendToMySqlP1.getName());
			ps.setString(2, sendToMySqlP1.getPhone());
			ps.setString(3, sendToMySqlP1.getEmail());
			ps.setInt(4, sendToMySqlP1.getBid());

			int result = db.executeUpdate(ps);

			// result > 0 means that a Participant record was successfully inserted
			if (result > 0) {
				request.setAttribute("successMessage", "Participant added successfully!");
				request.setAttribute("participantName", sendToMySqlP1.getName());
				request.setAttribute("participantPhone", sendToMySqlP1.getPhone());
				request.setAttribute("participantEmail", sendToMySqlP1.getEmail());
				request.setAttribute("participantBID", sendToMySqlP1.getBid());
				// Forward the request to the JSP for rendering the view
				RequestDispatcher dispatcher = request.getRequestDispatcher("/add-participant.jsp");
				dispatcher.forward(request, response);
			} else {
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("SQL Exception occurred");
			e.printStackTrace();

		}
	}

}
