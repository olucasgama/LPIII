<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Colaboradores</title>
    </head>
    <body>
        <h1>Pesquisa de Colaboradores</h1>
        <table border=1>
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
                    <td><c:out value="${colaborador.cpf}"/></td>
                    <td><c:out value="${colaborador.nome}"/></td>
                    <td><c:out value="${colaborador.email}"/></td>
                    <td><c:out value="${colaborador.celular}"/></td>
                    <td><c:out value="${colaborador.endereco.logradouro}"/></td>
                    <td><c:out value="${colaborador.numero}"/></td>
                    <td><c:out value="${colaborador.complemento}"/></td>
                    <td><a href="ManterColaboradorController?acao=prepararOperacao&operacao=Excluir&idColaborador=<c:out value="${colaborador.idColaborador}"/>">Excluir</a></td>
                    <td><a href="ManterColaboradorController?acao=prepararOperacao&operacao=Alterar&idColaborador=<c:out value="${colaborador.idColaborador}"/>">Alterar</a></td>     
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterColaboradorController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
