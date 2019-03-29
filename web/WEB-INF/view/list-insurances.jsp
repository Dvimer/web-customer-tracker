<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
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
        <input type="button" value="Add Insurance"
               onclick="window.location.href='showFormForAdd'; return false"
               class="add-button"
        />
        <!--  add a search box -->
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName"/>

            <input type="submit" value="Search" class="add-button"/>
        </form:form>
        <table>
            <tr>
                <th>ФИО</th>
                <th>Телефон</th>
                <th>Дата</th>
                <th>Дата начал полиса</th>
                <th>Цена</th>
                <th>Цена со скидкой</th>
                <th>Действие</th>
            </tr>
            <c:forEach var="tempInsurance" items="${insurances}">
                <c:url var="updateLink" value="/insurance/showFormForUdpate">
                    <c:param name="insuranceId" value="${tempInsurance.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/insurance/delete">
                    <c:param name="insuranceId" value="${tempInsurance.id}"/>
                </c:url>
                <tr>
                    <td>${tempInsurance.customer.firstName} ${tempInsurance.customer.lastName}</td>
                    <td>${tempInsurance.customer.phoneNumber}</td>
                    <td>${tempInsurance.createdDate}</td>
                    <td>${tempInsurance.startDateInsurance}</td>
                    <td>${tempInsurance.price}</td>
                    <td>${tempInsurance.discountPrice}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure want to delete this Insurance?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>
