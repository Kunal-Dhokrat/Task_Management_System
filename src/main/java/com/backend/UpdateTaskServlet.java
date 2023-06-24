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

public class UpdateTaskServlet extends HttpServlet {
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
			String sql = "UPDATE tasks SET title = ?, description = ?, due_date = ? WHERE task_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, description);
			statement.setString(3, due_date);
			statement.setString(4, taskId);

			// Execute the statement
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				String message = "Task updated successfully.";
				req.setAttribute("message", message);
				req.getRequestDispatcher("common.jsp").forward(req, res);
			} else {
				out.println("Failed to update task.");
			}
		} catch (SQLException e) {
			out.println("An error occurred while updating the task: " + e.getMessage());
		}
	}
}
