package Conexion;

import Interfase.Resultados;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ConexionDB  {
    
    public static String conexionDB="jdbc:sqlite:C:/Users/dell/Documents/DB/Formulario.s3db";
     
    
    public Connection openConnection() throws ClassNotFoundException {
       Connection con= null;
        Class.forName("org.sqlite.JDBC");
        
        try 
        {
            con = DriverManager.getConnection(conexionDB);
            System.out.println("Conexion Exitosa!!!!");
        
        } catch (Exception e) {
             System.out.println("Conexion Fallida !!!!"+e);
             
        }
        
        return con;
    }
   
     public int  insertSQL(String insertSQL) throws ClassNotFoundException{
        Connection con = new ConexionDB().openConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(insertSQL);
            pstm.execute();
            return 1;
            
        } catch (Exception e) {
            
            System.out.println(e);
            return 0;
        }
        
    }
     
 
     
        

    public Object prepareStatement(String querySQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException{
        ConexionDB conn = new ConexionDB();
        conn.openConnection();
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
    

}
