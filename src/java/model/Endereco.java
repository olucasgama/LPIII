/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;
    private String logradouro;
    private String cidade;
    private String bairro;
    private String uf;
    private String cep;

    public Endereco() {
    }

    public Endereco(/*Integer idEndereco,*/ String logradouro, String cidade, String bairro, String uf, String cep) {
        /*this.idEndereco = idEndereco;*/
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.cep = cep;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }    
    
    /*
    public static Endereco obterEndereco (int idEndereco) throws SQLException, ClassNotFoundException{
        return EnderecoDAO.getInstancia().findEndereco(idEndereco);
}
    
    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException{
        return EnderecoDAO.getInstancia().findAllEnderecos();
    }
    
    public void gravar() throws SQLException, ClassNotFoundException {
        EnderecoDAO.getInstancia().save(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        EnderecoDAO.getInstancia().remove(idEndereco);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        EnderecoDAO.getInstancia().save(this);
    }*/
}
