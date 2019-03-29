<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Cp1251" language="java" %>
<html>
<head>
    <title>Add insurance</title>
    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <meta charset="utf-8">
    <link rel="stylesheet"
          type="text/css"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2> CRM insurance RelationShip Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveInsurance" modelAttribute="insurance" method="post" acceptCharset="utf-8">
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Агент</label></td>
                <td><form:input path="agent"/></td>
            </tr>
            <tr>
                <td><label>Офис</label></td>
                <td><form:input path="offices"/></td>
            </tr>
            <tr>
                <td><label>Территория</label></td>
                <td><form:input path="location"/></td>
            </tr>
            <tr>
                <td><label style="background-color: red">Дата создания</label></td>
                <td><form:input path="createdDate"/></td>
            </tr>
            <tr>
                <td><label>Дата начала полиса</label></td>
                <td><form:input path="startDateInsurance"/>
            </tr>
            <tr>
                <td><label style="background-color: red">Имя</label></td>
                <td><form:input path="customer.firstName"/></td>
            </tr>
            <tr>
                <td><label>Фамилия</label></td>
                <td><form:input path="customer.lastName"/></td>
            </tr>
                <%--<tr>--%>
                <%--<td><label>Отчество</label></td>--%>
                <%--<td><form:input path="patronymic"/></td>--%>
                <%--</tr>--%>
            <tr>
                <td><label style="background-color: red">Телефон</label></td>
                <td><form:input path="customer.phoneNumber"/></td>
            </tr>
            <tr>
                <td><label style="background-color: red">Страховая компания</label></td>
                <td><form:input path="insuranceName"/></td>
            </tr>
            <tr>
                <td><label style="background-color: red">Модель авто</label></td>
                <td><form:input path="modelAuto"/></td>
            </tr>
            <tr>
                <td><label>Вид страховки</label></td>
                <td><form:input path="kindInsurance"/></td>
            </tr>
            <tr>
                <td><label>Базовый тариф</label></td>
                <td><form:input path="baseRate"/></td>
            </tr>
            <tr>
                <td><label>Цена</label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td><label>Скидка</label></td>
                <td><form:input path="discount"/></td>
            </tr>
            <tr>
                <td><label>Цина со скидкой</label></td>
                <td><form:input path="discountPrice"/></td>
            </tr>
            <tr>
                <td><label>Доставка</label></td>
                <td><form:input path="delivery"/></td>
            </tr>
            <tr>
                <td><label>Итоговая сумма</label></td>
                <td><form:input path="resultPrice"/></td>
            </tr>
            <tr>
                <td><label>КВ</label></td>
                <td><form:input path="kv"/></td>
            </tr>
            <tr>
                <td><label>Итог(КВ)</label></td>
                <td><form:input path="kvSummary"/></td>
            </tr>
            <tr>
                <td><label>ДК</label></td>
                <td><form:input path="dk"/></td>
            </tr>
            <tr>
                <td><label>ЗП Админам</label></td>
                <td><form:input path="adminSalery"/></td>
            </tr>
            <tr>
                <td><label>Наш итог</label></td>
                <td><form:input path="ourSummary"/></td>
            </tr>
            <tr>
                <td><label>Касса</label></td>
                <td><form:input path="cashbox"/></td>
            </tr>
            <tr>
                <td><label>Вывели общ.</label></td>
                <td><form:input path="displayed"/></td>
            </tr>
            <tr>
                <td><label>Вывел каждый</label></td>
                <td><form:input path="displayedEveryone"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"/>
    <p>
        <a href="${pageContext.request.contextPath}/insurance/list"/>Back List</p>
    </p>
</div>

</body>
</html>
