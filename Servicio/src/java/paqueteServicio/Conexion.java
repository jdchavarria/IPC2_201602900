
package paqueteServicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    protected static Connection cx;
    private Connection connection = null;
    private Statement s = null;
    
    public static Connection conectar(){
        if(cx!=null){
            return cx;
        }
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgrsql://localhost:5432/Prueba";
        String user ="postgres";
        String pass = "electronica";
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(url, user, pass);
            
        }catch(Exception e ){
            e.printStackTrace();
        }
        return cx;
    }
    public static void Desconectar(){
        if(cx==null){
            return;
        }
        try{
            cx.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void GuardarEmpleado(String name){
        conectar();
        try {   
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO Persona (nombre) VALUES ('" + name + "')");
            if(z==1){
                System.out.println("Se agrego el registro");
            }
            else{
                System.out.println("no se registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
