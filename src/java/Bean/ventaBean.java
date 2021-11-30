/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.VentaDao;
import DAO.VentaDaoImplement;
import Model.Cliente;
import Model.Empleado;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.Venta;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author PC7
 */
@ManagedBean
@ViewScoped
public class ventaBean {
    
   private int id_Cliente, id_Empleado;

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

 
  
    
    
    Venta venta;
    List<Venta> ventas;
    private Venta selectedVenta;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getVentas() {
        VentaDao dao = new VentaDaoImplement();
        ventas = dao.mostrarVenta();
        return ventas;
    }

    public void setVenta(List<Venta> ventas) {
        this.ventas = ventas;
    }    

    /**
     * Creates a new instance of ventaBean
     */
    public ventaBean() {
        venta = new Venta();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){         
        
        VentaDao dao = new VentaDaoImplement();
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id_Empleado);
        venta.setEmpleado(empleado);        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id_Cliente);
        venta.setCliente(cliente);        
        dao.insertarVenta(venta);
        venta = new Venta();
        addMessage("Venta agregada");
        
        
//        VentaDao dao = new VentaDaoImplement();      
//        Empleado empleado = new Empleado();        
//        empleado.setIdEmpleado(id_Empleado);
//        venta.setEmpleado(empleado);
//        Cliente cliente = new Cliente();
//        cliente.setIdCliente(id_Cliente);
//        venta.setCliente(cliente);        
//        dao.insertarVenta(venta);
//        venta = new Venta();
//        addMessage("Venta agregada");
    }
    
    public void modificar(){
        
        VentaDao dao = new VentaDaoImplement();
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id_Empleado);
        venta.setEmpleado(empleado);        
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id_Cliente);
        venta.setCliente(cliente);        
        dao.modificarVenta(venta);
        venta = new Venta();
        addMessage("Venta agregada");
        
        
//        VentaDao dao = new VentaDaoImplement();
//        Empleado empleado = new Empleado();
//        empleado.setIdEmpleado(id_Empleado);
//        venta.setEmpleado(empleado);
//        Cliente cliente = new Cliente();
//        cliente.setIdCliente(id_Cliente);
//        venta.setCliente(cliente);
//        dao.modificarVenta(venta);
//        venta = new Venta();
//        addMessage("Venta modificada");
    }
    
    public void eliminar(){
        VentaDao dao = new VentaDaoImplement();
        dao.eliminarVenta(venta);
        venta = new Venta();
        addMessage("Venta eliminada");
    }       
    
    public Venta getSelectedVenta() {
        return selectedVenta;
    }
 
    public void setSelectedVemta(Venta selectedVenta) {
        this.selectedVenta = selectedVenta;
    }
    
    
}
