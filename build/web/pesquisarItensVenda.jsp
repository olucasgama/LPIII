<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC - Pesquisa de Itens da Venda</title>
    </head>
    <body>
        <h1>Pesquisar Itens da Venda</h1>
        <table border=1>
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
                    <td><c:out value="${itemVenda.venda.idVenda}"/></td>
                    <td><c:out value="${itemVenda.produto.codBarra}"/></td>
                    <td><c:out value="${itemVenda.produto.nome}"/></td>
                    <td><c:out value="${itemVenda.quantidade}"/></td>
                    <td><c:out value="${itemVenda.precoUnitario}"/></td>
                    <td>
                        <a href="ManterItensVendaController?acao=prepararOperacao&operacao=Excluir&idVenda=${idVenda}&idItensVenda=<c:out value="${itemVenda.idItensVenda}"/>">
                            Excluir</a>
                    </td>
                    <td>
                        <a href="ManterItensVendaController?acao=prepararOperacao&operacao=Alterar&idVenda=${idVenda}&idItensVenda=<c:out value="${itemVenda.idItensVenda}"/>">
                            Alterar</a>
                    </td>
                </tr>
            </c:forEach>            
        </table>
        <br>
        <table>
            <td><form action="ManterItensVendaController?acao=prepararOperacao&operacao=Incluir&idVenda=${idVenda}" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
                </form></td>
                <td><form action="PesquisaVendaController?acao=prepararOperacao&operacao" method="post">
            <input type="submit" name="btnIncluir" value="Voltar">
                    </form></td>
        </table>
    </body>
</html>
