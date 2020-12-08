/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;

public class ManterEnderecoController extends HttpServlet {

    private Endereco endereco;
    
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
    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException, SQLException {

        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if (!operacao.equals("Incluir")) {
                int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
                //Endereco endereco = Endereco.obterEndereco(idEndereco);
                endereco = EnderecoDAO.getInstancia().findEndereco(idEndereco);
                request.setAttribute("endereco", endereco);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEndereco.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ClassNotFoundException, ServletException, IOException {
        try{
        String operacao = request.getParameter("operacao");
//        int idEndereco = Integer.parseInt(request.getParameter("numIdEndereco"));
        String logradouro = request.getParameter("txtLogradouro");
        String cidade = request.getParameter("txtCidade");
        String bairro = request.getParameter("txtBairro");
        String uf = request.getParameter("txtUf");
        String cep = request.getParameter("txtCep");
//        endereco = new Endereco(/*idEndereco,*/ logradouro, cidade, bairro, 
//                uf, cep);
            if (operacao.equals("Incluir")) {
                //endereco.gravar();
                endereco = new Endereco (logradouro, cidade, bairro, uf, cep);
                EnderecoDAO.getInstancia().save(endereco);
            } else {
                if (operacao.equals("Excluir")) {
                    EnderecoDAO.getInstancia().remove(endereco.getIdEndereco());
                }
                if (operacao.equals("Alterar")) {
                    endereco.setLogradouro(logradouro);
                    endereco.setCidade(cidade);
                    endereco.setBairro(bairro);
                    endereco.setUf(uf);
                    endereco.setCep(cep);
                    EnderecoDAO.getInstancia().save(endereco);
                }
            }
        
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEnderecoController");
            view.forward(request, response);
        }
        catch (IOException e) {
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
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterEnderecoController.class.getName()).log(Level.SEVERE, null, ex);
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
