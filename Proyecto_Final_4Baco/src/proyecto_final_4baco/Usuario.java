package proyecto_final_4baco;

public class Usuario {

    String Nombre_Usuarios, Contra;
    String Nombre, Confirmar_Contra;

    public Usuario(String Nombre_Usuarios, String Contra, String Confirmar_Contra) {
        this.Nombre_Usuarios = Nombre_Usuarios;
        this.Contra = Contra;
        //    this.Nombre = Nombre;
        this.Confirmar_Contra = Confirmar_Contra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getNombre_Usuarios() {
        return Nombre_Usuarios;
    }

    public void setNombre_Usuarios(String Nombre_Usuarios) {
        this.Nombre_Usuarios = Nombre_Usuarios;
    }

    public String getConfirmar_Contra() {
        return Confirmar_Contra;
    }

    public void setConfirmar_Contra(String Confirmar_Contra) {
        this.Confirmar_Contra = Confirmar_Contra;
    }

}
