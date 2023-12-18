<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: koranatruedeecharoen
  Date: 30/10/23
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>History | Midterm Exam</title>
</head>
<body>
<h2>Midterm Exam Web App By Koranat 65130500002</h2>
<h3>Welcome ${sessionScope.user.name} (${sessionScope.user.email})</h3>
<hr/>
<table>
    <caption>History</caption>
    <thead>
    <tr>
        <th>No</th>
        <th>Number</th>
        <th>Is Prime</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${history != null || history.size() - 1 > 0}">
        <c:forEach begin="0" end="${history.size() - 1}"
                   var="i">
            <tr>
                <td>${i + 1}</td>
                <td>${history.get(i).number}</td>
                <td>${history.get(i).prime ? "&#10003;" : "&#10060;"}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<hr/>
</body>
</html>
