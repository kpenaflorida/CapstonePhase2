package com.example.Zumba.zumba.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database implements DAO{
	private Connection connection;
	
	private static Database db = new Database();
	
	private Database() {
		// Private constructor to enforce singleton pattern
	}
	public static Database getInstance() {
		return db;
	}
	@Override
	public Connection getConnection() {
		if (connection == null || isClosed(connection)) {
			// Re-establish the connection if it's null or closed
			connect();
		}
		return connection;
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int executeUpdate(PreparedStatement preparedStatement) {
		int result = 0;
		try {
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ResultSet executeQuery(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "Patusan1!"; //find out mysql password
			String url = "jdbc:mysql://localhost/Zumba"; //reminder to create zumba database schema
															//and batch tables
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean isClosed(Connection connection) {
		try {
			return connection == null || connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
	
}

