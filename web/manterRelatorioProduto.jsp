<%-- 
    Document   : telaRelProdutos
    Created on : 05/10/2020, 13:09:59
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <ul class="main-nav">
            <h2>SGMC - Relatório de Produtos por Categoria</h2>
        </ul>
        <form class="form-relatorio" action="RelProdutosController?acao=emitir" method="post">
            <h3>Selecione a Categoria:</h3>
            <select name="txtCodCategoria">
                <c:forEach items="${categorias}" var="categoria">
                    <option value="${categoria.idCategoria}">${categoria.descricao}</option>  
                </c:forEach>
            </select>
            <input type="submit"/>
        </form>
    </body>
</html>
