/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio.bo;

import java.util.List;
import persistencia.dao.ClienteDAO;
import persistencia.to.Cliente;

/**
 *
 * @author usuario_pc
 */
public class ClienteBO {
    ClienteDAO clienteDAO;
    
    public void ClienteBO(){
        clienteDAO = new ClienteDAO();
    }
    public List<Cliente> lista(){
        return clienteDAO.listaClientes();
    }
    public String agregarCliente(Cliente cliente){
        return clienteDAO.agregarCliente(cliente);
    }
    public Cliente getCliente(String id){
        return clienteDAO.getCliente(id);
    }
    public String eliminarCliente(String id){
        return clienteDAO.eliminarCliente(id);
    }
    public String actualizarCliente(Cliente cliente){
        return clienteDAO.actualizarCliente(cliente);
    }    
}
