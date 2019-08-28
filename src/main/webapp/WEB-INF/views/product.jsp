<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>Product</h1>
<sec:authorize access='hasRole("ADMIN")'>
    <form:form action="/addProduct" method="post" modelAttribute="product">
        <div>
            <form:input placeholder="Name" path="name"/>
        </div>
        <div>
            <form:input placeholder="Price" path="price"/>
        </div>
        <div>
            <form:input placeholder="Amount" path="amount"/>
        </div>
        <div>
            <form:input placeholder="Manufacturer" path="manufacturer"/>
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
        <div>
            <a href="/profile">Back to Profile</a>
        </div>
    </form:form>
</sec:authorize>
</body>
</html>
