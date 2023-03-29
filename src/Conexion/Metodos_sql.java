
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

public class Metodos_sql
{
    /*
public void Mostrar()
{
    
    try 
    {
            ConexionDB conn = new ConexionDB();
            
            // Crear un modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.Usuario");
            model.addColumn("Usuario");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Telefono");
            model.addColumn("Gmail");
            model.addColumn("Clave");
                 
            // Consultar la base de datos y obtener los datos
            Statement stmt = conn.PreparedStatement();
            ResultSet rs = stmt.executeQuery("SELECT ID_Usuario,Usuario , Nombre, Apellido, Telefono, Gmail, Clave FROM Usuario");

            // Agregar los datos al modelo de la tabla
            while (rs.next()) 
            {
                Object[] fila = new Object[7];
                fila[0] = rs.getInt("ID_Usuario");
                fila[1] = rs.getInt("Usuario");
                fila[2] = rs.getString("Nombre");
                fila[3] = rs.getString("Apellido");
                fila[4] = rs.getString("Telefono");
                fila[5] = rs.getString("Gmail");
                fila[6] = rs.getString("Clave");
                
                model.addRow(fila);
            }
    tblRegistro.setModel(model);  
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    
    
    
}*/
}