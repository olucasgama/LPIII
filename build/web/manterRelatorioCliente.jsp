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
    </head>
    <body>
        <h1>Relatório de Clientes</h1>
        <form action="RelClientesController" method="post">
            Faixa de Clientes:
            <input type="text" name="txtCodClienteInicio"/><br/>
            até
            <input type="text" name="txtCodClienteFim"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
