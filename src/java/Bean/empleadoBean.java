/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDao;
import DAO.ClienteDaoImplement;
import DAO.EmpleadoDao;
import DAO.EmpleadoDaoImplement;
import Model.Cliente;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import Model.Empleado;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author PC7
 */
@ManagedBean
@ViewScoped
public class empleadoBean {
    
    Empleado empleado;
    List<Empleado> empleados;
    private Empleado selectedEmpleado;
    
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getEmpleados() {
        EmpleadoDao dao = new EmpleadoDaoImplement();
        empleados = dao.mostrarEmpleado();
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Creates a new instance of empleadoBean
     */
    public empleadoBean() {
        empleado = new Empleado();
    }
    
    
    public void addMessage(String summary){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar(){
        EmpleadoDao dao = new EmpleadoDaoImplement();
        dao.insertarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Empleado agregado");
    }
    
    public void modificar(){
        EmpleadoDao dao = new EmpleadoDaoImplement();
        dao.modificarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Empleado modificado");
    }
    
    public void eliminar(){
        EmpleadoDao dao = new EmpleadoDaoImplement();
        dao.eliminarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Empleado eliminado");
    }       
    
    public Empleado getSelectedEmpleado() {
        return selectedEmpleado;
    }
 
    public void setSelectedEmpleado(Empleado selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
    }
    
}
