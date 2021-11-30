/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import Model.Cliente;
/**
 *
 * @author PC7
 */
public interface ClienteDao {
    public void insertarCliente(Cliente ingeniero);
    public void modificarCliente(Cliente ingeniero);
    public void eliminarCliente(Cliente ingeniero);
    public List<Cliente> mostrarCliente();
}
