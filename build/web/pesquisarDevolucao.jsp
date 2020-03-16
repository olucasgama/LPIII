<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Perdas ou Devoluções</title>
    </head>
    <body>
        <h1>Pesquisar Perdas ou Devoluções</h1>
        <table border=1>
            <tr>
                <th>ID</th>
                <th>Tipo</th>
                <th>Venda</th>
                <th>Produto</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${perdasDevolucoes}" var="perdaDevolucao">
                <tr>
                    <td><c:out value="${perdaDevolucao.idPerdaDevolucao}"/></td>
                    <td><c:out value="${perdaDevolucao.tipo}"/></td>
                    <td><c:out value="${perdaDevolucao.venda.codBarra}"/></td>
                    <td><c:out value="${perdaDevolucao.produto.nome}"/></td>
                    <td><a href="ManterDevolucaoController?acao=prepararOperacao&operacao=Excluir&idPerdaDevolucao=<c:out value="${perdaDevolucao.idPerdaDevolucao}"/>">Excluir</a></td>
                    <td><a href="ManterDevolucaoController?acao=prepararOperacao&operacao=Alterar&idPerdaDevolucao=<c:out value="${perdaDevolucao.idPerdaDevolucao}"/>">Alterar</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterDevolucaoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
