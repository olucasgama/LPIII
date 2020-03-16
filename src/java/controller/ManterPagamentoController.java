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
import model.FormaPagamento;

public class ManterPagamentoController extends HttpServlet {

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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, ClassNotFoundException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")){
                int idFormaPgto = Integer.parseInt(request.getParameter("idFormaPgto"));
                FormaPagamento formaPagamento = FormaPagamento.obterFormaPagamento(idFormaPgto);
                request.setAttribute("formaPagamento", formaPagamento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPagamento.jsp");
            view.forward(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException e){
            throw new ServletException(e);
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
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPagamentoController.class.getName()).log(Level.SEVERE, null, ex);
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

    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException{
        String operacao = request.getParameter("operacao");
        int idFormaPgto = Integer.parseInt(request.getParameter("numIdPagamento"));
        String nome = request.getParameter("nome");
        int conta = Integer.parseInt(request.getParameter("conta"));
        int agencia = Integer.parseInt(request.getParameter("agencia"));
        String nomeBanco = request.getParameter("nomeBanco");
        String tipoConta = request.getParameter("optTipoConta");
        int numMaxParcelas = Integer.parseInt(request.getParameter("numMaxParcelas"));
        int intervaloParcelas = Integer.parseInt(request.getParameter("intervaloParcelas"));
        double taxaBanco = Double.parseDouble(request.getParameter("taxaBanco"));
        double taxaOperadora = Double.parseDouble(request.getParameter("taxaOperadora"));
        double multaAtraso = Double.parseDouble(request.getParameter("taxamultaAtraso"));
        String situacaoConfirmacao = request.getParameter("optSituacao");
        
        try{
            FormaPagamento formaPagamento = new FormaPagamento(idFormaPgto, nome, 
                    conta, agencia, nomeBanco, tipoConta, numMaxParcelas, 
            intervaloParcelas, taxaBanco, taxaOperadora, multaAtraso, situacaoConfirmacao);
            if(operacao.equals("Incluir")){
                formaPagamento.gravar();
            }else{
                if (operacao.equals("Alterar")){
                    formaPagamento.alterar();
                }else{
                    if (operacao.equals("Excluir")){
                        formaPagamento.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPagamentoController");
            view.forward(request, response);
        }
        catch(SQLException e){
            throw new ServletException(e);
        }
        catch(ClassNotFoundException e){
           throw new ServletException(e);
        }
    }
}
