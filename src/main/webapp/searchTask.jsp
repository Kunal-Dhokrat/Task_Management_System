<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/searchTaskStyle.css">
<title>Document</title>

</head>
<body>


	<h2>Search and Filtering</h2>
	<form action="searchTask" method="get">
		<table>
			<tr>
				<td><input type="hidden" name="action" value="add"></td>
			</tr>
			<tr>
				<td id="st">Search Term:</td>
				<td><input type="text" name="searchTerm" required
					placeholder="Enter search term"></td>
				<td><select name="" id="">
						<option value="All">All</option>
						<option value="Complete">Complete</option>
						<option value="Incomplete">Incomplete</option>
				</select></td>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
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
				<a href="update">Update Task</a>
			</button></li>
		<li><button>
				<a href="delete">Delete</a>
			</button></li>
	</ul>


</body>
        
</html>