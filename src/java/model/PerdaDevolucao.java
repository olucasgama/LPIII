/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PerdaDevolucaoDAO;
import java.sql.SQLException;
import java.util.List;

public class PerdaDevolucao {
    
    private int idPerdaDevolucao;
    private String tipo;
    private Produto produto;
    private Venda venda;
    private int idProduto;
    private int idVenda;

    public PerdaDevolucao(int idPerdaDevolucao, String tipo, Produto produto, Venda venda) {
        this.idPerdaDevolucao = idPerdaDevolucao;
        this.tipo = tipo;
        this.produto = produto;
        this.venda = venda;
    }

    public int getIdPerdaDevolucao() {
        return idPerdaDevolucao;
    }

    public void setIdPerdaDevolucao(int idPerdaDevolucao) {
        this.idPerdaDevolucao = idPerdaDevolucao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Produto getProduto() throws SQLException, ClassNotFoundException {
        if ((this.idProduto != 0) && (this.produto == null)){
            this.produto = Produto.obterProduto(this.idProduto);
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() throws SQLException, ClassNotFoundException {
        if ((this.idVenda != 0) && (this.venda== null)){
            this.venda = Venda.obterVenda(this.idVenda);
        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public static PerdaDevolucao obterPerdaDevolucao (int idPerdaDevolucao) throws SQLException, ClassNotFoundException{
        return PerdaDevolucaoDAO.obterPerdaDevolucao(idPerdaDevolucao);
    }
    
    public static List<PerdaDevolucao> obterPerdaDevolucoes() throws ClassNotFoundException, SQLException{
        return PerdaDevolucaoDAO.obterPerdaDevolucoes();
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        PerdaDevolucaoDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        PerdaDevolucaoDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        PerdaDevolucaoDAO.alterar(this);
    }
}
