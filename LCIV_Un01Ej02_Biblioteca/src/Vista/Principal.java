package Vista;

import Controlador.ConexionJDBC;

/**
 *
 * @author Angel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionJDBC conn = new ConexionJDBC();
        conn.excelente();
        
    }
    
}
