/*
Essa classe é responsável pela exibição dos métodos para as interfaces(Janelas, GUI's).
 */
package servicos;

import dao.DAOFactory;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuarioVO;

/**
* @author Thiago
**/

public class UsuarioServicos {
    
    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException{
        UsuarioDAO uDAO = dao.DAOFactory.getUsuarioDAO();
        uDAO.cadastrarUsuario(uVO);
    }
    
    
    public ArrayList<UsuarioVO> buscar() throws SQLException{
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        return uDAO.buscar();
    }
    
    
    
    public void deletarUsuario (long idUsuario) throws SQLException{
	UsuarioDAO uDAO = dao.DAOFactory.getUsuarioDAO();
	uDAO.deletarUsuario(idUsuario);
    }
    
    
    
    public ArrayList<UsuarioVO> filtrar(String query) throws SQLException{
    UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
    return uDAO.filtrar(query);
    }
    
   
    
    public void alterarUsuario(UsuarioVO uVo) throws SQLException{
	UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
	uDAO.alterarUsuario(uVo);
    }
    

    
}
