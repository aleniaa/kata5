package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import static kata5.CreateNewTable.createNewTable;

public class Kata5 {

    public static void main(String[] args) {
      
        connect();
        SelectApp app = new SelectApp();
        app.selectAll();
        createNewTable();
        String percorso= "C:\\Users\\milen\\OneDrive\\Desktop\\esami e oratiche ulpgc\\ingegneria software 2\\cose mie\\Kata5\\email.txt";
        List<String> list = MailListReader.read(percorso);
        InsertarDatosTabla idt= new InsertarDatosTabla();
        
        for (String string : list) {
            idt.insert(string);
        }
        
    } 
    
    private static void connect() {
        Connection conn = null;
        try {
            // parámetros de la BD
            String url= "jdbc:sqlite:Kata5.db";
            // creamos una conexión a la BD
            conn= DriverManager.getConnection(url);
            System.out.println("Connection estableshed");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if(conn!= null) {
                    conn.close();
                    }
                } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                  }
              }
    }
}
