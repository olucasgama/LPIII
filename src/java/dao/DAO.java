/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    
    public static void fecharConexao(Connection conexao, Statement comando) 
            throws SQLException{
                    
           if(comando != null){
                comando.close();
           }
           if(conexao != null){
               conexao.close();
           }
    }
}


