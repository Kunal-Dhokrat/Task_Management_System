package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTaskServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String taskId = req.getParameter("taskId");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String due_date = req.getParameter("due_date");

		// Establish a database connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management", "root",
				"1234")) {
			// Prepare the SQL statement
			String sql = "INSERT INTO tasks (task_id, title, description, due_date) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, taskId);
			statement.setString(2, title);
			statement.setString(3, description);
			statement.setString(4, due_date);

			// Execute the statement
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				String message = "Task added successfully.";
				req.setAttribute("message", message);
				req.getRequestDispatcher("common.jsp").forward(req, res);

			} else {
				out.println("Failed to add task.");
			}
		} catch (SQLException e) {
			out.println("An error occurred while adding the task: " + e.getMessage());
		}
	}
}
