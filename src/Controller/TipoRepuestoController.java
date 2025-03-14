/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Marca;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Model.TipoProducto;


/**
 *
 * @author nicolas
 */
public class TipoRepuestoController {

    public TipoRepuestoController() {
    }
    
    
    
    public boolean ingresoTipoProducto(String tipoProductoString) throws SQLException{
        
      try {
            TipoProducto.insertarTipo(tipoProductoString);
        } catch (Exception e) {
            throw new SQLException("Error con la conexion de Datos SQL");
        }
        return false;
       
    }
    
    
    
    
    
    
    
     public ArrayList<TipoProducto> listaTodosTipos()throws SQLException{
    
         try {
                  ArrayList <TipoProducto> listaProductos = new ArrayList<>();
                  listaProductos = TipoProducto.listarTodos();
                  return listaProductos;
                  
         } catch (SQLException e) {
             throw new SQLException("Error con la conexion de Datos SQL");
         }
         }
    
      
     
     
     
     
     
     public boolean modificarTipoProducto(String nombreActual, String nombreNuevo) throws SQLException{
     
      
 
         try {
               TipoProducto.modificarTipo(nombreActual, nombreNuevo);
             
             
             
         } catch (SQLException e) {
            throw new SQLException("Error con la conexion de Datos SQL");
         }
        return false;
     
     }
        
     
          public boolean modificarTipoProductoXid(int id_tipo, String nombreNuevo) throws SQLException{
     
      
 
         try {
               TipoProducto.modificarTipoXID(id_tipo, nombreNuevo);
             
             
             
         } catch (SQLException e) {
            throw new SQLException("Error con la conexion de Datos SQL");
         }
        return false;
     
     }
       
    
}
