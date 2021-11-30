/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venta;
import java.util.List;
import Model.Ventaproducto;
/**
 *
 * @author PC7
 */
public interface VentaProductoDao {
    public void insertarVentaProducto(Ventaproducto ventaproducto);
    public void modificarVentaProducto(Ventaproducto ventaproducto);
    public void eliminarVentaProducto(Ventaproducto ventaproducto);
    public List<Ventaproducto> mostrarVentaProducto();
}
