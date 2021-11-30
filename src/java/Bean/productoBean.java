/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ProductoDao;
import DAO.ProductoDaoImplement;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.Producto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author PC7
 */
@ManagedBean
@ViewScoped
public class productoBean {

     Producto producto;
    List<Producto> productos;
    private Producto selectedProducto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        ProductoDao dao = new ProductoDaoImplement();
        productos = dao.mostrarProducto();
        return productos;
    }

    public void setIngenieros(List<Producto> productos) {
        this.productos = productos;
    }
    
    /**
     * Creates a new instance of productoBean
     */
    public productoBean() {
        producto = new Producto();
    }
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.insertarProducto(producto);
        producto = new Producto();
        addMessage("Producto agregado");
    }
    
    public void modificar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.modificarProducto(producto);
        producto = new Producto();
        addMessage("Producto modificado");
    }
    
    public void eliminar(){
        ProductoDao dao = new ProductoDaoImplement();
        dao.eliminarProducto(producto);
        producto = new Producto();
        addMessage("Producto eliminado");
    }       
    
    public Producto getSelectedProducto() {
        return selectedProducto;
    }
 
    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto = selectedProducto;
    }
    
    
}
