/*
A classe DAOFactory é uma fábrica de DAO, ou seja, ela fabrica objetos 
de UsuarioDAO e retorna para qualquer classe que solicitar.

Quando ela retorna um objeto da classe UsuarioDAO ela está enviando 
o objeto com os métodos que tem dentro dele, nesse caso o método cadastrarUsuario.

Em suma, a classe Factory apenas cria um objeto da classe UsuarioDAO 
e retorna o mesmo para a classe que solicitar.
 */
package dao;

/**
 *
 * @author Thiago Machado
 */

public class DAOFactory {
    
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public static UsuarioDAO getUsuarioDAO() {
    return  usuarioDAO;
    }
    
}