<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Task</title>
<link rel="stylesheet" href="css/addTaskStyle.css">
</head>
<body>

	<h1>Task Management</h1>

	<h2>Add Task</h2>
	<form action="addTask" method="POST">
		<table>

			<tr>
				<td>Task ID:</td>
				<td><input type="text" name="taskId" required></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" required></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea name="description" required></textarea></td>
			</tr>
			<tr>
				<td>Due Date:</td>
				<td><input type="date" name="due_date" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Task"></td>
			</tr>
		</table>



	</form>

	<hr>

	<h2>Options</h2>
	<ul>
		<li><button>
				<a href="update">Update Task</a>
			</button></li>
		<li><button>
				<a href="delete">Delete Task</a>
			</button></li>
		<li><button>
				<a href="search">Search and Filtering</a>
			</button></li>
	</ul>


</body>
</html>