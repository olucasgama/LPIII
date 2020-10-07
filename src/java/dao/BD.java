/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection
        ("jdbc:mysql://localhost/sgmc", "root", "");
        return conexao;
    }
    public static void fecharConexao(Connection conexao, Statement comando)
            throws SQLException {
        if (comando != null) {
            comando.close();
        }
        if (conexao != null) {
            conexao.close();
        }
    }
    
}
