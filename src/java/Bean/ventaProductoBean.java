/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.VentaProductoDao;
import DAO.VentaProductoDaoImplement;
import Model.Producto;
import Model.Venta;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.Ventaproducto;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author PC7
 */
@ManagedBean
@ViewScoped
public class ventaProductoBean {
    
    int idVenta, idProducto;

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
    
    Ventaproducto ventaProducto;
    List<Ventaproducto> ventaproductos;
    private Ventaproducto selectedventaproducto;

    public Ventaproducto getVentaProducto() {
        return ventaProducto;
    }

    public void setVentaProducto(Ventaproducto ventaproducto) {
        this.ventaProducto = ventaproducto;
    }

    public List<Ventaproducto> getVentaproductos() {
        VentaProductoDao dao = new VentaProductoDaoImplement();
        ventaproductos = dao.mostrarVentaProducto();
        return ventaproductos;
    }

    public void setVentaProducto(List<Ventaproducto> ventaproductos) {
        this.ventaproductos = ventaproductos;
    }
    
    /**
     * Creates a new instance of ventaProductoBean
     */
    public ventaProductoBean() {
        ventaProducto = new Ventaproducto();
    }
        
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        VentaProductoDao dao = new VentaProductoDaoImplement();
        Venta venta = new Venta();
        venta.setIdVenta(idVenta);
        ventaProducto.setVenta(venta);        
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        ventaProducto.setProducto(producto);        
        dao.insertarVentaProducto(ventaProducto);
        ventaProducto = new Ventaproducto();
        addMessage("Venta-producto agregada");
    }
    
    public void modificar(){
        VentaProductoDao dao = new VentaProductoDaoImplement();
        Venta venta = new Venta();
        venta.setIdVenta(idVenta);
        ventaProducto.setVenta(venta);
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        ventaProducto.setProducto(producto);
        dao.modificarVentaProducto(ventaProducto);
        ventaProducto = new Ventaproducto();
        addMessage("Venta-producto modificada");
    }
    
    public void eliminar(){
        VentaProductoDao dao = new VentaProductoDaoImplement();
        dao.eliminarVentaProducto(ventaProducto);
        ventaProducto = new Ventaproducto();
        addMessage("Venta-producto eliminada");
    }       
    
    public Ventaproducto getSelectedVentaproducto() {
        return selectedventaproducto;
    }
 
    public void setSelectedVentaproducto(Ventaproducto selectedVentaproducto) {
        this.selectedventaproducto = selectedVentaproducto;
    }
    
}
