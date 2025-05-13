<%--
  Created by IntelliJ IDEA.
  User: cecilia
  Date: 1/9/25
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/assets/global.css">

<html>
<head>
    <title>Cadastro Local</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">


    <div class="card shadow p-4">
        <h1 class="text-center mb-4">Cadastro de Local</h1>

        <br/>
        <br/>

        <form:form modelAttribute="placeCreateForm" method="post" action="/add-new-place">

            <div class="mb-3 row">
                <label for="name" class="col-sm-1 col-form-label">Nome:</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name"/>
                    <form:errors path="name" cssStyle="color: red"/>
                    <br/>
                </div>
            </div>

            <div class="mb-3 row">
                <label for="code" class="col-sm-1 col-form-label">Código:</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="code"/>
                    <form:errors path="code" cssStyle="color: red"/>
                    <br/>
                </div>
            </div>

            <div class="mb-3 row">
                <label for="cep" class="col-sm-1 col-form-label">CEP:</label>
                <div class="col-sm-5">
                    <form:input class="form-control" path="cep" id="cep" maxlength="8"/>
                    <form:errors path="cep" cssStyle="color: red"/>
                </div>
                <div class="col-sm-2">
                    <button type="button" class="btn btn-primary" onclick="buscarEndereco()">Buscar</button>
                </div>
            </div>

            <div class="mb-3 row">
                <label for="neighbourhood" class="col-sm-1 col-form-label">Bairro:</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="neighbourhood" id="neighbourhood"/>
                    <form:errors path="neighbourhood" cssStyle="color: red"/>
                    <br/>
                </div>
            </div>

            <div class="mb-3 row">
                <label for="city" class="col-sm-1 col-form-label">Cidade:</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="city" id="city"/>
                    <form:errors path="city" cssStyle="color: red"/>
                    <br/>
                </div>
            </div>

            <div class="text-center">
                <form:button type="submit" class="btn btn-primary" >Cadastrar</form:button>
            </div>
        </form:form>
    </div>
</div>
    <script src="${pageContext.request.contextPath}/static/cep.js"></script>

</body>
</html>
