<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Fornecedores</title>
    </head>
    <body>
        <h1>Pesquisa de Fornecedores</h1>
        <table border=1>
            <tr>
                <th>CNPJ</th>
                <th>Nome Fantasia</th>
                <th>Representante</th>
                <th>Email</th>
                <th>Logradouro</th> 
                <th>Número</th>
                <th>Complemento</th>
                <th colspan="2">Ação</th>           
            </tr>
            <c:forEach items="${fornecedores}" var="fornecedor">
                <tr>
                    <td><c:out value="${fornecedor.cnpj}"/></td>
                    <td><c:out value="${fornecedor.nomeFantasia}"/></td>
                    <td><c:out value="${fornecedor.nomeRepresentante}"/></td>
                    <td><c:out value="${fornecedor.email}"/></td>
                    <td><c:out value="${fornecedor.endereco.logradouro}"/></td>
                    <td><c:out value="${fornecedor.numero}"/></td>
                    <td><c:out value="${fornecedor.complemento}"/></td>
                    <td><a href="ManterFornecedorController?acao=prepararOperacao&operacao=Excluir&idFornecedor=<c:out value="${fornecedor.idFornecedor}"/>">Excluir</a></td>
                    <td><a href="ManterFornecedorController?acao=prepararOperacao&operacao=Alterar&idFornecedor=<c:out value="${fornecedor.idFornecedor}"/>">Alterar</a></td>
                </tr>
            </c:forEach>            
        </table>
        <br>
        <form action="ManterFornecedorController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
