/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ItensVendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemVenda;
    private int quantidade;
    private float precoUnitario;
    private Venda venda;
    private int idVenda;
    private Produto produto;
    private int idProduto;

    public ItemVenda(Integer idItemVenda, int quantidade, float precoUnitario,
            Venda venda, Produto produto) {
        this.idItemVenda = idItemVenda;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.venda = venda;
        this.produto = produto;
    }

    public Integer getIdItensVenda() {
        return idItemVenda;
    }

    public void setIdItensVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Venda getVenda() throws SQLException, ClassNotFoundException {
        if ((this.idVenda != 0) && (this.venda == null)) {
            this.venda = Venda.obterVenda(this.idVenda);
        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Produto getProduto() throws SQLException, ClassNotFoundException {
        if ((this.idProduto != 0) && (this.produto == null)) {
            this.produto = Produto.obterProduto(this.idProduto);
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public static List<ItemVenda> obterItensVenda(int idVenda) throws SQLException, ClassNotFoundException {
        return ItensVendaDAO.getInstancia().findAllItensVenda();
    }

    public static List<ItemVenda> obterItensVendas() throws ClassNotFoundException, SQLException {
        return ItensVendaDAO.getInstancia().findAllItensVenda();
    }

//    public static ItemVenda obterItemVenda(int idItensVenda) throws ClassNotFoundException, SQLException {
//        return ItensVendaDAO.getInstancia().findItemVenda(idItemVenda);
//    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ItensVendaDAO.getInstancia().save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ItensVendaDAO.getInstancia().remove(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ItensVendaDAO.getInstancia().save(this);
    }
}
