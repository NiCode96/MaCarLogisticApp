/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection enlace;
    private String jdbc;
    private String userMysql;
    private String passUserMysql;
    private String db;
    
    public Conexion()
    {
        this.db = "MaCarApp";
        this.jdbc = "jdbc:mysql://localhost:3308/" + this.db;
        this.userMysql = "root";
        this.passUserMysql = "";
    }
    
    public boolean abrir() throws SQLException
    {
        this.enlace = DriverManager.getConnection(this.jdbc, this.userMysql, this.passUserMysql);
        return this.enlace != null;
    }
    
    public boolean cerrar() throws SQLException
    {
        this.enlace.close();
        this.enlace = null;
        return this.enlace == null;
    }
}