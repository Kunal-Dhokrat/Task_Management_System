package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchTaskServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String searchQuery = req.getParameter("searchQuery");

		// Establish a database connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management", "root",
				"1234")) {
			// Prepare the SQL statement
			String sql = "SELECT * FROM tasks WHERE task_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, searchQuery);

			// Execute the statement
			ResultSet resultSet = statement.executeQuery();

			// Process the search results
			while (resultSet.next()) {
				String taskId = resultSet.getString("task_id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				String due_date = resultSet.getString("due_date");

				// Output the search results
				out.println("Task ID: " + taskId);
				out.println("Title: " + title);
				out.println("Description: " + description);
				out.println("Due Date: " + due_date);
				out.println("<br>");
			}

			// Close the result set
			resultSet.close();
		} catch (SQLException e) {
			out.println("An error occurred while searching for tasks: " + e.getMessage());
		}
	}
}
