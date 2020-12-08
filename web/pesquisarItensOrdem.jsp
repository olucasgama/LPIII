<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SGMC - Pesquisa de Itens da Ordem de Serviço</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <ul class="main-nav">
        <h2>SGMC - Pesquisa de Itens da Ordem de Serviço</h2>
    </ul>
    <table border=1 class="table">
        <tr>
            <th>Número da Ordem de Serviço</th>
            <th>Produtos</th>
            <th>Quantidade</th>
            <th colspan="2">Ação</th>
        </tr>
        <c:forEach items="${itensOrdens}" var="itensOrdem">
            <tr>
                <td>
                    <c:out value="${itensOrdem.ordemServico.numOS}" />
                </td>
                <td>
                    <c:out value="${itensOrdem.produto.nome}" />
                </td>
                <td>
                    <c:out value="${itensOrdem.quantidade}" />
                </td>
                <td>
                    <a href="ManterItensOrdemController?acao=prepararOperacao&operacao=Excluir&idOrdemSrv=${idOrdemSrv}&idItensOrdem=<c:out value="${itensOrdem.idItensOrdem}" />">
                    Excluir</a>
                </td>
                <td>
                    <a href="ManterItensOrdemController?acao=prepararOperacao&operacao=Alterar&idOrdemSrv=${idOrdemSrv}&idItensOrdem=<c:out value="${itensOrdem.idItensOrdem}" />">
                    Alterar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <table>
        <td>
            <form class="table-input"
                action="ManterItensOrdemController?acao=prepararOperacao&operacao=Incluir&idOrdemSrv=${idOrdemSrv}"
                method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </td>
        <td>
            <form class="table-input" action="PesquisaOrdemServicoController?acao=prepararOperacao&operacao"
                method="post">
                <input type="submit" name="btnIncluir" value="Voltar">
            </form>
        </td>
    </table>
</body>

</html>