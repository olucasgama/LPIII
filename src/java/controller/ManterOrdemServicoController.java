/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FornecedorDAO;
import dao.OrdemServicoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;
import model.OrdemServico;

public class ManterOrdemServicoController extends HttpServlet {

    private OrdemServico ordemServico;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterOrdemServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOrdemServicoController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterOrdemServicoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOrdemServicoController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("fornecedores", FornecedorDAO.getInstancia().findAllFornecedors());
            if (!operacao.equals("Incluir")) {
                Integer idOrdemSrv = Integer.parseInt(request.getParameter("idOrdemSrv"));
                ordemServico = OrdemServicoDAO.getInstancia().findOrdemServico(idOrdemSrv);
                request.setAttribute("ordemServico", ordemServico);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterOrdemServico.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        String dataPedido = request.getParameter("dtDataPedido");
        String situacao = request.getParameter("optSituacao");
        String descricao = request.getParameter("txtDescricao");
        int numOS = Integer.parseInt(request.getParameter("txtNumeroOS"));
        int idFornecedor = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optFornecedor"));

        Fornecedor fornecedor = null;
        if (idFornecedor != 0) {
            fornecedor = FornecedorDAO.getInstancia().findFornecedor(idFornecedor);
        }
        if (operacao.equals("Incluir")) {
            ordemServico = new OrdemServico(dataPedido, situacao,
                    descricao, numOS, fornecedor);
            OrdemServicoDAO.getInstancia().save(ordemServico);
        } else {
            if (operacao.equals("Excluir")) {
                OrdemServicoDAO.getInstancia().removeItem(ordemServico.getIdOrdemSrv());
                OrdemServicoDAO.getInstancia().remove(ordemServico.getIdOrdemSrv());
            }
            if (operacao.equals("Alterar")) {
                ordemServico.setDataPedido(dataPedido);
                ordemServico.setDescricao(descricao);
                ordemServico.setFornecedor(fornecedor);
                ordemServico.setNumOS(numOS);
                ordemServico.setSituacao(situacao);
                OrdemServicoDAO.getInstancia().save(ordemServico);
            }
        }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaOrdemServicoController");
        view.forward(request, response);
    }

}
