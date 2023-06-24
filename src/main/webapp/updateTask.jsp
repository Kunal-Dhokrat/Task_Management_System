<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/updateTaskStyle.css">
<title>Document</title>

</head>
<body>


	<h2>Update Task</h2>
	<form action="updateTask" method="POST">
		<table>
			<tr>
				<td><input type="hidden" name="action" value="add"></td>
			</tr>
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
				<td><input type="date" name="dueDate" required></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Task"></td>
			</tr>
		</table>



	</form>

	<hr>

	<h2>Options</h2>
	<ul>
		<li><button>
				<a href="add">Add Task</a>
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