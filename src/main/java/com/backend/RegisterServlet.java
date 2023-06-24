package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String Pass1 = req.getParameter("pass");
		String confirmPass = req.getParameter("pass1");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Success");
			String url = "jdbc:mysql://localhost:3306/task_management";
			String uname = "root";
			String pass = "1234";
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement psmt = con.prepareStatement("insert into register values (?,?,?,?)");
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setString(3, Pass1);
			psmt.setString(4, confirmPass);
			int i = psmt.executeUpdate();
			if (i > 0) {
				res.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
