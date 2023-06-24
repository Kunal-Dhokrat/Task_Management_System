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

public class DeleteTaskServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String taskId = req.getParameter("taskId");

		// Establish a database connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management", "root",
				"1234")) {
			// Prepare the SQL statement
			String sql = "DELETE FROM tasks WHERE task_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, taskId);

			// Execute the statement
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				String message = "Task deleted successfully.";
				req.setAttribute("message", message);
				req.getRequestDispatcher("common.jsp").forward(req, res);
			} else {
				out.println("Failed to delete task.");
			}
		} catch (SQLException e) {
			out.println("An error occurred while deleting the task: " + e.getMessage());
		}
	}
}
