
package DTO;

/**
 *
 * @author Angel
 */
public class DTOListaLibros {
    private String nombreLibro;
    private String nombreAutor;
    private String nacionalidadAutor;

    public DTOListaLibros(String nombreLibro, String nombreAutor, String nacionalidadAutor) {
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.nacionalidadAutor = nacionalidadAutor;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getNacionalidadAutor() {
        return nacionalidadAutor;
    }
    
    
}
