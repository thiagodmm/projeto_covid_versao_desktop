/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.protocol.Resultset;

/**
 *
 * @author Jaderson Maciel
 */
public class Adm {
    
    private int id;
    private String senha, nomeAcesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeAcesso() {
        return nomeAcesso;
    }

    public void setNomeAcesso(String nomeAcesso) {
        this.nomeAcesso = nomeAcesso;
    }

    @Override
    public String toString() {
        return "Adm{" + "id=" + id + ", senha=" + senha + ", nomeAcesso=" + nomeAcesso + '}';
    }

    public Resultset autenticarAdmin(Adm admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
  
}
