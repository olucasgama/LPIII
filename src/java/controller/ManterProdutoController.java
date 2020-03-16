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
import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class ManterProdutoController extends HttpServlet {

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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
            try{
                String operacao = request.getParameter("operacao");
                request.setAttribute("operacao", operacao);
                request.setAttribute("fornecedores", Fornecedor.obterFornecedores());
                request.setAttribute("categorias", Categoria.obterCategorias());
                if (!operacao.equals("Incluir")){
                    int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                    Produto produto = Produto.obterProduto(idProduto);
                    request.setAttribute("produto", produto);
                }
                RequestDispatcher view = request.getRequestDispatcher("/manterProduto.jsp");
                view.forward(request, response);
            }catch(ServletException e){
                throw e;
            }catch(IOException | SQLException | ClassNotFoundException e){
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
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
        int idProduto = Integer.parseInt(request.getParameter("numIdProduto"));
        String nome = request.getParameter("nomeProduto");
        int codInterno = Integer.parseInt(request.getParameter("numCodInterno"));
        int codBarra = Integer.parseInt(request.getParameter("numCodBarra"));
        String unidadeMedida = request.getParameter("nomeUnidadeMedida");
        float precoCompra = Float.parseFloat(request.getParameter("precoCompra"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        float altura = Float.parseFloat(request.getParameter("altura"));
        float comprimento = Float.parseFloat(request.getParameter("comprimento"));
        String validade = request.getParameter("validade");
        int qtdMinima = Integer.parseInt(request.getParameter("qtdMinima"));
        int qtdAtual = Integer.parseInt(request.getParameter("qtdAtual"));
        int qtdMaxima = Integer.parseInt(request.getParameter("qtdMaxima"));
        float largura = Float.parseFloat(request.getParameter("largura"));
        int idFornecedor = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optFornecedor"));
        int idCategoria = operacao.equals("Excluir") ? 0 : Integer.parseInt(request.getParameter("optCategoria"));
        
        try{
            Fornecedor fornecedor = null;
            if(idFornecedor != 0){
                fornecedor = Fornecedor.obterFornecedor(idFornecedor);
            }
            Categoria categoria = null;
            if(idCategoria != 0){
                categoria = Categoria.obterCategoria(idCategoria);
            }
            
            Produto produto = new Produto(idProduto, nome, codInterno, codBarra,
                    unidadeMedida, precoCompra, peso, altura, comprimento, validade,
                    qtdMinima, qtdAtual, qtdMaxima, largura, fornecedor, categoria);
            if(operacao.equals("Incluir")){
                produto.gravar();
            }else{
                if (operacao.equals("Alterar")){
                    produto.alterar();
                }else{
                    if (operacao.equals("Excluir")){
                        produto.excluir();
                    }
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaProdutoController");
            view.forward(request, response);
        }
        catch(SQLException | ClassNotFoundException e){
            throw new ServletException(e);
        }
    }
    
    
}
