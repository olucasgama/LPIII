/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ColaboradorDAO;
import java.sql.SQLException;
import java.util.List;

public class Colaborador extends Usuario {

    private int idColaborador;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private String telefone;
    private String celular;
    private String estadoCivil;
    private String sexo;
    private int numero;
    private String complemento;
    private Endereco endereco;
    private int idEndereco;

    public Colaborador(int idColaborador, String cpf, String rg, 
            String dataNascimento, String telefone, String celular, 
            String estadoCivil, String sexo, int numero, String complemento, 
            int idUsuario, String nome, String email, String senha, 
            Endereco endereco) {
        super(idUsuario, nome, email, senha);
        this.idColaborador = idColaborador;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.celular = celular;
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
    
    

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public static Colaborador obterColaborador (int idColaborador) throws SQLException, ClassNotFoundException{
        return ColaboradorDAO.obterColaborador(idColaborador);
    }
    
    public static List<Colaborador> obterColaboradores() throws ClassNotFoundException, SQLException{
        return ColaboradorDAO.obterColaboradores();
    }
    
 
    @Override
    public void gravar() throws SQLException, ClassNotFoundException {
        ColaboradorDAO.gravar(this, this);
    }
    
    @Override
    public void excluir() throws ClassNotFoundException, SQLException{
        ColaboradorDAO.excluir(this);
    }
    
    @Override
    public void alterar() throws ClassNotFoundException, SQLException{
        ColaboradorDAO.alterar(this);
    }
}
