/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

public class Cliente {

    private int idCliente;
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
    private Endereco endereco;
    private int idEndereco;

    public Cliente(int idCliente, String cnpj, String razaoSocial, String inscricaoEstadual, String nome, String cpf, String rg, String telefone, String celular, String email, String dataNascimento, String estadoCivil, String sexo, int numero, String complemento, Endereco endereco) {
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
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
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
   
    public Endereco getEndereco() throws ClassNotFoundException, SQLException{
        if((this.idEndereco !=0) && (this.endereco == null)){
            this.endereco = Endereco.obterEndereco(this.idEndereco);
        }
        return endereco;
    }
    
    public static Cliente obterCliente (int idCliente) throws SQLException, ClassNotFoundException{
        return ClienteDAO.obterCliente(idCliente);
    }
    
    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException{
        return ClienteDAO.obterClientes();
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
    
    public void gravar() throws SQLException, ClassNotFoundException {
        ClienteDAO.gravar(this);
    }
    
    public void excluir() throws ClassNotFoundException, SQLException{
        ClienteDAO.excluir(this);
    }
    public void alterar() throws ClassNotFoundException, SQLException{
        ClienteDAO.alterar(this);
    }
}
