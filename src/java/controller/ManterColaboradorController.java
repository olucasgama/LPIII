/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ColaboradorDAO;
import dao.EnderecoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Colaborador;
import model.Endereco;

public class ManterColaboradorController extends HttpServlet {
    
    private Colaborador colaborador;
    
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterColaboradorController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("enderecos", EnderecoDAO.getInstancia().findAllEnderecos());
            if(!operacao.equals("Incluir")){
                Integer idColaborador = Integer.parseInt(request.getParameter("idColaborador"));
                colaborador = ColaboradorDAO.getInstancia().findColaborador(idColaborador);
                request.setAttribute("colaborador", colaborador);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterColaborador.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ClassNotFoundException, ServletException {
        try{
            String operacao = request.getParameter("operacao");
            String nome = request.getParameter("txtNome");
            String cpf = request.getParameter("numCPF");
            String rg = request.getParameter("numRg");
            String telefone = request.getParameter("txtTelefone");
            String celular = request.getParameter("txtCelular");
            String email = request.getParameter("txtEmail");
            String senha = request.getParameter("txtSenha");   
            String dataNascimento = request.getParameter("txtDataNasc");
            String estadoCivil = request.getParameter("optEstadoCivil");
            String sexo = request.getParameter("optSexo");
            int numero = Integer.parseInt(request.getParameter("numEndereco"));
            String complemento = request.getParameter("txtComplemento");
            int idEndereco = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optEndereco"));
            Endereco endereco = null;
            if(idEndereco != 0){
                endereco = EnderecoDAO.getInstancia().findEndereco(idEndereco);
            }
            if(operacao.equals("Incluir")){
                colaborador = new Colaborador(cpf, rg, dataNascimento, 
                    telefone, celular, estadoCivil, sexo, numero, complemento, 
                    nome, email, senha, endereco);
                ColaboradorDAO.getInstancia().save(colaborador);
            }else if(operacao.equals("Excluir")){
                    ColaboradorDAO.getInstancia().remove(colaborador.getIdUsuario());
                }else if(operacao.equals("Alterar")){
                    colaborador.setCpf(cpf);
                    colaborador.setRg(rg);
                    colaborador.setDataNascimento(dataNascimento);
                    colaborador.setTelefone(telefone);
                    colaborador.setCelular(celular);
                    colaborador.setEstadoCivil(estadoCivil);
                    colaborador.setSexo(sexo);
                    colaborador.setNumero(numero);
                    colaborador.setComplemento(complemento);
                    colaborador.setNome(nome);
                    colaborador.setEmail(email);
                    colaborador.setSenha(senha);
                    colaborador.setEndereco(endereco);
                    ColaboradorDAO.getInstancia().save(colaborador);
                }
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisaColaboradorController");
            view.forward(request, response);
        } catch (IOException e){
            throw new ServletException(e);
        }
    }
}
