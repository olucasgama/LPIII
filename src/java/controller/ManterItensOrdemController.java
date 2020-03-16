/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.ItemOrdem;
import model.OrdemServico;
import model.Produto;

public class ManterItensOrdemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
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

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        int idItensOrdem = Integer.parseInt(request.getParameter("numIdItensOrdem"));
        int idOrdemSrv = Integer.parseInt(request.getParameter("idOrdemSrv"));
        int quantidade = Integer.parseInt(request.getParameter("numQuantidade"));
        int idProduto = Integer.parseInt(request.getParameter("optProduto"));

        try {
            Produto produto = null;
            if (idProduto != 0) {
                produto = Produto.obterProduto(idProduto);
            }
            OrdemServico ordemServico = null;
            if (idOrdemSrv != 0) {
                ordemServico = OrdemServico.obterOrdemServico(idOrdemSrv);
            }
            ItemOrdem itensOrdem = new ItemOrdem(idItensOrdem, quantidade, produto, ordemServico);
            if (operacao.equals("Incluir")) {
                itensOrdem.gravar();
            } else {
                if (operacao.equals("Alterar")) {
                    itensOrdem.alterar();
                } else {
                    if (operacao.equals("Excluir")) {
                        itensOrdem.excluir();
                    }
                }
            }
            request.setAttribute("idOrdemSrv", idOrdemSrv);
            RequestDispatcher view = request.getRequestDispatcher("/pesquisarItensOrdem.jsp");
            request.setAttribute("itensOrdens", ItemOrdem.obterItensOrdem(idOrdemSrv));
            view.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("produtos", Produto.obterProdutos());
            request.setAttribute("ordensServicos", OrdemServico.obterOrdemServicos());
            if (!operacao.equals("Incluir")) {
                int idItensOrdem = Integer.parseInt(request.getParameter("idItensOrdem"));
                ItemOrdem itensOrdem = ItemOrdem.obterItemOrdem(idItensOrdem);
                request.setAttribute("itensOrdem", itensOrdem);
            }
            int idOrdemSrv = Integer.parseInt(request.getParameter("idOrdemSrv"));
            request.setAttribute("idOrdemSrv", idOrdemSrv);
            RequestDispatcher view = request.getRequestDispatcher("/manterItensOrdem.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException | SQLException | ClassNotFoundException e) {
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
            Logger.getLogger(ManterItensOrdemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItensOrdemController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterItensOrdemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterItensOrdemController.class.getName()).log(Level.SEVERE, null, ex);
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

}
