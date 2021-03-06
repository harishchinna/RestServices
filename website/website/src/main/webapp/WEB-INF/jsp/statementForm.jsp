<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<a href="statement?offset=1&size=5">Get Statement</a>
</div>
<div>
	<table>
		<tr>
			<th>Transaction Id</th>
			<th>Account Number</th>
			<th>Amount</th>
			<th>Transaction Type</th>
			<th>Current Balance</th>
			<th>Transaction Date</th>
			<th>Transaction Details</th>
		</tr>
		<%-- <jstl:if test = "${currentDataSet.transactions} != null"> --%>
			<c:forEach var="transactions" items="${currentDataSet.transactions}">
				<tr>
					<td>${transactions.transactionId}</td>
					<td>${transactions.accountNumber}</td>
					<td>${transactions.amount}</td>
					<td>${transactions.transactionType}</td>
					<td>${transactions.currentBalance}</td>
					<td>${transactions.transactionDate}</td>
					<td>${transactions.transactionDetails}</td>
					
				</tr>
			</c:forEach>
		<%-- </jstl:if> --%>
	</table>
	<div>
		<a href="${currentDataSet.previousLink.href}">Previous</a>
		<a href="${currentDataSet.nextLink.href}">Next</a>
	</div>
</div>
</body>
</html>