<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Produtos</title>
    </head>
    <body>
        <h1>Pesquisa de Produtos</h1>
        <table border=1>
            <tr>
                <th>Nome</th>
                <th>Código de Barra</th>
                <th>Quantidade Atual</th>
                <th>Fornecedor</th>
                <th>Categoria</th>  
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.nome}"/></td>
                    <td><c:out value="${produto.codBarra}"/></td>
                    <td><c:out value="${produto.qtdAtual}"/></td>
                    <td><c:out value="${produto.fornecedor.nomeFantasia}"/></td>
                    <td><c:out value="${produto.categoria.descricao}"/></td>       
                    <td><a href="ManterProdutoController?acao=prepararOperacao&operacao=Excluir&idProduto=<c:out value="${produto.idProduto}"/>">Excluir</a></td>
                    <td><a href="ManterProdutoController?acao=prepararOperacao&operacao=Alterar&idProduto=<c:out value="${produto.idProduto}"/>">Alterar</a></td>
                </tr>
            </c:forEach>            
        </table>
        <br>
        <form action="ManterProdutoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
