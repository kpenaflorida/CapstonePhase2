package com.example.Zumba.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.Zumba.model.Participant;
import com.example.Zumba.zumba.database.Database;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateParticipantServlet
 */
public class UpdateParticipantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateParticipantServlet() {
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

        // Retrieve participant data from the request
        int pid = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phone_number");
        int batchId = Integer.parseInt(request.getParameter("batch_id"));

        Database db = Database.getInstance();
        // SQL UPDATE statement
        String updateBatchsql = "UPDATE participants SET name = ?, email = ?, phone_number = ?, batch_id = ? WHERE pid = ?";

        // Use try-with-resources to ensure resources are closed properly
try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateBatchsql)) {


            // Set parameters for the PreparedStatement
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phoneNumber);
            ps.setInt(4, batchId);
            ps.setInt(5, pid);

            // Execute the update
            int rowsAffected = ps.executeUpdate();

            // Check if the update was successful
            if (rowsAffected > 0) {
                response.getWriter().write("Participant updated successfully.");
            } else {
                response.getWriter().write("Participant update failed. No rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred: " + e.getMessage());
        }
    }
}


