/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.VendaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private int idUsuario;
    @ManyToOne
    private FormaPagamento formaPagamento;
    private int idFormaPgto;
    @ManyToOne
    private Cliente cliente;   
    private int idCliente;

    public Venda(Integer idVenda, String dataVenda, float subTotal, int codBarra, 
            float valorDesconto, String situacao, Usuario usuario, 
            FormaPagamento formaPagamento, Cliente cliente) {
        this.idVenda = idVenda;
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
        if ((this.idUsuario != 0) && (this.usuario == null)){
            this.usuario = Usuario.obterUsuario(this.idUsuario);
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaPagamento getFormaPagamento() throws SQLException, ClassNotFoundException {
        if ((this.idFormaPgto != 0) && (this.formaPagamento == null)){
            this.formaPagamento = FormaPagamento.obterFormaPagamento(this.idFormaPgto);
        }
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() throws SQLException, ClassNotFoundException {
        if ((this.idCliente != 0) && (this.cliente == null)){
            this.cliente = Cliente.obterCliente(this.idCliente);
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFormaPgto() {
        return idFormaPgto;
    }

    public void setIdFormaPgto(int idFormaPgto) {
        this.idFormaPgto = idFormaPgto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public static Venda obterVenda (int idVenda) throws SQLException, ClassNotFoundException{
        return VendaDAO.getInstancia().findVenda(idVenda);
    }
    
    public static ArrayList<Venda> obterVendas() throws ClassNotFoundException, SQLException{
        return (ArrayList<Venda>) VendaDAO.getInstancia().findAllVendas();
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        VendaDAO.getInstancia().save(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        VendaDAO.getInstancia().save(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        VendaDAO.getInstancia().remove(idVenda);
    }
}
