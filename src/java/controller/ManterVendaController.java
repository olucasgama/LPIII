/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.FormaPagamentoDAO;
import dao.ItensVendaDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.FormaPagamento;
import model.ItemVenda;
import model.Usuario;
import model.Venda;

public class ManterVendaController extends HttpServlet {

    private Venda venda;
    private ItemVenda itemVenda;

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
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("pagamentos", FormaPagamentoDAO.getInstancia().findAllFormasPagamentos());
            request.setAttribute("clientes", ClienteDAO.getInstancia().findAllClientes());
            request.setAttribute("usuarios", UsuarioDAO.getInstancia().findAllUsuarios());
            if (!operacao.equals("Incluir")) {
                Integer idVenda = Integer.parseInt(request.getParameter("idVenda"));
                venda = VendaDAO.getInstancia().findVenda(idVenda);
                request.setAttribute("venda", venda);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterVenda.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        try {
            String operacao = request.getParameter("operacao");
            String dataVenda = request.getParameter("dtDataVenda");
            int idCliente = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optCliente"));
            int idUsuario = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optUsuario"));
            float subTotal = Float.parseFloat(request.getParameter("numSubTotal"));
            int codBarra = Integer.parseInt(request.getParameter("numCodBarra"));
            float valorDesconto = Float.parseFloat(request.getParameter("numValorDesconto"));
            String situacao = request.getParameter("optSituacao");
            int idFormaPgto = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optPagamento"));
            Cliente cliente = null;
            if (idCliente != 0) {
                cliente = ClienteDAO.getInstancia().findCliente(idCliente);
            }
            Usuario usuario = null;
            if (idUsuario != 0) {
                usuario = UsuarioDAO.getInstancia().findUsuario(idUsuario);
            }
            FormaPagamento formaPagamento = null;
            if (idFormaPgto != 0) {
                formaPagamento = FormaPagamentoDAO.getInstancia().findFormaPagamento(idFormaPgto);
            }
            if (operacao.equals("Incluir")) {
                venda = new Venda(dataVenda, subTotal, codBarra, valorDesconto,
                        situacao, usuario, formaPagamento, cliente);
                VendaDAO.getInstancia().save(venda);
            } else if (operacao.equals("Alterar")) {
                venda.setCliente(cliente);
                venda.setCodBarra(codBarra);
                venda.setDataVenda(dataVenda);
                venda.setFormaPagamento(formaPagamento);
                venda.setSituacao(situacao);
                venda.setUsuario(usuario);
                venda.setSubTotal(subTotal);
                venda.setValorDesconto(valorDesconto);
                VendaDAO.getInstancia().save(venda);
            } else if (operacao.equals("Excluir")) {
                VendaDAO.getInstancia().removeItem(venda.getIdVenda());
                VendaDAO.getInstancia().remove(venda.getIdVenda());
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaVendaController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
