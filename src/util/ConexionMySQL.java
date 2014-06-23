/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionMySQL{

    private String db = "estacionamientos"; //Nombre de la base de datos
    private String url = "jdbc:mysql://localhost/"+db; //direccion del servidor más el nombre de la BD
    private String user = "root"; //Nombre del administrador
    private String pass = "n8gx2dev"; //Contreseña del administrador

    public ConexionMySQL(){
        
    }

    public ConexionMySQL(String url, String db, String user, String pass){
        this.url = url;
        this.db = db;
        this.user = user;
        this.pass = pass;
    }    
    
    public Connection getConexion(){//Creacion del metodo Conectar
        Connection con = null;
        try{
            //Cargamos el Driver MySQL
            Class.forName("com.mysql.jdbc.Driver");
            //Creamos un enlace hacia la base de datos
            con = DriverManager.getConnection(this.url, this.user, this.pass);
        }        
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return con;  
    }    
}