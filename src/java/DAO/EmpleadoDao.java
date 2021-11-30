/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import java.util.List;
import Model.Empleado;

/**
 *
 * @author PC7
 */
public interface EmpleadoDao {
    public void insertarEmpleado(Empleado empleado);
    public void modificarEmpleado(Empleado empleado);
    public void eliminarEmpleado(Empleado empleado);
    public List<Empleado> mostrarEmpleado();
}
