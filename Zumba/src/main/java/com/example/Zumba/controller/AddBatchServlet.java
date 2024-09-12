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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.Zumba.model.Batch;
import com.example.Zumba.zumba.database.Database;

/**
 * Servlet implementation class AddBatchServlet
 */
public class AddBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBatchServlet() {
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

        // Retrieve batch data from the request
        int bid = Integer.parseInt(request.getParameter("bid"));
        String batchName = request.getParameter("batch_name");
        String classTime = request.getParameter("class_time");
        
        Database db = Database.getInstance();

        // SQL INSERT statement
        String sql = "INSERT INTO batches (bid, batch_name, class_time) VALUES (?, ?, ?)";

        // Use try-with-resources to ensure resources are closed properly
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters for the PreparedStatement
            pstmt.setInt(1, bid);
            pstmt.setString(2, batchName);
            pstmt.setString(3, classTime);  // The class_time parameter will be in 'YYYY-MM-DD HH:MM:SS' format

            // Execute the insert
            int rowsAffected = pstmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                response.getWriter().write("Batch added successfully.");
            } else {
                response.getWriter().write("Batch addition failed. No rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("An error occurred: " + e.getMessage());
        }
    }
}
