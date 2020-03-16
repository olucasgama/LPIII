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
            function consertaCel() {
                var c = "";
                var str = "";
                for (i = 0; i < cel.value.length; i++) {
                    c = cel.value.charAt(i);
                    if (num.indexOf(c) != -1) {
                        str += c;
                    }
                }
                if (str.length == 2) {
                    novo = "(" + str.substr(0, 2) + ") ";
                    document.getElementById("cel").value = novo;
                }
                if (str.length == 6) {
                    novo = "(" + str.substr(0, 2) + ") " + str.substr(2, 4) + "-";
                    document.getElementById("cel").value = novo;
                }
                if (str.length == 10) {
                    novo = "(" + str.substr(0, 2) + ") " + str.substr(2, 5) + "-" + str.substr(7, 4);
                    document.getElementById("cel").value = novo;
                }
            }

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

            function fisica() {
                document.getElementById("cnpj").disabled = true;
                document.getElementById("rc").disabled = true;
                document.getElementById("ie").disabled = true;
                document.getElementById("cnpj").value = "";
                document.getElementById("rc").value = "";
                document.getElementById("ie").value = "";

                document.getElementById("dt").disabled = false;
                document.getElementById("cpf").disabled = false;
                document.getElementById("rg").disabled = false;
                document.getElementById("ec").disabled = false;
                document.getElementById("sx").disabled = false;
            }
            function juridica() {
                document.getElementById("dt").disabled = true;
                document.getElementById("cpf").disabled = true;
                document.getElementById("rg").disabled = true;
                document.getElementById("ec").disabled = true;
                document.getElementById("sx").disabled = true;
                document.getElementById("dt").value = "";
                document.getElementById("cpf").value = "";
                document.getElementById("rg").value = "";
                document.getElementById("ec").value = "";
                document.getElementById("sx").value = "";

                document.getElementById("cnpj").disabled = false;
                document.getElementById("rc").disabled = false;
                document.getElementById("ie").disabled = false;
            }
            function validarFormulario(form) {

                var mensagem;
                mensagem = "";

                if (form.numIdCliente.value == "") {
                    mensagem = mensagem + "Informe o Id do Cliente\n";
                }
                if (frmManterCliente.optEndereco.selectedIndex == 0) {
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
        <h1>Manter Cliente - ${operacao}</h1>
        <form action="ManterClienteController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterCliente" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label>ID Cliente: </label>
                        <input type="number" name="numIdCliente" value="${cliente.idCliente}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        <td><label>Nome: </label>
                            <input type="text" name="txtNome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>          
                        <td><input type="radio" name="tipoPessoa"  onclick="juridica()">Pessoa Juridica<br>
                            <input type="radio" name="tipoPessoa"  onclick="fisica()">Pessoa Fisica</td>
                        <td><label>Data Nascimento: </label>
                            <input type="date" name="txtDataNasc" id="dt" value="${cliente.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>

                        <td><label>CPF (somente números): </label>
                            <input type="number" name="numCPF" id="cpf" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>RG: </label>
                            <input type="text" name="numRg" id="rg" value="${cliente.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label>CNPJ (somente números): </label>
                            <input type="text" name="numCnpj" id="cnpj" value="${cliente.cnpj}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Razão Social: </label>
                            <input type="text" name="txtRazao" id="rc" value="${cliente.razaoSocial}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Inscrição Estadual: </label>
                            <input type="text" name="txtInscricao" id="ie" value="${cliente.inscricaoEstadual}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label>E-mail: </label>
                            <input type="text" name="txtEmail" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Telefone: </label>
                            <input type="text" name="txtTelefone" id="tel"  maxlength="14" onkeypress="consertaTel()" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Celular: </label>
                            <input type="text" name="txtCelular" id="cel"  maxlength="15" onkeypress="consertaCel()" value="${cliente.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label>Estado Civil: </label>
                            <select name="optEstadoCivil" id="ec" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Solteiro(a)" <c:if test="${cliente.estadoCivil == 'Solteiro(a)'}"> selected</c:if>>Solteiro(a)</option>
                            <option value="Casado(a)" <c:if test="${cliente.estadoCivil == 'Casado(a)'}"> selected</c:if>>Casado(a)</option>
                            <option value="Viúvo(a)" <c:if test="${cliente.estadoCivil == 'Viúvo(a)'}"> selected</c:if>>Viúvo(a)</option>
                            </select></td>      
                        <td><label>Sexo: </label>
                            <select name="optSexo" id="sx" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Outro" <c:if test="${cliente.sexo == 'Outro'}"> selected</c:if>>Outro</option>
                            <option value="Masculino" <c:if test="${cliente.sexo == 'Masculino'}"> selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${cliente.sexo == 'Feminino'}"> selected</c:if>>Feminino</option>
                            </select></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label> Endereço: </label>
                            <select name="optEndereco" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${cliente.endereco.idEndereco == null}">selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.idEndereco}" <c:if test="${cliente.endereco.idEndereco == endereco.idEndereco}">selected</c:if>>${endereco.logradouro}</option>
                            </c:forEach>
                        </select></td>
                    <td><label>Número: </label>
                        <input type="number" name="numEndereco" value="${cliente.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Complemento: </label>
                            <input type="text" name="txtComplemento" value="${cliente.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>    
                    <tr>
                        <td>
                            <input type="submit" name="btnConfirmar" value="${operacao}">
                    </td>
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href = 'PesquisaClienteController'"></td></tr></table>
    </body>
</html>
