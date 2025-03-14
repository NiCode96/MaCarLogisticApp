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
public class MarcaRepuesto {
    
    // OBJETO CON 
    // id_marca, nombreMarca
    
    
    int id_marca;
    String nombreMarca;
    int estado_marcaRepuesto;

    public MarcaRepuesto() {
    }

    
    public MarcaRepuesto(int id_marca, String nombreMarca) {
        this.id_marca = id_marca;
        this.nombreMarca = nombreMarca;
        this.estado_marcaRepuesto = estado_marcaRepuesto;
    }

    public int getEstado_marcaRepuesto() {
        return estado_marcaRepuesto;
    }

    
    public int getId_marca() {
        return id_marca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public void setEstado_marcaRepuesto(int estado_marcaRepuesto) {
        this.estado_marcaRepuesto = estado_marcaRepuesto;
    }
    

    
    
    public static boolean insertarMarca(String marca) throws SQLException{
     
       Conexion conexion = new Conexion();
       Connection conn = null;
       
        if (!conexion.abrir()) {
            throw new SQLException("No se puede establecer conexion con la base de datos");
            
        }
        
        try {
                    conn = conexion.enlace;
        String consultaSQL = "INSERT INTO marcaRepuesto (nombreMarcaRepuesto) VALUES (?) ";
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        statement.setString(1, marca);
        
          int filas = statement.executeUpdate();
              return filas > 0;
              
        } finally {
            
            conexion.cerrar();
        }
        
        
        }
    
    
    
    
    
    public static ArrayList <MarcaRepuesto> buscarTodasMarcas() throws SQLException{
    ArrayList <MarcaRepuesto> listaMarcas = new ArrayList<>();
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
        if (!conexion.abrir()) {
            throw new SQLException("Error de conexion con base de datos SQL");
            
        }
        
       
        
        try {
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM marcaRepuesto ";
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        ResultSet resultado = statement.executeQuery();
        
        
        
            while (resultado.next()) {  
                
                MarcaRepuesto marcaIndexada = new MarcaRepuesto();
                marcaIndexada.setNombreMarca(resultado.getString("nombreMarcaRepuesto"));
                marcaIndexada.setId_marca(resultado.getInt("id_marcaRepuesto"));
                marcaIndexada.setEstado_marcaRepuesto(resultado.getInt("estado_marcaRepuesto"));
                
                listaMarcas.add(marcaIndexada);
                
                
            }
            
        } finally {
            
            conexion.cerrar();
        }
       return  listaMarcas;
        
        
        
    }
   
    
    
    
    
    public static MarcaRepuesto seleccionarMarcaEspecifica (String nombreMarcaRepuesto) throws SQLException{
    
      
        
        Conexion conexion = new Conexion();
        Connection conn = null ;
        
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE CONECTAR A BASE DE DATOS SQL");
            
        }
    
        
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM marcaRepuesto" + " WHERE nombreMarcaRepuesto = ? ";
        
        
        try {
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        statement.setString(1,nombreMarcaRepuesto);
        
        ResultSet resultado = statement.executeQuery();
        
            if (resultado.next()) {
                
                  MarcaRepuesto marcaBuscada = new MarcaRepuesto();
                  
                  marcaBuscada.setId_marca(resultado.getInt("id_marcaRepuesto"));
                  marcaBuscada.setNombreMarca(resultado.getString("nombreMarcaRepuesto"));
                  return marcaBuscada;} 
               
            } finally {
         
          conexion.cerrar();
   
        }
        return null;
    }
   
    
    
    public static boolean modificarMarca(String nombreActual, String nombreNuevo) throws SQLException{
    
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR CONEXION SQL");
                    
        }
        
        conn = conexion.enlace;
        String consultaSQL = "UPDATE marcaRepuesto SET nombreMarcaRepuesto = ? " +
                "WHERE nombreMarcaRepuesto = ?";
        
        try {
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombreNuevo);
            statement.setString(2, nombreActual);
            int filas = statement.executeUpdate();
              return  filas >0;
              
        } finally {
            conexion.cerrar();
            
        }
    }
    
    
        public static boolean modificarMarcaXid(int id_marcaRepuesto, String nombreNuevo) throws SQLException{
    
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR CONEXION SQL");
                    
        }
        
        conn = conexion.enlace;
        String consultaSQL = "UPDATE marcaRepuesto SET nombreMarcaRepuesto = ? " +
                "WHERE id_marcaRepuesto = ?";
        
        try {
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombreNuevo);
            statement.setInt(2, id_marcaRepuesto);
            int filas = statement.executeUpdate();
              return  filas >0;
              
        } finally {
            conexion.cerrar();
            
        }
    }
    

        public static boolean eliminarMarcaRepuesto(int id_marcaRepuesto) throws SQLException{
    
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR CONEXION SQL");
                    
        }
        
        conn = conexion.enlace;
        String consultaSQL = "UPDATE marcaRepuesto SET estado_marcaRepuesto = 0 " +
                "WHERE id_marcaRepuesto = ?";
        
        try {
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setInt(1, id_marcaRepuesto);
            
            int filas = statement.executeUpdate();
              return  filas >0;
              
        } finally {
            conexion.cerrar();
            
        }
    }
    
    
    public static boolean verificarDuplicidad (String nombreMarcaIngresado){
        
        try {
              ArrayList <MarcaRepuesto> tablaMarcas = MarcaRepuesto.buscarTodasMarcas();
              
              
              for (MarcaRepuesto objetoMarcaIndex : tablaMarcas) {
                String nombreMarcaVerificar = objetoMarcaIndex.getNombreMarca();
                
                  if (nombreMarcaIngresado.equals(nombreMarcaVerificar)) {
                      return true;
                  }
            }
              
              
              
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return false;
    
    }
}
