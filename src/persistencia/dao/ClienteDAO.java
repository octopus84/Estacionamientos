/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.dao;

import Util.ConexionMySQL;
import persistencia.to.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author usuario_pc
 */
public class ClienteDAO  {
    
    private ConexionMySQL dBase;
    
    public ClienteDAO(){
        dBase = new ConexionMySQL();
    }
    
    
    public String agregarCliente(Cliente c) {
        
        String result = null;
        String sql = "INSERT INTO CLIENTE(rut,nombre,apellido,email,password) ";
        sql = sql + "VALUES(?,?,?,?,?)";
        
        try{
            Connection cn = dBase.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            
            st.setString(1, c.getRut());
            st.setString(2, c.getNombre());
            st.setString(3, c.getApellido());
            st.setString(4, c.getEmail());
            st.setString(5, c.getPassword());
            
            st.close();
            cn.close();
        }catch(SQLException e){
            result = e.getMessage();
            System.out.println("error: " + e.getMessage());
        }
        return result;
        
    }    
    
    public List<Cliente> listaClientes() {
        
        List<Cliente> lista = null;
        String sql = "select * from cliente";
        
        try{
        
            Connection cn = dBase.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            
            lista = new ArrayList<Cliente>();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setRut(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                lista.add(c);
            }
            st.close();
            cn.close();            
        }catch(SQLException e){
            System.out.println("error: " + e.getMessage());
        }
                
        return lista;
    }
    
    public Cliente getCliente(String id) {
        Cliente c = null;
        String sql = "select * from cliente where rut=?";
        
        try{
            Connection cn = dBase.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            c = new Cliente();
            
            if (rs.next()){
                c.setRut(rs.getString(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
            }
            st.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("error: " + e.getMessage());
        }        
        
        return c;
    }

    public String actualizarCliente(Cliente c) {
        String result = null;
        String sql = "update cliente set nombre=?, apellido=?, ameil=?, password=? ";
        sql = sql + "where rut=?";
        try{
            Connection cn = dBase.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellido());
            st.setString(3, c.getEmail());
            st.setString(4, c.getPassword());
            st.setString(5, c.getRut());
            st.executeUpdate();
            
            st.close();
            cn.close();
        }catch(SQLException e){
            result = e.getMessage();
            System.out.println("error: " + e.getMessage());
        }        
        
        return result;
    }    
    
    public String eliminarCliente(String id) {
        String result = null;
        String sql = "delete from cliente where rut=?";
        
        try{
            Connection cn = dBase.getConexion();
            PreparedStatement st = cn.prepareStatement(sql);
            
            st.setString(1, id);
            st.executeUpdate();
            
            st.close();
            cn.close();
        }catch(SQLException e){
            result = e.getMessage();
            System.out.println("error: " + e.getMessage());
        }        
        
        return result;
    }
   
}