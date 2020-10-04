package BaseDeDatos;

import Modelo.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccesoBaseDatos {
    
    private String CONN = "jdbc:sqlserver://ANGEL-PC:50876;databaseName=LCIV_Servlets";
    private String USER = "sa";
    private String PASS = "tekken5";

    public AccesoBaseDatos() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Servicio> obtenerServicios() {
    
        ArrayList<Servicio> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
        
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Servicios");
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                double edad = rs.getDouble("costo");
                
                Servicio s = new Servicio(id, tipo, descripcion, edad);
                lista.add(s);
            }
            
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
//    public void agregar(Persona nueva) {
//    
//        try {
//
//            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
//        
//            PreparedStatement st = conn.prepareStatement("insert into Personas(Nombre, Apellido, Edad, IdEstadoCivil) values(?,?,?,?)");
//            st.setString(1,nueva.getNombre());
//            st.setString(2,nueva.getApellido());
//            st.setInt(3,nueva.getEdad());
//            st.setInt(4,nueva.getEstadoCivil().getId());
//            
//            st.executeUpdate();
//            st.close();
//
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(GestorDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
//    
    
//    

}
