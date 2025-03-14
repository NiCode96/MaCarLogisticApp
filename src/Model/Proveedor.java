/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Conexion.Conexion;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author nicolas
 */
public class Proveedor {
    int id_proveedor;
    String nombre_proveedor;
    int estado_proveedor;

    public Proveedor() {
    }
    
    

    public Proveedor(int id_proveedor, String nombre_proveedor, int estado_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.estado_proveedor = estado_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public int getEstado_proveedor() {
        return estado_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public void setEstado_proveedor(int estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }
    
    
    
    
        
    public static ArrayList <Proveedor> listarProveedores () throws SQLException{
    ArrayList <Proveedor> listarProveedores = new ArrayList<>();
    Conexion conexion = new Conexion();
    Connection conn = null;
    
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR BASE DE DATOS SQL");
        }
    
        
        
        try {
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM proveedor ";
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        ResultSet resultado = statement.executeQuery();
        
        
            while (resultado.next()) { 
                
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(resultado.getInt("id_proveedor"));
                proveedor.setNombre_proveedor(resultado.getString("nombre_proveedor"));
                proveedor.setEstado_proveedor(resultado.getInt("estado_proveedor"));
                listarProveedores.add(proveedor);
                
            }
            
            
        } finally {
            
            conexion.cerrar();
        }
        
        return listarProveedores;
    }
    
    
   
    
        public static boolean insertarProveedor(String nombre_proveedor) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            throw new SQLException("No se puede conectar a la base de datos SQL");
        }
    
        try {
            conn = conexion.enlace;
            String consultaSQL = "INSERT INTO proveedor (nombre_proveedor) VALUES (?) ";
                   
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
             statement.setString(1, nombre_proveedor);
             
              int filas = statement.executeUpdate();
              return filas > 0;
            
        } finally {
            
               conexion.cerrar();
                
        }
    
       
       
    }
        
        
        

public static boolean modificarProveedorXID(int id_proveedor, String nombre_proveedor) throws SQLException{
        
Conexion conexion = new Conexion();
Connection conn = null;
        
        
        if (!conexion.abrir()) {
            
    throw new SQLException("Error en la Conexion con base de datos SQL");
            
        }
        
        try {
            conn = conexion.enlace;
            String consultaSQL = "UPDATE proveedor SET nombre_proveedor = ? " +
                    "WHERE id_proveedor = ? ";
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombre_proveedor);
            statement.setInt(2, id_proveedor);
             int filas = statement.executeUpdate();
              return  filas >0;
            
        } finally {
            conexion.cerrar();
        }
    
    }
    



    public static boolean eliminarProveedor(int id_proveedor) throws SQLException{
        
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            
    throw new SQLException("Error en la Conexion con base de datos SQL");
            
        }
        
        try {
            conn = conexion.enlace;
            String consultaSQL = "UPDATE proveedor SET estado_proveedor = 0 " +
                    "WHERE id_proveedor = ? ";
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
          
            statement.setInt(1, id_proveedor);
             int filas = statement.executeUpdate();
              return  filas >0;
            
        } finally {
            conexion.cerrar();
        }
    
    }
    
    
    public static boolean verificarIngreso(String nuevoProveedor){
        
        try {
            
             ArrayList <Proveedor> listarProveedores = Proveedor.listarProveedores();
             
             for (Proveedor proveedorIndex : listarProveedores) {
                 String nombreProveedor = proveedorIndex.getNombre_proveedor();
                 
                 if (nuevoProveedor.equals(nombreProveedor)) {
                     return true;
                     
                 }
                
            }
                    
             
        } catch (Exception e) {
        }
        return false;
        
    }
    
}
