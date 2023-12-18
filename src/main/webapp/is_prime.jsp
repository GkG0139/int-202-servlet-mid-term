<%--
Made by 65130500002 Koranat Ruedeejaroen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Prime Checker | Midterm Exam</title>
</head>
<body>
<h2>Midterm Exam Web App By Koranat 65130500002</h2>
<h3>Welcome ${sessionScope.user.name} (${sessionScope.user.email})</h3>
<hr/>
<h1>Prime Checker ::</h1>
<hr/>
<form action="${pageContext.request.contextPath}/002/is_prime" method="post">
    <table>
        <tbody>
        <tr>
            <td>
                <label for="number">
                    Enter number to check:
                </label>
            </td>
            <td>
                <input type="number" name="number" id="number"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td style="text-align: right"><input type="submit" value="Submit">
            </td>
        </tr>
        </tbody>
    </table>
</form>
<c:choose>
    <c:when test="${error != null}">
        <hr/>
        <div style="color: red;">${error}</div>
    </c:when>
    <c:when test="${success != null}">
        <hr/>
        <div style="color: blue">${success}</div>
    </c:when>
</c:choose>
</body>
</html>
