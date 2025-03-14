/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
  
        model.addColumn("REPUESTO");
        model.addColumn("MARCA VEHICULO");
        model.addColumn("MODELO");
        model.addColumn("MARCA REPUESTO");
        model.addColumn("CANTIDAD");
 * @author nicolas
 */
public class ProductoImportacion {
    
    String repuesto;
    String marcaVehiculo;
    String Modelo;
    String marcaRepuesto;
    int cantidad;

    public ProductoImportacion(String repuesto, String marcaVehiculo, String Modelo, String marcaRepuesto, int cantidad) {
        this.repuesto = repuesto;
        this.marcaVehiculo = marcaVehiculo;
        this.Modelo = Modelo;
        this.marcaRepuesto = marcaRepuesto;
        this.cantidad = cantidad;
    }

    public ProductoImportacion() {
    }

    public String getRepuesto() {
        return repuesto;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getMarcaRepuesto() {
        return marcaRepuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setMarcaRepuesto(String marcaRepuesto) {
        this.marcaRepuesto = marcaRepuesto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
