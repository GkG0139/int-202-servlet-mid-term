<%--
Made by 65130500002 Koranat Ruedeejaroen
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Midterm Exam</title>
</head>
<body>
<h2>Midterm Exam Web App By Koranat 65130500002</h2>
<hr/>
<form action="${pageContext.request.contextPath}/002/register" method="post">
    <table>
        <tbody>
        <tr>
            <td>
                <label for="username">
                    Username:
                </label>
            </td>
            <td>
                <input type="text" name="username" id="username" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">
                    Email Address:
                </label>
            </td>
            <td>
                <input type="email" name="email" id="email" required/>
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
</body>
</html>
