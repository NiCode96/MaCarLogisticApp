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
public class VentaProducto extends Producto{
    int cantidadVendida;

    public VentaProducto(int id_producto, String nombreProducto, String sku, String tipoProducto, String marcaRepuesto, String marcaVehiculo, String modelosCompatibles, int cantidadRecepcionada, int id_marca, int id_marcaRepuesto, int id_tipo, int producto_estado, int valor, int valorProducto) {
        super(id_producto, nombreProducto, sku, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo, producto_estado, valor, valorProducto);
    }

    public VentaProducto() {
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public int getId_producto() {
        return id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getSku() {
        return sku;
    }

    public String getTipoProducto() {
        return tipoProducto;
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

    public int getId_tipo() {
        return id_tipo;
    }

    public int getProducto_estado() {
        return producto_estado;
    }

    public int getValor() {
        return valor;
    }

    public int getValorProducto() {
        return valorProducto;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
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

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setProducto_estado(int producto_estado) {
        this.producto_estado = producto_estado;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }
    
    
    
}
