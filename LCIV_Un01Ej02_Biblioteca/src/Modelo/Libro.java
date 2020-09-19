package Modelo;

/**
 *
 * @author Angel
 */
public class Libro {
    private int codigo;
    private String descripcion;
    private TipoPrestamo tipoPrestamo;
    private Autor autor;

    //CONSTRUCTOR
    public Libro(int codigo, String descripcion, TipoPrestamo tipoPrestamo, Autor autor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoPrestamo = tipoPrestamo;
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPrestamo getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(TipoPrestamo tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\"" + descripcion + "\" Autor: " + autor;
    }
    
    
}
