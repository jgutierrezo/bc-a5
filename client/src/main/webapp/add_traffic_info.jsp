<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Traffic Record</title>
<style>
label {
    display: inline-block;
    width: 200px;
    margin-bottom: 10px;
}
</style>
</head>
<body>

	<h1>Add Traffic Record</h1>

	<form action="<%=request.getContextPath()%>/TrafficForm" method="POST">
		<label for="neighborhood_id">Neighborhood:</label>
		<select id="neighborhood_id" name="neighborhood_id">
		<%		List<String> torontoNeighborhoods = (List<String>) request.getAttribute("torontoNeighborhoods");

		for (String neighborhood : torontoNeighborhoods) {
		%>
			<option value="<%=neighborhood%>"><%=neighborhood%></option>
		<%
		}
		%>
		</select>
		<br>
		<label for="traffic_cars">Traffic Cars (9 AM to 6 PM):</label>
		<input type="number" id="traffic_cars" name="traffic_cars" required>
		<br>
		<label for="pedestrians">Pedestrians (9 AM to 6 PM):</label>
		<input type="number" id="pedestrians" name="pedestrians" required>
		<br>
		<label for="date">Date:</label>
		<input type="text" id="date" name="date" placeholder="YYYY-MM-DD" required>
		<br>
		<input type="submit" value="Add Traffic Record">
		<br>
		<br>
			<button type="button" onclick="window.location.href='<%=request.getContextPath()%>/dashboard'">Go to Dashboard</button>
		
	</form>


</body>
</html>
