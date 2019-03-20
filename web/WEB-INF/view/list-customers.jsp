<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2> CRM Customer RelationShip Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false"
               class="add-button"
        />
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempCustomer" items="${customers}">
                <c:url var="updateLink" value="/customer/showFormForUdpate">
                    <c:param name="customId" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="${updateLink}">Update</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>
