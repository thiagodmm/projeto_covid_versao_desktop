/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.UsuarioVO;
import persistencia.Conexao;

/**
 *
 * @author Thiago Machado
 */

public class UsuarioDAO {
    
    // Método que insere um novo usuário no Banco de Dados
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException{

	//Busca conexão com o Banco de Dados
	Connection con = Conexao.getConexao();
        
        // Cria um objeto "stat" responsável por enviar os comandos de banco do java para serem executados dentro do BD	
        Statement stat = con.createStatement();
        
        try{
	String sql; // String que receberá o comando SQL
        
        sql = "insert into usuario(userid,nome,email,datanasc,peso,altura,alergias,doencas)"
                +"values(null,'"+uVO.getNome()+"','"+uVO.getEmail()+"',"+uVO.getDataNasc()+","+uVO.getPeso()+","+uVO.getAltura()+",'"+uVO.getAlergias()+"','"+uVO.getDoencas()+"')";
                
        // Executa o comando que guardamos dentro da String sql
        stat.execute(sql);


}catch(SQLException e){
	throw new SQLException("Erro ao criar novo usuário!");
}finally {        
        stat.close();
	con.close();	
}

}   
    
    
    
    
    
    public ArrayList<UsuarioVO> buscar() throws SQLException{
	Connection con = Conexao.getConexao();
	Statement stat = con.createStatement();
      
        try {
		String sql;
		sql = "select * from usuario";

		ResultSet rs= stat.executeQuery(sql);
		ArrayList<UsuarioVO> user = new ArrayList<>();
                
                while(rs.next()){
			UsuarioVO u = new UsuarioVO();
                        
                        u.setIdUsuario(rs.getLong("userid"));
                        u.setNome(rs.getString("nome"));
                        u.setEmail(rs.getString("email"));
                        u.setDataNasc(rs.getInt("datanasc"));
                        u.setPeso(rs.getDouble("peso"));
                        u.setAltura(rs.getDouble("altura"));
                        u.setAlergias(rs.getString("alergias"));
                        u.setDoencas(rs.getString("doencas"));
                        			
			user.add(u);
                }
                return user;
		
	}catch(SQLException e){
            throw new SQLException("Erro ao buscar dados no banco"+e.getMessage());

	}finally{
            stat.close();
            con.close();
	}                    
}    
    
    
    
    
        public void deletarUsuario (long idUsuario) throws SQLException{
	
        Connection con = Conexao.getConexao();
        Statement sta = con.createStatement();
            
        try{
	String sql;
	sql = "delete from usuario where userid = "+idUsuario;
	sta.execute(sql);
	} catch ( SQLException e ){
            throw new SQLException("Erro ao excluir dados no banco "+e.getMessage());
	}  finally {
	sta.close();
	con.close();
	}
    }
        
        
     public ArrayList<UsuarioVO> filtrar(String query) throws SQLException{
	Connection con = Conexao.getConexao();
	Statement sta = con.createStatement();

	try{
	String sql;
	sql = "select * from usuario "+query;
	ResultSet rs= sta.executeQuery(sql);
	ArrayList<UsuarioVO> prod = new ArrayList<>();
        
        while(rs.next()){
			UsuarioVO u = new UsuarioVO();
			u.setIdUsuario(rs.getLong("userid"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setDataNasc(rs.getInt("datanasc"));
                        u.setPeso(rs.getDouble("peso"));
                        u.setAltura(rs.getDouble("altura"));
                        u.setAlergias(rs.getString("alergias"));
                        u.setDoencas(rs.getString("doencas"));
                        
			prod.add(u);
                }
                return prod;
	
	}catch(SQLException e){
	throw new SQLException("Erro ao pesquisar dados no banco"+e.getMessage());
	}finally{
	sta.close();
	con.close();
	}

}    
    

     public void alterarUsuario(UsuarioVO uVo) throws SQLException{
	Connection con = Conexao.getConexao();
	Statement sta = con.createStatement();
	try{
		String sql;
                // Atualiza os dados, pegando da classe (get) aquilo que já foi adicionado anteriormente e set para o comando update
		
                sql= "update usuario set nome = '"+uVo.getNome()+"',email = '"+uVo.getEmail()+"',datanasc = "+uVo.getDataNasc()+",peso = "+uVo.getPeso()+",altura = "+uVo.getAltura()+",alergias = '"+uVo.getAlergias()+"',doencas = '"+uVo.getDoencas()+"' where userid = "+uVo.getIdUsuario();
                  
		sta.executeUpdate(sql);
                
	}catch(SQLException e){
		throw new SQLException("Erro ao atualizar dados no banco"+e.getMessage());
	}finally{
		sta.close();
		con.close();
	}


}
     
     
     
    
}


