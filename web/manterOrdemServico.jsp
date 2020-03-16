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

                if (form.numIdOrdemServico.value == "") {
                    mensagem = mensagem + "Informe o Id da Ordem de Serviço\n";
                }
                if (form.txtNumeroOS.value == "") {
                    mensagem = mensagem + "Informe o número da ordem de serviço\n";
                }
                if (form.txtDescricao.value == "") {
                    mensagem = mensagem + "Informe a descrição\n";
                }
                if (frmManterOrdemServico.optFornecedor.selectedIndex == 0) {
                    mensagem = mensagem + "Informe o fornecedor\n";
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
        <h1>Manter Ordem de Serviço - ${operacao}</h1>
        <form action="ManterOrdemServicoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterOrdemServico" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>
                        <label> ID: </label>
                        <input type="number" name="numIdOrdemServico" value="${ordemServico.idOrdemSrv}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </td>
                        <td>
                            <label> Número da Ordem de Serviço: </label>
                            <input type="number" name="txtNumeroOS" value="${ordemServico.numOS}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                    </tr>
                    <tr><td></td></tr> 
                    <tr>
                        <td>
                            <label> Fornecedor: </label>
                            <select name="optFornecedor" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${ordemServico.fornecedor.idFornecedor == null}">selected</c:if></option>
                            <c:forEach items="${fornecedores}" var="fornecedor">
                                <option value="${fornecedor.idFornecedor}" <c:if test="${ordemServico.fornecedor.idFornecedor == fornecedor.idFornecedor}">selected</c:if>>${fornecedor.nomeFantasia}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label> Descrição: </label>
                        <input type="text" name="txtDescricao" value="${ordemServico.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr> 
                    <tr>
                        <td><label> Data Pedido: </label>
                            <input type="date" name="dtDataPedido" value="${ordemServico.dataPedido}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label> Situação: </label>
                            <select name="optSituacao" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Em Aberto"<c:if test="${ordemServico.situacao == 'Em Aberto'}">selected</c:if>>Em Aberto</option>
                            <option value="Recebida"<c:if test="${ordemServico.situacao == 'Recebida'}">selected</c:if>>Recebida</option>
                            </select>
                        </td>
                    </tr>
                    <tr><td></td></tr> 
                    <tr>
                        <td><input type="submit" name="btnConfirmar" value="${operacao}">
                    </td>
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='PesquisaOrdemServicoController'"></td></tr></table>
    </body>
</html>
