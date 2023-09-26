package proyecto_final;

import javax.swing.JFrame;

public class Usuario {

    String NombreUsuario, ContraUsuario,Nuevo_Nombre,ConfirmarContra;

    public Usuario(String NombreUsuario, String ContraUsuario) {

        this.NombreUsuario = NombreUsuario;
        this.ContraUsuario = ContraUsuario;

    }

    public Usuario(String NombreUsuario, String ContraUsuario, String Nuevo_Nombre, String ConfirmarContra) {
        
        this.NombreUsuario = NombreUsuario;
        this.ContraUsuario = ContraUsuario;
        this.Nuevo_Nombre = Nuevo_Nombre;
        this.ConfirmarContra = ConfirmarContra;
        
    }
    
    
    
    

    public String getNombre_Usuario() {

        return this.NombreUsuario;

    }

    public String getContra() {

        return this.ContraUsuario;

    }
    
    public String getNew_Nombre() {

        return this.Nuevo_Nombre;

    }
    
    public String getConfirContra() {

        return this.ConfirmarContra;

    }
}


