/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ItensOrdemDAO;
import dao.OrdemServicoDAO;
import dao.ProdutoDAO;
import java.io.IOException;
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

    private ItemOrdem itensOrdem;

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
        try {
            String operacao = request.getParameter("operacao");
            int idOrdemSrv = Integer.parseInt(request.getParameter("idOrdemSrv"));
            int quantidade = Integer.parseInt(request.getParameter("numQuantidade"));
            int idProduto = Integer.parseInt(request.getParameter("optProduto"));

            Produto produto = null;
            if (idProduto != 0) {
                produto = ProdutoDAO.getInstancia().findProduto(idProduto);
            }
            OrdemServico ordemServico = null;
            if (idOrdemSrv != 0) {
                ordemServico = OrdemServicoDAO.getInstancia().findOrdemServico(idOrdemSrv);
            }
            if (operacao.equals("Incluir")) {
                itensOrdem = new ItemOrdem(quantidade, produto, ordemServico);
                ItensOrdemDAO.getInstancia().save(itensOrdem);
            } else {
                if (operacao.equals("Alterar")) {
                    itensOrdem.setOrdemServico(ordemServico);
                    itensOrdem.setProduto(produto);
                    itensOrdem.setQuantidade(quantidade);
                    ItensOrdemDAO.getInstancia().save(itensOrdem);
                } else {
                    if (operacao.equals("Excluir")) {
                        ItensOrdemDAO.getInstancia().remove(itensOrdem.getIdItensOrdem());
                    }
                }
            }
            request.setAttribute("idOrdemSrv", idOrdemSrv);
            RequestDispatcher view = request.getRequestDispatcher("/pesquisarItensOrdem.jsp");
            request.setAttribute("itensOrdens", ItensOrdemDAO.getInstancia().findAllItensOrdem(idOrdemSrv));
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("produtos", ProdutoDAO.getInstancia().findAllProdutos());
            request.setAttribute("ordensServicos", OrdemServicoDAO.getInstancia().findAllOrdemServicos());
            if (!operacao.equals("Incluir")) {
                Integer idItensOrdem = Integer.parseInt(request.getParameter("idItensOrdem"));
                itensOrdem = ItensOrdemDAO.getInstancia().findItemOrdem(idItensOrdem);
                request.setAttribute("itensOrdem", itensOrdem);
            }
            int idOrdemSrv = Integer.parseInt(request.getParameter("idOrdemSrv"));
            request.setAttribute("idOrdemSrv", idOrdemSrv);
            RequestDispatcher view = request.getRequestDispatcher("/manterItensOrdem.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
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
