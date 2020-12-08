<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SGMC - Pesquisa de Itens da Venda</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <ul class="main-nav">
        <h2>SGMC - Pesquisa de Itens da Venda</h2>
    </ul>
    <table border=1 class="table">
        <tr>
            <th>ID Venda</th>
            <th>Código de Barra</th>
            <th>Produtos</th>
            <th>Quantidade</th>
            <th>Preço Unitário</th>
            <th colspan="2">Ação</th>
        </tr>
        <c:forEach items="${itensVenda}" var="itemVenda">
            <tr>
                <td>
                    <c:out value="${itemVenda.venda.idVenda}" />
                </td>
                <td>
                    <c:out value="${itemVenda.produto.codBarra}" />
                </td>
                <td>
                    <c:out value="${itemVenda.produto.nome}" />
                </td>
                <td>
                    <c:out value="${itemVenda.quantidade}" />
                </td>
                <td>
                    <c:out value="${itemVenda.precoUnitario}" />
                </td>
                <td>
                    <a href="ManterItensVendaController?acao=prepararOperacao&operacao=Excluir&idVenda=${idVenda}&idItemVenda=<c:out value="${itemVenda.idItemVenda}" />">
                    Excluir</a>
                </td>
                <td>
                    <a href="ManterItensVendaController?acao=prepararOperacao&operacao=Alterar&idVenda=${idVenda}&idItemVenda=<c:out value="${itemVenda.idItemVenda}" />">
                    Alterar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <table>
        <td>
            <form class="table-input"
                action="ManterItensVendaController?acao=prepararOperacao&operacao=Incluir&idVenda=${idVenda}"
                method="post">
                <input type="submit" name="btnIncluir" value="Incluir">
            </form>
        </td>
        <td>
            <form class="table-input" action="PesquisaVendaController?acao=prepararOperacao&operacao" method="post">
                <input type="submit" name="btnIncluir" value="Voltar">
            </form>
        </td>
    </table>
</body>

</html>