/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PerdaDevolucaoDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PerdaDevolucao;
import model.Produto;
import model.Venda;

public class ManterDevolucaoController extends HttpServlet {

    private PerdaDevolucao perdaDevolucao;
    
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
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
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
            Logger.getLogger(ManterDevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterDevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterDevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterDevolucaoController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("vendas", VendaDAO.getInstancia().findAllVendas());
            request.setAttribute("produtos", ProdutoDAO.getInstancia().findAllProdutos());
            if(!operacao.equals("Incluir")){
                int idPerdaDevolucao = Integer.parseInt(request.getParameter("idPerdaDevolucao"));
                perdaDevolucao = PerdaDevolucaoDAO.getInstancia().findPerdaDevolucao(idPerdaDevolucao);
                request.setAttribute("perdaDevolucao", perdaDevolucao);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterDevolucao.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ClassNotFoundException, ServletException { 
        try {
        String operacao = request.getParameter("operacao");
        String tipo = request.getParameter("optTipo");
        int idProduto = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optProduto"));
        int idVenda = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optVenda"));
        Produto produto = null;
        if (idProduto != 0) {
            produto = ProdutoDAO.getInstancia().findProduto(idProduto);
        }
        Venda venda = null;
        if (idVenda != 0) {
        venda = VendaDAO.getInstancia().findVenda(idVenda);
        }
        if (operacao.equals("Incluir")) {
            perdaDevolucao = new PerdaDevolucao(tipo, produto, venda);
            PerdaDevolucaoDAO.getInstancia().save(perdaDevolucao);
        }else if(operacao.equals("Excluir")){
            PerdaDevolucaoDAO.getInstancia().remove(perdaDevolucao.getIdPerdaDevolucao());
        }else if(operacao.equals("Alterar")){
            perdaDevolucao.setTipo(tipo);
            perdaDevolucao.setProduto(produto);
            perdaDevolucao.setVenda(venda);
        }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaDevolucaoController");
        view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
