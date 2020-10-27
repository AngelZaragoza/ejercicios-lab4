package BaseDeDatos;

import Modelo.Servicio;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Servicios");

            while (rs.next()) {
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
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }
        return lista;
    }

    public void agregarServicio(Servicio nuevo) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            String sql = "INSERT INTO Servicios(tipo, descripcion, costo) values(?,?,?,)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nuevo.getTipo());
            st.setString(2, nuevo.getDescripcion());
            st.setDouble(3, nuevo.getCosto());

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(AccesoBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 0);
        }

    }

    public Throwable msjError(String msj) {
        //A implementar...
        return null;
    }

}
