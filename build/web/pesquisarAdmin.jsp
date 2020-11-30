<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SGMC</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <ul class="main-nav">
        <h2>SGMC - Pesquisa de Administradores</h2>
    </ul>
    <table border=1 class="table">
        <tr>
            <th>Nome</th>
            <th>E-mail</th>
            <th colspan="2">Ação</th>

        </tr>
        <c:forEach items="${admins}" var="admin">
            <tr>
                <td>
                    <c:out value="${admin.nome}" />
                </td>
                <td>
                    <c:out value="${admin.email}" />
                </td>
                <td><a href="ManterAdminController?acao=prepararOperacao&operacao=Excluir&idAdmin=<c:out value="
                        ${admin.idAdmin}" />">Excluir</a></td>
                <td><a href="ManterAdminController?acao=prepararOperacao&operacao=Alterar&idAdmin=<c:out value="
                        ${admin.idAdmin}" />">Alterar</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form class="table-input" action="ManterAdminController?acao=prepararOperacao&operacao=Incluir" method="post">
        <table>
            <tr>
                <td><input type="submit" name="btnIncluir" value="Incluir"></td>
            </tr>
        </table>
    </form>
    <table class="table-input">
        <tr>
            <td><input type="submit" name="btnVoltar" value="Voltar"
                    onclick="window.location.href='http://localhost:8000/SGMC/'"></td>
        </tr>
    </table>

</body>

</html>