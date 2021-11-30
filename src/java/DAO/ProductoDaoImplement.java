/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Empleado;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Model.Producto;
/**
 *
 * @author PC7
 */
public class ProductoDaoImplement implements ProductoDao{
    public void insertarProducto(Producto producto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void modificarProducto(Producto producto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void eliminarProducto(Producto producto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Producto> mostrarProducto() {
        Session session = null;
        List<Producto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Producto");
            lista = (List<Producto>) query.list();
        } catch (HibernateException e) {
         System.out.println(e.getMessage());            
        }finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }
}
