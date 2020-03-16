/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ItensOrdemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemOrdem {

    private int idItemOrdem;
    private int quantidade;
    private Produto produto;
    private int idProduto;
    private OrdemServico ordemServico;
    private int idOrdemSrv;

    public ItemOrdem(int idItensOrdem, int quantidade, Produto produto,
            OrdemServico ordemServico) {
        this.idItemOrdem = idItensOrdem;
        this.quantidade = quantidade;
        this.produto = produto;
        this.ordemServico = ordemServico;
    }

    public int getIdItensOrdem() {
        return idItemOrdem;
    }

    public void setIdItensOrdem(int idItemOrdem) {
        this.idItemOrdem = idItemOrdem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public OrdemServico getOrdemServico() throws SQLException, ClassNotFoundException {
        if ((this.idOrdemSrv != 0) && (this.ordemServico == null)) {
            this.ordemServico = OrdemServico.obterOrdemServico(this.idOrdemSrv);
        }
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public int getIdOrdemSrv() {
        return idOrdemSrv;
    }

    public void setIdOrdemSrv(int idOrdemSrv) {
        this.idOrdemSrv = idOrdemSrv;
    }

    public static ArrayList<ItemOrdem> obterItensOrdem(int idItensOrdem) throws SQLException, ClassNotFoundException {
        return ItensOrdemDAO.obterItensOrdem(idItensOrdem);
    }

    public static ArrayList<ItemOrdem> obterItensOrdens() throws ClassNotFoundException, SQLException {
        return ItensOrdemDAO.obterItensOrdens();
    }
    
    public static ItemOrdem obterItemOrdem(int idItensOrdem) throws ClassNotFoundException, SQLException {
        return ItensOrdemDAO.obterItemOrdem(idItensOrdem);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ItensOrdemDAO.gravar(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        ItensOrdemDAO.alterar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        ItensOrdemDAO.excluir(this);
    }
}
