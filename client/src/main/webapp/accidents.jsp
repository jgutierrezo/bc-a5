<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.juan.model.TrafficInfo"%>
<%@page import="com.juan.model.Accident"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Accidents</title>
<style>
table, td, th {
    border: 1px solid;
    border-collapse: collapse;
}

td, th {
    padding: 1rem;
}
</style>
</head>
<body>
    <h1>All Accidents</h1>
    <table>
        <tr>
            <th>Neighborhood</th>
            <th>Accident Date</th>
            <th>Accident Time</th>
            <th>Description</th>
            <th>Severity</th>
        </tr>
        <% List<TrafficInfo> trafficInfos = (List<TrafficInfo>) request.getAttribute("trafficInfos"); %>
        <% for (TrafficInfo trafficInfo : trafficInfos) { %>
            <% for (Accident accident : trafficInfo.getAccidents()) { %>
                <tr>
                    <td><%=trafficInfo.getNeighborhood()%></td>
                    <td><%=trafficInfo.getDate()%></td>
                    <td><%=accident.getAccidentTime()%></td>
                    <td><%=accident.getDescription()%></td>
                    <td><%=accident.getSeverity()%></td>
                </tr>
            <% } %>
        <% } %>
    </table>
    <br>
    <button type="button" onclick="window.location.href='<%=request.getContextPath()%>/dashboard'">Go to Dashboard</button>
</body>
</html>
