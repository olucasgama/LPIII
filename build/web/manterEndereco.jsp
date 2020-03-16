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

                if (form.numIdEndereco.value == "") {
                    mensagem = mensagem + "Informe o Id do Endereço\n";
                }
                if (form.txtLogradouro.value == "") {
                    mensagem = mensagem + "Informe o logradouro\n";
                }
                if (form.txtCidade.value == "") {
                    mensagem = mensagem + "Informe a cidade\n";
                }
                if (form.txtBairro.value == "") {
                    mensagem = mensagem + "Informe o bairro\n";
                }
                if (form.txtUf.value == "") {
                    mensagem = mensagem + "Informe a UF(Unidade da Federação)\n";
                }
                if (form.txtCep.value == "") {
                    mensagem = mensagem + "Informe o CEP\n";
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
        <h1>Manter Endereco - ${operacao}</h1>
        <form action="ManterEnderecoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterEndereco" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label> ID: </label>
                        <input type="number" name="numIdEndereco" value="${endereco.idEndereco}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr> 
                    <tr>
                        <td><label> Logradouro: </label>
                            <input type="text" name="txtLogradouro" value="${endereco.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label> Cidade: </label>
                            <input type="text" name="txtCidade" value="${endereco.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>           
                    <tr><td></td></tr> 
                    <tr>
                        <td><label> Bairro: </label>
                            <input type="text" name="txtBairro" value="${endereco.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        <td><label> UF: </label>
                            <input type="text" name="txtUf" value="${endereco.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        <td><label> CEP: </label>
                            <input type="number" name="txtCep" value="${endereco.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>  
                    <tr>
                        <td><input type="submit" name="btnConfirmar" value="${operacao}">
                    </td>
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href = 'PesquisaEnderecoController'"></td></tr></table>
    </body>
</html>
