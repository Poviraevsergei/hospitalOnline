<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<c:forEach items="${users}" var="user">
    <h3> id: ${user.id}</h3>
    <h3> firstName: ${user.firstName}</h3>
    <h3> lastName: ${user.lastName}</h3>
    <h3> age: ${user.age}</h3>
    <h3> login: ${user.login}</h3>
    <h3> password: ${user.password}</h3>
    <h4> -------------------------</h4>
</c:forEach>
</body>
</html>
