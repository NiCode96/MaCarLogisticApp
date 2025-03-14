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

/**
 *
 * @author nicolas
 */
public class MarcaController {

    
    
    public MarcaController() {
    }
    
    
    public boolean insertarMarca(String marca)throws SQLException{
        Marca insertarMarca = new Marca();
        insertarMarca.setNombreMarca(marca);
        
        try {
            Marca.insertarMarca(marca);
        } catch (Exception e) {
            throw new SQLException("Error con la conexion de Datos SQL");
        }
        return false;
        
    }
    
    
    
    public ArrayList<Marca> listaTodasMarcas()throws SQLException{
    
        ArrayList <Marca> listaMarcas = new ArrayList<>();
        
        try {
            
            listaMarcas = Marca.buscarTodasMarcas();
            return listaMarcas;
            
        } catch (Exception e) {
            throw new SQLException("Error con la conexion de Datos SQL");
        }
    
    }
    
    
    public Marca buscarIdMarca(String marcaSeleccionada){
        try {
            Marca.seleccionarMarcaEspecifica(marcaSeleccionada);
        } catch (Exception e) {
        }
        return null;
        
    }
    
    
       public Marca buscarxIdMarca2(int marcaSeleccionada){
        try {
            Marca.seleccionarMarcaEspecificaID(marcaSeleccionada);
        } catch (Exception e) {
        }
        return null;
        
    }
    
    
    
    public boolean modificarMarca (String nombreActual, String nombreNuevo){
    
        try {
           return Marca.modificarMarca(nombreActual, nombreNuevo);
        } catch (Exception e) {
        }
        return false;
        
    }
    
    
        public boolean modificarMarcaXid (int id_marca, String nombreNuevo){
    
        try {
           return Marca.modificarMarcaXId(id_marca, nombreNuevo);
        } catch (Exception e) {
        }
        return false;
        
    }
}
