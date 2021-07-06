/*
A classe ServicosFactory apenas cria um objeto da classe ProdutoServicos 
e retorna o mesmo para a classe que solicitar, geralmente uma classe de interface.
 */
package servicos;

/**
 *
 * @author Thiago Machado
 */

public class ServicosFactory {
    
    // Cria uma instância estática para que a mesma nunca seja modificada ou receba interferências
    private static UsuarioServicos usuarioServicos = new UsuarioServicos();

    public static UsuarioServicos getUsuarioServicos(){
    return usuarioServicos;
}

    
}
