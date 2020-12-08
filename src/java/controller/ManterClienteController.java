/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
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
import model.Cliente;
import model.Endereco;

public class ManterClienteController extends HttpServlet {

    private Cliente cliente;

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
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("enderecos", EnderecoDAO.getInstancia().findAllEnderecos());
            if (!operacao.equals("Incluir")) {
                Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
                cliente = ClienteDAO.getInstancia().findCliente(idCliente);
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
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
        String nome = request.getParameter("txtNome");
        String cnpj = request.getParameter("numCnpj");
        String razaoSocial = request.getParameter("txtRazao");
        String inscricaoEstadual = request.getParameter("txtInscricao");
        String cpf = request.getParameter("numCPF");
        String rg = request.getParameter("numRg");
        String telefone = request.getParameter("txtTelefone");
        String celular = request.getParameter("txtCelular");
        String email = request.getParameter("txtEmail");
        String dataNascimento = request.getParameter("txtDataNasc");
        String estadoCivil = request.getParameter("optEstadoCivil");
        String sexo = request.getParameter("optSexo");
        int numero = Integer.parseInt(request.getParameter("numEndereco"));
        String complemento = request.getParameter("txtComplemento");
        int idEndereco = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optEndereco"));
        Endereco endereco = null;
        if (idEndereco != 0) {
            endereco = EnderecoDAO.getInstancia().findEndereco(idEndereco);
        }
        if (operacao.equals("Incluir")) {
            cliente = new Cliente(cnpj, razaoSocial, inscricaoEstadual, nome, 
                    cpf, rg, telefone, celular, email, dataNascimento, estadoCivil, 
                    sexo, numero, complemento, endereco);
            ClienteDAO.getInstancia().save(cliente);
        } else if (operacao.equals("Alterar")) {
            cliente.setCnpj(cnpj);
            cliente.setRazaoSocial(razaoSocial);
            cliente.setInscricaoEstadual(inscricaoEstadual);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setRg(rg);
            cliente.setTelefone(telefone);
            cliente.setCelular(celular);
            cliente.setEmail(email);
            cliente.setDataNascimento(dataNascimento);
            cliente.setEstadoCivil(estadoCivil);
            cliente.setSexo(sexo);
            cliente.setNumero(numero);
            cliente.setComplemento(complemento);
            cliente.setEndereco(endereco);
            ClienteDAO.getInstancia().save(cliente);
        } else if (operacao.equals("Excluir")) {
             ClienteDAO.getInstancia().remove(cliente.getIdCliente());
        }
        RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
        view.forward(request, response);
        }catch (IOException e) {
            throw new ServletException(e);
        }
    }
}

