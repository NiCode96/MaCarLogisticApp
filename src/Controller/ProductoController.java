/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Producto;

/**
 *
 * @author nicolas
 */
public class ProductoController {

    public ProductoController() {
    }
    
    
    public boolean insertarProducto (
  String nombreProducto,
  String sku,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  String Bodega,
  int cantidadRecepcionada,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo,
  int valor,
  int valorProducto){
    
        try {
            Producto.ingresoProducto(nombreProducto, sku, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, Bodega, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo, valor, valorProducto);
            return  true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    
   public boolean modificarProducto (  
  String nombreProducto,
  String sku,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  int cantidadRecepcionada,
  String Bodega,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo,
  int valor,
  int valorProducto,
  int id_producto){
        
        
        try {
            
            Producto.modificarProducto(nombreProducto, sku, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, Bodega, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo, valor, valorProducto, id_producto);
            
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
    
    
 public boolean modificarEstado(int nuevoeEstado, int id_producto) {
    try {
        return Producto.modificarEstadoProducto(nuevoeEstado, id_producto);
    } catch (Exception e) {
        System.err.println("Error en modificarEstado: " + e.getMessage());
        return false;
    }
}
}
