<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Ordem de Serviço</title>
    </head>
    <body>
        <h1>Pesquisa de Ordens de Serviço</h1>
        <table border=1>
            <tr>
                <th>ID da Ordem de Serviço</th>
                <th>Data de Pedido</th>
                <th>Descrição</th>
                <th>Situação</th>
                <th>Fornecedor</th>
                <th colspan="3">Ação</th>
            <c:forEach items="${ordensServico}" var="ordemServico">
                <tr>
                    <td><c:out value="${ordemServico.idOrdemSrv}"/></td>
                    <td><c:out value="${ordemServico.dataPedido}"/></td>
                    <td><c:out value="${ordemServico.descricao}"/></td>
                    <td><c:out value="${ordemServico.situacao}"/></td>
                    <td><c:out value="${ordemServico.fornecedor.nomeFantasia}"/></td>
                    <td>
                        <a href="ManterOrdemServicoController?acao=prepararOperacao&operacao=Excluir&idOrdemSrv=<c:out value="${ordemServico.idOrdemSrv}"/>">
                            Excluir</a>
                    </td>
                    <td>
                        <a href="ManterOrdemServicoController?acao=prepararOperacao&operacao=Alterar&idOrdemSrv=<c:out value="${ordemServico.idOrdemSrv}"/>">
                            Alterar</a>
                    </td>
                     <td>
                        <a href="PesquisaItensOrdemController?idOrdemSrv=${ordemServico.idOrdemSrv}"> 
                            Itens</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <form action="ManterOrdemServicoController?acao=prepararOperacao&operacao=Incluir" method="post">
            <table><tr><td><input type="submit" name="btnIncluir" value="Incluir"></td></tr></table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='http://localhost:8084/SGMC/'"></td></tr></table>
    </body>
</html>
