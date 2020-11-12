/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import javax.persistence.Id;
import java.sql.SQLException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import dao.EnderecoDAO;
import java.util.List;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String celular;
    private String email;
    private String dataNascimento;
    private String estadoCivil;
    private String sexo;
    private int numero;
    private String complemento;
    @ManyToOne
    private Endereco endereco;
    private int idEndereco;

    public Cliente(Integer idCliente, String cnpj, String razaoSocial, String inscricaoEstadual, String nome, String cpf, String rg, String telefone, String celular, String email, String dataNascimento, String estadoCivil, String sexo, int numero, String complemento, Endereco endereco) {
        this.idCliente = idCliente;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public Cliente() {
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() throws ClassNotFoundException, SQLException {
        if ((this.idEndereco != 0) && (this.endereco == null)) {
            this.endereco = EnderecoDAO.getInstancia().findEndereco(idEndereco);
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
    
    public static Cliente obterCliente (int idCliente) throws SQLException, ClassNotFoundException{
        return ClienteDAO.getInstancia().findCliente(idCliente);
    }
    
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException{
        return ClienteDAO.getInstancia().findAllClientes();
    }

    public void excluir() throws ClassNotFoundException, SQLException{
        ClienteDAO.getInstancia().remove(idCliente);
    }
    public void alterar() throws ClassNotFoundException, SQLException{
        ClienteDAO.getInstancia().save(this);
    }
    
    public void gravar() throws ClassNotFoundException, SQLException{
        ClienteDAO.getInstancia().save(this);
    }
}
