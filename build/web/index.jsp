<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMC</title>
        <script language="JavaScript">
            function popUp(theUrl, winName, features) {
                window.open(theUrl, winName, features);
            }
        </script>
    </head>
    <body>
        <ul>
            <h1></h1>
            <li><a href="PesquisaAdminController">Manter Admin</a></li>
            <h1></h1>
            <li><a href="PesquisaEnderecoController">Manter Endereço</a></li>
            <h1></h1>
            <li><a href="PesquisaColaboradorController">Manter Colaborador</a></li>
            <h1></h1>
        </ul><br>  
        <ul>
            <h1></h1>
            <li><a href="PesquisaCategoriaController">Manter Categoria</a></li>
            <h1></h1>
            <li><a href="PesquisaFornecedorController">Manter Fornecedor</a></li>
            <h1></h1>
            <li><a href="PesquisaProdutoController">Manter Produto</a></li>
            <h1></h1>
            <li><a href="PesquisaPagamentoController">Manter Pagamento</a></li>
        </ul><br>
        <ul>
            <h1></h1>
            <li><a href="PesquisaClienteController">Manter Cliente</a></li>       
            <h1></h1>
            <li><a href="PesquisaVendaController">Manter Venda</a></li>
            <h1></h1>
            <li><a href="PesquisaDevolucaoController">Manter Perda/Devolução</a></li> 
            <h1></h1>
            <li><a href="PesquisaOrdemServicoController">Manter Ordem de Serviço</a></li>
        </ul><br>
        <ul>
            <h1></h1>
            <li>
            <a href="javascript:void(0)" onClick="popUp('telaRelClientes.jsp','RelClientes','scrollbars=no, width=500, height=270, left=0, top=0')">Relatório de Clientes</a>
            <!--<li><a href="telaRelClientes">Manter Cliente</a></li>--> 
            </li>
        </ul><br>
    </body>
</html>
