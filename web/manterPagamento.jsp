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

                if (form.numIdPagamento.value == "") {
                    mensagem = mensagem + "Informe o Id do pagamento\n";
                }
                if (form.nome.value == "") {
                    mensagem = mensagem + "Informe o nome da forma de pagamento\n";
                }
                if (form.conta.value == "") {
                    mensagem = mensagem + "Informe o número da conta\n";
                }
                if (form.agencia.value == "") {
                    mensagem = mensagem + "Informe o número da agência\n";
                } 
                if (form.nomeBanco.value == "") {
                    mensagem = mensagem + "Informe o nome do banco\n";
                } 
                if (form.numMaxParcelas.value == "") {
                    mensagem = mensagem + "Informe o número máximo de parcelas\n";
                } 
                if (form.intervaloParcelas.value == "") {
                    mensagem = mensagem + "Informe o intervalo de parcelas\n";
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
        <h1>Manter Pagamento - ${operacao}</h1>
        <form action="ManterPagamentoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterPagamento"  onsubmit="return validarFormulario(this)">
        <table>
                <tr>
                    <td><label> ID: </label>
                        <input type="number" name="numIdPagamento" value="${formaPagamento.idFormaPgto}"<c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </td>
                </tr>
                <tr><td></td></tr>
                <tr>
                    
                    <td><label> Nome da Forma de Pagamento: </label>
                        <input type="text" name="nome" value="${formaPagamento.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Conta: </label>
                        <input type="number" name="conta" value="${formaPagamento.conta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Agência: </label>
                        <input type="number" name="agencia" value="${formaPagamento.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr>
                <tr><td><label> Banco: </label>
                        <input type="text" name="nomeBanco" value="${formaPagamento.nomeBanco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Tipo de Conta: </label>
                        <select name="optTipoConta"  <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Conta Poupança"><c:if test="${formaPagamento.tipoConta == 'Conta Poupança'}">selected</c:if>Conta Poupança</option>
                            <option value="Conta Corrente"><c:if test="${formaPagamento.tipoConta == 'Conta Corrente'}">selected</c:if>Conta Corrente</option>
                        </select></td>
                </tr>
                <tr><td></td></tr>
                <tr>
                    <td><label> Num. Máximo de Parcelas: </label>
                        <input type="number" name="numMaxParcelas" value="${formaPagamento.numMaxParcelas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Intervalo de Parcelas (dias): </label>
                        <input type="number" name="intervaloParcelas" value="${formaPagamento.intervaloParcelas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr>
                <tr>
                        
                    <td><label> Taxa do Banco (%): </label>
                        <input type="number" name="taxaBanco" value="${formaPagamento.taxaBanco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Taxa da Operadora (%): </label>
                        <input type="number" name="taxaOperadora" value="${formaPagamento.taxaOperadora}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Taxa da Multa de Atraso (%): </label>
                        <input type="number" name="taxamultaAtraso" value="${formaPagamento.multaAtraso}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr>
                <tr>
                    <td><label> Situação de Confirmação do Pagamento: </label>
                        <select name="optSituacao"  <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Automático"><c:if test="${formaPagamento.situacaoConfirmacao == 'Automático'}">selected</c:if>Automático</option>
                            <option value="Manual"><c:if test="${formaPagamento.situacaoConfirmacao == 'Manual'}">selected</c:if>Manual</option>
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
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='PesquisaPagamentoController'"></td></tr></table>
    </body>
</html>
