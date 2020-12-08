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
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenda;
    private String dataVenda;
    private float subTotal;
    private int codBarra;
    private float valorDesconto;
    private String situacao;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private FormaPagamento formaPagamento;
    @ManyToOne
    private Cliente cliente;

    public Venda(String dataVenda, float subTotal, int codBarra, 
            float valorDesconto, String situacao, Usuario usuario, 
            FormaPagamento formaPagamento, Cliente cliente) {
        this.dataVenda = dataVenda;
        this.subTotal = subTotal;
        this.codBarra = codBarra;
        this.valorDesconto = valorDesconto;
        this.situacao = situacao;
        this.usuario = usuario;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
    }

    public Venda() {
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public Usuario getUsuario() throws SQLException, ClassNotFoundException {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaPagamento getFormaPagamento() throws SQLException, ClassNotFoundException {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() throws SQLException, ClassNotFoundException {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
