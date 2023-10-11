package proyecto_final_4baco;

public class Clientes {

    String Nit, Nombre;
    String Edad;
    String Genero;

    public Clientes(String Nit, String Nombre, String Edad, String Genero) {
        this.Nit = Nit;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Genero = Genero;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    
}
