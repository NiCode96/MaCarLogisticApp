/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaController;

import Model.Producto;
import Conexion.Conexion;
import Controller.ProductoController;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Marca;
import Model.MarcaRepuesto;
import Model.TipoProducto;
import javax.swing.JOptionPane;
import Export.ExportarExcel;
import java.io.IOException;
import Model.Proveedor;

/**
 *
 * @author nicolas
 */
public class VistaBodega extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaBodega
     */
    
    DefaultTableModel model = new DefaultTableModel();
    
    
    public VistaBodega() {
        initComponents();
        model.addColumn("ID Producto");
        model.addColumn("Codigo SKU");
        model.addColumn("Nombre Producto");
        model.addColumn("Tipo de Repuestos");
        model.addColumn("Marca Repuesto");
        model.addColumn("Marca Vehiculo");
        model.addColumn("Modelos Compatibles");
        model.addColumn("Cantidad recepcionada");
        model.addColumn("Valor Producto");
        model.addColumn("Valor Producto Clientes");
        
        llenarTabla();
        llenarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_stock = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        comboBox_TipoRepuesto = new javax.swing.JComboBox<>();
        comboBox_MarcaProducto = new javax.swing.JComboBox<>();
        comboBox_NombreRepuesto = new javax.swing.JComboBox<>();
        btn_tipo = new javax.swing.JButton();
        btn_nombreMarca = new javax.swing.JButton();
        btn_marca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_marcaVehiculo = new javax.swing.JButton();
        comboBox_MarcaVehiculo = new javax.swing.JComboBox<>();
        btn_sku = new javax.swing.JButton();
        comboBox_ID = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        btn_id = new javax.swing.JButton();
        comboBox_SKU = new javax.swing.JComboBox<>();
        btn_provedoor = new javax.swing.JButton();
        comboBox_proveedor = new javax.swing.JComboBox<>();
        btn_actualizarStock = new javax.swing.JButton();
        stock_Spinner = new javax.swing.JSpinner();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel1.setText("PRODUCTOS DISPONIBLES EN BODEGA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 14, 368, -1));

        tabla_stock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_stock);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 256, 1127, 349));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 43, 542, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 62, -1, -1));

        comboBox_TipoRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_TipoRepuestoActionPerformed(evt);
            }
        });
        getContentPane().add(comboBox_TipoRepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 117, 391, -1));

        getContentPane().add(comboBox_MarcaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 146, 391, -1));

        getContentPane().add(comboBox_NombreRepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 88, 391, -1));

        btn_tipo.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_tipo.setText("Tipo Repuesto:");
        btn_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tipoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 117, 147, -1));

        btn_nombreMarca.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_nombreMarca.setText("Nombre Repuesto:");
        btn_nombreMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nombreMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nombreMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 88, -1, -1));

        btn_marca.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_marca.setText("Marca Repuesto:");
        btn_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marcaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 146, 147, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel2.setText("Buscar por :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 62, -1, -1));

        btn_marcaVehiculo.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_marcaVehiculo.setText("Marca Vehiculo:");
        btn_marcaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_marcaVehiculoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_marcaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 88, 155, -1));

        getContentPane().add(comboBox_MarcaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 88, 234, -1));

        btn_sku.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_sku.setText("Codigo SKU:");
        btn_sku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_skuActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sku, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 117, 155, -1));

        getContentPane().add(comboBox_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 689, 234, -1));

        jButton6.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jButton6.setText("Ver todo el Stock Disponible");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 215, 556, -1));

        btn_id.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_id.setText("ID Producto");
        btn_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_idActionPerformed(evt);
            }
        });
        getContentPane().add(btn_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 689, 138, -1));

        getContentPane().add(comboBox_SKU, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 117, 234, -1));

        btn_provedoor.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_provedoor.setText("Proveedor:");
        btn_provedoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_provedoorActionPerformed(evt);
            }
        });
        getContentPane().add(btn_provedoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 146, 155, -1));

        getContentPane().add(comboBox_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 146, 234, -1));

        btn_actualizarStock.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_actualizarStock.setText("Actualizar Stock");
        btn_actualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarStockActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 718, 138, -1));
        getContentPane().add(stock_Spinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 718, 126, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    public void llenarTabla(){
        model.setRowCount(0);
        tabla_stock.setModel(model);
        
        try {
            
            
            
        ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();

        for (Producto productoIndex : tablaProductos) {
                        
        Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
                    
                    }
        } catch (Exception e) {
        }
        
    }
    
    
public void llenarCombo() {
    comboBox_NombreRepuesto.removeAllItems();
    comboBox_MarcaProducto.removeAllItems();
    comboBox_ID.removeAllItems();
    comboBox_SKU.removeAllItems();
    comboBox_TipoRepuesto.removeAllItems();
    comboBox_MarcaVehiculo.removeAllItems();

    comboBox_NombreRepuesto.addItem("");
    comboBox_MarcaProducto.addItem("");
    comboBox_ID.addItem("");
    comboBox_SKU.addItem("");
    comboBox_TipoRepuesto.addItem("");
    comboBox_MarcaVehiculo.addItem("");

    try {
        ArrayList<Marca> tablaMarca = Marca.buscarTodasMarcas();
        ArrayList<MarcaRepuesto> tablaMarcaRepuestos = MarcaRepuesto.buscarTodasMarcas();
        ArrayList<TipoProducto> tablaTipoProductos = TipoProducto.listarTodos();
        ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();
        ArrayList<Proveedor> tablaProveedor = Proveedor.listarProveedores();
        
        for (Proveedor proveedorIndex : tablaProveedor) {
            int estado = proveedorIndex.getEstado_proveedor();
            
            if (estado == 1) {
                
                comboBox_proveedor.addItem(proveedorIndex.getNombre_proveedor());
            }
        }
        

        for (Producto producto : tablaProductos) {
            if (producto.getProducto_estado() == 0) {
                comboBox_NombreRepuesto.addItem(producto.getNombreProducto());
                comboBox_SKU.addItem(producto.getSku());
                comboBox_ID.addItem(String.valueOf(producto.getId_producto()));
                
            }
        }

        for (Marca marca : tablaMarca) {
            int estado = marca.getMarca_estado();
            
            if (estado ==1) {
                comboBox_MarcaVehiculo.addItem(marca.getNombreMarca());
            }
            
        }
        
        

        for (MarcaRepuesto marcaRepuesto : tablaMarcaRepuestos) {
             int estado = marcaRepuesto.getEstado_marcaRepuesto();
             
             if (estado == 1) {
                comboBox_MarcaProducto.addItem(marcaRepuesto.getNombreMarca());
            }
            
        }

        for (TipoProducto tipo : tablaTipoProductos) {
            int estado = tipo.getEstado_tipo();
            
            if (estado == 1) {
                
                comboBox_TipoRepuesto.addItem(tipo.getTipoNombre());
            }
            
        }

    } catch (Exception e) {
        e.printStackTrace(); 
    }
}
    
    
    
    private void comboBox_TipoRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_TipoRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_TipoRepuestoActionPerformed

    private void btn_nombreMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nombreMarcaActionPerformed
        model.setRowCount(0);
        tabla_stock.setModel(model);
        String nombreRepuesto = comboBox_NombreRepuesto.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXnombreRepuesto(nombreRepuesto);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_btn_nombreMarcaActionPerformed

    private void btn_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tipoActionPerformed
        
        model.setRowCount(0);
        tabla_stock.setModel(model);
        String tipoRepuesto = comboBox_TipoRepuesto.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXtipo(tipoRepuesto);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado == 0) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btn_tipoActionPerformed

    private void btn_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marcaActionPerformed
        
    model.setRowCount(0);
    tabla_stock.setModel(model);
    String marcaRepuesto = comboBox_MarcaProducto.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXmarcaRepuesto(marcaRepuesto);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
       
                                           

        
        
        
        
        
        
        
    }//GEN-LAST:event_btn_marcaActionPerformed

    private void btn_marcaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_marcaVehiculoActionPerformed
    model.setRowCount(0);
    tabla_stock.setModel(model);
    String marcaVehiculo = comboBox_MarcaVehiculo.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXmarcaVehiculo(marcaVehiculo);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_marcaVehiculoActionPerformed

    private void btn_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_idActionPerformed
    model.setRowCount(0);
    tabla_stock.setModel(model);
    int id = Integer.parseInt(comboBox_ID.getSelectedItem().toString());
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXid(id);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
                                                    

    }//GEN-LAST:event_btn_idActionPerformed

    private void btn_skuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_skuActionPerformed
    model.setRowCount(0);
    tabla_stock.setModel(model);
    String sku = comboBox_SKU.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXsku(sku);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_skuActionPerformed

    private void btn_provedoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_provedoorActionPerformed
     
    model.setRowCount(0);
    tabla_stock.setModel(model);
    String proveedor = comboBox_proveedor.getSelectedItem().toString();
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarXbodega(proveedor);
             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado != 1) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }
        
        
        
        
    }//GEN-LAST:event_btn_provedoorActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed


    model.setRowCount(0);
    tabla_stock.setModel(model);
    
      
        try {
            
             ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();

             for (Producto productoIndex : tablaProductos) {
                 Object[] objeto = new Object[10];
                 
                objeto[0]= productoIndex.getId_producto();
                objeto[1]= productoIndex.getSku();
                objeto[2]= productoIndex.getNombreProducto();
                objeto[3]= productoIndex.getTipoProducto();
                objeto[4]= productoIndex.getMarcaRepuesto();
                objeto[5]= productoIndex.getMarcaVehiculo();
                objeto[6]= productoIndex.getModelosCompatibles();
                objeto[7]= productoIndex.getCantidadRecepcionada();
                objeto[8]= productoIndex.getValor();
                objeto[9]= productoIndex.getValorProducto();
                
                int estado = productoIndex.getProducto_estado();
                
                if (estado == 0) {
                     model.addRow(objeto);
                }
            }
             
        } catch (Exception e) {
        }


                              


        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_actualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarStockActionPerformed
         
       
        try {
            int id_productoSeleccionado = Integer.parseInt(comboBox_ID.getSelectedItem().toString());
            int nuevoStock = (int)stock_Spinner.getValue();
            
            boolean sucess = Producto.modificarCantidadProducto(nuevoStock,id_productoSeleccionado);
            if (sucess) {
                JOptionPane.showMessageDialog(this, "Cantidad de producto en bodega Actualizado!");
                
            }
            
        } catch (Exception e) {
        }




        
    }//GEN-LAST:event_btn_actualizarStockActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarStock;
    private javax.swing.JButton btn_id;
    private javax.swing.JButton btn_marca;
    private javax.swing.JButton btn_marcaVehiculo;
    private javax.swing.JButton btn_nombreMarca;
    private javax.swing.JButton btn_provedoor;
    private javax.swing.JButton btn_sku;
    private javax.swing.JButton btn_tipo;
    private javax.swing.JComboBox<String> comboBox_ID;
    private javax.swing.JComboBox<String> comboBox_MarcaProducto;
    private javax.swing.JComboBox<String> comboBox_MarcaVehiculo;
    private javax.swing.JComboBox<String> comboBox_NombreRepuesto;
    private javax.swing.JComboBox<String> comboBox_SKU;
    private javax.swing.JComboBox<String> comboBox_TipoRepuesto;
    private javax.swing.JComboBox<String> comboBox_proveedor;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner stock_Spinner;
    private javax.swing.JTable tabla_stock;
    // End of variables declaration//GEN-END:variables




}