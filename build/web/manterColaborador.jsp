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

            function validarFormulario(form) {

                var mensagem;
                mensagem = "";
                if (form.numIdColaborador.value == "") {
                    mensagem = mensagem + "Informe o id do colaborador\n";
                }
                if (form.txtNome.value == "") {
                    mensagem = mensagem + "Informe o nome\n";
                }
                if (form.txtDataNasc.value == "") {
                    mensagem = mensagem + "Informe a data de nascimento\n";
                }
                if (form.txtSenha.value == "") {
                    mensagem = mensagem + "Informe a senha\n";
                }
                if (form.numCPF.value == "") {
                    mensagem = mensagem + "Informe o CPF\n";
                }
                if (form.numRg.value == "") {
                    mensagem = mensagem + "Informe o RG\n";
                }
                if (form.txtEmail.value == "") {
                    mensagem = mensagem + "Informe o email\n";
                }
                if (form.txtTelefone.value == "") {
                    mensagem = mensagem + "Informe o telefone\n";
                }
                if (form.txtCelular.value == "") {
                    mensagem = mensagem + "Informe o celular\n";
                }
                if (frmManterColaborador.optEndereco.selectedIndex == "") {
                    mensagem = mensagem + "Informe o endereço\n";
                }
                if (form.numEndereco.value == "") {
                    mensagem = mensagem + "Informe o número do endereço\n";
                }
                if (form.txtComplemento.value == "") {
                    mensagem = mensagem + "Informe o complemento\n";
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
        <h1>Manter Colaborador - ${operacao}</h1>
        <form action="ManterColaboradorController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterColaborador" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label>ID Colaborador: </label>
                        <input type="number" name="numIdColaborador" value="${colaborador.idColaborador}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        <td><label>Nome: </label>
                            <input type="text" name="txtNome" value="${colaborador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Data Nascimento: </label>
                            <input type="date" name="txtDataNasc" value="${colaborador.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label> Senha: </label>
                            <input type="password" name="txtSenha" value="${colaborador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                        <td><label> Repetir Senha: </label>
                            <input type="password"></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td><label>CPF (somente números): </label>
                            <input type="number" name="numCPF" value="${colaborador.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>RG: </label>
                            <input type="text" name="numRg" value="${colaborador.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td></tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label>E-mail: </label>
                            <input type="email" name="txtEmail" value="${colaborador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Telefone: </label>
                            <input type="tel" name="txtTelefone" id="tel"  maxlength="14" onkeypress="consertaTel()" value="${colaborador.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label>Celular: </label>
                            <input type="tel" name="txtCelular" id="cel"  maxlength="15" onkeypress="consertaCel()" value="${colaborador.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td>
                            <label>Estado Civil: </label>
                            <select name="optEstadoCivil" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Solteiro(a)" <c:if test="${colaborador.estadoCivil == 'Solteiro(a)'}">selected</c:if>>Solteiro(a)</option>
                            <option value="Casado(a)" <c:if test="${colaborador.estadoCivil == 'Casado(a)'}">selected</c:if>>Casado(a)</option>
                            <option value="Viúvo(a)" <c:if test="${colaborador.estadoCivil == 'Viúvo(a)'}">selected</c:if>>Viúvo(a)</option>
                            </select>
                        </td>      
                        <td>
                            <label>Sexo: </label>
                            <select name="optSexo" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="Outro" <c:if test="${colaborador.sexo == 'Outro'}">selected</c:if>>Outro</option>
                            <option value="Masculino" <c:if test="${colaborador.sexo == 'Masculino'}">selected</c:if>>Masculino</option>
                            <option value="Feminino" <c:if test="${colaborador.sexo == 'Feminino'}">selected</c:if>>Feminino</option>
                            </select>
                        </td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td>
                            <label> Logradouro: </label>
                            <select name="optEndereco"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${colaborador.endereco.idEndereco == null}">selected</c:if></option>
                            <c:forEach items="${enderecos}" var="endereco">
                                <option value="${endereco.idEndereco}" <c:if test="${colaborador.endereco.idEndereco == endereco.idEndereco}">selected</c:if>>${endereco.logradouro}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label> Número: </label>
                        <input type="number" name="numEndereco" value="${colaborador.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td><label> Complemento: </label>
                            <input type="text" name="txtComplemento" value="${colaborador.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>    
                    <tr>
                        <td><input type="submit" name="btnConfirmar" value="${operacao}"></td>    
                </tr>
            </table>
        </form>
        <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href = 'PesquisaColaboradorController'"></td></tr></table>
    </body>
</html>
