<%--
  Created by IntelliJ IDEA.
  User: cecilia
  Date: 2/13/25
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Atualização de Local</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">


        <div class="card shadow p-4">
            <h1 class="text-center mb-4">Edição de Local</h1>

            <br/>
            <br/>

            <form:form modelAttribute="placeUpdateForm" method="post" action="/update-a-place">
                        <input type="hidden" name="id" value="${placeUpdateForm.id}">

                <div class="mb-3 text-center">
                        <label class="form-label fw-bold">ID:</label> ${placeUpdateForm.id} <br>

                </div>

                <div class="mb-3 row">
                        <label for="name" class="col-sm-1 col-form-label">Nome:</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="name"/>
                        <form:errors path="name" cssStyle="color: red"/>
                        <br/>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label for="name" class="col-sm-1 col-form-label">Código:</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="code"/>
                        <form:errors path="code" cssStyle="color: red"/>
                        <br/>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label for="name" class="col-sm-1 col-form-label">Bairro:</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="neighbourhood"/>
                        <form:errors path="neighbourhood" cssStyle="color: red"/>
                        <br/>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label for="name" class="col-sm-1 col-form-label">Cidade:</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="city"/>
                        <form:errors path="city" cssStyle="color: red"/>
                        <br/>
                    </div>
                </div>

                <div class="text-center">
                    <form:button type="submit" class="btn btn-primary" >Salvar</form:button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
