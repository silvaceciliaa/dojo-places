<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cecilia
  Date: 1/23/25
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Listagem de Locais</h1>

    <div class="list-group">
        <ol>
            <c:forEach items="${places}" var="place">
                <div class="list-group-item p-4 mb-3 border rounded shadow-sm">
                    <li>
                        <strong>ID:</strong> ${place.id} <br>
                        <strong>Nome:</strong> ${place.name} <br>
                        <strong>Código:</strong> ${place.code} <br>
                        <strong>Cidade:</strong> ${place.city} <br>
                        <strong>Data de criação:</strong> ${place.createdAt} <br>
                        <strong>Dias desde a última atualização:</strong> ${place.updatedAt} <br>

                        <form action="/update-place" method="get">
                            <input type="hidden" name="id" value="${place.id}">
                            <button class="btn btn-primary btn-sm">Editar</button>
                        </form>

                        <a href="/delete-place/${place.id}" class="btn btn-danger btn-sm" onclick="return confirm('Tem certeza que deseja remover este item?');">Remover</a>
                    </li>
                    </div>
                <hr>
            </c:forEach>
        </ol>
    </div>
</div>

</body>
</html>
