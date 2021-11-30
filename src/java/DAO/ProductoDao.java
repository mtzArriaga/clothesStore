/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleado;
import java.util.List;
import Model.Producto;
/**
 *
 * @author PC7
 */
public interface ProductoDao {
    public void insertarProducto(Producto producto);
    public void modificarProducto(Producto producto);
    public void eliminarProducto(Producto producto);
    public List<Producto> mostrarProducto();
}
