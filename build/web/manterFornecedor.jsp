<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC</title>
         <script type="text/javascript">
              
            var novo = "";
            var i;
            var num = "1234567890";
            function consertaTel() {
                var c = "";
                var str = "";
                for (i = 0; i < tel.value.length; i++) {
                    c = tel.value.charAt(i);
                    if (num.indexOf(c) != -1) {
                        str += c;
                    }
                }
                if (str.length == 2) {
                    novo = "(" + str.substr(0, 2) + ") ";
                    document.getElementById("tel").value = novo;
                }
                if (str.length == 6) {
                    novo = "(" + str.substr(0, 2) + ") " + str.substr(2, 4) + "-";
                    document.getElementById("tel").value = novo;
                }
                if (str.length == 10) {
                    novo = "(" + str.substr(0, 2) + ") " + str.substr(2, 4) + "-" + str.substr(6, 4);
                    document.getElementById("tel").value = novo;
                }
            }
            
            function validarFormulario(form) {

                var mensagem;
                mensagem = "";

                if (form.numIdFornecedor.value == "") {
                    mensagem = mensagem + "Informe o Id do Fornecedor\n";
                }
                if (form.txtNomeFantasia.value == "") {
                    mensagem = mensagem + "Informe o nome fantasia\n";
                }
                if (form.numCnpj.value == "") {
                    mensagem = mensagem + "Informe o CNPJ\n";
                }
                if (form.txtNomeRepresentante.value == "") {
                    mensagem = mensagem + "Informe o nome do representante\n";
                }
                if (form.txtEmail.value == "") {
                    mensagem = mensagem + "Informe o email\n";
                }
                if (form.numTelefone.value == "") {
                    mensagem = mensagem + "Informe o telefone\n";
                }
                if (frmManterFornecedor.optEndereco.selectedIndex == 0) {
                    mensagem = mensagem + "Informe o endereço\n";
                }
                if (form.numEndereco.value == "") {
                    mensagem = mensagem + "Informe o número do endereço\n";
                }
                if (form.txtComplemento.value == "") {
                    mensagem = mensagem + "Informe o complemento do endereço\n";
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
        <h1>Manter Fornecedor - ${operacao}</h1>
        <form action="ManterFornecedorController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterFornecedor" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label> ID: </label>
                        <input type="number" name="numIdFornecedor" value="${fornecedor.idFornecedor}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr> 
                <tr>
                    <td><label> Nome Fantasia: </label>
                        <input type="text" name="txtNomeFantasia" value="${fornecedor.nomeFantasia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> CNPJ (somente números): </label>
                        <input type="number" name="numCnpj" value="${fornecedor.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Nome Representante: </label>
                        <input type="text" name="txtNomeRepresentante" value="${fornecedor.nomeRepresentante}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>           
                <tr><td></td></tr> 
                <tr>
                    <td><label> E-mail: </label>
                        <input type="email" name="txtEmail" value="${fornecedor.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </td>
                    <td><label> Telefone: </label>
                        <input type="tel" name="numTelefone" id="tel"  maxlength="14" onkeypress="consertaTel()" value="${fornecedor.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr> 
                <tr>
                    <td>
                        <label> Endereço: </label>
                        <select name="optEndereco" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${fornecedor.endereco.idEndereco == null}">selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.idEndereco}" <c:if test="${fornecedor.endereco.idEndereco == endereco.idEndereco}">selected</c:if>>${endereco.logradouro}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label> Número: </label>
                        <input type="number" name="numEndereco" value="${fornecedor.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td><label> Complemento: </label>
                        <input type="text" name="txtComplemento" value="${fornecedor.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr><td></td></tr> 
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="${operacao}">
                    </td>    
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='PesquisaFornecedorController'"></td></tr></table>
    </body>
</html>
