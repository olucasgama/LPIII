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

    public OrdemServico(String dataPedido, String situacao,
            String descricao, int numOS, Fornecedor fornecedor) {
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
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
