/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class ManterItensVendaController extends HttpServlet {

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
            Logger.getLogger(ManterItensVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItensVendaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterItensVendaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItensVendaController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int idItensVenda = Integer.parseInt(request.getParameter("numIdItensVenda"));
        int idVenda = Integer.parseInt(request.getParameter("idVenda"));
        int idProduto = Integer.parseInt(request.getParameter("optProduto"));
        int quantidade = Integer.parseInt(request.getParameter("numQuantidade"));
        float precoUnitario = Float.parseFloat(request.getParameter("numPrecoUnitario"));

        try {
            Produto produto = null;
            if (idProduto != 0) {
                produto = Produto.obterProduto(idProduto);
            }
            Venda venda = null;
            if (idVenda != 0) {
                venda = Venda.obterVenda(idVenda);
            }
            ItemVenda itensVenda = new ItemVenda(idItensVenda, quantidade, precoUnitario,
                    venda, produto);
            itensVenda.setIdVenda(idVenda);
            itensVenda.setIdProduto(idProduto);
            if (operacao.equals("Incluir")) {
                itensVenda.gravar();
            } else {
                if (operacao.equals("Alterar")) {
                    itensVenda.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        itensVenda.excluir();
                    }
                }
            }
            request.setAttribute("idVenda", idVenda);
            RequestDispatcher view = request.getRequestDispatcher("/pesquisarItensVenda.jsp");
            request.setAttribute("itensVenda", ItemVenda.obterItensVenda(idVenda));
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("produtos", Produto.obterProdutos());
            request.setAttribute("vendas", Venda.obterVendas());
            if (!operacao.equals("Incluir")) {
                int idIntensVenda = Integer.parseInt(request.getParameter("idItensVenda"));
                ItemVenda itensVenda = ItemVenda.obterItemVenda(idIntensVenda);
                request.setAttribute("itensVenda", itensVenda);
            }
            int idVenda = Integer.parseInt(request.getParameter("idVenda"));
            request.setAttribute("idVenda", idVenda);

            RequestDispatcher view = request.getRequestDispatcher("/manterItensVenda.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

}
