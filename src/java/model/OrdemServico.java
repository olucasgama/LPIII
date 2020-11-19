/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.OrdemServicoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrdemServico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdemSrv;
    private String dataPedido;
    private String situacao;
    private String descricao;
    private int numOS;
    @ManyToOne
    private Fornecedor fornecedor;
    private int idFornecedor;

    public OrdemServico(Integer idOrdemSrv, String dataPedido, String situacao, 
            String descricao, int numOS, Fornecedor fornecedor) {
        this.idOrdemSrv = idOrdemSrv;
        this.dataPedido = dataPedido;
        this.situacao = situacao;
        this.descricao = descricao;
        this.numOS = numOS;
        this.fornecedor = fornecedor;
    }

    public OrdemServico() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumOS() {
        return numOS;
    }

    public void setNumOS(int numOS) {
        this.numOS = numOS;
    }

    
    public Integer getIdOrdemSrv() {
        return idOrdemSrv;
    }

    public void setIdOrdemSrv(Integer idOrdemSrv) {
        this.idOrdemSrv = idOrdemSrv;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public static OrdemServico obterOrdemServico (int idOrdemServico) throws SQLException, ClassNotFoundException{
        return OrdemServicoDAO.getInstancia().findOrdemServico(idOrdemServico);
    }
    
    public static List<OrdemServico> obterOrdemServicos() throws ClassNotFoundException, SQLException{
        return OrdemServicoDAO.getInstancia().findAllOrdemServicos();
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        OrdemServicoDAO.getInstancia().save(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException{
        OrdemServicoDAO.getInstancia().save(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        OrdemServicoDAO.getInstancia().remove(idOrdemSrv);
    }
}
