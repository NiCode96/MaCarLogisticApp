/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.MarcaRepuesto;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class MarcaRepuestoController {

    
    
    public MarcaRepuestoController() {
    }
    
    
    public boolean insertarMarca(String marca)throws SQLException{
        MarcaRepuesto insertarMarca = new MarcaRepuesto();
        insertarMarca.setNombreMarca(marca);
        
        try {
            MarcaRepuesto.insertarMarca(marca);
        } catch (Exception e) {
            throw new SQLException("Error con la conexion de Datos SQL");
        }
        return false;
        
    }
    
    
    
    public ArrayList<MarcaRepuesto> listaTodasMarcas()throws SQLException{
    
        ArrayList <MarcaRepuesto> listaMarcas = new ArrayList<>();
        
        try {
            
            listaMarcas = MarcaRepuesto.buscarTodasMarcas();
            return listaMarcas;
            
        } catch (Exception e) {
            throw new SQLException("Error con la conexion de Datos SQL");
        }
    
    }
    
    
    public MarcaRepuesto buscarIdMarca(String marcaSeleccionada){
        try {
            MarcaRepuesto.seleccionarMarcaEspecifica(marcaSeleccionada);
        } catch (Exception e) {
        }
        return null;
        
    }
    
    
    
    public boolean modificarMarca (String nombreActual, String nombreNuevo){
    
        try {
           return MarcaRepuesto.modificarMarca(nombreActual, nombreNuevo);
        } catch (Exception e) {
        }
        return false;
        
    }
    
    
        public boolean modificarMarcaXid (int id_marcaRepuesto, String nombreNuevo){
    
        try {
           return MarcaRepuesto.modificarMarcaXid(id_marcaRepuesto, nombreNuevo);
        } catch (Exception e) {
        }
        return false;
        
    }
}
