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
public class ItemOrdem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemOrdem;
    private int quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private OrdemServico ordemServico;

    public ItemOrdem(int quantidade, Produto produto,
            OrdemServico ordemServico) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.ordemServico = ordemServico;
    }

    public ItemOrdem() {
    }

    public Integer getIdItensOrdem() {
        return idItemOrdem;
    }

    public void setIdItensOrdem(Integer idItemOrdem) {
        this.idItemOrdem = idItemOrdem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() throws SQLException, ClassNotFoundException {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public OrdemServico getOrdemServico() throws SQLException, ClassNotFoundException {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
}
