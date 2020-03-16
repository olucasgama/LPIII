<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Endereços</title>
    </head>
    <body>
        <h1>Pesquisa de Endereços</h1>
        <table border=1>
            <tr>
                <th>Logradouro</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>UF</th>
                <th>CEP</th>
                <th colspan="2">Ação</th>
                
            </tr>
            <c:forEach items="${enderecos}" var="endereco">
                <tr>
                    <td><c:out value="${endereco.logradouro}"/></td>
                    <td><c:out value="${endereco.cidade}"/></td>
                    <td><c:out value="${endereco.bairro}"/></td>
                    <td><c:out value="${endereco.uf}"/></td>
                    <td><c:out value="${endereco.cep}"/></td>
                    <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Excluir&idEndereco=<c:out value="${endereco.idEndereco}"/>">Excluir</a></td>
                    <td><a href="ManterEnderecoController?acao=prepararOperacao&operacao=Alterar&idEndereco=<c:out value="${endereco.idEndereco}"/>">Alterar</a></td>
                </tr>
            </c:forEach>            
        </table>
        <br>
        <form action="ManterEnderecoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
