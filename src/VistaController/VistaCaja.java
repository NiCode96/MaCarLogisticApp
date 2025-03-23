/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package VistaController;
import Model.Producto;
import Conexion.Conexion;
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
import Model.VentaProducto;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.net.URL;  // Asegúrate de importar la clase URL
import java.util.Iterator;

/**
 *
 * @author nicolas
 */
public class VistaCaja extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaCaja
     */
    
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<VentaProducto> tablaVenta = new ArrayList<>();
    double sumaTotal = 0;
    
    public VistaCaja() {
        initComponents();
        model.addColumn("REPUESTO");
        model.addColumn("CODIGO SKU");
        model.addColumn("MARCA VEHICULO");
        model.addColumn("MODELO COMPATIBLE");
        model.addColumn("VALOR PRODUCTO");
        model.addColumn("IVA/19%");
        model.addColumn("UNIDADES");
        
        llenarTabla();
        llenarCombo();
        
        
    }

    
    
public void sumaTotalCompra() {
    // Reiniciar los acumuladores
    sumaTotal = 0;
    double sumaIVA = 0;

    // Iterar sobre los productos vendidos
    for (VentaProducto ventaProducto : tablaVenta) {
        // Tomar el total como valor bruto (con IVA)
        double totalConIVA = ventaProducto.getValor() * ventaProducto.getCantidadVendida();

        // Calcular el valor neto (sin IVA)
        double subtotalProducto = totalConIVA / 1.19;

        // Calcular el IVA correctamente
        double IVAProducto = totalConIVA - subtotalProducto;

        // Acumular valores
        sumaIVA += IVAProducto;
        sumaTotal += totalConIVA; // Ahora sumaTotal representa el total con IVA
    }

    // Mostrar los valores en los campos de texto sin decimales
    txt_iva19.setText(String.format("%d", (int) sumaIVA)); // IVA total
    txt_total.setText(String.format("%d", (int) sumaTotal)); // Total con IVA
}

