/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class Produto {

    private int idProduto;
    private String nome;
    private int codInterno;
    private int codBarra;
    private String unidadeMedida;
    private float precoCompra;
    private float peso;
    private float altura;
    private float comprimento;
    private String validade;
    private int qtdMinima;
    private int qtdAtual;
    private int qtdMaxima;
    private float largura;
    private Fornecedor fornecedor;
    private Categoria categoria;
    private int idFornecedor;
    private int idCategoria;

    public Produto(int idProduto, String nome, int codInterno, int codBarra, 
            String unidadeMedida, float precoCompra, float peso, float altura, 
            float comprimento, String validade, int qtdMinima, int qtdAtual, 
            int qtdMaxima, float largura, Fornecedor fornecedor, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.codInterno = codInterno;
        this.codBarra = codBarra;
        this.unidadeMedida = unidadeMedida;
        this.precoCompra = precoCompra;
        this.peso = peso;
        this.altura = altura;
        this.comprimento = comprimento;
        this.validade = validade;
        this.qtdMinima = qtdMinima;
        this.qtdAtual = qtdAtual;
        this.qtdMaxima = qtdMaxima;
        this.largura = largura;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(int codInterno) {
        this.codInterno = codInterno;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public Fornecedor getFornecedor() throws SQLException, ClassNotFoundException {
        if ((this.idFornecedor != 0)&& (this.fornecedor == null)){
            this.fornecedor = Fornecedor.obterFornecedor(this.idFornecedor);
        }
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Categoria getCategoria() throws SQLException, ClassNotFoundException {
        if ((this.idCategoria != 0) && (this.categoria == null)){
            this.categoria = Categoria.obterCategoria(this.idCategoria);
        }
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public static Produto obterProduto (int idProduto) throws SQLException, ClassNotFoundException{
        return ProdutoDAO.obterProduto(idProduto);
    }
    
    public static List<Produto> obterProdutos() throws ClassNotFoundException, SQLException{
        return ProdutoDAO.obterProdutos();
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        ProdutoDAO.gravar(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        ProdutoDAO.alterar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException {
        ProdutoDAO.excluir(this);
    }
}
