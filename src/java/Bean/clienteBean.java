/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDao;
import DAO.ClienteDaoImplement;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.Cliente;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author PC7
 */
@ManagedBean
@ViewScoped
public class clienteBean {

    Cliente cliente;
    List<Cliente> clientes;
    private Cliente selectedCliente;
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        ClienteDao dao = new ClienteDaoImplement();
        clientes = dao.mostrarCliente();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    public clienteBean() {
        cliente = new Cliente();
    }
    
     public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ClienteDao dao = new ClienteDaoImplement();
        dao.insertarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente agregado");
    }
    
    public void modificar(){
        ClienteDao dao = new ClienteDaoImplement();
        dao.modificarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente modificado");
    }
    
    public void eliminar(){
        ClienteDao dao = new ClienteDaoImplement();
        dao.eliminarCliente(cliente);
        cliente = new Cliente();
        addMessage("Cliente eliminado");
    }       
    
    public Cliente getSelectedCliente() {
        return selectedCliente;
    }
 
    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }    
}

