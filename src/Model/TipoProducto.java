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
public class TipoProducto {
    
    // id_tipo, tipoNombre, marca, id_marca
    
    int id_tipo;
    String tipoNombre;
    int estado_tipo;

    public TipoProducto(int id_tipo, String tipoNombre) {
        this.id_tipo = id_tipo;
        this.tipoNombre = tipoNombre;
        this.estado_tipo = estado_tipo;
    }

    public TipoProducto() {
    }

    
    public int getId_tipo() {
        return id_tipo;
    }

    
    public String getTipoNombre() {
        return tipoNombre;
    }

    
    public int getEstado_tipo() {
        return estado_tipo;
    }
    
    

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    
    
    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    
    
    public void setEstado_tipo(int estado_tipo) {
        this.estado_tipo = estado_tipo;
    }
   
    
    
    
    
    
    
    public static ArrayList <TipoProducto> listarTodos () throws SQLException{
    ArrayList <TipoProducto> listaTipos = new ArrayList<>();
    Conexion conexion = new Conexion();
    Connection conn = null;
    
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR BASE DE DATOS SQL");
        }
    
        
        
        try {
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM TipoProducto ";
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        ResultSet resultado = statement.executeQuery();
        
        
            while (resultado.next()) { 
                
                TipoProducto tipoProducto = new TipoProducto();
                tipoProducto.setId_tipo(resultado.getInt("id_tipo"));
                tipoProducto.setTipoNombre(resultado.getString("tipoNombre"));
                tipoProducto.setEstado_tipo(resultado.getInt("estado_tipo"));
                listaTipos.add(tipoProducto);
                
            }
            
            
        } finally {
            
            conexion.cerrar();
        }
        
        return listaTipos;
    }
    
    
    
    
    
    
    
    
    
    public static boolean insertarTipo(String nombreTipo) throws SQLException {
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            throw new SQLException("No se puede conectar a la base de datos SQL");
        }
    
        try {
            conn = conexion.enlace;
            String consultaSQL = "INSERT INTO TipoProducto (tipoNombre) VALUES (?) ";
                   
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
             statement.setString(1, nombreTipo);
             
              int filas = statement.executeUpdate();
              return filas > 0;
            
        } finally {
            
               conexion.cerrar();
                
        }
    
       
       
    }
    
    
    
    
    
    
    
    
    public static boolean modificarTipo(String nombreActual, String nombreNuevo) throws SQLException{
        
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            
    throw new SQLException("Error en la Conexion con base de datos SQL");
            
        }
        
        try {
            conn = conexion.enlace;
            String consultaSQL = "UPDATE TipoProducto SET tipoNombre = ? " +
                    "WHERE tipoNombre = ? ";
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombreNuevo);
            statement.setString(2, nombreActual);
             int filas = statement.executeUpdate();
              return  filas >0;
            
        } finally {
            conexion.cerrar();
        }
    
    }
    
    
    public static boolean modificarTipoXID(int id_tipo, String nombreNuevo) throws SQLException{
        
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            
    throw new SQLException("Error en la Conexion con base de datos SQL");
            
        }
        
        try {
            conn = conexion.enlace;
            String consultaSQL = "UPDATE TipoProducto SET tipoNombre = ? " +
                    "WHERE id_tipo = ? ";
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombreNuevo);
            statement.setInt(2, id_tipo);
             int filas = statement.executeUpdate();
              return  filas >0;
            
        } finally {
            conexion.cerrar();
        }
    
    }
    
    
    public static boolean eliminarTipo(int id_tipo) throws SQLException{
        
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        
        if (!conexion.abrir()) {
            
    throw new SQLException("Error en la Conexion con base de datos SQL");
            
        }
        
        try {
            conn = conexion.enlace;
            String consultaSQL = "UPDATE TipoProducto SET estado_tipo = 0 " +
                    "WHERE id_tipo = ? ";
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
          
            statement.setInt(1, id_tipo);
             int filas = statement.executeUpdate();
              return  filas >0;
            
        } finally {
            conexion.cerrar();
        }
    
    }
    
    
    
    
    
    public static boolean verificarIngreso(String tipodeProductoIngresado){
        
        try {
            
             ArrayList <TipoProducto> listaTipos = TipoProducto.listarTodos();
             
             for (TipoProducto ObjetoTipoIndex : listaTipos) {
                 String nombreObjeto = ObjetoTipoIndex.getTipoNombre();
                 
                 if (tipodeProductoIngresado.equals(nombreObjeto)) {
                     return true;
                     
                 }
                
            }
                    
             
        } catch (Exception e) {
        }
        return false;
        
    }
    
}
    
    
    
    

