 
package Interfase;
import Conexion.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Resultados extends javax.swing.JFrame
{
       DefaultTableModel model = new DefaultTableModel();
    private String Ssql;
        
       public Resultados() throws SQLException, ClassNotFoundException 
       {
            initComponents();    
            mostrar();
            
             
       }
       
       
     public ArrayList<User> userList() throws ClassNotFoundException, SQLException {
         java.sql.Connection con = new ConexionDB().openConnection();
        String querySQL = "select ID_Usuario,Usuario,Nombre,Apellido,Telefono,Gmail,Clave from Usuario";
        ResultSet rsult = con.prepareStatement(querySQL).executeQuery();
         
        ArrayList<User> userList = new ArrayList<>();
             User user;
            while(rsult.next()){
                int id = rsult.getByte("ID_Usuario");
                String Usuario =rsult.getString("Usuario");
                String Nombre =rsult.getString("Nombre");
                String Apellido =rsult.getString("Apellido");
                String Telefono =rsult.getString("Telefono");
                String Gmail =rsult.getString("Gmail");
                String Clave =rsult.getString("Clave");

                user = new User(id, Usuario,Nombre,Apellido,Telefono,Gmail,Clave);
                userList.add(user);

            }
            
          rsult.close();
          con.close(); 
           
          return userList;
     }
         
       
    public void mostrar()throws SQLException, ClassNotFoundException{
        
        
         DefaultTableModel model = new DefaultTableModel();
                           model.addColumn("ID_Usuario");
                           model.addColumn("Usuario");
                           model.addColumn("Nombre");
                           model.addColumn("Apellido");
                           model.addColumn("Telefono");
                           model.addColumn("Gmail");
                           model.addColumn("Clave");
               
             jTable1.setModel(model); 
       
            ArrayList<User> userList = userList();

            DefaultTableModel rowModel = (DefaultTableModel) jTable1.getModel();
            Object[] row = new Object[7];
            for(int i = 0; i < userList.size(); i++)
            {
                row[0] = userList.get(i).getId();
                row[1] = userList.get(i).getUsuario();
                row[2] = userList.get(i).getNombre();
                row[3] = userList.get(i).getApellido();
                row[4] = userList.get(i).getTelefono();
                row[5] = userList.get(i).getGmail();
                row[6] = userList.get(i).getClave();

                rowModel.addRow(row);
            }

      
        
        
        
        
    }

       
    public void eliminar() throws ClassNotFoundException, SQLException
    {
        int fila = jTable1.getSelectedRow();
        java.sql.Connection con = new ConexionDB().openConnection();
        String row = jTable1.getValueAt(fila, 0).toString();
        
        if(fila >=0)
        {    
            try {
                String SQLdelete = "DELETE FROM Usuario WHERE ID_Usuario ='"+row+"' ";
                int rsult = con.prepareStatement(SQLdelete).executeUpdate();
                JOptionPane.showMessageDialog(null, "DATO ELIMINADO");
            } catch (Exception e) {
                System.err.println(e);
            }
       
        }
       con.close(); 
    }  

   public void update() throws ClassNotFoundException{
        jTable1.getCellEditor().stopCellEditing();
        int fila = jTable1.getSelectedRow();
        java.sql.Connection con = new ConexionDB().openConnection();
        
        String ID = jTable1.getValueAt(fila, 0).toString();     
        String Usuario = jTable1.getValueAt(fila,1).toString();
        String Nombre = jTable1.getValueAt(fila,2).toString();
        String Apellido = jTable1.getValueAt(fila,3).toString();
        String Telefono = jTable1.getValueAt(fila,4).toString();
        String Gmail = jTable1.getValueAt(fila,5).toString();
        String Clave = jTable1.getValueAt(fila,6).toString();
           
        if(fila >=0)
        {    
            try {
                String SQLupdate = "UPDATE Usuario SET Usuario = '"+Usuario+"',Nombre ='"+Nombre+"',Apellido='"+Apellido+"'"
                        + ",Telefono='"+Telefono+"',Gmail='"+Gmail+"',Clave='"+Clave+"'  WHERE ID_Usuario ='"+ID+"'";
                
                int rsult = con.prepareStatement(SQLupdate).executeUpdate();
                JOptionPane.showMessageDialog(null, "DATO ACTUALIZADO");
            } catch (Exception e)
            {
                System.err.println(e);
            }
       
        }
   
    }
  


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 204, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, new java.awt.Color(255, 255, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(0, 204, 153))));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios Registrados");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/borrar.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/update.png"))); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/cerrars.png"))); // NOI18N
        jbCerrar.setText("Cerrar Sesion");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jbActualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar)
                            .addGap(73, 73, 73)
                            .addComponent(jbCerrar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
           try {
               eliminar();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           }
           try {
             mostrar();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           }
      
        
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
             
        
           try
           {
               update();
               mostrar();   
           } 
           catch (ClassNotFoundException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
           try {
               IniciarSesion inicio = new IniciarSesion();
               inicio.setVisible(true);
               
               this.dispose();
               
// TODO add your handling code here:
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
           }
    }//GEN-LAST:event_jbCerrarActionPerformed
 
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Resultados().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEliminar;
    // End of variables declaration//GEN-END:variables

    
}
