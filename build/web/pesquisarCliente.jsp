<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Clientes</title>
    </head>
    <body>
        <h1>Pesquisa de Clientes</h1>
        <table border=1>
            <tr>
                <th>CPF/CNPJ</th>
                <th>Nome</th>
                <th>Celular</th>
                <th>Email</th>
                <th>Endereço</th>
                <th>Número</th> 
                <th>Complemento</th> 
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.cpf}${cliente.cnpj}"/></td>
                    <td><c:out value="${cliente.nome}"/></td>
                    <td><c:out value="${cliente.celular}"/></td>
                    <td><c:out value="${cliente.email}"/></td>
                    <td><c:out value="${cliente.endereco.logradouro}"/></td>
                    <td><c:out value="${cliente.numero}"/></td>
                    <td><c:out value="${cliente.complemento}"/></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Excluir&idCliente=<c:out value="${cliente.idCliente}"/>">Excluir</a></td>
                    <td><a href="ManterClienteController?acao=prepararOperacao&operacao=Alterar&idCliente=<c:out value="${cliente.idCliente}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
