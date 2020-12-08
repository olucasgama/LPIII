<%-- 
    Document   : telaRelClientes
    Created on : 15/03/2020, 09:04:52
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Clientes</title>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <ul class="main-nav">
            <h2>SGMC - Relatório de Clientes</h2>
        </ul>
        <form class="form" action="RelClientesController" method="post">
            <h3> Faixa de Clientes: </h3>
            <input type="text" name="txtCodClienteInicio"/><br/>
            <h3> até </h3>
            <input type="text" name="txtCodClienteFim"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