public void llenarTabla() {
    // Limpiar la tabla antes de llenarla
    model.setRowCount(0);
    tbl_cotizacion.setModel(model);

    // Recorrer los productos en tablaVenta
    for (VentaProducto ventaProducto : tablaVenta) {
        int stock = ventaProducto.getCantidadRecepcionada();
        int cantidadVendida = ventaProducto.getCantidadVendida();
        double valorBruto = ventaProducto.getValor(); // Valor con IVA incluido
        double totalConIVA = valorBruto * cantidadVendida; // Total bruto
        double subtotal = totalConIVA / 1.19; // Extraemos el valor neto sin IVA
        double IVAProducto = totalConIVA - subtotal; // IVA correcto

        // Crear el objeto para la fila
        Object[] objeto = new Object[7];
        objeto[0] = ventaProducto.getNombreProducto();
        objeto[1] = ventaProducto.getSku();
        objeto[2] = ventaProducto.getMarcaVehiculo();
        objeto[3] = ventaProducto.getModelosCompatibles();
        objeto[4] = String.format("%d", (int) subtotal); // Precio total sin IVA (entero)
        objeto[5] = String.format("%d", (int) IVAProducto); // IVA extraído (entero)
        objeto[6] = cantidadVendida; // Cantidad vendida

        // Agregar la fila al modelo
        model.addRow(objeto);
    }
}
  
    public void llenarCombo(){
        try {
            comboBox_repuesto.removeAllItems();
            
            // Cargar todos los productos disponibles
            ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();
            
            // Filtrar productos con estado "activo" (suponiendo que 0 es activo)
            for (Producto tablaProducto : tablaProductos) {
                if (tablaProducto.getProducto_estado() == 0) {
                    // Añadir item al comboBox con formato adecuado
                    comboBox_repuesto.addItem("ID: " + tablaProducto.getId_producto() + "     " + tablaProducto.getNombreProducto() 
                        + "      MARCA: " + tablaProducto.getMarcaVehiculo() + "      COMPATIBLE: " + tablaProducto.getModelosCompatibles());
                }
            }
        } catch (Exception e) {
            // Registrar el error si ocurre un problema
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        spinner_cantidad = new javax.swing.JSpinner();
        comboBox_repuesto = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cotizacion = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSpinner2 = new javax.swing.JSpinner();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_rutCliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_nombreCliente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_generarOrden = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_iva19 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        btn_quitar = new javax.swing.JButton();
        comboBox_productos = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txt_vendedor = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setClosable(true);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel4.setText("COTIZACION  MAYORISTAS");

        comboBox_repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_repuestoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel7.setText("Producto:");

        btn_agregar.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        btn_agregar.setText("Agregar a Pedido");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel11.setText("Cantidad:");

        tbl_cotizacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_cotizacion);

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 3, 18)); // NOI18N
        jLabel13.setText("Productos Añadidos:");

        jInternalFrame1.setClosable(true);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel5.setText("Modulo de Caja");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel8.setText("Producto:");

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jButton3.setText("Realizar Venta");

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jButton4.setText("Agregar a Pedido");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel14.setText("Codigo Producto:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel15.setText("Cantidad:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel17.setText("Productos Añadidos:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(18, 18, 18)
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox2, 0, 467, Short.MAX_VALUE)
                                        .addComponent(jTextField4)))
                                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                    .addGap(18, 18, 18)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(16, 16, 16))
        );

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel19.setText("Nombre:");

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel20.setText("Rut Cliente:");

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        txt_rutCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rutClienteActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel21.setText("Telefono:");

        txt_nombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreClienteActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel22.setText("Total Venta:");

        txt_total.setEditable(false);
        txt_total.setText("0");

        btn_generarOrden.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        btn_generarOrden.setText("Guardar Pedido");
        btn_generarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarOrdenActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel23.setText("Direccion:");

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        jLabel24.setText("$");

        txt_iva19.setEditable(false);
        txt_iva19.setText("0");

        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel26.setText("IVA 19%:");

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 2, 14)); // NOI18N
        jLabel27.setText("$");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel18.setText("Fecha:");

        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });

        btn_quitar.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        btn_quitar.setText("Quitar Producto");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel29.setText("Producto Cotizado:");

        txt_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vendedorActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel30.setText("Vendedor:");

        txt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mailActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel31.setText("Mail Cliente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel24)
                                .addComponent(jLabel27))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_iva19, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBox_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_generarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(177, 177, 177))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel21)
                                .addComponent(jLabel30)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(txt_telefono)
                                .addComponent(txt_nombreCliente)
                                .addComponent(txt_vendedor))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_rutCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                                        .addComponent(txt_direccion)
                                        .addComponent(txt_mail))
                                    .addGap(159, 159, 159))
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBox_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 703, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 703, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_quitar)
                            .addComponent(comboBox_productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_iva19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generarOrden)
                    .addComponent(btn_limpiar))
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 365, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 365, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            
            
            
            int cantidadVendida = (int) spinner_cantidad.getValue();
            ArrayList<Producto> tablaProductos = Producto.buscarTodasMarcas();
            int id_delCombo = obtenerIdSeleccionado();
            VentaProducto nuevoProducto = new VentaProducto();
            boolean productoAgregado = false;
            
            for (Producto tablaProducto : tablaProductos) {
                int id_deLaTabla = tablaProducto.getId_producto();
                int estado_producto = tablaProducto.getProducto_estado();
                
                if (id_deLaTabla == id_delCombo && estado_producto == 0 && cantidadVendida > 0) {
                    nuevoProducto.setNombreProducto(tablaProducto.getNombreProducto());
                    nuevoProducto.setSku(tablaProducto.getSku());
                    nuevoProducto.setMarcaVehiculo(tablaProducto.getMarcaVehiculo());
                    nuevoProducto.setModelosCompatibles(tablaProducto.getModelosCompatibles());
                    nuevoProducto.setValor(tablaProducto.getValor());
                    nuevoProducto.setValorProducto(tablaProducto.getValorProducto());
                    nuevoProducto.setCantidadVendida(cantidadVendida);
                    
                    tablaVenta.add(nuevoProducto);
                    llenarTabla();
                    sumaTotalCompra ();
                    llenarComboProducto();
                            comboBox_productos.setSelectedIndex(-1);  // Deja el ComboBox sin selección
                            comboBox_repuesto.setSelectedIndex(-1);
        spinner_cantidad.setValue(0);  // Reinicia el Spinner a cero
        productoAgregado = true;
        break;
                }
            }
            
            
            if (!productoAgregado) {
               JOptionPane.showMessageDialog(this, "Debe agregar por lo menos una unidad por producto");
            }
            
            
        } catch (Exception e) {
            
        }
    
        
        
        
        
        
            
       
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_rutClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rutClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rutClienteActionPerformed

    private void txt_nombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreClienteActionPerformed

    private void comboBox_repuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_repuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_repuestoActionPerformed

    private void btn_generarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarOrdenActionPerformed
