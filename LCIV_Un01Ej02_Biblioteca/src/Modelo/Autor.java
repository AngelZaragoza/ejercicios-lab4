package Modelo;

/**
 *
 * @author Angel
 */
public class Autor {
    private int idAutor;
    private String nombre;
    private int dni;
    private Pais nacionalidad;

    //CONSTRUCTORES
    public Autor() {
    }
        
    public Autor(int idAutor, String nombre, int dni, Pais nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
    }
    
    //GETTERS Y SETTERS

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
