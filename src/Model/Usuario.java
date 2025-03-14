/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Conexion.Conexion;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class Usuario {
  
    
    int user_id;
    String usuarioNombre;
    String usuarioApellido;
    String usuarioRut;
    String contraseña;
    String usuario;
    int usr_visible;
    int usr_tipo;

    public Usuario() {
    }

    public Usuario(int user_id, String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int usr_visible, int usr_tipo) {
        this.user_id = user_id;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioRut = usuarioRut;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.usr_visible = usr_visible;
        this.usr_tipo = usr_tipo;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public String getUsuarioRut() {
        return usuarioRut;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getUsr_visible() {
        return usr_visible;
    }

    public int getUsr_tipo() {
        return usr_tipo;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public void setUsuarioRut(String usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setUsr_visible(int usr_visible) {
        this.usr_visible = usr_visible;
    }

    public void setUsr_tipo(int usr_tipo) {
        this.usr_tipo = usr_tipo;
    }
    
    
    
    
public static ArrayList<Usuario> todosUsuarios () throws SQLException{
   
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    Conexion conexion = new Conexion();
   Connection conn = null;
   
    if (!conexion.abrir()) {
        
        throw new SQLException("Problema en conexion de base de datos SQL");
    }
    
    
    try {
       
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM usuario ";
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        
        ResultSet resultado = statement.executeQuery();
        
        while (resultado.next()) {            
        
        Usuario usuario = new Usuario();
        usuario.setUser_id(resultado.getInt("user_id"));
        usuario.setUsuarioNombre(resultado.getString("usuarioNombre"));
        usuario.setUsuarioApellido(resultado.getString("usuarioApellido"));
        usuario.setUsuarioRut(resultado.getString("usuarioRut"));
        usuario.setContraseña(resultado.getString("contraseña"));
        usuario.setUsuario(resultado.getString("usuario"));
        usuario.setUsr_visible(resultado.getInt("usr_visible"));
        usuario.setUsr_tipo(resultado.getInt("usr_tipo"));
        
        
        listaUsuarios.add(usuario);
        }
    
        
    } finally {
        conexion.cerrar();
    }
        return listaUsuarios;
}
    
 


public boolean verificacion(String usuario, String password) throws SQLException {
    ArrayList<Usuario> lista = Usuario.todosUsuarios();

    for (Usuario usuarios : lista) {
        String usuarioBloc = usuarios.getUsuario();
        String contraseñaBloc = usuarios.getContraseña();
        int usrActivo = usuarios.getUsr_visible();

        if (usuario.equals(usuarioBloc) && password.equals(contraseñaBloc)&&usrActivo == 1) {
            return true; // Si encuentra coincidencia, retorna true inmediatamente
        }
    }

    return false; // Si no encontró coincidencia después de recorrer toda la lista
}




public static boolean verificacionAdmin(String usuario) throws SQLException {
    ArrayList<Usuario> lista = Usuario.todosUsuarios();

    for (Usuario usuarios : lista) {
        String usuarioBloc = usuarios.getUsuario();
        //String contraseñaBloc = usuarios.getContraseña();
        int tipo = usuarios.getUsr_tipo();

        if (usuario.equals(usuarioBloc)&&tipo == 1) {
            return true; // Si encuentra coincidencia, retorna true inmediatamente
        }
    }

    return false; // Si no encontró coincidencia después de recorrer toda la lista
}




public static boolean verificacionDuplicado(String usuario, String rut) throws SQLException {
    ArrayList<Usuario> lista = Usuario.todosUsuarios();

    for (Usuario usuarios : lista) {
        String usuarioUnico = usuarios.getUsuario();
        String rutUnico = usuarios.getUsuarioRut();
        

        if (!usuario.equals(usuarioUnico) || !rut.equals(rutUnico)) {
            return true; // Si encuentra coincidencia, retorna true inmediatamente
        }
    }

    return false; // Si no encontró coincidencia después de recorrer toda la lista
}




public static boolean insertarUsuario (String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int usr_visible, int usr_tipo) throws SQLException{

    Conexion conexion = new Conexion();
    Connection conn = null;
    
    if (!conexion.abrir()) {
        
        throw new SQLException("No es posible realizar conexion con base de datos");
    }

    
    
    try {
        
          conn = conexion.enlace;
          String consultaSQL = "INSERT INTO usuario (usuarioNombre, usuarioApellido, usuarioRut, contraseña, usuario, usr_visible, usr_tipo )" +
                               "VALUES (?, ?, ?, ?, ?, ?, ?)";
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          statement.setString(1, usuarioNombre);
          statement.setString(2, usuarioApellido);
          statement.setString(3, usuarioRut);
          statement.setString(4, contraseña);
          statement.setString(5, usuario);
          statement.setInt(6, usr_visible);
          statement.setInt(7, usr_tipo);
          
          int filas = statement.executeUpdate();
          return filas > 0;
          
    } finally {
        
        conexion.cerrar();
    }
    
}
}      
    
        
        
        
    
  
