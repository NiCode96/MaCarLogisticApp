/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaController;
import Model.Marca;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import Controller.MarcaController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author nicolas
 */
public class VistaIngresoMarca extends javax.swing.JInternalFrame {
    
  
    JDesktopPane desktopPane = new JDesktopPane();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form VistaIngresoMarca
     */
    public VistaIngresoMarca() {
        
        initComponents();
        model.addColumn("CODIGO");
        model.addColumn("MARCA");
        


        try {
        llenarComboMarca();
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error al llenar el combo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(VistaIngresoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        seleccionId();
        llenarTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrincipalPanel = new javax.swing.JPanel();
        combo_marcaID = new javax.swing.JComboBox<>();
        btn_agregarMarca = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_marca = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setClosable(true);

        PrincipalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo_marcaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_marcaIDActionPerformed(evt);
            }
        });
        PrincipalPanel.add(combo_marcaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 70, 336, -1));

        btn_agregarMarca.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_agregarMarca.setText("Agregar");
        btn_agregarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarMarcaActionPerformed(evt);
            }
        });
        PrincipalPanel.add(btn_agregarMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 196, 168, -1));

        btn_modificar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        PrincipalPanel.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 112, 182, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel4.setText("Buscar Marca ID:");
        PrincipalPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 71, 126, 26));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel1.setText("Nueva Marca");
        PrincipalPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 196, 94, -1));

        txt_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_marcaActionPerformed(evt);
            }
        });
        PrincipalPanel.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 196, 284, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel2.setText("INGRESO NUEVA MARCA");
        PrincipalPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 16, 235, -1));

        tabla_marca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_marca);

        PrincipalPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 238, 588, 210));

        btn_eliminar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        PrincipalPanel.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 112, 182, -1));

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void llenarTabla(){
    model.setRowCount(0);
    tabla_marca.setModel(model);
    
     MarcaController marcaController = new MarcaController();
        try {
            
              ArrayList<Marca>listaMarca = marcaController.listaTodasMarcas();
        
      
            for (Marca marcaIndex : listaMarca) {
                Object objeto [] = new Object[2];
               objeto[0] = marcaIndex.getId_marca();
               objeto[1]= marcaIndex.getNombreMarca();
               int  estado = marcaIndex.getMarca_estado();
               
                if (estado == 1) {
                   model.addRow(objeto); 
                }
                
    
      
            }
    
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No es posible cargar los datos en la tabla Marcas");
        }
      
    
    
    }
    
    
    
    private void btn_agregarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarMarcaActionPerformed
        String marca = txt_marca.getText().trim();
        MarcaController marcaController = new MarcaController();
        
        
        
        
      
        
        try {
      
            if (!marca.isEmpty() && !Marca.verificarDuplicidad(marca)) {
                
                Marca.insertarMarca(marca);
                JOptionPane.showMessageDialog(this, "Marca ingresada Correctamente");
                
            } else {
                
                 JOptionPane.showMessageDialog(this, "Debe completar campos con datos no duplicados");
            }
            
            

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al Agregar Marca, problema relacionado con conexion a Base de Datos SQL");
            Logger.getLogger(VistaIngresoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }


   refresh();
           
        
    }//GEN-LAST:event_btn_agregarMarcaActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
    int id_marca = Integer.parseInt(combo_marcaID.getSelectedItem().toString());
    String nombreNuevo = txt_marca.getText().trim();

MarcaController marcaController = new MarcaController();

      
        try {
            if (!nombreNuevo.isEmpty() && !Marca.verificarDuplicidad(nombreNuevo)) {
            
            marcaController.modificarMarcaXid(id_marca, nombreNuevo);
           
            JOptionPane.showMessageDialog(this, "Marca Modificada correctamente");
            llenarComboMarca();
            llenarTabla();
            
            } else {
            
              JOptionPane.showMessageDialog(this, "Deben agregarse datos validos");
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "NO ES POSIBLE REALIZAR OPERACION");
        }


 
refresh();



    }//GEN-LAST:event_btn_modificarActionPerformed




public void refresh(){
    try {
        txt_marca.setText("");
llenarComboMarca();
llenarTabla();
    } catch (Exception e) {
    }
}


    private void txt_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_marcaActionPerformed

    private void combo_marcaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_marcaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_marcaIDActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
    int id_marca = Integer.parseInt(combo_marcaID.getSelectedItem().toString());
        try {
            Marca.eliminarMarca(id_marca);
            JOptionPane.showMessageDialog(this, "Marca Eliminada correctamente");
            llenarComboMarca();
            llenarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VistaIngresoMarca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    
    
   public void llenarComboMarca()throws SQLException{
        
        combo_marcaID.removeAllItems();
    
    MarcaController marcaController = new MarcaController();
    
        ArrayList<Marca>listaMarca = marcaController.listaTodasMarcas();
        
      
            for (Marca marcaIndex : listaMarca) {
            int marcaNombre = marcaIndex.getId_marca();
            int estado = marcaIndex.getMarca_estado();
                    
                if (estado == 1) {
                    combo_marcaID.addItem(String.valueOf(marcaNombre));
                }
            
            
        
    
      
            }
    
         
            
          
    }
    
    
    
    
    
    public void seleccionId (){
    String marcaSeleccionda = combo_marcaID.getSelectedItem().toString();
    MarcaController marcaController = new MarcaController();
        try {
           Marca marcaSelect = new Marca();
           marcaSelect = marcaController.buscarIdMarca(marcaSeleccionda);
           txt_marca.setText(String.valueOf(marcaSelect.getId_marca()));
          
                
        } catch (Exception e) {
        }
    
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrincipalPanel;
    private javax.swing.JButton btn_agregarMarca;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> combo_marcaID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_marca;
    private javax.swing.JTextField txt_marca;
    // End of variables declaration//GEN-END:variables
}
