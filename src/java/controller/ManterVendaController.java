/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.FormaPagamento;
import model.Usuario;
import model.Venda;

public class ManterVendaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if(acao.equals("confirmarOperacao")){
            confirmarOperacao(request, response);
        }else{
            if(acao.equals("prepararOperacao")){
                prepararOperacao(request, response);
            }
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("pagamentos", FormaPagamento.obterFormasPagamentos());
            request.setAttribute("clientes", Cliente.obterClientes());
            request.setAttribute("usuarios", Usuario.obterUsuarios());
            if(!operacao.equals("Incluir")){
                int idVenda = Integer.parseInt(request.getParameter("idVenda"));
                Venda venda = Venda.obterVenda(idVenda);
                request.setAttribute("venda", venda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterVenda.jsp");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException | SQLException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException{
        String operacao = request.getParameter("operacao");
        int idVenda = Integer.parseInt(request.getParameter("numIdVenda"));
        String dataVenda = request.getParameter("dtDataVenda");
        int idCliente = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optCliente"));
        int idUsuario = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optUsuario"));
        float subTotal = Float.parseFloat(request.getParameter("numSubTotal"));
        int codBarra = Integer.parseInt(request.getParameter("numCodBarra"));
        float valorDesconto = Float.parseFloat(request.getParameter("numValorDesconto"));
        String situacao = request.getParameter("optSituacao");
        int idFormaPgto = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optPagamento"));
        try{
            Cliente cliente = null;
            if(idCliente != 0){
                cliente = Cliente.obterCliente(idCliente);
            }
            Usuario usuario = null;
            if(idUsuario != 0){
                usuario = Usuario.obterUsuario(idUsuario);
            }
            FormaPagamento formaPagamento = null;
            if(idFormaPgto != 0){
                formaPagamento = FormaPagamento.obterFormaPagamento(idFormaPgto);
            }
            Venda venda = new Venda(idVenda, dataVenda, subTotal, codBarra, 
            valorDesconto, situacao, usuario, formaPagamento, cliente);
            if(operacao.equals("Incluir")){
                venda.gravar();
            }else{
                if(operacao.equals("Alterar")){
                    venda.alterar();
                }else{
                    if (operacao.equals("Excluir")){
                        venda.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendaController");
            view.forward(request, response);
        }
        catch(SQLException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
    
}
