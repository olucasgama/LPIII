/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FormaPagamentoDAO;
import java.sql.SQLException;
import java.util.List;

public class FormaPagamento {
    private int idFormaPgto;
    private String nome;
    private int conta;
    private int agencia;
    private String nomeBanco;
    private String tipoConta;
    private int numMaxParcelas;
    private int intervaloParcelas;
    private double taxaBanco;
    private double taxaOperadora;
    private double multaAtraso;
    private String situacaoConfirmacao;

    public FormaPagamento(int idFormaPgto, String nome, int conta, int agencia, String nomeBanco, String tipoConta, int numMaxParcelas, int intervaloParcelas, double taxaBanco, double taxaOperadora, double multaAtraso, String situacaoConfirmacao) {
        this.idFormaPgto = idFormaPgto;
        this.nome = nome;
        this.conta = conta;
        this.agencia = agencia;
        this.nomeBanco = nomeBanco;
        this.tipoConta = tipoConta;
        this.numMaxParcelas = numMaxParcelas;
        this.intervaloParcelas = intervaloParcelas;
        this.taxaBanco = taxaBanco;
        this.taxaOperadora = taxaOperadora;
        this.multaAtraso = multaAtraso;
        this.situacaoConfirmacao = situacaoConfirmacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdFormaPgto() {
        return idFormaPgto;
    }

    public void setIdFormaPgto(int idFormaPgto) {
        this.idFormaPgto = idFormaPgto;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getNumMaxParcelas() {
        return numMaxParcelas;
    }

    public void setNumMaxParcelas(int numMaxParcelas) {
        this.numMaxParcelas = numMaxParcelas;
    }

    public int getIntervaloParcelas() {
        return intervaloParcelas;
    }

    public void setIntervaloParcelas(int intervaloParcelas) {
        this.intervaloParcelas = intervaloParcelas;
    }

    public double getTaxaBanco() {
        return taxaBanco;
    }

    public void setTaxaBanco(double taxaBanco) {
        this.taxaBanco = taxaBanco;
    }

    public double getTaxaOperadora() {
        return taxaOperadora;
    }

    public void setTaxaOperadora(double taxaOperadora) {
        this.taxaOperadora = taxaOperadora;
    }

    public double getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public String getSituacaoConfirmacao() {
        return situacaoConfirmacao;
    }

    public void setSituacaoConfirmacao(String situacaoConfirmacao) {
        this.situacaoConfirmacao = situacaoConfirmacao;
    }

    
    public static FormaPagamento obterFormaPagamento (int idFormaPgto) throws SQLException, ClassNotFoundException{
        return FormaPagamentoDAO.obterFormaPagamento(idFormaPgto);
    }
    
    public static List<FormaPagamento> obterFormasPagamentos() throws ClassNotFoundException, SQLException{
        return FormaPagamentoDAO.obterFormasPagamentos();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        FormaPagamentoDAO.gravar(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        FormaPagamentoDAO.alterar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        FormaPagamentoDAO.excluir(this);
    }
}
