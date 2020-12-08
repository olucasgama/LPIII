/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.PerdaDevolucaoDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PerdaDevolucao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerdaDevolucao;
    private String tipo;
    @ManyToOne
    private Produto produto;
    //private int idProduto;
    @ManyToOne
    private Venda venda;
    //private int idVenda;

    public PerdaDevolucao(/*Integer idPerdaDevolucao,*/ String tipo, Produto produto, Venda venda) {
        //this.idPerdaDevolucao = idPerdaDevolucao;
        this.tipo = tipo;
        this.produto = produto;
        this.venda = venda;
    }

    public PerdaDevolucao() {
    }

    public Integer getIdPerdaDevolucao() {
        return idPerdaDevolucao;
    }

    public void setIdPerdaDevolucao(Integer idPerdaDevolucao) {
        this.idPerdaDevolucao = idPerdaDevolucao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Produto getProduto() throws SQLException, ClassNotFoundException {
//        if ((this.idProduto != 0) && (this.produto == null)){
//            //this.produto = Produto.obterProduto(this.idProduto);
//            this.produto = ProdutoDAO.getInstancia().findProduto(idProduto);
//        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() throws SQLException, ClassNotFoundException {
//        if ((this.idVenda != 0) && (this.venda== null)){
//            //this.venda = Venda.obterVenda(this.idVenda);
//            this.venda = VendaDAO.getInstancia().findVenda(idVenda);
//        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

//    public int getIdProduto() {
//        return idProduto;
//    }
//
//    public void setIdProduto(int idProduto) {
//        this.idProduto = idProduto;
//    }
//
//    public int getIdVenda() {
//        return idVenda;
//    }
//
//    public void setIdVenda(int idVenda) {
//        this.idVenda = idVenda;
//    }
//
//    public static PerdaDevolucao obterPerdaDevolucao (int idPerdaDevolucao) throws SQLException, ClassNotFoundException{
//        return PerdaDevolucaoDAO.getInstancia().findPerdaDevolucao(idPerdaDevolucao);
//    }
//    
//    public static List<PerdaDevolucao> obterPerdaDevolucoes() throws ClassNotFoundException, SQLException{
//        return PerdaDevolucaoDAO.getInstancia().findAllPerdaDevolucoes();
//    }
//    
//    public void gravar() throws ClassNotFoundException, SQLException{
//        PerdaDevolucaoDAO.getInstancia().save(this);
//    }
//    
//    public void excluir() throws ClassNotFoundException, SQLException {
//        PerdaDevolucaoDAO.getInstancia().remove(idPerdaDevolucao);
//    }
//    
//    public void alterar() throws ClassNotFoundException, SQLException{
//        PerdaDevolucaoDAO.getInstancia().save(this);
//    }
}
