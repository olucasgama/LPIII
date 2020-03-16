<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC</title>
        <script>

            function validarFormulario(form) {

                var mensagem;
                mensagem = "";

                if (form.numIdItensOrdem.value == "") {
                    mensagem = mensagem + "Informe o id do item da ordem de serviço\n";
                }
                if (frmManterItensOrdem.optOrdemSrv.selectedIndex == 0) {
                    mensagem = mensagem + "Informe a ordem de serviço\n";
                }
                if (frmManterItensOrdem.optProduto.selectedIndex == 0) {
                    mensagem = mensagem + "Informe o produto\n";
                }
                if (form.numQuantidade.value == "") {
                    mensagem = mensagem + "Informe a quantidade\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h1>Manter Itens Ordem - ${operacao} - Ordem de Serviço: ${idOrdemSrv}</h1>
        <form action="ManterItensOrdemController?acao=confirmarOperacao&operacao=${operacao}&idOrdemSrv=${idOrdemSrv}" method="post" name="frmManterItensOrdem" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>
                        <label> ID: </label>
                        <input type="number" name="numIdItensOrdem" value="${itensOrdem.idItensOrdem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </td>
                        <td>
                            <label> ID Ordem:</label>
                        <select name="optOrdemSrv" disabled>
                            <c:if test="${operacao!='Incluir'}">
                                <c:forEach items="${ordensServicos}" var="ordemSrv">
                                    <option value="${ordemSrv.idOrdemSrv}" <c:if test="${itensOrdem.ordemServico.idOrdemSrv == ordemSrv.idOrdemSrv}">selected</c:if>>${ordemSrv.idOrdemSrv}</option>
                                </c:forEach>
                            </c:if>
                            <c:if test="${operacao=='Incluir'}">
                                <c:forEach items="${ordensServicos}" var="ordemSrv">
                                    <option value="${ordemSrv.idOrdemSrv}" <c:if test="${itensOrdem.ordemServico.idOrdemSrv == idOrdemSrv}">selected</c:if>>${idOrdemSrv}</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <c:if test="${operacao != 'Alterar'}"> <input type="hidden" name="optOrdemSrv" value="${idOrdemSrv}"></c:if>
                        </td>
                    </tr>
                    <br>
                    <tr>
                        <td>
                            <label> Produto: </label>
                            <select name="optProduto" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${itensOrdem.produto.idProduto == null}">selected</c:if></option>
                            <c:forEach items="${produtos}" var="produto">
                                <option value="${produto.idProduto}" <c:if test="${itensOrdem.produto.idProduto == produto.idProduto}">selected</c:if>>${produto.nome}</option>
                            </c:forEach>
                        </select>
                        <c:if test="${operacao == 'Excluir'}"> <input type="hidden" name="optProduto" value="${itensOrdem.produto.idProduto}"></c:if>
                        </td>
                        <td>
                            <label> Quantidade: </label>
                            <input type="number" name="numQuantidade" value="${itensOrdem.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="btnConfirmar" value="${operacao}">
                    </td>
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href = 'PesquisaOrdemServicoController'"></td></tr></table>
    </body>
</html>
