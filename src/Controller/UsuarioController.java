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
public class UsuarioController {

    public UsuarioController() {
    }
    
    
    
    public boolean insertarUsuario(String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int usr_visible, int usr_tipo) throws SQLException{
    
        try {
 
            Usuario.insertarUsuario(usuarioNombre, usuarioApellido, usuarioRut, contraseña, usuario, usr_visible, usr_tipo);
                    
        } catch (Exception e) {
        }
        return false;
    
    }
    
    
    
}
