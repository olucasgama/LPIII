<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SGMC - Pesquisa de Colaboradores</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <ul class="main-nav">
        <h2>SGMC - Pesquisa de Colaboradores</h2>
    </ul>
    <table border=1 class="table">
        <tr>
            <th>CPF</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Celular</th>
            <th>Logradouro</th>
            <th>Número</th>
            <th>Complemento</th>
            <th colspan="2">Ação</th>
        </tr>
        <c:forEach items="${colaboradores}" var="colaborador">
            <tr>
                <td>
                    <c:out value="${colaborador.cpf}" />
                </td>
                <td>
                    <c:out value="${colaborador.nome}" />
                </td>
                <td>
                    <c:out value="${colaborador.email}" />
                </td>
                <td>
                    <c:out value="${colaborador.celular}" />
                </td>
                <td>
                    <c:out value="${colaborador.endereco.logradouro}" />
                </td>
                <td>
                    <c:out value="${colaborador.numero}" />
                </td>
                <td>
                    <c:out value="${colaborador.complemento}" />
                </td>
                <td><a href="ManterColaboradorController?acao=prepararOperacao&operacao=Excluir&idColaborador=<c:out value="${colaborador.idUsuario}" />">Excluir</a></td>
                <td><a href="ManterColaboradorController?acao=prepararOperacao&operacao=Alterar&idColaborador=<c:out value="${colaborador.idUsuario}" />">Alterar</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form class="table-input" action="ManterColaboradorController?acao=prepararOperacao&operacao=Incluir" method="post">
        <table>
            <tr>
                <td><input type="submit" name="btnIncluir" value="Incluir"></td>
            </tr>
        </table>
    </form>
    <table class="table-input">
        <tr>
            <td><input type="submit" name="btnVoltar" value="Voltar"
                    onclick="window.location.href='http://localhost:8080/SGMC/'"></td>
        </tr>
    </table>
</body>

</html>