// 1. Crear el documento
Document documento = new Document();

try {
    // 2. Establecer el escritor para el PDF
    int numeroCotizacion = (int) (Math.random() * 10000) + 1;  // Número aleatorio entre 1 y 10,000
    String escritorio = System.getProperty("user.home") + "/Desktop";  // Ruta del escritorio
    String ruta = escritorio + "/COTIZACION_" + numeroCotizacion + ".pdf";  // Nombre con número de cotización
    PdfWriter.getInstance(documento, new FileOutputStream(ruta));

    // 3. Abrir el documento
    documento.open();

    // 3.1 Agregar el logo en la esquina superior izquierda
    URL logoURL = getClass().getResource("/resources/logox.png");  // Ruta dentro de resources
    if (logoURL != null) {
        Image logo = Image.getInstance(logoURL);
        logo.scaleToFit(240, 120);  // Reducción del 20%
        logo.setAbsolutePosition(300, 700);  // Mover un poco más a la derecha
        documento.add(logo);
    } else {
        JOptionPane.showMessageDialog(null, "Logo no encontrado.");
    }

    // 4. Crear fuentes para el PDF
    Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    Font fuenteNormal = new Font(Font.FontFamily.HELVETICA, 12);
    Font fuenteTabla = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD); // Reducido de 9 a 8
    Font fuenteSubtitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLDITALIC);
    Font fuenteBancaria = new Font(Font.FontFamily.HELVETICA, 10);
    Font fuenteTablaContenido = new Font(Font.FontFamily.HELVETICA, 7); // Fuente más pequeña para el contenido

    // 5. Agregar información de título
    documento.add(new Paragraph("Cotización de Repuestos", fuenteTitulo));
    documento.add(new Paragraph("Número de Cotización: " + numeroCotizacion, fuenteNormal));
    documento.add(new Paragraph(" ", fuenteNormal));  // Espacio en blanco

    // 6. Datos del Cliente
    documento.add(new Paragraph("Datos del Cliente:", fuenteSubtitulo));
    documento.add(new Paragraph("Nombre: " + txt_nombreCliente.getText(), fuenteNormal));
    documento.add(new Paragraph("RUT: " + txt_rutCliente.getText(), fuenteNormal));
    documento.add(new Paragraph("Dirección: " + txt_direccion.getText(), fuenteNormal));
    documento.add(new Paragraph("Teléfono: " + txt_telefono.getText(), fuenteNormal));
    documento.add(new Paragraph("Vendedor: " + txt_vendedor.getText(), fuenteNormal));
    documento.add(new Paragraph("Correo: " + txt_mail.getText(), fuenteNormal));
    documento.add(new Paragraph(" ", fuenteNormal));  // Espacio en blanco

    // 7. Crear la tabla para los productos
    PdfPTable tabla = new PdfPTable(tbl_cotizacion.getColumnCount());
    tabla.setWidthPercentage(100);

    // 8. Agregar encabezados a la tabla
    for (int i = 0; i < tbl_cotizacion.getColumnCount(); i++) {
        PdfPCell celda = new PdfPCell(new Phrase(tbl_cotizacion.getColumnName(i), fuenteTabla));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
    }

    // 9. Agregar las filas de la tabla con fuente más pequeña
    for (int i = 0; i < tbl_cotizacion.getRowCount(); i++) {
        for (int j = 0; j < tbl_cotizacion.getColumnCount(); j++) {
            PdfPCell celda = new PdfPCell(new Phrase(tbl_cotizacion.getValueAt(i, j).toString(), fuenteTablaContenido));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(celda);
        }
    }

    // 10. Agregar la tabla al documento
    documento.add(tabla);

    // 11. Agregar el subtotal, IVA y total
    documento.add(new Paragraph(" ", fuenteNormal));
    documento.add(new Paragraph("IVA 19%: $" + txt_iva19.getText(), fuenteNormal));
    documento.add(new Paragraph("Total: $" + txt_total.getText(), fuenteNormal));

    // 12. Agregar datos bancarios
    documento.add(new Paragraph(" ", fuenteNormal));
    documento.add(new Paragraph("—————————————————————————————————", fuenteBancaria));
    documento.add(new Paragraph("DATOS BANCARIOS", fuenteSubtitulo));
    documento.add(new Paragraph("Nombre Empresa: COMERCIALIZADORA CARRASCO MACAR LIMITADA", fuenteBancaria));
    documento.add(new Paragraph("RUT Empresa: 77.930.258-K", fuenteBancaria));
    documento.add(new Paragraph("Correo: macar.repuestos.automotriz@gmail.com", fuenteBancaria));
    documento.add(new Paragraph("Banco: BCI", fuenteBancaria));
    documento.add(new Paragraph("Cuenta Corriente Empresa: Nº 97477648", fuenteBancaria));
    documento.add(new Paragraph("—————————————————————————————————", fuenteBancaria));

    // 13. Agregar el pie de página
    URL pieURL = getClass().getResource("/resources/pie.png");
    if (pieURL != null) {
        Image piePagina = Image.getInstance(pieURL);
        piePagina.scaleToFit(500, 100);
        piePagina.setAlignment(Element.ALIGN_CENTER);
        documento.add(new Paragraph(" ", fuenteNormal));
        documento.add(piePagina);
    } else {
        JOptionPane.showMessageDialog(null, "Pie de página no encontrado.");
    }

    // 14. Cerrar el documento
    documento.close();

    // 15. Mostrar mensaje de éxito
    JOptionPane.showMessageDialog(null, "¡PDF generado exitosamente en: " + ruta + "!");

} catch (FileNotFoundException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Archivo no encontrado: " + e.getMessage());
} catch (IOException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error de entrada/salida: " + e.getMessage());
} catch (DocumentException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error al generar el documento: " + e.getMessage());
}
    }//GEN-LAST:event_btn_generarOrdenActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        tablaVenta.clear();
        llenarTabla();
        llenarComboProducto();
       
        txt_iva19.setText("");
        txt_total.setText("");
            comboBox_productos.setSelectedIndex(-1);  // Deja el ComboBox sin selección
        spinner_cantidad.setValue(0);  // Reinicia el Spinner a cero
        comboBox_repuesto.setSelectedIndex(-1);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
   
        Iterator <VentaProducto> iterator = tablaVenta.iterator();
        String producto = comboBox_productos.getSelectedItem().toString();
        
        while (iterator.hasNext()) {
             
            VentaProducto next = iterator.next();
            
            if (next.getNombreProducto().contains(producto)) {
                iterator.remove();
                
            }
            
        }
        
        llenarTabla();
        llenarComboProducto();
        sumaTotalCompra();
        
        
        
    }//GEN-LAST:event_btn_quitarActionPerformed

    private void txt_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vendedorActionPerformed

    private void txt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mailActionPerformed

    public void llenarComboProducto(){
    comboBox_productos.removeAllItems();
        try {
            
            for (VentaProducto ventaProducto : tablaVenta) {
                comboBox_productos.addItem(ventaProducto.getNombreProducto());
                
                
            }
        } catch (Exception e) {
        }
    
    }
    
    
    
    public int obtenerIdSeleccionado() {
    // Obtiene el valor seleccionado en el JComboBox como un String
    String seleccion = (String) comboBox_repuesto.getSelectedItem();
    
    // Verifica que la selección no sea null y que empiece con "ID: "
    if (seleccion != null && seleccion.startsWith("ID: ")) {
        try {
            // Divide la cadena en partes separadas por espacios en blanco
            String[] partes = seleccion.split(" "); 
            
            // El ID está en la segunda posición (índice 1) porque el formato es: "ID: 123 NombreProducto..."
            String idStr = partes[1]; 
            
            // Convierte el ID de String a int y lo devuelve
            return Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            // Si hay un error en la conversión, imprime el error en la consola
            e.printStackTrace();
        }
    }
    
    // Retorna -1 si no hay selección válida o si ocurre un error
    return -1; 
}
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_generarOrden;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JComboBox<String> comboBox_productos;
    private javax.swing.JComboBox<String> comboBox_repuesto;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JSpinner spinner_cantidad;
    private javax.swing.JTable tbl_cotizacion;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_iva19;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_rutCliente;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_vendedor;
    // End of variables declaration//GEN-END:variables
}
