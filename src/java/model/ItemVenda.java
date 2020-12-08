/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemVenda;
    private int quantidade;
    private float precoUnitario;
    @ManyToOne
    private Venda venda;
    @ManyToOne
    private Produto produto;

    public ItemVenda(int quantidade, float precoUnitario,
            Venda venda, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.venda = venda;
        this.produto = produto;
    }

    public ItemVenda() {
    }

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
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
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() throws SQLException, ClassNotFoundException {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
