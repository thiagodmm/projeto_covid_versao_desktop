/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thiago Machado
 */

public class Conexao {
    
  //cria uma constante com o endereçamento da base de dados no conector com mysql
  private static String URL = "jdbc:mysql://localhost:3306/appcovid19";

  //cria uma constante para determinar usuário predefinido do banco de dados (na instalação)
  private static String USUARIO= "root";

  //cria uma constante para determinar a senha do usuário
  private static String SENHA = "";

  //método que estabelece a conexão com o banco de dados
  public static Connection getConexao() throws SQLException{

    //diz que ainda não foi estabelecida conexão com o BD
    Connection c = null;

    //tenta estabelecer conexão
    try{

      c = DriverManager.getConnection(URL, USUARIO, SENHA);

    //caso a tentativa tenha sido falha, gera uma exceção   
    }catch(SQLException e){
      throw new SQLException("Erro ao conectar!",e.getMessage());
    }
    
    return c;
    
  }    
    
}
