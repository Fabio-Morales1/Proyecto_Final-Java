package proyecto_final;

import javax.swing.JFrame;

public class Usuario {

    String NombreUsuario, ContraUsuario;

    public Usuario(String NombreUsuario, String ContraUsuario) {

        this.NombreUsuario = NombreUsuario;

        this.ContraUsuario = ContraUsuario;

    }
    
    
    

    public String getNombre() {

        return this.NombreUsuario;

    }

    public String getContra() {

        return this.ContraUsuario;

    }
}


