<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/TrafficForm" method="post">

<div>
Mortgage Amount: <input name="amount" type="number">
</div>
<div>
Interest Rate: <input name="rate" type="number">%
</div>
<div>
Interest Term: <input name="year" type="number"> Years
</div>
<button type="submit">Calculate</button>

</form>
</body>
</html>