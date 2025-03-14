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
public class Producto {
    
    // OBJETO CON 8 ATRIBUTOS  EN MYSQL LAS TABLAS SON:
    // id_producto, nombreProducto, cantidad, valorCompra, marca, modeloCompatible
    
  int id_producto;
  String nombreProducto;
  String sku;
  String tipoProducto;
  String marcaRepuesto;
  String marcaVehiculo;
  String modelosCompatibles;
  int cantidadRecepcionada;
  int id_marca;
  int id_marcaRepuesto;
  int id_tipo;
  int producto_estado;
  int valor;
  int valorProducto;
  String Bodega;

    public Producto(int id_producto, String nombreProducto,String sku, String tipoProducto, String marcaRepuesto, String marcaVehiculo, String modelosCompatibles, int cantidadRecepcionada, int id_marca, int id_marcaRepuesto, int id_tipo,int producto_estado, int valor, int valorProducto) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.sku = sku;
        this.tipoProducto = tipoProducto;
        this.marcaRepuesto = marcaRepuesto;
        this.marcaVehiculo = marcaVehiculo;
        this.modelosCompatibles = modelosCompatibles;
        this.cantidadRecepcionada = cantidadRecepcionada;
        this.id_marca = id_marca;
        this.id_marcaRepuesto = id_marcaRepuesto;
        this.id_tipo = id_tipo;
        this.producto_estado = producto_estado;
        this.valor = valor;
        this.valorProducto = valorProducto;
        this.Bodega = Bodega;
        
    }

    public Producto() {
    }

    public String getSku() {
        return sku;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    
    public int getId_tipo() {
        return id_tipo;
    }

    public int getValor() {
        return valor;
    }

    
 
    public String getTipoProducto() {
        return tipoProducto;
    }


    public int getId_producto() {
        return id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarcaRepuesto() {
        return marcaRepuesto;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public String getModelosCompatibles() {
        return modelosCompatibles;
    }

    public int getCantidadRecepcionada() {
        return cantidadRecepcionada;
    }

    public int getId_marca() {
        return id_marca;
    }

    public int getId_marcaRepuesto() {
        return id_marcaRepuesto;
    }

    public int getProducto_estado() {
        return producto_estado;
    }

    public String getBodega() {
        return Bodega;
    }
    
    
    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    

    
    
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMarcaRepuesto(String marcaRepuesto) {
        this.marcaRepuesto = marcaRepuesto;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public void setModelosCompatibles(String modelosCompatibles) {
        this.modelosCompatibles = modelosCompatibles;
    }

    public void setCantidadRecepcionada(int cantidadRecepcionada) {
        this.cantidadRecepcionada = cantidadRecepcionada;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setId_marcaRepuesto(int id_marcaRepuesto) {
        this.id_marcaRepuesto = id_marcaRepuesto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setProducto_estado(int producto_estado) {
        this.producto_estado = producto_estado;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setBodega(String Bodega) {
        this.Bodega = Bodega;
    }
  
    
    
    
    
    
  
  
    
    
  public static ArrayList <Producto> buscarTodasMarcas() throws SQLException{
      
      Conexion conexion = new Conexion();
      Connection conn = null;
      
      
      if (!conexion.abrir()) {
          throw  new SQLException("No fue posible abrir la conexion SQL");
      }
      
      try {
                ArrayList <Producto> tablaProductos = new ArrayList<>();

          conn = conexion.enlace;
          String consultaSQL = "SELECT * FROM Producto ";
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          ResultSet resultado = statement.executeQuery();

          while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
              
          }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
      
  }
  
  
  
  
  
  
  public static boolean ingresoProducto(
          
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
  int valorProducto
  ) throws SQLException{
      
      
  Conexion conexion = new Conexion();
  Connection conn = null;
  
      if (!conexion.abrir()) {
          throw new SQLException("No se pudo abrir la conexion SQL");
      }
      
      
      try { 
          conn = conexion.enlace;
          String consultaSQL = "INSERT INTO Producto (nombreProducto, sku, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo, valor, valorProducto, Bodega ) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          statement.setString(1, nombreProducto);
          statement.setString(2, sku);
          statement.setString(3, tipoProducto);
          statement.setString(4, marcaRepuesto);
          statement.setString(5, marcaVehiculo);
          statement.setString(6, modelosCompatibles);
          statement.setInt(7, cantidadRecepcionada);
          statement.setInt(8, id_marca);
          statement.setInt(9, id_marcaRepuesto);
          statement.setInt(10, id_tipo);
          statement.setInt(11, valor);
          statement.setInt(12, valorProducto);
          statement.setString(13, Bodega);
          
          
           int filas = statement.executeUpdate();
              return filas > 0;
          
      } finally {
          
          conexion.cerrar();
      }
  
  }
  
  
  
  
public static int VerificacionAsignacion_idMarca(String marcaVehiculo) {
    try {
        ArrayList<Marca> tablaMarca = Marca.buscarTodasMarcas();
        for (Marca marca : tablaMarca) {
            if (marcaVehiculo.equals(marca.getNombreMarca())) {
                return marca.getId_marca();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra la marca
}





public static int VerificacionAsignacion_idMarcaRepuestos(String marcaRepuesto) {
    try {
        ArrayList<MarcaRepuesto> tablaMarcaRepuesto = MarcaRepuesto.buscarTodasMarcas();
        for (MarcaRepuesto marcaRepuesto1 : tablaMarcaRepuesto) {
            
            if (marcaRepuesto.equals(marcaRepuesto1.getNombreMarca())) {
                return marcaRepuesto1.getId_marca();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra la marca de repuesto
}





public static int VerificacionAsignacion_idTipo(String tipoRepuesto) {
    try {
        
        ArrayList<TipoProducto> tablaTipoProductos = TipoProducto.listarTodos();
        
        for (TipoProducto tipoProducto : tablaTipoProductos) {
            
            if (tipoRepuesto.equals(tipoProducto.getTipoNombre())) {
                return tipoProducto.getId_tipo();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra el tipo de repuesto
}
  


public static boolean modificarProducto (        
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
  int valorProducto,
  int id_producto
  ) throws SQLException{
    
    Conexion conexion = new Conexion();
      Connection conn = null;
      
      
      if (!conexion.abrir()) {
          throw  new SQLException("No fue posible abrir la conexion SQL");
      }
      
      try {
        
          conn = conexion.enlace;
          String consultaSQL = "UPDATE Producto SET nombreProducto = ?, sku = ?, tipoProducto = ?, marcaRepuesto = ?, marcaVehiculo = ?, modelosCompatibles = ?, cantidadRecepcionada = ?, id_marca = ?, id_marcaRepuesto = ?, id_tipo = ?, valor = ?, valorProducto = ?, Bodega = ? " +
                               "WHERE id_producto = ?";
          
          
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          statement.setString(1, nombreProducto);
          statement.setString(2, sku);
          statement.setString(3, tipoProducto);
          statement.setString(4, marcaRepuesto);
          statement.setString(5, marcaVehiculo);
          statement.setString(6, modelosCompatibles);
          statement.setInt(7, cantidadRecepcionada);
          statement.setInt(8, id_marca);
          statement.setInt(9, id_marcaRepuesto);
          statement.setInt(10, id_tipo);
          statement.setInt(11, valor);
          statement.setInt(12, valorProducto);
          statement.setString(13, Bodega);
          statement.setInt(14, id_producto);
          
          
           int filas = statement.executeUpdate();
              return  filas >0;
          
    } finally {
          
          conexion.cerrar();
    }
}





public static boolean modificarEstadoProducto(int nuevoEstado, int id_producto) throws SQLException {
    Conexion conexion = new Conexion();
    
    if (!conexion.abrir()) {
        throw new SQLException("No fue posible abrir la conexión SQL");
    }

    Connection conn = conexion.enlace;
    String consultaSQL = "UPDATE Producto SET producto_estado = ? WHERE id_producto = ?";

    try (PreparedStatement statement = conn.prepareStatement(consultaSQL)) {
        statement.setInt(1, nuevoEstado);
        statement.setInt(2, id_producto);
        
        int filas = statement.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        System.err.println("Error al modificar estado del producto: " + e.getMessage());
        return false;
    } finally {
        conexion.cerrar();
    }
}

/*NombreRepuesto
TipoRepuesto
MarcaRepuesto
MarcaVehiculo
IDproducto
CodigoSKU
*/

public static ArrayList<Producto> buscarXnombreRepuesto (String nombreProducto) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE nombreProducto = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, nombreProducto);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}




public static ArrayList<Producto> buscarXmarcaRepuesto (String marcaRepuesto) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE marcaRepuesto = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, marcaRepuesto);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}

public static ArrayList<Producto> buscarXbodega (String bodega) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE Bodega = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, bodega);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}





public static ArrayList<Producto> buscarXmarcaVehiculo (String marcaVehiculo) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE marcaVehiculo = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, marcaVehiculo);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}






public static ArrayList<Producto> buscarXid (int id_producto) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE id_producto = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setInt(1, id_producto);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}






public static ArrayList<Producto> buscarXsku (String sku) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE sku = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, sku);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}






public static ArrayList<Producto> buscarXtipo (String tipoProducto) throws SQLException{
    
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
            if (!conexion.abrir()) {
                throw new SQLException("No se pudo relizar conexion con base de datos SQL");
            }
            
            try {
                ArrayList<Producto> tablaProductos = new ArrayList<>();
                conn = conexion.enlace;
                String consultaSQL = "SELECT * FROM Producto WHERE tipoProducto = ? ";
                PreparedStatement statement = conn.prepareStatement(consultaSQL);
                statement.setString(1, tipoProducto);
                ResultSet resultado = statement.executeQuery();
                
   
                
              while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setSku(resultado.getString("sku"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              producto.setValor(resultado.getInt("valor"));
              producto.setValorProducto(resultado.getInt("valorProducto"));
              producto.setBodega(resultado.getString("Bodega"));
              
              tablaProductos.add(producto);
              
                 }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
}





public static boolean modificarCantidadProducto(int nuevaCantidad, int id_producto) throws SQLException {
    Conexion conexion = new Conexion();
    
    if (!conexion.abrir()) {
        throw new SQLException("No fue posible abrir la conexión SQL");
    }

    Connection conn = conexion.enlace;
    String consultaSQL = "UPDATE Producto SET cantidadRecepcionada = ? WHERE id_producto = ?";

    try (PreparedStatement statement = conn.prepareStatement(consultaSQL)) {
        statement.setInt(1, nuevaCantidad);
        statement.setInt(2, id_producto);
        
        int filas = statement.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        System.err.println("Error al modificar estado del producto: " + e.getMessage());
        return false;
    } finally {
        conexion.cerrar();
    }
}

}

