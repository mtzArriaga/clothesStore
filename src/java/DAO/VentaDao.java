/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Producto;
import java.util.List;
import Model.Venta;

/**
 *
 * @author PC7
 */
public interface VentaDao {
     public void insertarVenta(Venta venta);
    public void modificarVenta(Venta venta);
    public void eliminarVenta(Venta venta);
    public List<Venta> mostrarVenta();
}
