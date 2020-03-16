<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC</title>
        <script type="text/javascript">       
            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.numIdAdmin.value == ""){
                    mensagem = mensagem + "Informe o Id do Admin\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe o nome\n";
                }
                if (form.txtEmail.value == ""){
                    mensagem = mensagem + "Informe o email\n";
                }
                if (form.txtSenha.value == ""){
                    mensagem = mensagem + "Informe a senha\n";
                }
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
        </script>
    </head>
    <body>
        <h1>Manter Admin - ${operacao}</h1>
        <form action="ManterAdminController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterAdmin" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td><label> ID Admin: </label>
                        <input type="number" name="numIdAdmin" value="${admin.idAdmin}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr> 
                    <tr>
                        <td><label> Nome: </label>
                            <input type="text" name="txtNome" value="${admin.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </td>
                        <td><label> Email: </label>
                            <input type="email" name="txtEmail" value="${admin.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td><label> Senha: </label>
                            <input type="password" name="txtSenha" value="${admin.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>

                        <td><label> Repetir Senha: </label>
                            <input type="password" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                    <td><input type="submit" name="btnConfirmar" value="${operacao}"></td>
                    </tr>
            </table>
            </form>
                    <table><tr><td><input type="submit" name="btnVoltar" value="Voltar" onclick="window.location.href='PesquisaAdminController'"></td></tr></table> 
    </body>
</html>
