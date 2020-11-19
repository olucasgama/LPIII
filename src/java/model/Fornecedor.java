/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FornecedorDAO;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFornecedor;
    private String nomeFantasia;
    private String cnpj;
    private String nomeRepresentante;
    private String email;
    private String telefone;
    private int numero;
    private String complemento;
    @ManyToOne
    private Endereco endereco;
    private int idEndereco;

    public Fornecedor(Integer idFornecedor, String nomeFantasia, String cnpj, String nomeRepresentante, String email, String telefone, int numero, String complemento, Endereco endereco) {
        this.idFornecedor = idFornecedor;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
        this.email = email;
        this.telefone = telefone;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public Fornecedor() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() throws SQLException, ClassNotFoundException {
        if((this.idEndereco !=0) && (this.endereco == null)){
            this.endereco = Endereco.obterEndereco(this.idEndereco);
        }
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    
   public static Fornecedor obterFornecedor(int idFornecedor) throws SQLException, ClassNotFoundException {
        return FornecedorDAO.getInstancia().findFornecedor(idFornecedor);
    }

    public static List<Fornecedor> obterFornecedores() throws ClassNotFoundException, SQLException {
        return FornecedorDAO.getInstancia().findAllFornecedors();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FornecedorDAO.getInstancia().save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        FornecedorDAO.getInstancia().remove(idFornecedor);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        FornecedorDAO.getInstancia().save(this);
    }
}
