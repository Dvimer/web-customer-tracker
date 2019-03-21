<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <input type="button" value="Add Insurance"
               onclick="window.location.href='showFormForAdd'; return false"
               class="add-button"
        />
        <!--  add a search box -->
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="searchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>
        <table>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Дата создания</th>
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
                    <td>${tempInsurance.firstName}</td>
                    <td>${tempInsurance.lastName}</td>
                    <td>${tempInsurance.patronymic}</td>
                    <td>${tempInsurance.createdDate}</td>
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
